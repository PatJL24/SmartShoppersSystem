/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smart_Shopper_System;

/**
 *
 * @author patli
 */
import java.io.FileWriter;
import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.FileReader;
import java.io.IOException;

public class MaintainUser {
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
            user.setUsername(reader.get("name"));
            user.setPassword(reader.get("password"));
            user.setEmail(reader.get("email"));
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
            csvOutput.write("Email");
            csvOutput.write("User Type");
            csvOutput.endRecord();

            // else assume that the file already has the correct header line
            // write out a few records
            for(User u: users){
                csvOutput.write(u.getName());
                csvOutput.write(u.getPassword());
		csvOutput.write(u.getEmail());
		csvOutput.write(u.getUserType());
                csvOutput.endRecord();
            }
                csvOutput.close();
            }
            catch (IOException e) {}
    }
}