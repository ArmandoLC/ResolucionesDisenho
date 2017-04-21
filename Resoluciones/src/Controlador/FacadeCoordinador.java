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
    public boolean GuardarResolucion(DTOResolucion resolucion, Formato formato, String ruta) {
        return ctrl.GuardarResolucion(resolucion, formato, ruta);
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
        ArrayList<DTOPersona> p = new ArrayList<>();
        DTOPersona p1 = new DTOPersona();
        DTOPersona p2 = new DTOPersona();
        DTOPersona p3 = new DTOPersona();
        p1.setId("26525+256");
        p2.setId("16545graeg415");
        p3.setId("1536aersrg145");
        p3.setId("15261gareg515");
        p1.setNombre("betbreabo");
        p2.setNombre("bebrato");
        p3.setNombre("betbadaarbo");
        p1.setTelefono("teleff");
        p2.setTelefono("telfesff");
        p3.setTelefono("tefeslf");
        p1.setCorreo("serb@bstkb.com");
        p2.setCorreo("serb@bstkb.com");
        p3.setCorreo("serb@bstkb.com");
        p.add(p1);p.add(p2);p.add(p3);
        return p;
        //return ctrl.ConsultarTopProfesores(top);
    }

    @Override
    public ArrayList<DTOCurso> ConsultarTopCursos(int top) {
        //datos de prueba
        ArrayList<DTOCurso> c = new ArrayList<>();
        DTOCurso d1 = new DTOCurso();
        DTOCurso d2 = new DTOCurso();
        DTOCurso d3 = new DTOCurso();
        DTOCurso d4 = new DTOCurso();
        d1.setId("IC12345");
        d2.setId("IC498445");
        d3.setId("IC78974");
        d4.setId("IC89784");
        d1.setNombre("curso d1");
        d2.setNombre("curso d2");
        d3.setNombre("curso d3");
        d4.setNombre("curso d4");
        d1.setCreditos(4);
        d2.setCreditos(5);
        d3.setCreditos(6);
        d4.setCreditos(7);
        c.add(d1);c.add(d2);c.add(d3);c.add(d4);
        return c;
        //return ctrl.ConsultarTopCursos(top);
    }

        
}
