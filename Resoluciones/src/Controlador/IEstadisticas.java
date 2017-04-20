package Controlador;

import DTOs.DTOCurso;
import DTOs.DTOPersona;
import DTOs.DTOSolicitud;
import java.util.ArrayList;
import java.util.Date;

public interface IEstadisticas {

    public ArrayList<DTOSolicitud> ConsultarSolicitudesAtendidas(Date desde, Date hasta);

    public ArrayList<DTOPersona> ConsultarTopProfesores(int top);

    public ArrayList<DTOCurso> ConsultarTopCursos(int top);
}
