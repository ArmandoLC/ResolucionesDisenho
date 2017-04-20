package Modelo;

import java.util.ArrayList;
import java.util.Date;


public class Resolucion {
    private int nResolucion;
    private Date fecha;
    private String nombreCoordinador;
    private String nombreDirectorEscuela;
    private String nombreDirectorAdmYReg;
    private String introduccion;
    private String resultado;
    private String considerandos;
    private String resuelvo;

    public Resolucion() {
    }

    public Resolucion(int nResolucion, 
                      Date fecha, 
                      String nombreCoordinador, 
                      String nombreDirectorEscuela, 
                      String nombreDirectorAdmYReg, 
                      String introduccion, 
                      String resultado, 
                      String considerandos, 
                      String resuelvo) {
        
        this.nResolucion = nResolucion;
        this.fecha = fecha;
        this.nombreCoordinador = nombreCoordinador;
        this.nombreDirectorEscuela = nombreDirectorEscuela;
        this.nombreDirectorAdmYReg = nombreDirectorAdmYReg;
        this.introduccion = introduccion;
        this.resultado = resultado;
        this.considerandos = considerandos;
        this.resuelvo = resuelvo;
    }

    public int getnResolucion() {
        return nResolucion;
    }

    public void setnResolucion(int nResolucion) {
        this.nResolucion = nResolucion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreCoordinador() {
        return nombreCoordinador;
    }

    public void setNombreCoordinador(String nombreCoordinador) {
        this.nombreCoordinador = nombreCoordinador;
    }

    public String getNombreDirectorEscuela() {
        return nombreDirectorEscuela;
    }

    public void setNombreDirectorEscuela(String nombreDirectorEscuela) {
        this.nombreDirectorEscuela = nombreDirectorEscuela;
    }

    public String getNombreDirectorAdmYReg() {
        return nombreDirectorAdmYReg;
    }

    public void setNombreDirectorAdmYReg(String nombreDirectorAdmYReg) {
        this.nombreDirectorAdmYReg = nombreDirectorAdmYReg;
    }

    public String getIntroduccion() {
        return introduccion;
    }

    public void setIntroduccion(String introduccion) {
        this.introduccion = introduccion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getConsiderandos() {
        return considerandos;
    }

    public void setConsiderandos(String considerandos) {
        this.considerandos = considerandos;
    }

    public String getResuelvo() {
        return resuelvo;
    }

    public void setResuelvo(String resuelvo) {
        this.resuelvo = resuelvo;
    }

    @Override
    public String toString() {
        return "Resolucion{" + "nResolucion=" + nResolucion + ", fecha=" + fecha + ", nombreCoordinador=" + nombreCoordinador + ", nombreDirectorEscuela=" + nombreDirectorEscuela + ", nombreDirectorAdmYReg=" + nombreDirectorAdmYReg + ", introduccion=" + introduccion + ", resultado=" + resultado + ", considerandos=" + considerandos + ", resuelvo=" + resuelvo + '}';
    }

}
