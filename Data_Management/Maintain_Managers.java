/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_Management;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author patli
 */
public class Maintain_Managers {
    public ArrayList<User> users = new ArrayList<>();

    /**
     * 
     * @param path
     * @throws Exception 
     */
    public void load(String path) throws Exception{
	CsvReader reader = new CsvReader(path); 
	reader.readHeaders();
		
	while(reader.readRecord()){ 
            User user = new User();
            //name,id,email,password
            user.setUsername(reader.get("Username"));
            user.setPassword(reader.get("Password"));
            user.setUserType(reader.get("UserType"));
            user.setFirstName(reader.get("First Name"));
            user.setLastName(reader.get("Last Name"));
            user.setStoreNum(reader.get("Store Num"));
            users.add(user);
	}
    }
    
    /**
     * 
     * @param path
     * @throws Exception 
     */
    public void update(String path) throws Exception{
	try {		
            CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
            
            //name,id,email,password
            csvOutput.write("Username");
            csvOutput.write("Password");
            csvOutput.write("UserType");
            csvOutput.write("First Name");
            csvOutput.write("Last Name");
            csvOutput.write("Store Num");
            csvOutput.endRecord();

            // else assume that the file already has the correct header line
            // write out a few records
            for(User u: users){
                csvOutput.write(u.getUsername()); //0
                csvOutput.write(u.getPassword()); //1
                csvOutput.write(u.getUserType()); //2
                csvOutput.write(u.getFirstName()); //3
                csvOutput.write(u.getLastName()); //4
                csvOutput.write(u.getStoreNum()); //5
                csvOutput.endRecord();
            }
                csvOutput.close();
            }
            catch (IOException e) {}
    }
}
