/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.ControladorPrincipal;
import DTOs.DTOCurso;
import DTOs.DTOPersona;
import DTOs.DTOResolucion;
import DTOs.DTOSolicitud;
import Controlador.ICoordinador;
import Enums.Estado;
import Enums.Formato;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FacadeCoordinador extends Facade implements ICoordinador{
    
    public FacadeCoordinador(){
        super();
    }

    @Override
    public ArrayList<DTOSolicitud> ConsultarSolicitudes() {
        return controlador.ConsultarSolicitudes();
    }

    @Override
    public int RegistrarSolicitud(DTOSolicitud dtoSolicitud) {
        return controlador.RegistrarSolicitud(dtoSolicitud);
    }

    @Override
    public DTOCurso ConsultarCurso(int nSolicitud) {
        return controlador.ConsultarCurso(nSolicitud);
    }

    @Override
    public ArrayList<DTOCurso> ConsultarCursos() {
        return controlador.ConsultarCursos();
    }

    @Override
    public DTOPersona ConsultarProfesor(int nSolicitud) {
        return controlador.ConsultarProfesor(nSolicitud);
    }

    @Override
    public ArrayList<String> ConsultarInconsistencias() {
        return controlador.ConsultarInconsistencias();
    }

    @Override
    public boolean RegistrarInconsistencia(String incosistencia) {
        return controlador.RegistrarInconsistencia(incosistencia);
    }

    @Override
    public ArrayList<DTOSolicitud> ConsultarSolicitudes(Estado estado) {
        return controlador.ConsultarSolicitudes(estado);
    }

    @Override
    public boolean RegistrarSolicitudes(String ruta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean TramitarSolicitud(int nSolicitud) {
        return controlador.TramitarSolicitud(nSolicitud);
    }

    @Override
    public boolean AnularSolicitud(int nSolicitud, String aclaracion) {
        return controlador.AnularSolicitud(nSolicitud, aclaracion);
    }

    @Override
    public boolean RegistrarResolucion(DTOResolucion resolucion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DTOResolucion ConsultarResolucion(int nSolicitud) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean GenerarResolucion(DTOResolucion resolucion, Formato formato, String ruta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DTOSolicitud> ConsultarSolicitudesAtendidas(Date desde, Date hasta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DTOPersona> ConsultarTopProfesores(int top) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DTOCurso> ConsultarTopCursos(int top) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        
}
