/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DTOs.DTOCurso;
import DTOs.DTOPersona;
import DTOs.DTOferta;
import java.util.ArrayList;

/**
 *
 * @author Armando
 */
public interface IDAOPremisa {

    public ArrayList<DTOPersona> ConsultarCarteraDocente() throws Exception;

    public ArrayList<DTOCurso> ConsultarPlanEstudios() throws Exception;

    public ArrayList<DTOferta> ConsultarOfertaAcademica() throws Exception;

    public ArrayList<String> ConsultarSituaciones() throws Exception;
}
