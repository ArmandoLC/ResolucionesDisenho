package Vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Backoffice extends JFrame {
    
    protected void initLookAndFeel(){
        try{
            //setLocationRelativeTo(null);
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    protected void showMessage( String mensaje ) {
        JOptionPane.showMessageDialog(
            null, mensaje, "Mensaje", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    
}
