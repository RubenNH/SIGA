package SIGA.Model.Asesorias;

public class BeanAseso {

    private int idAsesorias;
    private String tema;
    private String duda;
    private int tiempo;
    private int FkProfesores;
    private int FkEstados;
    private int FkMatricula;

    public BeanAseso() {
    }

    public BeanAseso(int idAsesorias, String tema, String duda, int tiempo, int FkProfesores, int FkEstados, int FkMatricula) {
        this.idAsesorias = idAsesorias;
        this.tema = tema;
        this.duda = duda;
        this.tiempo = tiempo;
        this.FkProfesores = FkProfesores;
        this.FkEstados = FkEstados;
        this.FkMatricula = FkMatricula;
    }

    public long getIdAsesorias() {
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

    public int getFkMatricula() {
        return FkMatricula;
    }

    public void setFkMatricula(int fkMatricula) {
        FkMatricula = fkMatricula;
    }
};

