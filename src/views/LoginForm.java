/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controller.AuthenticationController;
import javax.swing.JOptionPane;
import model.BabyFinger;
import model.IndexFinger;
import model.MiddleFinger;
import model.RingFinger;
import model.Thumb;
import model.User;

/**
 *
 * @author Eranga
 */
public class LoginForm extends javax.swing.JFrame {
    float len_thumbf;
    float width_thumbf;
    float len_indexf;
    float width_indexf;
    float len_middlef;
    float width_middlef;
    float len_ringf;
    float width_ringf;
    float len_littlef;
    float width_littlef;
    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
        threshold.setText("0.1");
        this.setLocationRelativeTo(null);
        User.setThreshold((float) 0.1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        signUp = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        thumbLength = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        middleLength = new javax.swing.JTextField();
        indexLength = new javax.swing.JTextField();
        ringLength = new javax.swing.JTextField();
        littleLength = new javax.swing.JTextField();
        littleWidth = new javax.swing.JTextField();
        ringWidth = new javax.swing.JTextField();
        middleWidth = new javax.swing.JTextField();
        indexWidth = new javax.swing.JTextField();
        thumbWidth = new javax.swing.JTextField();
        scan = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        id_text = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        threshold = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        signUp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        signUp.setForeground(new java.awt.Color(255, 0, 102));
        signUp.setText("SignUp");
        signUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signUp))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(signUp, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hand.jpg"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Thumb");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Index Finger");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Middle Finger");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Ring Finger");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Little finger");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 255));
        jLabel8.setText("Length(cm)");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 255));
        jLabel9.setText("Width(cm)");

        thumbWidth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thumbWidthActionPerformed(evt);
            }
        });

        scan.setText("Scan");
        scan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("User Id");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Threshold");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(231, 231, 231)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ringLength, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                            .addComponent(middleLength, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(indexLength, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(thumbLength, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(littleLength))
                                        .addGap(114, 114, 114)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(littleWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(ringWidth, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                                                .addComponent(middleWidth, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(indexWidth, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(thumbWidth, javax.swing.GroupLayout.Alignment.TRAILING))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11))
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(id_text)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(threshold, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))))))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scan)
                        .addGap(176, 176, 176))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(thumbLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(thumbWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(indexLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(indexWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(middleWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(middleLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(ringLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ringWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(littleLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(littleWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(threshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(scan)))))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void thumbWidthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thumbWidthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thumbWidthActionPerformed

    private boolean validate(String x){
        if (!x.equals("")) {
            try {
                
                Float.parseFloat(x);
                
                if(x.matches("\\d*")){
                    if(x.matches("(\\d{1}||\\d{2})")){
                        return true;
                    }
                    return false;
                }
                else if(x.matches("(\\d{1}||\\d{2})(.?)((\\d{1}||\\d{2}||\\d{3}||\\d{4}))")){
                    return true;
                }else{
                    return false;
                }
            } catch (NumberFormatException nfe) {
                return false;
            }
        }
        return false;
        
    }
    private void signUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpActionPerformed
            new SignUpForm().setVisible(true);
            this.dispose();
    }//GEN-LAST:event_signUpActionPerformed

    private void scanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanActionPerformed
        boolean proceed=false;
        String user_id=id_text.getText().trim();
        String len_thumb=thumbLength.getText().trim();
        String width_thumb=(thumbWidth.getText().trim());
        String len_index=(indexLength.getText().trim());
        String width_index=(indexWidth.getText().trim());
        String len_middle=(middleLength.getText().trim());
        String width_middle=(middleWidth.getText().trim());
        String len_ring=(ringLength.getText().trim());
        String width_ring=(ringWidth.getText().trim());
        String len_little=(littleLength.getText().trim());
        String width_little=(littleWidth.getText().trim());
        if(validate(len_thumb) && validate(width_thumb)){
            len_thumbf=Float.parseFloat(len_thumb);
            width_thumbf=Float.parseFloat(width_thumb);
            if(validate(len_index) && validate(width_index)){
                len_indexf=Float.parseFloat(len_index);
                width_indexf=Float.parseFloat(width_index);
                if(validate(len_middle) && validate(width_middle)){
                    len_middlef=Float.parseFloat(len_middle);
                    width_middlef=Float.parseFloat(width_middle);
                    if(validate(len_ring) && validate(width_ring)){
                        len_ringf=Float.parseFloat(len_ring);
                        width_ringf=Float.parseFloat(width_ring);
                        if(validate(len_little) && validate(width_little)){
                            len_littlef=Float.parseFloat(len_little);
                            width_littlef=Float.parseFloat(width_little);
                            proceed=true;
                        }else{
                            JOptionPane.showMessageDialog(null, "You have an error in Little Finger fields"
                                    + "\n Values must not be greator than 100cm",
                                "Information", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "You have an error in Ring Finger fields"
                                + "\n Values must not be greator than 100cm",
                            "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "You have an error in middle Finger fields"
                            + "\n Values must not be greator than 100cm",
                        "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "You have an error in index Finger fields"
                        + "\n Values must not be greator than 100cm",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "You have an error in thumb fields"
                    + "\n Values must not be greator than 100cm",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        if(proceed){
            String threshold1=threshold.getText();
            float thresholdFloat=0;
            try{
                thresholdFloat=Float.parseFloat(threshold1);
                User.setThreshold(thresholdFloat);
                Thumb thumb=new Thumb(len_thumbf,width_thumbf);
                IndexFinger index=new IndexFinger(len_indexf,width_indexf);
                MiddleFinger middle=new MiddleFinger(len_middlef, width_middlef);
                RingFinger ring=new RingFinger(len_ringf, width_ringf);
                BabyFinger little=new BabyFinger(len_littlef, width_littlef);
                AuthenticationController.authenticateUser(middle, index,
                        ring, little, thumb, user_id);
                clearFields();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "You have an error in threshold field",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            
            
        }
        
        
    }//GEN-LAST:event_scanActionPerformed
    private void clearFields(){
        thumbLength.setText("");
        thumbWidth.setText("");
        indexLength.setText("");
        indexWidth.setText("");
        middleLength.setText("");
        middleWidth.setText("");
        ringLength.setText("");
        ringWidth.setText("");
        littleLength.setText("");
        littleWidth.setText("");
    }
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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField id_text;
    private javax.swing.JTextField indexLength;
    private javax.swing.JTextField indexWidth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField littleLength;
    private javax.swing.JTextField littleWidth;
    private javax.swing.JTextField middleLength;
    private javax.swing.JTextField middleWidth;
    private javax.swing.JTextField ringLength;
    private javax.swing.JTextField ringWidth;
    private javax.swing.JButton scan;
    private javax.swing.JButton signUp;
    private javax.swing.JTextField threshold;
    private javax.swing.JTextField thumbLength;
    private javax.swing.JTextField thumbWidth;
    // End of variables declaration//GEN-END:variables
}
