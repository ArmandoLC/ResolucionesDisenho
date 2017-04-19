
import DTOs.DTOCurso;
import DTOs.DTOPersona;
import DTOs.DTOSolicitud;
import DTOs.DTOferta;
import Modelo.Solicitud;
import Modelo.SolicitudBuilder;
import java.io.File;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import jxl.Sheet;
import jxl.Workbook;

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
    public static void main(String[] args) throws Exception{
        try {
            /*//Pueba de la creación de la solicitud
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
             */
            /*
            ArrayList<String> situaciones = new ArrayList<String>();
            File f = new File("C:\\Users\\Armando\\Documents\\I Semestre 2017\\Diseño de Software\\Proyectos\\Proyecto#1\\Datos\\DatosProyecto1.xls");

            Workbook wb = Workbook.getWorkbook(f);
            Sheet sheet = wb.getSheet("SITUACIONES");
            int rows = sheet.getRows();
            int cols = sheet.getColumns();
            for (int i = 1; i < rows; i++) {
               situaciones.add(sheet.getCell(0, i).getContents());
            }
            for (int i = 0; i < situaciones.size(); i++) {
                System.out.println(situaciones.get(i).toString());
            }
            */

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
