/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

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

    ControladorPrincipal control;
    
    public FacadeCoordinador(){
        control = new ControladorPrincipal();
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
    public ArrayList<DTOSolicitud> ConsultarSolicitudes(Estado estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DTOResolucion ConsultarResolucion(int nSolicitud) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> ConsultarAnotaciones(int nSolicitud) {
        //return control.consultarAnotaciones(nSolicitud);
        return null;
    }
    
    @Override
    public boolean TramitarSolicitud(int nSolicitud) {
        return control.TramitarSolicitud(nSolicitud);
    }

    @Override
    public boolean RegistrarSolicitudesGoogleForm() {
        return control.RegistrarSolicitudesGoogleForm();
    }

    @Override
    public boolean RegistrarInconsistencia(String incosistencia) {
        return control.RegistrarInconsistencia(incosistencia);
    }

    @Override
    public boolean RegistrarAnotacion(int nSolicitud, String anotacion) {
        return control.RegistrarAnotacion(nSolicitud, anotacion);
    }

    @Override
    public boolean AnularSolicitud(int nSolicitud, String aclaracion) {
        return control.AnularSolicitud(nSolicitud, aclaracion);
    }

    @Override
    public boolean GenerarResolucion(int nSolicitud, int nResolucion, Formato formato) {
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
