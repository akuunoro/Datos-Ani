
package datosani;


public class home extends javax.swing.JFrame {
    private int loggedInFarmerId = 0;
    private int botanicfam_code;
    
    public home(int loggedInFarmerId, int botanicfam_code) {
        
        initComponents();
        System.out.println("Logged in Farmer ID: " + loggedInFarmerId);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        H_logo = new javax.swing.JLabel();
        btn_Hhome = new javax.swing.JButton();
        btn_HAbout = new javax.swing.JButton();
        H_separator = new javax.swing.JSeparator();
        H_logoword = new javax.swing.JLabel();
        btn_Hsignup = new javax.swing.JButton();
        btn_Hsignin = new javax.swing.JButton();
        H_bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        H_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Datos-Ani Icon Logo.png"))); // NOI18N
        getContentPane().add(H_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 50));

        btn_Hhome.setBackground(new java.awt.Color(204, 255, 204));
        btn_Hhome.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_Hhome.setForeground(new java.awt.Color(0, 100, 0));
        btn_Hhome.setText("HOME");
        btn_Hhome.setToolTipText("");
        btn_Hhome.setBorderPainted(false);
        btn_Hhome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Hhome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HhomeActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Hhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 90, 30));

        btn_HAbout.setBackground(new java.awt.Color(204, 255, 204));
        btn_HAbout.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_HAbout.setForeground(new java.awt.Color(0, 100, 0));
        btn_HAbout.setText("ABOUT");
        btn_HAbout.setToolTipText("");
        btn_HAbout.setBorderPainted(false);
        btn_HAbout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_HAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HAboutActionPerformed(evt);
            }
        });
        getContentPane().add(btn_HAbout, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 100, 30));

        H_separator.setBackground(new java.awt.Color(0, 100, 0));
        H_separator.setForeground(new java.awt.Color(0, 0, 0));
        H_separator.setOpaque(true);
        getContentPane().add(H_separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 550, 2));

        H_logoword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Datos-Ani Logo2.png"))); // NOI18N
        getContentPane().add(H_logoword, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 550, 200));

        btn_Hsignup.setBackground(new java.awt.Color(204, 255, 204));
        btn_Hsignup.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_Hsignup.setForeground(new java.awt.Color(0, 100, 0));
        btn_Hsignup.setText("SIGN UP");
        btn_Hsignup.setBorderPainted(false);
        btn_Hsignup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Hsignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HsignupActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Hsignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, 130, 50));

        btn_Hsignin.setBackground(new java.awt.Color(204, 255, 204));
        btn_Hsignin.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_Hsignin.setForeground(new java.awt.Color(0, 100, 0));
        btn_Hsignin.setText("SIGN IN");
        btn_Hsignin.setBorderPainted(false);
        btn_Hsignin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Hsignin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HsigninActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Hsignin, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, 130, 50));

        H_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG1.png"))); // NOI18N
        getContentPane().add(H_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_HhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HhomeActionPerformed
        new home(loggedInFarmerId, botanicfam_code).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_HhomeActionPerformed

    private void btn_HAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HAboutActionPerformed
        new aboutda(loggedInFarmerId).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_HAboutActionPerformed

    private void btn_HsigninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HsigninActionPerformed
        new interfacesignin(loggedInFarmerId, botanicfam_code).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_HsigninActionPerformed

    private void btn_HsignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HsignupActionPerformed
        new interfacesignup(loggedInFarmerId, botanicfam_code).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_HsignupActionPerformed

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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int loggedInFarmerId = 0;
                int botanicfam_code = 0;
                new home(loggedInFarmerId,botanicfam_code).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel H_bg;
    private javax.swing.JLabel H_logo;
    private javax.swing.JLabel H_logoword;
    private javax.swing.JSeparator H_separator;
    private javax.swing.JButton btn_HAbout;
    private javax.swing.JButton btn_Hhome;
    private javax.swing.JButton btn_Hsignin;
    private javax.swing.JButton btn_Hsignup;
    // End of variables declaration//GEN-END:variables
}
