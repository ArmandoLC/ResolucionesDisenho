package Vista;

import DTOs.DTOSolicitud;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


public class TableModelSolicitud extends AbstractTableModel{

    private final String columnas[];
    private ArrayList<DTOSolicitud> solicitudes;
    private final JTable table;
    
    public TableModelSolicitud(JTable table){
        this.columnas = new String[]{"Id", "Fecha", "Solicitante", "Nombre", "Periodo", "Curso", "Grupo", "Estado"};
        this.table = table;
        this.solicitudes = new ArrayList<>();
    }
    
    public ArrayList<DTOSolicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(ArrayList<DTOSolicitud> solicitudes) {
        this.solicitudes = solicitudes;
        table.setModel(this);
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
        switch (col) {
            case 0: temp = solicitudes.get(row).getId(); break;
            case 1: temp = sdf.format(solicitudes.get(row).getFecha()); break;
            case 2: temp = solicitudes.get(row).getIdSolicitante(); break;
            case 3: temp = solicitudes.get(row).getNombreSolicitante(); break;
            case 4: temp = solicitudes.get(row).getPeriodo(); break;
            case 5: temp = solicitudes.get(row).getCodigoCurso(); break;
            case 6: temp = solicitudes.get(row).getnGrupo(); break;
            case 7: temp = solicitudes.get(row).getEstado(); break;
            default: break;
        }
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
