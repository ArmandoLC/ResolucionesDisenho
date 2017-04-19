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

public class FacadeCoordinador extends Facade implements ICoordinador{
    
    public FacadeCoordinador(){
        super();
    }

    @Override
    public ArrayList<DTOSolicitud> ConsultarSolicitudes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int RegistrarSolicitud(DTOSolicitud dtoSolicitud) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DTOCurso ConsultarCurso(int nSolicitud) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DTOCurso> ConsultarCursos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DTOPersona ConsultarProfesor(int nSolicitud) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> ConsultarInconsistencias() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean RegistrarInconsistencia(String incosistencia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DTOSolicitud> ConsultarSolicitudes(Estado estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean RegistrarSolicitudes(String ruta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean TramitarSolicitud(int nSolicitud) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean AnularSolicitud(int nSolicitud, String aclaracion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
