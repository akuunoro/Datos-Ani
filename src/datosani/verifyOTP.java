/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosani;
import java.awt.Color;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;


/**
 *
 * @author Russel
 */
public class verifyOTP extends javax.swing.JFrame {

    private final sqlconnector dbConnection;
    
    static int otp;
    public static String addemail;
    
    
    private int loggedInFarmerId; 
    private String getemail;
    private String showfirstname;
    private int botanicfam_code;
    private int plotlandcode;
    private String total_sales;
    private String total_costs;
    private String getrtdate;
    
    public verifyOTP(int loggedInFarmerId, String getemail, String showfirstname, int botanicfam_code, int plotlandcode, String total_sales, String total_costs) {
        this.getemail = getemail;
        this.showfirstname = showfirstname;
        this.loggedInFarmerId = loggedInFarmerId;
        initComponents();
        
        dbConnection = sqlconnector.getInstance(); 
        
        
        System.out.println("Logged in Farmer ID: " + loggedInFarmerId);
        System.out.println("Farmer First Name: " + showfirstname);
        System.out.println("Email Address: " + getemail);
        
        txt_showemail.setText(getemail);
      
        txt_showemail.setOpaque(false);
        txt_showemail.setBorder(null);
        txt_showemail.setForeground(new Color(0,100,0));
        txt_showemail.setBackground(new Color(0, 0, 0, 0));
        
        Random rand = new Random();
        otp = 100000 + rand.nextInt(900000);
        
        
           
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("PUT-YOUR-EMAIL-HERE", "PUT-YOUR-APP-PASSWORD-HERE");
            }
        });

        try {
            
            Message message = new MimeMessage(session);

            
            message.setFrom(new InternetAddress(getemail));

          
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(getemail));

           
            message.setSubject("Datos-Ani: Authentication Code (OTP)");

           
            message.setText("Hello " + showfirstname + "!\n\n\n" + "This is your one-time OTP to access to your account: " + otp + "\n\n" + 
                            "If you do not request for this OTP. Kindly ignore this message.");
            
            Transport.send(message);

            System.out.println("Sent message successfully to " + "marabilla.rr.bscs@gmail.com");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
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

        txt_showemail = new javax.swing.JTextField();
        si_Separator = new javax.swing.JSeparator();
        si_logo = new javax.swing.JLabel();
        si_AboutWord1 = new javax.swing.JLabel();
        Si_Username1 = new javax.swing.JLabel();
        Si_Username2 = new javax.swing.JLabel();
        Si_Username3 = new javax.swing.JLabel();
        txt_OTP = new javax.swing.JTextField();
        btn_OTPcheck = new javax.swing.JButton();
        si_Panelbg1 = new javax.swing.JLabel();
        si_Panelbg2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_showemail.setEditable(false);
        txt_showemail.setBackground(new java.awt.Color(204, 255, 204));
        txt_showemail.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        txt_showemail.setForeground(new java.awt.Color(0, 100, 0));
        txt_showemail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_showemail.setToolTipText("");
        txt_showemail.setBorder(null);
        txt_showemail.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt_showemail.setName(""); // NOI18N
        txt_showemail.setOpaque(false);
        txt_showemail.setRequestFocusEnabled(false);
        txt_showemail.setVerifyInputWhenFocusTarget(false);
        txt_showemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_showemailActionPerformed(evt);
            }
        });
        getContentPane().add(txt_showemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 320, 30));

        si_Separator.setBackground(new java.awt.Color(0, 100, 0));
        si_Separator.setForeground(new java.awt.Color(0, 0, 0));
        si_Separator.setOpaque(true);
        getContentPane().add(si_Separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 550, 2));

        si_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Datos-Ani Icon Logo.png"))); // NOI18N
        getContentPane().add(si_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 50));

        si_AboutWord1.setFont(new java.awt.Font("SansSerif", 1, 40)); // NOI18N
        si_AboutWord1.setForeground(new java.awt.Color(255, 255, 255));
        si_AboutWord1.setText("AUTHENTICATION");
        getContentPane().add(si_AboutWord1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 360, 40));

        Si_Username1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        Si_Username1.setForeground(new java.awt.Color(0, 100, 0));
        Si_Username1.setText("Verify with Email Message");
        getContentPane().add(Si_Username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, -1, -1));

        Si_Username2.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        Si_Username2.setForeground(new java.awt.Color(0, 100, 0));
        Si_Username2.setText("Please enter the authentication code.");
        getContentPane().add(Si_Username2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, -1, -1));

        Si_Username3.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        Si_Username3.setForeground(new java.awt.Color(0, 100, 0));
        Si_Username3.setText("A 6-digit authentication code will be sent to");
        getContentPane().add(Si_Username3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, -1, -1));

        txt_OTP.setFont(new java.awt.Font("SansSerif", 1, 40)); // NOI18N
        txt_OTP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_OTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_OTPActionPerformed(evt);
            }
        });
        txt_OTP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_OTPKeyTyped(evt);
            }
        });
        getContentPane().add(txt_OTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, 410, 70));

        btn_OTPcheck.setBackground(new java.awt.Color(204, 255, 204));
        btn_OTPcheck.setFont(new java.awt.Font("SansSerif", 1, 35)); // NOI18N
        btn_OTPcheck.setForeground(new java.awt.Color(0, 100, 0));
        btn_OTPcheck.setText("SUBMIT");
        btn_OTPcheck.setBorderPainted(false);
        btn_OTPcheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_OTPcheckActionPerformed(evt);
            }
        });
        getContentPane().add(btn_OTPcheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 490, 300, 50));

        si_Panelbg1.setBackground(new java.awt.Color(204, 255, 204, 150));
        si_Panelbg1.setOpaque(true);
        getContentPane().add(si_Panelbg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 900, 230));

        si_Panelbg2.setBackground(new java.awt.Color(204, 255, 204, 150));
        si_Panelbg2.setOpaque(true);
        getContentPane().add(si_Panelbg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 344, 900, 210));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_OTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_OTPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_OTPActionPerformed

    private void btn_OTPcheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_OTPcheckActionPerformed
        try {
            int enteredOTP = Integer.parseInt(txt_OTP.getText());
            if (enteredOTP == otp) {
                JOptionPane.showMessageDialog(this, "OTP verified!");
                
                new insidelogin(loggedInFarmerId, showfirstname, getemail, botanicfam_code, plotlandcode, total_sales, total_costs, getrtdate).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid OTP! Please try again.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid OTP.");
        }
    }//GEN-LAST:event_btn_OTPcheckActionPerformed

    private void txt_showemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_showemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_showemailActionPerformed

    private void txt_OTPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_OTPKeyTyped
       char qnty = evt.getKeyChar();
       if(Character.isLetter(qnty)&&!evt.isAltDown()){
           evt.consume();}
    }//GEN-LAST:event_txt_OTPKeyTyped

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
            java.util.logging.Logger.getLogger(verifyOTP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(verifyOTP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(verifyOTP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(verifyOTP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int loggedInFarmerId = 0;
                String getemail = null;
                String showfirstname = null;
                int botanicfam_code = 0;
                int plotlandcode = 0;
                String total_sales = null;
                String total_costs = null;
                
                
                
                new verifyOTP(loggedInFarmerId, getemail, showfirstname, botanicfam_code, plotlandcode, total_sales, total_costs).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Si_Username1;
    private javax.swing.JLabel Si_Username2;
    private javax.swing.JLabel Si_Username3;
    private javax.swing.JButton btn_OTPcheck;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel si_AboutWord1;
    private javax.swing.JLabel si_Panelbg1;
    private javax.swing.JLabel si_Panelbg2;
    private javax.swing.JSeparator si_Separator;
    private javax.swing.JLabel si_logo;
    private javax.swing.JTextField txt_OTP;
    private javax.swing.JTextField txt_showemail;
    // End of variables declaration//GEN-END:variables
}
