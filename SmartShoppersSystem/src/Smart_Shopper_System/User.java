/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smart_Shopper_System;

/**
 *
 * @author patli
 */
public class User {
	public String username;
	public String password;
        public String usertype;
        public String email;
	
	public User(String username, String password, String usertype, String email) {
            super();
            this.username = username;
            this.password = password;
            this.usertype = usertype;
            this.email = email;
	}
	
	public User(){
            super();
        }

	public String getName() {
            return username;
	}

	public void setUsername(String usertype) {
            this.username = usertype;
	}
	public String getEmail() {
            return email;
	}

	public void setEmail(String email) {
            this.email = email;
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
}