
import static java.lang.System.out;


public class EnterPlayerNames extends javax.swing.JFrame {
    String player1name;
    String player2name;

    public EnterPlayerNames() {
        initComponents();
        this.setLocationRelativeTo(null);

      
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        player1 = new javax.swing.JTextField();
        player2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(648, 380));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Engravers MT", 1, 55)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Player 1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 80, 380, 90);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Engravers MT", 1, 55)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Player 2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 170, 390, 90);

        player1.setFont(new java.awt.Font("Engravers MT", 1, 36)); // NOI18N
        player1.setOpaque(false);
        player1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actplayer1(evt);
            }
        });
        getContentPane().add(player1);
        player1.setBounds(420, 100, 213, 63);

        player2.setFont(new java.awt.Font("Engravers MT", 1, 36)); // NOI18N
        player2.setOpaque(false);
        player2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actplayer2(evt);
            }
        });
        getContentPane().add(player2);
        player2.setBounds(416, 175, 220, 71);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Engravers MT", 1, 48)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 102, 255));
        jButton1.setText("PLAY");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(200, 280, 230, 60);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/il2.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1, 2, 650, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void actplayer1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actplayer1
     
        
    }//GEN-LAST:event_actplayer1

    private void actplayer2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actplayer2
        
    }//GEN-LAST:event_actplayer2

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       player1name=player1.getText();
       player2name=player2.getText();
     
       this.setVisible(false);
       board bb=new board();
      
       bb.launch(ComMode);
      
       bb.getnames(player1name,player2name);
      
       bb.setVisible(true);
       
       bb.setLocationRelativeTo(null);
       
       
       
    }//GEN-LAST:event_jButton1ActionPerformed
    Boolean ComMode;
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EnterPlayerNames form=new EnterPlayerNames();
                form.setVisible(true);
                
            }
        });
    }
    void launch(Boolean ComMode)
    {
        this.ComMode=ComMode;
        if(ComMode)
        {
            
            this.player1.setFont(new java.awt.Font("Engravers MT", 1, 20));
            this.player1.setText("Master Hand");
            
            this.player1.setEditable(false);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField player1;
    private javax.swing.JTextField player2;
    // End of variables declaration//GEN-END:variables






}

