/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package User_Interfaces;

import Data_Management.Maintain_Managers;
import Data_Management.Maintain_Users;
import Data_Management.User;
import Smart_Shopper_System.Smart_Shoppers_System;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author patli
 */
public class Admin_Form extends javax.swing.JFrame {

    File dic = new File("C:\\SmartShoppersSystem");   //directory file path
    
    String loginPath = "C:\\SmartShoppersSystem\\logins.csv";
    File loginFile = new File(loginPath);
    
    String storesPath = "C:\\SmartShoppersSystem\\stores.csv";
    File storesFile = new File(storesPath);
    
    String itemsPath = "C:\\SmartShoppersSystem\\items.csv";
    File itemsFile = new File(itemsPath);
    
    String managersPath = "C:\\SmartShoppersSystem\\managers.csv";
    File managersFile = new File(managersPath);
    
    Maintain_Users maintainUsers = new Maintain_Users();
    Maintain_Managers maintainManagers = new Maintain_Managers();
    User newUser;
    
    
    private boolean checkValues(String username) throws FileNotFoundException{        
        Scanner fileManager = new Scanner(managersFile);
        
        boolean found = false; // added this variable
        
        while (fileManager.hasNextLine()) {
            String input = fileManager.nextLine();
            String[] userValues = input.split(",");
            String Username = userValues[0];
            if (Username.equals(username)) {
                found = true; // added this to set found
            } // removed the else statement
        }
        return found;
    }
    
    private void addUser(String usr, String pswd, String userType, String firstName, String lastName, String storeNum) throws IOException, Exception{
        try {     
            boolean validValues = checkValues(usr);
            
            if(validValues == false){
                
                newUser = new User(usr, pswd, userType, firstName, lastName, storeNum);
                
                //add user to login file.
                maintainUsers.load(loginPath);
                
                maintainUsers.users.add(newUser);

                maintainUsers.update(loginPath); 
                
                //add user to manager file.
                maintainManagers.load(managersPath);
                
                maintainManagers.users.add(newUser);
                
                maintainManagers.update(managersPath);

                JOptionPane.showMessageDialog(null, "Register Successful!", "Registered", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
               JOptionPane.showMessageDialog(null, "Username taken. Try again.", "Error Message", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(notepad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean verifyFields(String userName, String password,String firstName, String lastName, String storeNum){    
        if(userName.trim().equals("") || password.trim().equals("")
                || firstName.trim().equals("") || lastName.trim().equals("")){
            JOptionPane.showMessageDialog(null, "One or more fields are empty", "Missing Fields", 2);
            return false;
        }
        //if everything is okay
        else{
            return true;
        }
    }
    
    private void createManager() throws Exception {
        String username = jTextField_ManagerUsername.getText();
        String password = String.valueOf(jPasswordField_ManagerPassword.getPassword());  
        String userType = "Manager";
        String firstName = jTextField_FirstName.getText();
        String lastName = jTextField_LastName.getText();
        String storeNum = jTextField_StoreNum.getText();
        
        try {
            if(verifyFields(username, password, firstName, lastName, storeNum) == true){
                //Need to switch to csv file
                addUser(username, password, userType, firstName, lastName, storeNum);
            }
        } catch (IOException ex) {}
    }
    
    /**
     * Creates new form AdminManager_Form
     */
    public Admin_Form() {
        initComponents();
        
        this.setAlwaysOnTop(false);
        
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_UpdateManagers = new javax.swing.JTable();
        customerLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        customerLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_StoresTable = new javax.swing.JTable();
        jButton_DeleteStore = new javax.swing.JButton();
        jButton_UpdateStore = new javax.swing.JButton();
        customerLabel8 = new javax.swing.JLabel();
        customerLabel9 = new javax.swing.JLabel();
        customerLabel10 = new javax.swing.JLabel();
        customerLabel12 = new javax.swing.JLabel();
        jButton_CreateManager = new javax.swing.JButton();
        jButton_DeleteManager = new javax.swing.JButton();
        jButton_UpdateManager = new javax.swing.JButton();
        jPasswordField_ManagerPassword = new javax.swing.JPasswordField();
        jTextField_LastName = new javax.swing.JTextField();
        jTextField_ManagerUsername = new javax.swing.JTextField();
        jTextField_StoreNum = new javax.swing.JTextField();
        customerLabel13 = new javax.swing.JLabel();
        customerLabel11 = new javax.swing.JLabel();
        customerLabel15 = new javax.swing.JLabel();
        jTextField_FirstName = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        customerLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        customerLabel3 = new javax.swing.JLabel();
        customerLabel4 = new javax.swing.JLabel();
        customerLabel5 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jComboBox_OpeningHours = new javax.swing.JComboBox<>();
        jComboBox_ClosingHours = new javax.swing.JComboBox<>();
        jSeparator5 = new javax.swing.JSeparator();
        customerLabel6 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jTextField_StoreName = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_ViewManagers = new javax.swing.JTable();
        customerLabel7 = new javax.swing.JLabel();
        jTextField_CreateStoreManager = new javax.swing.JTextField();
        jButton_CreateStore = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        customerLabel14 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jTextField_StoreAddress1 = new javax.swing.JTextField();
        jButton_Logout = new javax.swing.JButton();
        jButton_UpdateTables = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_UpdateManagers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Username", "Password", "First Name", "Last Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_UpdateManagers);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 480, 140));

        customerLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        customerLabel.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel.setText("Last Name:");
        jPanel2.add(customerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 340, 10));

        customerLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        customerLabel1.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel1.setText("Store Management");
        jPanel2.add(customerLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 350, 10));

        jTable_StoresTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Store #", "Store Name", "Managers", "Opening", "Closing", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable_StoresTable);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 490, 140));

        jButton_DeleteStore.setText("Delete Store");
        jButton_DeleteStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteStoreActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_DeleteStore, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 110, 40));

        jButton_UpdateStore.setText("Update Store");
        jButton_UpdateStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateStoreActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_UpdateStore, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 110, 40));

        customerLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        customerLabel8.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel8.setText("Managers:");
        jPanel2.add(customerLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        customerLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        customerLabel9.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel9.setText("Click on Table To:");
        jPanel2.add(customerLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 20));

        customerLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        customerLabel10.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel10.setText("Password:");
        jPanel2.add(customerLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, -1, 20));

        customerLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        customerLabel12.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel12.setText("Store # (Optional):");
        jPanel2.add(customerLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        jButton_CreateManager.setText("Add Manager");
        jButton_CreateManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CreateManagerActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_CreateManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, 120, 40));

        jButton_DeleteManager.setText("Delete");
        jButton_DeleteManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteManagerActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_DeleteManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 530, 80, 30));

        jButton_UpdateManager.setText("Update");
        jButton_UpdateManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateManagerActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_UpdateManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 530, 80, 30));
        jPanel2.add(jPasswordField_ManagerPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, 100, 30));
        jPanel2.add(jTextField_LastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, 100, 30));
        jPanel2.add(jTextField_ManagerUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 100, 30));
        jPanel2.add(jTextField_StoreNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 100, 30));

        customerLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        customerLabel13.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel13.setText("Username:");
        jPanel2.add(customerLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        customerLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        customerLabel11.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel11.setText("Click on Table To:");
        jPanel2.add(customerLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 500, -1, 20));

        customerLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        customerLabel15.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel15.setText("First Name:");
        jPanel2.add(customerLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, -1));
        jPanel2.add(jTextField_FirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 100, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 570));

        jPanel3.setBackground(new java.awt.Color(204, 0, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        customerLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        customerLabel2.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel2.setText("Closing:");
        jPanel3.add(customerLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 280, 10));

        customerLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        customerLabel3.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel3.setText("Store Creation:");
        jPanel3.add(customerLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));

        customerLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        customerLabel4.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel4.setText("Manager Username:");
        jPanel3.add(customerLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, -1, 20));

        customerLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        customerLabel5.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel5.setText("Store Name:");
        jPanel3.add(customerLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, -1));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 280, 10));

        jComboBox_OpeningHours.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" }));
        jComboBox_OpeningHours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_OpeningHoursActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox_OpeningHours, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        jComboBox_ClosingHours.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" }));
        jComboBox_ClosingHours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_ClosingHoursActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox_ClosingHours, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));
        jPanel3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, -1, -1));

        customerLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        customerLabel6.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel6.setText("Information:");
        jPanel3.add(customerLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));
        jPanel3.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 280, 10));

        jTextField_StoreName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_StoreNameActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField_StoreName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 140, 30));

        jTable_ViewManagers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Manager #", "First Name", "Manager #"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable_ViewManagers);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 300, 140));

        customerLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        customerLabel7.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel7.setText("Address:");
        jPanel3.add(customerLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));
        jPanel3.add(jTextField_CreateStoreManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 270, -1));

        jButton_CreateStore.setText("Add Store");
        jButton_CreateStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CreateStoreActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_CreateStore, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 120, 30));
        jPanel3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 90, 10));

        customerLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        customerLabel14.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel14.setText("Open:");
        jPanel3.add(customerLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        jPanel3.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 90, 10));

        jTextField_StoreAddress1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_StoreAddress1ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField_StoreAddress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 140, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 320, 510));

        jButton_Logout.setBackground(new java.awt.Color(204, 0, 204));
        jButton_Logout.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton_Logout.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Logout.setText("Logout");
        jButton_Logout.setMaximumSize(new java.awt.Dimension(100, 28));
        jButton_Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_LogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_LogoutMouseExited(evt);
            }
        });
        jButton_Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LogoutActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 100, 40));

        jButton_UpdateTables.setBackground(new java.awt.Color(204, 0, 204));
        jButton_UpdateTables.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton_UpdateTables.setForeground(new java.awt.Color(255, 255, 255));
        jButton_UpdateTables.setText("Update Tables");
        jButton_UpdateTables.setMaximumSize(new java.awt.Dimension(100, 28));
        jButton_UpdateTables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_UpdateTablesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_UpdateTablesMouseExited(evt);
            }
        });
        jButton_UpdateTables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateTablesActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_UpdateTables, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 150, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_OpeningHoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_OpeningHoursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_OpeningHoursActionPerformed

    private void jTextField_StoreNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_StoreNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_StoreNameActionPerformed
    
    
    
    private void createStore(){
        //Need to create store object and update it to the store file
        //Need to create Manage object and update it to login file
    }
    
    private void jButton_CreateStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CreateStoreActionPerformed
       //Need to update both Login file and stores file by creating objects
       createStore();
       updateStoresTable();
       updateManagerTables();
    }//GEN-LAST:event_jButton_CreateStoreActionPerformed

    private void jButton_DeleteStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteStoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_DeleteStoreActionPerformed

    private void jButton_UpdateStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateStoreActionPerformed
        updateStoresTable();
    }//GEN-LAST:event_jButton_UpdateStoreActionPerformed

    private void jButton_CreateManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CreateManagerActionPerformed
        try {
            createManager();
            //Need to update execl file first
        } catch (Exception ex) {
            Logger.getLogger(Admin_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //updateManagerTables();
    }//GEN-LAST:event_jButton_CreateManagerActionPerformed

    private void jButton_DeleteManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteManagerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_DeleteManagerActionPerformed

    private void jButton_UpdateManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateManagerActionPerformed
        //Need to Update the values of excel files first
        updateManagerTables();
    }//GEN-LAST:event_jButton_UpdateManagerActionPerformed

    private void jComboBox_ClosingHoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_ClosingHoursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_ClosingHoursActionPerformed

    private void jTextField_StoreAddress1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_StoreAddress1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_StoreAddress1ActionPerformed

    private void jButton_LogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_LogoutMouseEntered
        // set jbutton background
        jButton_Logout.setBackground(new Color(255, 102, 255));
    }//GEN-LAST:event_jButton_LogoutMouseEntered

    private void jButton_LogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_LogoutMouseExited
        // set jbutton background
        jButton_Logout.setBackground(new Color(204, 0, 204));
    }//GEN-LAST:event_jButton_LogoutMouseExited

    private void jButton_LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LogoutActionPerformed
        Smart_Shoppers_System login = new Smart_Shoppers_System();
        login.setVisible(true);
        login.pack();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton_LogoutActionPerformed

    private void jButton_UpdateTablesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_UpdateTablesMouseEntered
         // set jbutton background
        jButton_Logout.setBackground(new Color(255, 102, 255));
    }//GEN-LAST:event_jButton_UpdateTablesMouseEntered

    private void jButton_UpdateTablesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_UpdateTablesMouseExited
        // set jbutton background
        jButton_Logout.setBackground(new Color(204, 0, 204));
    }//GEN-LAST:event_jButton_UpdateTablesMouseExited

    private void jButton_UpdateTablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateTablesActionPerformed
       updateStoresTable();
       updateManagerTables();
    }//GEN-LAST:event_jButton_UpdateTablesActionPerformed
    
    private void updateStoresTable(){
        FileReader fileStores;
        try {
            fileStores = new FileReader(storesFile);
            BufferedReader store = new BufferedReader(fileStores);
            DefaultTableModel storesModel = (DefaultTableModel) jTable_StoresTable.getModel();
            Object[] lines = store.lines().toArray();
            
            for (Object line : lines) {
                String[] row = line.toString().split(",");
                storesModel.addRow(row);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void updateManagerTables(){
        FileReader fileManagers;
        try {
            
            fileManagers = new FileReader(managersFile);
            
            BufferedReader file = new BufferedReader(fileManagers);
            
            DefaultTableModel updateManagerTable = (DefaultTableModel) jTable_UpdateManagers.getModel();
            DefaultTableModel viewManagerTable = (DefaultTableModel) jTable_ViewManagers.getModel();
            
            
            Object[] lines = file.lines().toArray();
            
            for (int i = 1; i < lines.length; i++) {
                
                String[] row = lines[i].toString().split(",");
                
                if(row[8].equals("Manager")){
                    updateManagerTable.addRow(row);
                    viewManagerTable.addRow(row);
                }
            }
        }catch (IOException ex) {
            Logger.getLogger(Admin_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
            java.util.logging.Logger.getLogger(Admin_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Admin_Form().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel customerLabel;
    private javax.swing.JLabel customerLabel1;
    private javax.swing.JLabel customerLabel10;
    private javax.swing.JLabel customerLabel11;
    private javax.swing.JLabel customerLabel12;
    private javax.swing.JLabel customerLabel13;
    private javax.swing.JLabel customerLabel14;
    private javax.swing.JLabel customerLabel15;
    private javax.swing.JLabel customerLabel2;
    private javax.swing.JLabel customerLabel3;
    private javax.swing.JLabel customerLabel4;
    private javax.swing.JLabel customerLabel5;
    private javax.swing.JLabel customerLabel6;
    private javax.swing.JLabel customerLabel7;
    private javax.swing.JLabel customerLabel8;
    private javax.swing.JLabel customerLabel9;
    private javax.swing.JButton jButton_CreateManager;
    private javax.swing.JButton jButton_CreateStore;
    private javax.swing.JButton jButton_DeleteManager;
    private javax.swing.JButton jButton_DeleteStore;
    private javax.swing.JButton jButton_Logout;
    private javax.swing.JButton jButton_UpdateManager;
    private javax.swing.JButton jButton_UpdateStore;
    private javax.swing.JButton jButton_UpdateTables;
    private javax.swing.JComboBox<String> jComboBox_ClosingHours;
    private javax.swing.JComboBox<String> jComboBox_OpeningHours;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField_ManagerPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable jTable_StoresTable;
    private javax.swing.JTable jTable_UpdateManagers;
    private javax.swing.JTable jTable_ViewManagers;
    private javax.swing.JTextField jTextField_CreateStoreManager;
    private javax.swing.JTextField jTextField_FirstName;
    private javax.swing.JTextField jTextField_LastName;
    private javax.swing.JTextField jTextField_ManagerUsername;
    private javax.swing.JTextField jTextField_StoreAddress1;
    private javax.swing.JTextField jTextField_StoreName;
    private javax.swing.JTextField jTextField_StoreNum;
    // End of variables declaration//GEN-END:variables
}
