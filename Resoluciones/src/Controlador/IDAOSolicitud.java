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
public interface IDAOSolicitud {

    public ArrayList<DTOSolicitud> ConsultarSolicitudes();

    public int RegistrarSolicitud(DTOSolicitud dtoSolicitud);

    public ArrayList<DTOSolicitud> RegistrarSolicitudes(ArrayList<DTOSolicitud> dtoSolicitudes);
}
