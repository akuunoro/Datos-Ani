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

/**
 *
 * @author Russel
 */
public class ad_cropdata extends javax.swing.JFrame {
    private String showfirstname;
    private String getemail;
    private final sqlconnector dbConnection;
    private int botanicfam_code;
    private int plotlandcode;
    private String Ncropprice;
    private int crop_code;
    private String total_sales;
    private String total_costs;
    private String getrtdate;
    
    private int loggedInFarmerId;
    /**
     * Creates new form add_data
     */
    public ad_cropdata(int loggedInFarmerId, String showfirstname, int botanicfam_code) {
        this.loggedInFarmerId = loggedInFarmerId; 
        this.showfirstname = showfirstname;
        this.botanicfam_code = botanicfam_code;
        initComponents();
        dbConnection = sqlconnector.getInstance(); 
       
        int farmerid = loggedInFarmerId;
        
        realtDate();
        realtTime();
        
        System.out.println("Logged in Farmer ID: " + loggedInFarmerId);
        
        cmb_plantdate.addItem("");
        cmb_plantdate.addItem("January");
        cmb_plantdate.addItem("February");
        cmb_plantdate.addItem("March");
        cmb_plantdate.addItem("April");
        cmb_plantdate.addItem("May");
        cmb_plantdate.addItem("June");
        cmb_plantdate.addItem("July");
        cmb_plantdate.addItem("August");
        cmb_plantdate.addItem("September");
        cmb_plantdate.addItem("October");
        cmb_plantdate.addItem("November");
        cmb_plantdate.addItem("December");
        
        cmb_harvestdate.addItem("");
        cmb_harvestdate.addItem("January");
        cmb_harvestdate.addItem("February");
        cmb_harvestdate.addItem("March");
        cmb_harvestdate.addItem("April");
        cmb_harvestdate.addItem("May");
        cmb_harvestdate.addItem("June");
        cmb_harvestdate.addItem("July");
        cmb_harvestdate.addItem("August");
        cmb_harvestdate.addItem("September");
        cmb_harvestdate.addItem("October");
        cmb_harvestdate.addItem("November");
        cmb_harvestdate.addItem("December");
        
        cmb_priceper.addItem("");
        cmb_priceper.addItem("sack");
        cmb_priceper.addItem("piece");
        cmb_priceper.addItem("bundle");
        
        cmb_yplantdate.addItem("");
        for (int i = 2025; i >= 2000; i--) {
            cmb_yplantdate.addItem(String.valueOf(i));
        }
        
        cmb_yharvestdate.addItem("");
        for (int i = 2025; i >= 2000; i--) {
            cmb_yharvestdate.addItem(String.valueOf(i));
        }
        
        cmb_sory.addItem("");
        for (int i = 2025; i >= 2000; i--) {
            cmb_sory.addItem(String.valueOf(i));
        }
        
        cmb_croprotation.addItem("");
        cmb_croprotation.addItem("Yes");
        cmb_croprotation.addItem("No");
        
       
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
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_ad_cp_User = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txt_yieldedqnty = new javax.swing.JTextField();
        txt_cropname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_cropprice = new javax.swing.JTextField();
        cmb_priceper = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmb_yplantdate = new javax.swing.JComboBox<>();
        cmb_plantdate = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cmb_harvestdate = new javax.swing.JComboBox<>();
        cmb_yharvestdate = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cmb_sory = new javax.swing.JComboBox<>();
        cmb_croprotation = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        ad_cd_Clear = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        ad_cd_Save = new javax.swing.JButton();
        logo10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        rtDate = new javax.swing.JLabel();
        rtTime = new javax.swing.JLabel();
        vd_vc_back = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btn_insidelogin_User = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator3.setBackground(new java.awt.Color(0, 100, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setOpaque(true);
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 550, 2));

        logo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Datos-Ani Icon Logo.png"))); // NOI18N
        getContentPane().add(logo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 50));

        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, -1, 50));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 70, 70));

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

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ADD CROP DATA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOpaque(true);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 188, 490, -1));

        txt_yieldedqnty.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_yieldedqnty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_yieldedqntyKeyTyped(evt);
            }
        });
        getContentPane().add(txt_yieldedqnty, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 120, 40));

        txt_cropname.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        getContentPane().add(txt_cropname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 300, 40));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Crop Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 200, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Planting Date");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 140, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Price");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 140, -1));

        txt_cropprice.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_cropprice.setToolTipText("");
        txt_cropprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_croppriceKeyTyped(evt);
            }
        });
        getContentPane().add(txt_cropprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 120, 40));

        cmb_priceper.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        getContentPane().add(cmb_priceper, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, 110, 40));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Per");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, 140, -1));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Yielded Quantity");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 140, -1));

        cmb_yplantdate.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        getContentPane().add(cmb_yplantdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 240, 110, 40));

        cmb_plantdate.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        cmb_plantdate.setMaximumRowCount(12);
        getContentPane().add(cmb_plantdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, 110, 40));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Harvest Date");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, 140, -1));

        cmb_harvestdate.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        cmb_harvestdate.setMaximumRowCount(12);
        getContentPane().add(cmb_harvestdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 110, 40));

        cmb_yharvestdate.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        getContentPane().add(cmb_yharvestdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 330, 110, 40));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Crop Rotation");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 390, 140, -1));

        cmb_sory.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        getContentPane().add(cmb_sory, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 420, 110, 40));

        cmb_croprotation.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        getContentPane().add(cmb_croprotation, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 420, 110, 40));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Season/ Year");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 140, -1));

        ad_cd_Clear.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        ad_cd_Clear.setText("Clear");
        ad_cd_Clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ad_cd_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ad_cd_ClearActionPerformed(evt);
            }
        });
        getContentPane().add(ad_cd_Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 500, 100, 40));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, -1, -1));

        ad_cd_Save.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        ad_cd_Save.setText("Save");
        ad_cd_Save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ad_cd_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ad_cd_SaveActionPerformed(evt);
            }
        });
        getContentPane().add(ad_cd_Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 500, 100, 40));

        logo10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/User Icon.png"))); // NOI18N
        logo10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(logo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, -1, 50));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dATE.png"))); // NOI18N
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 60, 60));

        jLabel13.setBackground(new java.awt.Color(0, 51, 102, 150));
        jLabel13.setOpaque(true);
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 820, 450));

        rtDate.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        rtDate.setForeground(new java.awt.Color(0, 100, 0));
        rtDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(rtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 140, 30));

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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/TIME.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 60, 60));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG2.png"))); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btn_insidelogin_User.setBorder(null);
        btn_insidelogin_User.setBorderPainted(false);
        btn_insidelogin_User.setContentAreaFilled(false);
        btn_insidelogin_User.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_insidelogin_User.setFocusPainted(false);
        btn_insidelogin_User.setFocusable(false);
        btn_insidelogin_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insidelogin_UserActionPerformed(evt);
            }
        });
        getContentPane().add(btn_insidelogin_User, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 60, 70));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ad_cd_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ad_cd_ClearActionPerformed
        txt_cropname.setText("");
        txt_yieldedqnty.setText("");
        txt_cropprice.setText("");
        cmb_priceper.setSelectedItem(""); 
        cmb_plantdate.setSelectedItem("");
        cmb_yplantdate.setSelectedItem("");
        cmb_harvestdate.setSelectedItem("");
        cmb_yharvestdate.setSelectedItem("");
        cmb_sory.setSelectedItem("");
        cmb_croprotation.setSelectedItem("");
        
    }//GEN-LAST:event_ad_cd_ClearActionPerformed

    private void ad_cd_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ad_cd_SaveActionPerformed
        String cropname, yieldedqnty, cropprice, mplantdate, yplantdate, mharvestdate, yharvestdate, sory, croprotation;
        String peryq, percp;
        
        if ("".equals(txt_cropname.getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Enter Crop Name");
        }
        else if ("".equals(txt_yieldedqnty.getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Enter Yielded Quantity");
        }
        else if ("".equals(txt_cropprice.getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Enter Crop Price");
        }
        else if ("".equals(cmb_priceper.getSelectedItem())){
            JOptionPane.showMessageDialog(new JFrame(), "Choose Per Price");
        }
        else if ("".equals(cmb_plantdate.getSelectedItem())){
            JOptionPane.showMessageDialog(new JFrame(), "Choose Planting Month");
        }
        else if ("".equals(cmb_yplantdate.getSelectedItem())){
            JOptionPane.showMessageDialog(new JFrame(), "Choose Planting Year");
        }
        else if ("".equals(cmb_harvestdate.getSelectedItem())){
            JOptionPane.showMessageDialog(new JFrame(), "Choose Harvest Month");
        }
        else if ("".equals(cmb_yharvestdate.getSelectedItem())){
            JOptionPane.showMessageDialog(new JFrame(), "Choose Harvest Year");
        }
        else if ("".equals(cmb_sory.getSelectedItem())){
            JOptionPane.showMessageDialog(new JFrame(), "Choose Season or Year");
        }
        else if ("".equals(cmb_croprotation.getSelectedItem())){
            JOptionPane.showMessageDialog(new JFrame(), "Choose Crop Rotation Status");
        }
        else{
            cropname = txt_cropname.getText();
            
            yieldedqnty = txt_yieldedqnty.getText();
            
            String yq = yieldedqnty;
            
            cropprice = txt_cropprice.getText();
            percp = (String) cmb_priceper.getSelectedItem();
            
            String cp = cropprice + " / " + percp;
          
            mplantdate = (String) cmb_plantdate.getSelectedItem();            
            yplantdate = (String) cmb_yplantdate.getSelectedItem();        
            String plantdate = mplantdate + "-" + yplantdate;
            
            mharvestdate = (String) cmb_harvestdate.getSelectedItem();           
            yharvestdate = (String) cmb_yharvestdate.getSelectedItem();
            String harvestdate = mharvestdate + "-" + yharvestdate;
            
            sory = (String) cmb_sory.getSelectedItem();
            
            croprotation = (String) cmb_croprotation.getSelectedItem();
            
            
            Ncropprice = cropprice;
            
            Random Fcrop_numf = new Random();
            int Fcrop_numberf = 10000 + Fcrop_numf.nextInt(90000);
            
            Random Fcrop_nums = new Random();
            int Fcrop_numbers = 100 + Fcrop_nums.nextInt(999);
            
            String uk_Fcrop_num = String.valueOf(Fcrop_numberf) + "-" + loggedInFarmerId + "-" + String.valueOf(Fcrop_numbers);

            sqlconnector connector = sqlconnector.getInstance();
            Connection connection = connector.getConnection();

            String sql1 = "SELECT botanicfam_code FROM botanicfam WHERE botanicfam_crops = ?";
            String sql2 = "INSERT INTO crops_data (uk_cropidentifier, vegetable_name, cpfarmer_id, cpbotanicfam_code, cpseason, crop_rotation, yielded_qnty, crop_price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            String sql3 = "SELECT crop_code FROM crops_data WHERE uk_cropidentifier = ? AND cpfarmer_id = ? AND cpbotanicfam_code = ?";
            String sql4 = "INSERT INTO plotofland (plfarmer_id, plcrop_code, date_planted, date_harvest) VALUES (?, ?, ?, ?)";
            String sql5 = "SELECT plot_land_code FROM plotofland WHERE plfarmer_id = ? AND plcrop_code = ?";
            String sql6 = "UPDATE crops_data SET cpplot_land_code = ? WHERE crop_code = ? AND uk_cropidentifier = ? AND cpfarmer_id = ? AND cpbotanicfam_code = ?";

        try {

            // Step 1: Retrieve botanic family code
            try (PreparedStatement pstmt1 = connection.prepareStatement(sql1)) {
                pstmt1.setString(1, cropname);
                try (ResultSet rs1 = pstmt1.executeQuery()) {
                    if (rs1.next()) {
                        botanicfam_code = rs1.getInt("botanicfam_code");
                    } else {
                        JOptionPane.showMessageDialog(null, "Botanic family code not found for the specified crop.");
                        return;
                    }
                }
            }

            // Step 2: Insert into crops_data table
            try (PreparedStatement pstmt2 = connection.prepareStatement(sql2)) {
                pstmt2.setString(1, uk_Fcrop_num);
                pstmt2.setString(2, cropname);
                pstmt2.setInt(3, loggedInFarmerId);
                pstmt2.setInt(4, botanicfam_code);
                pstmt2.setString(5, sory);
                pstmt2.setString(6, croprotation);
                pstmt2.setString(7, yq);
                pstmt2.setString(8, cp);

                int rowsInserted2 = pstmt2.executeUpdate();

                if (rowsInserted2 <= 0) {
                    JOptionPane.showMessageDialog(null, "Can't add data to crops_data.");
                    return;
                }
            }

            // Step 3: Retrieve crop code
            try (PreparedStatement pstmt3 = connection.prepareStatement(sql3)) {
                pstmt3.setString(1, uk_Fcrop_num);
                pstmt3.setInt(2, loggedInFarmerId);
                pstmt3.setInt(3, botanicfam_code);
                try (ResultSet rs3 = pstmt3.executeQuery()) {
                    if (rs3.next()) {
                        crop_code = rs3.getInt("crop_code");
                    } else {
                        JOptionPane.showMessageDialog(null, "Can't retrieve crop code.");
                        return;
                    }
                }
            }

            // Step 4: Insert into plotofland table
            try (PreparedStatement pstmt4 = connection.prepareStatement(sql4)) {
                pstmt4.setInt(1, loggedInFarmerId);
                pstmt4.setInt(2, crop_code);
                pstmt4.setString(3, plantdate);
                pstmt4.setString(4, harvestdate);

                int rowsInserted4 = pstmt4.executeUpdate();

                if (rowsInserted4 <= 0) {
                    JOptionPane.showMessageDialog(null, "Can't add data to plotofland.");
                    return;
                }
            }

            // Step 5: Retrieve plot_land_code
            try (PreparedStatement pstmt5 = connection.prepareStatement(sql5)) {
                pstmt5.setInt(1, loggedInFarmerId);
                pstmt5.setInt(2, crop_code);
                try (ResultSet rs5 = pstmt5.executeQuery()) {
                    if (rs5.next()) {
                        plotlandcode = rs5.getInt("plot_land_code");
                    } else {
                        JOptionPane.showMessageDialog(null, "Can't retrieve plot land code.");
                        return;
                    }
                }
            }

            // Step 6: Update cpplot_land_code in crops_data
            try (PreparedStatement pstmt6 = connection.prepareStatement(sql6)) {
                pstmt6.setInt(1, plotlandcode);
                pstmt6.setInt(2, crop_code);
                pstmt6.setString(3, uk_Fcrop_num);
                pstmt6.setInt(4, loggedInFarmerId);
                pstmt6.setInt(5, botanicfam_code);

                int rowsUpdated = pstmt6.executeUpdate();

                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Data Added Successfully.");
                    new ad_salesdata(loggedInFarmerId, showfirstname, Ncropprice, botanicfam_code, plotlandcode).setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update cpplot_land_code in crops_data.");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ad_cropdata.class.getName()).log(Level.SEVERE, "Database error", ex);
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
        }
    }
    }//GEN-LAST:event_ad_cd_SaveActionPerformed

    private void txt_yieldedqntyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_yieldedqntyKeyTyped
       char qnty = evt.getKeyChar();
       if(Character.isLetter(qnty)&&!evt.isAltDown()){
           evt.consume();
       }
    }//GEN-LAST:event_txt_yieldedqntyKeyTyped

    private void txt_croppriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_croppriceKeyTyped
        if(Character.isLetter(evt.getKeyChar())){
            evt.consume();
        }
        else{
            try{
                Double.parseDouble(txt_cropprice.getText()+evt.getKeyChar());
            }catch(NumberFormatException e){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txt_croppriceKeyTyped

    private void vd_vc_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vd_vc_backActionPerformed
        new insidelogin(loggedInFarmerId, showfirstname, getemail, botanicfam_code, plotlandcode, total_sales, total_costs, getrtdate).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_vd_vc_backActionPerformed

    private void btn_insidelogin_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insidelogin_UserActionPerformed
        new user(loggedInFarmerId, showfirstname, botanicfam_code).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_insidelogin_UserActionPerformed

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
            java.util.logging.Logger.getLogger(ad_cropdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ad_cropdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ad_cropdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ad_cropdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int farmerid = 1;
                String showfirstname = null;
                int botanicfam_code = 0;
                new ad_cropdata(farmerid, showfirstname, botanicfam_code).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ad_cd_Clear;
    private javax.swing.JButton ad_cd_Save;
    private javax.swing.JButton btn_ad_cp_User;
    private javax.swing.JButton btn_insidelogin_User;
    private javax.swing.JComboBox<String> cmb_croprotation;
    private javax.swing.JComboBox<String> cmb_harvestdate;
    private javax.swing.JComboBox<String> cmb_plantdate;
    private javax.swing.JComboBox<String> cmb_priceper;
    private javax.swing.JComboBox<String> cmb_sory;
    private javax.swing.JComboBox<String> cmb_yharvestdate;
    private javax.swing.JComboBox<String> cmb_yplantdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel logo10;
    private javax.swing.JLabel logo2;
    private javax.swing.JLabel rtDate;
    private javax.swing.JLabel rtTime;
    private javax.swing.JTextField txt_cropname;
    private javax.swing.JTextField txt_cropprice;
    private javax.swing.JTextField txt_yieldedqnty;
    private javax.swing.JButton vd_vc_back;
    // End of variables declaration//GEN-END:variables
}
