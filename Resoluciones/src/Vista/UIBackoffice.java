
package Vista;

import DTOs.DTOSolicitud;
import java.util.ArrayList;
import javax.swing.JDialog;

public interface UIBackoffice {
    
    public void RegistrarSolicitud(JDialog dialog);
    public void ConsultarSituaciones(JDialog dialog);
    public void ConsultarSolicitudes();
    public void ConsultarCursos(JDialog dialog);
    public void ConsultarGrupos(JDialog dialog);
    public void ConsultarSolicitudesEstudiante (String idEstudiante);
}
