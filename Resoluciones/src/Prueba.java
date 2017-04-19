
import DTOs.DTOCurso;
import DTOs.DTOPersona;
import DTOs.DTOSolicitud;
import DTOs.DTOferta;
import Modelo.Solicitud;
import Modelo.SolicitudBuilder;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Armando
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*try {
             SolicitudBuilder sol =   new SolicitudBuilder();
             
             DTOCurso dtoCurso = new DTOCurso("IC400","Diseño",4);
             DTOPersona dtoSolicitante = new DTOPersona("IDArmando","Armando","Email","84317926");
             DTOPersona dtoProfesor = new DTOPersona("IDLuis","Luis","Correo","87942212");
             Date d = Date.valueOf(LocalDate.now());
             DTOSolicitud dtoSolicitud = new DTOSolicitud(1,d,"IDArmando","Armando", "I", "IC400", 4,"IDArmando" ,"NA", "CA", "TA","Situacion" , "Desc", "ruta", "Pendiente", "aclaracion", 1, 20, "Coordinador", "Director", "AdmyReg", new ArrayList(), new ArrayList());
             DTOferta dtoOferta = new DTOferta("I","IC400",1,"IDLuis","Horario","Aula");  
             sol.setDatosSolicitud(dtoSolicitud, dtoCurso, dtoOferta, dtoProfesor, dtoSolicitante);
             Solicitud s = sol.create();
             System.out.println(s.toString());
                    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
    }
}
