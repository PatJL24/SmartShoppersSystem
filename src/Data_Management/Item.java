/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_Management;

/**
 *
 * @author patli
 */
public class Item {
    
    String storeNum;
    String name;
    String itemID;
    String category;
    String aisleNum;
    String description;
    String size;
    String price;
    String itemOnSale;
    
    public Item(String name, String itemID, String description, String size, String price, 
            String itemOnSale, String category, String aisleNum, String storeNum){
        super();
        this.name = name;
        this.itemID = itemID;
        this.category = category;
        this.aisleNum = aisleNum;
        this.description = description;
        this.size = size;
        this.price = price;
        this.itemOnSale = itemOnSale;
        this.storeNum = storeNum;
    }
    
    public Item(){
            super();
    }
    
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getItemID(){
        return itemID;
    }
    
    public void setItemID(String itemID){
        this.itemID = itemID;
    }
    
    public String getCategory(){
        return category;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    
    public String getAisleNum(){
        return aisleNum;
    }
    
    public void setAisleNum(String aisleNum){
        this.aisleNum = aisleNum;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public String getSize(){
        return size;
    }
    
    public void setSize(String size){
        this.size = size;
    }
    
    public String getPrice(){
        return price;
    }
    
    public void setPrice(String price){
        this.price = price;
    }
    
    public String getItemOnSale(){
        return itemOnSale;
    }
    
    public void setItemOnSale(String itemOnSale){
        this.itemOnSale = itemOnSale;
    }
    
    public String getStoreNum(){
        return storeNum;
    }
    
    public void setStoreNum(String storeNum){
        this.storeNum = storeNum;
    }
    
}
