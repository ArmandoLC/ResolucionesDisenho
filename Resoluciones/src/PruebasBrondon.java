
import Controlador.DAOMySQL;
import DTOs.DTOSolicitud;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class PruebasBrondon {


    public static void main(String[] args) {

        DAOMySQL dao = new DAOMySQL();
        DTOSolicitud s1 = new DTOSolicitud();
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                s1.setFecha(dateFormat.parse("2015-04-15"));
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
        
        DTOSolicitud s2 = new DTOSolicitud();
            
            try {
                s2.setFecha(dateFormat.parse("2014-02-02"));
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
            s2.setIdSolicitante("1546468");
            s2.setNombreSolicitante("Julian");
            s2.setPeriodo("2017");
            s2.setnGrupo(40);
            s2.setCodigoCurso("s11");
            s2.setEstado("Tramitada");
            s2.setIdAfectado("idAfec");
            s2.setNombreAfectado("nameAf");
            s2.setCorreoAfectado("corAF");
            s2.setTelefonoAfectado("telAf");
            s2.setInconsistencia("exclusioooon");
            s2.setDescripcionDetallada("descripAF");
            s2.setRutaArchivoAdjunto("rutaf");
            s2.setAclaracion("lul aclaracion");
        ArrayList<DTOSolicitud> aray = new ArrayList<>();
        aray.add(s1); aray.add(s2);
        
        //aray = dao.RegistrarSolicitudes(aray);
        int result = dao.RegistrarSolicitud(s1);
        System.out.println("Salida: "+result);
        //System.out.println(aray.get(0).getId() + "_" + aray.get(1).getId());
    }
}
