package Siga.Modelos.Estudiante;

public class BeanEstudiante {

    private String id_Matricula;
    private int telefono;
    private int genero;
    private int Fk_Usuario;
    private int Fk_Carrera;
    private int Fk_Cuatri;

    public BeanEstudiante() {
    }

    public BeanEstudiante(String id_Matricula, int telefono, int genero, int fk_Usuario, int fk_Carrera, int fk_Cuatri) {
        this.id_Matricula = id_Matricula;
        this.telefono = telefono;
        this.genero = genero;
        Fk_Usuario = fk_Usuario;
        Fk_Carrera = fk_Carrera;
        Fk_Cuatri = fk_Cuatri;
    }

    public String getId_Matricula() {
        return id_Matricula;
    }

    public void setId_Matricula(String id_Matricula) {
        this.id_Matricula = id_Matricula;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public int getFk_Usuario() {
        return Fk_Usuario;
    }

    public void setFk_Usuario(int fk_Usuario) {
        Fk_Usuario = fk_Usuario;
    }

    public int getFk_Carrera() {
        return Fk_Carrera;
    }

    public void setFk_Carrera(int fk_Carrera) {
        Fk_Carrera = fk_Carrera;
    }

    public int getFk_Cuatri() {
        return Fk_Cuatri;
    }

    public void setFk_Cuatri(int fk_Cuatri) {
        Fk_Cuatri = fk_Cuatri;
    }
}
