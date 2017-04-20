/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.IGeneradorResolucion;
import Modelo.Resolucion;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;


/**
 *
 * @author Armando
 */
public class GeneradorResolucionHTML implements IGeneradorResolucion {

    @Override
    public boolean Generar(Resolucion resolucion) {
        try{        
            
            Properties prop = new Properties();
            prop.load(new FileReader("src\\PropertiesFile.properties")); 
            
            String dirAdmReg = prop.getProperty("nombreDirectorAdmYReg");
            String nResolucion = prop.getProperty("nResolucionActual");
            
            String nResAct = prop.getProperty("nResolucionActual");
            
            File file = new File("D:\\resolucion" + nResolucion + ".html");            
            FileWriter writer = new FileWriter(file);
            
            BufferedWriter buffer = new BufferedWriter(writer);
            
            String htmlPage = 
"<html>\n" +
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
