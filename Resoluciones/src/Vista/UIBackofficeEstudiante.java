/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.FacadeEstudiante;
import DTOs.DTOCurso;
import DTOs.DTOSolicitud;
import Enums.Estado;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JDialog;

/**
 *
 * @author Armando
 */
public class UIBackofficeEstudiante extends Backoffice implements UIBackoffice{

    private static FacadeEstudiante facade = new FacadeEstudiante();
    private final BackofficeEstudiante backoffice;

    public UIBackofficeEstudiante(Backoffice backoffice){
        this.backoffice = (BackofficeEstudiante) backoffice;
    }

    @Override
    public void RegistrarSolicitud( JDialog pdialog ) {
        try{  DialogRegistrarSolicitud dialog = (DialogRegistrarSolicitud) pdialog;
            DTOSolicitud dtoSolicitud = new DTOSolicitud();
            dtoSolicitud.setFecha(Calendar.getInstance().getTime()); 
            dtoSolicitud.setIdSolicitante(dialog.getTxtIdSolicitante().getText());
            dtoSolicitud.setNombreSolicitante(dialog.getTxtNombreSolicitante().getText());
            String nPeriodo =  (String) dialog.getCbPeriodo().getSelectedItem();
            String modalidad = (String) dialog.getCbModalidad().getSelectedItem();
            String anho = dialog.getTxtAnho().getText();
            String periodo = nPeriodo + String.valueOf(modalidad.charAt(0)) + anho;
            dtoSolicitud.setPeriodo(periodo);
            dtoSolicitud.setCodigoCurso((String) dialog.getCbCurso().getSelectedItem());
            dtoSolicitud.setnGrupo(Integer.parseInt((String) dialog.getCbGrupo().getSelectedItem()));
            dtoSolicitud.setIdAfectado(dialog.getTxtIdAfectado().getText());
            dtoSolicitud.setNombreAfectado(dialog.getTxtNombreAfectado().getText());
            dtoSolicitud.setCorreoAfectado(dialog.getTxtCorreoAfectado().getText());
            dtoSolicitud.setTelefonoAfectado(dialog.getTxtTelefono().getText());
            dtoSolicitud.setInconsistencia((String) dialog.getCbSituacion().getSelectedItem());         
            dtoSolicitud.setDescripcionDetallada(dialog.getTxtDescripcion().getText());
            dtoSolicitud.setRutaArchivoAdjunto(dialog.getTxtArchivoAdjunto().getText());
            dtoSolicitud.setEstado(Estado.Pendiente.name());
            dtoSolicitud.setAclaracion("sin definir");
            Integer idSolicitud = facade.RegistrarSolicitud(dtoSolicitud);
            if(idSolicitud != -1) { 
                backoffice.showMessage("La identificación de la solicitud es " + idSolicitud.toString());
                ConsultarSolicitudes();
            }
            else backoffice.showMessage("No se ha podido registrar la solicitud");
        } catch(Exception e){ backoffice.showError(e.getMessage()); }   
    }
    
    @Override
    public void ConsultarSituaciones(JDialog pdialog) {
        try{  DialogRegistrarSolicitud dialog = (DialogRegistrarSolicitud) pdialog;
            ArrayList<String> situaciones = facade.ConsultarInconsistencias();
            situaciones.forEach((situacion) -> { dialog.getCbSituacion().addItem(situacion); });
        } catch(Exception e){ backoffice.showError(e.getMessage()); }
    }
    
    @Override
    public void ConsultarSolicitudes() {
        try{  ArrayList<DTOSolicitud> solicitudes;
            solicitudes = facade.ConsultarSolicitudes();
            backoffice.getTabModelSolicitudes().setSolicitudes(solicitudes);
        } catch(Exception e){ backoffice.showError(e.getMessage()); }
    }
    
    @Override
    public void ConsultarCursos(JDialog pdialog) {
        try{  DialogRegistrarSolicitud dialog = (DialogRegistrarSolicitud) pdialog;
            ArrayList<DTOCurso> cursos = facade.ConsultarCursos();
            cursos.forEach((curso) -> { dialog.getCbCurso().addItem(curso.getId()); });
        } catch(Exception e){ backoffice.showError(e.getMessage()); }
    }

    @Override
    public void ConsultarGrupos(JDialog pdialog){
        try{  DialogRegistrarSolicitud dialog = (DialogRegistrarSolicitud) pdialog;
            dialog.getCbGrupo().removeAllItems();
            String codCurso = (String) dialog.getCbCurso().getSelectedItem();
            ArrayList<Integer> grupos = facade.ConsultarGrupos(codCurso);
            grupos.forEach((grupo) -> { dialog.getCbGrupo().addItem(grupo.toString()); });
        } catch(Exception e){ backoffice.showError(e.getMessage()); }
    }

    @Override
    public void ConsultarSolicitudesEstudiante(String idEstudiante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
