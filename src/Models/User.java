/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author patli
 */
public class User {
	public String username;
	public String password;
        public String usertype;
        public String firstName;
        public String lastName;
        public String street;
        public String postalCode;
        public String city;
        public String country;
 	
	public User(String username, String password, String usertype
        ,String firstName, String lastName,String street,
        String postalCode, String city, String country) {
            super();
            this.username = username;
            this.password = password;
            this.usertype = usertype;
            this.firstName = firstName;
            this.lastName = lastName;
            this.street = street;
            this.postalCode = postalCode;
            this.city = city;
            this.country = country;
	}
        
        public User(String username, String password, String userType, String firstName, String lastName){
            super();
            this.username = username;
            this.password = password;
            this.usertype = userType;
            this.firstName = firstName;
            this.lastName = lastName;
        }
	
	public User(){
            super();
        }

	public String getUsername() {
            return username;
	}

	public void setUsername(String usertype) {
            this.username = usertype;
	}

	public String getPassword() {
            return password;
	}

	public void setPassword(String password) {
            this.password = password;
	}
        
        public String getUserType(){
            return usertype;
        }
        
        public void setUserType(String usertype){
            this.usertype = usertype;
        }
        
        public String getFirstName(){
            return firstName;
        }
        
        public void setFirstName(String firstName){
            this.firstName = firstName;
        }
        
        public String getLastName(){
            return lastName;
        }
        
        public void setLastName(String lastName){
            this.lastName = lastName;
        }
        
        public String getStreet(){
            return street;
        }
        
        public void setStreet(String address){
            this.street = address;
        }
        
        public String getPostalCode(){
            return postalCode;
        }
        
        public void setPostalCode(String postalCode){
            this.postalCode = postalCode;
        }
        
        public String getCity(){
            return city;
        }
        
        public void setCity(String city){
            this.city = city;
        }
        
        public String getCountry(){
            return country;
        }
        
        public void setCountry(String country){
            this.country = country;
        }
}