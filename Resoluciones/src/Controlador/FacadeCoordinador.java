package Controlador;

import DTOs.DTOCurso;
import DTOs.DTOPersona;
import DTOs.DTOResolucion;
import DTOs.DTOSolicitud;
import Enums.Estado;
import Enums.Formato;
import java.util.ArrayList;
import java.util.Date;

public class FacadeCoordinador extends Facade implements ICoordinador{
    

    public FacadeCoordinador(){
        super();
    }

    @Override
    public ArrayList<DTOSolicitud> ConsultarSolicitudes() {
        return ctrl.ConsultarSolicitudes();
    }

    @Override
    public int RegistrarSolicitud(DTOSolicitud dtoSolicitud) {
        return ctrl.RegistrarSolicitud(dtoSolicitud);
    }

    @Override
    public DTOCurso ConsultarCurso(int nSolicitud) {
        return ctrl.ConsultarCurso(nSolicitud);
    }

    @Override
    public ArrayList<DTOCurso> ConsultarCursos() {
        return ctrl.ConsultarCursos();
    }

    @Override
    public DTOPersona ConsultarProfesor(int nSolicitud) {
        return ctrl.ConsultarProfesor(nSolicitud);
    }

    @Override
    public ArrayList<String> ConsultarInconsistencias() {
        return ctrl.ConsultarInconsistencias();
    }

    @Override
    public boolean RegistrarInconsistencia(String incosistencia) {
        return ctrl.RegistrarInconsistencia(incosistencia);
    }

    @Override
    public ArrayList<DTOSolicitud> ConsultarSolicitudes(Estado estado) {
        return ctrl.ConsultarSolicitudes(estado);
    }

    @Override
    public boolean RegistrarSolicitudes(String ruta) {
        return ctrl.RegistrarSolicitudes(ruta);
    }

    @Override
    public boolean TramitarSolicitud(int nSolicitud) {
        return ctrl.TramitarSolicitud(nSolicitud);
    }

    @Override
    public boolean AnularSolicitud(int nSolicitud, String aclaracion) {
        return ctrl.AnularSolicitud(nSolicitud, aclaracion);
    }

    @Override
    public boolean RegistrarResolucion(DTOResolucion resolucion) {
        return ctrl.RegistrarResolucion(resolucion);
    }

    @Override
    public DTOResolucion ConsultarResolucion(int nSolicitud) {
        return ctrl.ConsultarResolucion(nSolicitud);
    }

    @Override
    public boolean GuardarResolucion(int idSolicitud, Formato formato, String ruta) {
        return ctrl.GuardarResolucion(idSolicitud, formato, ruta);
    }
    
    @Override
    public ArrayList<Integer> ConsultarGrupos(String codCurso) {
        return ctrl.ConsultarGrupos(codCurso);
    }

    @Override
    public ArrayList<DTOSolicitud> ConsultarSolicitudesAtendidas(Date desde, Date hasta) {
        return ctrl.ConsultarSolicitudesAtendidas(desde, hasta);
    }

    @Override
    public ArrayList<DTOPersona> ConsultarTopProfesores(int top) {
        return ctrl.ConsultarTopProfesores(top);
    }

    @Override
    public ArrayList<DTOCurso> ConsultarTopCursos(int top) {
        return ctrl.ConsultarTopCursos(top);
    }

    @Override
    public ArrayList<DTOSolicitud> consultarSolicitudesEstudiante(String idEstudiante) {
        return ctrl.consultarSolicitudesEstudiante(idEstudiante);
    }

        
}
