package Vista;

import DTOs.DTOSolicitud;
import Enums.Estado;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import org.jdesktop.swingx.JXDatePicker;

public class BackofficeCoordinador extends Backoffice{
    
    private JPopupMenu popup;
    private UIBackofficeCoordinador uibackoffice = new UIBackofficeCoordinador(this);;
            
    public BackofficeCoordinador() {
        initLookAndFeel();
        initComponents();
        initVariables();
        initConsultaSolicitudes();
    }
    
    private void initConsultaSolicitudes(){
        uibackoffice.ConsultarSolicitudes();
    }
    
    private void initVariables(){
        initModel(tabSolicitudes);
        setEstados();
        setFechas();
        setListeners();
        setLocationRelativeTo(null);
    }
    
    private void setEstados(){
        cbEstado.addItem("Todas");
        for(Estado estado : Estado.values())
            cbEstado.addItem(estado.toString());
    }
    
    private void setFechas(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -30);
        dpDesde.setDate(calendar.getTime());
        calendar.add(Calendar.DAY_OF_MONTH, 31);
        dpHasta.setDate(calendar.getTime());
    }
    
    private void setListeners(){
        tabSolicitudes.addMouseListener(mouseAdapter);
        cbEstado.addItemListener(itemListener);
    }

    private final ItemListener itemListener = new ItemListener (){
        @Override
        public void itemStateChanged(ItemEvent e) {
            uibackoffice.ConsultarSolicitudes();
        }
    };
    
    private final MouseAdapter mouseAdapter = new MouseAdapter() {
        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.isPopupTrigger()) {
                int i = tabSolicitudes.rowAtPoint( e.getPoint() );
                int j = tabSolicitudes.columnAtPoint( e.getPoint() );
                if (! tabSolicitudes.isRowSelected(i)) tabSolicitudes.changeSelection(i, j, false, false);
                popup = new JPopupMenu(); addPopupMenuOptions();
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        }     
    };
    
    public void addPopupMenuOptions(){
        DTOSolicitud solicitud = tabModelSolicitudes.getSolicitud(tabSolicitudes.getSelectedRow());
        switch(Estado.valueOf(solicitud.getEstado())){
            case Anulada: setPopupOptionsSolicitudAnulada(solicitud); break;
            case Tramitada: setPopupOptionsSolicitudTramitada(solicitud); break;
            case Pendiente: setPopupOptionsSolicitudPendiente(solicitud); break;
        }
        setPopupOptionsSolicitud(solicitud);
    }
    
    public void setPopupOptionsSolicitudAnulada(DTOSolicitud solicitud){
        JMenuItem item = new JMenuItem("Motivo de anulación");
        item.addActionListener((ActionEvent e) -> {
            Dialog dialog = new DialogAclaracion(this, true, solicitud);
            dialog.setVisible(true);
        }); popup.add(item);
    }
    
    public void setPopupOptionsSolicitudTramitada(DTOSolicitud solicitud){
        JMenuItem item = new JMenuItem();
        item.setText("Resolución");
        item.addActionListener((ActionEvent e) -> {
            Dialog dialog = new DialogRegistrarResolucion(this, true, solicitud);
            dialog.setVisible(true);
        }); popup.add(item);
    }
    
    public void setPopupOptionsSolicitudPendiente(DTOSolicitud solicitud){
        JMenuItem itemGenerar = new JMenuItem("Tramitar solicitud");
        itemGenerar.addActionListener((ActionEvent e) -> {
            uibackoffice.TramitarSolicitud(solicitud);
        }); popup.add(itemGenerar);
        JMenuItem itemVer = new JMenuItem("Anular solicitud");
        itemVer.addActionListener((ActionEvent e) -> {
            Dialog dialog = new DialogAclaracion(this, true, solicitud);
            dialog.setVisible(true);
        }); popup.add(itemVer);
    }
    
    public void setPopupOptionsSolicitud(DTOSolicitud solicitud){
        JMenuItem itemVer = new JMenuItem("Visualizar detalles");
        itemVer.addActionListener((ActionEvent e) -> {
            Dialog dialog = new DialogDetallesSolicitud(this, true, solicitud);
            dialog.setVisible(true);
        }); popup.add(itemVer);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        busyPainter1 = new org.jdesktop.swingx.painter.BusyPainter();
        panelFondo = new javax.swing.JPanel();
        cbEstado = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();
        btnRegistrarSolicitud = new javax.swing.JButton();
        btnExtraerExcel = new javax.swing.JButton();
        dpDesde = new org.jdesktop.swingx.JXDatePicker();
        dpHasta = new org.jdesktop.swingx.JXDatePicker();
        linkEstadisticas = new org.jdesktop.swingx.JXHyperlink();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabSolicitudes = new org.jdesktop.swingx.JXTable();
        linkReporteSolicitudes = new org.jdesktop.swingx.JXHyperlink();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mitemInconsistencia = new javax.swing.JMenuItem();
        mitemConsultarSolicitudEstudiante = new javax.swing.JMenuItem();
        mitemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFondo.setBackground(new java.awt.Color(255, 255, 255));

        cbEstado.setToolTipText("Filtrar las solicitudes por estado");
        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
            }
        });

        jLabel1.setText("Filtrar por estado:");

        btnRegistrarSolicitud.setText("Registrar");
        btnRegistrarSolicitud.setToolTipText("Registro de solicitudes");
        btnRegistrarSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarSolicitudActionPerformed(evt);
            }
        });

        btnExtraerExcel.setText("Importar solicitudes CSV");
        btnExtraerExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtraerExcelActionPerformed(evt);
            }
        });

        linkEstadisticas.setText("Estadísticas");
        linkEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkEstadisticasActionPerformed(evt);
            }
        });

        jLabel2.setText("Desde:");

        jLabel3.setText("Hasta:");

        tabSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabSolicitudes);

        linkReporteSolicitudes.setText("Reporte de solicitudes según las fechas indicadas");
        linkReporteSolicitudes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkReporteSolicitudesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dpDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dpHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(linkReporteSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(linkEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelFondoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 306, Short.MAX_VALUE)
                        .addComponent(btnExtraerExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistrarSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(linkEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dpDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dpHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(linkReporteSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRegistrarSolicitud)
                        .addComponent(btnExtraerExcel))
                    .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jMenu1.setText("Principal");

        mitemInconsistencia.setText("Registrar inconsistencia");
        mitemInconsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitemInconsistenciaActionPerformed(evt);
            }
        });
        jMenu1.add(mitemInconsistencia);

        mitemConsultarSolicitudEstudiante.setText("Consultar solicitudes estudiante");
        mitemConsultarSolicitudEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitemConsultarSolicitudEstudianteActionPerformed(evt);
            }
        });
        jMenu1.add(mitemConsultarSolicitudEstudiante);

        mitemSalir.setText("Salir");
        mitemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitemSalirActionPerformed(evt);
            }
        });
        jMenu1.add(mitemSalir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void linkEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkEstadisticasActionPerformed
        JDialog dialog = new DialogEstadisticas(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_linkEstadisticasActionPerformed

    private void mitemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitemSalirActionPerformed
        java.lang.System.exit(0);
    }//GEN-LAST:event_mitemSalirActionPerformed

    private void mitemInconsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitemInconsistenciaActionPerformed
        JDialog dialog = new DialogInconsistencia(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_mitemInconsistenciaActionPerformed

    private void linkReporteSolicitudesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkReporteSolicitudesActionPerformed
        JDialog dialog = new DialogSolicitudesAtendidas(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_linkReporteSolicitudesActionPerformed

    private void btnExtraerExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtraerExcelActionPerformed
        uibackoffice.RegistrarSolicitudes();
    }//GEN-LAST:event_btnExtraerExcelActionPerformed

    private void btnRegistrarSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarSolicitudActionPerformed
        JDialog dialog = new DialogRegistrarSolicitud(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnRegistrarSolicitudActionPerformed

    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEstadoActionPerformed

    private void mitemConsultarSolicitudEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitemConsultarSolicitudEstudianteActionPerformed
        JDialog dialog = new DialogFiltrarSolicitudEstudiante(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_mitemConsultarSolicitudEstudianteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExtraerExcel;
    private javax.swing.JButton btnRegistrarSolicitud;
    private org.jdesktop.swingx.painter.BusyPainter busyPainter1;
    private javax.swing.JComboBox<String> cbEstado;
    private org.jdesktop.swingx.JXDatePicker dpDesde;
    private org.jdesktop.swingx.JXDatePicker dpHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXHyperlink linkEstadisticas;
    private org.jdesktop.swingx.JXHyperlink linkReporteSolicitudes;
    private javax.swing.JMenuItem mitemConsultarSolicitudEstudiante;
    private javax.swing.JMenuItem mitemInconsistencia;
    private javax.swing.JMenuItem mitemSalir;
    private javax.swing.JPanel panelFondo;
    private org.jdesktop.swingx.JXTable tabSolicitudes;
    // End of variables declaration//GEN-END:variables

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new BackofficeCoordinador().setVisible(true);
        });
    }

    public JComboBox<String> getCbEstado() {
        return cbEstado;
    }

    public void setCbEstado(JComboBox<String> cbEstado) {
        this.cbEstado = cbEstado;
    }

    public JXDatePicker getDpDesde() {
        return dpDesde;
    }

    public void setDpDesde(JXDatePicker dpDesde) {
        this.dpDesde = dpDesde;
    }

    public JXDatePicker getDpHasta() {
        return dpHasta;
    }

    public void setDpHasta(JXDatePicker dpHasta) {
        this.dpHasta = dpHasta;
    }
    
}
