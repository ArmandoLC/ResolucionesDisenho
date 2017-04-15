/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Tipos_Enumerados.Estado;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Armando
 */
public class Solicitud {
    //Atributos representados con relaciones a otras clases
    private Resolucion resolucion;
    private Estudiante afectado;
    private Persona solicitante;
    private Oferta inforCurso; //Por medio de este atributo se pueden obtener datos del curso y profesor
    
    //Atributos propios de esta clase
    private int id;
    private Date fecha ;
    private String tipoSituacion;
    private String descripcionDetallada;
    private ArrayList<String> listaAnotaciones;
    private String rutaArchivoAdjunto;
    private Estado estado;
    private String aclaracion;

    
    public void RegistrarAnotacion(String anotacion){
        
    }
}
