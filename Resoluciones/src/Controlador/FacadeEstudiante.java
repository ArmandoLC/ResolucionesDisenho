package Controlador;

import DTOs.DTOCurso;
import DTOs.DTOSolicitud;
import java.util.ArrayList;

public class FacadeEstudiante extends Facade{

    @Override
    public ArrayList<DTOSolicitud> ConsultarSolicitudes() {
        return ctrl.ConsultarSolicitudes();
    }

    @Override
    public int RegistrarSolicitud(DTOSolicitud dtoSolicitud) {
        return ctrl.RegistrarSolicitud(dtoSolicitud);
    }

    @Override
    public ArrayList<Integer> ConsultarGrupos(String codCurso) {
        return ctrl.ConsultarGrupos(codCurso);
    }

    @Override
    public DTOCurso ConsultarCurso(int nSolicitud) {
        return ctrl.ConsultarCurso(nSolicitud);
    }

    @Override
    public ArrayList<String> ConsultarInconsistencias() {
        return ctrl.ConsultarInconsistencias();
    }

    @Override
    public ArrayList<DTOCurso> ConsultarCursos() {
        return ctrl.ConsultarCursos();
    }
    
}
