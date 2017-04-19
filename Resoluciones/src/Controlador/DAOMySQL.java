/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DTOs.DTOSolicitud;
import Controlador.IDAOSolicitud;
import java.util.ArrayList;

/**
 *
 * @author Armando
 */
public class DAOMySQL implements IDAOSolicitud{

    private String stringConexion;

    @Override
    public ArrayList<DTOSolicitud> ConsultarSolicitudes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public int RegistrarSolicitud(DTOSolicitud dtoSolicitud) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public ArrayList<DTOSolicitud> RegistrarSolicitudes(ArrayList<DTOSolicitud> dtoSolicitudes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
