package Controlador;

import DTOs.DTOCurso;
import DTOs.DTOPersona;
import DTOs.DTOResolucion;
import DTOs.DTOSolicitud;
import Enums.Estado;
import Enums.Formato;
import java.util.ArrayList;

/**
 *
 * @author Armando
 */
public interface ICoordinador extends IEstadisticas {
    
    public DTOCurso ConsultarCurso(int nSolicitud);    
    
    public ArrayList<DTOCurso> ConsultarCursos();
    
    public DTOPersona ConsultarProfesor(int nSolicitud);
    
    public ArrayList<String> ConsultarInconsistencias();
    
    public boolean RegistrarInconsistencia(String incosistencia);
    
    public ArrayList<DTOSolicitud> ConsultarSolicitudes(Estado estado);
    
    public boolean RegistrarSolicitudes(String ruta);
    
    public boolean TramitarSolicitud(int nSolicitud);
    
    public boolean AnularSolicitud(int nSolicitud, String aclaracion);
    
    public boolean RegistrarResolucion(DTOResolucion resolucion);
    
    public DTOResolucion ConsultarResolucion(int nSolicitud);
    
    public boolean GenerarResolucion(DTOResolucion resolucion, Formato formato, String ruta);  
    
    public ArrayList<Integer> ConsultarGrupos(String codCurso);
    
}
