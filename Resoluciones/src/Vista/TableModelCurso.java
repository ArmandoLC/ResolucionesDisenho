package Vista;

import DTOs.DTOCurso;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


public class TableModelCurso extends AbstractTableModel{

    private String columnas[] = {"Id","Nombre","Créditos"};
    private ArrayList<DTOCurso> cursos;
    private JTable table;
    
    public TableModelCurso(JTable table){
        this.table = table;
        this.cursos = new ArrayList<>();
    }
    
    public TableModelCurso(ArrayList<DTOCurso> cursos){
        this.cursos = cursos;
    }
    
    public ArrayList<DTOCurso> getSolicitudes() {
        return cursos;
    }

    public void setCursos(ArrayList<DTOCurso> cursos) {
        this.cursos = cursos;
        table.setModel(this);
    }
    
    @Override
    public int getRowCount() {
        int size; 
        if (cursos == null) size = 0; 
        else size = cursos.size();
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
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
        if (col == 0) temp = cursos.get(row).getId(); 
        else if (col == 1) temp = cursos.get(row).getNombre();
        else if (col == 2) temp = cursos.get(row).getCreditos();
        return temp;
    }
    
    public void addRow(DTOCurso curso){
        cursos.add(curso);
    }
    
    public DTOCurso getCurso(int row){ 
        int index = table.convertRowIndexToModel(row);
        return cursos.get(index);
    }
    
}
