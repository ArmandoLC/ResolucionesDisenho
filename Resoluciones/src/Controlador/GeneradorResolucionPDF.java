package Controlador;

import Modelo.Resolucion;
import com.itextpdf.text.Chunk;

       
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Properties;


public class GeneradorResolucionPDF implements IGeneradorResolucion{

    public GeneradorResolucionPDF() {
    }
    
    @Override
    public boolean Generar(Resolucion resolucion, String ruta) {
        try{        
            
            Font negrita = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
            Properties prop = new Properties();
            prop.load(new FileReader("src\\PropertiesFile.properties")); 
            
            String nResAct = prop.getProperty("nResolucionActual");
            
            Document document = new Document(PageSize.A4, 50, 50, 50, 50);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta + "\\resolucion" + nResAct + ".pdf"));
            
            document.open();
            
            // Encabezado
            Paragraph encabezado = 
                    new Paragraph("Resolución de la Dirección de la Escuela de Ingeniería en Computación\n"
                            + "Instituto Tecnológico de Costa Rica\n\n"
                            + "RES-IC-" + nResAct + "-2017\n\n",
                            negrita);
            
            encabezado.setAlignment(Element.ALIGN_CENTER);
            document.add(encabezado);
            
            // Receptores
            Paragraph atencion = new Paragraph();
            Chunk negAtencion = new Chunk("Atención:    " , negrita);
            Chunk receptores = new Chunk(resolucion.getNombreDirectorAdmYReg() + ", Director\n"
                                      + "                      Departamento de Admisión y Registro");
            
            atencion.add(negAtencion);
            atencion.add(receptores);            
            document.add(atencion);
            
            // Introduccion
            document.add(new Paragraph("\n" + resolucion.getIntroduccion()));
            
            // Resultandos
            Paragraph tResultando = new Paragraph("\nRESULTANDO ÚNICO:", negrita);   
            document.add(tResultando);
            document.add(new Paragraph("\n" + resolucion.getResultado()));
            
            
            //Considerandos
            Paragraph tConsiderando = new Paragraph("\nCONSIDERANDOS:", negrita);
            document.add(tConsiderando);
            document.add(new Paragraph("\n" + resolucion.getConsiderandos()));
            
            // Resulevos
            Paragraph tResuelvo = new Paragraph("\nRESUELVO:",negrita);
            document.add(tResuelvo);
            document.add(new Paragraph("\n" + resolucion.getResuelvo()));
            
            
            // Firmas - Notificacion
            Paragraph tNotifiquese = new Paragraph("\nNOTIFIQUESE:", negrita);            
            Paragraph notific = new Paragraph(resolucion.getNombreDirectorEscuela() + "\n" + 
                    "Director Escuela Ingenería en Computación\n"
                    + "Instituto Tecnológico de Costa Rica");
            
            document.add(tNotifiquese);
            notific.setAlignment(Element.ALIGN_RIGHT);
            document.add(notific);
            
            
            document.close();
            
            return true;
        }
        catch (Exception e){
            return false;
        } 
        
    }
    
}
