/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import DTOs.DTOSolicitud;
import Enums.Estado;
import Vista.BackofficeCoordinador;
import Vista.FacadeEstudiante;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import javax.swing.JDialog;

/**
 *
 * @author Armando
 */
public class UIBackofficeCoordinador {

    private FacadeCoordinador facade;
    private BackofficeCoordinador backoffice;

    public UIBackofficeCoordinador(Backoffice backoffice){
        this.facade = new FacadeCoordinador();
        this.backoffice = (BackofficeCoordinador) backoffice;
    }
    
    public void ConsultarSolicitudes() {
        ArrayList<DTOSolicitud> solicitudes;
        String item = (String) backoffice.getCbEstado().getSelectedItem();
        if("Todas".equals(item)){
            solicitudes = facade.ConsultarSolicitudes();
        }
        else {
            Estado estado = Estado.valueOf(item);
            solicitudes = facade.ConsultarSolicitudes(estado);
        }
        backoffice.getTabModelSolicitudes().setSolicitudes(solicitudes);
    }

    public void ConsultarResolucion() {
        
    }

    public void ConsultarAnotaciones() {
    }

    public void ConsultarTopProfesores() {
    }

    public void ConsultarTopCursos() {
    }

    public void RegistrarSolicitud(JDialog dialogRegistrarSolicitud) {
        try{
            Properties prop = new Properties();
            InputStream input = new FileInputStream("config.properties");
            prop.load(input);
        
            DialogRegistrarSolicitud dialog = (DialogRegistrarSolicitud) dialogRegistrarSolicitud;
            DTOSolicitud dtoSolicitud = new DTOSolicitud();
            dtoSolicitud.setFecha(Calendar.getInstance().getTime()); 
            
            dtoSolicitud.setIdSolicitante(dialog.getTxtIdSolicitante().getText());
            dtoSolicitud.setNombreSolicitante(dialog.getTxtNombreSolicitante().getText());
            dtoSolicitud.setEstado(Estado.Pendiente.name());
            dtoSolicitud.setNombreDirectorAdmYRegResolucion(prop.getProperty("nombreDirectorAdmYReg"));
            dtoSolicitud.setNombreDirectorEscuelaResolucion(prop.getProperty("nombreDirectorEscuela"));

            String nPeriodo =  dialog.getTxtPeriodo().getText();
            String modalidad = (String) dialog.getCbModalidad().getSelectedItem();
            String anho = dialog.getTxtAnho().getText();
            String periodo = nPeriodo + modalidad + anho;
            
            int nGrupo = Integer.parseInt(dialog.getTxtGrupo().getText());
            String tipoInconsistencia = (String) dialog.getCbSituacion().getSelectedItem();
            
        
        }
        catch(NumberFormatException e){
            backoffice.showMessage("Espacio inválido");
        }
        catch(IOException e ){
            backoffice.showMessage("El archivo de propiedades no se ha encontrado");
        }
        
    }

    public void RegistrarInconsistencia(JDialog dialog) {
        DialogInconsistencia dialogIncosistencia = (DialogInconsistencia) dialog;
        String nuevaInconsistencia = dialogIncosistencia.getTxtRegistrarInconsistencia().getText();
        boolean respuesta = facade.RegistrarInconsistencia(nuevaInconsistencia);
        if(respuesta) backoffice.showMessage("Nueva inconsistencia registrada");
        else backoffice.showMessage("No se ha podido registrar la inconsistencia");
    }

    public void RegistrarSolicitudesGoogleForm(JDialog dialog) {

    }

    public void RegistrarAnotacion() {
    }

    public void AnularSolicitud(JDialog dialog) {
        DialogAclaracion dialogAclaracion = (DialogAclaracion) dialog;
        String aclaracion = dialogAclaracion.getTxtAclaracion().getText();
        int nSolicitud = dialogAclaracion.getSolicitud().getId();
        boolean respuesta = facade.AnularSolicitud(nSolicitud, aclaracion);
        if(respuesta){
            backoffice.showMessage("Solicitud tramitada");
            ConsultarSolicitudes();
        }
        else backoffice.showMessage("No se ha podido realizar la acción");
        
    }

    public void TramitarSolicitud(DTOSolicitud solicitud) {
        boolean respuesta = facade.TramitarSolicitud(solicitud.getId());
        if(respuesta){
            backoffice.showMessage("Solicitud anulada");
            ConsultarSolicitudes();
        }
        else backoffice.showMessage("No se ha podido realizar la acción");
        
    }

    public void GenerarResolucion() {
        
    }
    
}
