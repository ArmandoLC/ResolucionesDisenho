package Controlador;

import DTOs.DTOSolicitud;
import java.util.ArrayList;

import java.io.BufferedReader;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DAOGoogleForm extends DAOSolicitud{

    public DAOGoogleForm() {
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
            
            reader = new BufferedReader(new FileReader(ruta));
            while ((linea = reader.readLine()) != null){
                
                if (cont >= 1)
                {
                    System.out.println("\tAtendiendo solicitud...");
                    String[] solicitud = linea.split(delimitador);
                
                    String fechaStr = solicitud[0].substring(1, 11);
                    Date fecha = formatter.parse(fechaStr);
                    
                    String idSolicitante = solicitud[1].substring(1, solicitud[1].length() - 1);
                    String nombreSolicitante = solicitud[2].substring(1, solicitud[2].length() - 1);
                    String idAfectado = solicitud[3].substring(1, solicitud[3].length() - 1);
                    String nombreAfectado = solicitud[4].substring(1, solicitud[4].length() - 1);
                    String correoAfectado = solicitud[5].substring(1, solicitud[5].length() - 1);
                    String telefAfectado = solicitud[6].substring(1, solicitud[6].length() - 1);
                    String oferta = solicitud[7].substring(1, solicitud[7].length() - 1) + 
                                    solicitud[8].substring(1, solicitud[8].length() - 1) + 
                                    solicitud[9].substring(1, solicitud[9].length() - 1) ;
                    String codCurso = solicitud[10].substring(1, solicitud[10].length() - 1);
                    int nGrupo = Integer.parseInt(solicitud[11].substring(1, solicitud[11].length() - 1));
                    String tipoSituacion = solicitud[12].substring(1, solicitud[12].length() - 1);
                    String descripDetallada = solicitud[13].substring(1, solicitud[13].length());
                    
                    
                    // Se concatena las oraciones de la descripcion detallada en caso que hubieran comas en medio.
                    if (solicitud.length > 14){
                        int actual = 14;
                        
                        while (actual < solicitud.length){
                            descripDetallada += "," + solicitud[actual].substring(0, solicitud[actual].length());
                            actual++;
                        }
                    }

                    DTOSolicitud dtoSolicitud = 
                            new DTOSolicitud(0, fecha, idSolicitante, nombreSolicitante, oferta, codCurso,
                                             nGrupo, idAfectado, nombreAfectado, correoAfectado, telefAfectado, 
                                             tipoSituacion, descripDetallada, "", "", "",0);
                    
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
}
