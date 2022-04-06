/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package User_Interfaces;
import Data_Management.Maintain_Users;
import Smart_Shopper_System.Smart_Shoppers_System;
import Data_Management.User;
import java.awt.Color;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author patli
 */
public class Register_Form extends javax.swing.JFrame { 
    File dic = new File("C:\\SmartShoppersSystem");   //directory file path
    String loginPath = "C:\\SmartShoppersSystem\\logins.csv";
    File loginFile = new File(loginPath);
    Maintain_Users maintainUsers = new Maintain_Users();
    User newUser;
    
    private boolean checkUsername(String username) throws FileNotFoundException{
        Scanner fileScan = new Scanner(loginFile);
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
    
    private void addUser(String usr, String pswd, String userType,
            String firstName, String lastName, String street, String postalCode, 
            String city, String country) throws IOException, Exception{
        try {     
            boolean sameUsername = checkUsername(usr);
            
            if(sameUsername == false){
                maintainUsers.load(loginPath);
                
                newUser = new User(usr, pswd, userType, firstName, lastName, street, postalCode,
                city, country);
                
                maintainUsers.users.add(newUser);

                maintainUsers.update(loginPath); 

                JOptionPane.showMessageDialog(null, "Register Successful!", "Registered", 2);
            }
            else{
               JOptionPane.showMessageDialog(null, "Username taken. Try again.", "Error Message", 2);
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(notepad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean verifyFields(String userName, String password, String confirmPass, 
        String userType,String firstName, String lastName, 
        String street, String postalCode, String city, String country){
        
        if(userName.trim().equals("") || password.trim().equals("") 
                || confirmPass.trim().equals("") || userType.equals("None")
                || firstName.trim().equals("") || lastName.trim().equals("") 
                || street.trim().equals("")|| postalCode.trim().equals("")|| city.trim().equals("") || 
                country.trim().equals("")){
            JOptionPane.showMessageDialog(null, "One or more fields are empty", "Missing Fields", 2);
            return false;
        }
        
        
        //check if two passwords are equals
        else if(!password.equals(confirmPass)){
            JOptionPane.showMessageDialog(null, "Passwords do not match", "Confirm Passwords", 2);
            return false;
        }
        
        //if everything is okay
        else{
            return true;
        }
    }
    
    private void register() throws Exception {
       
        String username = jTextField_Username.getText();
        String password = String.valueOf(jPasswordField_Password.getPassword());
        String confirmPassword = String.valueOf(jPasswordField_ConfirmPass.getPassword());  
        String userType = "Customer";
        String firstName = jTextField_FirstName.getText();
        String lastName = jTextField_LastName.getText();
        String street = jTextField_Street.getText();
        String postalCode = jTextField_PostalCode.getText();
        String city = jTextField_City.getText();
        String country = jTextField_Country.getText();
        
        try {
            if(verifyFields(username, password, confirmPassword, userType, firstName, lastName
            ,street, postalCode, city, country) == true){
                //Need to switch to csv file
                addUser(username, password, userType, firstName, 
                        lastName, street, postalCode, city, country);
            }
        } catch (IOException ex) {}
    }
    
    /**
     * Creates new form Register_form
     */
    public Register_Form() {
        initComponents();
        
        //center the form
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField_Password = new javax.swing.JPasswordField();
        jButton_Back = new javax.swing.JButton();
        jTextField_Username = new javax.swing.JTextField();
        jButton_Register = new javax.swing.JButton();
        jButton_Reset = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField_ConfirmPass = new javax.swing.JPasswordField();
        jTextField_FirstName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_LastName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField_Street = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField_PostalCode = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField_Country = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField_City = new javax.swing.JTextField();
        loginLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setForeground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Username:");

        jLabel2.setText("Password:");

        jButton_Back.setBackground(new java.awt.Color(255, 0, 0));
        jButton_Back.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton_Back.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Back.setText("Back to Login");
        jButton_Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_BackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_BackMouseExited(evt);
            }
        });
        jButton_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BackActionPerformed(evt);
            }
        });

        jButton_Register.setBackground(new java.awt.Color(255, 0, 0));
        jButton_Register.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton_Register.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Register.setText("Register");
        jButton_Register.setMaximumSize(new java.awt.Dimension(100, 28));
        jButton_Register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_RegisterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_RegisterMouseExited(evt);
            }
        });
        jButton_Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegisterActionPerformed(evt);
            }
        });

        jButton_Reset.setBackground(new java.awt.Color(255, 0, 0));
        jButton_Reset.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton_Reset.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Reset.setText("Reset");
        jButton_Reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_ResetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_ResetMouseExited(evt);
            }
        });
        jButton_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ResetActionPerformed(evt);
            }
        });

        jLabel3.setText("Confirm Password:");

        jTextField_FirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_FirstNameActionPerformed(evt);
            }
        });

        jLabel6.setText("Last Name:");

        jTextField_LastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_LastNameActionPerformed(evt);
            }
        });

        jLabel7.setText("First Name:");

        jLabel8.setText("Street Name & #:");

        jLabel9.setText("Postal Code:");

        jTextField_PostalCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PostalCodeActionPerformed(evt);
            }
        });

        jLabel11.setText("Country:");

        jLabel12.setText("City:");

        jTextField_City.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_CityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(46, 46, 46)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField_FirstName)
                                            .addComponent(jTextField_LastName)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(14, 14, 14)
                                                .addComponent(jTextField_Street, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextField_Country, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel12))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField_City, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                            .addComponent(jTextField_PostalCode))))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_Username, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPasswordField_Password)
                                    .addComponent(jPasswordField_ConfirmPass))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton_Back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Register, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(299, 299, 299))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_LastName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)
                        .addComponent(jTextField_PostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField_Street, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_Country, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_City, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField_ConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Register, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 58, 500, 360));

        loginLabel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        loginLabel.setForeground(new java.awt.Color(255, 255, 255));
        loginLabel.setText("Register");
        jPanel2.add(loginLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_LastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_LastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_LastNameActionPerformed

    private void jTextField_FirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_FirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_FirstNameActionPerformed

    private void jButton_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ResetActionPerformed
        jPasswordField_Password.setText("");
        jPasswordField_ConfirmPass.setText("");
        jTextField_Username.setText("");
        jTextField_FirstName.setText("");
        jTextField_LastName.setText("");
        jTextField_Street.setText("");
        jTextField_PostalCode.setText("");
        jTextField_City.setText("");
        jTextField_Country.setText("");
    }//GEN-LAST:event_jButton_ResetActionPerformed

    private void jButton_ResetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ResetMouseExited
        // set jbutton background
        jButton_Reset.setBackground(new Color(255, 0, 0));
    }//GEN-LAST:event_jButton_ResetMouseExited

    private void jButton_ResetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ResetMouseEntered
        // set jbutton background
        jButton_Reset.setBackground(new Color(225, 100, 2));
    }//GEN-LAST:event_jButton_ResetMouseEntered

    private void jButton_RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegisterActionPerformed
        try {
            register();
        } catch (Exception ex) {
            Logger.getLogger(Register_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_RegisterActionPerformed

    private void jButton_RegisterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_RegisterMouseExited
        // set jbutton background
        jButton_Register.setBackground(new Color(255, 0, 0));
    }//GEN-LAST:event_jButton_RegisterMouseExited

    private void jButton_RegisterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_RegisterMouseEntered
        // set jbutton background
        jButton_Register.setBackground(new Color(225, 100, 2));
    }//GEN-LAST:event_jButton_RegisterMouseEntered

    private void jButton_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BackActionPerformed
        //calls the login form
        Smart_Shoppers_System login = new Smart_Shoppers_System();
        login.setVisible(true);
        login.pack();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton_BackActionPerformed

    private void jButton_BackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_BackMouseExited
        // set jbutton background
        jButton_Back.setBackground(new Color(255, 0, 0));
    }//GEN-LAST:event_jButton_BackMouseExited

    private void jButton_BackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_BackMouseEntered
        // set jbutton background
        jButton_Back.setBackground(new Color(225, 100, 2));
    }//GEN-LAST:event_jButton_BackMouseEntered

    private void jTextField_PostalCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PostalCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PostalCodeActionPerformed

    private void jTextField_CityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_CityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_CityActionPerformed

    
    
    //create a function to check if the entered username already exists in the database.
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Register_Form().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Back;
    private javax.swing.JButton jButton_Register;
    private javax.swing.JButton jButton_Reset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField_ConfirmPass;
    private javax.swing.JPasswordField jPasswordField_Password;
    private javax.swing.JTextField jTextField_City;
    private javax.swing.JTextField jTextField_Country;
    private javax.swing.JTextField jTextField_FirstName;
    private javax.swing.JTextField jTextField_LastName;
    private javax.swing.JTextField jTextField_PostalCode;
    private javax.swing.JTextField jTextField_Street;
    private javax.swing.JTextField jTextField_Username;
    private javax.swing.JLabel loginLabel;
    // End of variables declaration//GEN-END:variables
}
