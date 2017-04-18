package Vista;

import DTOs.DTOSolicitud;
import Enums.Estado;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

public class BackofficeCoordinador extends Backoffice implements ActionListener {
    
    JPopupMenu popup;
            
    public BackofficeCoordinador() {
        
        initLookAndFeel();
        initComponents();
        setEstados();
        
        String columnas[] = {"Id","Fecha","Solicitante", "Nombre", "Periodo", "Curso", "Grupo"};
        TableModelSolicitud tabModelo = new TableModelSolicitud();
        
        
        DTOSolicitud solicitud1 = new DTOSolicitud();
        solicitud1.setId(123456);
        solicitud1.setFecha(new Date(20170417));
        solicitud1.setIdSolicitante("1546468");
        solicitud1.setNombreSolicitante("Julian");
        solicitud1.setPeriodo("IS2017");
        solicitud1.setnGrupo(4);
        solicitud1.setCodigoCurso("156485fr");
        tabModelo.addRow(solicitud1);
        tabModelo.addRow(solicitud1);
        //tabSolicitudes.setModel(tabModelo);
        tabSolicitudes.addMouseListener(mouseAdapter);
        
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
        
        popup.add(new JMenuItem("ohla"));
        popup.add(new JMenuItem("ohla"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Component c = (Component)e.getSource();
        JPopupMenu popup = (JPopupMenu)c.getParent();
        System.out.println(tabSolicitudes.getSelectedRow() + " : " + tabSolicitudes.getSelectedColumn());
    }
    
    public void setEstados(){
        for(Estado estado : Estado.values())
            cbEstado.addItem(estado.toString());
        cbEstado.addItem("Todas");
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mitemRegistrarSolicitud = new javax.swing.JMenuItem();
        mitemRegistrarDesdeGoogle = new javax.swing.JMenuItem();
        mitemGenerarResolucion = new javax.swing.JMenuItem();
        mitemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFondo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Filtrar por estado:");

        btnRegistrarSolicitud.setText("Registrar");

        btnExtraerExcel.setText("Extraer solicitudes del Excel");

        linkEstadisticas.setText("Estadísticas");

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
                    .addComponent(jLabel3))
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

        mitemRegistrarSolicitud.setText("Registrar nueva solicitud");
        jMenu1.add(mitemRegistrarSolicitud);

        mitemRegistrarDesdeGoogle.setText("Registrar desde Google Forms");
        jMenu1.add(mitemRegistrarDesdeGoogle);

        mitemGenerarResolucion.setText("Generar resolución");
        jMenu1.add(mitemGenerarResolucion);

        mitemSalir.setText("Salir");
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
    private javax.swing.JMenuItem mitemGenerarResolucion;
    private javax.swing.JMenuItem mitemRegistrarDesdeGoogle;
    private javax.swing.JMenuItem mitemRegistrarSolicitud;
    private javax.swing.JMenuItem mitemSalir;
    private javax.swing.JPanel panelFondo;
    private org.jdesktop.swingx.JXTable tabSolicitudes;
    // End of variables declaration//GEN-END:variables


}
