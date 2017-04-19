/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DTOs.DTOSolicitud;
import Controlador.IDAOSolicitud;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Armando
 */
public class DAOGoogleForm implements IDAOSolicitud{

    private String rutaArchivo;
    
    public DAOGoogleForm() {
    }

    public DAOGoogleForm(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }
    
    
    // Extrae todas las solicitudes de un archivo CSV, las inserta en un DTOSolicitudes
    @Override
    public ArrayList<DTOSolicitud> ConsultarSolicitudes() {
        
        ArrayList<DTOSolicitud> solicitudes = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        BufferedReader reader = null;
        String linea = "";
        String delimitador = ",";
        int cont = 0;
        
        try {
            
            reader = new BufferedReader(new FileReader(rutaArchivo));
            while ((linea = reader.readLine()) != null){
                
                if (cont >= 1)
                {
                    String[] solicitud = linea.split(delimitador);
                
                    String fechaStr = solicitud[0].substring(1, 11);
                    Date fecha = formatter.parse(fechaStr);
                    
                    String idSolicitante = solicitud[1].substring(1, solicitud[1].length() - 1);
                    String nombreSolicitante = solicitud[2].substring(1, solicitud[2].length() - 1);
                    String idAfectado = solicitud[3].substring(1, solicitud[3].length() - 1);
                    String nombreAfectado = solicitud[4].substring(1, solicitud[4].length() - 1);
                    String correoAfectado = solicitud[5].substring(1, solicitud[5].length() - 1);
                    String telefAfectado = solicitud[6].substring(1, solicitud[6].length() - 1);
                    String periodo = solicitud[7].substring(1, solicitud[7].length() - 1) + 
                                     solicitud[8].substring(1, solicitud[8].length() - 1);
                    String codCurso = solicitud[9].substring(1, solicitud[9].length() - 1);
                    int nGrupo = Integer.parseInt(solicitud[10].substring(1, solicitud[10].length() - 1));
                    String tipoSituacion = solicitud[11].substring(1, solicitud[11].length() - 1);
                    String descripDetallada = solicitud[12].substring(1, solicitud[12].length());
                    
                    
                    // Se concatena las oraciones de la descripcion detallada en caso que hubieran comas en medio.
                    if (solicitud.length > 13){
                        int actual = 13;
                        
                        while (actual < solicitud.length){
                            descripDetallada += "," + solicitud[actual].substring(0, solicitud[actual].length());
                            actual++;
                        }
                    }

                    DTOSolicitud dtoSolicitud = 
                            new DTOSolicitud(fecha, idSolicitante, nombreSolicitante, periodo, codCurso,
                                             nGrupo, idAfectado, nombreAfectado, correoAfectado, telefAfectado, 
                                             tipoSituacion, descripDetallada, "", "", new ArrayList<String>());
                    
                    solicitudes.add(dtoSolicitud);
                    
                }
                cont++;
            }            
        }
        catch (Exception e){
            return null;
        }
        
        // Cerrar el archivo
        finally {
            if (reader != null){
                try{
                    reader.close();
                }
                catch (Exception e){ 
                    throw new UnsupportedOperationException("No se pudo cerrar el archivo!");
                }
            }
        }
        
        return solicitudes;
    }

    @Override
    public int RegistrarSolicitud(DTOSolicitud dtoSolicitud) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DTOSolicitud> RegistrarSolicitudes(ArrayList<DTOSolicitud> dtoSolicitudes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
