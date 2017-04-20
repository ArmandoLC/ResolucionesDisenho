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
import Enums.Recurso;
import Modelo.Persona;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
        factorySolicitudes = new FactoryDAOSolicitud();
        this.CargarPremisas();
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

    public void CargarPremisas(){
        try{  ArrayList<DTOCurso> listCursos = daoPremisa.ConsultarPlanEstudios();
            ArrayList<DTOPersona> listDocentes = daoPremisa.ConsultarCarteraDocente();
            ArrayList<DTOferta> listOferta = daoPremisa.ConsultarOfertaAcademica();
            situaciones = daoPremisa.ConsultarSituaciones();

            listCursos.forEach((DTOCurso) -> setPlanEstudios(DTOCurso));
            listDocentes.forEach((DTOPersona) -> setCarteraDocentes(DTOPersona));
            listOferta.forEach((DTOferta) -> setOfertaAcademica(DTOferta));
        } catch(Exception e){ } 
    }

    @Override
    public ArrayList<DTOSolicitud> ConsultarSolicitudes() {

        ArrayList<DTOSolicitud> listSolicitudes = new ArrayList<>();
        
        for (int i = 0; i < solicitudes.size(); i++) {
            listSolicitudes.add(crearDTOSolicitud(solicitudes.get(i)));
        }
        return listSolicitudes;
    }

    @Override
    public int RegistrarSolicitud(DTOSolicitud dtoSolicitud) {
        //Se procede a guardar en la base de datos..
        DAOMySQL BD = (DAOMySQL) factorySolicitudes.CrearDAOSolicitud(Recurso.MySQL);
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
        Solicitud nuevaSolic = solicitudBuilder
                .setDatosSolicitud(dtoSolicitud)
                .setAfectado(dtoAfectado)
                .setSolicitante(dtoSolicitante)
                .setOferta(dtoOferta, curso, profesor)
                .create();
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
    public ArrayList<Integer> ConsultarGrupos(String codCurso) {
        ArrayList<Integer> lisResult = new ArrayList<>();
        for (int i = 0; i < ofertaAcademica.size(); i++) {
            if (ofertaAcademica.get(i).getCurso().getId().equals(codCurso)) {
                lisResult.add(ofertaAcademica.get(i).getnGrupo());
            }
        }

        return lisResult;
    }

    @Override
    public ArrayList<DTOSolicitud> ConsultarSolicitudesAtendidas(Date desde, Date hasta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DTOPersona> ConsultarTopProfesores(int top) {
        
        ArrayList<DTOPersona> resultado = new ArrayList<>();
        Map<String, Integer> topList = new HashMap<>();
        
        solicitudes.forEach((solic)-> fillMap(solic.getInfoCurso().getProfesor().getId(), topList ) );
        if (top < 1) top = 1; int count = 1;
        
        while(count <= top){
            String key = getHigherIdFromMap(topList);
            DTOPersona nuevo = new DTOPersona();
            nuevo.setId(key);
            resultado.add(nuevo);
            topList.remove(key);
            count++;
        }
               
        return resultado;
    }
    
    @Override
    public ArrayList<DTOCurso> ConsultarTopCursos(int top) {
		
        ArrayList<DTOCurso> resultado = new ArrayList<>();
        Map<String, Integer> topList = new HashMap<>();
        
        solicitudes.forEach((curso)-> fillMap(curso.getInfoCurso().getProfesor().getId(), topList ) );
        if (top < 1) top = 1; int count = 1;
        
        while(count <= top){
            String key = getHigherIdFromMap(topList);
            DTOCurso nuevo = new DTOCurso();
            nuevo.setId(key);
            resultado.add(nuevo);
            topList.remove(key);
            count++;
        }
               
        return resultado;
		
	}
    
    private void fillMap(String id, Map mapa){        
        if(mapa.containsKey(id)){
            int valor = (int) mapa.get(id);
            mapa.put(id, valor+1);
        } else {
            mapa.put(id, 1);
        }        
    }
    
    private String getHigherIdFromMap(Map mapa){
        
        return (String) Collections.max(mapa.entrySet(), Map.Entry.comparingByValue()).getKey();
    }


}
