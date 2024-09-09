
package datosani;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;


public class insidelogin extends javax.swing.JFrame {
    private String getemail;
    private String showfirstname;
    private int loggedInFarmerId;
    private int botanicfam_code;
    private int plotlandcode;
    private String total_sales;
    private String total_costs;
    
    private String getrtdate;
    private int ch_code;
    private int cr_code;
    private String croprotate;
    private String cropharvest;
    private String schedcropharvest;
   
    
   
    
    
    
    public insidelogin(int loggedInFarmerId, String showfirstname, String getemail, int botanicfam_code, int plotlandcode, String total_sales, String total_costs, String getrtdate) {
        this.getemail = getemail;
        this.loggedInFarmerId = loggedInFarmerId; 
        this.plotlandcode = plotlandcode;
        this.botanicfam_code = botanicfam_code;
        this.showfirstname = showfirstname;
        this.getrtdate = getrtdate;
       
        initComponents();
        this.showfirstname = showfirstname;
        txt_LsShowusername.setText(showfirstname);
        
        
        realtDate();
        realtTime();
       
        
        System.out.println("Logged in Farmer ID: " + loggedInFarmerId);
        System.out.println("Botanic Family ID: " + botanicfam_code);
        System.out.println("Plot of Land Code: " + plotlandcode);
        
        /*Date odate = new Date();
        SimpleDateFormat sdfodate = new SimpleDateFormat("MM-dd-yyyy");
        String showdateo = sdfodate.format(odate);

        String getmonth = showdateo.substring(0, 2);
        String getyear = showdateo.substring(6, 10);

        System.out.println("Month: " + getmonth);
        System.out.println("Year: " + getyear);

        String schedcropnharvest = null;


    switch (getmonth) {
    case "01":
        schedcropnharvest = "January";
        break;
    case "02":
        schedcropnharvest = "February";
        break;
    case "03":
        schedcropnharvest = "March";
        break;
    case "04":
        schedcropnharvest = "April";
        break;
    case "05":
        schedcropnharvest = "May";
        break;
    case "06":
        schedcropnharvest = "June";
        break;
    case "07":
        schedcropnharvest = "July";
        break;
    case "08":
        schedcropnharvest = "August";
        break;
    case "09":
        schedcropnharvest = "September";
        break;
    case "10":
        schedcropnharvest = "October";
        break;
    case "11":
        schedcropnharvest = "November";
        break;
    case "12":
        schedcropnharvest = "December";
        break;
    default:
        
        break;
}

System.out.println("Monthafter: " + schedcropnharvest);
        
        try {
        sqlconnector connector = sqlconnector.getInstance();
        Connection connection = connector.getConnection();
        
        
        String getpkch = "SELECT sched_ch_code FROM schedcrop_harvest WHERE schfarmer_id = ? AND sch_botanicfamcode = ? AND sch_plantdate = ? AND sch_plantyear = ?";
        
        System.out.println(getpkch);
        
        try (PreparedStatement pstmtget = connection.prepareStatement(getpkch)) {
            pstmtget.setInt(1, loggedInFarmerId);
            pstmtget.setInt(2, botanicfam_code);
            pstmtget.setString(3, schedcropnharvest);
            pstmtget.setString(4, getyear);
           
            
            ResultSet rsget = pstmtget.executeQuery();
            
           
            
            while (rsget.next()) {
                ch_code = rsget.getInt("sched_ch_code");
                
                System.out.println(ch_code);
              
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "Get chQuery Error: " + e.getMessage());
        }
        
        
        String getpkcr = "SELECT sched_cr_code FROM schedcrop_rotation WHERE scrfarmer_id = ? AND scr_botanicfamcode = ? AND scr_plantdate = ? AND scr_plantyear = ?";
        
        System.out.println(getpkcr);
        
        try (PreparedStatement pstmtgetcr = connection.prepareStatement(getpkcr)) {
            pstmtgetcr.setInt(1, loggedInFarmerId);
            pstmtgetcr.setInt(2, botanicfam_code);
            pstmtgetcr.setString(3, schedcropnharvest);
            pstmtgetcr.setString(4, getyear);
            
            ResultSet rsgetcr = pstmtgetcr.executeQuery();
            
           
            
            while (rsgetcr.next()) {
                cr_code = rsgetcr.getInt("sched_cr_code");
                
               
                System.out.println(cr_code);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "Get crQuery Error: " + e.getMessage());
        }

        
        String getschedch = "SELECT sch_cropname FROM schedcrop_harvest WHERE sched_ch_code = ? AND schfarmer_id = ? AND sch_botanicfamcode = ? AND sch_plantdate = ? AND sch_plantyear = ? " +
                               "ORDER BY sch_cropname ASC";
                               
                               System.out.println(getschedch);
                               
                               try (PreparedStatement pstmtschedch = connection.prepareStatement(getschedch)) {
                                
                                System.out.println(ch_code);   
                                System.out.println(loggedInFarmerId);   
                                System.out.println(botanicfam_code);   
                                System.out.println(schedcropnharvest);   
                                System.out.println(getyear);   
                                   
                                pstmtschedch.setInt(1, ch_code);
                                pstmtschedch.setInt(2, loggedInFarmerId);
                                pstmtschedch.setInt(3, botanicfam_code);
                                pstmtschedch.setString(4, schedcropnharvest);
                                pstmtschedch.setString(5, getyear);

                                ResultSet rsgetschedch = pstmtschedch.executeQuery();

                                

                                while (rsgetschedch.next()) {
                                    
                                    cropharvest = rsgetschedch.getString("sch_cropname");
                                    
                                    System.out.println(cropharvest);
                                    
                                    if(cropharvest == null || cropharvest.isEmpty()){
                                        JOptionPane.showMessageDialog(new JFrame(), "No set schedule for this month. You can rest.");
                                    }else if (cropharvest != null){//Notif for Harvest
                                    Properties props = new Properties();
                                    props.put("mail.smtp.host", "smtp.gmail.com");
                                    props.put("mail.smtp.port", "587");
                                    props.put("mail.smtp.auth", "true");
                                    props.put("mail.smtp.starttls.enable", "true");


                                    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                                        @Override
                                        protected PasswordAuthentication getPasswordAuthentication() {
                                            return new PasswordAuthentication("marabilla.rr.bscs@gmail.com", "hkll rwrb llyc ijjt");
                                        }
                                    });

                                    try {

                                        Message message = new MimeMessage(session);


                                        message.setFrom(new InternetAddress(getemail));


                                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(getemail));


                                        message.setSubject("Datos-Ani: Harvest Time!");


                                        message.setText("Hello " + showfirstname + "!\n\n\n" + "This month of " + schedcropnharvest + ", " + cropharvest + " is set to be harvested. The fruition of your hardwork is here. Great Job!");
                             
            
                                        Transport.send(message);
                                    } catch (MessagingException e) {
                                    throw new RuntimeException(e);
                                    }
                                     }
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(new JFrame(), "Get 1Query Error: " + e.getMessage());
                            }
                               
        String getschedcr = "SELECT scr_cropname FROM schedcrop_rotation WHERE sched_cr_code = ? AND scrfarmer_id = ? AND scr_botanicfamcode = ? AND scr_plantdate = ? AND scr_plantyear = ? " +
                               "ORDER BY scr_cropname ASC";                       
                               
                               System.out.println(getschedcr);
                               
                               try (PreparedStatement pstmtschedcr = connection.prepareStatement(getschedcr)) {
    
                                pstmtschedcr.setInt(1, cr_code);
                                pstmtschedcr.setInt(2, loggedInFarmerId);
                                pstmtschedcr.setInt(3, botanicfam_code);
                                pstmtschedcr.setString(4, schedcropnharvest);
                                pstmtschedcr.setString(5, getyear);

                                ResultSet rsgetschedcr = pstmtschedcr.executeQuery();



                                while (rsgetschedcr.next()) {
                                    
                                    croprotate = rsgetschedcr.getString("scr_cropname");
                                    
                                    System.out.println(croprotate);
                                    
                                    if(croprotate == null || croprotate.isEmpty()){
                                        JOptionPane.showMessageDialog(new JFrame(), "No set schedule for this month. You can rest.");
                                    }else if (croprotate != null){

                                       //Mag Send Notif abt croprotate
                                    Properties props = new Properties();
                                    props.put("mail.smtp.host", "smtp.gmail.com");
                                    props.put("mail.smtp.port", "587");
                                    props.put("mail.smtp.auth", "true");
                                    props.put("mail.smtp.starttls.enable", "true");


                                    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                                        @Override
                                        protected PasswordAuthentication getPasswordAuthentication() {
                                            return new PasswordAuthentication("marabilla.rr.bscs@gmail.com", "hkll rwrb llyc ijjt");
                                        }
                                    });

                                    try {

                                        Message message = new MimeMessage(session);


                                        message.setFrom(new InternetAddress(getemail));


                                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(getemail));


                                        message.setSubject("Datos-Ani: Crop Rotation Schedule");


                                        message.setText("Hello " + showfirstname + "!\n\n\n" + "This month of " + schedcropnharvest + ", " + croprotate + " is set to be planted for crop rotation.");


                                        Transport.send(message);
                                    } catch (MessagingException e) {
                                        throw new RuntimeException(e);
                                    }
                                    }
                                    
                                    
                                    
                                    
                                    
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(new JFrame(), "Get 2Query Error: " + e.getMessage());
                            }   
                               
                               
         //dulo                      
         }catch (Exception e) {
        JOptionPane.showMessageDialog(new JFrame(), "Database Connection Error: " + e.getMessage());
        }
        
        */
        
        
        
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

        logo10 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        logo2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_LsAddData = new javax.swing.JButton();
        btn_LsViewData = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btn_insidelogin_User = new javax.swing.JButton();
        rtDate = new javax.swing.JLabel();
        logo11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rtTime = new javax.swing.JLabel();
        txt_LsShowusername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        logo10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/User Icon.png"))); // NOI18N
        logo10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ADD DATA.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 160, 180));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 100, 0));
        jLabel6.setText("ADD DATA");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/VIEW DATA.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 170, 170));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/TIME.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 60, 60));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 100, 0));
        jLabel8.setText("VIEW DATA");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 430, -1, -1));

        btn_LsAddData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_LsAddData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LsAddDataActionPerformed(evt);
            }
        });
        getContentPane().add(btn_LsAddData, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 230, 250));

        btn_LsViewData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_LsViewData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LsViewDataActionPerformed(evt);
            }
        });
        getContentPane().add(btn_LsViewData, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 230, 250));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 50)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Welcome");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 230, 40));

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

        rtDate.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        rtDate.setForeground(new java.awt.Color(0, 100, 0));
        rtDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(rtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 140, 30));

        logo11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/User Icon.png"))); // NOI18N
        logo11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(logo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, -1, 50));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dATE.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 60, 60));

        rtTime.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        rtTime.setForeground(new java.awt.Color(0, 100, 0));
        rtTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(rtTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 160, 30));

        txt_LsShowusername.setEditable(false);
        txt_LsShowusername.setBackground(new java.awt.Color(0, 90, 0));
        txt_LsShowusername.setFont(new java.awt.Font("SansSerif", 1, 45)); // NOI18N
        txt_LsShowusername.setForeground(new java.awt.Color(255, 255, 255));
        txt_LsShowusername.setBorder(null);
        txt_LsShowusername.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt_LsShowusername.setName(""); // NOI18N
        txt_LsShowusername.setOpaque(false);
        txt_LsShowusername.setRequestFocusEnabled(false);
        txt_LsShowusername.setVerifyInputWhenFocusTarget(false);
        txt_LsShowusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_LsShowusernameActionPerformed(evt);
            }
        });
        getContentPane().add(txt_LsShowusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 320, 60));

        jLabel2.setBackground(new java.awt.Color(0, 90, 0));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 710, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG2.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LsAddDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LsAddDataActionPerformed
        
        new ad_cropdata(loggedInFarmerId, showfirstname, botanicfam_code).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_LsAddDataActionPerformed

    private void btn_LsViewDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LsViewDataActionPerformed
        new vd_viewfarmdata(loggedInFarmerId, showfirstname, botanicfam_code, plotlandcode, total_sales, total_costs).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_LsViewDataActionPerformed

    private void txt_LsShowusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_LsShowusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_LsShowusernameActionPerformed

    private void btn_insidelogin_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insidelogin_UserActionPerformed
        new user(loggedInFarmerId, showfirstname, botanicfam_code).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_insidelogin_UserActionPerformed

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
            java.util.logging.Logger.getLogger(insidelogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(insidelogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(insidelogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(insidelogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        String showfirstname = null;
        
        int loggedInFarmerId = 0;
        int botanicfam_code = 0;
        int plotlandcode = 0;
        String total_sales = null;
        String total_costs = null;
        String getrtdate = null;
        String getemail = null;
        
        
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new insidelogin(loggedInFarmerId, showfirstname, getemail, botanicfam_code, plotlandcode, total_sales, total_costs, getrtdate).setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_LsAddData;
    private javax.swing.JButton btn_LsViewData;
    private javax.swing.JButton btn_insidelogin_User;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel logo10;
    private javax.swing.JLabel logo11;
    private javax.swing.JLabel logo2;
    private javax.swing.JLabel rtDate;
    private javax.swing.JLabel rtTime;
    private javax.swing.JTextField txt_LsShowusername;
    // End of variables declaration//GEN-END:variables
}
