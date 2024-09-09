/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosani;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author Russel
 */
public class interfacesignin extends javax.swing.JFrame {
    
   
    private final sqlconnector dbConnection;
    
    static int otp;
    public static String addemail;
    
    
    
    private String getemail;
    private int loggedInFarmerId; 
    private int botanicfam_code;
    private int plotlandcode;
    private String total_sales;
    private String total_costs;
    
    
    public interfacesignin(int loggedInFarmerId, int botanicfam_code) {
        this.loggedInFarmerId = loggedInFarmerId;
        this.botanicfam_code = botanicfam_code;
        
        initComponents();
        dbConnection = sqlconnector.getInstance(); 
        
        
        
        
    }

   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        si_Separator = new javax.swing.JSeparator();
        si_logo = new javax.swing.JLabel();
        btn_SiHome = new javax.swing.JButton();
        btn_SiAbout = new javax.swing.JButton();
        Si_LogoWord = new javax.swing.JLabel();
        si_AboutWord3 = new javax.swing.JLabel();
        si_AboutWord1 = new javax.swing.JLabel();
        si_AboutWord2 = new javax.swing.JLabel();
        btn_SiSignup = new javax.swing.JButton();
        btn_SiAbout2 = new javax.swing.JButton();
        btn_gotoMainIn = new javax.swing.JButton();
        btn_SiSignin = new javax.swing.JButton();
        Si_Password = new javax.swing.JLabel();
        Si_Username = new javax.swing.JLabel();
        txt_Siemail = new javax.swing.JTextField();
        txt_SiPassword = new javax.swing.JPasswordField();
        si_Panelbg = new javax.swing.JLabel();
        Sibg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        si_Separator.setBackground(new java.awt.Color(0, 100, 0));
        si_Separator.setForeground(new java.awt.Color(0, 0, 0));
        si_Separator.setOpaque(true);
        getContentPane().add(si_Separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 550, 2));

        si_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Datos-Ani Icon Logo.png"))); // NOI18N
        getContentPane().add(si_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 50));

        btn_SiHome.setBackground(new java.awt.Color(204, 255, 204));
        btn_SiHome.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_SiHome.setForeground(new java.awt.Color(0, 100, 0));
        btn_SiHome.setText("HOME");
        btn_SiHome.setToolTipText("");
        btn_SiHome.setBorderPainted(false);
        btn_SiHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_SiHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SiHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btn_SiHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 90, 30));

        btn_SiAbout.setBackground(new java.awt.Color(204, 255, 204));
        btn_SiAbout.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_SiAbout.setForeground(new java.awt.Color(0, 100, 0));
        btn_SiAbout.setText("ABOUT");
        btn_SiAbout.setToolTipText("");
        btn_SiAbout.setBorderPainted(false);
        btn_SiAbout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_SiAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SiAboutActionPerformed(evt);
            }
        });
        getContentPane().add(btn_SiAbout, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 100, 30));

        Si_LogoWord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Horizontal Logo.png"))); // NOI18N
        getContentPane().add(Si_LogoWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        si_AboutWord3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        si_AboutWord3.setForeground(new java.awt.Color(255, 255, 255));
        si_AboutWord3.setText("track of crop rotation.");
        getContentPane().add(si_AboutWord3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 370, 40));

        si_AboutWord1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        si_AboutWord1.setForeground(new java.awt.Color(255, 255, 255));
        si_AboutWord1.setText("\"Datos-Ani is a farm management system that encompasses two ");
        getContentPane().add(si_AboutWord1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 360, 40));

        si_AboutWord2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        si_AboutWord2.setForeground(new java.awt.Color(255, 255, 255));
        si_AboutWord2.setText("main purposes: harvest and economic performance; and keeping");
        getContentPane().add(si_AboutWord2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 370, 40));

        btn_SiSignup.setBackground(new java.awt.Color(204, 255, 204));
        btn_SiSignup.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btn_SiSignup.setForeground(new java.awt.Color(0, 100, 0));
        btn_SiSignup.setText("SIGN UP");
        btn_SiSignup.setBorderPainted(false);
        btn_SiSignup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_SiSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SiSignupActionPerformed(evt);
            }
        });
        getContentPane().add(btn_SiSignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 90, -1));

        btn_SiAbout2.setBackground(new java.awt.Color(0, 51, 153));
        btn_SiAbout2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btn_SiAbout2.setForeground(new java.awt.Color(255, 255, 255));
        btn_SiAbout2.setText("ABOUT");
        btn_SiAbout2.setBorderPainted(false);
        btn_SiAbout2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_SiAbout2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SiAbout2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_SiAbout2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 90, 30));

        btn_gotoMainIn.setBackground(new java.awt.Color(0, 51, 153));
        btn_gotoMainIn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btn_gotoMainIn.setForeground(new java.awt.Color(255, 255, 255));
        btn_gotoMainIn.setText("SIGN IN");
        btn_gotoMainIn.setBorderPainted(false);
        btn_gotoMainIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_gotoMainIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gotoMainInActionPerformed(evt);
            }
        });
        getContentPane().add(btn_gotoMainIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 90, -1));

        btn_SiSignin.setBackground(new java.awt.Color(204, 255, 204));
        btn_SiSignin.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btn_SiSignin.setForeground(new java.awt.Color(0, 100, 0));
        btn_SiSignin.setText("SIGN IN");
        btn_SiSignin.setBorderPainted(false);
        btn_SiSignin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_SiSignin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SiSigninActionPerformed(evt);
            }
        });
        getContentPane().add(btn_SiSignin, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 90, -1));

        Si_Password.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Si_Password.setForeground(new java.awt.Color(0, 100, 0));
        Si_Password.setText("Password");
        getContentPane().add(Si_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, -1, -1));

        Si_Username.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Si_Username.setForeground(new java.awt.Color(0, 100, 0));
        Si_Username.setText("Email Address");
        getContentPane().add(Si_Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, -1, -1));

        txt_Siemail.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        getContentPane().add(txt_Siemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 390, 40));

        txt_SiPassword.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        getContentPane().add(txt_SiPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, 390, 40));

        si_Panelbg.setBackground(new java.awt.Color(204, 255, 204, 150));
        si_Panelbg.setOpaque(true);
        getContentPane().add(si_Panelbg, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 440, 350));

        Sibg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG1.png"))); // NOI18N
        getContentPane().add(Sibg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SiHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SiHomeActionPerformed
        new home(loggedInFarmerId, botanicfam_code).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_SiHomeActionPerformed

    private void btn_SiAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SiAboutActionPerformed
        new aboutda(loggedInFarmerId).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_SiAboutActionPerformed

    private void btn_gotoMainInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gotoMainInActionPerformed
         String siemail, sipassword;
    
    if ("".equals(txt_Siemail.getText())){
        JOptionPane.showMessageDialog(new JFrame(), "Enter Email Address");
    } else if ("".equals(txt_SiPassword.getText())){
        JOptionPane.showMessageDialog(new JFrame(), "Enter Password");
    } else {
        siemail = txt_Siemail.getText();
        sipassword = txt_SiPassword.getText();
        
        try {
            sqlconnector connector = sqlconnector.getInstance();
            Connection connection = connector.getConnection();
            
            String sql = "SELECT farmer_id, frmr_first_name, frmr_emailaddress FROM farmer_info WHERE frmr_emailaddress = ? AND frmr_password = ?";
            
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, siemail);
                pstmt.setString(2, sipassword);
                
                ResultSet rs = pstmt.executeQuery();
                
                if (rs.next()) {
                    int loggedInFarmerId = rs.getInt("farmer_id"); // Store the logged-in farmer's ID
                    String showfirstname = rs.getString("frmr_first_name");
                    String getemail = rs.getString("frmr_emailaddress");
            
            // Print retrieved values for debugging
                    System.out.println("Logged in Farmer ID: " + loggedInFarmerId);
                    System.out.println("Farmer First Name: " + showfirstname);
                    System.out.println("Email Address: " + getemail);
                    JOptionPane.showMessageDialog(new JFrame(), "Login successful!");
                    
                    
                    //otp
                    Random randomotp = new Random();
                    int minnumotp = 100000;
                    int maxnumotp = 999999;
   
                    otp = randomotp.nextInt(maxnumotp-minnumotp)+minnumotp;
        
                    addemail = getemail;
                    

                    
                    
                    new verifyOTP(loggedInFarmerId, getemail, showfirstname, botanicfam_code, plotlandcode, total_sales, total_costs).setVisible(true);
     
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "No Account Found. Please try again.");
                }
                
                rs.close();
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Database error: " + ex.getMessage());
        }
        
        
        
        //Mag S-send Notificatiom
        
        
        
        
        
        
        
        
        
    }
    }//GEN-LAST:event_btn_gotoMainInActionPerformed

    private void btn_SiSigninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SiSigninActionPerformed
        new interfacesignin(loggedInFarmerId, botanicfam_code).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_SiSigninActionPerformed

    private void btn_SiSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SiSignupActionPerformed
        new interfacesignup(loggedInFarmerId, botanicfam_code).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_SiSignupActionPerformed

    private void btn_SiAbout2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SiAbout2ActionPerformed
        new aboutda(loggedInFarmerId).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_SiAbout2ActionPerformed

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
            java.util.logging.Logger.getLogger(interfacesignin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfacesignin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfacesignin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfacesignin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                int loggedInFarmerId = 0;
                int botanicfam_code = 0;
                new interfacesignin(loggedInFarmerId, botanicfam_code).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Si_LogoWord;
    private javax.swing.JLabel Si_Password;
    private javax.swing.JLabel Si_Username;
    private javax.swing.JLabel Sibg;
    private javax.swing.JButton btn_SiAbout;
    private javax.swing.JButton btn_SiAbout2;
    private javax.swing.JButton btn_SiHome;
    private javax.swing.JButton btn_SiSignin;
    private javax.swing.JButton btn_SiSignup;
    private javax.swing.JButton btn_gotoMainIn;
    private javax.swing.JLabel si_AboutWord1;
    private javax.swing.JLabel si_AboutWord2;
    private javax.swing.JLabel si_AboutWord3;
    private javax.swing.JLabel si_Panelbg;
    private javax.swing.JSeparator si_Separator;
    private javax.swing.JLabel si_logo;
    private javax.swing.JPasswordField txt_SiPassword;
    private javax.swing.JTextField txt_Siemail;
    // End of variables declaration//GEN-END:variables
}
