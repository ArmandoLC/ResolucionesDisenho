package Vista;

import DTOs.DTOPersona;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


public class TableModelProfesor extends AbstractTableModel{

    private String columnas[] = {"Id","Nombre","Correo", "Telefono"};
    private ArrayList<DTOPersona> personas;
    private JTable table;
    
    public TableModelProfesor(JTable table){
        this.table = table;
        this.personas = new ArrayList<>();
    }
    
    public TableModelProfesor(ArrayList<DTOPersona> personas){
        this.personas = personas;
    }
    
    public ArrayList<DTOPersona> getSolicitudes() {
        return personas;
    }

    public void setPersonas(ArrayList<DTOPersona> personas) {
        this.personas = personas;
        table.setModel(this);
    }
    
    @Override
    public int getRowCount() {
        int size; 
        if (personas == null) size = 0; 
        else size = personas.size();
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
        if (col == 0) temp = personas.get(row).getId(); 
        else if (col == 1) temp = personas.get(row).getNombre();
        else if (col == 2) temp = personas.get(row).getCorreo(); 
        else if (col == 3) temp = personas.get(row).getTelefono(); 
        return temp;
    }
    
    public void addRow(DTOPersona persona){
        personas.add(persona);
    }
    
    public DTOPersona getProfesor(int row){ 
        int index = table.convertRowIndexToModel(row);
        return personas.get(index);
    }
    
}
