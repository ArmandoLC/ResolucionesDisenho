package Vista;

import DTOs.DTOResolucion;
import DTOs.DTOSolicitud;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import org.jdesktop.swingx.JXEditorPane;

public class DialogRegistrarResolucion extends javax.swing.JDialog {

    private final UIBackofficeCoordinador uibackoffice;
    
    private DTOSolicitud solicitud;
    private String introduccion = " <b>{ Hora y fecha }</b>, el suscrito <b>{ " + 
                        "Nombre del Director }</b>, Director de la Escuela de Ingeniería en Computación en " +
                        "atención al caso de <b>{ Situacion de inconsistencia }</b> del estudiante <b>{ Nombre del afectado }</b>" +
                        ", carné <b>{ carné del afectado }</b> , sobre el curso <b>{ código y nombre del curso }</b> " +
                        ", grupo <b>{ Número de grupo }</b>, del <b>{ Semestre }</b> , resuelvo:";
    
    private String resultado =   "Por un error involuntario, no se tramitó la inclusión del estudiante <b>{ Nombre del estudiante }</b>" +
                        "con identificación <b>{ carné del estudiante }</b> en el curso <b>{ código y nombre del curso }</b>" +
                        ", grupo <b>{ Número de grupo }</b> impartido por el " +
                        "profesor <b>{ Nombre del profesor }</b> en el <b>{ Semestre }</b>, " + 
                        "el profesor no pudo registrar en el acta la calificación obtenida\n" +
                        "por el estudiante.  ";
    
    private String considerandos = "Después de haber realizado la investigación del caso, y consultado al profesor" +
                        "<b>{ Nombre del profesor }</b>, quien impartió el curso <b>{ código y nombre del curso }</b>" +
                        ", <b>{ Número de grupo }</b>, del <b>{ Semestre }</b> " +
                        " se logra comprobar que el estudiante <b>{ Nombre del afectado }</b>," +
                        "carné <b>{ carné del estudiante }</b>, efectivamente aprobó el curso con una nota de noventa y cinco" +
                        "(95), por lo que esta Dirección solicita gestionar la modificación del acta\n" +
                        "correspondiente. ";
    
    private String resuelvo =   " Autorizar la modificación del acta del curso  <b>{ código y nombre del curso }</b>" +
                        " grupo <b>{ Número de grupo }</b> en el <b>{ Semestre }</b>" +
                        "impartido por el profesor <b>{ Nombre del profesor }</b> para inc,luir al estudiante" +
                        "<b>{ Nombre del afectado }</b>, carné <b>{ carné del estudiante }</b> con una nota de aprobación" +
                        "de noventa y cinco (95). ";
    
    public DialogRegistrarResolucion(java.awt.Frame parent, boolean modal, DTOSolicitud solicitud) {
        super(parent, modal);
        initComponents();
        
        uibackoffice = new UIBackofficeCoordinador((Backoffice) parent);
        txtEditor.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        txtEditor.setContentType("text/html");
        txtEditor.setText(introduccion);
        btnIntroduccion.setSelected(true);
        this.solicitud = solicitud;
        
        uibackoffice.ConsultarResolucion(this);
        
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtEditor = new org.jdesktop.swingx.JXEditorPane();
        btnIntroduccion = new javax.swing.JToggleButton();
        btnResultado = new javax.swing.JToggleButton();
        btnConsiderandos = new javax.swing.JToggleButton();
        btnResuelvo = new javax.swing.JToggleButton();
        btnRegistrar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtEditor.setBorder(null);
        txtEditor.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 18)); // NOI18N
        txtEditor.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtEditor.setMargin(new java.awt.Insets(20, 20, 20, 20));
        txtEditor.setOpaque(false);
        jScrollPane3.setViewportView(txtEditor);

        btnIntroduccion.setText("Introducción");
        btnIntroduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntroduccionActionPerformed(evt);
            }
        });

        btnResultado.setText("Resultado");
        btnResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultadoActionPerformed(evt);
            }
        });

        btnConsiderandos.setText("Considerandos");
        btnConsiderandos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsiderandosActionPerformed(evt);
            }
        });

        btnResuelvo.setText("Resuelvo");
        btnResuelvo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResuelvoActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnIntroduccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConsiderandos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnResuelvo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIntroduccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnConsiderandos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnResuelvo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(224, 224, 224)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrar)
                .addContainerGap())
            .addComponent(jScrollPane3)
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

    private void btnIntroduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntroduccionActionPerformed
        if( btnIntroduccion.isSelected() ){ 
            if(btnResultado.isSelected()) resultado = txtEditor.getText();
            if(btnConsiderandos.isSelected()) considerandos = txtEditor.getText();
            if(btnResuelvo.isSelected()) resuelvo = txtEditor.getText();
            btnResultado.setSelected(false);
            btnConsiderandos.setSelected(false);
            btnResuelvo.setSelected(false);
            txtEditor.setText(introduccion);
        }
    }//GEN-LAST:event_btnIntroduccionActionPerformed

    private void btnResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultadoActionPerformed
        if( btnResultado.isSelected() ){ 
            if(btnIntroduccion.isSelected()) introduccion = txtEditor.getText();
            if(btnConsiderandos.isSelected()) considerandos = txtEditor.getText();
            if(btnResuelvo.isSelected()) resuelvo = txtEditor.getText();
            btnIntroduccion.setSelected(false);
            btnConsiderandos.setSelected(false);
            btnResuelvo.setSelected(false);
            txtEditor.setText(resultado);
        }
    }//GEN-LAST:event_btnResultadoActionPerformed

    private void btnConsiderandosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsiderandosActionPerformed
        if(  btnConsiderandos.isSelected() ){ 
            if(btnIntroduccion.isSelected()) introduccion = txtEditor.getText();
            if(btnResultado.isSelected()) resultado = txtEditor.getText();
            if(btnResuelvo.isSelected()) resuelvo = txtEditor.getText();
            btnIntroduccion.setSelected(false);
            btnResultado.setSelected(false);
            btnResuelvo.setSelected(false);
            txtEditor.setText(considerandos);
        }
    }//GEN-LAST:event_btnConsiderandosActionPerformed

    private void btnResuelvoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResuelvoActionPerformed
        if( btnResuelvo.isSelected() ){ 
            if(btnIntroduccion.isSelected()) introduccion = txtEditor.getText();
            if(btnResultado.isSelected()) resultado = txtEditor.getText();
            if(btnConsiderandos.isSelected()) considerandos = txtEditor.getText();
            btnIntroduccion.setSelected(false);
            btnResultado.setSelected(false);
            btnConsiderandos.setSelected(false);
            txtEditor.setText(resuelvo);
        }
    }//GEN-LAST:event_btnResuelvoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        uibackoffice.RegistrarResolucion(this);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Dialog dialog  = new DialogGuardarResolucion((Frame) this.getParent(), true, solicitud);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnConsiderandos;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JToggleButton btnIntroduccion;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JToggleButton btnResuelvo;
    private javax.swing.JToggleButton btnResultado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXEditorPane txtEditor;
    // End of variables declaration//GEN-END:variables

    public String getIntroduccion() {
        return introduccion;
    }

    public void setIntroduccion(String introduccion) {
        this.introduccion = introduccion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getConsiderandos() {
        return considerandos;
    }

    public void setConsiderandos(String considerandos) {
        this.considerandos = considerandos;
    }

    public String getResuelvo() {
        return resuelvo;
    }

    public void setResuelvo(String resuelvo) {
        this.resuelvo = resuelvo;
    }

    public JXEditorPane getTxtEditor() {
        return txtEditor;
    }

    public void setTxtEditor(JXEditorPane txtEditor) {
        this.txtEditor = txtEditor;
    }

    public DTOSolicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(DTOSolicitud solicitud) {
        this.solicitud = solicitud;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(JButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public JToggleButton getBtnConsiderandos() {
        return btnConsiderandos;
    }

    public void setBtnConsiderandos(JToggleButton btnConsiderandos) {
        this.btnConsiderandos = btnConsiderandos;
    }

    public JToggleButton getBtnIntroduccion() {
        return btnIntroduccion;
    }

    public void setBtnIntroduccion(JToggleButton btnIntroduccion) {
        this.btnIntroduccion = btnIntroduccion;
    }

    public JToggleButton getBtnResuelvo() {
        return btnResuelvo;
    }

    public void setBtnResuelvo(JToggleButton btnResuelvo) {
        this.btnResuelvo = btnResuelvo;
    }

    public JToggleButton getBtnResultado() {
        return btnResultado;
    }

    public void setBtnResultado(JToggleButton btnResultado) {
        this.btnResultado = btnResultado;
    }
    
    
    


}
