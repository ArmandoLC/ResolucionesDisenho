/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DTOs.DTOCurso;
import DTOs.DTOResolucion;
import DTOs.DTOSolicitud;
import Enums.Estado;
import Enums.Formato;
import java.util.ArrayList;

/**
 *
 * @author Armando
 */
public interface ICoordinador extends IEstadisticas {

    public ArrayList<DTOSolicitud> ConsultarSolicitudes(Estado estado);

    public DTOResolucion ConsultarResolucion(int nSolicitud);

    public ArrayList<String> ConsultarAnotaciones(int nSolicitud);
    
    public DTOCurso ConsultarCurso(int nSolicitud);
    
    public ArrayList<DTOCurso> ConsultarCursos();
    
    public ArrayList<String> ConsultarSituaciones();
    
    public boolean TramitarSolicitud(int nSolicitud);

    public boolean RegistrarSolicitudesGoogleForm();

    public boolean RegistrarInconsistencia(String incosistencia);

    public boolean RegistrarAnotacion(int nSolicitud, String anotacion);

    public boolean AnularSolicitud(int nSolicitud, String aclaracion);
    
    public boolean SolicitarTemplateResolucion(int nSolicitud);

    public boolean GenerarResolucion(int nSolicitud, int nResolucion, String ruta, Formato formato);
}
