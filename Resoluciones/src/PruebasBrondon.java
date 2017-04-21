
import Controlador.DAOMySQL;
import DTOs.DTOferta;

public class PruebasBrondon {

    public static void main(String[] args) {
        
        DAOMySQL dao = new DAOMySQL();
        
        dao.AnularSolicitud(12, "Satanas en vida la anulo");
    }
}
