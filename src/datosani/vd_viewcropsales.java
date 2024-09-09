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
public class vd_viewcropsales extends javax.swing.JFrame {
    
    private final sqlconnector dbConnection;
    
   
    private int loggedInFarmerId;
    private String showfirstname;
    private int botanicfam_code;
    private int plotlandcode;
    private String total_sales;
    private String total_costs;
    
    private boolean isItemInComboBox(JComboBox comboBox, String item) {
            for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).equals(item)) {
            return true;
        }
            }
        return false;
    }
    
    
    
    
    public vd_viewcropsales(int loggedInFarmerId, String showfirstname, int botanicfam_code, int plotlandcode, String total_sales, String total_costs) {
        initComponents();
        
        
        dbConnection = sqlconnector.getInstance(); 
        
        
        realtDate();
        realtTime();
         
        this.loggedInFarmerId = loggedInFarmerId; 
        this.showfirstname = showfirstname;
        this.plotlandcode = plotlandcode;
        this.botanicfam_code = botanicfam_code;
        
        System.out.println("Logged in Farmer ID: " + loggedInFarmerId);
        System.out.println("Botanic Family ID: " + botanicfam_code);
        System.out.println("Plot of Land Code: " + plotlandcode);
        
        String croprotationy = "Yes";
        String croprotationn = "No";
                
        
        cmb_Cscropname.addItem("");
        cmb_Cssory.addItem("");
        cmb_Cscroprotation.addItem("");
        cmb_Cscroprotation.addItem(croprotationy);
        cmb_Cscroprotation.addItem(croprotationn);
        
        try {
        sqlconnector connector = sqlconnector.getInstance();
        Connection connection = connector.getConnection();
        
        // Populate crop name dropdown
        String sqlget1 = "SELECT vegetable_name FROM crops_data WHERE cpfarmer_id = ? " +
                         "ORDER BY vegetable_name ASC";
        try (PreparedStatement pstmt1 = connection.prepareStatement(sqlget1)) {
            pstmt1.setInt(1, loggedInFarmerId);
            
            ResultSet rs1 = pstmt1.executeQuery();
            while (rs1.next()) {
                
                String Chname = rs1.getString("vegetable_name");
                if (!isItemInComboBox(cmb_Cscropname, Chname)) {
                cmb_Cscropname.addItem(Chname);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "QueryGet1 Error: " + e.getMessage());
        }
        
        String sqlget2 = "SELECT cpseason FROM crops_data WHERE cpfarmer_id = ? " +
                         "ORDER BY cpseason DESC";
        try (PreparedStatement pstmt2 = connection.prepareStatement(sqlget2)) {         
            pstmt2.setInt(1, loggedInFarmerId);
            ResultSet rs2 = pstmt2.executeQuery();
            while (rs2.next()) {
                String Chseasonyear = rs2.getString("cpseason");
                if (!isItemInComboBox(cmb_Cssory, Chseasonyear)) {
                cmb_Cssory.addItem(Chseasonyear);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "QueryGet2 Error: " + e.getMessage());
        }
        
       
    DefaultTableModel croptbl = (DefaultTableModel) tbl_Cropsales.getModel();
    
    String sqlshow1 = "SELECT c.vegetable_name, c.cpseason, cs.sold_qnty, cs.total_sales " +
                      "FROM crops_data AS c " +
                      "JOIN crop_sales AS cs ON c.crop_code = cs.salescrop_code " +
                      "WHERE c.cpfarmer_id = ? " +
                      "ORDER BY cpseason DESC, vegetable_name ASC";
    
    try (PreparedStatement pstmt3 = connection.prepareStatement(sqlshow1)) {
        pstmt3.setInt(1, loggedInFarmerId);
        ResultSet rs3 = pstmt3.executeQuery();
        
        // Clear table model before adding new data
        croptbl.setRowCount(0);
        
        while (rs3.next()) {
            Vector<Object> row = new Vector<>();
            row.add(rs3.getString("vegetable_name"));
            row.add(rs3.getString("cpseason"));
            row.add(rs3.getString("sold_qnty"));
            row.add(rs3.getString("total_sales"));
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

        logo9 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        logo4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmb_Cscroprotation = new javax.swing.JComboBox<>();
        cmb_Cscropname = new javax.swing.JComboBox<>();
        btn_CrFind = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Cropsales = new javax.swing.JTable();
        cmb_Cssory = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        logo10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_ad_cp_User2 = new javax.swing.JButton();
        logo11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rtDate = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        vd_vcs_back = new javax.swing.JButton();
        rtTime = new javax.swing.JLabel();
        btn_CrGraph = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        logo9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/User Icon.png"))); // NOI18N
        logo9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
        jLabel11.setText("CROP SALES");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 220, 40));

        cmb_Cscroprotation.setBackground(new java.awt.Color(102, 153, 0));
        cmb_Cscroprotation.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        getContentPane().add(cmb_Cscroprotation, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 160, 30));

        cmb_Cscropname.setBackground(new java.awt.Color(102, 153, 0));
        cmb_Cscropname.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        cmb_Cscropname.setBorder(null);
        cmb_Cscropname.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(cmb_Cscropname, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 160, 30));

        btn_CrFind.setBackground(new java.awt.Color(102, 153, 0));
        btn_CrFind.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btn_CrFind.setForeground(new java.awt.Color(255, 255, 255));
        btn_CrFind.setText("FIND");
        btn_CrFind.setBorderPainted(false);
        btn_CrFind.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_CrFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CrFindActionPerformed(evt);
            }
        });
        getContentPane().add(btn_CrFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, 90, 30));

        tbl_Cropsales.setBackground(new java.awt.Color(102, 153, 0));
        tbl_Cropsales.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        tbl_Cropsales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Crop Name", "Season/Year", "Quantity Sold", "Total Sale"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Cropsales.setToolTipText("");
        tbl_Cropsales.setGridColor(new java.awt.Color(0, 51, 0));
        jScrollPane1.setViewportView(tbl_Cropsales);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 860, 250));

        cmb_Cssory.setBackground(new java.awt.Color(102, 153, 0));
        cmb_Cssory.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        getContentPane().add(cmb_Cssory, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 160, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dATE.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 60, 60));

        logo10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/User Icon.png"))); // NOI18N
        logo10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(logo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, -1, 50));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Crop Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Crop/ Crop Rotation");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Season/ Year");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, -1, -1));

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

        logo11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Crop Sales (Transparent).png"))); // NOI18N
        logo11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(logo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/TIME.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 60, 60));

        rtDate.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        rtDate.setForeground(new java.awt.Color(0, 100, 0));
        rtDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(rtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 140, 30));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        vd_vcs_back.setBackground(new java.awt.Color(102, 153, 0));
        vd_vcs_back.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        vd_vcs_back.setForeground(new java.awt.Color(255, 255, 255));
        vd_vcs_back.setText("BACK");
        vd_vcs_back.setBorderPainted(false);
        vd_vcs_back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vd_vcs_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vd_vcs_backActionPerformed(evt);
            }
        });
        getContentPane().add(vd_vcs_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 550, -1, 30));

        rtTime.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        rtTime.setForeground(new java.awt.Color(0, 100, 0));
        rtTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(rtTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 160, 30));

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
        getContentPane().add(btn_CrGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 230, 90, 30));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG2.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CrFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CrFindActionPerformed
        String selectedItem = (String) cmb_Cscropname.getSelectedItem();
        String selectedItem2 = (String) cmb_Cssory.getSelectedItem();
        String selectedItem3 = (String) cmb_Cscroprotation.getSelectedItem();
        
        if (selectedItem != null && (selectedItem2 == null || selectedItem2.isEmpty()) && (selectedItem3 == null || selectedItem3.isEmpty())) {
        try {
            sqlconnector connector = sqlconnector.getInstance();
            Connection connection = connector.getConnection();
            
            DefaultTableModel croptbl = (DefaultTableModel) tbl_Cropsales.getModel();
                    
            
           String sqlshow2 = "SELECT c.vegetable_name, c.cpseason, cs.sold_qnty, cs.total_sales " +
                             "FROM crops_data AS c " +
                             "JOIN crop_sales AS cs ON c.crop_code = cs.salescrop_code " +
                             "WHERE c.cpfarmer_id = ? AND c.vegetable_name = ? " +
                             "ORDER BY cpseason DESC, vegetable_name ASC";

                             
            System.out.println("SQL Query: " + sqlshow2);
            
            try (PreparedStatement pstmt4 = connection.prepareStatement(sqlshow2)) {      
                pstmt4.setInt(1, loggedInFarmerId);
                pstmt4.setString(2, selectedItem); 
                
                ResultSet rs4 = pstmt4.executeQuery();
                
                // Clear existing table data
                croptbl.setRowCount(0);
                
                while (rs4.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rs4.getString("vegetable_name"));
                    row.add(rs4.getString("cpseason"));
                    row.add(rs4.getString("sold_qnty"));
                    row.add(rs4.getString("total_sales"));
                    croptbl.addRow(row);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new JFrame(), "Query Error: " + e.getMessage());
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Database Connection Error: " + e.getMessage());
        }
    }else if (selectedItem2 != null && ((selectedItem == null || selectedItem.isEmpty()) && (selectedItem3 == null || selectedItem3.isEmpty()))) {
        try {
            sqlconnector connector = sqlconnector.getInstance();
            Connection connection = connector.getConnection();
            
            DefaultTableModel croptbl = (DefaultTableModel) tbl_Cropsales.getModel();
                    
            
            String sqlshow3 = "SELECT c.vegetable_name, c.cpseason, cs.sold_qnty, cs.total_sales " +
                               "FROM crops_data AS c " +
                               "JOIN crop_sales AS cs ON c.crop_code = cs.salescrop_code " +
                               "WHERE c.cpfarmer_id = ? AND c.cpseason = ? " +
                               "ORDER BY cpseason DESC, vegetable_name ASC";

            
            System.out.println("SQL Query: " + sqlshow3);
            
            try (PreparedStatement pstmt5 = connection.prepareStatement(sqlshow3)) {      
                pstmt5.setInt(1, loggedInFarmerId);
                pstmt5.setString(2, selectedItem2); 
                
                ResultSet rs5 = pstmt5.executeQuery();
                
                // Clear existing table data
                croptbl.setRowCount(0);
                
                while (rs5.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rs5.getString("vegetable_name"));
                    row.add(rs5.getString("cpseason"));
                    row.add(rs5.getString("sold_qnty"));
                    row.add(rs5.getString("total_sales"));
                    croptbl.addRow(row);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new JFrame(), "Query Error: " + e.getMessage());
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Database Connection Error: " + e.getMessage());
        }
    }else if (selectedItem3 != null && ((selectedItem == null || selectedItem.isEmpty()) && (selectedItem2 == null || selectedItem2.isEmpty()))) {
        try {
            sqlconnector connector = sqlconnector.getInstance();
            Connection connection = connector.getConnection();
            
            DefaultTableModel croptbl = (DefaultTableModel) tbl_Cropsales.getModel();
                    
            
            String sqlshow4 = "SELECT c.vegetable_name, c.cpseason, cs.sold_qnty, cs.total_sales " +
                              "FROM crops_data AS c " +
                              "JOIN crop_sales AS cs ON c.crop_code = cs.salescrop_code " +
                              "WHERE c.cpfarmer_id = ? AND c.crop_rotation = ? " +
                              "ORDER BY cpseason DESC, vegetable_name ASC";

            
            System.out.println("SQL Query: " + sqlshow4);
            
            try (PreparedStatement pstmt6 = connection.prepareStatement(sqlshow4)) {      
                pstmt6.setInt(1, loggedInFarmerId);
                pstmt6.setString(2, selectedItem3); // Set parameter for the prepared statement
                
                ResultSet rs6 = pstmt6.executeQuery();
                
                // Clear existing table data
                croptbl.setRowCount(0);
                
                while (rs6.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rs6.getString("vegetable_name"));
                    row.add(rs6.getString("cpseason"));
                    row.add(rs6.getString("sold_qnty"));
                    row.add(rs6.getString("total_sales"));
                    croptbl.addRow(row);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new JFrame(), "Query Error: " + e.getMessage());
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Database Connection Error: " + e.getMessage());
        }
    }else if (selectedItem != null && selectedItem2 != null && (selectedItem3 == null || selectedItem3.isEmpty())){
        try {
            sqlconnector connector = sqlconnector.getInstance();
            Connection connection = connector.getConnection();
            
            DefaultTableModel croptbl = (DefaultTableModel) tbl_Cropsales.getModel();
                    
            
            String sqlshow4 = "SELECT c.vegetable_name, c.cpseason, cs.sold_qnty, cs.total_sales " +
                              "FROM crops_data AS c " +
                              "JOIN crop_sales AS cs ON c.crop_code = cs.salescrop_code " +
                              "WHERE c.cpfarmer_id = ? AND c.vegetable_name = ? AND c.cpseason = ? " +
                              "ORDER BY cpseason DESC, vegetable_name ASC";
                    

            
            System.out.println("SQL Query: " + sqlshow4);
            
            try (PreparedStatement pstmt6 = connection.prepareStatement(sqlshow4)) {      
                pstmt6.setInt(1, loggedInFarmerId);
                pstmt6.setString(2, selectedItem);
                pstmt6.setString(3, selectedItem2); // Set parameter for the prepared statement
                
                ResultSet rs6 = pstmt6.executeQuery();
                
                // Clear existing table data
                croptbl.setRowCount(0);
                
                while (rs6.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rs6.getString("vegetable_name"));
                    row.add(rs6.getString("cpseason"));
                    row.add(rs6.getString("sold_qnty"));
                    row.add(rs6.getString("total_sales"));
                    croptbl.addRow(row);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new JFrame(), "Query Error: " + e.getMessage());
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Database Connection Error: " + e.getMessage());
        }
    }else if (selectedItem != null && selectedItem3 != null && (selectedItem2 == null || selectedItem2.isEmpty())){
        try {
            sqlconnector connector = sqlconnector.getInstance();
            Connection connection = connector.getConnection();
            
            DefaultTableModel croptbl = (DefaultTableModel) tbl_Cropsales.getModel();
                    
            
            String sqlshow4 = "SELECT c.vegetable_name, c.cpseason, cs.sold_qnty, cs.total_sales " +
                              "FROM crops_data AS c " +
                              "JOIN crop_sales AS cs ON c.crop_code = cs.salescrop_code " +
                              "WHERE c.cpfarmer_id = ? AND c.vegetable_name = ? AND c.crop_rotation = ? " +
                              "ORDER BY cpseason DESC, vegetable_name ASC";

            
            System.out.println("SQL Query: " + sqlshow4);
            
            try (PreparedStatement pstmt6 = connection.prepareStatement(sqlshow4)) {      
                pstmt6.setInt(1, loggedInFarmerId);
                pstmt6.setString(2, selectedItem);
                pstmt6.setString(3, selectedItem3); // Set parameter for the prepared statement
                
                ResultSet rs6 = pstmt6.executeQuery();
                
                // Clear existing table data
                croptbl.setRowCount(0);
                
                while (rs6.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rs6.getString("vegetable_name"));
                    row.add(rs6.getString("cpseason"));
                    row.add(rs6.getString("sold_qnty"));
                    row.add(rs6.getString("total_sales"));
                    croptbl.addRow(row);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new JFrame(), "Query Error: " + e.getMessage());
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Database Connection Error: " + e.getMessage());
        }
    }else if (selectedItem2 != null && selectedItem3 != null && (selectedItem == null || selectedItem.isEmpty())){
        try {
            sqlconnector connector = sqlconnector.getInstance();
            Connection connection = connector.getConnection();
            
            DefaultTableModel croptbl = (DefaultTableModel) tbl_Cropsales.getModel();
                    
            
            String sqlshow4 = "SELECT c.vegetable_name, c.cpseason, cs.sold_qnty, cs.total_sales " +
                              "FROM crops_data AS c " +
                              "JOIN crop_sales AS cs ON c.crop_code = cs.salescrop_code " +
                              "WHERE c.cpfarmer_id = ? AND c.cpseason = ? AND c.crop_rotation = ? " +
                              "ORDER BY cpseason DESC, vegetable_name ASC";

            
            System.out.println("SQL Query: " + sqlshow4);
            
            try (PreparedStatement pstmt6 = connection.prepareStatement(sqlshow4)) {      
                pstmt6.setInt(1, loggedInFarmerId);
                pstmt6.setString(2, selectedItem2);
                pstmt6.setString(3, selectedItem3); 
                
                ResultSet rs6 = pstmt6.executeQuery();
                
                // Clear existing table data
                croptbl.setRowCount(0);
                
                while (rs6.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rs6.getString("vegetable_name"));
                    row.add(rs6.getString("cpseason"));
                    row.add(rs6.getString("sold_qnty"));
                    row.add(rs6.getString("total_sales"));
                    croptbl.addRow(row);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new JFrame(), "Query Error: " + e.getMessage());
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Database Connection Error: " + e.getMessage());
        }
    }else if (selectedItem != null && selectedItem2 != null && selectedItem3 != null){
        try {
            sqlconnector connector = sqlconnector.getInstance();
            Connection connection = connector.getConnection();
            
            DefaultTableModel croptbl = (DefaultTableModel) tbl_Cropsales.getModel();
                    
            
            String sqlshow4 = "SELECT c.vegetable_name, c.cpseason, cs.sold_qnty, cs.total_sales " +
                              "FROM crops_data AS c " +
                              "JOIN crop_sales AS cs ON c.crop_code = cs.salescrop_code " +
                              "WHERE c.cpfarmer_id = ? AND c.vegetable_name = ? AND c.cpseason = ? AND c.crop_rotation = ? " +
                              "ORDER BY cpseason DESC, vegetable_name ASC";

            
            System.out.println("SQL Query: " + sqlshow4);
            
            try (PreparedStatement pstmt6 = connection.prepareStatement(sqlshow4)) {      
                pstmt6.setInt(1, loggedInFarmerId);
                pstmt6.setString(2, selectedItem);
                pstmt6.setString(3, selectedItem2);
                pstmt6.setString(4, selectedItem3); 
                
                ResultSet rs6 = pstmt6.executeQuery();
                
                // Clear existing table data
                croptbl.setRowCount(0);
                
                while (rs6.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rs6.getString("vegetable_name"));
                    row.add(rs6.getString("cpseason"));
                    row.add(rs6.getString("sold_qnty"));
                    row.add(rs6.getString("total_sales"));
                    croptbl.addRow(row);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new JFrame(), "Query Error: " + e.getMessage());
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Database Connection Error: " + e.getMessage());
        }
    }
                 
            
            
            
            
            
            
            
    }//GEN-LAST:event_btn_CrFindActionPerformed

    private void vd_vcs_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vd_vcs_backActionPerformed
        new vd_viewfarmdata(loggedInFarmerId, showfirstname, botanicfam_code, plotlandcode, total_sales, total_costs).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_vd_vcs_backActionPerformed

    private void btn_ad_cp_User2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ad_cp_User2ActionPerformed
        new user(loggedInFarmerId, showfirstname, botanicfam_code).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_ad_cp_User2ActionPerformed

    private void btn_CrGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CrGraphActionPerformed
        
    sqlconnector connector = sqlconnector.getInstance();
    Connection connection = connector.getConnection();

    String sqlsalesgraphget = "SELECT c.cpseason, SUM(cs.total_sales) AS total_sales " +
            "FROM crops_data AS c " +
            "JOIN crop_sales AS cs ON c.crop_code = cs.salescrop_code " +
            "WHERE c.cpfarmer_id = ? AND cs.salesfarmer_id = ? " +
            "GROUP BY c.cpseason " +
            "ORDER BY c.cpseason ASC";

    System.out.println("SQL Query: " + sqlsalesgraphget);

    try (PreparedStatement pstmtsalesgraph = connection.prepareStatement(sqlsalesgraphget)) {
        pstmtsalesgraph.setInt(1, loggedInFarmerId);
        pstmtsalesgraph.setInt(2, loggedInFarmerId);

        ResultSet rssalesgraph = pstmtsalesgraph.executeQuery();

        DefaultCategoryDataset vdcropsalesgraph = new DefaultCategoryDataset();

        while (rssalesgraph.next()) {
            String seasonoryear = rssalesgraph.getString("cpseason") ;
            double doverall_sales = rssalesgraph.getDouble("total_sales");

            System.out.println("Season/Year: " + seasonoryear);
            System.out.println("Total Sales: " + doverall_sales);

            vdcropsalesgraph.setValue(doverall_sales, "Overall Sales", seasonoryear);
        }
        
        JFreeChart salesbarchart = ChartFactory.createBarChart3D("CROP SALES", "Season/Year", "Total Sales", vdcropsalesgraph, PlotOrientation.VERTICAL, true, true, false);

        CategoryPlot plot = (CategoryPlot) salesbarchart.getPlot();
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
        salesbarchart.getTitle().setFont(new Font("SansSerif", Font.BOLD, 20));
        salesbarchart.getCategoryPlot().getDomainAxis().setLabelFont(new Font("SansSerif", Font.BOLD, 14));
        salesbarchart.getCategoryPlot().getRangeAxis().setLabelFont(new Font("SansSerif", Font.BOLD, 14));
        salesbarchart.getCategoryPlot().getDomainAxis().setTickLabelFont(new Font("SansSerif", Font.BOLD, 12));
        salesbarchart.getCategoryPlot().getRangeAxis().setTickLabelFont(new Font("SansSerif", Font.BOLD, 12));

        plot.setRangeGridlinePaint(Color.BLACK);
        
        //black bg 
        ChartPanel chartPanel = new ChartPanel(salesbarchart);
        chartPanel.setBackground(new Color(0,0,0,0));

        // the panel
        ChartFrame salesframe = new ChartFrame("Datos-Ani: Crop Sales Bar Graph", salesbarchart);
        salesframe.getContentPane().setBackground(new Color(0,0,0,0));
        salesframe.setContentPane(chartPanel);
        salesframe.setSize(900, 500);
        salesframe.setLocationRelativeTo(null);
        salesframe.setVisible(true);

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
            java.util.logging.Logger.getLogger(vd_viewcropsales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vd_viewcropsales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vd_viewcropsales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vd_viewcropsales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
                int loggedInFarmerId = 0;
                String showfirstname = null;
                int botanicfam_code = 0;
                int plotlandcode = 0;
                String total_sales = null;
                String total_costs = null;
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vd_viewcropsales(loggedInFarmerId, showfirstname, botanicfam_code, plotlandcode, total_sales, total_costs).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CrFind;
    private javax.swing.JButton btn_CrGraph;
    private javax.swing.JButton btn_ad_cp_User2;
    private javax.swing.JComboBox<String> cmb_Cscropname;
    private javax.swing.JComboBox<String> cmb_Cscroprotation;
    private javax.swing.JComboBox<String> cmb_Cssory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel logo10;
    private javax.swing.JLabel logo11;
    private javax.swing.JLabel logo4;
    private javax.swing.JLabel logo9;
    private javax.swing.JLabel rtDate;
    private javax.swing.JLabel rtTime;
    private javax.swing.JTable tbl_Cropsales;
    private javax.swing.JButton vd_vcs_back;
    // End of variables declaration//GEN-END:variables
}
