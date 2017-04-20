

package Controlador;

import DTOs.DTOSolicitud;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class DAOMySQL extends DAOSolicitud{
      
    @Override
    public ArrayList<DTOSolicitud> ConsultarSolicitudes() {
        
        ArrayList<DTOSolicitud> resultado = getSolicitudesSinResolucion();
        
        resultado.forEach((DTO)-> agregarResolucionParaDTO(DTO) );
        
        return resultado;
        
    }
    
    private void agregarResolucionParaDTO(DTOSolicitud dto) {
        
        int idBuscado = dto.getId();        
        ResultSet rs;
        
        try {
            CallableStatement conexionSP = obtenerConexionSP("{call obtenerNumResolucionParaSolic(?)}");
            
            conexionSP.setInt("idBuscado", idBuscado);
            rs = conexionSP.executeQuery(); 

            while (rs.next() )
            {
                dto.setnResolucion( rs.getInt("numeroResolucion") );
            }
        } 
        catch (Exception e) 
        {
            dto.setnResolucion( -1 );
        }
    }
        
    private ArrayList<DTOSolicitud> getSolicitudesSinResolucion(){
        
        ArrayList<DTOSolicitud> retorno = new ArrayList<>();
        ResultSet rs;
        
        try {
           
            CallableStatement conexionSP = obtenerConexionSP("{call consultarSolicitudes()}");
            
            rs = conexionSP.executeQuery(); 

            while (rs.next() )
            {
                retorno.add(new DTOSolicitud(   rs.getInt("id"), 
                                                rs.getDate("fecha"), 
                                                rs.getString("idSolicitante"),
                                                rs.getString("solicitante"),
                                                rs.getString("periodo"),
                                                rs.getString("codigoCurso"),
                                                rs.getInt("numeroGrupo"),
                                                rs.getString("idAfectado"),
                                                rs.getString("nombreAfectado"),
                                                rs.getString("correoAfectado"),
                                                rs.getString("telefonoAfectado"),
                                                rs.getString("inconsistencia"),
                                                rs.getString("descripcion"),
                                                rs.getString("rutaAdjunto"),
                                                rs.getString("estado"),
                                                rs.getString("aclaracion"),
                                                -1
                                            ) );
            }
        } 
        catch (Exception e) 
        {
            return new ArrayList<>();
        }
        
        return retorno;
    }
    
    public int RegistrarSolicitud(DTOSolicitud dtoSolicitud) {      
        
        DTOSolicitud dto = dtoSolicitud;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ResultSet rs; int lastID = -1;
        
        try {
            
            CallableStatement conexionSP = obtenerConexionSP("{call registrarSolicitud(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        
            conexionSP.setString("fecha", dateFormat.format(dto.getFecha()));
            conexionSP.setString("idSolic", dto.getIdSolicitante());
            conexionSP.setString("nombreSolic", dto.getNombreSolicitante());
            conexionSP.setString("period", dto.getPeriodo());
            conexionSP.setString("codCurso", dto.getCodigoCurso());
            conexionSP.setInt("nGrupo", dto.getnGrupo());
            conexionSP.setString("idAfect", dto.getIdAfectado());
            conexionSP.setString("nombreAfect", dto.getNombreAfectado());
            conexionSP.setString("correoAfect", dto.getCorreoAfectado());
            conexionSP.setString("telefonoAfect", dto.getTelefonoAfectado());
            conexionSP.setString("inconsist", dto.getInconsistencia());
            conexionSP.setString("descrip", dto.getDescripcionDetallada());
            conexionSP.setString("ruta", dto.getRutaArchivoAdjunto());
            conexionSP.setString("estado", dto.getEstado());
            conexionSP.setString("aclarac", dto.getAclaracion());
            
            rs = conexionSP.executeQuery(); 

            while (rs.next() )
            {
                lastID = rs.getInt("ultimoID");
            }
        } 
        catch (Exception e) 
        {
            return -1;
        }
        return lastID;
    }
 
    public ArrayList<DTOSolicitud> RegistrarSolicitudes(ArrayList<DTOSolicitud> dtoSolicitudes) {
                        
        dtoSolicitudes.forEach((dtoSolicitud)-> registrarSolicitudObteniendoID(dtoSolicitud));
        
        return dtoSolicitudes;
        
    }
    
    private void registrarSolicitudObteniendoID(DTOSolicitud dto){
        
        int id = RegistrarSolicitud(dto);
        dto.setId(id);   
    }
    
    private CallableStatement obtenerConexionSP(String procAlmacenado) throws Exception {
        
        Class.forName("com.mysql.jdbc.Driver");
        conexion = DriverManager.getConnection(ruta, user, pass);            
        return conexion.prepareCall(procAlmacenado);
        
    }
    
    public DAOMySQL(){
        setRutaConexion("jdbc:mysql://localhost:3306/resolucionesbd");
    }
    
    private String user = "root"; 
    private String pass = "1234";
    private Connection conexion;
}
