package Vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;

public class Backoffice extends JFrame {
    
    protected TableModelSolicitud tabModelSolicitudes;
    
    protected void initModel(JTable tabSolicitudes) {
        tabModelSolicitudes = new TableModelSolicitud(tabSolicitudes);  
        tabSolicitudes.setModel(tabModelSolicitudes);
    }
    
    protected void initLookAndFeel(){      
        try{ UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); }
        catch(Exception e){ showError(e.getMessage()); }
    }
    
    protected void showError( String mensaje ) {
        JOptionPane.showMessageDialog(
            null, "Error: " + mensaje, "Información", 
            JOptionPane.ERROR_MESSAGE);
    }
    
    protected void showMessage( String mensaje ) {
        JOptionPane.showMessageDialog(
            null, "Mensaje: " + mensaje, "Información", 
            JOptionPane.INFORMATION_MESSAGE);
    }

    public TableModelSolicitud getTabModelSolicitudes() {
        return tabModelSolicitudes;
    }

    public void setTabModelSolicitudes(TableModelSolicitud tabModelSolicitudes) {
        this.tabModelSolicitudes = tabModelSolicitudes;
    }
    
    
    
}
