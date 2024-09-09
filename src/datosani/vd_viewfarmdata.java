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
public class vd_viewfarmdata extends javax.swing.JFrame {
    private String getemail;
    private final sqlconnector dbConnection;
    private int loggedInFarmerId;
    private int botanicfam_code;
    private int plotlandcode;
    private String showfirstname;
    private String total_sales;
    private String total_costs;
    private String getrtdate;

   
    
    public vd_viewfarmdata(int loggedInFarmerId, String showfirstname, int botanicfam_code, int plotlandcode, String total_sales, String total_costs) {
        initComponents();
        
        
        dbConnection = sqlconnector.getInstance(); 
        
        realtDate();
        realtTime();
        
        
        this.showfirstname = showfirstname;
        this.loggedInFarmerId = loggedInFarmerId; 
        this.plotlandcode = plotlandcode;
        this.botanicfam_code = botanicfam_code;
        
        System.out.println("Logged in Farmer ID: " + loggedInFarmerId);
        System.out.println("Botanic Family ID: " + botanicfam_code);
        System.out.println("Plot of Land Code: " + plotlandcode);
        
        
      
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

        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        logo4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        logo5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        logo7 = new javax.swing.JLabel();
        logo8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        logo6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        rtDate = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rtTime = new javax.swing.JLabel();
        logo9 = new javax.swing.JLabel();
        vd_vc_back = new javax.swing.JButton();
        btn_ad_cp_User2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        jLabel2.setBackground(new java.awt.Color(0, 51, 102, 150));
        jLabel2.setOpaque(true);

        jLabel16.setBackground(new java.awt.Color(0, 51, 102, 150));
        jLabel16.setOpaque(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator5.setBackground(new java.awt.Color(0, 100, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setOpaque(true);
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 550, 2));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Crops (Transparent).png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 80, 90));

        logo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Datos-Ani Icon Logo.png"))); // NOI18N
        getContentPane().add(logo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 50));

        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, -1, 50));

        logo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Crop Rotation (Transparent).png"))); // NOI18N
        logo5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(logo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 80, 90));

        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 90, -1));

        jLabel4.setToolTipText("");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, -1));

        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, -1, -1));

        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, -1, -1));

        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, -1, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TOTAL PROFIT");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 430, 230, 40));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("CROP ROTATION");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 260, 40));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("CROP COSTS");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 210, 40));

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 40)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("CROPS");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 150, 40));

        logo7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Crop Costs (Transparent).png"))); // NOI18N
        logo7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(logo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 100, 80));

        logo8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Total Profit.png"))); // NOI18N
        logo8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(logo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 410, -1, 80));

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("CROP SALES");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 300, 200, 40));

        jButton3.setBackground(new java.awt.Color(102, 153, 0));
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 380, 110));

        jButton4.setBackground(new java.awt.Color(102, 153, 0));
        jButton4.setBorderPainted(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 380, 110));

        jButton10.setBackground(new java.awt.Color(102, 153, 0));
        jButton10.setBorderPainted(false);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 440, 110));

        logo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Crop Sales (Transparent).png"))); // NOI18N
        logo6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(logo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, -1, 90));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dATE.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 60, 60));

        jButton11.setBackground(new java.awt.Color(102, 153, 0));
        jButton11.setBorderPainted(false);
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 380, 110));

        jButton12.setBackground(new java.awt.Color(102, 153, 0));
        jButton12.setBorderPainted(false);
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, 380, 110));

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

        logo9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/User Icon.png"))); // NOI18N
        logo9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(logo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, -1, 50));

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
        getContentPane().add(vd_vc_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, -1, 30));

        btn_ad_cp_User2.setBorder(null);
        btn_ad_cp_User2.setBorderPainted(false);
        btn_ad_cp_User2.setContentAreaFilled(false);
        btn_ad_cp_User2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ad_cp_User2.setFocusPainted(false);
        btn_ad_cp_User2.setFocusable(false);
        btn_ad_cp_User2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ad_cp_User2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ad_cp_User2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 60, 70));

        jLabel17.setBackground(new java.awt.Color(0, 51, 102, 150));
        jLabel17.setOpaque(true);
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 900, 450));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG2.png"))); // NOI18N
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        new vd_viewcrops(loggedInFarmerId, showfirstname, botanicfam_code, plotlandcode, total_sales, total_costs).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new vd_viewcroprotation(loggedInFarmerId, showfirstname, botanicfam_code, plotlandcode, total_sales, total_costs).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        new vd_viewcropsales(loggedInFarmerId, showfirstname, botanicfam_code, plotlandcode, total_sales, total_costs).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new vd_viewcropcosts(loggedInFarmerId, showfirstname, botanicfam_code, plotlandcode, total_sales, total_costs).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        new vd_viewtotalprofit(loggedInFarmerId, showfirstname, botanicfam_code, plotlandcode, total_sales, total_costs).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void vd_vc_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vd_vc_backActionPerformed
        new insidelogin(loggedInFarmerId, showfirstname, getemail, botanicfam_code, plotlandcode, total_sales, total_costs, getrtdate).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_vd_vc_backActionPerformed

    private void btn_ad_cp_User2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ad_cp_User2ActionPerformed
        new user(loggedInFarmerId, showfirstname, botanicfam_code).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_ad_cp_User2ActionPerformed

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
            java.util.logging.Logger.getLogger(vd_viewfarmdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vd_viewfarmdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vd_viewfarmdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vd_viewfarmdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        int loggedInFarmerId = 0;
                int botanicfam_code = 0;
                int plotlandcode = 0;
                String total_sales = null;
                String total_costs = null;
                String showfirstname = null;
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vd_viewfarmdata(loggedInFarmerId, showfirstname, botanicfam_code, plotlandcode, total_sales, total_costs).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ad_cp_User2;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel logo4;
    private javax.swing.JLabel logo5;
    private javax.swing.JLabel logo6;
    private javax.swing.JLabel logo7;
    private javax.swing.JLabel logo8;
    private javax.swing.JLabel logo9;
    private javax.swing.JLabel rtDate;
    private javax.swing.JLabel rtTime;
    private javax.swing.JButton vd_vc_back;
    // End of variables declaration//GEN-END:variables
}
