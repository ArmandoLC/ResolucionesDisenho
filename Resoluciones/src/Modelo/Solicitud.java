/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Enums.Estado;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Armando
 */
public class Solicitud {
    //Atributos representados con relaciones a otras clases
    private Resolucion resolucion;
    private Estudiante afectado;
    private Persona solicitante;
    private Oferta infoCurso; //Por medio de este atributo se pueden obtener datos del curso y profesor
    
    //Atributos propios de esta clase
    private int id;
    private Date fecha ;
    private String tipoSituacion;
    private String descripcionDetallada;
    private ArrayList<String> listaAnotaciones;
    private String rutaArchivoAdjunto;
    private Estado estado;
    private String aclaracion;
    
    public Resolucion getResolucion() {
        return resolucion;
    }

    public void setResolucion(Resolucion resolucion) {
        this.resolucion = resolucion;
    }

    public Estudiante getAfectado() {
        return afectado;
    }

    public void setAfectado(Estudiante afectado) {
        this.afectado = afectado;
    }

    public Persona getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Persona solicitante) {
        this.solicitante = solicitante;
    }

    public Oferta getInfoCurso() {
        return infoCurso;
    }

    public void setInfoCurso(Oferta infoCurso) {
        this.infoCurso = infoCurso;
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

    public ArrayList<String> getListaAnotaciones() {
        return listaAnotaciones;
    }

    public void setListaAnotaciones(ArrayList<String> listaAnotaciones) {
        this.listaAnotaciones = listaAnotaciones;
    }

    public String getRutaArchivoAdjunto() {
        return rutaArchivoAdjunto;
    }

    public void setRutaArchivoAdjunto(String rutaArchivoAdjunto) {
        this.rutaArchivoAdjunto = rutaArchivoAdjunto;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getAclaracion() {
        return aclaracion;
    }

    public void setAclaracion(String aclaracion) {
        this.aclaracion = aclaracion;
    }
    
    
    public void RegistrarAnotacion(String anotacion){
        listaAnotaciones.add(anotacion);

    }
    
    
    @Override
    public String toString() {
        return "Solicitud{" + "resolucion=" + resolucion + ", afectado=" + afectado + ", solicitante=" + solicitante + ", infoCurso=" + infoCurso + ", id=" + id + ", fecha=" + fecha + ", tipoSituacion=" + tipoSituacion + ", descripcionDetallada=" + descripcionDetallada + ", listaAnotaciones=" + listaAnotaciones + ", rutaArchivoAdjunto=" + rutaArchivoAdjunto + ", estado=" + estado + ", aclaracion=" + aclaracion + '}';
    }
}
