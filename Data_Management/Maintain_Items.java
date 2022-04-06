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
public class Maintain_Items {
    public ArrayList<Item> items = new ArrayList<>();

    /**
     * 
     * @param path
     * @throws Exception 
     */
    public void load(String path) throws Exception{
	CsvReader reader = new CsvReader(path); 
	reader.readHeaders();
		
	while(reader.readRecord()){ 
            Item item = new Item();
            item.setName(reader.get("Name"));
            item.setItemID(reader.get("Item ID"));
            item.setCategory(reader.get("Category"));
            item.setAisleNum(reader.get("Aisle Num"));
            item.setDescription(reader.get("Description"));
            item.setSize(reader.get("Size"));
            item.setPrice(reader.get("Price"));
            item.setItemOnSale(reader.get("Item On Sale"));
            item.setStoreNum(reader.get("Store Num"));
            items.add(item);
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
            csvOutput.write("Name");
            csvOutput.write("Item ID");
            csvOutput.write("Category");
            csvOutput.write("Aisle Num");
            csvOutput.write("Description");
            csvOutput.write("Size");
            csvOutput.write("Price");
            csvOutput.write("Item On Sale");
            csvOutput.write("Store Num");
            csvOutput.endRecord();

            // else assume that the file already has the correct header line
            // write out a few records
            for(Item u: items){
                csvOutput.write(u.getName()); 
                csvOutput.write(u.getItemID());
                csvOutput.write(u.getCategory());
                csvOutput.write(u.getAisleNum());
                csvOutput.write(u.getDescription()); 
                csvOutput.write(u.getSize()); 
                csvOutput.write(u.getPrice()); 
                csvOutput.write(u.getItemOnSale()); 
                csvOutput.write(u.getStoreNum()); //8
                csvOutput.endRecord();
            }
                csvOutput.close();
            }
            catch (IOException e) {}
    }
   
}
