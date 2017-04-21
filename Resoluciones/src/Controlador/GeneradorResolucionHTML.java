package Controlador;
import Modelo.Resolucion;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

public class GeneradorResolucionHTML implements IGeneradorResolucion {

    @Override
    public boolean Generar(Resolucion resolucion, String ruta) {
        try{        
            
            Properties prop = new Properties();
            prop.load(new FileReader("src\\PropertiesFile.properties")); 
            
            String dirAdmReg = prop.getProperty("nombreDirectorAdmYReg");
            String nResolucion = prop.getProperty("nResolucionActual");
            
            String nResAct = prop.getProperty("nResolucionActual");
            
            File file = new File(ruta + "\\resolucion" + nResolucion + ".html");            
            FileWriter writer = new FileWriter(file);
            
            BufferedWriter buffer = new BufferedWriter(writer);
            
            String htmlPage = 
"<html>\n" +
"<head><meta charset=utf-8></head>" + 
"    <body>" +
"        <b>" +
"            <h3><center" +
"                Resoluci&oacute;n de la Direcci&oacute;n de la Escuela de Ingenier&iacute;a en Computaci&oacute;n\n" +
"                " +
"                <br>" +
"                Instituto Tencol&oacute;gico de Costa Rica" +
"                \n" +
"                <br><br>" +
"                RES-IC-" + nResolucion+"-2017" +
"                <br><br><br>" +
"            </center></h3>" +
"        </b>" +
"        <p><strong>" +
"                Atenci&oacute;n:</strong>" +
"                &nbsp;"+ dirAdmReg +", Director<br>" +
"                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
"                Departamento de Admisi&oacute;n y Registro" +
"        </p>" +
"        <br>" +
"        <p align=justify >" + resolucion.getIntroduccion() + 
"        </p>" +
"        <br>" +
"        <strong><h3>" +
"            RESULTANDO &Uacute;NICO" +
"        </h3></strong>" +
"        <p align=justify>" + resolucion.getResultado() + 
"        </p>" +
"        <br>" +
"        <strong><h3>" +
"            CONSIDERANDOS" +
"        </h3></strong>" +
"        <p align=justify>" + resolucion.getConsiderandos() + 
"        </p>" +
"        <br>" +
"        <strong><h3>" +
"            RESUELVO" +
"        </h3></strong>" +
"        <p align=justify>" + resolucion.getResuelvo() + 
"        </p>" +
"        <br>" +
"        <strong><h3>" +
"            NOTIF&Iacute;QUESE:" +
"        </h3></strong>" +
"        <p align=right>" + 
             resolucion.getNombreDirectorEscuela() + "<br>" +
"            Director Escuela de Ingenier&iacute;a en Computaci&oacute;n<br>" +
"            instituto Tecnol&oacute;gico de Costa Rica" +
"        </p>" +
"    </body>" +
"</html>";
            
            buffer.write(htmlPage);            
            buffer.flush();
            writer.flush();            
            
            return true;
        }
        catch (Exception e){
            return false;
        } 
        
    }    public int Generar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
