package pf.siga.model.asesorias;

public class Asesorias {
    private int IdAsesorias;
    private int IdUsers;
    private String Username;
    private String Pass;
    private String Tema;
    private String Duda;
    private String Razon;
    private int Tiempo;
    private int Permiso;
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

    public Asesorias(int idAsesorias, int idUsers, String username, String pass, String tema, String duda, String razon, int tiempo, int permiso, int fkProfesores, int fkEstados, String estados, int fkMaterias, String fkMatricula, String materias, String matricula, String profesor, String alumno) {
        IdAsesorias = idAsesorias;
        IdUsers = idUsers;
        Username = username;
        Pass = pass;
        Tema = tema;
        Duda = duda;
        Razon = razon;
        Tiempo = tiempo;
        Permiso = permiso;
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

    public String getRazon() {
        return Razon;
    }

    public void setRazon(String razon) {
        Razon = razon;
    }

    public int getIdUsers() {
        return IdUsers;
    }

    public void setIdUsers(int idUsers) {
        IdUsers = idUsers;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public int getPermiso() {
        return Permiso;
    }

    public void setPermiso(int permiso) {
        Permiso = permiso;
    }
}
