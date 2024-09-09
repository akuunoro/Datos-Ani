/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosani;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Russel
 */
public class vd_viewcrops extends javax.swing.JFrame {
    private final sqlconnector dbConnection;
    
    private int loggedInFarmerId;
    private String showfirstname;
    private int botanicfam_code;
    private int plotlandcode;
    private String total_sales;
    private String total_costs;
    String crop_rotate = "No"; 
    
    
    private boolean isItemInComboBox(JComboBox comboBox, String item) {
    for (int i = 0; i < comboBox.getItemCount(); i++) {
        if (comboBox.getItemAt(i).equals(item)) {
            return true;
        }
    }
    return false;
}
    
    public vd_viewcrops(int loggedInFarmerId, String showfirstname, int botanicfam_code, int plotlandcode, String total_sales, String total_costs) {      
        dbConnection = sqlconnector.getInstance(); 
        
        
        this.loggedInFarmerId = loggedInFarmerId; 
        this.showfirstname = showfirstname;
        this.plotlandcode = plotlandcode;
        this.botanicfam_code = botanicfam_code;
               
                
                
        initComponents();
        
        realtDate();
        realtTime();
        
        System.out.println("Logged in Farmer ID: " + loggedInFarmerId);
        System.out.println("Botanic Family ID: " + botanicfam_code);
        System.out.println("Plot of Land Code: " + plotlandcode);
        
       
        
        cmb_VcChcropname.addItem("");
        cmb_VcChsory.addItem("");
        
        
         
    
    try {
        sqlconnector connector = sqlconnector.getInstance();
        Connection connection = connector.getConnection();
        
        
        String sqlget1 = "SELECT vegetable_name FROM crops_data WHERE cpfarmer_id = ? AND crop_rotation = ? " +
                         "ORDER BY vegetable_name ASC;";
        try (PreparedStatement pstmt1 = connection.prepareStatement(sqlget1)) {
            pstmt1.setInt(1, loggedInFarmerId);
            pstmt1.setString(2, crop_rotate);
            ResultSet rs1 = pstmt1.executeQuery();
            while (rs1.next()) {
                
                String Chname = rs1.getString("vegetable_name");
                if (!isItemInComboBox(cmb_VcChcropname, Chname)) {
                cmb_VcChcropname.addItem(Chname);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "QueryGet1 Error: " + e.getMessage());
        }
        
       
        String sqlget2 = "SELECT cpseason FROM crops_data WHERE cpfarmer_id = ? AND crop_rotation = ? " +
                         "ORDER BY cpseason DESC;";
        try (PreparedStatement pstmt2 = connection.prepareStatement(sqlget2)) {
            pstmt2.setInt(1, loggedInFarmerId);
            pstmt2.setString(2, crop_rotate);
            ResultSet rs2 = pstmt2.executeQuery();
            while (rs2.next()) {
                String Chseasonyear = rs2.getString("cpseason");
                if (!isItemInComboBox(cmb_VcChsory, Chseasonyear)) {
                cmb_VcChsory.addItem(Chseasonyear);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "QueryGet2 Error: " + e.getMessage());
        }
        
        // Fetch crops based on rotation value
        DefaultTableModel croptbl = (DefaultTableModel) tbl_Vcrop.getModel();
        String sqlshow1 = "SELECT c.vegetable_name, c.cpseason, p.date_planted, p.date_harvest, " +
                          "b.botanical_family, c.yielded_qnty, c.crop_price " +
                          "FROM crops_data AS c " +
                          "JOIN botanicfam AS b ON c.cpbotanicfam_code = b.botanicfam_code " +
                          "JOIN plotofland AS p ON c.cpplot_land_code = p.plot_land_code " +
                          "WHERE c.cpfarmer_id = ? AND c.crop_rotation = ? " +
                          "ORDER BY cpseason DESC, vegetable_name ASC;";
        
        try (PreparedStatement pstmt3 = connection.prepareStatement(sqlshow1)) {
            pstmt3.setInt(1, loggedInFarmerId);
            pstmt3.setString(2, crop_rotate);
            
            ResultSet rs3 = pstmt3.executeQuery();
            
            // Clear table model before adding new data
            croptbl.setRowCount(0);
            
            while (rs3.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs3.getString("vegetable_name"));
                row.add(rs3.getString("cpseason"));
                row.add(rs3.getString("date_planted"));
                row.add(rs3.getString("date_harvest"));
                row.add(rs3.getString("botanical_family"));
                row.add(rs3.getString("yielded_qnty"));
                row.add(rs3.getString("crop_price"));
                croptbl.addRow(row);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "QueryGet3 Error: " + e.getMessage());
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(new JFrame(), "Database Connection Error: " + e.getMessage());
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

        jSeparator5 = new javax.swing.JSeparator();
        logo4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmb_VcChsory = new javax.swing.JComboBox<>();
        cmb_VcChcropname = new javax.swing.JComboBox<>();
        vd_vc_back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Vcrop = new javax.swing.JTable();
        btn_Vcfind = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logo10 = new javax.swing.JLabel();
        btn_CrGraph = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        rtTime = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_ad_cp_User2 = new javax.swing.JButton();
        rtDate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

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

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("CROPS");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 110, 40));

        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 90, -1));

        cmb_VcChsory.setBackground(new java.awt.Color(102, 153, 0));
        cmb_VcChsory.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        getContentPane().add(cmb_VcChsory, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 160, 30));

        cmb_VcChcropname.setBackground(new java.awt.Color(102, 153, 0));
        cmb_VcChcropname.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        cmb_VcChcropname.setBorder(null);
        cmb_VcChcropname.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(cmb_VcChcropname, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 160, 30));

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
        getContentPane().add(vd_vc_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 550, -1, 30));

        tbl_Vcrop.setBackground(new java.awt.Color(102, 153, 0));
        tbl_Vcrop.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        tbl_Vcrop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Crop Name", "Season/Year", "Planting Date", "Harvest Date", "Botanical Family", "Yielded Quantity", "Crop Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Vcrop.setGridColor(new java.awt.Color(0, 51, 0));
        tbl_Vcrop.setShowGrid(true);
        jScrollPane1.setViewportView(tbl_Vcrop);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 860, 250));

        btn_Vcfind.setBackground(new java.awt.Color(102, 153, 0));
        btn_Vcfind.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btn_Vcfind.setForeground(new java.awt.Color(255, 255, 255));
        btn_Vcfind.setText("FIND");
        btn_Vcfind.setBorderPainted(false);
        btn_Vcfind.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Vcfind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VcfindActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Vcfind, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 90, 30));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Season/ Year");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, -1, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Crop Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        logo10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/User Icon.png"))); // NOI18N
        logo10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(logo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, -1, 50));

        btn_CrGraph.setBackground(new java.awt.Color(102, 153, 0));
        btn_CrGraph.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btn_CrGraph.setForeground(new java.awt.Color(255, 255, 255));
        btn_CrGraph.setText("GRAPH");
        btn_CrGraph.setBorderPainted(false);
        btn_CrGraph.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_CrGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CrGraphActionPerformed(evt);
            }
        });
        getContentPane().add(btn_CrGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, 90, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dATE.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 60, 60));

        rtTime.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        rtTime.setForeground(new java.awt.Color(0, 100, 0));
        rtTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(rtTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 160, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/TIME.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 60, 60));

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

        rtDate.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        rtDate.setForeground(new java.awt.Color(0, 100, 0));
        rtDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(rtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 140, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG2.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_VcfindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VcfindActionPerformed
       String selectedItem = (String) cmb_VcChcropname.getSelectedItem();
       String selectedItem2 = (String) cmb_VcChsory.getSelectedItem();
       
       
       
        if (selectedItem != null && (selectedItem2 == null || selectedItem2.isEmpty())) {
        try {
            sqlconnector connector = sqlconnector.getInstance();
            Connection connection = connector.getConnection();
            
            DefaultTableModel croptbl = (DefaultTableModel) tbl_Vcrop.getModel();
            
            String sqlshow2 = "SELECT c.vegetable_name, c.cpseason, p.date_planted, p.date_harvest, " +
                              "b.botanical_family, c.yielded_qnty, c.crop_price " +
                              "FROM crops_data AS c " +
                              "JOIN botanicfam AS b ON c.cpbotanicfam_code = b.botanicfam_code " +
                              "JOIN plotofland AS p ON c.cpplot_land_code = p.plot_land_code " +
                              "WHERE c.cpfarmer_id = ? AND c.vegetable_name = ? AND c.crop_rotation = ? " +
                              "ORDER BY cpseason DESC, vegetable_name ASC";
            
            System.out.println("SQL Query: " + sqlshow2);
            
            try (PreparedStatement pstmt4 = connection.prepareStatement(sqlshow2)) {
                pstmt4.setInt(1, loggedInFarmerId);
                pstmt4.setString(2, selectedItem); 
                pstmt4.setString(3, crop_rotate);
                ResultSet rs4 = pstmt4.executeQuery();
                
                // Clear existing table data
                croptbl.setRowCount(0);
                
                while (rs4.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rs4.getString("vegetable_name"));
                    row.add(rs4.getString("cpseason"));
                    row.add(rs4.getString("date_planted"));
                    row.add(rs4.getString("date_harvest"));
                    row.add(rs4.getString("botanical_family"));
                    row.add(rs4.getString("yielded_qnty"));
                    row.add(rs4.getString("crop_price"));
                    croptbl.addRow(row);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new JFrame(), "Query Error: " + e.getMessage());
                 
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Database Connection Error: " + e.getMessage());
        }
        
        
    }else if (selectedItem2 != null && (selectedItem == null || selectedItem.isEmpty())) {
           
        try {
            sqlconnector connector = sqlconnector.getInstance();
            Connection connection = connector.getConnection();
            
            DefaultTableModel croptbl = (DefaultTableModel) tbl_Vcrop.getModel();
            
            String sqlshow3 = "SELECT c.vegetable_name, c.cpseason, p.date_planted, p.date_harvest, " +
                              "b.botanical_family, c.yielded_qnty, c.crop_price " +
                              "FROM crops_data AS c " +
                              "JOIN botanicfam AS b ON c.cpbotanicfam_code = b.botanicfam_code " +
                              "JOIN plotofland AS p ON c.cpplot_land_code = p.plot_land_code " +
                              "WHERE c.cpfarmer_id = ? AND c.cpseason = ? AND c.crop_rotation = ? " +
                              "ORDER BY cpseason DESC, vegetable_name ASC";
            
            System.out.println("SQL Query: " + sqlshow3);
            
            try (PreparedStatement pstmt5 = connection.prepareStatement(sqlshow3)) {      
                pstmt5.setInt(1, loggedInFarmerId);
                pstmt5.setString(2, selectedItem2); 
                pstmt5.setString(3, crop_rotate);
                ResultSet rs5 = pstmt5.executeQuery();
                
                // Clear existing table data
                croptbl.setRowCount(0);
                
                while (rs5.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rs5.getString("vegetable_name"));
                    row.add(rs5.getString("cpseason"));
                    row.add(rs5.getString("date_planted"));
                    row.add(rs5.getString("date_harvest"));
                    row.add(rs5.getString("botanical_family"));
                    row.add(rs5.getString("yielded_qnty"));
                    row.add(rs5.getString("crop_price"));
                    croptbl.addRow(row);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new JFrame(), "Query Error: " + e.getMessage());
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Database Connection Error: " + e.getMessage());
        }
    }else if (selectedItem != null && selectedItem2 != null){
        try {
            sqlconnector connector = sqlconnector.getInstance();
            Connection connection = connector.getConnection();
            
            DefaultTableModel croptbl = (DefaultTableModel) tbl_Vcrop.getModel();
            
            String sqlshow4 = "SELECT c.vegetable_name, c.cpseason, p.date_planted, p.date_harvest, " +
                              "b.botanical_family, c.yielded_qnty, c.crop_price " +
                              "FROM crops_data AS c " +
                              "JOIN botanicfam AS b ON c.cpbotanicfam_code = b.botanicfam_code " +
                              "JOIN plotofland AS p ON c.cpplot_land_code = p.plot_land_code " +
                              "WHERE c.cpfarmer_id = ? AND c.vegetable_name = ? AND c.cpseason = ? AND c.crop_rotation = ? " +
                              "ORDER BY cpseason DESC, vegetable_name ASC";
            
            System.out.println("SQL Query: " + sqlshow4);
            
            try (PreparedStatement pstmt6 = connection.prepareStatement(sqlshow4)) {  
                pstmt6.setInt(1, loggedInFarmerId);
                pstmt6.setString(2, selectedItem); 
                pstmt6.setString(3, selectedItem2);
                pstmt6.setString(4, crop_rotate);
                ResultSet rs6 = pstmt6.executeQuery();
                
                // Clear existing table data
                croptbl.setRowCount(0);
                
                while (rs6.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rs6.getString("vegetable_name"));
                    row.add(rs6.getString("cpseason"));
                    row.add(rs6.getString("date_planted"));
                    row.add(rs6.getString("date_harvest"));
                    row.add(rs6.getString("botanical_family"));
                    row.add(rs6.getString("yielded_qnty"));
                    row.add(rs6.getString("crop_price"));
                    croptbl.addRow(row);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new JFrame(), "Query Error: " + e.getMessage());
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Database Connection Error: " + e.getMessage());
        }
    }

    }//GEN-LAST:event_btn_VcfindActionPerformed

    private void vd_vc_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vd_vc_backActionPerformed
        new vd_viewfarmdata(loggedInFarmerId, showfirstname, botanicfam_code, plotlandcode, total_sales, total_costs).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_vd_vc_backActionPerformed

    private void btn_ad_cp_User2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ad_cp_User2ActionPerformed
        new user(loggedInFarmerId, showfirstname, botanicfam_code).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_ad_cp_User2ActionPerformed

    private void btn_CrGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CrGraphActionPerformed

        sqlconnector connector = sqlconnector.getInstance();
        Connection connection = connector.getConnection();
        
        String sqlcropgraphget = "SELECT cpseason, SUM(yielded_qnty) AS yielded_qnty " +
                                  "FROM crops_data " +
                                  "WHERE cpfarmer_id = ? AND crop_rotation = ? " +
                                  "GROUP BY cpseason " +
                                  "ORDER BY cpseason ASC";

        System.out.println("SQL Query: " + sqlcropgraphget);

        try (PreparedStatement pstmtcropgraph = connection.prepareStatement(sqlcropgraphget)) {
            pstmtcropgraph.setInt(1, loggedInFarmerId);
            pstmtcropgraph.setString(2, crop_rotate);

            ResultSet rscropgraph = pstmtcropgraph.executeQuery();

            DefaultCategoryDataset vdcropgraph = new DefaultCategoryDataset();

            while (rscropgraph.next()) {
                String seasonoryear = rscropgraph.getString("cpseason") ;
                double dcrop = rscropgraph.getDouble("yielded_qnty");

                System.out.println("Season/Year: " + seasonoryear);
                System.out.println("Total Yielded Quantity: " + dcrop);

                vdcropgraph.setValue(dcrop, "Overall Yielded Quantity", seasonoryear);
            }

            JFreeChart cropbarchart = ChartFactory.createBarChart3D("CROPS' YIELDED QUANTITY", "Season/Year", "Total Yielded Quantity", vdcropgraph, PlotOrientation.VERTICAL, true, true, false);

            CategoryPlot plot = (CategoryPlot) cropbarchart.getPlot();
            BarRenderer renderer = (BarRenderer) plot.getRenderer();
            renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());

            // Ni-mamake sure na ma-s-set yung legends to visible
            renderer.setBarPainter(new StandardBarPainter());
            renderer.setItemLabelsVisible(true);
            renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
            renderer.setItemLabelFont(new Font("SansSerif", Font.BOLD, 12));
            renderer.setItemLabelPaint(Color.BLACK);

            // Color for bars
            renderer.setSeriesPaint(0, new Color(0,153,0));

            // Color Background Chart
            plot.setBackgroundPaint(new Color(153,153,255));

            // Change Fonts and Bold
            cropbarchart.getTitle().setFont(new Font("SansSerif", Font.BOLD, 20));
            cropbarchart.getCategoryPlot().getDomainAxis().setLabelFont(new Font("SansSerif", Font.BOLD, 14));
            cropbarchart.getCategoryPlot().getRangeAxis().setLabelFont(new Font("SansSerif", Font.BOLD, 14));
            cropbarchart.getCategoryPlot().getDomainAxis().setTickLabelFont(new Font("SansSerif", Font.BOLD, 12));
            cropbarchart.getCategoryPlot().getRangeAxis().setTickLabelFont(new Font("SansSerif", Font.BOLD, 12));

            plot.setRangeGridlinePaint(Color.BLACK);

            //black bg
            ChartPanel chartPanel = new ChartPanel(cropbarchart);
            chartPanel.setBackground(new Color(0,0,0,0));

            // the panel
            ChartFrame cropframe = new ChartFrame("Datos-Ani: Crops' Yielded Quantity Bar Graph", cropbarchart);
            cropframe.getContentPane().setBackground(new Color(0,0,0,0));
            cropframe.setContentPane(chartPanel);
            cropframe.setSize(900, 500);
            cropframe.setLocationRelativeTo(null);
            cropframe.setVisible(true);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Query Error: " + e.getMessage());
        }

    }//GEN-LAST:event_btn_CrGraphActionPerformed

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
            java.util.logging.Logger.getLogger(vd_viewcrops.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vd_viewcrops.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vd_viewcrops.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vd_viewcrops.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
            
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                int loggedInFarmerId = 0;
                String showfirstname = null;
                int botanicfam_code = 0;
                int plotlandcode = 0;
                String total_sales = null;
                String total_costs = null;
                
                
    
                                
                new vd_viewcrops(loggedInFarmerId, showfirstname, botanicfam_code, plotlandcode, total_sales, total_costs).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CrGraph;
    private javax.swing.JButton btn_Vcfind;
    private javax.swing.JButton btn_ad_cp_User2;
    private javax.swing.JComboBox<String> cmb_VcChcropname;
    private javax.swing.JComboBox<String> cmb_VcChsory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel logo10;
    private javax.swing.JLabel logo4;
    private javax.swing.JLabel rtDate;
    private javax.swing.JLabel rtTime;
    private javax.swing.JTable tbl_Vcrop;
    private javax.swing.JButton vd_vc_back;
    // End of variables declaration//GEN-END:variables
}
