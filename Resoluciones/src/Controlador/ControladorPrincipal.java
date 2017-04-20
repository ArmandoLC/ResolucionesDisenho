/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DTOs.DTOCurso;
import DTOs.DTOPersona;
import DTOs.DTOResolucion;
import DTOs.DTOSolicitud;
import Modelo.Curso;
import Modelo.Oferta;
import Modelo.Profesor;
import Modelo.Solicitud;
import Modelo.SolicitudBuilder;
import Controlador.ICoordinador;
import Controlador.IDAOPremisa;
import Controlador.DAOSolicitud;
import Controlador.IGeneradorResolucion;
import Controlador.ISolicitud;
import DTOs.DTOferta;
import Enums.Estado;
import Enums.Formato;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Armando
 */
public class ControladorPrincipal implements ISolicitud,ICoordinador{
    //Atributos propios del controlador
    private DAOSolicitud daoSolicitud;
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

    public ControladorPrincipal() {
        solicitudes = new ArrayList<>();
        ofertaAcademica = new ArrayList<>();
        planEstudios = new ArrayList<>();
        carteraDocente = new ArrayList<>();
        daoPremisa = new DAOPremisaExcel();
    }

    private void setPlanEstudios(DTOCurso dtoCurso){
        Curso curso = new Curso(dtoCurso.getId(),dtoCurso.getNombre(),dtoCurso.getCreditos());
        planEstudios.add(curso);
    }
    
    private void setCarteraDocentes(DTOPersona dtoPersona){
       Profesor profesor = new Profesor(dtoPersona.getId(),dtoPersona.getNombre(), dtoPersona.getCorreo(), dtoPersona.getTelefono());
       carteraDocente.add(profesor);
    }
    
    private Curso  getCurso(String idCurso){
        for (int i = 0; i < planEstudios.size(); i++) {
            if (planEstudios.get(i).getId().equals(idCurso)){
                return planEstudios.get(i);
            }
        }
        return null;
    }
    
    private Profesor  getProfesor(String idProfesor){
        for (int i = 0; i < carteraDocente.size(); i++) {
            if (carteraDocente.get(i).getId().equals(idProfesor)){
                return carteraDocente.get(i);
            }
        }
        return null;
    }
    
    private void setOfertaAcademica(DTOferta dtoOferta){
       Oferta oferta = new Oferta(getCurso(dtoOferta.getIdCurso()), getProfesor(dtoOferta.getIdProfesor()),
                            dtoOferta.getPeriodo(), dtoOferta.getnGrupo(), dtoOferta.getHorario(), dtoOferta.getAula());
       ofertaAcademica.add(oferta);
    }
    
    public void CargarPremisas() throws Exception{
        ArrayList<DTOCurso> listCursos = daoPremisa.ConsultarPlanEstudios();
        ArrayList<DTOPersona> listDocentes = daoPremisa.ConsultarCarteraDocente();
        ArrayList<DTOferta> listOferta = daoPremisa.ConsultarOfertaAcademica();
        situaciones = daoPremisa.ConsultarSituaciones();
        
        listCursos.forEach((DTOCurso)-> setPlanEstudios(DTOCurso));
        listDocentes.forEach((DTOPersona)-> setCarteraDocentes(DTOPersona));
        listOferta.forEach((DTOferta)-> setOfertaAcademica(DTOferta));
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
