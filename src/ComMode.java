
/**
 *
 * @author Ishadi
 */
public class ComMode extends javax.swing.JFrame {

    /**
     * Creates new form ComMode
     */
    public ComMode() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnGrup = new javax.swing.ButtonGroup();
        player1btn = new javax.swing.JRadioButton();
        player2btn = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        Gobtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(353, 332));
        setResizable(false);
        getContentPane().setLayout(null);

        BtnGrup.add(player1btn);
        player1btn.setFont(new java.awt.Font("Press Start 2P", 0, 10)); // NOI18N
        player1btn.setForeground(new java.awt.Color(255, 255, 255));
        player1btn.setText("Player #1");
        player1btn.setContentAreaFilled(false);
        player1btn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(player1btn);
        player1btn.setBounds(50, 130, 130, 40);

        BtnGrup.add(player2btn);
        player2btn.setFont(new java.awt.Font("Press Start 2P", 0, 10)); // NOI18N
        player2btn.setForeground(new java.awt.Color(255, 255, 255));
        player2btn.setText("Player #2");
        player2btn.setContentAreaFilled(false);
        getContentPane().add(player2btn);
        player2btn.setBounds(50, 180, 130, 40);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Press Start 2P", 1, 18)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("You wanna play as");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 60, 360, 50);

        Gobtn.setBackground(new java.awt.Color(51, 0, 0));
        Gobtn.setFont(new java.awt.Font("Press Start 2P", 1, 24)); // NOI18N
        Gobtn.setText("Go");
        Gobtn.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.MatteBorder(null)));
        Gobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GobtnActionPerformed(evt);
            }
        });
        getContentPane().add(Gobtn);
        Gobtn.setBounds(210, 230, 110, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/p2.jpg"))); // NOI18N
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(102, 0, 0)));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-5, -5, 360, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GobtnActionPerformed
        if(player1btn.isSelected())
            Computer=Boolean.TRUE;
        else 
        {
            Computer=Boolean.FALSE;
            
        }
        this.launch();
        
    }//GEN-LAST:event_GobtnActionPerformed

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
            java.util.logging.Logger.getLogger(ComMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComMode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BtnGrup;
    private javax.swing.JButton Gobtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton player1btn;
    private javax.swing.JRadioButton player2btn;
    // End of variables declaration//GEN-END:variables
    boolean Computer;
    
    void launch()
    {
       
        board bb=new board();
      
        bb.launch(Boolean.TRUE);
        
      
       
      
       bb.setVisible(true);
       
       bb.setLocationRelativeTo(null);
    }
    Boolean getPlayer()
    {
        return Computer;
    }
    

}

