/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosani;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author Russel
 */
public class addcropdata extends javax.swing.JFrame {

    private int loggedInFarmerId;
    private String showfirstname;
    private int plotlandcode;
    private int botanicfam_code;
    private String total_sales;
    private String total_costs;
    private String getrtdate;
    private String getemail;
          
    
    public addcropdata(int loggedInFarmerId, String showfirstname, int botanicfam_code) {
        this.loggedInFarmerId = loggedInFarmerId;
        this.showfirstname = showfirstname;
        this.botanicfam_code = botanicfam_code;
        initComponents();
        
        realtDate();
        realtTime();
        
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

        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        btn_add_User = new javax.swing.JButton();
        logo2 = new javax.swing.JLabel();
        vd_add_back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_setcroprotation = new javax.swing.JButton();
        btn_addcropdata = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_setcropharvest = new javax.swing.JButton();
        rtDate = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        rtTime = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator3.setBackground(new java.awt.Color(0, 100, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setOpaque(true);
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 550, 2));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Russel\\Downloads\\STUFSS\\1st Year - 2nd Semester\\DBMS\\Projects\\GRAPHIC DESIGN\\UI DESIGN FINAL DRAFT\\Icons\\User Icon.png")); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, -1, 50));

        btn_add_User.setBorder(null);
        btn_add_User.setBorderPainted(false);
        btn_add_User.setContentAreaFilled(false);
        btn_add_User.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_add_User.setFocusPainted(false);
        btn_add_User.setFocusable(false);
        btn_add_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_UserActionPerformed(evt);
            }
        });
        getContentPane().add(btn_add_User, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 60, 70));

        logo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Datos-Ani Icon Logo.png"))); // NOI18N
        getContentPane().add(logo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 50));

        vd_add_back.setBackground(new java.awt.Color(102, 153, 0));
        vd_add_back.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        vd_add_back.setForeground(new java.awt.Color(255, 255, 255));
        vd_add_back.setText("BACK");
        vd_add_back.setBorderPainted(false);
        vd_add_back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vd_add_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vd_add_backActionPerformed(evt);
            }
        });
        getContentPane().add(vd_add_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Russel\\Downloads\\STUFSS\\1st Year - 2nd Semester\\DBMS\\Projects\\GRAPHIC DESIGN\\UI DESIGN FINAL DRAFT\\Icons\\Crops (Transparent).png")); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 140, 100));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Russel\\Downloads\\STUFSS\\1st Year - 2nd Semester\\DBMS\\Projects\\GRAPHIC DESIGN\\UI DESIGN FINAL DRAFT\\Icons\\Crop Rotation (Transparent).png")); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 140, 100));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 50)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ADD CROP DATA");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 470, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 50)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SET CROP ROTATION");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 580, -1));

        btn_setcroprotation.setBackground(new java.awt.Color(102, 153, 0));
        btn_setcroprotation.setBorderPainted(false);
        btn_setcroprotation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_setcroprotation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_setcroprotationActionPerformed(evt);
            }
        });
        getContentPane().add(btn_setcroprotation, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 710, 100));

        btn_addcropdata.setBackground(new java.awt.Color(102, 153, 0));
        btn_addcropdata.setBorderPainted(false);
        btn_addcropdata.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_addcropdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addcropdataActionPerformed(evt);
            }
        });
        getContentPane().add(btn_addcropdata, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 710, 100));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Russel\\Downloads\\STUFSS\\1st Year - 2nd Semester\\DBMS\\Projects\\GRAPHIC DESIGN\\UI DESIGN FINAL DRAFT\\Icons\\Crops (Transparent).png")); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 140, 100));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 50)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("SET CROP HARVEST");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 580, -1));

        btn_setcropharvest.setBackground(new java.awt.Color(102, 153, 0));
        btn_setcropharvest.setBorderPainted(false);
        btn_setcropharvest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_setcropharvest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_setcropharvestActionPerformed(evt);
            }
        });
        getContentPane().add(btn_setcropharvest, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 710, 100));

        rtDate.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        rtDate.setForeground(new java.awt.Color(0, 100, 0));
        rtDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(rtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 140, 30));

        jLabel14.setBackground(new java.awt.Color(0, 51, 102, 150));
        jLabel14.setOpaque(true);
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 820, 450));

        rtTime.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        rtTime.setForeground(new java.awt.Color(0, 100, 0));
        rtTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(rtTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 190, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG2.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_add_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_UserActionPerformed
        new user(loggedInFarmerId, showfirstname, botanicfam_code).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_add_UserActionPerformed

    private void vd_add_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vd_add_backActionPerformed
        new insidelogin(loggedInFarmerId, showfirstname, getemail, botanicfam_code, plotlandcode, total_sales, total_costs, getrtdate).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_vd_add_backActionPerformed

    private void btn_addcropdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addcropdataActionPerformed
        new ad_cropdata(loggedInFarmerId, showfirstname, botanicfam_code).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_addcropdataActionPerformed

    private void btn_setcroprotationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_setcroprotationActionPerformed
        new ad_setcroprotation(loggedInFarmerId, showfirstname, botanicfam_code).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_setcroprotationActionPerformed

    private void btn_setcropharvestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_setcropharvestActionPerformed
        new ad_setcropharvest(loggedInFarmerId, showfirstname, botanicfam_code).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_setcropharvestActionPerformed

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
            java.util.logging.Logger.getLogger(addcropdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addcropdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addcropdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addcropdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            int loggedInFarmerId = 0;
            String showfirstname = null;
            int botanicfam_code = 0;
            public void run() {
                new addcropdata(loggedInFarmerId, showfirstname, botanicfam_code).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add_User;
    private javax.swing.JButton btn_addcropdata;
    private javax.swing.JButton btn_setcropharvest;
    private javax.swing.JButton btn_setcroprotation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel logo2;
    private javax.swing.JLabel rtDate;
    private javax.swing.JLabel rtTime;
    private javax.swing.JButton vd_add_back;
    // End of variables declaration//GEN-END:variables
}
