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
import Modelo.Estudiante;
import Modelo.Persona;
import Modelo.Resolucion;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorPrincipal implements ISolicitud, ICoordinador {

    //Atributos propios del controlador
    private DAOSolicitud daoSolicitud;
    private ArrayList<String> inconsistencias;

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

    public void CargarPremisas() {
        try {
            ArrayList<DTOCurso> listCursos = daoPremisa.ConsultarPlanEstudios();
            ArrayList<DTOPersona> listDocentes = daoPremisa.ConsultarCarteraDocente();
            ArrayList<DTOferta> listOferta = daoPremisa.ConsultarOfertaAcademica();
            inconsistencias = daoPremisa.ConsultarInconsistencias();
            
            DAOMySQL BD = (DAOMySQL) factorySolicitudes.CrearDAOSolicitud(Recurso.MySQL);
            listCursos.stream().forEach((curso) -> {
                BD.RegistrarCurso(curso);
            });
            listDocentes.stream().forEach((docente) -> {
                BD.RegistrarProfesor(docente);
            });
            listOferta.stream().forEach((oferta) -> {
                BD.RegistrarOferta(oferta);
            });
            inconsistencias.stream().forEach((inconsistencia) -> {
                BD.RegistrarInconsistencia(inconsistencia);
            });
   
            listCursos.forEach((DTOCurso) -> setPlanEstudios(DTOCurso));
            listDocentes.forEach((DTOPersona) -> setCarteraDocentes(DTOPersona));
            listOferta.forEach((DTOferta) -> setOfertaAcademica(DTOferta));
        } catch (Exception e) {
        }
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

    private DTOResolucion crearDTOResolucion(Resolucion resolucion, int idSolicitud) {
        DTOResolucion dtoResolucion = new DTOResolucion();
        dtoResolucion.setIdSolicitud(idSolicitud);
        dtoResolucion.setIntroduccion(resolucion.getIntroduccion());
        dtoResolucion.setConsiderandos(resolucion.getConsiderandos());
        dtoResolucion.setResuelvo(resolucion.getResuelvo());
        dtoResolucion.setResultado(resolucion.getResultado());
        return dtoResolucion;
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
        if(solicitud.getResolucion() == null){
            dtoSolicitud.setnResolucion(-1);
        }
        else{
            dtoSolicitud.setnResolucion(solicitud.getResolucion().getnResolucion());
        }
        
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
    
    private Solicitud generarSolicitud(DTOSolicitud dtoSolicitud){
        //Se procede a guardar la solicitud en memoria (en el atributo solicitudes)..
        //dtoSolicitud.setId(dtoS);
        Oferta infoCurso = null;
        for (Oferta oferta : ofertaAcademica) {
            Boolean b1 = oferta.getCurso().getId().equals(dtoSolicitud.getCodigoCurso());
            Boolean b2 = oferta.getnGrupo() == dtoSolicitud.getnGrupo();
            System.out.println(b1 + " " + b2);
            if (b1 && b2) {
                infoCurso = oferta;
            }
        }
        DTOPersona dtoAfectado = crearDTOPersona(new Estudiante(dtoSolicitud.getIdAfectado(), dtoSolicitud.getNombreAfectado(), dtoSolicitud.getCorreoAfectado(), dtoSolicitud.getTelefonoAfectado()));
        DTOPersona dtoSolicitante = crearDTOPersona(new Persona(dtoSolicitud.getIdSolicitante(), dtoSolicitud.getNombreSolicitante(), "", ""));
        DTOferta dtoOferta = crearDTOferta(infoCurso);

        //Se crea la solcitud por medio del builder
        solicitudBuilder = new SolicitudBuilder();

        Solicitud nuevaSolic = solicitudBuilder
                .setDatosSolicitud(dtoSolicitud)
                .setAfectado(dtoAfectado)
                .setSolicitante(dtoSolicitante)
                .setOferta(dtoOferta, infoCurso.getCurso(), infoCurso.getProfesor())
                .create();
        
        return nuevaSolic;
    }
    
    private String getPropiedad(String propiedad) throws IOException {
        Properties prop = new Properties();
        FileReader reader = new FileReader("src\\PropertiesFile.properties");
        prop.load(reader);
        return prop.getProperty(propiedad);
    }

    private void setPropiedad(String propiedad, String valor) throws IOException {
         FileInputStream in = new FileInputStream("src\\PropertiesFile.properties");
        Properties props = new Properties();
        props.load(in);
        in.close();

        FileOutputStream out = new FileOutputStream("src\\PropertiesFile.properties");
        props.setProperty(propiedad, valor);
        props.store(out, null);
        out.close();
    }

    private void fillMap(String id, Map mapa) {
        if (mapa.containsKey(id)) {
            int valor = (int) mapa.get(id);
            mapa.put(id, valor + 1);
        } else {
            mapa.put(id, 1);
        }
    }

    private String getHigherIdFromMap(Map mapa) {

        return (String) Collections.max(mapa.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    @Override
    public ArrayList<DTOSolicitud> ConsultarSolicitudes() {
        DAOMySQL DB = (DAOMySQL) factorySolicitudes.CrearDAOSolicitud(Recurso.MySQL);
        ArrayList<DTOSolicitud> dtoSolicitudes = DB.ConsultarSolicitudes();
        solicitudes = new ArrayList<>();
        System.gc();
        
        //Actualizar solicitudes
        for (DTOSolicitud dtoSolicitud : dtoSolicitudes) {
            solicitudes.add(generarSolicitud(dtoSolicitud));
        }
        
        return dtoSolicitudes;
    }
    
    @Override
    public int RegistrarSolicitud(DTOSolicitud dtoSolicitud) {
        //Se procede a guardar en la base de datos..
        DAOMySQL BD = (DAOMySQL) factorySolicitudes.CrearDAOSolicitud(Recurso.MySQL);
        int identificador = BD.RegistrarSolicitud(dtoSolicitud);
        dtoSolicitud.setId(identificador);
        
        solicitudes.add(generarSolicitud(dtoSolicitud));
        
        return identificador;
    }

    @Override
    public DTOCurso ConsultarCurso(int nSolicitud) {
        Curso curso = getSolicitud(nSolicitud).getInfoCurso().getCurso();
        DTOCurso dtoCurso = new DTOCurso();
        dtoCurso.setId(curso.getId());
        dtoCurso.setNombre(curso.getNombre());
        dtoCurso.setCreditos(curso.getCreditos());
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
        return inconsistencias;
    }

    @Override
    public boolean RegistrarInconsistencia(String incosistencia) {
        try {
            //Se debe registrar en la BD y en memoria(atributo inconsistencias del controlador)
            inconsistencias.add(incosistencia);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ArrayList<DTOSolicitud> ConsultarSolicitudes(Estado estado) {
        ArrayList<DTOSolicitud> listSolicitudes = new ArrayList<>();
        for (Solicitud solicitud : solicitudes) {
            //Se filtran las solicitudes por medio del estado
            if (solicitud.getEstado() == estado) {
                listSolicitudes.add(crearDTOSolicitud(solicitud));
            }
        }
        //Se retorna la lista de solicitudes que cumplen con el estado ingresado
        return listSolicitudes;
    }

    @Override
    public boolean RegistrarSolicitudes(String ruta) {
        DAOGoogleForm form = (DAOGoogleForm) factorySolicitudes.CrearDAOSolicitud(Recurso.GoogleForm);
        form.setRutaConexion(ruta);
        ArrayList<DTOSolicitud> dtoSolicitudes = form.ConsultarSolicitudes();
        
        for(DTOSolicitud solicitud : dtoSolicitudes) { 
            solicitud.setEstado(Estado.Pendiente.name());
            solicitud.setRutaArchivoAdjunto("Solicutud por medio del formulario");
        }

        DAOMySQL DB = (DAOMySQL) factorySolicitudes.CrearDAOSolicitud(Recurso.MySQL);
        DB.RegistrarSolicitudes(dtoSolicitudes);

        return true;
    }

    @Override
    public boolean TramitarSolicitud(int nSolicitud) {
        try {
            ConsultarSolicitudes();
            //Se debe tramitar en la BD y en memoria(atributo solicitud del controlador)
            getSolicitud(nSolicitud).setEstado(Estado.Tramitada);
            DAOMySQL DB = (DAOMySQL) factorySolicitudes.CrearDAOSolicitud(Recurso.MySQL);
            DB.TramitarSolicitud(nSolicitud);
            
            //Se actualizan en memoria las solicitudes
            ConsultarSolicitudes();
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean AnularSolicitud(int nSolicitud, String aclaracion) {
        try {
            ConsultarSolicitudes();
            //Se debe anular en la BD y en memoria(atributo solicitud del controlador)
            getSolicitud(nSolicitud).setEstado(Estado.Anulada);
            getSolicitud(nSolicitud).setAclaracion(aclaracion);
            
            DAOMySQL DB = (DAOMySQL) factorySolicitudes.CrearDAOSolicitud(Recurso.MySQL);
            DB.AnularSolicitud(nSolicitud, aclaracion);
            
            //Se actualizan en memoria las solicitudes
            ConsultarSolicitudes();
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean RegistrarResolucion(DTOResolucion resolucion) {
        try {
            DAOMySQL DB = (DAOMySQL) factorySolicitudes.CrearDAOSolicitud(Recurso.MySQL);
            int nResolucion;
            nResolucion = Integer.parseInt(getPropiedad("nResolucionActual"));
            setPropiedad("nResolucionActual", String.valueOf(nResolucion + 1));
            Date fecha = Calendar.getInstance().getTime();
            String nombreCoordinador = getPropiedad("nombreCoordinador");
            String nombreDirectorEscuela = getPropiedad("nombreDirectorEscuela");
            String nombreDirectorAdmYReg = getPropiedad("nombreDirectorAdmYReg");

            String introduccion = resolucion.getIntroduccion();
            String resultado = resolucion.getResultado();
            String considerandos = resolucion.getConsiderandos();
            String resuelvo = resolucion.getResuelvo();
            
            Resolucion resolucionResult = new Resolucion(
                    nResolucion, fecha, nombreCoordinador, nombreDirectorEscuela, 
                    nombreDirectorAdmYReg, introduccion, resultado, considerandos, resuelvo);
            
            //Se guarda en la base de datos
            DB.RegistrarResolucion(resolucion.getIdSolicitud(), resolucionResult);
            
            //Se guarda en memoria
            getSolicitud(resolucion.getIdSolicitud()).setResolucion(resolucionResult);
            
            
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public DTOResolucion ConsultarResolucion(int nSolicitud) {
        
        Solicitud solicitud = getSolicitud(nSolicitud);
        
        DAOMySQL DB = (DAOMySQL) factorySolicitudes.CrearDAOSolicitud(Recurso.MySQL);
        Resolucion resolucion = DB.ConsultarResolucion(nSolicitud);
        solicitud.setResolucion(resolucion);
        
        
        if(solicitud.getResolucion() != null){
            DTOResolucion res = crearDTOResolucion(solicitud.getResolucion(), nSolicitud);
            res.setIdResolucion(resolucion.getnResolucion());
            return crearDTOResolucion(solicitud.getResolucion(), nSolicitud);
        }
        else
            return null;
        
    }

    @Override
    public boolean GuardarResolucion(int idSolicitud, Formato formato, String ruta) {
        if (formato.equals(Formato.HTML)) {
            estrategiaGeneracion = new GeneradorResolucionHTML();
        } else {
            estrategiaGeneracion = new GeneradorResolucionPDF();
        }

        Solicitud solicitud = getSolicitud(idSolicitud);
        System.out.println("Solicitud: "+solicitud.toString());
        return estrategiaGeneracion.Generar(solicitud.getResolucion(), ruta);
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
        //Son las que se encuentran anuladas o tramitadas
        ArrayList<DTOSolicitud> dtoSolicitud = new ArrayList<>();
        for (Solicitud solicitud : solicitudes) {
            if (solicitud.getEstado() == Estado.Anulada || solicitud.getEstado() == Estado.Tramitada) {
                if (solicitud.getFecha().after(desde) && solicitud.getFecha().before(hasta)) {
                    dtoSolicitud.add(crearDTOSolicitud(solicitud));
                }
            }
        }
        return dtoSolicitud;
    }

    @Override
    public ArrayList<DTOPersona> ConsultarTopProfesores(int top) {

        ArrayList<DTOPersona> resultado = new ArrayList<>();
        Map<String, Integer> topList = new HashMap<>();

        solicitudes.forEach((solic) -> fillMap(solic.getInfoCurso().getProfesor().getId(), topList));
        if (top < 1) {
            top = 1;
        }
        int count = 1;

        while (count <= top && !topList.isEmpty()) {
            String key = getHigherIdFromMap(topList);
            resultado.add( crearDTOPersona( getProfesor(key)));
            topList.remove(key);
            count++;
        }

        return resultado;
    }

    @Override
    public ArrayList<DTOCurso> ConsultarTopCursos(int top) {

        ArrayList<DTOCurso> resultado = new ArrayList<>();
        Map<String, Integer> topList = new HashMap<>();

        solicitudes.forEach((solic) -> fillMap(solic.getInfoCurso().getCurso().getId(), topList));
        if (top < 1) {
            top = 1;
        }
        int count = 1;

        while (count <= top && !topList.isEmpty()) {
            String key = getHigherIdFromMap(topList);
            resultado.add( crearDTOCurso( getCurso(key)));
            topList.remove(key);
            count++;
        }

        return resultado;

    }

    @Override
    public ArrayList<DTOSolicitud> consultarSolicitudesEstudiante(String idEstudiante) {
        ArrayList<DTOSolicitud> dtoSolicitudes = new ArrayList<>();
        
        for (Solicitud solicitud : solicitudes) {
            if(solicitud.getAfectado().getId().equals(idEstudiante)){
                dtoSolicitudes.add(crearDTOSolicitud(solicitud));
            }
        }
        return dtoSolicitudes;
    }
}
