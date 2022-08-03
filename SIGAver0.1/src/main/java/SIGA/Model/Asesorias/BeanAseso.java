package SIGA.Model.Asesorias;

public class BeanAseso {

    private long idAsesorias;
    private String tema;
    private String duda;
    private int tiempo;
    private long Profesores_idProfesores;
    private long As_Estados_idAs_Estados;
    private long Estudiante_id_Matricula;
    private long Estudiante_Carreras_idCarrera;
    private long Estudiante_Cuatri_idCuatri;

    public BeanAseso() {
    }

    public BeanAseso(long idAsesorias, String tema, String duda, int tiempo, long profesores_idProfesores, long as_Estados_idAs_Estados, long estudiante_id_Matricula, long estudiante_Carreras_idCarrera, long estudiante_Cuatri_idCuatri) {
        this.idAsesorias = idAsesorias;
        this.tema = tema;
        this.duda = duda;
        this.tiempo = tiempo;
        this.Profesores_idProfesores = profesores_idProfesores;
        this.As_Estados_idAs_Estados = as_Estados_idAs_Estados;
        this.Estudiante_id_Matricula = estudiante_id_Matricula;
        this.Estudiante_Carreras_idCarrera = estudiante_Carreras_idCarrera;
        this.Estudiante_Cuatri_idCuatri = estudiante_Cuatri_idCuatri;
    }

    public long getIdAsesorias() {
        return idAsesorias;
    }

    public void setIdAsesorias(long idAsesorias) {
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

    public long getProfesores_idProfesores() {
        return Profesores_idProfesores;
    }

    public void setProfesores_idProfesores(long profesores_idProfesores) {
        this.Profesores_idProfesores = profesores_idProfesores;
    }

    public long getAs_Estados_idAs_Estados() {
        return As_Estados_idAs_Estados;
    }

    public void setAs_Estados_idAs_Estados(long as_Estados_idAs_Estados) {
        this.As_Estados_idAs_Estados = as_Estados_idAs_Estados;
    }

    public long getEstudiante_id_Matricula() {
        return Estudiante_id_Matricula;
    }

    public void setEstudiante_id_Matricula(long estudiante_id_Matricula) {
        this.Estudiante_id_Matricula = estudiante_id_Matricula;
    }

    public long getEstudiante_Carreras_idCarrera() {
        return Estudiante_Carreras_idCarrera;
    }

    public void setEstudiante_Carreras_idCarrera(long estudiante_Carreras_idCarrera) {
        this.Estudiante_Carreras_idCarrera = estudiante_Carreras_idCarrera;
    }

    public long getEstudiante_Cuatri_idCuatri() {
        return Estudiante_Cuatri_idCuatri;
    }

    public void setEstudiante_Cuatri_idCuatri(long estudiante_Cuatri_idCuatri) {
        this.Estudiante_Cuatri_idCuatri = estudiante_Cuatri_idCuatri;
    }
}
