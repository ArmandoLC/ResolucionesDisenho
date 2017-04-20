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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

        DTOSolicitud s1 = new DTOSolicitud();
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                s1.setFecha(dateFormat.parse("2014-02-02"));
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
            s1.setIdSolicitante("1546468");
            s1.setNombreSolicitante("Julian");
            s1.setPeriodo("2017");
            s1.setnGrupo(40);
            s1.setCodigoCurso("s11");
            s1.setEstado("Anulada");
            s1.setIdAfectado("idAfec");
            s1.setNombreAfectado("nameAf");
            s1.setCorreoAfectado("corAF");
            s1.setTelefonoAfectado("telAf");
            s1.setInconsistencia("exclusioooon");
            s1.setDescripcionDetallada("descripAF");
            s1.setRutaArchivoAdjunto("rutaf");
            s1.setAclaracion("lul aclaracion");
        
        DTOSolicitud s2 = new DTOSolicitud();
            
            try {
                s2.setFecha(dateFormat.parse("2014-02-02"));
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
            s2.setIdSolicitante("1546468");
            s2.setNombreSolicitante("Julian");
            s2.setPeriodo("2017");
            s2.setnGrupo(40);
            s2.setCodigoCurso("s11");
            s2.setEstado("Tramitada");
            s2.setIdAfectado("idAfec");
            s2.setNombreAfectado("nameAf");
            s2.setCorreoAfectado("corAF");
            s2.setTelefonoAfectado("telAf");
            s2.setInconsistencia("exclusioooon");
            s2.setDescripcionDetallada("descripAF");
            s2.setRutaArchivoAdjunto("rutaf");
            s2.setAclaracion("lul aclaracion");
            
            DTOSolicitud s3 = new DTOSolicitud();
            
            try {
                s3.setFecha(dateFormat.parse("2014-02-02"));
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
            s3.setIdSolicitante("1546468");
            s3.setNombreSolicitante("Julian");
            s3.setPeriodo("2017");
            s3.setnGrupo(40);
            s3.setCodigoCurso("s11");
            s3.setEstado("Tramitada");
            s3.setIdAfectado("idAfec");
            s3.setNombreAfectado("nameAf");
            s3.setCorreoAfectado("corAF");
            s3.setTelefonoAfectado("telAf");
            s3.setInconsistencia("exclusioooon");
            s3.setDescripcionDetallada("descripAF");
            s3.setRutaArchivoAdjunto("rutaf");
            s3.setAclaracion("lul aclaracion");
            
            DTOSolicitud s4 = new DTOSolicitud();
            
            try {
                s4.setFecha(dateFormat.parse("2014-02-02"));
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
            s4.setIdSolicitante("1546468");
            s4.setNombreSolicitante("Julian");
            s4.setPeriodo("2017");
            s4.setnGrupo(40);
            s4.setCodigoCurso("s11");
            s4.setEstado("Pendiente");
            s4.setIdAfectado("idAfec");
            s4.setNombreAfectado("nameAf");
            s4.setCorreoAfectado("corAF");
            s4.setTelefonoAfectado("telAf");
            s4.setInconsistencia("exclusioooon");
            s4.setDescripcionDetallada("descripAF");
            s4.setRutaArchivoAdjunto("rutaf");
            s4.setAclaracion("lul aclaracion");
           
        ArrayList<DTOSolicitud> aray = new ArrayList<>();
        aray.add(s1); aray.add(s2); aray.add(s3); aray.add(s4);
        System.out.println("Controlador");
        return aray;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
