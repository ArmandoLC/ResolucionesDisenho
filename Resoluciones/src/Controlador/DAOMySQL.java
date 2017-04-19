

package Controlador;

import DTOs.DTOSolicitud;
import java.sql.*;
import java.util.ArrayList;


public class DAOMySQL extends DAOSolicitud{
       
    @Override
    public ArrayList<DTOSolicitud> ConsultarSolicitudes() {
        
        ArrayList<DTOSolicitud> retorno = new ArrayList<>();
        String procAlmacenado = "{call consultarSolicitudes()}";
        ResultSet rs;
        Connection conexion = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(rutaConexion, user, pass);            
            CallableStatement conexionSP = conexion.prepareCall(procAlmacenado);
            
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
                                                    rs.getString("tipoSituacion"),
                                                    rs.getString("descripcion"),
                                                    rs.getString("rutaAdjunto"), 
                                                    rs.getString("aclaracion"), 
                                                    new ArrayList<>()
                                                ) );
                }
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            return null;
        }
        
        return retorno;
        
    }

    
    public int RegistrarSolicitud(DTOSolicitud dtoSolicitud) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public ArrayList<DTOSolicitud> RegistrarSolicitudes(ArrayList<DTOSolicitud> dtoSolicitudes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DAOMySQL(){
        setRutaConexion("jdbc:mysql://localhost:3306/resolucionesbd");
    }
    
    String user = "root"; String pass = "1234";
    
}
