
import Controlador.DAOMySQL;
import DTOs.DTOSolicitud;
import java.util.ArrayList;


public class PruebasBrondon {


    public static void main(String[] args) {

        DAOMySQL dao = new DAOMySQL();
        
        ArrayList<DTOSolicitud> aray = dao.ConsultarSolicitudes();        
        aray.forEach((a)-> System.out.println(a.getNombreAfectado()) );
    }
}
