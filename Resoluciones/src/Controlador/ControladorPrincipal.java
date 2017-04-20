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
import DTOs.DTOferta;
import Enums.Estado;
import Enums.Formato;
<<<<<<< HEAD
import java.text.ParseException;
import java.text.SimpleDateFormat;
=======
import Enums.Recurso;
import Modelo.Persona;
>>>>>>> origin/master
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Armando
 */
public class ControladorPrincipal implements ISolicitud, ICoordinador {

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

    private Curso getCurso(String idCurso) {
        for (int i = 0; i < planEstudios.size(); i++) {
            if (planEstudios.get(i).getId().equals(idCurso)) {
                return planEstudios.get(i);
            }
        }
        return null;
    }

    private Profesor getProfesor(String idProfesor) {
        for (int i = 0; i < carteraDocente.size(); i++) {
            if (carteraDocente.get(i).getId().equals(idProfesor)) {
                return carteraDocente.get(i);
            }
        }
        return null;
    }
    
    private Solicitud getSolicitud(int nSolicitud) {
        for (int i = 0; i < solicitudes.size(); i++) {
            if (solicitudes.get(i).getId() == nSolicitud) {
                return solicitudes.get(i);
            }
        }
        return null;
    }
    
    private ArrayList<Solicitud> getSolicitudes(Estado estado) {
        ArrayList<Solicitud> listSolicitudes = new ArrayList<>();
        for (int i = 0; i < solicitudes.size(); i++) {
            if (solicitudes.get(i).getEstado().equals(estado)) {
                listSolicitudes.add(solicitudes.get(i));
            }
        }
        return listSolicitudes;
    }

    private DTOCurso crearDTOCurso(Curso curso) {
        DTOCurso dtoCurso = new DTOCurso();
        dtoCurso.setId(curso.getId());
        dtoCurso.setNombre(curso.getNombre());
        dtoCurso.setCreditos(curso.getCreditos());
        return dtoCurso;
    }
    
    private DTOPersona crearDTOPersona(Persona persona) {
        DTOPersona dtoPersona = new DTOPersona();
        dtoPersona.setId(persona.getId());
        dtoPersona.setNombre(persona.getNombre());
        dtoPersona.setCorreo(persona.getCorreo());
        dtoPersona.setTelefono(persona.getTelefono());
        return dtoPersona;
    }
    
    private DTOferta crearDTOferta(Oferta oferta) {
        DTOferta dtoOferta = new DTOferta();
        dtoOferta.setAula(oferta.getAula());
        dtoOferta.setHorario(oferta.getHorario());
        dtoOferta.setIdCurso(oferta.getCurso().getId());
        dtoOferta.setIdProfesor(oferta.getProfesor().getId());
        dtoOferta.setPeriodo(oferta.getPeriodo());
        dtoOferta.setnGrupo(oferta.getnGrupo());
        return dtoOferta;
    }
    
    private DTOSolicitud crearDTOSolicitud(Solicitud solicitud) {
        DTOSolicitud dtoSolicitud = new DTOSolicitud();
        
        dtoSolicitud.setId(solicitud.getId());
        dtoSolicitud.setAclaracion(solicitud.getAclaracion());
        dtoSolicitud.setCodigoCurso(solicitud.getInfoCurso().getCurso().getId());
        dtoSolicitud.setnGrupo(solicitud.getInfoCurso().getnGrupo());
        dtoSolicitud.setPeriodo(solicitud.getInfoCurso().getPeriodo());
        dtoSolicitud.setIdAfectado(solicitud.getAfectado().getId());
        dtoSolicitud.setNombreAfectado(solicitud.getAfectado().getNombre());
        dtoSolicitud.setCorreoAfectado(solicitud.getAfectado().getCorreo());
        dtoSolicitud.setTelefonoAfectado(solicitud.getAfectado().getTelefono());
        dtoSolicitud.setDescripcionDetallada(solicitud.getDescripcion());
        dtoSolicitud.setEstado(solicitud.getEstado().toString());
        dtoSolicitud.setFecha(solicitud.getFecha());
        dtoSolicitud.setIdSolicitante(solicitud.getSolicitante().getId());
        dtoSolicitud.setNombreSolicitante(solicitud.getSolicitante().getNombre());
        dtoSolicitud.setInconsistencia(solicitud.getInconsistencia());
        dtoSolicitud.setRutaArchivoAdjunto(solicitud.getRutaArchivoAdjunto());
        //dtoSolicitud.setnResolucion(solicitud.getResolucion().getnResolucion());
        
        return dtoSolicitud;
    }
    
    
    private void setPlanEstudios(DTOCurso dtoCurso) {
        Curso curso = new Curso(dtoCurso.getId(), dtoCurso.getNombre(), dtoCurso.getCreditos());
        planEstudios.add(curso);
    }

    private void setCarteraDocentes(DTOPersona dtoPersona) {
        Profesor profesor = new Profesor(dtoPersona.getId(), dtoPersona.getNombre(), dtoPersona.getCorreo(), dtoPersona.getTelefono());
        carteraDocente.add(profesor);
    }

    private void setOfertaAcademica(DTOferta dtoOferta) {
        Oferta oferta = new Oferta(getCurso(dtoOferta.getIdCurso()), getProfesor(dtoOferta.getIdProfesor()),
                dtoOferta.getPeriodo(), dtoOferta.getnGrupo(), dtoOferta.getHorario(), dtoOferta.getAula());
        ofertaAcademica.add(oferta);
    }

    public void CargarPremisas() throws Exception {
        ArrayList<DTOCurso> listCursos = daoPremisa.ConsultarPlanEstudios();
        ArrayList<DTOPersona> listDocentes = daoPremisa.ConsultarCarteraDocente();
        ArrayList<DTOferta> listOferta = daoPremisa.ConsultarOfertaAcademica();
        situaciones = daoPremisa.ConsultarSituaciones();

        listCursos.forEach((DTOCurso) -> setPlanEstudios(DTOCurso));
        listDocentes.forEach((DTOPersona) -> setCarteraDocentes(DTOPersona));
        listOferta.forEach((DTOferta) -> setOfertaAcademica(DTOferta));
    }

    @Override
    public ArrayList<DTOSolicitud> ConsultarSolicitudes() {
<<<<<<< HEAD

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
=======
        ArrayList<DTOSolicitud> listSolicitudes = new ArrayList<>();
        
        for (int i = 0; i < solicitudes.size(); i++) {
            listSolicitudes.add(crearDTOSolicitud(solicitudes.get(i)));
        }
        return listSolicitudes;
>>>>>>> origin/master
    }

    @Override
    public int RegistrarSolicitud(DTOSolicitud dtoSolicitud) {
        //Se procede a guardar en la base de datos..
        DAOMySQL BD =(DAOMySQL) factorySolicitudes.CrearDAOSolicitud(Recurso.MySQL);
        int identificador = BD.RegistrarSolicitud(dtoSolicitud);
        
        //Se procede a guardar la solicitud en memoria (en el atributo solicitudes)..
        dtoSolicitud.setId(identificador);
        Solicitud solicitud = getSolicitud(dtoSolicitud.getId());

        Curso curso = solicitud.getInfoCurso().getCurso();
        Profesor profesor = solicitud.getInfoCurso().getProfesor();
        
        DTOPersona dtoAfectado = crearDTOPersona(solicitud.getAfectado());
        DTOPersona dtoSolicitante = crearDTOPersona(solicitud.getSolicitante());
        DTOferta dtoOferta = crearDTOferta(solicitud.getInfoCurso());
        
        //Se crea la solcitud por medio del builder
        Solicitud nuevaSolic = solicitudBuilder.setDatosSolicitud(dtoSolicitud).setAfectado(dtoAfectado).setSolicitante(dtoSolicitante).setOferta(dtoOferta, curso, profesor).create();
        //Se guarda en la lista de solicitudes que se encuentra en el controlador
        solicitudes.add(nuevaSolic);
        
        //Se retorna el ID con el que se registró la solicitud
        return identificador;
    }

    @Override
    public DTOCurso ConsultarCurso(int nSolicitud) {
        Curso curso = getSolicitud(nSolicitud).getInfoCurso().getCurso();
        DTOCurso dtoCurso = new DTOCurso();
        dtoCurso.setId(curso.getId());
        dtoCurso.setNombre(curso.getNombre());
        dtoCurso.setCreditos(curso.getCreditos());

        curso = null;
        System.gc();

        return dtoCurso;
    }

    @Override
    public ArrayList<DTOCurso> ConsultarCursos() {
        ArrayList<DTOCurso> cursos = new ArrayList<>();
        for (int i = 0; i < planEstudios.size(); i++) {
            DTOCurso dtoCurso = new DTOCurso();
            dtoCurso.setId(planEstudios.get(i).getId());
            dtoCurso.setNombre(planEstudios.get(i).getNombre());
            dtoCurso.setCreditos(planEstudios.get(i).getCreditos());

            cursos.add(dtoCurso);

            dtoCurso = null;
            System.gc();
        }
        return cursos;
    }

    @Override
    public DTOPersona ConsultarProfesor(int nSolicitud) {
        Profesor profesor = getSolicitud(nSolicitud).getInfoCurso().getProfesor();
        return crearDTOPersona(profesor);
    }

    @Override
    public ArrayList<String> ConsultarInconsistencias() {
        return situaciones;
    }

    @Override
    public boolean RegistrarInconsistencia(String incosistencia) {
        try {
            //Se debe registrar en la BD y en memoria(atributo situaciones del controlador)
            situaciones.add(incosistencia);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ArrayList<DTOSolicitud> ConsultarSolicitudes(Estado estado) {
        //Se filtran las solicitudes por medio del estado
        ArrayList<Solicitud> listSolicitud = getSolicitudes(estado);
        //Se genera por cada solicitud un DTOSolicitud que se almacena en listDTOSolicitud
        ArrayList<DTOSolicitud> listDTOSolicitud = new ArrayList<>();
        for (int i = 0; i < listSolicitud.size(); i++) {
            listDTOSolicitud.add(crearDTOSolicitud(listSolicitud.get(i)));
        }
        //Se retorna la lista de solicitudes que cumplen con el estado ingresado
        return listDTOSolicitud;
    }

    @Override
    public boolean RegistrarSolicitudes(String ruta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean TramitarSolicitud(int nSolicitud) {
        try {
            //Se debe tramitar en la BD y en memoria(atributo solicitud del controlador)
            getSolicitud(nSolicitud).setEstado(Estado.Tramitada);
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean AnularSolicitud(int nSolicitud, String aclaracion) {
        try {
            //Se debe anular en la BD y en memoria(atributo solicitud del controlador)
            getSolicitud(nSolicitud).setEstado(Estado.Anulada);
            getSolicitud(nSolicitud).setAclaracion(aclaracion);
            
            return true;
        } catch (Exception e) {
            return false;
        }
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
