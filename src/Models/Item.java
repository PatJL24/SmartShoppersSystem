/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author patli
 */
public class Item {
    
    String storeID;
    String itemName;
    String itemID;
    String category;
    String aisleNum;
    String description;
    String size;
    String price;
    String itemOnSale;
    String itemAvailability;
    
    public Item(String itemName, String itemID, String description, String size, String price, 
            String itemAvailability, String itemOnSale, String category, String aisleNum, String storeID){
        super();
        this.itemName = itemName;
        this.itemID = itemID;
        this.category = category;
        this.aisleNum = aisleNum;
        this.description = description;
        this.size = size;
        this.price = price;
        this.itemOnSale = itemOnSale;
        this.storeID = storeID;
        this.itemAvailability = itemAvailability;
    }
    
    public Item(String itemName, String itemID, String itemDescription, String itemCategory, 
             String itemSize, String itemAisle, String itemPrice){
        super();
        this.itemName = itemName;
        this.itemID = itemID;
        this.category = itemCategory;
        this.aisleNum = itemAisle;
        this.description = itemDescription;
        this.size = itemSize;
        this.price = itemPrice;
    }
    
    public Item(){
            super();
    }
    
    public String getItemName(){
        return itemName;
    }
    
    public void setItemName(String name){
        this.itemName = name;
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
    
    public String getStoreID(){
        return storeID;
    }
    
    public void setStoreID(String storeNum){
        this.storeID = storeNum;
    }
    
    public String getItemAvailability(){
        return itemAvailability;
    }
    
    public void setItemAvailability(String itemAvailability){
        this.itemAvailability = itemAvailability;
    }
    
}
