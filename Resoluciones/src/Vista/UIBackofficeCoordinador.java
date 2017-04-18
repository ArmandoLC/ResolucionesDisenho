/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import DTOs.DTOSolicitud;
import Vista.BackofficeCoordinador;
import Vista.FacadeEstudiante;
import java.util.ArrayList;

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
        //if(backoffice.)
        ArrayList<DTOSolicitud> solicitudes;
        //backoffice.tabModelSolicitudes.setSolicitudes(solicitudes);
    }

    public void ConsultarResolucion() {
    }

    public void ConsultarAnotaciones() {
    }

    public void ConsultarTopProfesores() {
    }

    public void ConsultarTopCursos() {
    }

    public void RegistrarSolicitud() {
    }

    public void RegistrarInconsistencia() {
    }

    public void RegistrarSolicitudesGoogleForm() {
    }

    public void RegistrarAnotacion() {
    }

    public void AnularSolicitud(DTOSolicitud solicitud, String aclaracion) {
        boolean respuesta = facade.AnularSolicitud(0, aclaracion);
        //if()
    }

    public void TramitarSolicitud(DTOSolicitud solicitud) {
        boolean respuesta = facade.TramitarSolicitud(solicitud.getId());
        if(respuesta){
            backoffice.showMessage("Solicitud tramitada\n");
            ConsultarSolicitudes();
            
        }
    }

    public void GenerarResolucion() {
        
    }
    
}
