/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIs;

import DatabaseUploads.Maintain_Stores;
import DatabaseUploads.Maintain_Users;
import Models.Store;
import Models.User;

import java.awt.Color;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

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
    
    String directoryPath = "C:\\SmartShoppersSystem\\database";
    File systemPath = new File(directoryPath);   //directory file path
    
    String loginPath = "C:\\SmartShoppersSystem\\database\\logins.csv";
    File loginFile = new File(loginPath);
    
    String storesPath = "C:\\SmartShoppersSystem\\database\\stores.csv";
    File storesFile = new File(storesPath);
    
    String itemsPath = "C:\\SmartShoppersSystem\\database\\items.csv";
    File itemsFile = new File(itemsPath);
    
    String originalManagerName;
    String originalStoreID;
    String originalStoreName;

    User newUser;
    Store newStore;
    
    
    private boolean checkUsername(String username) throws FileNotFoundException{        
        Scanner fileManager = new Scanner(loginFile);
        
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
    
    private void addManager(String username, String password, String userType, String firstName, String lastName) throws IOException, Exception{
        try {     
            boolean validValues = checkUsername(username);
            
            if(validValues == false){
                
                newUser = new User(username, password, userType, firstName, lastName);
                Maintain_Users maintainUsers = new Maintain_Users();
                
                //add user to login file.
                maintainUsers.load(loginPath);
                
                maintainUsers.users.add(newUser);

                maintainUsers.update(loginPath); 
                
                JOptionPane.showMessageDialog(null, "Register Successful!", "Registered", JOptionPane.INFORMATION_MESSAGE);
                
                jTextField_ManagerUsername.setText("");
                jPasswordField_ManagerPassword.setText("");
                jTextField_FirstName.setText("");
                jTextField_LastName.setText("");
                jTextField_StoreNumber.setText("");
            }
            else{
               JOptionPane.showMessageDialog(null, "Username taken. Try again.", "Error Message", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(notepad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean verifyManagerFields(String userName, String password,String firstName, String lastName){    
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
        
        try {
            if(verifyManagerFields(username, password, firstName, lastName) == true){
                //Need added to excel file
                addManager(username, password, userType, firstName, lastName);
                updateManagerTable();
            }
        } catch (IOException ex) {}
    }
    
    private boolean checkStoreValues(String storeNum, String manager) throws FileNotFoundException{        
        Scanner fileStore = new Scanner(storesFile);
        Scanner fileManager = new Scanner(loginFile);
        boolean found = false; // added this variable
        
        if(storesFile.length() == 0 || storesFile.length() == 1){
            found = true;
        }else{
            while (fileStore.hasNextLine()) {
                found = false;

                String input = fileStore.nextLine();
                String[] storeValues = input.split(",");
                String numStore = storeValues[1];
                String storeManager = storeValues[2];
               
                
                if (!storeNum.equals(numStore) || !manager.equals(storeManager)) {

                    while(fileManager.hasNextLine()){

                        String inputM = fileManager.nextLine();
                        String[] loginValues = inputM.split(",");
                        String userName = loginValues[0];
                        String userType = loginValues[8];

                        if(userType.equals("Manager")){
                            if(userName.equals(manager)){
                                found = true;
                                break;
                               }
                            }
                        }
                    return found;
                    }
                }
        }
        return found;
    }
    
    private void addStore(String openingHours, String closingHours, String storeNumber, 
            String storeName, String address, String managerName) throws IOException, Exception{
        try {     
            boolean validValues = checkStoreValues(storeNumber, managerName);
            
            System.out.println(validValues);
            
            if(validValues){
                
                int distance = (int)(Math.random() * (1000) + 1);
                String distanceUser = String.valueOf(distance);
                
                newStore = new Store(storeName, storeNumber, openingHours, 
                closingHours, address, managerName, distanceUser);
                
                Maintain_Stores maintainStores = new Maintain_Stores();
                
                //add user to login file.
                maintainStores.load(storesPath);
                
                maintainStores.stores.add(newStore);

                maintainStores.update(storesPath); 
                
                JOptionPane.showMessageDialog(null, "Register Successful!", "Registered", JOptionPane.INFORMATION_MESSAGE);
                
                jComboBox_OpeningHours.setSelectedItem("None");
                jComboBox_ClosingHours.setSelectedItem("None");
                jTextField_StoreNumber.setText("");
                jTextField_StoreName.setText("");
                jTextField_StoreAddress.setText("");
                jTextField_StoreManager.setText("");
            }
            else{
               JOptionPane.showMessageDialog(null, "Error. Try again.", "Error Message", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(notepad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean verifyStoreFields(String openingHours, String closingHours, String storeNumber, 
        String storeName, String address, String managerName){
        
        if(openingHours.trim().equals("None") || closingHours.trim().equals("None")
                || storeNumber.trim().equals("") || storeName.trim().equals("") || managerName.trim().equals("") || 
                address.trim().equals("")){
           
            JOptionPane.showMessageDialog(null, "One or more fields are empty", "Missing Fields", 2);
            return false;
        }
        //if everything is okay
        else{
            return true;
        }
    }
    
    private void createStore(){
        //Need to create store object and update it to the store file
        //Need to create Manage object and update it to login file
        String openingHours = jComboBox_OpeningHours.getSelectedItem().toString();
        String closingHours = jComboBox_ClosingHours.getSelectedItem().toString();
        
        String storeNumber = jTextField_StoreNumber.getText();
        String storeName = jTextField_StoreName.getText();
        
        String storeAddress = jTextField_StoreAddress.getText();
        
        String managerName = jTextField_StoreManager.getText();
        
        if(verifyStoreFields(openingHours, closingHours, storeNumber, storeName, storeAddress, managerName) == true){
            try {
                //Need added to excel file
                addStore(openingHours, closingHours, storeNumber, storeName, storeAddress, managerName);
                updateStoreTable();
            } catch (Exception ex) {
                Logger.getLogger(Admin_Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Creates new form AdminManager_Form
     */
    public Admin_Form() {
        initComponents();
        
        this.setAlwaysOnTop(false);
        this.setLocationRelativeTo(null);
        
        updateManagerTable();
        updateStoreTable();
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
        jTable_ManagerTable = new javax.swing.JTable();
        customerLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        customerLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_StoresTable = new javax.swing.JTable();
        jButton_DeleteStore = new javax.swing.JButton();
        customerLabel8 = new javax.swing.JLabel();
        customerLabel9 = new javax.swing.JLabel();
        customerLabel10 = new javax.swing.JLabel();
        jButton_CreateManager = new javax.swing.JButton();
        jButton_DeleteManager = new javax.swing.JButton();
        jButton_UpdateManager = new javax.swing.JButton();
        jPasswordField_ManagerPassword = new javax.swing.JPasswordField();
        jTextField_LastName = new javax.swing.JTextField();
        jTextField_ManagerUsername = new javax.swing.JTextField();
        customerLabel13 = new javax.swing.JLabel();
        customerLabel11 = new javax.swing.JLabel();
        customerLabel15 = new javax.swing.JLabel();
        jTextField_FirstName = new javax.swing.JTextField();
        jButton_UpdateStoreInfo = new javax.swing.JButton();
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
        jTextField_StoreNumber = new javax.swing.JTextField();
        customerLabel7 = new javax.swing.JLabel();
        jTextField_StoreManager = new javax.swing.JTextField();
        jButton_CreateStore = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        customerLabel14 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jTextField_StoreAddress = new javax.swing.JTextField();
        customerLabel16 = new javax.swing.JLabel();
        jTextField_StoreName = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jButton_Logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_ManagerTable.setModel(new javax.swing.table.DefaultTableModel(
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
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_ManagerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ManagerTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_ManagerTable);

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
                "Store #", "Store ID", "Manager", "Opening", "Closing", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_StoresTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_StoresTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_StoresTable);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 480, 140));

        jButton_DeleteStore.setText("Delete Store");
        jButton_DeleteStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteStoreActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_DeleteStore, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 110, 50));

        customerLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        customerLabel8.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel8.setText("Managers:");
        jPanel2.add(customerLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        customerLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        customerLabel9.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel9.setText("Click on Table To:");
        jPanel2.add(customerLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, 20));

        customerLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        customerLabel10.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel10.setText("Password:");
        jPanel2.add(customerLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, -1, 20));

        jButton_CreateManager.setText("Add Manager");
        jButton_CreateManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CreateManagerActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_CreateManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, 120, 40));

        jButton_DeleteManager.setText("Delete");
        jButton_DeleteManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteManagerActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_DeleteManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 520, 90, 40));

        jButton_UpdateManager.setText("Update");
        jButton_UpdateManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateManagerActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_UpdateManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 520, 90, 40));
        jPanel2.add(jPasswordField_ManagerPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, 100, 30));
        jPanel2.add(jTextField_LastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, 100, 30));
        jPanel2.add(jTextField_ManagerUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 100, 30));

        customerLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        customerLabel13.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel13.setText("Username:");
        jPanel2.add(customerLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        customerLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        customerLabel11.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel11.setText("Click on Table To:");
        jPanel2.add(customerLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 500, -1, 20));

        customerLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        customerLabel15.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel15.setText("First Name:");
        jPanel2.add(customerLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, -1));
        jPanel2.add(jTextField_FirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 100, 30));

        jButton_UpdateStoreInfo.setText("Update Store Info");
        jButton_UpdateStoreInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateStoreInfoActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_UpdateStoreInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 130, 50));

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
        customerLabel3.setText("Store:");
        jPanel3.add(customerLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, -1));

        customerLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        customerLabel4.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel4.setText("Manager Username:");
        jPanel3.add(customerLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, -1, 20));

        customerLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        customerLabel5.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel5.setText("Store ID:");
        jPanel3.add(customerLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 280, 10));

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

        jTextField_StoreNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_StoreNumberActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField_StoreNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 120, 30));

        customerLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        customerLabel7.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel7.setText("Address:");
        jPanel3.add(customerLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, -1));
        jPanel3.add(jTextField_StoreManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 270, 30));

        jButton_CreateStore.setText("Add Store");
        jButton_CreateStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CreateStoreActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_CreateStore, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 110, 40));
        jPanel3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 90, 10));

        customerLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        customerLabel14.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel14.setText("Open:");
        jPanel3.add(customerLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        jPanel3.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 280, 10));

        jTextField_StoreAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_StoreAddressActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField_StoreAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 280, 30));

        customerLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        customerLabel16.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel16.setText("Store Name:");
        jPanel3.add(customerLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, -1));

        jTextField_StoreName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_StoreNameActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField_StoreName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 140, 30));
        jPanel3.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 90, 10));

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
        jPanel1.add(jButton_Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 100, 40));

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

    private void jTextField_StoreNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_StoreNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_StoreNumberActionPerformed

    
    private void jButton_CreateStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CreateStoreActionPerformed
       //Need to update both Login file and stores file by creating objects
       createStore();
    }//GEN-LAST:event_jButton_CreateStoreActionPerformed

    private void jButton_DeleteStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteStoreActionPerformed
        if(jTable_StoresTable.getSelectedRowCount() == 1){
            try {
                int input = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete the store?", "Deletion of Store",
                        JOptionPane.OK_CANCEL_OPTION, 2);
                
                Maintain_Stores maintainStore = new Maintain_Stores();
                maintainStore.load(storesPath);
                
                if (input == 0){
                    for(Store store: maintainStore.stores){
                        if(store.getStoreNum().equals(originalStoreID)){
                            maintainStore.stores.remove(store);
                            break;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Store Deleted", "Deleted", 2);
                    maintainStore.update(storesPath);
                    updateStoreTable();
                }
            } catch (Exception ex) {
                Logger.getLogger(Admin_Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            if(jTable_ManagerTable.getRowCount() == 0){
                 JOptionPane.showMessageDialog(null, "Table is Empty", "Empty Table", 2);
            }
            JOptionPane.showMessageDialog(null, "Select a Row to update.", "Updated", 2);
        }
    }//GEN-LAST:event_jButton_DeleteStoreActionPerformed

    private void jButton_CreateManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CreateManagerActionPerformed
        try {
            createManager();
            //Need to update execl file first
        } catch (Exception ex) {
            Logger.getLogger(Admin_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //updateManagerTables();
    }//GEN-LAST:event_jButton_CreateManagerActionPerformed

    private void deleteManager(){
        if(jTable_ManagerTable.getSelectedRowCount() == 1){
            try {
                int input = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete your account?", "Deletion of Account",
                        JOptionPane.OK_CANCEL_OPTION, 2);
                
                Maintain_Users maintainLogin = new Maintain_Users();
                maintainLogin.load(loginPath);
                
                Maintain_Stores maintainStore = new Maintain_Stores();
                maintainStore.load(storesPath);
                
                if (input == 0){
                    for(User user: maintainLogin.users){
                        if(user.getUsername().equals(originalManagerName) && user.getUserType().equals("Manager")){
                            maintainLogin.users.remove(user);
                            break;
                        }
                    }
                    
                    for(Store store: maintainStore.stores){
                        if(store.getManager().equals(originalManagerName)){
                                store.setManager("");
                                break;
                        }    
                    }        
                    JOptionPane.showMessageDialog(null, "Account Deleted", "Deleted", 2);
                    maintainLogin.update(loginPath);
                    maintainStore.update(storesPath);
                    
                    updateManagerTable();
                    updateStoreTable();
                }
            } catch (Exception ex) {
                Logger.getLogger(Admin_Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            if(jTable_ManagerTable.getRowCount() == 0){
                 JOptionPane.showMessageDialog(null, "Table is Empty", "Empty Table", 2);
            }
            JOptionPane.showMessageDialog(null, "Select a Row to update.", "Updated", 2);
        }
    }
    
    private void jButton_DeleteManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteManagerActionPerformed
        deleteManager();
    }//GEN-LAST:event_jButton_DeleteManagerActionPerformed

    private void updateManager(){
        //set data to textfield when selected
        
        if(jTable_ManagerTable.getSelectedRowCount() == 1){
            try {
                int input = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to update your account?", "Updating Account",
                        JOptionPane.OK_CANCEL_OPTION, 2);
                
                Maintain_Users maintainLogin = new Maintain_Users();
                maintainLogin.load(loginPath);
                
                if (input == 0){
                    for(User user: maintainLogin.users){
                        if(user.getUsername().equals(originalManagerName) && user.getUserType().equals("Manager")){
                            String newUsername = jTextField_ManagerUsername.getText();
                            String newPassword = String.valueOf(jPasswordField_ManagerPassword.getPassword());
                            String newFirstName = jTextField_FirstName.getText();
                            String newLastName = jTextField_LastName.getText();
                            user.setUsername(newUsername);
                            user.setPassword(newPassword);
                            user.setFirstName(newFirstName);
                            user.setLastName(newLastName);
                            break;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Account Updated", "Updated", 2);
                    maintainLogin.update(loginPath);
                }
                updateManagerTable();
            } catch (Exception ex) {
                Logger.getLogger(Admin_Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            if(jTable_ManagerTable.getRowCount() == 0){
                 JOptionPane.showMessageDialog(null, "Table is Empty", "Empty Table", 2);
            }
            JOptionPane.showMessageDialog(null, "Select a Row to update.", "Updated", 2);
        }
    }
    
    private void jButton_UpdateManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateManagerActionPerformed
       updateManager();
    }//GEN-LAST:event_jButton_UpdateManagerActionPerformed

    private void jComboBox_ClosingHoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_ClosingHoursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_ClosingHoursActionPerformed

    private void jTextField_StoreAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_StoreAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_StoreAddressActionPerformed

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

    private void jTextField_StoreNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_StoreNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_StoreNameActionPerformed

    private void jButton_UpdateStoreInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateStoreInfoActionPerformed
        if(jTable_StoresTable.getSelectedRowCount() == 1){
            StoreMangement_Form  store_Form = new StoreMangement_Form();
            store_Form.setVisible(true);
            store_Form.getStoreID(this.originalStoreID);
            store_Form.getStoreName(this.originalStoreName);
            store_Form.getUserType("Admin");
            store_Form.pack();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
        else{
             JOptionPane.showMessageDialog(null, "Select a Row to Edit the Store.", "Select a Store", 2);
        }
    }//GEN-LAST:event_jButton_UpdateStoreInfoActionPerformed

    private void jTable_ManagerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ManagerTableMouseClicked
        DefaultTableModel managerModel = (DefaultTableModel)jTable_ManagerTable.getModel();
        
        //set data to textfield when selected
        
        originalManagerName = managerModel.getValueAt(jTable_ManagerTable.getSelectedRow(), 0).toString();
        String password = managerModel.getValueAt(jTable_ManagerTable.getSelectedRow(), 1).toString();
        String firstName = managerModel.getValueAt(jTable_ManagerTable.getSelectedRow(), 2).toString();
        String lastName = managerModel.getValueAt(jTable_ManagerTable.getSelectedRow(), 3).toString();
        
        jTextField_ManagerUsername.setText(originalManagerName);
        jPasswordField_ManagerPassword.setText(password);
        jTextField_FirstName.setText(firstName);
        jTextField_LastName.setText(lastName);
        
    }//GEN-LAST:event_jTable_ManagerTableMouseClicked

    private void jTable_StoresTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_StoresTableMouseClicked
        DefaultTableModel storeModel = (DefaultTableModel)jTable_StoresTable.getModel();
        
        //set data to textfield when selected
        
        this.originalStoreName = storeModel.getValueAt(jTable_StoresTable.getSelectedRow(), 0).toString();
        this.originalStoreID = storeModel.getValueAt(jTable_StoresTable.getSelectedRow(), 1).toString();
        String managerName = storeModel.getValueAt(jTable_StoresTable.getSelectedRow(), 2).toString();
        String address = storeModel.getValueAt(jTable_StoresTable.getSelectedRow(), 3).toString();
        String opening = storeModel.getValueAt(jTable_StoresTable.getSelectedRow(), 4).toString();
        if(opening.equals("0:00")){
            opening = "00:00";
        }
        String closing = storeModel.getValueAt(jTable_StoresTable.getSelectedRow(), 5).toString();
        
        jTextField_StoreName.setText(this.originalStoreName);
        jTextField_StoreNumber.setText(this.originalStoreID);
        jTextField_StoreManager.setText(managerName);
        jTextField_StoreAddress.setText(address);
        jComboBox_OpeningHours.setSelectedItem(opening);
        jComboBox_ClosingHours.setSelectedItem(closing);
    }//GEN-LAST:event_jTable_StoresTableMouseClicked
    
    private void updateStoreTable(){   
        try {
            DefaultTableModel csvData = new DefaultTableModel();

            if(csvData.getColumnCount() == 0 && storesFile.length() == 0){
                csvData.addColumn("Store Name");
                csvData.addColumn("Store Number");
                csvData.addColumn("Manager");
                csvData.addColumn("Address");
                csvData.addColumn("Opening");
                csvData.addColumn("Closing");
            }else{
                Scanner fileScan = new Scanner(storesFile);
            
                int start = 0;

                while (fileScan.hasNextLine()) {
                    String input = fileScan.nextLine();
                    String[] userValues = input.split(",");
                    
                    String storeName = userValues[0];
                    String storeNum = userValues[1];
                    String manager = userValues[2];
                    String address = userValues[3];
                    String openingHours = userValues[4];
                    String closingHours = userValues[5];

                    if(start == 0){
                        start = 1;
                        csvData.addColumn("Store Name");
                        csvData.addColumn("Store Number");
                        csvData.addColumn("Manager");
                        csvData.addColumn("Address");
                        csvData.addColumn("Opening");
                        csvData.addColumn("Closing");
                    }
                    else{
                        Vector row = new Vector();
                        row.add(storeName);
                        row.add(storeNum);
                        row.add(manager);
                        row.add(address);
                        row.add(openingHours);
                        row.add(closingHours);
                        csvData.addRow(row);
                    }
                }
            }
            jTable_StoresTable.setModel(csvData);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void updateManagerTable(){
        try {            
            DefaultTableModel csvData = new DefaultTableModel();
            
            if(csvData.getColumnCount() == 0 && loginFile.length() <= 1){
                csvData.addColumn("Username");
                csvData.addColumn("Password");
                csvData.addColumn("First Name");
                csvData.addColumn("Last Name");
            }
            
            Scanner fileScan = new Scanner(loginFile);
            
            int start = 0;
            
            while (fileScan.hasNextLine()) {
                String input = fileScan.nextLine();
                String[] userValues = input.split(",");
                String username = userValues[0];
                String password = userValues[1];
                String firstName = userValues[2];
                String lastName = userValues[3];
                String userType = userValues[8];
                
                if(start == 0){
                    start = 1;
                    csvData.addColumn("Username");
                    csvData.addColumn("Password");
                    csvData.addColumn("First Name");
                    csvData.addColumn("Last Name");
                }
                else{
                    if(userType.equals("Manager")){
                        Vector row = new Vector();
                        row.add(username);
                        row.add(password);
                        row.add(firstName);
                        row.add(lastName);
                        csvData.addRow(row);
                    }
                }
            }
            jTable_ManagerTable.setModel(csvData);
        } catch (FileNotFoundException ex) {
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
    private javax.swing.JLabel customerLabel13;
    private javax.swing.JLabel customerLabel14;
    private javax.swing.JLabel customerLabel15;
    private javax.swing.JLabel customerLabel16;
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
    private javax.swing.JButton jButton_UpdateStoreInfo;
    private javax.swing.JComboBox<String> jComboBox_ClosingHours;
    private javax.swing.JComboBox<String> jComboBox_OpeningHours;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField_ManagerPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable_ManagerTable;
    private javax.swing.JTable jTable_StoresTable;
    private javax.swing.JTextField jTextField_FirstName;
    private javax.swing.JTextField jTextField_LastName;
    private javax.swing.JTextField jTextField_ManagerUsername;
    private javax.swing.JTextField jTextField_StoreAddress;
    private javax.swing.JTextField jTextField_StoreManager;
    private javax.swing.JTextField jTextField_StoreName;
    private javax.swing.JTextField jTextField_StoreNumber;
    // End of variables declaration//GEN-END:variables
}
