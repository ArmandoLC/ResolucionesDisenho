/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import DTOs.DTOSolicitud;
import Interfaces.IDAOSolicitud;
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

    @Override
    public int RegistrarSolicitud(DTOSolicitud dtoSolicitud) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DTOSolicitud> RegistrarSolicitudes(ArrayList<DTOSolicitud> dtoSolicitudes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
