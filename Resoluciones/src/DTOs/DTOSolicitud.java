/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Armando
 */
public class DTOSolicitud {

    // Solicitud
    private int id;
    private Date fecha;
    private String idSolicitante;
    private String nombreSolicitante;
    private String periodo;
    private String codigoCurso;
    private int nGrupo;
    private String idAfectado;
    private String nombreAfectado;
    private String correoAfectado;
    private String telefonoAfectado;
    private String tipoSituacion;
    private String descripcionDetallada;
    private String rutaArchivoAdjunto;
    private String estado;
    private String aclaracion;
    private ArrayList<String> listaAnotaciones;
    
    // Resolucion
    private int nResolucion;
    private int fechaResolucion;
    private String nombreCoordinadorResolucion;
    private String nombreDirectorEscuelaResolucion;
    private String nombreDirectorAdmYRegResolucion;
    private ArrayList<String> listaResueltosResolucion;

    

    public DTOSolicitud() {
    }

    //Constructor con campos de resolucion
    public DTOSolicitud(int id, Date fecha, String idSolicitante, String nombreSolicitante, 
                        String periodo, String codigoCurso, int nGrupo, String idAfectado, 
                        String nombreAfectado, String correoAfectado, String telefonoAfectado, 
                        String tipoSituacion, String descripcionDetallada, String rutaArchivoAdjunto, 
                        String aclaracion, int nResolucion, int fechaResolucion, 
                        String nombreCoordinadorResolucion, String nombreDirectorEscuelaResolucion, 
                        String nombreDirectorAdmYRegResolucion, ArrayList<String> listaAnotaciones, 
                        ArrayList<String> listaResueltosResolucion) {
        this.id = id;
        this.fecha = fecha;
        this.idSolicitante = idSolicitante;
        this.nombreSolicitante = nombreSolicitante;
        this.periodo = periodo;
        this.codigoCurso = codigoCurso;
        this.nGrupo = nGrupo;
        this.idAfectado = idAfectado;
        this.nombreAfectado = nombreAfectado;
        this.correoAfectado = correoAfectado;
        this.telefonoAfectado = telefonoAfectado;
        this.tipoSituacion = tipoSituacion;
        this.descripcionDetallada = descripcionDetallada;
        this.rutaArchivoAdjunto = rutaArchivoAdjunto;
        this.aclaracion = aclaracion;
        this.nResolucion = nResolucion;
        this.fechaResolucion = fechaResolucion;
        this.nombreCoordinadorResolucion = nombreCoordinadorResolucion;
        this.nombreDirectorEscuelaResolucion = nombreDirectorEscuelaResolucion;
        this.nombreDirectorAdmYRegResolucion = nombreDirectorAdmYRegResolucion;
        this.listaAnotaciones = listaAnotaciones;
        this.listaResueltosResolucion = listaResueltosResolucion;
    }
    
    //Constructor sin campos de la resolucion
    public DTOSolicitud(int id, Date fecha, String idSolicitante, String nombreSolicitante, 
                        String periodo, String codigoCurso, int nGrupo, String idAfectado, 
                        String nombreAfectado, String correoAfectado, String telefonoAfectado, 
                        String tipoSituacion, String descripcionDetallada, String rutaArchivoAdjunto, 
                        String aclaracion, ArrayList<String> listaAnotaciones) {
        this.id = id;
        this.fecha = fecha;
        this.idSolicitante = idSolicitante;
        this.nombreSolicitante = nombreSolicitante;
        this.periodo = periodo;
        this.codigoCurso = codigoCurso;
        this.nGrupo = nGrupo;
        this.idAfectado = idAfectado;
        this.nombreAfectado = nombreAfectado;
        this.correoAfectado = correoAfectado;
        this.telefonoAfectado = telefonoAfectado;
        this.tipoSituacion = tipoSituacion;
        this.descripcionDetallada = descripcionDetallada;
        this.rutaArchivoAdjunto = rutaArchivoAdjunto;
        this.aclaracion = aclaracion;
        this.listaAnotaciones = listaAnotaciones;
    }
    
    //Constructor sin campos de la resolucion ni ID de la solicitud.
    // Está pensada para extraer solicitudes del CSV, sin haber ingresado a la
    // base de datos, por lo que no tiene una identificaciónn aún.
    public DTOSolicitud(Date fecha, String idSolicitante, String nombreSolicitante, 
                        String periodo, String codigoCurso, int nGrupo, String idAfectado, 
                        String nombreAfectado, String correoAfectado, String telefonoAfectado, 
                        String tipoSituacion, String descripcionDetallada, String rutaArchivoAdjunto, 
                        String aclaracion, ArrayList<String> listaAnotaciones) {
        this.fecha = fecha;
        this.idSolicitante = idSolicitante;
        this.nombreSolicitante = nombreSolicitante;
        this.periodo = periodo;
        this.codigoCurso = codigoCurso;
        this.nGrupo = nGrupo;
        this.idAfectado = idAfectado;
        this.nombreAfectado = nombreAfectado;
        this.correoAfectado = correoAfectado;
        this.telefonoAfectado = telefonoAfectado;
        this.tipoSituacion = tipoSituacion;
        this.descripcionDetallada = descripcionDetallada;
        this.rutaArchivoAdjunto = rutaArchivoAdjunto;
        this.aclaracion = aclaracion;
        this.listaAnotaciones = listaAnotaciones;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(String idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public String getNombreSolicitante() {
        return nombreSolicitante;
    }

    public void setNombreSolicitante(String nombreSolicitante) {
        this.nombreSolicitante = nombreSolicitante;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public int getnGrupo() {
        return nGrupo;
    }

    public void setnGrupo(int nGrupo) {
        this.nGrupo = nGrupo;
    }

    public String getIdAfectado() {
        return idAfectado;
    }

    public void setIdAfectado(String idAfectado) {
        this.idAfectado = idAfectado;
    }

    public String getNombreAfectado() {
        return nombreAfectado;
    }

    public void setNombreAfectado(String nombreAfectado) {
        this.nombreAfectado = nombreAfectado;
    }

    public String getCorreoAfectado() {
        return correoAfectado;
    }

    public void setCorreoAfectado(String correoAfectado) {
        this.correoAfectado = correoAfectado;
    }

    public String getTelefonoAfectado() {
        return telefonoAfectado;
    }

    public void setTelefonoAfectado(String telefonoAfectado) {
        this.telefonoAfectado = telefonoAfectado;
    }

    public String getTipoSituacion() {
        return tipoSituacion;
    }

    public void setTipoSituacion(String tipoSituacion) {
        this.tipoSituacion = tipoSituacion;
    }

    public String getDescripcionDetallada() {
        return descripcionDetallada;
    }

    public void setDescripcionDetallada(String descripcionDetallada) {
        this.descripcionDetallada = descripcionDetallada;
    }

    public String getRutaArchivoAdjunto() {
        return rutaArchivoAdjunto;
    }

    public void setRutaArchivoAdjunto(String rutaArchivoAdjunto) {
        this.rutaArchivoAdjunto = rutaArchivoAdjunto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

    public String getAclaracion() {
        return aclaracion;
    }

    public void setAclaracion(String aclaracion) {
        this.aclaracion = aclaracion;
    }

    public int getnResolucion() {
        return nResolucion;
    }

    public void setnResolucion(int nResolucion) {
        this.nResolucion = nResolucion;
    }

    public int getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(int fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public String getNombreCoordinadorResolucion() {
        return nombreCoordinadorResolucion;
    }

    public void setNombreCoordinadorResolucion(String nombreCoordinadorResolucion) {
        this.nombreCoordinadorResolucion = nombreCoordinadorResolucion;
    }

    public String getNombreDirectorEscuelaResolucion() {
        return nombreDirectorEscuelaResolucion;
    }

    public void setNombreDirectorEscuelaResolucion(String nombreDirectorEscuelaResolucion) {
        this.nombreDirectorEscuelaResolucion = nombreDirectorEscuelaResolucion;
    }

    public String getNombreDirectorAdmYRegResolucion() {
        return nombreDirectorAdmYRegResolucion;
    }

    public void setNombreDirectorAdmYRegResolucion(String nombreDirectorAdmYRegResolucion) {
        this.nombreDirectorAdmYRegResolucion = nombreDirectorAdmYRegResolucion;
    }

    public ArrayList<String> getListaAnotaciones() {
        return listaAnotaciones;
    }

    public void setListaAnotaciones(ArrayList<String> listaAnotaciones) {
        this.listaAnotaciones = listaAnotaciones;
    }

    public ArrayList<String> getListaResueltosResolucion() {
        return listaResueltosResolucion;
    }

    public void setListaResueltosResolucion(ArrayList<String> listaResueltosResolucion) {
        this.listaResueltosResolucion = listaResueltosResolucion;
    }

}
