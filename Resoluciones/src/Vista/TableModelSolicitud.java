package Vista;

import DTOs.DTOSolicitud;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class TableModelSolicitud extends AbstractTableModel{

    private String columnas[] = {"Id","Fecha","Solicitante", "Nombre", "Periodo", "Curso", "Grupo"};
    private ArrayList<DTOSolicitud> solicitudes;
    
    public TableModelSolicitud(){
        solicitudes = new ArrayList<>();
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
        return columnas.length;
    }

    @Override
    public int getColumnCount() {
        int size; 
        if (solicitudes == null) size = 0; 
        else size = solicitudes.size();
        return size; 
    }

    @Override
    public Object getValueAt(int row, int col) {
        Object temp = null; 
        if (col == 0) temp = solicitudes.get(row).getId(); 
        else if (col == 1) temp = solicitudes.get(row).getFecha(); 
        else if (col == 2) temp = solicitudes.get(row).getIdSolicitante(); 
        else if (col == 3) temp = solicitudes.get(row).getNombreSolicitante(); 
        else if (col == 4) temp = solicitudes.get(row).getPeriodo(); 
        else if (col == 5) temp = solicitudes.get(row).getCodigoCurso(); 
        else if (col == 6) temp = solicitudes.get(row).getnGrupo(); 
        return temp;
    }
    
    
    
    public void addRow(DTOSolicitud solicitud){
        solicitudes.add(solicitud);
    }
    
    public DTOSolicitud getSolicitud(int row){ 
        return solicitudes.get(row);
    }
    
}
