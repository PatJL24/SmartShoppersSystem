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
public class Maintain_Stores {
    public ArrayList<Store> stores = new ArrayList<>();

    /**
     * 
     * @param path
     * @throws Exception 
     */
    public void load(String path) throws Exception{
	CsvReader reader = new CsvReader(path); 
	reader.readHeaders();
		
	while(reader.readRecord()){ 
            Store store = new Store();
            
            store.setStoreName(reader.get("Store Name"));
            store.setStoreNum(reader.get("Store Number"));
            store.setManager(reader.get("Manager"));
            store.setAddress(reader.get("Address"));
            store.setOpeningHours(reader.get("Opening Hours"));
            store.setClosingHours(reader.get("Closing Hours"));
            store.setTotalItems(reader.get("Total Items"));
            stores.add(store);
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
            csvOutput.write("Store Name");
            csvOutput.write("Store Number");
            csvOutput.write("Manager");
            csvOutput.write("Address");
            csvOutput.write("Opening Hours");
            csvOutput.write("Closing Hours");
            csvOutput.write("Total Items");
            csvOutput.endRecord();

            // else assume that the file already has the correct header line
            // write out a few records
            for(Store u: stores){
                csvOutput.write(u.getStoreName()); //0
                csvOutput.write(u.getStoreNum()); 
                csvOutput.write(u.getManager()); 
                csvOutput.write(u.getAddress()); 
                csvOutput.write(u.getOpeningHours()); 
                csvOutput.write(u.getClosingHours());  //6
                csvOutput.write(u.getTotalItems()); //7
                csvOutput.endRecord();
            }
                csvOutput.close();
            }
            catch (IOException e) {}
    }
}
