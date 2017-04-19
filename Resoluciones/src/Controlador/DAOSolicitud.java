package Controlador;

import DTOs.DTOSolicitud;
import java.util.ArrayList;

public abstract class DAOSolicitud {

    protected String ruta;

    public DAOSolicitud() {
    }

    public void setRutaConexion(String rutaConexion) {
        this.ruta = rutaConexion;
    } 
    
    public abstract ArrayList<DTOSolicitud> ConsultarSolicitudes();    

}
