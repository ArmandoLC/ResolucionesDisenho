
package Vista;

import javax.swing.JTextField;

public class DialogInconsistencia extends javax.swing.JDialog {

    UIBackofficeCoordinador uibackoffice;
    
    public DialogInconsistencia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        uibackoffice = new UIBackofficeCoordinador((Backoffice) parent);
        initComponents();
        setLocationRelativeTo(null);
    }

    public JTextField getTxtRegistrarInconsistencia() {
        return txtRegistrarInconsistencia;
    }

    public void setTxtRegistrarInconsistencia(JTextField txtRegistrarInconsistencia) {
        this.txtRegistrarInconsistencia = txtRegistrarInconsistencia;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtRegistrarInconsistencia = new javax.swing.JTextField();
        btnRegistrarInconsistencia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Resuma en unas palabras la inconsistencia: ");

        btnRegistrarInconsistencia.setText("Registrar inconsistencia");
        btnRegistrarInconsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarInconsistenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRegistrarInconsistencia)
                    .addComponent(jLabel1)
                    .addComponent(btnRegistrarInconsistencia, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtRegistrarInconsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarInconsistencia)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarInconsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarInconsistenciaActionPerformed
        uibackoffice.RegistrarInconsistencia(this);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegistrarInconsistenciaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarInconsistencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtRegistrarInconsistencia;
    // End of variables declaration//GEN-END:variables
}
