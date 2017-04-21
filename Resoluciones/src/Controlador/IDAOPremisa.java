package Controlador;

import DTOs.DTOCurso;
import DTOs.DTOPersona;
import DTOs.DTOferta;
import java.util.ArrayList;

public interface IDAOPremisa {

    public ArrayList<DTOPersona> ConsultarCarteraDocente() throws Exception;

    public ArrayList<DTOCurso> ConsultarPlanEstudios() throws Exception;

    public ArrayList<DTOferta> ConsultarOfertaAcademica() throws Exception;

    public ArrayList<String> ConsultarInconsistencias() throws Exception;
}
