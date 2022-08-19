package pf.siga.model.asesorias;

public class Asesorias {
    private int IdAsesorias;
    private String Tema;
    private String Duda;
    private int Tiempo;
    private int FkProfesores;
    private int FkEstados;
    private String Estados;
    private int FkMaterias;
    private String FkMatricula;
    private String Materias;
    private String Matricula;
    private String Profesor;
    private String Alumno;

    public Asesorias() {
    }

    public Asesorias(int idAsesorias, String tema, String duda, int tiempo, int fkProfesores, int fkEstados, String estados, int fkMaterias, String fkMatricula, String materias, String matricula, String profesor, String alumno) {
        IdAsesorias = idAsesorias;
        Tema = tema;
        Duda = duda;
        Tiempo = tiempo;
        FkProfesores = fkProfesores;
        FkEstados = fkEstados;
        Estados = estados;
        FkMaterias = fkMaterias;
        FkMatricula = fkMatricula;
        Materias = materias;
        Matricula = matricula;
        Profesor = profesor;
        Alumno = alumno;
    }

    public int getIdAsesorias() {
        return IdAsesorias;
    }

    public void setIdAsesorias(int idAsesorias) {
        IdAsesorias = idAsesorias;
    }

    public String getTema() {
        return Tema;
    }

    public void setTema(String tema) {
        Tema = tema;
    }

    public String getDuda() {
        return Duda;
    }

    public void setDuda(String duda) {
        Duda = duda;
    }

    public int getTiempo() {
        return Tiempo;
    }

    public void setTiempo(int tiempo) {
        Tiempo = tiempo;
    }

    public int getFkProfesores() {
        return FkProfesores;
    }

    public void setFkProfesores(int fkProfesores) {
        FkProfesores = fkProfesores;
    }

    public int getFkEstados() {
        return FkEstados;
    }

    public void setFkEstados(int fkEstados) {
        FkEstados = fkEstados;
    }

    public String getEstados() {
        return Estados;
    }

    public void setEstados(String estados) {
        Estados = estados;
    }

    public int getFkMaterias() {
        return FkMaterias;
    }

    public void setFkMaterias(int fkMaterias) {
        FkMaterias = fkMaterias;
    }

    public String getFkMatricula() {
        return FkMatricula;
    }

    public void setFkMatricula(String fkMatricula) {
        FkMatricula = fkMatricula;
    }

    public String getMaterias() {
        return Materias;
    }

    public void setMaterias(String materias) {
        Materias = materias;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public String getProfesor() {
        return Profesor;
    }

    public void setProfesor(String profesor) {
        Profesor = profesor;
    }

    public String getAlumno() {
        return Alumno;
    }

    public void setAlumno(String alumno) {
        Alumno = alumno;
    }
}
