package Siga.Modelos.Asesorias;

public class BeanAsesorias {

    private int idAsesorias;
    private String tema;
    private String duda;
    private int tiempo;
    private int FkProfesores;
    private int Estados;
    private int FkMaterias;
    private String FkMatricula;
    private String Materias;
    private String Matricula;
    private String Profesores;

    public BeanAsesorias() {
    }

    public BeanAsesorias(int idAsesorias, String tema, String duda, int tiempo, int FkProfesores, int Estados, String FkMatricula, int FkMaterias, String Materias, String Matricula, String Profesores) {
        this.idAsesorias = idAsesorias;
        this.tema = tema;
        this.duda = duda;
        this.tiempo = tiempo;
        this.FkProfesores = FkProfesores;
        this.Estados = Estados;
        this.FkMatricula = FkMatricula;
        this.FkMaterias = FkMaterias;
        this.Profesores = Profesores;
        this.Matricula = Matricula;
        this.Materias = Materias;
    }

    public int getIdAsesorias() {
        return idAsesorias;
    }

    public void setIdAsesorias(int idAsesorias) {
        this.idAsesorias = idAsesorias;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDuda() {
        return duda;
    }

    public void setDuda(String duda) {
        this.duda = duda;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public String getProfesores() {
        return Profesores;
    }

    public void setProfesores(String Profesores) {
        this.Profesores = Profesores;
    }

    public int getEstados() {
        return Estados;
    }

    public void setEstados(int estados) {
        Estados = estados;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getMaterias() {
        return Materias;
    }

    public void setMaterias(String Materias) {
        this.Materias = Materias;
    }

    public int getFkProfesores() {return FkProfesores;}

    public void setFkProfesores(int fkProfesores) {FkProfesores = fkProfesores;}

    public int getFkMaterias() {return FkMaterias;}

    public void setFkMaterias(int fkMaterias) {FkMaterias = fkMaterias;}

    public String getFkMatricula() {return FkMatricula;}

    public void setFkMatricula(String fkMatricula) {FkMatricula = fkMatricula;}
};
