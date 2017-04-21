package DTOs;

import java.util.ArrayList;
import java.util.Date;


public class DTOResolucion {

    private int idSolicitud;
    private int idResolucion;
    private String introduccion;
    private String resultado;
    private String considerandos;
    private String resuelvo; 

    public DTOResolucion() {
    }

    public DTOResolucion(int idSolicitud, String introduccion, String resultado, 
                         String considerandos, String resuelvo) {
        this.idSolicitud = idSolicitud;
        this.introduccion = introduccion;
        this.resultado = resultado;
        this.considerandos = considerandos;
        this.resuelvo = resuelvo;
    }
    
    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
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

    public int getIdResolucion() {
        return idResolucion;
    }

    public void setIdResolucion(int idResolucion) {
        this.idResolucion = idResolucion;
    }

    
    @Override
    public String toString() {
        return "DTOResolucion{" + "idSolicitud=" + idSolicitud + ", introduccion=" + introduccion + ", resultado=" + resultado + ", considerandos=" + considerandos + ", resuelvo=" + resuelvo + '}';
    }
    
}
