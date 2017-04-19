/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.IGeneradorResolucion;

       
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;


public class GenerardorResolucionPDF implements IGeneradorResolucion{

    @Override
    public int Generar() {
        
        Document a = new Document(PageSize.A4, 50, 50, 50, 50);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
