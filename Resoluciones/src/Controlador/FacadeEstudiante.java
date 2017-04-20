package Controlador;

import DTOs.DTOSolicitud;
import java.util.ArrayList;

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
