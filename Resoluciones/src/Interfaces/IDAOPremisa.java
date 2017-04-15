/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DTOs.DTOCurso;
import DTOs.DTOPersona;
import DTOs.DTOferta;
import java.util.ArrayList;

/**
 *
 * @author Armando
 */
public interface IDAOPremisa {

    public ArrayList<DTOPersona> ConsultarCarteraDocente();

    public ArrayList<DTOCurso> ConsultarPlanEstudios();

    public ArrayList<DTOferta> ConsultarOfertaAcademica();

    public ArrayList<String> ConsultarSituaciones();
}
