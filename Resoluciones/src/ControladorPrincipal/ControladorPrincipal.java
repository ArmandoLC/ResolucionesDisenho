/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorPrincipal;

import DAOs.DAOPremisaExcel;
import DAOs.FactoryDAOSolicitud;
import DTOs.DTOCurso;
import DTOs.DTOPersona;
import DTOs.DTOResolucion;
import DTOs.DTOSolicitud;
import Datos.Curso;
import Datos.Oferta;
import Datos.Profesor;
import Datos.Solicitud;
import Datos.SolicitudBuilder;
import Interfaces.ICoordinador;
import Interfaces.IDAOPremisa;
import Interfaces.IDAOSolicitud;
import Interfaces.IGeneradorResolucion;
import Interfaces.ISolicitud;
import Tipos_Enumerados.Estado;
import Tipos_Enumerados.Formato;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Armando
 */
public class ControladorPrincipal implements ISolicitud,ICoordinador{
    //Atributos propios del controlador
    private IDAOSolicitud daoSolicitud;
    private ArrayList<String> situaciones;
    
    //Atributos de las relaciones con las otras clases (COMPOSICIONES)
    private IDAOPremisa daoPremisa;
    private IGeneradorResolucion estrategiaGeneracion;
    private FactoryDAOSolicitud factorySolicitudes;
    private SolicitudBuilder solicitudBuilder;
    
    //Atributos de las relaciones con las otras clases (AGREGACIONES)
    private ArrayList<Solicitud> solicitudes;
    private ArrayList<Oferta> ofertaAcademica;
    private ArrayList<Curso> planEstudios;
    private ArrayList<Profesor> carteraDocente;
    
    
    private void CargarPremisas(){}
    

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean RegistrarSolicitudesGoogleForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean RegistrarInconsistencia(String incosistencia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean RegistrarAnotacion(int nSolicitud, String anotacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean AnularSolicitud(int nSolicitud, String aclaracion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
