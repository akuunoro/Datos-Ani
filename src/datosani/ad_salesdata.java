/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosani;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Russel
 */
public class ad_salesdata extends javax.swing.JFrame {
    private String getemail;
    private final sqlconnector dbConnection;
    private int loggedInFarmerId;
    private String showfirstname;
    private int botanicfam_code;
    private int plotlandcode;
    private String Ncropprice;
    private String total_sales; 
    private String total_costs;
    private String getrtdate;
             
    
    
    public ad_salesdata(int loggedInFarmerId, String showfirstname, String Ncropprice, int botanicfam_code, int plotlandcode) {
        this.loggedInFarmerId = loggedInFarmerId;
        this.showfirstname = showfirstname;
        this.botanicfam_code = botanicfam_code;
        this.plotlandcode = plotlandcode;
        this.Ncropprice = Ncropprice;
        
        initComponents();
        dbConnection = sqlconnector.getInstance(); 
        
        
        realtDate();
        realtTime();
       
        
        System.out.println("Logged in Farmer ID: " + loggedInFarmerId);
        System.out.println("Botanical Family: " + botanicfam_code);
        System.out.println("Plot Land: " + plotlandcode);
        
        int farmerid = loggedInFarmerId;
       
        cmb_salesper.addItem("");
        cmb_salesper.addItem("sack");
        cmb_salesper.addItem("piece");
        cmb_salesper.addItem("bundle");
        
        
        
        
        
    }

    public void realtDate(){
        Date date = new Date();
        SimpleDateFormat sdfdate = new SimpleDateFormat("MM-dd-yyyy");
        String showdate = sdfdate.format(date);
        rtDate.setText(showdate);
        
    }
    
    public void realtTime(){
        new Timer (0, new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent ae) {
                Date time = new Date();
                SimpleDateFormat sdftime = new SimpleDateFormat("hh.mm.ss");
                String showtime = sdftime.format(time);
                rtTime.setText(showtime);
            }
        }).start();
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator5 = new javax.swing.JSeparator();
        logo4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cmb_salesper = new javax.swing.JComboBox<>();
        txt_soldqnty = new javax.swing.JTextField();
        logo10 = new javax.swing.JLabel();
        ad_sd_Clear = new javax.swing.JButton();
        ad_sd_Save = new javax.swing.JButton();
        btn_ad_cp_User = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        rtDate = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rtTime = new javax.swing.JLabel();
        vd_vc_back = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        vd_vc_back1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator5.setBackground(new java.awt.Color(0, 100, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setOpaque(true);
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 550, 2));

        logo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Datos-Ani Icon Logo.png"))); // NOI18N
        getContentPane().add(logo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 50));

        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, -1, 50));
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 70, 70));

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("ADD CROP DATA");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setOpaque(true);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 188, 490, -1));

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Sales");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 90, -1));

        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Sold Quantity");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 140, -1));

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Per");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 140, -1));

        cmb_salesper.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        getContentPane().add(cmb_salesper, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 110, 40));

        txt_soldqnty.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_soldqnty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_soldqntyKeyTyped(evt);
            }
        });
        getContentPane().add(txt_soldqnty, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 120, 40));

        logo10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/User Icon.png"))); // NOI18N
        logo10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(logo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, -1, 50));

        ad_sd_Clear.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        ad_sd_Clear.setText("Clear");
        ad_sd_Clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ad_sd_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ad_sd_ClearActionPerformed(evt);
            }
        });
        getContentPane().add(ad_sd_Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 500, 100, 40));

        ad_sd_Save.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        ad_sd_Save.setText("Save");
        ad_sd_Save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ad_sd_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ad_sd_SaveActionPerformed(evt);
            }
        });
        getContentPane().add(ad_sd_Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 500, 100, 40));

        btn_ad_cp_User.setBorder(null);
        btn_ad_cp_User.setBorderPainted(false);
        btn_ad_cp_User.setContentAreaFilled(false);
        btn_ad_cp_User.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ad_cp_User.setFocusPainted(false);
        btn_ad_cp_User.setFocusable(false);
        btn_ad_cp_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ad_cp_UserActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ad_cp_User, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 60, 70));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dATE.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 60, 60));

        jLabel24.setBackground(new java.awt.Color(0, 51, 102, 150));
        jLabel24.setOpaque(true);
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 820, 450));

        rtDate.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        rtDate.setForeground(new java.awt.Color(0, 100, 0));
        rtDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(rtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 140, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/TIME.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 60, 60));

        rtTime.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        rtTime.setForeground(new java.awt.Color(0, 100, 0));
        rtTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(rtTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 160, 30));

        vd_vc_back.setBackground(new java.awt.Color(102, 153, 0));
        vd_vc_back.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        vd_vc_back.setForeground(new java.awt.Color(255, 255, 255));
        vd_vc_back.setText("BACK");
        vd_vc_back.setBorderPainted(false);
        vd_vc_back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vd_vc_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vd_vc_backActionPerformed(evt);
            }
        });
        getContentPane().add(vd_vc_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, 30));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG2.png"))); // NOI18N
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        vd_vc_back1.setBackground(new java.awt.Color(102, 153, 0));
        vd_vc_back1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        vd_vc_back1.setForeground(new java.awt.Color(255, 255, 255));
        vd_vc_back1.setText("BACK");
        vd_vc_back1.setBorderPainted(false);
        vd_vc_back1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vd_vc_back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vd_vc_back1ActionPerformed(evt);
            }
        });
        getContentPane().add(vd_vc_back1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ad_sd_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ad_sd_ClearActionPerformed
        txt_soldqnty.setText("");
        cmb_salesper.setSelectedItem("");
    }//GEN-LAST:event_ad_sd_ClearActionPerformed

    private void ad_sd_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ad_sd_SaveActionPerformed
        String soldqnty, persoldqnty;
        String cropprice;
    
    if ("".equals(txt_soldqnty.getText())) {
        JOptionPane.showMessageDialog(new JFrame(), "Enter Sold Quantity");
    } else if ("".equals(cmb_salesper.getSelectedItem())) {
        JOptionPane.showMessageDialog(new JFrame(), "Choose Per Sold Quantity");
    } else {
        
    soldqnty = txt_soldqnty.getText();
    persoldqnty = (String) cmb_salesper.getSelectedItem();
    String sq = soldqnty + " / " + persoldqnty;
    
    try {
                        
        sqlconnector connector = sqlconnector.getInstance();
        Connection connection = connector.getConnection();
        
        
        
        String sql1 = "SELECT crop_code FROM crops_data WHERE cpfarmer_id = ? AND cpbotanicfam_code = ? AND cpplot_land_code = ?";
        
        try (PreparedStatement pstmt1 = connection.prepareStatement(sql1)) {
            pstmt1.setInt(1, loggedInFarmerId);
            pstmt1.setInt (2, botanicfam_code);
            pstmt1.setInt (3, plotlandcode);
            
            ResultSet rs1 = pstmt1.executeQuery();
        
            if (rs1.next()) {
                int cropcode_sales = rs1.getInt("crop_code"); 
                
                System.out.println("Cropcode_sales: " + cropcode_sales);
                System.out.println("Crop Price: " +  Ncropprice);
               
                double dsoldqnty = Double.parseDouble(soldqnty);
                double dcropprice = Double.parseDouble(Ncropprice);
                double dtotal_sales = (dsoldqnty * dcropprice);
                String total_sales = String.valueOf(dtotal_sales);
                
                String sql2 = "INSERT INTO crop_sales (salesfarmer_id, salescrop_code, sold_qnty, total_sales) VALUES (?, ?, ?, ?)";
            
                try (PreparedStatement pstmt2 = connection.prepareStatement(sql2)) {
                    pstmt2.setInt(1, loggedInFarmerId);
                    pstmt2.setInt(2, cropcode_sales);
                    pstmt2.setString(3, sq);
                    pstmt2.setString(4, total_sales);
                    
                    System.out.println("Executing SQL Query: " + sql1);
                    System.out.println("salesfarmer_id: " + loggedInFarmerId);
                    System.out.println("salescrop_code: " + cropcode_sales);
                    System.out.println("sold_qnty: " + sq);
                    System.out.println("total_sales: " + total_sales);
                    
                    int rowsInserted = pstmt2.executeUpdate();
                
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(this, "Data Added Successfully.");
                        new ad_costdata(loggedInFarmerId, showfirstname,botanicfam_code, plotlandcode).setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to Add Data.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "No crop found for the logged-in farmer.");
            }
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter valid numbers for quantity and price.");
    } catch (SQLException ex) {
        Logger.getLogger(ad_salesdata.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    }//GEN-LAST:event_ad_sd_SaveActionPerformed

    private void txt_soldqntyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_soldqntyKeyTyped
        char qnty = evt.getKeyChar();
       if(Character.isLetter(qnty)&&!evt.isAltDown()){
           evt.consume();
       }
    }//GEN-LAST:event_txt_soldqntyKeyTyped

    private void vd_vc_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vd_vc_backActionPerformed
        new insidelogin(loggedInFarmerId, showfirstname, getemail, botanicfam_code, plotlandcode, total_sales, total_costs, getrtdate).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_vd_vc_backActionPerformed

    private void vd_vc_back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vd_vc_back1ActionPerformed
        new insidelogin(loggedInFarmerId, showfirstname, getemail, botanicfam_code, plotlandcode, total_sales, total_costs, getrtdate).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_vd_vc_back1ActionPerformed

    private void btn_ad_cp_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ad_cp_UserActionPerformed
        new user(loggedInFarmerId, showfirstname, botanicfam_code).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_ad_cp_UserActionPerformed

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
            java.util.logging.Logger.getLogger(ad_salesdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ad_salesdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ad_salesdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ad_salesdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int farmerid = 0;
                String showfirstname = null;
                int botanicfam_code = 0;
                String Ncropprice = null;
                int plotlandcode = 0;
                new ad_salesdata(farmerid, showfirstname, Ncropprice, botanicfam_code, plotlandcode).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ad_sd_Clear;
    private javax.swing.JButton ad_sd_Save;
    private javax.swing.JButton btn_ad_cp_User;
    private javax.swing.JComboBox<String> cmb_salesper;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel logo10;
    private javax.swing.JLabel logo4;
    private javax.swing.JLabel rtDate;
    private javax.swing.JLabel rtTime;
    private javax.swing.JTextField txt_soldqnty;
    private javax.swing.JButton vd_vc_back;
    private javax.swing.JButton vd_vc_back1;
    // End of variables declaration//GEN-END:variables
}
