package Controlador;

import DTOs.DTOCurso;
import DTOs.DTOSolicitud;
import java.util.ArrayList;


public interface ISolicitud {

    public ArrayList<DTOSolicitud> ConsultarSolicitudes();

    public int RegistrarSolicitud(DTOSolicitud dtoSolicitud);
    
    public DTOCurso ConsultarCurso(int nSolicitud);    
    
    public ArrayList<DTOCurso> ConsultarCursos();
    
    public ArrayList<String> ConsultarInconsistencias();
    
    public ArrayList<Integer> ConsultarGrupos(String codCurso);
    
    public  ArrayList<DTOSolicitud> consultarSolicitudesEstudiante(String idEstudiante);
}
