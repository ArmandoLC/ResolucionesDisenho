package Vista;

import Controlador.FacadeCoordinador;
import DTOs.DTOCurso;
import DTOs.DTOPersona;
import DTOs.DTOResolucion;
import DTOs.DTOSolicitud;
import Enums.Estado;
import Enums.Formato;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

public class UIBackofficeCoordinador extends Backoffice implements UIBackoffice{

    private final FacadeCoordinador facade;
    private final BackofficeCoordinador backoffice;

    
    public UIBackofficeCoordinador(Backoffice backoffice){
        this.facade = new FacadeCoordinador();
        this.backoffice = (BackofficeCoordinador) backoffice;
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
            dtoSolicitud.setAclaracion("Sin definir");
            Integer idSolicitud = facade.RegistrarSolicitud(dtoSolicitud);
            if(idSolicitud != -1) { 
                backoffice.showMessage("La identificación de la solicitud es " + idSolicitud.toString());
                ConsultarSolicitudes();
            } else backoffice.showError("No se ha podido registrar la solicitud");
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
            String item = (String) backoffice.getCbEstado().getSelectedItem();
            if("Todas".equals(item)) solicitudes = facade.ConsultarSolicitudes();
            else solicitudes = facade.ConsultarSolicitudes(Estado.valueOf(item));
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
    
        
    public void ConsultarSolicitudesAtendidas(JDialog pdialog){
        try{  DialogSolicitudesAtendidas dialog = (DialogSolicitudesAtendidas) pdialog;
            dialog.getEditor().setContentType("text/html");
            Date desde = backoffice.getDpDesde().getDate();
            Date hasta = backoffice.getDpHasta().getDate();
            String reporte = GenerarReporteSolicitudesAtendidas(desde, hasta);
            dialog.getEditor().setText(reporte);
        } catch(Exception e){ backoffice.showError(e.getMessage()); }
    }
      
    private String GenerarReporteSolicitudesAtendidas(Date desde, Date hasta){
        String reporte = "<b><font color=\"#CD5C5C\">Reporte de solicitudes atendidas</font></b><br><br>";
        for(DTOSolicitud solicitud : facade.ConsultarSolicitudesAtendidas(desde, hasta)){
            DTOCurso curso = facade.ConsultarCurso(solicitud.getId());
            reporte += "<b><font color=\"#FA8072\">ID</font></b>" + solicitud.getId() + "<br>";
            reporte += "<b>Período: <b> " + solicitud.getId() + "<br>";
            reporte += "<b>Tipo de inconsistencia: <b> " + solicitud.getInconsistencia()+ "<br>";
            reporte += "<b>Número de resolución: <b> " + String.valueOf(solicitud.getnResolucion()) + "<br>";
            reporte += "<b>Curso: <b> " + curso.getId() + "  " + curso.getNombre() + "<br>";
            reporte += "<b>Grupo: <b> " + String.valueOf(solicitud.getnGrupo()) + "<br>";
        } return reporte;
    }
    
    public void ConsultarTopProfesores(JDialog pdialog) {
        try{  DialogEstadisticas dialog = (DialogEstadisticas) pdialog;
            TableModelProfesor model = new TableModelProfesor(dialog.getTabProfesores()); 
            ArrayList<DTOPersona> profs = facade.ConsultarTopProfesores(3);
            model.setPersonas( profs );
            dialog.getTabProfesores().setModel(model);
        } catch(Exception e){ backoffice.showError(e.getMessage()); }
    }

    public void ConsultarTopCursos(JDialog pdialog) {
        try{  DialogEstadisticas dialog = (DialogEstadisticas) pdialog;
            TableModelCurso model = new TableModelCurso(dialog.getTabCursos()); 
            ArrayList<DTOCurso> top = facade.ConsultarTopCursos(5);
            model.setCursos( top );
            dialog.getTabProfesores().setModel(model);
        } catch(Exception e){ backoffice.showError(e.getMessage()); }
    }
        
    
    public void TramitarSolicitud(DTOSolicitud solicitud) {
        try{  boolean respuesta = facade.TramitarSolicitud(solicitud.getId());
            if(respuesta){ backoffice.showMessage("Solicitud tramitada"); ConsultarSolicitudes(); } 
            else backoffice.showMessage("No se ha podido realizar la acción");
        } catch(Exception e){ backoffice.showError(e.getMessage()); }
    }
    
    public void AnularSolicitud(JDialog pdialog) {
        try{  DialogAclaracion dialog = (DialogAclaracion) pdialog;
            String aclaracion = dialog.getTxtAclaracion().getText();
            int nSolicitud = dialog.getSolicitud().getId();
            boolean respuesta = facade.AnularSolicitud(nSolicitud, aclaracion);
            if(respuesta){ backoffice.showMessage("Solicitud anulada"); ConsultarSolicitudes(); }
            else backoffice.showMessage("No se ha podido realizar la acción");
        } catch(Exception e){ backoffice.showError(e.getMessage()); }   
    }
   
  
    public void RegistrarInconsistencia(JDialog pdialog) {
        try{  DialogInconsistencia dialog = (DialogInconsistencia) pdialog;
            String nuevaInconsistencia = dialog.getTxtRegistrarInconsistencia().getText();
            boolean respuesta = facade.RegistrarInconsistencia(nuevaInconsistencia);
            if(respuesta) backoffice.showMessage("Nueva inconsistencia registrada");
            else backoffice.showMessage("No se ha podido registrar la inconsistencia");
        } catch(Exception e){ backoffice.showError(e.getMessage()); }
    }
    
    public void RegistrarSolicitudes() {
        try{  JFileChooser file = new JFileChooser();
            file.showOpenDialog(backoffice);
            File archivo = file.getSelectedFile();
            backoffice.showMessage("Cargando solicitudes desde:\n"+archivo.getAbsolutePath());
            boolean respuesta = facade.RegistrarSolicitudes(archivo.getAbsolutePath());
            if(respuesta) {
                backoffice.showMessage("Nueva inconsistencia registrada");
                ConsultarSolicitudes();
            }
            else backoffice.showMessage("No se ha podido registrar la inconsistencia");  
        } catch(Exception e){ backoffice.showError(e.getMessage()); }
    }
   
    
    public void RegistrarResolucion(JDialog pdialog){
        try{  DialogRegistrarResolucion dialog = (DialogRegistrarResolucion) pdialog;
            DTOResolucion resolucion = new DTOResolucion();
            resolucion.setIdSolicitud(dialog.getSolicitud().getId());
            resolucion.setIntroduccion(dialog.getIntroduccion());
            resolucion.setResultado(dialog.getResultado());
            resolucion.setConsiderandos(dialog.getConsiderandos());
            resolucion.setResuelvo(dialog.getResuelvo());
            boolean respuesta = facade.RegistrarResolucion(resolucion);
            if(respuesta) { 
                backoffice.showMessage("Resolucion registrada"); 
                dialog.getBtnGuardar().setSelected(false);
                dialog.getBtnRegistrar().setSelected(true);
                ConsultarSolicitudes();
            }
            else backoffice.showMessage("No se ha podido realizar la acción");  
        } catch(Exception e){ backoffice.showMessage(e.getMessage()); }
    }
    
    public void GuardarResolucion(JDialog pdialog) {
        try{  DialogGuardarResolucion dialog = (DialogGuardarResolucion) pdialog;
            Formato formato = Formato.valueOf((String) dialog.getCbFormatos().getSelectedItem());
            String ruta = dialog.getTxtRuta().getText();
            boolean respuesta = facade.GuardarResolucion(dialog.getResolucion(), formato, ruta);
            if(respuesta) backoffice.showMessage("Resolución guardada en " + ruta); 
            else backoffice.showMessage("No se ha podido realizar la acción");  
        } catch(Exception e){ backoffice.showMessage(e.getMessage()); }
    }

    public void ConsultarResolucion(JDialog dialog) {
        try{
            
        } catch(Exception e){ backoffice.showError(e.getMessage()); }
    }

    
}
