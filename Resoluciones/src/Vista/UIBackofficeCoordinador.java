package Vista;

import DTOs.DTOCurso;
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
            dialog.getEditor().setContentType("text/html"); 
            ArrayList<DTOSolicitud> solicitudes = facade.ConsultarSolicitudesAtendidas(desde, hasta);
            String reporte = "<b><font color=\"#CD5C5C\">ID</font></b><br><br>";
            for(DTOSolicitud solicitud : solicitudes){
                DTOCurso curso = facade.ConsultarCurso(solicitud.getId());
                reporte += "<b><font color=\"#FA8072\">ID</font></b>" + solicitud.getId() + "\n";
                reporte += "<b>Período: <b> " + solicitud.getId() + "\n";
                reporte += "<b>Tipo de situación: <b> " + solicitud.getTipoSituacion() + "\n";
                reporte += "<b>Número de resolución: <b> " + String.valueOf(solicitud.getnResolucion()) + "\n";
                reporte += "<b>Curso: <b> " + curso.getId() + "  " + curso.getNombre() + "\n";
                reporte += "<b>Grupo: <b> " + String.valueOf(solicitud.getnGrupo()) + "\n";
            }
            dialog.getEditor().setText(reporte);
            
        }
        catch(Exception e){
            backoffice.showMessage(e.getMessage());
        }
    
    }

    public void ConsultarResolucion(JDialog dialog) {
        try{
            
        }
        catch(Exception e){
            backoffice.showMessage(e.getMessage());
        }
    }

    public void ConsultarAnotaciones(DTOSolicitud solicitud) {
        try{
            
        }
        catch(Exception e){
            backoffice.showMessage(e.getMessage());
        }
    }

    public void ConsultarTopProfesores(JDialog dialog) {
        try{
            
        }
        catch(Exception e){
            backoffice.showMessage(e.getMessage());
        }
    }

    public void ConsultarTopCursos(JDialog dialog) {
        try{
            
        }
        catch(Exception e){
            backoffice.showMessage(e.getMessage());
        }
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
            else backoffice.showMessage("No se ha podido registrar la solicitud");
            
        }
        catch(NumberFormatException e){
            backoffice.showMessage("Espacio inválido");
        }      
        catch(Exception e){
            backoffice.showMessage("Espacio inválido");
        }   
        
    }

    public void RegistrarInconsistencia(JDialog dialogInconsistencia) {
        try{
            DialogInconsistencia dialog = (DialogInconsistencia) dialogInconsistencia;
            String nuevaInconsistencia = dialog.getTxtRegistrarInconsistencia().getText();
            boolean respuesta = facade.RegistrarInconsistencia(nuevaInconsistencia);
            if(respuesta) backoffice.showMessage("Nueva inconsistencia registrada");
            else backoffice.showMessage("No se ha podido registrar la inconsistencia");
        }
        catch(Exception e){
            backoffice.showMessage(e.getMessage());
        }
    }

    public void RegistrarSolicitudesGoogleForm(JDialog dialog) {
        try{
            
        }
        catch(Exception e){
            backoffice.showMessage(e.getMessage());
        }
    }

    public void RegistrarAnotacion(JDialog dialog) {
        try{
            
        }
        catch(Exception e){
            backoffice.showMessage(e.getMessage());
        }
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
        try{
            
        }
        catch(Exception e){
            backoffice.showMessage(e.getMessage());
        }
    }

    public void ConsultarCursos(JDialog dialogRegistrarSolicitud) {
        try{
            DialogRegistrarSolicitud dialog = (DialogRegistrarSolicitud) dialogRegistrarSolicitud;
            ArrayList<DTOCurso> cursos = facade.ConsultarCursos();
            for(DTOCurso curso : cursos) dialog.getCbCurso().addItem(curso.getId());
        }
        catch(Exception e){
            backoffice.showMessage(e.getMessage());
        }
    }
    
    public void ConsultarSituaciones(JDialog dialogRegistrarSolicitud) {
        try{
            DialogRegistrarSolicitud dialog = (DialogRegistrarSolicitud) dialogRegistrarSolicitud;
            ArrayList<String> situaciones = facade.ConsultarSituaciones();
            for(String situacion : situaciones) dialog.getCbSituacion().addItem(situacion);
        }
        catch(Exception e){
            backoffice.showMessage(e.getMessage());
        }
    }
    
}
