/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Armando
 */
public class DTOSolicitud {

    public int id;
    public Date fecha;
    public String idSolicitante;
    public String nombreSolicitante;
    public String periodo;
    public String codigoCurso;
    public int nGrupo;
    public String idAfectado;
    public String nombreAfectado;
    public String correoAfectado;
    public String telefonoAfectado;
    public String tipoSituacion;
    public String descripcionDetallada;
    public String rutaArchivoAdjunto;
    public String aclaracion;
    public int nResolucion;
    public int fechaResolucion;
    public String nombreCoordinadorResolucion;
    public String nombreDirectorEscuelaResolucion;
    public String nombreDirectorAdmYRegResolucion;
    public ArrayList<String> listaAnotaciones;
    public ArrayList<String> listaResueltosResolucion;

}
