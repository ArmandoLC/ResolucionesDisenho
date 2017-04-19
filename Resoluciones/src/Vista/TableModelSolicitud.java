package Vista;

import DTOs.DTOSolicitud;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


public class TableModelSolicitud extends AbstractTableModel{

    private String columnas[] = {"Id","Fecha","Solicitante", "Nombre", "Periodo", "Curso", "Grupo", "Estado"};
    private ArrayList<DTOSolicitud> solicitudes;
    private JTable table;
    
    public TableModelSolicitud(JTable table){
        this.table = table;
        this.solicitudes = new ArrayList<>();
    }
    
    public TableModelSolicitud(ArrayList<DTOSolicitud> solicitudes){
        this.solicitudes = solicitudes;
    }
    
    public ArrayList<DTOSolicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(ArrayList<DTOSolicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }
    
    @Override
    public int getRowCount() {
        int size; 
        if (solicitudes == null) size = 0; 
        else size = solicitudes.size();
        return size; 
        
    }

    @Override
    public int getColumnCount() {
        return columnas.length; 
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    
    
    @Override
    public Object getValueAt(int row, int col) {
        Object temp = null; 
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (col == 0) temp = solicitudes.get(row).getId(); 
        else if (col == 1) temp = sdf.format(solicitudes.get(row).getFecha()); 
        else if (col == 2) temp = solicitudes.get(row).getIdSolicitante(); 
        else if (col == 3) temp = solicitudes.get(row).getNombreSolicitante(); 
        else if (col == 4) temp = solicitudes.get(row).getPeriodo(); 
        else if (col == 5) temp = solicitudes.get(row).getCodigoCurso(); 
        else if (col == 6) temp = solicitudes.get(row).getnGrupo(); 
        else if (col == 7) temp = solicitudes.get(row).getEstado(); 
        return temp;
    }
    
    public void addRow(DTOSolicitud solicitud){
        solicitudes.add(solicitud);
        table.setModel(this);
    }
    
    public DTOSolicitud getSolicitud(int row){ 
        int index = table.convertRowIndexToModel(row);
        return solicitudes.get(index);
    }
    
}
