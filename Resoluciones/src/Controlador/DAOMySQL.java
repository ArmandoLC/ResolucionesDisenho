

package Controlador;

import DTOs.*;
import Modelo.Resolucion;
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
    
    public int RegistrarOferta(DTOferta dtoOferta) {      
        
        DTOferta dto = dtoOferta;
        ResultSet rs; int lastID = -1;
        
        try {
                       
            CallableStatement conexionSP = obtenerConexionSP("{call registrarOferta(?,?,?,?,?,?)}");
                        
            conexionSP.setString("codCurso", dto.getIdCurso());
            conexionSP.setString("idProfe", dto.getIdProfesor());
            conexionSP.setInt("nGrupo", dto.getnGrupo());
            conexionSP.setString("period", dto.getPeriodo());
            conexionSP.setString("sched", dto.getHorario());
            conexionSP.setString("class", dto.getAula());
            
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
    
    public void RegistrarCurso(DTOCurso dtoCurso) {      
        
        DTOCurso dto = dtoCurso;
        ResultSet rs; 
        
        try {
                       
            CallableStatement conexionSP = obtenerConexionSP("{call registrarCurso(?,?,?)}");
                        
            conexionSP.setString("cod", dto.getId());
            conexionSP.setString("nomb", dto.getNombre());
            conexionSP.setInt("cred", dto.getCreditos());
            
            rs = conexionSP.executeQuery(); 

        } 
        catch (Exception e){}
    }
    
    public int RegistrarInconsistencia(String nombre) {      
        
        ResultSet rs; int lastID = -1;
        
        try {
                       
            CallableStatement conexionSP = obtenerConexionSP("{call registrarInconsistencia(?)}");
                        
            conexionSP.setString("detail", nombre);
            
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
    
    public void RegistrarProfesor(DTOPersona dtoPersona) {      
        
        DTOPersona dto = dtoPersona;
        ResultSet rs; int lastID = -1;
        
        try {
                       
            CallableStatement conexionSP = obtenerConexionSP("{call registrarProfesor(?,?,?,?)}");
                        
            conexionSP.setString("identif", dto.getId());
            conexionSP.setString("nomb", dto.getNombre());
            conexionSP.setString("mail", dto.getCorreo());
            conexionSP.setString("tel", dto.getTelefono());
            
            rs = conexionSP.executeQuery(); 
        } 
        catch (Exception e) {}
        
    }
    
    public void AnularSolicitud(int idSolicitud, String aclaracion) {      
        
        ResultSet rs;
        
        try {
                       
            CallableStatement conexionSP = obtenerConexionSP("{call anularSolicitud(?,?)}");
                        
            conexionSP.setInt("idS", idSolicitud);
            conexionSP.setString("aclaration", aclaracion);
            
            rs = conexionSP.executeQuery(); 
        } 
        catch (Exception e) {}
        
    }
    
    public void TramitarSolicitud(int idSolicitud) {      
        
        ResultSet rs;
        
        try {
                       
            CallableStatement conexionSP = obtenerConexionSP("{call tramitarSolicitud(?)}");
                        
            conexionSP.setInt("idS", idSolicitud);
            
            rs = conexionSP.executeQuery(); 
        } 
        catch (Exception e) {}
        
    }
    public Resolucion ConsultarResolucion(int idSolicitud ){
    
        ResultSet rs;
        try{
            Resolucion resolucion = null;
            
            CallableStatement conexionSP = obtenerConexionSP("{call consultarResolucion(?)}");
            
            conexionSP.setInt("pidSolicitud", idSolicitud);
            
            rs = conexionSP.executeQuery();
            
            while ( rs.next() )
            {
                resolucion = new Resolucion();
                resolucion.setnResolucion(rs.getInt("numeroResolucion"));
                resolucion.setFecha(rs.getDate("fecha"));
                resolucion.setNombreCoordinador(rs.getString("coordinador"));
                resolucion.setNombreDirectorEscuela(rs.getString("directorEscuela"));
                resolucion.setNombreDirectorAdmYReg(rs.getString("directorAdmyReg"));
                resolucion.setIntroduccion(rs.getString("introduccion"));
                resolucion.setResultado(rs.getString("resultado"));
                resolucion.setConsiderandos(rs.getString("considerandos"));
                resolucion.setResuelvo(rs.getString("resuelvo"));
            }
            
            return resolucion;
        }
        catch(Exception e){
            return null;
        }
        
    }
    
    
    public boolean RegistrarResolucion(int idSolicitud, Resolucion resolucion){
        
        Resolucion r = resolucion;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ResultSet rs;
        
        try{           
            CallableStatement conexionSP = obtenerConexionSP("{call registrarResolucion(?,?,?,?,?,?,?,?,?,?)}");
            conexionSP.setInt("idSolicitud", idSolicitud);
            conexionSP.setInt("nResolucion", r.getnResolucion());
            conexionSP.setString("fecha", dateFormat.format(r.getFecha()));
            conexionSP.setString("coordinador", r.getNombreCoordinador());
            conexionSP.setString("directorEscuela", r.getNombreDirectorEscuela());
            conexionSP.setString("directorAdmyReg", r.getNombreDirectorAdmYReg());
            conexionSP.setString("introduccion", r.getIntroduccion());
            conexionSP.setString("resultado", r.getResultado());
            conexionSP.setString("considerandos", r.getConsiderandos());
            conexionSP.setString("resuelvo", r.getResuelvo());
 
            rs = conexionSP.executeQuery();
            return true;
        }
        catch(Exception e){
            return false;
        }
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
