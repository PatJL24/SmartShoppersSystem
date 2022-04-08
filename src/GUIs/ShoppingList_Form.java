/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIs;

import Models.Item;
import Models.User;
import DatabaseUploads.Maintain_Items;
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
public class ShoppingList_Form extends javax.swing.JFrame {

    String storesPath = "C:\\SmartShoppersSystem\\database\\stores.csv";
    File storesFile = new File(storesPath);
    
    String itemsPath = "C:\\SmartShoppersSystem\\database\\items.csv";
    File itemsFile = new File(itemsPath);
    
    String databasePath = "C:\\SmartShoppersSystem\\database";
    File databaseFile = new File(databasePath);
    
    
    String originalStoreID;
    String originalStoreName;
    
    String userName;
    String password;
    String firstName;
    String lastName;
    String street;
    String Country;
    String city;
    String PostalCode;
    String userType = "Customer";
    
    String itemName;
    String itemID;
    String itemCategory;
    String itemAisle;
    String itemDescription;
    String itemSize;
    String itemPrice;
    String itemSale;
    String itemAvailability;
    
    String shoppingItemName;
    String shoppingItemID;
    String shoppingItemSize;
    String shoppingItemPrice;
    
    User currentUser;
    Item newItem;
   
    String userPath;
    String userShoppingListPath;
    
    File userShoppingList;
    File userFile;
    
    public void getInfo(User user, String storeID, String storeName){
        this.currentUser = user;
        this.userName = user.getUsername();
        CustomerNameLabel.setText("Customer Name: " + userName);
        this.password = user.getPassword();
        this.userType = user.getUserType();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.street = user.getStreet();
        this.Country = user.getCountry();
        this.city = user.getCity();
        this.PostalCode = user.getPostalCode();
        
        this.originalStoreID = storeID;
        this.originalStoreName = storeName;
        StoreNameLabel.setText("Store Name: " + this.originalStoreName);
        
        userPath = this.databasePath + "\\" + this.userName;
        userFile = new File(userPath);
        
        userShoppingListPath = this.databasePath + "\\" + this.userName + "\\" + this.originalStoreName + ".csv";
        userShoppingList = new File(userShoppingListPath);
    }
    
    // create folder in which record is save
    private void createFolder(File dic) {
        if (!dic.isDirectory()) {
            dic.mkdirs();
        }
    }
    
    private void createFile(){
        try {
            createFolder(this.databaseFile);
            createFolder(this.userFile);
            userShoppingList.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Smart_Shoppers_System.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Creates new form ShoppingList_Form
     */
    public ShoppingList_Form() {
        initComponents();
        this.setLocationRelativeTo(null);
        updateItemsTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_Back1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_ShoppingListTable = new javax.swing.JTable();
        jButton_AddItem = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_ItemsTable = new javax.swing.JTable();
        customerLabel1 = new javax.swing.JLabel();
        customerLabel3 = new javax.swing.JLabel();
        jButton_RemoveItem = new javax.swing.JButton();
        jButton_Back = new javax.swing.JButton();
        customerLabel4 = new javax.swing.JLabel();
        customerLabel5 = new javax.swing.JLabel();
        jButton_UpdateTables = new javax.swing.JButton();
        jButton_Logout = new javax.swing.JButton();
        CustomerNameLabel = new javax.swing.JLabel();
        StoreNameLabel = new javax.swing.JLabel();

        jButton_Back1.setBackground(new java.awt.Color(0, 0, 204));
        jButton_Back1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton_Back1.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Back1.setText("Back");
        jButton_Back1.setMaximumSize(new java.awt.Dimension(100, 28));
        jButton_Back1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_Back1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_Back1MouseExited(evt);
            }
        });
        jButton_Back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Back1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 0, 204));
        jPanel2.setForeground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_ShoppingListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "ID", "Size", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_ShoppingListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ShoppingListTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_ShoppingListTable);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 540, 170));

        jButton_AddItem.setBackground(new java.awt.Color(204, 0, 204));
        jButton_AddItem.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton_AddItem.setForeground(new java.awt.Color(255, 255, 255));
        jButton_AddItem.setText("Add Item to List");
        jButton_AddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddItemActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_AddItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 170, 47));

        jTable_ItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "ID", "Category", "Aisle", "Description", "Size", "Price", "Sale", "Availability"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_ItemsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ItemsTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable_ItemsTable);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 590, 170));

        customerLabel1.setBackground(new java.awt.Color(255, 255, 255));
        customerLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        customerLabel1.setText("Shopping List:");
        jPanel3.add(customerLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, -1, -1));

        customerLabel3.setBackground(new java.awt.Color(255, 255, 255));
        customerLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        customerLabel3.setText("Select Item from Shopping List:");
        jPanel3.add(customerLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 190, -1));

        jButton_RemoveItem.setBackground(new java.awt.Color(204, 0, 204));
        jButton_RemoveItem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton_RemoveItem.setForeground(new java.awt.Color(255, 255, 255));
        jButton_RemoveItem.setText("Remove Item from List");
        jButton_RemoveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RemoveItemActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_RemoveItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, 47));

        jButton_Back.setBackground(new java.awt.Color(0, 0, 204));
        jButton_Back.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton_Back.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Back.setText("Back");
        jButton_Back.setMaximumSize(new java.awt.Dimension(100, 28));
        jButton_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BackActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 140, 60));

        customerLabel4.setBackground(new java.awt.Color(255, 255, 255));
        customerLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        customerLabel4.setText("List of Items in Store:");
        jPanel3.add(customerLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        customerLabel5.setBackground(new java.awt.Color(255, 255, 255));
        customerLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        customerLabel5.setText("Select Item from Store Table:");
        jPanel3.add(customerLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jButton_UpdateTables.setBackground(new java.awt.Color(0, 0, 204));
        jButton_UpdateTables.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton_UpdateTables.setForeground(new java.awt.Color(255, 255, 255));
        jButton_UpdateTables.setText("Update Tables");
        jButton_UpdateTables.setMaximumSize(new java.awt.Dimension(100, 28));
        jButton_UpdateTables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateTablesActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_UpdateTables, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 140, 50));

        jButton_Logout.setBackground(new java.awt.Color(0, 0, 204));
        jButton_Logout.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton_Logout.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Logout.setText("Logout");
        jButton_Logout.setMaximumSize(new java.awt.Dimension(100, 28));
        jButton_Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LogoutActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 140, 50));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 24, 780, 420));

        CustomerNameLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        CustomerNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        CustomerNameLabel.setText("Customer Name:");
        jPanel2.add(CustomerNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 340, -1));

        StoreNameLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        StoreNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        StoreNameLabel.setText("Store Name:");
        jPanel2.add(StoreNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 340, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BackActionPerformed
        Customer_Form customer = new Customer_Form();
        customer.getUser(this.currentUser);
        customer.setVisible(true);
        customer.pack();
        customer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton_BackActionPerformed

    private void jTable_ShoppingListTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ShoppingListTableMouseClicked
        DefaultTableModel listModel = (DefaultTableModel)jTable_ShoppingListTable.getModel();
        
        shoppingItemName = listModel.getValueAt(jTable_ShoppingListTable.getSelectedRow(), 0).toString();
        shoppingItemID = listModel.getValueAt(jTable_ShoppingListTable.getSelectedRow(), 1).toString();
        shoppingItemSize = listModel.getValueAt(jTable_ShoppingListTable.getSelectedRow(), 2).toString();
        shoppingItemPrice = listModel.getValueAt(jTable_ShoppingListTable.getSelectedRow(), 3).toString();
    }//GEN-LAST:event_jTable_ShoppingListTableMouseClicked
    
    private void updateShoppingList(){
        DefaultTableModel csvItemsData = new DefaultTableModel();
 
        if(userShoppingList.length() <= 1){
            csvItemsData.addColumn("Name");
            csvItemsData.addColumn("ID");
            csvItemsData.addColumn("Size");
            csvItemsData.addColumn("Price");
        }else{
            try {
                Scanner itemsFileScan = new Scanner(userShoppingList);
                
                int start = 0;
                
                while (itemsFileScan.hasNextLine()) {
                    
                    String input = itemsFileScan.nextLine();
                    String[] itemValues = input.split(",");
                    
                    String nameItem = itemValues[0]; //name
                    String idItem = itemValues[1]; //Id

                    String sizeItem = itemValues[5]; //Size
                    String priceItem = itemValues[6]; //Price
                    
                    
                    if(start == 0){
                            start = 1;
                            csvItemsData.addColumn("Name");
                            csvItemsData.addColumn("ID");
                            csvItemsData.addColumn("Size");
                            csvItemsData.addColumn("Price");
                    }else{
                        Vector row = new Vector();
                        row.add(nameItem);
                        row.add(idItem);
                        row.add(sizeItem);
                        row.add(priceItem);
                        csvItemsData.addRow(row); 
                    }
                    
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(StoreMangement_Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        jTable_ShoppingListTable.setModel(csvItemsData);
    }
    
    private void updateItemsTable(){
        DefaultTableModel csvItemsData = new DefaultTableModel();
 
        if(csvItemsData.getColumnCount() == 0 && itemsFile.length() == 0){
            csvItemsData.addColumn("Name");
            csvItemsData.addColumn("ID");
            csvItemsData.addColumn("Category");
            csvItemsData.addColumn("Aisle");
            csvItemsData.addColumn("Description");
            csvItemsData.addColumn("Size");
            csvItemsData.addColumn("Price");
            csvItemsData.addColumn("Sale");
            csvItemsData.addColumn("Availability");
        }else{
            try {
                Scanner itemsFileScan = new Scanner(itemsFile);
                
                int start = 0;
                
                while (itemsFileScan.hasNextLine()) {
                    
                    String input = itemsFileScan.nextLine();
                    String[] itemValues = input.split(",");
                    
                    String nameItem = itemValues[0];
                    String idItem = itemValues[1];
                    String categoryItem = itemValues[2];
                    String aisleItem = itemValues[3];
                    String descriptionItem = itemValues[4];
                    String sizeItem = itemValues[5]; //Size
                    String priceItem = itemValues[6]; //Price
                    String saleItem = itemValues[7]; //ItemOnSale
                    String availabilityItem = itemValues[9]; //Item Availability
                    
                    String idStore = itemValues[8]; //Store ID
                    
                    if(start == 0){
                            start = 1;
                            csvItemsData.addColumn("Name");
                            csvItemsData.addColumn("ID");
                            csvItemsData.addColumn("Category");
                            csvItemsData.addColumn("Aisle");
                            csvItemsData.addColumn("Description");
                            csvItemsData.addColumn("Size");
                            csvItemsData.addColumn("Price");
                            csvItemsData.addColumn("Sale");
                            csvItemsData.addColumn("Availability");
                    }else{
                        if(idStore.equals(this.originalStoreID)){
                            Vector row = new Vector();
                            row.add(nameItem);
                            row.add(idItem);
                            row.add(categoryItem);
                            row.add(aisleItem);
                            row.add(sizeItem);
                            row.add(priceItem);
                            row.add(descriptionItem);
                            row.add(saleItem);
                            row.add(availabilityItem);
                            csvItemsData.addRow(row);
                        }
                    }
                    
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(StoreMangement_Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        jTable_ItemsTable.setModel(csvItemsData);
    }
    
    private boolean checkItemValues(String itemName, String itemID) throws FileNotFoundException{        
        Scanner fileItem = new Scanner(itemsFile);
        
        boolean found = true; // added this variable

        if(itemsFile.length() == 0 || itemsFile.length() == 1){
            found = true;
        }else{
            fileItem.nextLine();
            while (fileItem.hasNextLine()) {
                found = true;
                
                String input = fileItem.nextLine();
                String[] itemValues = input.split(",");
                String nameItem = itemValues[1];
                String idItem = itemValues[2];
                int availabilityItem = Integer.parseInt(itemValues[9]);
            
            if (itemName.equals(nameItem) && itemID.equals(idItem) && availabilityItem < 1) {
                    found = false;  
                } 
            }
        }
        return found;
    }
    
    private void addItem(String nameItem, String itemID, String itemDescription, String itemCategory, 
            String itemSize, String itemAisleNum, String itemPrice) throws IOException, Exception{
        try {     
            boolean validValues = checkItemValues(nameItem, itemID);
            
            if(validValues){

                newItem = new Item(nameItem, itemID, itemDescription, itemCategory, itemSize, itemPrice, 
                itemAisleNum);
                
                Maintain_Items maintainItem = new Maintain_Items();
                
                //add user to login file.
                maintainItem.load(userShoppingListPath);
                
                maintainItem.items.add(newItem);

                maintainItem.update(userShoppingListPath); 
                
                Maintain_Items maintainItemDatabase = new Maintain_Items();
                maintainItemDatabase.load(itemsPath);
                for(Item item: maintainItemDatabase.items){
                     if(item.getItemID().equals(itemID)){
                        int intItemAvailability = Integer.parseInt(itemAvailability);
                        int newIntItemAvailability = intItemAvailability - 1;
                        String stringNewItemAvailabilty = String.valueOf(newIntItemAvailability);
                        item.setItemAvailability(stringNewItemAvailabilty);
                        break;
                      }
                }     
                maintainItemDatabase.update(itemsPath);
                
                JOptionPane.showMessageDialog(null, "Item Added!", "Item Added", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
               JOptionPane.showMessageDialog(null, "No Item Available.", "Error Message", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(notepad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void jButton_AddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddItemActionPerformed
        createFile();
        try {
            addItem(itemName, itemID, itemDescription, itemCategory, itemSize, itemAisle, itemPrice);
        } catch (Exception ex) {
            Logger.getLogger(ShoppingList_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateItemsTable();
        updateShoppingList();
    }//GEN-LAST:event_jButton_AddItemActionPerformed

   
    private void jTable_ItemsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ItemsTableMouseClicked
        DefaultTableModel itemModel = (DefaultTableModel)jTable_ItemsTable.getModel();
        
        itemName = itemModel.getValueAt(jTable_ItemsTable.getSelectedRow(), 0).toString();
        itemID = itemModel.getValueAt(jTable_ItemsTable.getSelectedRow(), 1).toString();
        itemCategory = itemModel.getValueAt(jTable_ItemsTable.getSelectedRow(), 2).toString();
        itemAisle = itemModel.getValueAt(jTable_ItemsTable.getSelectedRow(), 3).toString();
        itemDescription = itemModel.getValueAt(jTable_ItemsTable.getSelectedRow(), 4).toString();
        itemSize = itemModel.getValueAt(jTable_ItemsTable.getSelectedRow(), 5).toString();
        itemPrice = itemModel.getValueAt(jTable_ItemsTable.getSelectedRow(), 6).toString();
        itemSale = itemModel.getValueAt(jTable_ItemsTable.getSelectedRow(), 7).toString();
        itemAvailability = itemModel.getValueAt(jTable_ItemsTable.getSelectedRow(), 8).toString();    
    }//GEN-LAST:event_jTable_ItemsTableMouseClicked

    private void deleteItem(){
        if(jTable_ShoppingListTable.getSelectedRowCount() == 1){
            try {
                int input = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete the item?", "Deletion of item",
                        JOptionPane.OK_CANCEL_OPTION, 2);
                
                if (input == 0){
                    Maintain_Items maintainItemDatabase = new Maintain_Items();
                    maintainItemDatabase.load(itemsPath);
                    for(Item item: maintainItemDatabase.items){
                         if(item.getItemID().equals(itemID)){
                            int intItemAvailability = Integer.parseInt(itemAvailability);
                            String stringNewItemAvailabilty = String.valueOf(intItemAvailability);
                            item.setItemAvailability(stringNewItemAvailabilty);
                            break;
                          }
                        }     
                    maintainItemDatabase.update(itemsPath);
                    
                    Maintain_Items maintainListTable = new Maintain_Items();
                    maintainListTable.load(userShoppingListPath);
                    
                    for(Item item: maintainListTable.items){
                        if(item.getItemID().equals(shoppingItemID)){
                            maintainListTable.items.remove(item);
                            break;
                        }
                    }
                    maintainListTable.update(userShoppingListPath);
                    JOptionPane.showMessageDialog(null, "Item removed from list", "Deleted", 2);
                }
            } catch (Exception ex) {
                Logger.getLogger(Admin_Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            if(jTable_ShoppingListTable.getRowCount() == 0){
                 JOptionPane.showMessageDialog(null, "Table is Empty", "Empty Table", 2);
            }
            JOptionPane.showMessageDialog(null, "Select a Row to update.", "Updated", 2);
        }
    }
    
    private void jButton_RemoveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RemoveItemActionPerformed
       createFile();
       deleteItem();
       updateItemsTable();
       updateShoppingList();
    }//GEN-LAST:event_jButton_RemoveItemActionPerformed

    private void jButton_Back1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_Back1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Back1MouseEntered

    private void jButton_Back1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_Back1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Back1MouseExited

    private void jButton_Back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Back1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Back1ActionPerformed

    private void jButton_UpdateTablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateTablesActionPerformed
       updateItemsTable();
       updateShoppingList();
    }//GEN-LAST:event_jButton_UpdateTablesActionPerformed

    private void jButton_LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LogoutActionPerformed
        Smart_Shoppers_System login = new Smart_Shoppers_System();
        login.setVisible(true);
        login.pack();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton_LogoutActionPerformed

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
            java.util.logging.Logger.getLogger(ShoppingList_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShoppingList_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShoppingList_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShoppingList_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShoppingList_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CustomerNameLabel;
    private javax.swing.JLabel StoreNameLabel;
    private javax.swing.JLabel customerLabel1;
    private javax.swing.JLabel customerLabel3;
    private javax.swing.JLabel customerLabel4;
    private javax.swing.JLabel customerLabel5;
    private javax.swing.JButton jButton_AddItem;
    private javax.swing.JButton jButton_Back;
    private javax.swing.JButton jButton_Back1;
    private javax.swing.JButton jButton_Logout;
    private javax.swing.JButton jButton_RemoveItem;
    private javax.swing.JButton jButton_UpdateTables;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable_ItemsTable;
    private javax.swing.JTable jTable_ShoppingListTable;
    // End of variables declaration//GEN-END:variables
}
