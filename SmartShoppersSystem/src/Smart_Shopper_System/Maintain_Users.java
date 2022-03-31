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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Maintain_Users {
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
            user.setFirstName(reader.get("First Name"));
            user.setLastName(reader.get("Last Name"));
            user.setStreet(reader.get("Street"));
            user.setPostalCode(reader.get("Postal Code"));
            user.setCity(reader.get("City"));
            user.setCountry(reader.get("Country"));
            user.setUserType(reader.get("User Type"));
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
            csvOutput.write("First Name");
            csvOutput.write("Last Name");
            csvOutput.write("Street");
            csvOutput.write("Postal Code");
            csvOutput.write("City");
            csvOutput.write("Country");
            csvOutput.write("User Type");
            csvOutput.endRecord();

            // else assume that the file already has the correct header line
            // write out a few records
            for(User u: users){
                csvOutput.write(u.getUsername()); //0
                csvOutput.write(u.getPassword()); //1
                csvOutput.write(u.getFirstName()); //2
                csvOutput.write(u.getLastName()); //3
                csvOutput.write(u.getStreet()); //4
                csvOutput.write(u.getPostalCode()); //5
                csvOutput.write(u.getCity()); //6
                csvOutput.write(u.getCountry()); //7
                csvOutput.write(u.getUserType()); //8
                csvOutput.endRecord();
            }
                csvOutput.close();
            }
            catch (IOException e) {}
    }
    
    public static boolean checkUsername(String username, File file) throws FileNotFoundException{
        Scanner fileScan = new Scanner(file);
        boolean found = false; // added this variable
          while (fileScan.hasNextLine()) {
            String input = fileScan.nextLine();
            String[] userValues = input.split(",");
            String Username = userValues[0];

           if (Username.equals(username)) {
                found = true; // added this to set found
            } // removed the else statement
        }
        return found;
    }
}