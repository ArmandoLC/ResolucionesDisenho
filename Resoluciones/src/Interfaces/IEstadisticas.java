/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DTOs.DTOCurso;
import DTOs.DTOPersona;
import DTOs.DTOSolicitud;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Armando
 */
public interface IEstadisticas {

    public ArrayList<DTOSolicitud> ConsultarSolicitudesAtendidas(Date desde, Date hasta);

    public ArrayList<DTOPersona> ConsultarTopProfesores(int top);

    public ArrayList<DTOCurso> ConsultarTopCursos(int top);
}
