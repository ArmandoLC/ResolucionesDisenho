package Modelo;

import DTOs.DTOCurso;
import DTOs.DTOPersona;
import DTOs.DTOSolicitud;
import DTOs.DTOferta;
import Enums.Estado;

public class SolicitudBuilder {

    private Solicitud solicitud;

    public SolicitudBuilder setSolicitante(DTOPersona dtoPersona) {

        solicitud.setSolicitante(new Persona(dtoPersona.getId(), dtoPersona.getNombre(),
                dtoPersona.getCorreo(), dtoPersona.getTelefono()));
        return this;
    }

    public SolicitudBuilder setAfectado(DTOPersona dtoPersona) {
        solicitud.setAfectado(new Estudiante(dtoPersona.getId(), dtoPersona.getNombre(),
                dtoPersona.getCorreo(), dtoPersona.getTelefono()));
        return this;
    }

    public SolicitudBuilder setOferta(DTOferta dtoOferta, Curso curso, Profesor profesor) {
        solicitud.setInfoCurso(new Oferta(curso, profesor, dtoOferta.getPeriodo(),
                dtoOferta.getnGrupo(), dtoOferta.getHorario(), dtoOferta.getAula()));
        return this;
    }

    public SolicitudBuilder setDatosSolicitud(DTOSolicitud dtoSolicitud) {

        solicitud = new Solicitud();

        solicitud.setId(dtoSolicitud.getId());
        solicitud.setFecha(dtoSolicitud.getFecha());
        solicitud.setInconsistencia(dtoSolicitud.getInconsistencia());
        solicitud.setDescripcion(dtoSolicitud.getDescripcionDetallada());
        solicitud.setRutaArchivoAdjunto(dtoSolicitud.getRutaArchivoAdjunto());
        solicitud.setEstado(Estado.valueOf(dtoSolicitud.getEstado())); // Se obtiene el Estado apartir de un String
        solicitud.setAclaracion(dtoSolicitud.getAclaracion());

        return this;

    }

    public Solicitud create() {
        return solicitud;
    }
}
