
import Controlador.DAOMySQL;
import DTOs.DTOCurso;
import DTOs.DTOPersona;
import DTOs.DTOSolicitud;
import DTOs.DTOferta;
import Modelo.Solicitud;
import Modelo.SolicitudBuilder;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;


public class Prueba2 {


    public static void main(String[] args) {

        DAOMySQL dao = new DAOMySQL();
        
        ArrayList<DTOSolicitud> aray = dao.ConsultarSolicitudes();
        System.out.println(aray.get(0).getCorreoAfectado());
    }
}
