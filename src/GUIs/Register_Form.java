/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIs;
import DatabaseUploads.Maintain_Users;
import Models.User;
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
    File dic = new File("C:\\SmartShoppersSystem\\database");   //directory file path
    String loginPath = "C:\\SmartShoppersSystem\\database\\logins.csv";
    File loginFile = new File(loginPath);
    Maintain_Users maintainUsers = new Maintain_Users();
    User newUser;
    
    private boolean checkUsername(String usr) throws FileNotFoundException{
        Scanner fileScan = new Scanner(loginFile);
        boolean found = false; // added this variable
          while (fileScan.hasNextLine()) {
            String input = fileScan.nextLine();
            String[] userValues = input.split(",");
            String username = userValues[0];

           if (username.equals(usr)) {
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
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Username:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 146, -1, -1));

        jLabel2.setText("Password:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 182, -1, -1));
        jPanel3.add(jPasswordField_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 177, 376, 26));

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
        jPanel3.add(jButton_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 259, -1, 47));
        jPanel3.add(jTextField_Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 143, 376, -1));

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
        jPanel3.add(jButton_Register, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 259, 129, 47));

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
        jPanel3.add(jButton_Reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 259, 137, 47));

        jLabel3.setText("Confirm Password:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 220, -1, -1));
        jPanel3.add(jPasswordField_ConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 215, 376, 26));

        jTextField_FirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_FirstNameActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField_FirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 6, 358, 28));

        jLabel6.setText("Last Name:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 50, -1, -1));

        jTextField_LastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_LastNameActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField_LastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 46, 358, 24));

        jLabel7.setText("First Name:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 12, -1, -1));

        jLabel8.setText("Street Name & #:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 84, -1, -1));
        jPanel3.add(jTextField_Street, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 80, 126, 25));
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 61, -1, -1));

        jLabel9.setText("Postal Code:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 84, -1, -1));

        jTextField_PostalCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PostalCodeActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField_PostalCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 80, 142, 25));

        jLabel11.setText("Country:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 105, -1, -1));
        jPanel3.add(jTextField_Country, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 107, 126, 30));

        jLabel12.setText("City:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 105, -1, -1));

        jTextField_City.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_CityActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField_City, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 107, 142, 30));

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
