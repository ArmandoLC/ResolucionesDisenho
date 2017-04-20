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
public class FacadeEstudiante extends Facade{

    @Override
    public ArrayList<DTOSolicitud> ConsultarSolicitudes() {
        return ctrl.ConsultarSolicitudes();
    }

    @Override
    public int RegistrarSolicitud(DTOSolicitud dtoSolicitud) {
        return ctrl.RegistrarSolicitud(dtoSolicitud);
    }
    
}
