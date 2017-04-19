
package Modelo;

import DTOs.DTOCurso;
import DTOs.DTOPersona;
import DTOs.DTOSolicitud;
import DTOs.DTOferta;
import Enums.Estado;

public class SolicitudBuilder {

    /*private Solicitud solicitud;

    public Resolucion setResolucion(DTOSolicitud dtoSolicitud) {
        return new Resolucion(dtoSolicitud.getnResolucion(), dtoSolicitud.getFecha(), dtoSolicitud.getNombreCoordinadorResolucion(), dtoSolicitud.getNombreDirectorEscuelaResolucion(), dtoSolicitud.getNombreDirectorAdmYRegResolucion(), dtoSolicitud.getListaResueltosResolucion());
    }

    public Estudiante newAfectado(DTOSolicitud dtoSolicitud) {
        return new Estudiante(dtoSolicitud.getIdAfectado(), dtoSolicitud.getNombreAfectado(), dtoSolicitud.getCorreoAfectado(), dtoSolicitud.getTelefonoAfectado());
    }

    public SolicitudBuilder setSolicitante(DTOPersona dtoPersona){
        
        solicitud.setSolicitante(new Persona(dtoPersona.getId(),dtoPersona.getNombre(),
                                 dtoPersona.getCorreo(),dtoPersona.getTelefono()));
        
        return this;
    }

    public Oferta newOferta(DTOCurso dtoCurso, DTOPersona dtoProfesor, DTOferta dtoOferta) {
        Curso curso = new Curso(dtoCurso.getId(), dtoCurso.getNombre(), dtoCurso.getCreditos());
        Profesor profesor = new Profesor(dtoProfesor.getId(), dtoProfesor.getNombre(), dtoProfesor.getCorreo(), dtoProfesor.getTelefono());
        return new Oferta(curso, profesor, dtoOferta.getPeriodo(), dtoOferta.getnGrupo(), dtoOferta.getHorario(), dtoOferta.getAula());
    }

    public SolicitudBuilder setDatosSolicitud(DTOSolicitud dtoSolicitud, DTOCurso dtoCurso, DTOferta dtoOferta, DTOPersona dtoProfesor, DTOPersona dtoSolicitante) throws Exception{
        try{
            solicitud = new Solicitud();

            solicitud.setResolucion(newResolucion(dtoSolicitud));
            solicitud.setAfectado(newAfectado(dtoSolicitud));
            solicitud.setSolicitante(newSolicitante(dtoSolicitante));
            solicitud.setInfoCurso(newOferta(dtoCurso, dtoProfesor, dtoOferta));

            solicitud.setId(dtoSolicitud.getId());
            solicitud.setFecha(dtoSolicitud.getFecha());
            solicitud.setTipoSituacion(dtoSolicitud.getTipoSituacion());
            solicitud.setDescripcionDetallada(dtoSolicitud.getDescripcionDetallada());
            solicitud.setListaAnotaciones(dtoSolicitud.getListaAnotaciones());
            solicitud.setRutaArchivoAdjunto(dtoSolicitud.getRutaArchivoAdjunto());
            solicitud.setEstado(Estado.valueOf(dtoSolicitud.getEstado())); // Se obtiene el Estado apartir de un String
            solicitud.setAclaracion(dtoSolicitud.getAclaracion());

            return this;
        }
         catch (Exception e) {
            throw new Exception("La solicitud no se pudo crear!");
        }
    }

    public Solicitud create() {
        return solicitud;
    }*/
}
