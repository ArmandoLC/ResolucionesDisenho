package Vista;

import DTOs.DTOSolicitud;
import Enums.Estado;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.swing.JDialog;

public class UIBackofficeCoordinador {
      
    Properties prop;
    InputStream input;
    
    private FacadeCoordinador facade;
    private BackofficeCoordinador backoffice;

    public UIBackofficeCoordinador(Backoffice backoffice){
        this.facade = new FacadeCoordinador();
        this.backoffice = (BackofficeCoordinador) backoffice;
        initPropertiesFile();
    }
    
    private void initPropertiesFile (){
        try{
            prop = new Properties();
            input = this.getClass().getResourceAsStream("PropertiesFile.properties");
            prop.load(input); 
            input.close();
        }
        catch(IOException e){
            backoffice.showMessage("Error al cargar el archivo de configuración");
        }
    }
    
    public void ConsultarSolicitudes() {
        try{
            ArrayList<DTOSolicitud> solicitudes;
            String item = (String) backoffice.getCbEstado().getSelectedItem();
            if("Todas".equals(item)) solicitudes = facade.ConsultarSolicitudes();
            else {
                Estado estado = Estado.valueOf(item);
                solicitudes = facade.ConsultarSolicitudes(estado);
            }
            backoffice.getTabModelSolicitudes().setSolicitudes(solicitudes);
        }
        catch(Exception e){
            backoffice.showMessage(e.getMessage());
        }
    }
    
    public void ConsultarSolicitudes(JDialog dialogSolicitudesAtendidas){
        try{
            DialogSolicitudesAtendidas dialog = (DialogSolicitudesAtendidas) dialogSolicitudesAtendidas;
            Date desde = backoffice.getDpDesde().getDate();
            Date hasta = backoffice.getDpHasta().getDate();
            ArrayList<DTOSolicitud> solicitudes = facade.ConsultarSolicitudesAtendidas(desde, hasta);
            for(DTOSolicitud solicitud : solicitudes){
            
            }
            dialog.getTxtSolicitudesAtendidas();
            
        }
        catch(Exception e){
            backoffice.showMessage(e.getMessage());
        }
    
    }

    public void ConsultarResolucion(JDialog dialog) {
        
    }

    public void ConsultarAnotaciones(DTOSolicitud solicitud) {
        
    }

    public void ConsultarTopProfesores(JDialog dialog) {
        
    }

    public void ConsultarTopCursos(JDialog dialog) {
        
    }
        
    public void RegistrarSolicitud(JDialog dialogRegistrarSolicitud) {
        try{
            
            DialogRegistrarSolicitud dialog = (DialogRegistrarSolicitud) dialogRegistrarSolicitud;
            DTOSolicitud dtoSolicitud = new DTOSolicitud();
            
            dtoSolicitud.setFecha(Calendar.getInstance().getTime()); 
            dtoSolicitud.setIdSolicitante(dialog.getTxtIdSolicitante().getText());
            dtoSolicitud.setNombreSolicitante(dialog.getTxtNombreSolicitante().getText());
            dtoSolicitud.setEstado(Estado.Pendiente.name());
            dtoSolicitud.setNombreDirectorAdmYRegResolucion(prop.getProperty("nombreDirectorAdmYReg"));
            dtoSolicitud.setNombreDirectorEscuelaResolucion(prop.getProperty("nombreDirectorEscuela"));
            dtoSolicitud.setNombreCoordinadorResolucion("nombreCoordinador");
           
            String nPeriodo =  dialog.getTxtPeriodo().getText();
            String modalidad = (String) dialog.getCbModalidad().getSelectedItem();
            String anho = dialog.getTxtAnho().getText();
            dtoSolicitud.setPeriodo(nPeriodo + modalidad + anho);
            
            dtoSolicitud.setCodigoCurso((String) dialog.getCbCurso().getSelectedItem());
            dtoSolicitud.setnGrupo(Integer.parseInt(dialog.getTxtGrupo().getText()));
            dtoSolicitud.setTipoSituacion((String) dialog.getCbSituacion().getSelectedItem());
            dtoSolicitud.setIdAfectado(dialog.getTxtIdAfectado().getText());
            dtoSolicitud.setNombreAfectado(dialog.getTxtNombreAfectado().getText());
            dtoSolicitud.setCorreoAfectado(dialog.getTxtCorreoAfectado().getText());
            dtoSolicitud.setTelefonoAfectado(dialog.getTxtTelefono().getText());
            dtoSolicitud.setDescripcionDetallada(dialog.getTxtDescripcion().getText());
            dtoSolicitud.setRutaArchivoAdjunto(dialog.getTxtArchivoAdjunto().getText());
            
            Integer idSolicitud = facade.RegistrarSolicitud(dtoSolicitud);
            if(idSolicitud != 0) backoffice.showMessage("La identificación de la solicitud es " + idSolicitud.toString());
            else throw new Exception("No se ha podido registrar la solicitud");
            
        }
        catch(NumberFormatException e){
            backoffice.showMessage("Espacio inválido");
        }
        catch(IOException e ){
            backoffice.showMessage("El archivo de propiedades no se ha encontrado");
        }
        catch(Exception e ){
            backoffice.showMessage(e.getMessage());
        }
        
    }

    public void RegistrarInconsistencia(JDialog dialogInconsistencia) {
        DialogInconsistencia dialog = (DialogInconsistencia) dialogInconsistencia;
        String nuevaInconsistencia = dialog.getTxtRegistrarInconsistencia().getText();
        boolean respuesta = facade.RegistrarInconsistencia(nuevaInconsistencia);
        if(respuesta) backoffice.showMessage("Nueva inconsistencia registrada");
        else backoffice.showMessage("No se ha podido registrar la inconsistencia");
    }

    public void RegistrarSolicitudesGoogleForm(JDialog dialog) {

    }

    public void RegistrarAnotacion() {
        
    }

    public void AnularSolicitud(JDialog dialogAclaracion) {
        DialogAclaracion dialog = (DialogAclaracion) dialogAclaracion;
        String aclaracion = dialog.getTxtAclaracion().getText();
        int nSolicitud = dialog.getSolicitud().getId();
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

    public void GenerarResolucion(JDialog dialog) {
        //facade.GenerarResolucion(solicitud.getId(), prop.getProperty("nResolucionActual"), ruta, Formato.HTML);
    }
    
}
