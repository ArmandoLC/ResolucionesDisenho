
import Controlador.DAOMySQL;
import DTOs.DTOSolicitud;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PruebasBrondon {


    public static void main(String[] args) {

        DAOMySQL dao = new DAOMySQL();
        DTOSolicitud s1 = new DTOSolicitud();
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                s1.setFecha(dateFormat.parse("2014-02-02"));
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
            s1.setIdSolicitante("1546468");
            s1.setNombreSolicitante("Julian");
            s1.setPeriodo("2017");
            s1.setnGrupo(40);
            s1.setCodigoCurso("s11");
            s1.setEstado("Tramitada");
            s1.setIdAfectado("idAfec");
            s1.setNombreAfectado("nameAf");
            s1.setCorreoAfectado("corAF");
            s1.setTelefonoAfectado("telAf");
            s1.setInconsistencia("exclusioooon");
            s1.setDescripcionDetallada("descripAF");
            s1.setRutaArchivoAdjunto("rutaf");
            s1.setAclaracion("lul aclaracion");
            
        System.out.println(dao.RegistrarSolicitud(s1));
    }
}
