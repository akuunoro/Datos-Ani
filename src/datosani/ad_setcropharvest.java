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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class ad_setcropharvest extends javax.swing.JFrame {
    private String getemail;
    private final sqlconnector dbConnection;
    private int loggedInFarmerId;
    private String showfirstname;
    private int plotlandcode;
    private int botanicfam_code;
    private String total_sales;
    private String total_costs;
    private String getrtdate;
    
    private int botanicfam_codecr;
    
    
    public ad_setcropharvest(int loggedInFarmerId, String showfirstname, int botanicfam_code) {
        this.loggedInFarmerId = loggedInFarmerId;
        this.showfirstname = showfirstname;
        this.botanicfam_code = botanicfam_code;
        
        
        initComponents();
        
        dbConnection = sqlconnector.getInstance(); 
        
        realtDate();
        realtTime();
        
        cmb_chplantdate.addItem("");
        cmb_chplantdate.addItem("January");
        cmb_chplantdate.addItem("February");
        cmb_chplantdate.addItem("March");
        cmb_chplantdate.addItem("April");
        cmb_chplantdate.addItem("May");
        cmb_chplantdate.addItem("June");
        cmb_chplantdate.addItem("July");
        cmb_chplantdate.addItem("August");
        cmb_chplantdate.addItem("September");
        cmb_chplantdate.addItem("October");
        cmb_chplantdate.addItem("November");
        cmb_chplantdate.addItem("December");
        
        cmb_chplantyear.addItem("");
        for (int i = 2030; i >= 2000; i--) {
            cmb_chplantyear.addItem(String.valueOf(i));
        }
        
        
        
        
        
        
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
        logo2 = new javax.swing.JLabel();
        btn_add_User = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txt_chcropname = new javax.swing.JTextField();
        cmb_chplantdate = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmb_chplantyear = new javax.swing.JComboBox<>();
        ad_setch_Clear = new javax.swing.JButton();
        ad_setch_Save = new javax.swing.JButton();
        vd_add_back = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        rtDate = new javax.swing.JLabel();
        rtTime = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator3.setBackground(new java.awt.Color(0, 100, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setOpaque(true);
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 550, 2));

        logo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Datos-Ani Icon Logo.png"))); // NOI18N
        getContentPane().add(logo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 50));

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

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Russel\\Downloads\\STUFSS\\1st Year - 2nd Semester\\DBMS\\Projects\\GRAPHIC DESIGN\\UI DESIGN FINAL DRAFT\\Icons\\User Icon.png")); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, -1, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Russel\\Downloads\\STUFSS\\1st Year - 2nd Semester\\DBMS\\Projects\\GRAPHIC DESIGN\\UI DESIGN FINAL DRAFT\\Icons\\Crops (Transparent).png")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, 70));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SET CROP HARVEST");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOpaque(true);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 490, 2));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Crop Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 140, -1));

        txt_chcropname.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_chcropname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_chcropnameKeyTyped(evt);
            }
        });
        getContentPane().add(txt_chcropname, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 190, 40));

        cmb_chplantdate.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        cmb_chplantdate.setMaximumRowCount(12);
        getContentPane().add(cmb_chplantdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 110, 40));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Planting Date");
        jLabel8.setToolTipText("");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 120, -1));

        cmb_chplantyear.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        cmb_chplantyear.setMaximumRowCount(12);
        getContentPane().add(cmb_chplantyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 320, 110, 40));

        ad_setch_Clear.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        ad_setch_Clear.setText("Clear");
        ad_setch_Clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ad_setch_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ad_setch_ClearActionPerformed(evt);
            }
        });
        getContentPane().add(ad_setch_Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 500, 100, 40));

        ad_setch_Save.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        ad_setch_Save.setText("Save");
        ad_setch_Save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ad_setch_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ad_setch_SaveActionPerformed(evt);
            }
        });
        getContentPane().add(ad_setch_Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 500, 100, 40));

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

        jLabel14.setBackground(new java.awt.Color(0, 51, 102, 150));
        jLabel14.setOpaque(true);
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 820, 450));

        rtDate.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        rtDate.setForeground(new java.awt.Color(0, 100, 0));
        rtDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(rtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 140, 30));

        rtTime.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        rtTime.setForeground(new java.awt.Color(0, 100, 0));
        rtTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(rtTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 190, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG2.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_add_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_UserActionPerformed
        new user(loggedInFarmerId, showfirstname, botanicfam_code).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_add_UserActionPerformed

    private void txt_chcropnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_chcropnameKeyTyped

    }//GEN-LAST:event_txt_chcropnameKeyTyped

    private void ad_setch_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ad_setch_ClearActionPerformed
        txt_chcropname.setText("");
        cmb_chplantdate.setSelectedItem("");
        cmb_chplantyear.setSelectedItem("");

    }//GEN-LAST:event_ad_setch_ClearActionPerformed

    private void ad_setch_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ad_setch_SaveActionPerformed
        String chcropname, chplantdate, chplantyear;

        if ("".equals(txt_chcropname.getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Enter Crop Name");
        }
        else if ("".equals(cmb_chplantdate.getSelectedItem())){
            JOptionPane.showMessageDialog(new JFrame(), "Enter Yielded Quantity");
        }
        else if ("".equals(cmb_chplantyear.getSelectedItem())){
            JOptionPane.showMessageDialog(new JFrame(), "Choose Per Yielded Quantity");
        }else{
            chcropname = txt_chcropname.getText();
            chplantdate = (String) cmb_chplantdate.getSelectedItem();
            chplantyear = (String) cmb_chplantyear.getSelectedItem();
            
           
            
            
            
            sqlconnector connector = sqlconnector.getInstance();
            Connection connection = connector.getConnection();
            
            String sqlgetbf = "SELECT botanicfam_code FROM botanicfam WHERE botanicfam_crops = ?";
            
            try (PreparedStatement pstmtgetbf = connection.prepareStatement(sqlgetbf)) {
                pstmtgetbf.setString(1, chcropname);
                try (ResultSet rsgetbf = pstmtgetbf.executeQuery()) {
                    if (rsgetbf.next()) {
                        botanicfam_codecr = rsgetbf.getInt("botanicfam_code");
                    } else {
                        JOptionPane.showMessageDialog(null, "Botanic family code not found for the specified crop.");
                        return;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ad_setcropharvest.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            String sql1 = "INSERT INTO schedcrop_harvest (schfarmer_id, sch_botanicfamcode, sch_cropname, sch_plantdate, sch_plantyear) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt1 = connection.prepareStatement(sql1)) {
                pstmt1.setInt(1, loggedInFarmerId);
                pstmt1.setInt(2, botanicfam_codecr);
                pstmt1.setString(3, chcropname);
                pstmt1.setString(4, chplantdate);
                pstmt1.setString (5, chplantyear);

                int rowsInserted1 = pstmt1.executeUpdate();
                if (rowsInserted1 > 0) {
                    JOptionPane.showMessageDialog(null, "Data Added Successfully.");
                    new insidelogin(loggedInFarmerId, showfirstname, getemail, botanicfam_code, plotlandcode, total_sales, total_costs, getrtdate).setVisible(true);
                    this.dispose();
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ad_cropdata.class.getName()).log(Level.SEVERE, "Database error", ex);
                JOptionPane.showMessageDialog(null, "Data Cannot Be Added: " + ex.getMessage());
            }

        }
    }//GEN-LAST:event_ad_setch_SaveActionPerformed

    private void vd_add_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vd_add_backActionPerformed
        new insidelogin(loggedInFarmerId, showfirstname, getemail, botanicfam_code, plotlandcode, total_sales, total_costs, getrtdate).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_vd_add_backActionPerformed

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
            java.util.logging.Logger.getLogger(ad_setcropharvest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ad_setcropharvest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ad_setcropharvest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ad_setcropharvest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int loggedInFarmerId = 0;
                String showfirstname = null;
                int botanicfam_code = 0;
                new ad_setcropharvest(loggedInFarmerId, showfirstname, botanicfam_code).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ad_setch_Clear;
    private javax.swing.JButton ad_setch_Save;
    private javax.swing.JButton btn_add_User;
    private javax.swing.JComboBox<String> cmb_chplantdate;
    private javax.swing.JComboBox<String> cmb_chplantyear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel logo2;
    private javax.swing.JLabel rtDate;
    private javax.swing.JLabel rtTime;
    private javax.swing.JTextField txt_chcropname;
    private javax.swing.JButton vd_add_back;
    // End of variables declaration//GEN-END:variables
}
