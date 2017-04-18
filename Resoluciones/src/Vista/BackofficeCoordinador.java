package Vista;

import DTOs.DTOSolicitud;
import Enums.Estado;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class BackofficeCoordinador extends Backoffice{
    
    UIBackofficeCoordinador uibackoffice;
    
    JPopupMenu popup;
    TableModelSolicitud tabModelSolicitudes;
            
    public BackofficeCoordinador() {
        
        initLookAndFeel();
        initComponents();
        setEstados();
       
        uibackoffice = new UIBackofficeCoordinador(this);
        tabModelSolicitudes = new TableModelSolicitud(tabSolicitudes);  
        tabSolicitudes.setModel(tabModelSolicitudes);
        tabSolicitudes.addMouseListener(mouseAdapter);
        loadTestData();
        
    }
    
    private void loadTestData(){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
            DTOSolicitud solicitud1 = new DTOSolicitud();
            solicitud1.setId(123);
            solicitud1.setFecha(sdf.parse("15/10/2013"));
            solicitud1.setIdSolicitante("1546468");
            solicitud1.setNombreSolicitante("Julian");
            solicitud1.setPeriodo("IS2017");
            solicitud1.setnGrupo(4);
            solicitud1.setCodigoCurso("156485fr");
            solicitud1.setEstado("Tramitada");
            DTOSolicitud solicitud2 = new DTOSolicitud();
            solicitud2.setId(456);
            solicitud2.setFecha(sdf.parse("13/10/2013"));
            solicitud2.setIdSolicitante("1546468");
            solicitud2.setNombreSolicitante("Julian");
            solicitud2.setPeriodo("IS2017");
            solicitud2.setnGrupo(4);
            solicitud2.setCodigoCurso("156485fr");
            solicitud2.setEstado("Anulada");
            DTOSolicitud solicitud3 = new DTOSolicitud();
            solicitud3.setId(789);
            solicitud3.setFecha(sdf.parse("12/10/2013"));
            solicitud3.setIdSolicitante("1546468");
            solicitud3.setNombreSolicitante("Julian");
            solicitud3.setPeriodo("IS2017");
            solicitud3.setnGrupo(4);
            solicitud3.setCodigoCurso("156485fr");
            solicitud3.setEstado("Pendiente");
            tabModelSolicitudes.addRow(solicitud1);
            tabModelSolicitudes.addRow(solicitud2);
            tabModelSolicitudes.addRow(solicitud3);
            tabSolicitudes.setModel(tabModelSolicitudes);
        }
        catch(Exception e){
            System.out.println("Error al colocar la hora");
        }
    }
    
    private final MouseAdapter mouseAdapter = new MouseAdapter() {

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("pressed");
        }
        
        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.isPopupTrigger()) {
                int row = tabSolicitudes.rowAtPoint( e.getPoint() );
                int column = tabSolicitudes.columnAtPoint( e.getPoint() );
                if (!tabSolicitudes.isRowSelected(row))
                    tabSolicitudes.changeSelection(row, column, false, false);
                popup = new JPopupMenu();
                addPopupMenuOptions(popup);
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        }
            
    };
    
    public void addPopupMenuOptions(JPopupMenu popup){
        
        int fila = tabSolicitudes.getSelectedRow();
        DTOSolicitud solicitud = tabModelSolicitudes.getSolicitud(fila);
        popup.add(new JMenuItem("#Solicitud " + String.valueOf(solicitud.getId())));
        
        if("Anulada".equals(solicitud.getEstado())){
            JMenuItem item = new JMenuItem("Ver aclaración");
            item.addActionListener((ActionEvent e) -> {
                System.out.println("Abriendo aclaracion");
            });
            popup.add(item);
        }
        
        else if("Tramitada".equals(solicitud.getEstado())){
            
            JMenuItem itemGenerar = new JMenuItem("Generar resolución");
            itemGenerar.addActionListener((ActionEvent e) -> {
                System.out.println("Generar resolución");
            }); popup.add(itemGenerar);
            
            JMenuItem itemVer = new JMenuItem("Ver resolución");
            itemVer.addActionListener((ActionEvent e) -> {
                System.out.println("Ver resolución");
            }); popup.add(itemVer);
   
        }
        else if("Pendiente".equals(solicitud.getEstado())){
        
            JMenuItem itemGenerar = new JMenuItem("Tramitar");
            itemGenerar.addActionListener((ActionEvent e) -> {
                uibackoffice.TramitarSolicitud(solicitud);
            }); popup.add(itemGenerar);
            
            JMenuItem itemVer = new JMenuItem("Anular");
            itemVer.addActionListener((ActionEvent e) -> {
                System.out.println("Anulando");
            }); popup.add(itemVer);
            
        }
        
        JMenuItem itemVer = new JMenuItem("Ver detalles");
        itemVer.addActionListener((ActionEvent e) -> {
            System.out.println("Desplegando detalles");
        }); popup.add(itemVer);
    }
    
    public void setEstados(){
        for(Estado estado : Estado.values())
            cbEstado.addItem(estado.toString());
        cbEstado.addItem("Todas");
    }
    
    public static void main(String args[]) {
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BackofficeCoordinador().setVisible(true);
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        busyPainter1 = new org.jdesktop.swingx.painter.BusyPainter();
        panelFondo = new javax.swing.JPanel();
        cbEstado = new javax.swing.JComboBox<>();
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
        linkEstadisticas1 = new org.jdesktop.swingx.JXHyperlink();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mitemInconsistencia = new javax.swing.JMenuItem();
        mitemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFondo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Filtrar por estado:");

        btnRegistrarSolicitud.setText("Registrar");

        btnExtraerExcel.setText("Extraer solicitudes del Excel");
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

        linkEstadisticas1.setText("Reporte de solicitudes según las fechas indicadas");
        linkEstadisticas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkEstadisticas1ActionPerformed(evt);
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
                        .addComponent(linkEstadisticas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(linkEstadisticas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        DialogEstadisticas dialog = new DialogEstadisticas(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_linkEstadisticasActionPerformed

    private void mitemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitemSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mitemSalirActionPerformed

    private void mitemInconsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitemInconsistenciaActionPerformed
        DialogInconsistencia dialog = new DialogInconsistencia(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_mitemInconsistenciaActionPerformed

    private void linkEstadisticas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkEstadisticas1ActionPerformed
        DialogSolicitudesAtendidas dialog = new DialogSolicitudesAtendidas(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_linkEstadisticas1ActionPerformed

    private void btnExtraerExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtraerExcelActionPerformed
        JFileChooser file=new JFileChooser();
        file.showOpenDialog(this);
        File archivo = file.getSelectedFile();
    }//GEN-LAST:event_btnExtraerExcelActionPerformed

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
    private org.jdesktop.swingx.JXHyperlink linkEstadisticas1;
    private javax.swing.JMenuItem mitemInconsistencia;
    private javax.swing.JMenuItem mitemSalir;
    private javax.swing.JPanel panelFondo;
    private org.jdesktop.swingx.JXTable tabSolicitudes;
    // End of variables declaration//GEN-END:variables


}
