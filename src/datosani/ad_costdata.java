/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosani;

import com.mysql.cj.xdevapi.Statement;
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
public class ad_costdata extends javax.swing.JFrame {
    private String showfirstname;
    private int botanicfam_code;
    private final sqlconnector dbConnection;
    private int loggedInFarmerId;
    private int plotlandcode;
    private String total_sales;
    private String total_costs;
    private String getrtdate;
    private String getemail;
    
    
    public ad_costdata(int loggedInFarmerId, String showfirstname, int botanicfam_code, int plotlandcode){
        
        this.loggedInFarmerId = loggedInFarmerId; 
        initComponents();
        this.plotlandcode = plotlandcode;
        this.botanicfam_code = botanicfam_code;
        this.showfirstname = showfirstname;
        
        dbConnection = sqlconnector.getInstance(); 
        
        realtDate();
        realtTime();
        
        
        System.out.println("Logged in Farmer ID: " + loggedInFarmerId);
        
        int farmerid = loggedInFarmerId;
       
        
        cmb_fper.addItem("");
        cmb_fper.addItem("Kilo");
        cmb_fper.addItem("Slips");
        cmb_fper.addItem("Sack");
        
        cmb_hper.addItem("");
        cmb_hper.addItem("Kilo");
        cmb_hper.addItem("Slips");
        cmb_hper.addItem("Sack");
        
        cmb_pper.addItem("");
        cmb_pper.addItem("Kilo");
        cmb_pper.addItem("Slips");
        cmb_pper.addItem("Sack");
        
        cmb_sper.addItem("");
        cmb_sper.addItem("Kilo");
        cmb_sper.addItem("Slips");
        cmb_sper.addItem("Sack");
        
        txt_Pfertilizer.setText("0");
        txt_Pherbicide.setText("0");
        txt_Ppesticide.setText("0");
        txt_Pseed.setText("0");
        
        txt_Tufertilizer.setText("0");
        txt_Tuherbicide.setText("0");
        txt_Tupesticide.setText("0");
        txt_Tuseed.setText("0");
        
        
        
        
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

        btn_ad_cp_User2 = new javax.swing.JButton();
        logo4 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        ad_cod_Clear = new javax.swing.JButton();
        ad_cod_Save = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt_Pseed = new javax.swing.JTextField();
        cmb_fper = new javax.swing.JComboBox<>();
        txt_fertilizer = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txt_Tuseed = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txt_Pfertilizer = new javax.swing.JTextField();
        cmb_sper = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        txt_addi_cost = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txt_Tufertilizer = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txt_herbicide = new javax.swing.JTextField();
        txt_Tuherbicide = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txt_Pherbicide = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        cmb_hper = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txt_pesticide = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txt_Tupesticide = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txt_Ppesticide = new javax.swing.JTextField();
        cmb_pper = new javax.swing.JComboBox<>();
        logo10 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ad_cd_back = new javax.swing.JButton();
        rtDate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rtTime = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_ad_cp_User = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        logo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Datos-Ani Icon Logo.png"))); // NOI18N
        getContentPane().add(logo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 50));

        jSeparator5.setBackground(new java.awt.Color(0, 100, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setOpaque(true);
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 550, 2));

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

        ad_cod_Clear.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        ad_cod_Clear.setText("Clear");
        ad_cod_Clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ad_cod_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ad_cod_ClearActionPerformed(evt);
            }
        });
        getContentPane().add(ad_cod_Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 500, 100, 40));

        ad_cod_Save.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        ad_cod_Save.setText("Save");
        ad_cod_Save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ad_cod_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ad_cod_SaveActionPerformed(evt);
            }
        });
        getContentPane().add(ad_cod_Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 500, 100, 40));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("COSTS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 78, -1));

        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Used Quantity");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 250, 110, -1));

        jLabel23.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Price");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 250, 50, -1));

        txt_Pseed.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_Pseed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_PseedKeyTyped(evt);
            }
        });
        getContentPane().add(txt_Pseed, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 280, 70, 30));

        cmb_fper.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        getContentPane().add(cmb_fper, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 80, 30));

        txt_fertilizer.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        getContentPane().add(txt_fertilizer, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 160, 30));

        jLabel24.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Additional Costs");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 350, 160, -1));

        jLabel25.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Seed");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 140, -1));

        txt_Tuseed.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_Tuseed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_TuseedKeyTyped(evt);
            }
        });
        getContentPane().add(txt_Tuseed, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 280, 60, 30));

        jLabel26.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Fertilizer");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 140, -1));

        jLabel27.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Name");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 140, -1));

        txt_Pfertilizer.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_Pfertilizer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_PfertilizerKeyTyped(evt);
            }
        });
        getContentPane().add(txt_Pfertilizer, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 90, 30));

        cmb_sper.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        getContentPane().add(cmb_sper, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 280, 80, 30));

        jLabel29.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Times Used");
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 100, -1));

        txt_addi_cost.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_addi_cost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_addi_costKeyTyped(evt);
            }
        });
        getContentPane().add(txt_addi_cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 380, 130, 30));

        jLabel30.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Price");
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 50, -1));

        txt_Tufertilizer.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_Tufertilizer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_TufertilizerKeyTyped(evt);
            }
        });
        getContentPane().add(txt_Tufertilizer, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 60, 30));

        jLabel28.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Herbicide");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 140, -1));

        jLabel31.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Name");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 140, -1));

        txt_herbicide.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        getContentPane().add(txt_herbicide, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 160, 30));

        txt_Tuherbicide.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_Tuherbicide.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_TuherbicideKeyTyped(evt);
            }
        });
        getContentPane().add(txt_Tuherbicide, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 60, 30));

        jLabel32.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Times Used");
        getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 100, -1));

        txt_Pherbicide.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_Pherbicide.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_PherbicideKeyTyped(evt);
            }
        });
        getContentPane().add(txt_Pherbicide, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 90, 30));

        jLabel33.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Price");
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 50, -1));

        cmb_hper.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        getContentPane().add(cmb_hper, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, 80, 30));

        jLabel34.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Pesticide");
        getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 140, -1));

        jLabel35.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Name");
        getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 140, -1));

        txt_pesticide.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        getContentPane().add(txt_pesticide, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, 160, 30));

        jLabel36.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Times Used");
        getContentPane().add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, 100, -1));

        txt_Tupesticide.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_Tupesticide.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_TupesticideKeyTyped(evt);
            }
        });
        getContentPane().add(txt_Tupesticide, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 60, 30));

        jLabel37.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Price");
        getContentPane().add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 50, -1));

        txt_Ppesticide.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txt_Ppesticide.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_PpesticideKeyTyped(evt);
            }
        });
        getContentPane().add(txt_Ppesticide, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 90, 30));

        cmb_pper.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        getContentPane().add(cmb_pper, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 80, 30));

        logo10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/User Icon.png"))); // NOI18N
        logo10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(logo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, -1, 50));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dATE.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 60, 60));

        ad_cd_back.setBackground(new java.awt.Color(102, 153, 0));
        ad_cd_back.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        ad_cd_back.setForeground(new java.awt.Color(255, 255, 255));
        ad_cd_back.setText("BACK");
        ad_cd_back.setBorderPainted(false);
        ad_cd_back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ad_cd_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ad_cd_backActionPerformed(evt);
            }
        });
        getContentPane().add(ad_cd_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, 30));

        rtDate.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        rtDate.setForeground(new java.awt.Color(0, 100, 0));
        rtDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(rtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 140, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/TIME.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 60, 60));

        rtTime.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        rtTime.setForeground(new java.awt.Color(0, 100, 0));
        rtTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(rtTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 160, 30));

        jLabel2.setBackground(new java.awt.Color(0, 51, 102, 150));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 900, 450));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG2.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ad_cp_User2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ad_cp_User2ActionPerformed
        new user(loggedInFarmerId, showfirstname, botanicfam_code).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_ad_cp_User2ActionPerformed

    private void ad_cod_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ad_cod_ClearActionPerformed
        
        cmb_fper.setSelectedItem("");
        cmb_hper.setSelectedItem("");       
        cmb_pper.setSelectedItem("");
        cmb_sper.setSelectedItem("");
        
        txt_Pfertilizer.setText("");
        txt_Pherbicide.setText("");
        txt_Ppesticide.setText("");
        txt_Pseed.setText("");
        txt_Tufertilizer.setText("");
        txt_Tuherbicide.setText("");
        txt_Tupesticide.setText("");
        txt_Tuseed.setText("");
        txt_addi_cost.setText("");
        txt_fertilizer.setText("");
        txt_herbicide.setText("");
        txt_pesticide.setText("");
    }//GEN-LAST:event_ad_cod_ClearActionPerformed

    private void ad_cod_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ad_cod_SaveActionPerformed
        String perf, perh, perp, pers;
        String nfertilizer, nherbicide, npesticide, pfertilizer, pherbicide, ppesticide, pseed, tufertilizer,tuherbicide, tupesticide, tuseed, addicost;
        
        
        if ("".equals(txt_Pseed.getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Enter Seed Price");
        }
        else if ("".equals(txt_Tuseed.getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Enter Seed Timed of Used");
        }
        else if ("".equals(txt_addi_cost.getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Enter Additional Costs");
        }
        else if ("".equals(cmb_sper.getSelectedItem())){
            JOptionPane.showMessageDialog(new JFrame(), "Choose per Seed");
        }
        else {
            perf = (String) cmb_fper.getSelectedItem();
            perh = (String) cmb_hper.getSelectedItem();
            perp = (String) cmb_pper.getSelectedItem();
            pers = (String) cmb_sper.getSelectedItem();
        
            
            nfertilizer = txt_fertilizer.getText();
            nherbicide = txt_herbicide.getText();
            npesticide = txt_pesticide.getText();
            pfertilizer = txt_Pfertilizer.getText();
            pherbicide = txt_Pherbicide.getText();
            ppesticide = txt_Ppesticide.getText();
            pseed = txt_Pseed.getText();
            tufertilizer = txt_Tufertilizer.getText();
            tuherbicide = txt_Tuherbicide.getText();
            tupesticide = txt_Tupesticide.getText();
            tuseed = txt_Tuseed.getText();
            addicost = txt_addi_cost.getText();
        
            String pperf = pfertilizer + " / " + perf;
            String pperh = pherbicide + " / " + perh;
            String pperp = ppesticide + " / " + perp;
            String ppers = pseed + " / " + pers;
        
    try {
    // Establish database connection
    sqlconnector connector = sqlconnector.getInstance();
    Connection connection = connector.getConnection();

    
    String sql1 = "SELECT crop_code, vegetable_name FROM crops_data WHERE cpfarmer_id = ? AND cpbotanicfam_code = ? AND cpplot_land_code = ?";
    try (PreparedStatement pstmt1 = connection.prepareStatement(sql1)) {
        pstmt1.setInt(1, loggedInFarmerId);
        pstmt1.setInt(2, botanicfam_code);
        pstmt1.setInt(3, plotlandcode);

        ResultSet rs1 = pstmt1.executeQuery();
        if (rs1.next()) {
            int cropcode_sales = rs1.getInt("crop_code");
            String vegetableName = rs1.getString("vegetable_name");

            
            String sql2 = "INSERT INTO fertilizer_data (name_fertilizer, ffarmer_id, fcrop_code, price_fertilizer) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt2 = connection.prepareStatement(sql2, new String[]{"fertilizer_id"})) {
                pstmt2.setString(1, nfertilizer);
                pstmt2.setInt(2, loggedInFarmerId);
                pstmt2.setInt(3, cropcode_sales);
                pstmt2.setString(4, pperf);

                int rowsInserted2 = pstmt2.executeUpdate();
                if (rowsInserted2 > 0) {
                    int fertilizerId = -1;
                    ResultSet generatedKeys2 = pstmt2.getGeneratedKeys();
                    if (generatedKeys2.next()) {
                        fertilizerId = generatedKeys2.getInt(1);
                    } else {
                        throw new SQLException("Failed to get generated fertilizer ID.");
                    }

                   
                    String sql3 = "INSERT INTO herbicide_data (name_herbicide, hfarmer_id, hcrop_code, price_herbicide) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement pstmt3 = connection.prepareStatement(sql3, new String[]{"herbicide_id"})) {
                        pstmt3.setString(1, nherbicide);
                        pstmt3.setInt(2, loggedInFarmerId);
                        pstmt3.setInt(3, cropcode_sales);
                        pstmt3.setString(4, pperh);

                        int rowsInserted3 = pstmt3.executeUpdate();
                        if (rowsInserted3 > 0) {
                            int herbicideId = -1;
                            ResultSet generatedKeys3 = pstmt3.getGeneratedKeys();
                            if (generatedKeys3.next()) {
                                herbicideId = generatedKeys3.getInt(1);
                            } else {
                                throw new SQLException("Failed to get generated herbicide ID.");
                            }

                            // Step 4: Insert into pesticide_data table
                            String sql4 = "INSERT INTO pesticide_data (name_pesticide, pfarmer_id, pcrop_code, price_pesticide) VALUES (?, ?, ?, ?)";
                            try (PreparedStatement pstmt4 = connection.prepareStatement(sql4, new String[]{"pesticide_id"})) {
                                pstmt4.setString(1, npesticide);
                                pstmt4.setInt(2, loggedInFarmerId);
                                pstmt4.setInt(3, cropcode_sales);
                                pstmt4.setString(4, pperp);

                                int rowsInserted4 = pstmt4.executeUpdate();
                                if (rowsInserted4 > 0) {
                                    int pesticideId = -1;
                                    ResultSet generatedKeys4 = pstmt4.getGeneratedKeys();
                                    if (generatedKeys4.next()) {
                                        pesticideId = generatedKeys4.getInt(1);
                                    } else {
                                        throw new SQLException("Failed to get generated pesticide ID.");
                                    }

                                    // Step 5: Insert into seed_data table using vegetable_name as name_seed
                                    String sql5 = "INSERT INTO seed_data (sfarmer_id, scrop_code, name_seed, price_seed) VALUES (?, ?, ?, ?)";
                                        try (PreparedStatement pstmt5 = connection.prepareStatement(sql5, new String[]{"seed_id"})) {
                                        pstmt5.setInt(1, loggedInFarmerId);
                                        pstmt5.setInt(2, cropcode_sales);
                                        pstmt5.setString(3, vegetableName);
                                        pstmt5.setString(4, ppers);

                                        int rowsInserted5 = pstmt5.executeUpdate();
                                        if (rowsInserted5 > 0) {
                                            int seedId = -1;
                                            ResultSet generatedKeys5 = pstmt5.getGeneratedKeys();
                                            if (generatedKeys5.next()) {
                                                seedId = generatedKeys5.getInt(1);
                                            } else {
                                                throw new SQLException("Failed to get generated seed ID.");
                                            }

                                            // Step 6: Insert into additional_costs table
                                            String sql6 = "INSERT INTO additional_costs (addi_farmerid, addi_crop_code, total_addi_cost) VALUES (?, ?, ?)";
                                            try (PreparedStatement pstmt6 = connection.prepareStatement(sql6, new String[]{"addi_cost_id"})) {
                                                pstmt6.setInt(1, loggedInFarmerId);
                                                pstmt6.setInt(2, cropcode_sales);
                                                pstmt6.setString(3, addicost);

                                                int rowsInserted6 = pstmt6.executeUpdate();
                                                if (rowsInserted6 > 0) {
                                                    int addiCostId = -1;
                                                    ResultSet generatedKeys6 = pstmt6.getGeneratedKeys();
                                                    if (generatedKeys6.next()) {
                                                        addiCostId = generatedKeys6.getInt(1);
                                                    } else {
                                                        throw new SQLException("Failed to get generated additional cost ID.");
                                                    }

                                                    // Step 7: Update plotofland table
                                                    String sql7 = "UPDATE plotofland SET plfertilizer_code = ?, plherbicide_code = ?, plpesticide_code = ?, plseed_code = ? WHERE plot_land_code = ? AND plfarmer_id = ? AND plcrop_code = ?";
                                                    try (PreparedStatement pstmt7 = connection.prepareStatement(sql7)) {
                                                        pstmt7.setInt(1, fertilizerId);
                                                        pstmt7.setInt(2, herbicideId);
                                                        pstmt7.setInt(3, pesticideId);
                                                        pstmt7.setInt(4, seedId);
                                                        pstmt7.setInt(5, plotlandcode);
                                                        pstmt7.setInt(6, loggedInFarmerId);
                                                        pstmt7.setInt(7, cropcode_sales);

                                                        int rowsUpdated7 = pstmt7.executeUpdate();
                                                        if (rowsUpdated7 > 0) {
                                                            // Step 8: Calculate and insert into total_costs table
                                                            double dfertilizer = Double.parseDouble(pfertilizer);
                                                            double dherbicide = Double.parseDouble(pherbicide);
                                                            double dpesticide = Double.parseDouble(ppesticide);
                                                            double dseed = Double.parseDouble(pseed);
                                                            double daddicost = Double.parseDouble(addicost);
                                                            double dtufertilizer = Double.parseDouble(tufertilizer);
                                                            double dtuherbicide = Double.parseDouble(tuherbicide);
                                                            double dtupesticide = Double.parseDouble(tupesticide);
                                                            double dtuseed = Double.parseDouble(tuseed);

                                                            double totalCostValue = (dfertilizer * dtufertilizer) + (dherbicide * dtuherbicide) + (dpesticide * dtupesticide) + (dseed * dtuseed) + daddicost;
                                                            String totalcost = String.valueOf(totalCostValue);

                                                            String sql8 = "INSERT INTO total_costs (tcfarmer_id, tccrop_code, tcseed_code, tcfertilizer_code, tcpesticide_code, tcherbicide_code, qnty_seedused, qnty_fertilizerused, qnty_pesticideused, qnty_herbicideused, tcaddi_cost_code, total_cost) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                                                            try (PreparedStatement pstmt8 = connection.prepareStatement(sql8)) {
                                                                pstmt8.setInt(1, loggedInFarmerId);
                                                                pstmt8.setInt(2, cropcode_sales);
                                                                pstmt8.setInt(3, seedId);
                                                                pstmt8.setInt(4, fertilizerId);
                                                                pstmt8.setInt(5, pesticideId);
                                                                pstmt8.setInt(6, herbicideId);
                                                                pstmt8.setString(7, tuseed);
                                                                pstmt8.setString(8, tufertilizer);
                                                                pstmt8.setString(9, tupesticide);
                                                                pstmt8.setString(10, tuherbicide);
                                                                pstmt8.setInt(11, addiCostId);
                                                                pstmt8.setString(12, totalcost);

                                                                int rowsInserted8 = pstmt8.executeUpdate();
                                                                if (rowsInserted8 > 0) {
                                                                     // Step 9: Retrieve sales_code from crop_sales table
                                                            String sql9 = "SELECT sales_code, total_sales FROM crop_sales WHERE salesfarmer_id = ? AND salescrop_code = ?";
                                                            try (PreparedStatement pstmt9 = connection.prepareStatement(sql9)) {
                                                                pstmt9.setInt(1, loggedInFarmerId);
                                                                pstmt9.setInt(2, cropcode_sales);

                                                                ResultSet rs2 = pstmt9.executeQuery();
                                                                if (rs2.next()) {
                                                                    int sales_code = rs2.getInt("sales_code");
                                                                    String total_sales = rs2.getString("total_sales");

                                                                    // Step 10: Retrieve costs_code from total_costs table
                                                                    String sql10 = "SELECT costs_code, total_cost FROM total_costs WHERE tcfarmer_id = ? AND tccrop_code = ?";
                                                                    try (PreparedStatement pstmt10 = connection.prepareStatement(sql10)) {
                                                                        pstmt10.setInt(1, loggedInFarmerId);
                                                                        pstmt10.setInt(2, cropcode_sales);
                                                                 

                                                                        ResultSet rs3 = pstmt10.executeQuery();
                                                                        if (rs3.next()) {
                                                                            int costs_code = rs3.getInt("costs_code");
                                                                            String total_costs = rs3.getString("total_cost");

                                                                            // Step 11: Calculate profit and insert into crop_profit table
                                                                            double dtotal_sales = Double.parseDouble(total_sales);
                                                                            double dtotal_costs = Double.parseDouble(total_costs);
                                                                            double dtotalprofit =  dtotal_sales - dtotal_costs;
                                                                            String totalprofit = String.valueOf(dtotalprofit);
                                                                            
                                                                            String sql11 = "INSERT INTO crop_profit (profitfarmer_id, profitcrop_code, profitcrop_sales, profittotal_costs, total_profit) VALUES (?, ?, ?, ?, ?)";
                                                                            try (PreparedStatement pstmt11 = connection.prepareStatement(sql11)) {
                                                                                pstmt11.setInt(1, loggedInFarmerId);
                                                                                pstmt11.setInt(2, cropcode_sales);
                                                                                pstmt11.setInt(3, sales_code);
                                                                                pstmt11.setInt(4, costs_code);
                                                                                pstmt11.setString(5, totalprofit);

                                                                                int rowsInserted11 = pstmt11.executeUpdate();
                                                                                  if (rowsInserted11 > 0) {
                                                                                            JOptionPane.showMessageDialog(new JFrame(), "Data Added Successfully.");
                                                                                            new insidelogin(loggedInFarmerId, showfirstname, getemail, botanicfam_code, plotlandcode, total_sales, total_costs, getrtdate).setVisible(true);
                                                                                            this.dispose();
                                                                                        } else {
                                                                                            JOptionPane.showMessageDialog(new JFrame(), "Failed to insert into crop_profit.");
                                                                                        }
                                                                                    } catch (SQLException ex) {
                                                                                        JOptionPane.showMessageDialog(new JFrame(), "Error inserting into crop_profit: " + ex.getMessage());
                                                                                    }
                                                                                } else {
                                                                                    JOptionPane.showMessageDialog(new JFrame(), "Costs Code Not Found.");
                                                                                }
                                                                            } catch (SQLException ex) {
                                                                                JOptionPane.showMessageDialog(new JFrame(), "Error retrieving costs_code: " + ex.getMessage());
                                                                            }
                                                                        } else {
                                                                            JOptionPane.showMessageDialog(new JFrame(), "Sales Code Not Found.");
                                                                        }
                                                                    } catch (SQLException ex) {
                                                                        JOptionPane.showMessageDialog(new JFrame(), "Error retrieving sales_code: " + ex.getMessage());
                                                                    }
                                                                } else {
                                                                    JOptionPane.showMessageDialog(new JFrame(), "Failed to insert into total_costs.");
                                                                }
                                                            } catch (SQLException ex) {
                                                                JOptionPane.showMessageDialog(new JFrame(), "Error inserting into total_costs: " + ex.getMessage());
                                                            }
                                                        } else {
                                                            JOptionPane.showMessageDialog(new JFrame(), "Failed to update plotofland.");
                                                        }
                                                    } catch (SQLException ex) {
                                                        JOptionPane.showMessageDialog(new JFrame(), "Error updating plotofland: " + ex.getMessage());
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(new JFrame(), "Failed to insert into additional_costs.");
                                                }
                                            } catch (SQLException ex) {
                                                JOptionPane.showMessageDialog(new JFrame(), "Error inserting into additional_costs: " + ex.getMessage());
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(new JFrame(), "Failed to insert into seed_data.");
                                        }
                                    } catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(new JFrame(), "Error inserting into seed_data: " + ex.getMessage());
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(new JFrame(), "Failed to insert into pesticide_data.");
                                }
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(new JFrame(), "Error inserting into pesticide_data: " + ex.getMessage());
                            }
                        } else {
                            JOptionPane.showMessageDialog(new JFrame(), "Failed to get generated herbicide ID.");
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(new JFrame(), "Error inserting into herbicide_data: " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Failed to get generated fertilizer ID.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), "Error inserting into fertilizer_data: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Crop Code Not Found.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(new JFrame(), "Database error: " + ex.getMessage());
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(new JFrame(), "Error: " + e.getMessage());
}
        }
    
    }//GEN-LAST:event_ad_cod_SaveActionPerformed
        
    
    
    private void txt_TufertilizerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TufertilizerKeyTyped
        char qnty = evt.getKeyChar();
       if(Character.isLetter(qnty)&&!evt.isAltDown()){
           evt.consume();}
    }//GEN-LAST:event_txt_TufertilizerKeyTyped

    private void txt_TuherbicideKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TuherbicideKeyTyped
        char qnty = evt.getKeyChar();
       if(Character.isLetter(qnty)&&!evt.isAltDown()){
           evt.consume();}
    }//GEN-LAST:event_txt_TuherbicideKeyTyped

    private void txt_TupesticideKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TupesticideKeyTyped
        char qnty = evt.getKeyChar();
       if(Character.isLetter(qnty)&&!evt.isAltDown()){
           evt.consume();}
    }//GEN-LAST:event_txt_TupesticideKeyTyped

    private void txt_PfertilizerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PfertilizerKeyTyped
        if(Character.isLetter(evt.getKeyChar())){
            evt.consume();
        }
        else{
            try{
                Double.parseDouble(txt_Pfertilizer.getText()+evt.getKeyChar());
            }catch(NumberFormatException e){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txt_PfertilizerKeyTyped

    private void txt_PherbicideKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PherbicideKeyTyped
        if(Character.isLetter(evt.getKeyChar())){
            evt.consume();
        }
        else{
            try{
                Double.parseDouble(txt_Pherbicide.getText()+evt.getKeyChar());
            }catch(NumberFormatException e){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txt_PherbicideKeyTyped

    private void txt_PpesticideKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PpesticideKeyTyped
        if(Character.isLetter(evt.getKeyChar())){
            evt.consume();
        }
        else{
            try{
                Double.parseDouble(txt_Ppesticide.getText()+evt.getKeyChar());
            }catch(NumberFormatException e){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txt_PpesticideKeyTyped

    private void txt_PseedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PseedKeyTyped
        if(Character.isLetter(evt.getKeyChar())){
            evt.consume();
        }
        else{
            try{
                Double.parseDouble(txt_Pseed.getText()+evt.getKeyChar());
            }catch(NumberFormatException e){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txt_PseedKeyTyped

    private void txt_TuseedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TuseedKeyTyped
        char qnty = evt.getKeyChar();
       if(Character.isLetter(qnty)&&!evt.isAltDown()){
           evt.consume();}
    }//GEN-LAST:event_txt_TuseedKeyTyped

    private void txt_addi_costKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_addi_costKeyTyped
        if(Character.isLetter(evt.getKeyChar())){
            evt.consume();
        }
        else{
            try{
                Double.parseDouble(txt_addi_cost.getText()+evt.getKeyChar());
            }catch(NumberFormatException e){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txt_addi_costKeyTyped

    private void ad_cd_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ad_cd_backActionPerformed
        new insidelogin(loggedInFarmerId, showfirstname, getemail, botanicfam_code, plotlandcode, total_sales, total_costs, getrtdate).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ad_cd_backActionPerformed

    private void btn_ad_cp_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ad_cp_UserActionPerformed
        new user(loggedInFarmerId, showfirstname, botanicfam_code).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_ad_cp_UserActionPerformed

    
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
            java.util.logging.Logger.getLogger(ad_costdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ad_costdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ad_costdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ad_costdata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int farmerid = 0;
                String showfirstname = null;
                int botanicfam_code = 0;
                int plotlandcode = 0;
                
                new ad_costdata(farmerid, showfirstname, botanicfam_code, plotlandcode).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ad_cd_back;
    private javax.swing.JButton ad_cod_Clear;
    private javax.swing.JButton ad_cod_Save;
    private javax.swing.JButton btn_ad_cp_User;
    private javax.swing.JButton btn_ad_cp_User2;
    private javax.swing.JComboBox<String> cmb_fper;
    private javax.swing.JComboBox<String> cmb_hper;
    private javax.swing.JComboBox<String> cmb_pper;
    private javax.swing.JComboBox<String> cmb_sper;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel logo10;
    private javax.swing.JLabel logo4;
    private javax.swing.JLabel rtDate;
    private javax.swing.JLabel rtTime;
    private javax.swing.JTextField txt_Pfertilizer;
    private javax.swing.JTextField txt_Pherbicide;
    private javax.swing.JTextField txt_Ppesticide;
    private javax.swing.JTextField txt_Pseed;
    private javax.swing.JTextField txt_Tufertilizer;
    private javax.swing.JTextField txt_Tuherbicide;
    private javax.swing.JTextField txt_Tupesticide;
    private javax.swing.JTextField txt_Tuseed;
    private javax.swing.JTextField txt_addi_cost;
    private javax.swing.JTextField txt_fertilizer;
    private javax.swing.JTextField txt_herbicide;
    private javax.swing.JTextField txt_pesticide;
    // End of variables declaration//GEN-END:variables
}
