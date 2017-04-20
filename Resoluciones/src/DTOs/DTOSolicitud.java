package DTOs;
import java.util.Date;


public class DTOSolicitud {

    // Solicitud
    private int id;
    private Date fecha;
    private String idSolicitante;
    private String nombreSolicitante;
    private String periodo;
    private String codigoCurso;
    private int nGrupo;
    private String idAfectado;
    private String nombreAfectado;
    private String correoAfectado;
    private String telefonoAfectado;
    private String inconsistencia;
    private String descripcionDetallada;
    private String rutaArchivoAdjunto;
    private String estado;
    private String aclaracion;
    private int nResolucion;
    

    public DTOSolicitud() {
    }

    public DTOSolicitud(int id, Date fecha, String idSolicitante, String nombreSolicitante, String periodo, String codigoCurso, int nGrupo, String idAfectado, String nombreAfectado, String correoAfectado, String telefonoAfectado, String tipoSituacion, String descripcionDetallada, String rutaArchivoAdjunto, String estado, String aclaracion, int nResolucion) {
        this.id = id;
        this.fecha = fecha;
        this.idSolicitante = idSolicitante;
        this.nombreSolicitante = nombreSolicitante;
        this.periodo = periodo;
        this.codigoCurso = codigoCurso;
        this.nGrupo = nGrupo;
        this.idAfectado = idAfectado;
        this.nombreAfectado = nombreAfectado;
        this.correoAfectado = correoAfectado;
        this.telefonoAfectado = telefonoAfectado;
        this.inconsistencia = tipoSituacion;
        this.descripcionDetallada = descripcionDetallada;
        this.rutaArchivoAdjunto = rutaArchivoAdjunto;
        this.estado = estado;
        this.aclaracion = aclaracion;
        this.nResolucion = nResolucion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(String idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public String getNombreSolicitante() {
        return nombreSolicitante;
    }

    public void setNombreSolicitante(String nombreSolicitante) {
        this.nombreSolicitante = nombreSolicitante;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public int getnGrupo() {
        return nGrupo;
    }

    public void setnGrupo(int nGrupo) {
        this.nGrupo = nGrupo;
    }

    public String getIdAfectado() {
        return idAfectado;
    }

    public void setIdAfectado(String idAfectado) {
        this.idAfectado = idAfectado;
    }

    public String getNombreAfectado() {
        return nombreAfectado;
    }

    public void setNombreAfectado(String nombreAfectado) {
        this.nombreAfectado = nombreAfectado;
    }

    public String getCorreoAfectado() {
        return correoAfectado;
    }

    public void setCorreoAfectado(String correoAfectado) {
        this.correoAfectado = correoAfectado;
    }

    public String getTelefonoAfectado() {
        return telefonoAfectado;
    }

    public void setTelefonoAfectado(String telefonoAfectado) {
        this.telefonoAfectado = telefonoAfectado;
    }

    public String getInconsistencia() {
        return inconsistencia;
    }

    public void setInconsistencia(String inconsistencia) {
        this.inconsistencia = inconsistencia;
    }

    public String getDescripcionDetallada() {
        return descripcionDetallada;
    }

    public void setDescripcionDetallada(String descripcionDetallada) {
        this.descripcionDetallada = descripcionDetallada;
    }

    public String getRutaArchivoAdjunto() {
        return rutaArchivoAdjunto;
    }

    public void setRutaArchivoAdjunto(String rutaArchivoAdjunto) {
        this.rutaArchivoAdjunto = rutaArchivoAdjunto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAclaracion() {
        return aclaracion;
    }

    public void setAclaracion(String aclaracion) {
        this.aclaracion = aclaracion;
    }

    public int getnResolucion() {
        return nResolucion;
    }

    public void setnResolucion(int nResolucion) {
        this.nResolucion = nResolucion;
    }

    @Override
    public String toString() {
        return "DTOSolicitud{" + "id=" + id + ", fecha=" + fecha + ", idSolicitante=" + idSolicitante + ", nombreSolicitante=" + nombreSolicitante + ", periodo=" + periodo + ", codigoCurso=" + codigoCurso + ", nGrupo=" + nGrupo + ", idAfectado=" + idAfectado + ", nombreAfectado=" + nombreAfectado + ", correoAfectado=" + correoAfectado + ", telefonoAfectado=" + telefonoAfectado + ", tipoSituacion=" + inconsistencia + ", descripcionDetallada=" + descripcionDetallada + ", rutaArchivoAdjunto=" + rutaArchivoAdjunto + ", estado=" + estado + ", aclaracion=" + aclaracion + ", nResolucion=" + nResolucion + '}';
    } 

}
