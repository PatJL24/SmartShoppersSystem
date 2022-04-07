/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package User_Interfaces;

import Data_Management.Maintain_Users;
import Data_Management.User;
import java.awt.Color;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author patli
 */
public class Smart_Shoppers_System extends javax.swing.JFrame {
    
    String directoryPath = "C:\\SmartShoppersSystem\\database";
    File systemPath = new File(directoryPath);   //directory file path
    
    String loginPath = "C:\\SmartShoppersSystem\\database\\logins.csv";
    File loginFile = new File(loginPath);
    
    String storesPath = "C:\\SmartShoppersSystem\\database\\stores.csv";
    File storesFile = new File(storesPath);
    
    String itemsPath = "C:\\SmartShoppersSystem\\database\\items.csv";
    File itemsFile = new File(itemsPath);
    
    User currentUser;
    
    private boolean findUser(String userName, String password, String path) throws Exception{
        boolean found = false;
        Maintain_Users maintainLogin = new Maintain_Users();
        maintainLogin.load(path);
        
        for(User newUser: maintainLogin.users){
            if(newUser.getUsername().equals(userName) && newUser.getPassword().equals(password)){
                found = true;
                this.currentUser = newUser;
            }
        }
        
        return found;
    }
    
    // create folder in which record is save
    private void createFolder(File dic) {
        if (!dic.isDirectory()) {
            dic.mkdirs();
        }
    }
    
    private void createFile(){
        try {
            createFolder(this.systemPath);
            loginFile.createNewFile();
            storesFile.createNewFile();
            itemsFile.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Smart_Shoppers_System.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void addAdmin(){
        try {
            Maintain_Users maintainLogin = new Maintain_Users();
            maintainLogin.load(loginPath);
            
            User newUser = new User("admin", "password", "Administrator", "Patrick", "Li");
            
            if(maintainLogin.users.isEmpty()){
                maintainLogin.users.add(newUser);
            }
            
            maintainLogin.update(loginPath);
        } catch (Exception ex) {
            Logger.getLogger(Smart_Shoppers_System.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void login() throws Exception {
        String username = jTextField_Username.getText();

        String password = String.valueOf(jPasswordField_Password.getPassword());
        
        try {
            validLogin(username, password, loginPath);
        } catch (FileNotFoundException ex) {}
    }
    

    // login logic 
    private void validLogin(String usr, String pswd, String path) throws FileNotFoundException, Exception {
        //createFile();
        
        //Scanner fileScan = new Scanner(file);

        if(loginFile.length() < 1){
            addAdmin();
        }
        
        if(findUser(usr, pswd, path) && this.currentUser.getUserType().equals("Customer")){
            Customer_Form customer = new Customer_Form();
            customer.getUser(this.currentUser);
            customer.setVisible(true);
            customer.pack();
            customer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
        else if(findUser(usr, pswd, path) && this.currentUser.getUserType().equals("Administrator")){
            Admin_Form admin = new Admin_Form();
            admin.setVisible(true);
            admin.pack();
            admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();        
        }else if(findUser(usr, pswd, path) && this.currentUser.getUserType().equals("Manager")){
            StoreMangement_Form  store_Form = new StoreMangement_Form();
            store_Form.setVisible(true);
            store_Form.getManagerUsername(this.currentUser.getUsername());
            store_Form.getUserType("Manager");
            store_Form.pack();
            store_Form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        else{
             JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Login Error", 2);
        }
    }
    
    /**
     * Creates new form Login_Form
     */
    public Smart_Shoppers_System() {
        initComponents();
        
        
        createFile();
        
        //center the form
        this.setLocationRelativeTo(null);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField_Password = new javax.swing.JPasswordField();
        jButton_Login = new javax.swing.JButton();
        jTextField_Username = new javax.swing.JTextField();
        jButton_Register = new javax.swing.JButton();
        loginLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 84, 140));
        jPanel2.setForeground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Username:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 38, -1, -1));

        jLabel2.setText("Password:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 80, -1, -1));

        jPasswordField_Password.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel3.add(jPasswordField_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 80, 438, 44));

        jButton_Login.setBackground(new java.awt.Color(0, 84, 140));
        jButton_Login.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton_Login.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Login.setText("Login");
        jButton_Login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_LoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_LoginMouseExited(evt);
            }
        });
        jButton_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LoginActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 162, 61));

        jTextField_Username.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel3.add(jTextField_Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 22, 438, 46));

        jButton_Register.setBackground(new java.awt.Color(0, 84, 140));
        jButton_Register.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton_Register.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Register.setText("Register");
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
        jPanel3.add(jButton_Register, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 162, 61));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 73, 560, 240));

        loginLabel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        loginLabel.setForeground(new java.awt.Color(255, 255, 255));
        loginLabel.setText("Login");
        jPanel2.add(loginLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 9, -1, 310));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LoginActionPerformed
        try {
            login();
        } catch (Exception ex) {
            Logger.getLogger(Smart_Shoppers_System.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_LoginActionPerformed

    
    private void jButton_LoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_LoginMouseEntered
        // set jbutton background
        jButton_Login.setBackground(new Color(0, 101, 183));
        
    }//GEN-LAST:event_jButton_LoginMouseEntered

    private void jButton_LoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_LoginMouseExited
        // set jbutton background
        jButton_Login.setBackground(new Color(0, 84, 140));
    }//GEN-LAST:event_jButton_LoginMouseExited

    private void jButton_RegisterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_RegisterMouseEntered
        // set jbutton background
        jButton_Login.setBackground(new Color(0, 101, 183));
    }//GEN-LAST:event_jButton_RegisterMouseEntered

    private void jButton_RegisterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_RegisterMouseExited
        // set jbutton background
        jButton_Login.setBackground(new Color(0, 84, 140));
    }//GEN-LAST:event_jButton_RegisterMouseExited

    private void jButton_RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegisterActionPerformed
        // Calls the register form
        addAdmin();
        Register_Form register = new Register_Form();
        register.setVisible(true);
        register.pack();
        register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton_RegisterActionPerformed

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
            java.util.logging.Logger.getLogger(Smart_Shoppers_System.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Smart_Shoppers_System.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Smart_Shoppers_System.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Smart_Shoppers_System.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Smart_Shoppers_System().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Login;
    private javax.swing.JButton jButton_Register;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField_Password;
    private javax.swing.JTextField jTextField_Username;
    private javax.swing.JLabel loginLabel;
    // End of variables declaration//GEN-END:variables
}
