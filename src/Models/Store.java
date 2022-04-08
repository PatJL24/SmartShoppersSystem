/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author patli
 */
public class Store {
    //8 Categories
    String totalItems;
    String openingHours;
    String closingHours;
    String address;
    String storeNum;
    String storeName;
    String manager;
    //ArrayList<Item> items = new ArrayList<>();
    String distanceFromUserAddress; //Using longitude and latitude of Store to find the distance from user.
    
    
    public Store(String storeName, String storeNum, String openingHours, String closingHours, String address,
            String manager, String distanceFromUserAddress, String totalItems){
        super();
        this.storeName = storeName;
        this.storeNum = storeNum;
        this.totalItems = totalItems;
        this.openingHours = openingHours;
        this.closingHours = closingHours;
        this.address = address;
        this.distanceFromUserAddress = distanceFromUserAddress;
        this.manager = manager;
    }
    
    public Store(String storeName, String storeNum, String openingHours, String closingHours, 
            String address, String manager, String distanceFromUserAddress){
        super();
        this.storeName = storeName;
        this.storeNum = storeNum;
        this.openingHours = openingHours;
        this.closingHours = closingHours;
        this.address = address;
        this.manager = manager;
        this.distanceFromUserAddress = distanceFromUserAddress;
        this.totalItems = "0";
    }
    
    public Store(){
        super();
    }
    
    public String getStoreName(){
        return storeName;
    }
    
    public void setStoreName(String storeName){
        this.storeName = storeName;
    }
    
    public String getStoreNum(){
        return storeNum;
    }
    
    public void setStoreNum(String storeNum){
        this.storeNum = storeNum;
    }
    
    public String getManager(){
        return manager;
    }
    
    public void setManager(String manager){
        this.manager = manager;
    }
    
    public String getTotalItems(){
        return totalItems;
    }
    
    public void setTotalItems(String itemsAvailability){
        this.totalItems = itemsAvailability;
    }
    
    public String getDistanceFromUserAddress(){
        return distanceFromUserAddress;
    }
    
    public void setDistanceFromUserAddress(String distanceFromUserAddress){
        this.distanceFromUserAddress = distanceFromUserAddress;
    }
    
    public String getOpeningHours(){
        return openingHours;
    }
    
    public void setOpeningHours(String openingHours){
        this.openingHours = openingHours;
    }
    
    public String getClosingHours(){
        return closingHours;
    }
    
    public void setClosingHours(String closingHours){
        this.closingHours = closingHours;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
}
