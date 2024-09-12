/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosani;


import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;


/**
 *
 * @author Russel
 */
public class interfacesignup extends javax.swing.JFrame {
    
    private final sqlconnector dbConnection;
    private int loggedInFarmerId;
    private int botanicfam_code;
    
    public interfacesignup(int loggedInFarmerId, int botanicfam_code) {
        
        this.loggedInFarmerId = loggedInFarmerId;
        this.botanicfam_code = botanicfam_code;
        initComponents();
        dbConnection = sqlconnector.getInstance(); 
        
        cmb_bdmonth.addItem(" "); 
        cmb_bdmonth.addItem("January");
        cmb_bdmonth.addItem("February");
        cmb_bdmonth.addItem("March");
        cmb_bdmonth.addItem("April");
        cmb_bdmonth.addItem("May");
        cmb_bdmonth.addItem("June");
        cmb_bdmonth.addItem("July");
        cmb_bdmonth.addItem("August");
        cmb_bdmonth.addItem("September");
        cmb_bdmonth.addItem("October");
        cmb_bdmonth.addItem("November");
        cmb_bdmonth.addItem("December");
        
        cmb_bdday.addItem("");
        for (int i = 1; i <= 31; i++) {
            cmb_bdday.addItem(String.valueOf(i));
        }
        
        cmb_bdyear.addItem("");
        for (int i = 2024; i >= 1900; i--) {
            cmb_bdyear.addItem(String.valueOf(i));
        }
        
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        su_Separator = new javax.swing.JSeparator();
        btn_SuHome = new javax.swing.JButton();
        btn_SuAbout = new javax.swing.JButton();
        su_logo = new javax.swing.JLabel();
        btn_SiSignin = new javax.swing.JButton();
        btn_SiSignup = new javax.swing.JButton();
        btn_SiSignup1 = new javax.swing.JButton();
        txt_Suaddress = new javax.swing.JTextField();
        txt_Sulastname = new javax.swing.JTextField();
        txt_Sumiddlename = new javax.swing.JTextField();
        txt_Sufirstname = new javax.swing.JTextField();
        txt_Sumobilenum = new javax.swing.JTextField();
        txt_SuEmail = new javax.swing.JTextField();
        txt_SuPassword = new javax.swing.JTextField();
        su_password = new javax.swing.JLabel();
        su_fn = new javax.swing.JLabel();
        su_mn = new javax.swing.JLabel();
        su_ln = new javax.swing.JLabel();
        su_gender = new javax.swing.JLabel();
        su_mobilenum = new javax.swing.JLabel();
        su_birthdate = new javax.swing.JLabel();
        su_emailaddress = new javax.swing.JLabel();
        Su_bg = new javax.swing.JLabel();
        btn_genderm = new javax.swing.JRadioButton();
        btn_genderf = new javax.swing.JRadioButton();
        su_address1 = new javax.swing.JLabel();
        su_panelbg = new javax.swing.JLabel();
        cmb_bdyear = new javax.swing.JComboBox<>();
        cmb_bdmonth = new javax.swing.JComboBox<>();
        cmb_bdday = new javax.swing.JComboBox<>();
        su_panell = new javax.swing.JLabel();
        su_bgg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        su_Separator.setBackground(new java.awt.Color(0, 100, 0));
        su_Separator.setForeground(new java.awt.Color(0, 0, 0));
        su_Separator.setOpaque(true);
        getContentPane().add(su_Separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 550, 2));

        btn_SuHome.setBackground(new java.awt.Color(204, 255, 204));
        btn_SuHome.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_SuHome.setForeground(new java.awt.Color(0, 100, 0));
        btn_SuHome.setText("HOME");
        btn_SuHome.setToolTipText("");
        btn_SuHome.setBorderPainted(false);
        btn_SuHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_SuHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btn_SuHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 90, 30));

        btn_SuAbout.setBackground(new java.awt.Color(204, 255, 204));
        btn_SuAbout.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_SuAbout.setForeground(new java.awt.Color(0, 100, 0));
        btn_SuAbout.setText("ABOUT");
        btn_SuAbout.setToolTipText("");
        btn_SuAbout.setBorderPainted(false);
        btn_SuAbout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_SuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuAboutActionPerformed(evt);
            }
        });
        getContentPane().add(btn_SuAbout, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 100, 30));

        su_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Datos-Ani Icon Logo.png"))); // NOI18N
        getContentPane().add(su_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 50));

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
        getContentPane().add(btn_SiSignin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 90, -1));

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
        getContentPane().add(btn_SiSignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 510, 90, -1));

        btn_SiSignup1.setBackground(new java.awt.Color(204, 255, 204));
        btn_SiSignup1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btn_SiSignup1.setForeground(new java.awt.Color(0, 100, 0));
        btn_SiSignup1.setText("SIGN UP");
        btn_SiSignup1.setBorderPainted(false);
        btn_SiSignup1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_SiSignup1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SiSignup1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_SiSignup1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 90, -1));

        txt_Suaddress.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txt_Suaddress.setToolTipText("");
        getContentPane().add(txt_Suaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 400, 40));

        txt_Sulastname.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        getContentPane().add(txt_Sulastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 400, 40));

        txt_Sumiddlename.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        getContentPane().add(txt_Sumiddlename, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 400, 40));

        txt_Sufirstname.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        getContentPane().add(txt_Sufirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 400, 40));

        txt_Sumobilenum.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txt_Sumobilenum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SumobilenumKeyTyped(evt);
            }
        });
        getContentPane().add(txt_Sumobilenum, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 400, 40));

        txt_SuEmail.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        getContentPane().add(txt_SuEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 340, 400, 40));

        txt_SuPassword.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        getContentPane().add(txt_SuPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, 400, 40));

        su_password.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        su_password.setForeground(new java.awt.Color(0, 100, 0));
        su_password.setText("Password");
        getContentPane().add(su_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 120, 20));

        su_fn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        su_fn.setForeground(new java.awt.Color(0, 100, 0));
        su_fn.setText("First Name");
        getContentPane().add(su_fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 120, 20));

        su_mn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        su_mn.setForeground(new java.awt.Color(0, 100, 0));
        su_mn.setText("Middle Name");
        getContentPane().add(su_mn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 120, 20));

        su_ln.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        su_ln.setForeground(new java.awt.Color(0, 100, 0));
        su_ln.setText("Last Name");
        getContentPane().add(su_ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 120, 20));

        su_gender.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        su_gender.setForeground(new java.awt.Color(0, 100, 0));
        su_gender.setText("Gender");
        getContentPane().add(su_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 120, 20));

        su_mobilenum.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        su_mobilenum.setForeground(new java.awt.Color(0, 100, 0));
        su_mobilenum.setText("Mobile Number");
        getContentPane().add(su_mobilenum, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 120, 20));

        su_birthdate.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        su_birthdate.setForeground(new java.awt.Color(0, 100, 0));
        su_birthdate.setText("Bitrth Date");
        getContentPane().add(su_birthdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 120, 20));

        su_emailaddress.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        su_emailaddress.setForeground(new java.awt.Color(0, 100, 0));
        su_emailaddress.setText("Email Address");
        getContentPane().add(su_emailaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 120, 20));
        getContentPane().add(Su_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, -1, -1));

        btn_genderm.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_genderm.setForeground(new java.awt.Color(0, 100, 0));
        btn_genderm.setSelected(true);
        btn_genderm.setText("Male");
        btn_genderm.setContentAreaFilled(false);
        btn_genderm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gendermActionPerformed(evt);
            }
        });
        getContentPane().add(btn_genderm, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, -1, -1));

        btn_genderf.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_genderf.setForeground(new java.awt.Color(0, 100, 0));
        btn_genderf.setText("Female");
        btn_genderf.setContentAreaFilled(false);
        btn_genderf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_genderfActionPerformed(evt);
            }
        });
        getContentPane().add(btn_genderf, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, -1, -1));

        su_address1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        su_address1.setForeground(new java.awt.Color(0, 100, 0));
        su_address1.setText("Address");
        getContentPane().add(su_address1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 120, 20));

        su_panelbg.setBackground(new java.awt.Color(204, 255, 204));
        su_panelbg.setOpaque(true);
        getContentPane().add(su_panelbg, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, -1, -1));

        cmb_bdyear.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cmb_bdyear.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                cmb_bdyearComponentAdded(evt);
            }
        });
        getContentPane().add(cmb_bdyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 270, 130, 40));

        cmb_bdmonth.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cmb_bdmonth.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                cmb_bdmonthComponentAdded(evt);
            }
        });
        getContentPane().add(cmb_bdmonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 160, 40));

        cmb_bdday.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cmb_bdday.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                cmb_bddayComponentAdded(evt);
            }
        });
        getContentPane().add(cmb_bdday, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 270, 70, 40));

        su_panell.setBackground(new java.awt.Color(204, 255, 204, 150));
        su_panell.setOpaque(true);
        getContentPane().add(su_panell, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 960, 460));

        su_bgg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG1.png"))); // NOI18N
        getContentPane().add(su_bgg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SuHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuHomeActionPerformed
        new home(loggedInFarmerId, botanicfam_code).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_SuHomeActionPerformed

    private void btn_SuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuAboutActionPerformed
        new aboutda(loggedInFarmerId).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_SuAboutActionPerformed

    private void btn_SiSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SiSignupActionPerformed
        String lastname, middlename, firstname, address, gender = null, mobilenumber, email, password;
        String genderset, month, day, year;
        
        
        if ("".equals(txt_Sulastname.getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Enter Last Name");
        }
        else if ("".equals(txt_Sumiddlename.getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Enter Middle Name");
        }
        else if ("".equals(txt_Sufirstname.getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Enter Last Name");
        }
        else if ("".equals(txt_Suaddress.getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Enter Address");
        }
        else if ("".equals(txt_Sumobilenum.getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Enter Mobile Number");
        }
        else if ("".equals(txt_SuEmail.getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Enter Email Address");
        }
        else if ("".equals(txt_SuPassword.getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Enter Password");
        } 
        else {
            lastname = txt_Sulastname.getText();
            middlename = txt_Sumiddlename.getText();
            firstname = txt_Sufirstname.getText();
            address = txt_Suaddress.getText();
            
            if (btn_genderm.isSelected()){
                genderset = "Male";
                gender = genderset;
            }
            
            if (btn_genderf.isSelected()){
                genderset = "Female";
                gender = genderset;
            }
            
            month = (String) cmb_bdmonth.getSelectedItem();
            day = (String) cmb_bdday.getSelectedItem();
            year = (String) cmb_bdyear.getSelectedItem();

            if (month == null || day == null || year == null) {
            JOptionPane.showMessageDialog(this, "Select A Birthdate.");
            return;
            }

        // Concatenate (Pagsamahin) birthdate components into a single string
            String birthdate = month + "-" + day + "-" + year;
            
            
            mobilenumber = txt_Sumobilenum.getText();
            email = txt_SuEmail.getText();
            password = txt_SuPassword.getText();
            
            
            try {
                
                sqlconnector connector = sqlconnector.getInstance();
                Connection connection = connector.getConnection();
                String sql = "INSERT INTO farmer_info (frmr_last_name, frmr_middle_name, frmr_first_name, frmr_address, frmr_gender, "
                    + "frmr_mobilenum, frmr_birthdate, frmr_emailaddress, frmr_password) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
                try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    pstmt.setString(1, lastname);
                    pstmt.setString(2, middlename);
                    pstmt.setString(3, firstname);
                    pstmt.setString(4, address);
                    pstmt.setString(5, gender);
                    pstmt.setString(6, mobilenumber);
                    pstmt.setString(7, birthdate);
                    pstmt.setString(8, email);
                    pstmt.setString(9, password);
                    
                    int rowsInserted = pstmt.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(this, "Sign up successful! Account Created!");
                        // Optionally, perform further actions after successful signup
                      
                        new interfacesignin(loggedInFarmerId, botanicfam_code).setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to sign up. Please try again.");
                    }   
                }
            
            
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btn_SiSignupActionPerformed


    private void btn_gendermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gendermActionPerformed
        btn_genderf.setSelected(false);
    }//GEN-LAST:event_btn_gendermActionPerformed

    private void btn_genderfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_genderfActionPerformed
        btn_genderm.setSelected(false);
    }//GEN-LAST:event_btn_genderfActionPerformed

    private void cmb_bdyearComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_cmb_bdyearComponentAdded
        
    }//GEN-LAST:event_cmb_bdyearComponentAdded

    private void cmb_bdmonthComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_cmb_bdmonthComponentAdded
        
    }//GEN-LAST:event_cmb_bdmonthComponentAdded

    private void cmb_bddayComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_cmb_bddayComponentAdded
        
    }//GEN-LAST:event_cmb_bddayComponentAdded

    private void btn_SiSigninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SiSigninActionPerformed
        new interfacesignin(loggedInFarmerId, botanicfam_code).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_SiSigninActionPerformed

    private void btn_SiSignup1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SiSignup1ActionPerformed
      new interfacesignup(loggedInFarmerId, botanicfam_code).setVisible(true);
      this.dispose();
    }//GEN-LAST:event_btn_SiSignup1ActionPerformed

    private void txt_SumobilenumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SumobilenumKeyTyped
        char qnty = evt.getKeyChar();
       if(Character.isLetter(qnty)&&!evt.isAltDown()){
           evt.consume();
       }
    }//GEN-LAST:event_txt_SumobilenumKeyTyped

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
            java.util.logging.Logger.getLogger(interfacesignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfacesignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfacesignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfacesignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int loggedInFarmerId = 0;
                int botanicfam_code = 0;
                new interfacesignup(loggedInFarmerId, botanicfam_code).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Su_bg;
    private javax.swing.JButton btn_SiSignin;
    private javax.swing.JButton btn_SiSignup;
    private javax.swing.JButton btn_SiSignup1;
    private javax.swing.JButton btn_SuAbout;
    private javax.swing.JButton btn_SuHome;
    private javax.swing.JRadioButton btn_genderf;
    private javax.swing.JRadioButton btn_genderm;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cmb_bdday;
    private javax.swing.JComboBox<String> cmb_bdmonth;
    private javax.swing.JComboBox<String> cmb_bdyear;
    private javax.swing.JSeparator su_Separator;
    private javax.swing.JLabel su_address1;
    private javax.swing.JLabel su_bgg;
    private javax.swing.JLabel su_birthdate;
    private javax.swing.JLabel su_emailaddress;
    private javax.swing.JLabel su_fn;
    private javax.swing.JLabel su_gender;
    private javax.swing.JLabel su_ln;
    private javax.swing.JLabel su_logo;
    private javax.swing.JLabel su_mn;
    private javax.swing.JLabel su_mobilenum;
    private javax.swing.JLabel su_panelbg;
    private javax.swing.JLabel su_panell;
    private javax.swing.JLabel su_password;
    private javax.swing.JTextField txt_SuEmail;
    private javax.swing.JTextField txt_SuPassword;
    private javax.swing.JTextField txt_Suaddress;
    private javax.swing.JTextField txt_Sufirstname;
    private javax.swing.JTextField txt_Sulastname;
    private javax.swing.JTextField txt_Sumiddlename;
    private javax.swing.JTextField txt_Sumobilenum;
    // End of variables declaration//GEN-END:variables
}
