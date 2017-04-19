package Controlador;

import DTOs.DTOSolicitud;
import java.util.ArrayList;


public interface ISolicitud {

    public ArrayList<DTOSolicitud> ConsultarSolicitudes();

    public int RegistrarSolicitud(DTOSolicitud dtoSolicitud);
}
