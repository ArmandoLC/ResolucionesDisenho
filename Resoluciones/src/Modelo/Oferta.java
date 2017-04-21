package Modelo;

public class Oferta {
    //Atributos de relación con otras clases
    private Curso curso;
    private Profesor profesor;
    
    //Atributos propios de la oferta
    private String periodo = "";
    private int nGrupo = 0;
    private String horario = "";
    private String aula = "";

    public Oferta(){
    
    }
    
    public Oferta(Curso curso, Profesor profesor, String periodo, int nGrupo, String horario, String aula) {
        this.curso = curso;
        this.profesor = profesor;
        this.periodo = periodo;
        this.nGrupo = nGrupo;
        this.horario = horario;
        this.aula = aula;
    }

    
    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getnGrupo() {
        return nGrupo;
    }

    public void setnGrupo(int nGrupo) {
        this.nGrupo = nGrupo;
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
        return "Oferta{" + "curso=" + curso + ", profesor=" + profesor + ", periodo=" + periodo + ", nGrupo=" + nGrupo + ", horario=" + horario + ", aula=" + aula + '}';
    }
    
}
