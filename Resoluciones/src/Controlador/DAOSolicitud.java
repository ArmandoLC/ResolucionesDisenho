/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DTOs.DTOSolicitud;
import java.util.ArrayList;

/**
 *
 * @author Armando
 */
public abstract class DAOSolicitud {

    protected String rutaConexion;

    public DAOSolicitud() {
    }

    public void setRutaConexion(String rutaConexion) {
        this.rutaConexion = rutaConexion;
    }
    
    
    public abstract ArrayList<DTOSolicitud> ConsultarSolicitudes();    

}
