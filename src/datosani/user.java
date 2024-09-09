/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosani;

/**
 *
 * @author Russel
 */
public class user extends javax.swing.JFrame {
   private String getemail;
   private int loggedInFarmerId;
   private String showfirstname;
   private int botanicfam_code; 
   private int plotlandcode;
   private String total_sales; 
   private String total_costs;
   private String getrtdate;
   
    public user(int loggedInFarmerId, String showfirstname, int botanicfam_code) {
        this.loggedInFarmerId = loggedInFarmerId;
        this.botanicfam_code = botanicfam_code;
        this.showfirstname = showfirstname;
        initComponents();
        
        
        
        
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        ghf = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ad_cod_Save = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        logo4 = new javax.swing.JLabel();
        btn_LsHome2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 26)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Sign Out");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, 130, 40));

        ghf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Datos-Ani Logo2.png"))); // NOI18N
        getContentPane().add(ghf, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 550, 260));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Sign Out (Transparent).png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 430, 40, 40));

        ad_cod_Save.setBackground(new java.awt.Color(255, 153, 153));
        ad_cod_Save.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        ad_cod_Save.setForeground(new java.awt.Color(204, 0, 0));
        ad_cod_Save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ad_cod_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ad_cod_SaveActionPerformed(evt);
            }
        });
        getContentPane().add(ad_cod_Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 200, 40));

        jSeparator5.setBackground(new java.awt.Color(0, 100, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setOpaque(true);
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 550, 2));

        logo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Datos-Ani Icon Logo.png"))); // NOI18N
        getContentPane().add(logo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 50));

        btn_LsHome2.setBackground(new java.awt.Color(204, 255, 204));
        btn_LsHome2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_LsHome2.setForeground(new java.awt.Color(0, 100, 0));
        btn_LsHome2.setText("HOME");
        btn_LsHome2.setToolTipText("");
        btn_LsHome2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_LsHome2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LsHome2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_LsHome2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 90, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG1.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ad_cod_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ad_cod_SaveActionPerformed
        new home(loggedInFarmerId, botanicfam_code).setVisible(true);
        loggedInFarmerId = 0;
        this.dispose();
    }//GEN-LAST:event_ad_cod_SaveActionPerformed

    private void btn_LsHome2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LsHome2ActionPerformed
        new insidelogin(loggedInFarmerId, showfirstname, getemail, botanicfam_code, plotlandcode, total_sales, total_costs, getrtdate).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_LsHome2ActionPerformed

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
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int loggedInFarmerId = 0;
                String showfirstname = null;
                int botanicfam_code = 0;
                new user(loggedInFarmerId, showfirstname, botanicfam_code).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ad_cod_Save;
    private javax.swing.JButton btn_LsHome2;
    private javax.swing.JLabel ghf;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel logo4;
    // End of variables declaration//GEN-END:variables
}
