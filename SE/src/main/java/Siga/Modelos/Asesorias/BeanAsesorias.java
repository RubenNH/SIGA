package Siga.Modelos.Asesorias;

public class BeanAsesorias {

    private int idAsesorias;
    private String tema;
    private String duda;
    private int tiempo;
    private String FkProfesores;
    private int Estados;
    private String FkMaterias;
    private String FkMatricula;

    public BeanAsesorias() {
    }

    public BeanAsesorias(int idAsesorias, String tema, String duda, int tiempo, String FkProfesores, int Estados, String FkMatricula, String FkMaterias) {
        this.idAsesorias = idAsesorias;
        this.tema = tema;
        this.duda = duda;
        this.tiempo = tiempo;
        this.FkProfesores = FkProfesores;
        this.Estados = Estados;
        this.FkMatricula = FkMatricula;
        this.FkMaterias = FkMaterias;
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

    public String getFkProfesores() {
        return FkProfesores;
    }

    public void setFkProfesores(String fkProfesores) {
        FkProfesores = fkProfesores;
    }

    public int getEstados() {
        return Estados;
    }

    public void setEstados(int estados) {
        Estados = estados;
    }

    public String getFkMatricula() {
        return FkMatricula;
    }

    public void setFkMatricula(String fkMatricula) {
        FkMatricula = fkMatricula;
    }

    public String getFkMaterias() {
        return FkMaterias;
    }

    public void setFkMaterias(String fkMaterias) {
        FkMaterias = fkMaterias;
    }
};
