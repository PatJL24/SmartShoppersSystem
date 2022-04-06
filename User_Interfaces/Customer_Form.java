/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package User_Interfaces;

import Smart_Shopper_System.Smart_Shoppers_System;
import Data_Management.User;
import java.awt.Color;
import java.io.File;
import javax.swing.JFrame;

/**
 *
 * @author patli
 */
public class Customer_Form extends javax.swing.JFrame {

    String directory = "C:\\SmartShoppersSystem";
    File loginDirectory = new File(directory);   //directory file path
    
    
    String storeLocationDic = "C:\\SmartShoppersSystem\\Stores";
    File storeDirectory = new File(directory);
    
    String storeLocationFilePath = "C:\\SmartShoppersSystem\\Stores\\storeLocations.csv";
    File storeLocation = new File(storeLocationFilePath); //Store Locations  Path
   
    User currentUser;
    
    
    String username;
    String password;
    String firstName;
    String lastName;
    String street;
    String Country;
    String city;
    String PostalCode;
    String userType = "Customer";
    
    public void getUser(User user){
        this.currentUser = user;
        this.username = user.getUsername();
        customerLabel.setText("Customer: " + this.username);
        this.password = user.getPassword();
        this.userType = user.getUserType();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.street = user.getStreet();
        this.Country = user.getCountry();
        this.city = user.getCity();
        this.PostalCode = user.getPostalCode();
    }
    
    /**
     * Creates new form User_Interface
     */
    public Customer_Form() {
        initComponents();
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

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton_Logout = new javax.swing.JButton();
        jButton_AccountSettings = new javax.swing.JButton();
        customerLabel = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 0, 204));
        jPanel2.setForeground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel3.add(jButton_Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 6, 157, 47));

        jButton_AccountSettings.setBackground(new java.awt.Color(204, 0, 204));
        jButton_AccountSettings.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton_AccountSettings.setForeground(new java.awt.Color(255, 255, 255));
        jButton_AccountSettings.setText("Account Settings");
        jButton_AccountSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_AccountSettingsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_AccountSettingsMouseExited(evt);
            }
        });
        jButton_AccountSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AccountSettingsActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_AccountSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 6, -1, 47));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 44, 710, 350));

        customerLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        customerLabel.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel.setText("Customer:");
        jPanel2.add(customerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AccountSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AccountSettingsActionPerformed
        Settings_Form accountSettings = new Settings_Form();
        accountSettings.getUser(currentUser);
        accountSettings.setVisible(true);
        accountSettings.pack();
        accountSettings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton_AccountSettingsActionPerformed

    private void jButton_AccountSettingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_AccountSettingsMouseExited
        // set jbutton background
        jButton_AccountSettings.setBackground(new Color(204, 0, 204));
    }//GEN-LAST:event_jButton_AccountSettingsMouseExited

    private void jButton_AccountSettingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_AccountSettingsMouseEntered
        // set jbutton background
        jButton_AccountSettings.setBackground(new Color(255, 102, 255));
    }//GEN-LAST:event_jButton_AccountSettingsMouseEntered

    private void jButton_LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LogoutActionPerformed
        Smart_Shoppers_System login = new Smart_Shoppers_System();
        login.setVisible(true);
        login.pack();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton_LogoutActionPerformed

    private void jButton_LogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_LogoutMouseExited
        // set jbutton background
        jButton_Logout.setBackground(new Color(204, 0, 204));
    }//GEN-LAST:event_jButton_LogoutMouseExited

    private void jButton_LogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_LogoutMouseEntered
        // set jbutton background
        jButton_Logout.setBackground(new Color(255, 102, 255));
    }//GEN-LAST:event_jButton_LogoutMouseEntered

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
            java.util.logging.Logger.getLogger(Customer_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Customer_Form().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel customerLabel;
    private javax.swing.JButton jButton_AccountSettings;
    private javax.swing.JButton jButton_Logout;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
