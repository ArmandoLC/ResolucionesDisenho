/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;

/**
 *
 * @author Armando
 */
public class DTOferta {

    private String periodo;
    private String idCurso;
    private int nGrupo;
    private String idProfesor;
    private String horario;
    private String aula;
    
    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public int getnGrupo() {
        return nGrupo;
    }

    public void setnGrupo(int nGrupo) {
        this.nGrupo = nGrupo;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    @Override
    public String toString() {
        return "DTOferta{" + "periodo=" + periodo + ", idCurso=" + idCurso + ", nGrupo=" + nGrupo + ", idProfesor=" + idProfesor + ", horario=" + horario + ", aula=" + aula + '}';
    }
    
    
}
