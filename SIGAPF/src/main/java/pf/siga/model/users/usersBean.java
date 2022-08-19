package pf.siga.model.users;

public class usersBean {
    private int Id;
    private String Username;
    private String Password;
    private int Status;
    private int Permiso;
    private String Nombres;
    private String Apellidos;
    private String Id_Matricula;
    private int Telefono;
    private int Genero;
    private int Fk_Usuario;
    private int Fk_Carrera;
    private int Fk_Cuatri;

    public usersBean() {
    }

    public usersBean(int id, String username, String password, int status, int permiso, String nombres, String apellidos, String id_Matricula, int telefono, int genero, int fk_Usuario, int fk_Carrera, int fk_Cuatri) {
        Id = id;
        Username = username;
        Password = password;
        Status = status;
        Permiso = permiso;
        Nombres = nombres;
        Apellidos = apellidos;
        Id_Matricula = id_Matricula;
        Telefono = telefono;
        Genero = genero;
        Fk_Usuario = fk_Usuario;
        Fk_Carrera = fk_Carrera;
        Fk_Cuatri = fk_Cuatri;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public int getPermiso() {
        return Permiso;
    }

    public void setPermiso(int permiso) {
        Permiso = permiso;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getId_Matricula() {
        return Id_Matricula;
    }

    public void setId_Matricula(String id_Matricula) {
        Id_Matricula = id_Matricula;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int telefono) {
        Telefono = telefono;
    }

    public int getGenero() {
        return Genero;
    }

    public void setGenero(int genero) {
        Genero = genero;
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
