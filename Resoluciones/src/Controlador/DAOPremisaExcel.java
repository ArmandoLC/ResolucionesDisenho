/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DTOs.DTOCurso;
import DTOs.DTOPersona;
import DTOs.DTOferta;
import Controlador.IDAOPremisa;
import java.util.ArrayList;

/**
 *
 * @author Armando
 */
public class DAOPremisaExcel implements IDAOPremisa{
    private String ruta;

    @Override
    public ArrayList<DTOPersona> ConsultarCarteraDocente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DTOCurso> ConsultarPlanEstudios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DTOferta> ConsultarOfertaAcademica() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> ConsultarSituaciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
