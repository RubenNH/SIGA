package SIGA.Model.Auth;

public class BeanUser {
    private long id;
    private String username;
    private String password;
    private int status;
    private String nombre;
    private String apellidos;
    private long Id_estudiates;
    private long Id_profesores;
    private long Id_Admin;
    public BeanUser() {
    }

    public BeanUser(long id, String username, String password, int status, String nombre, String apellidos, long id_estudiates, long id_profesores, long id_Admin) {
        this.id = id;
        this.username = username;
        this.password = password;
        //this.status = status;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.Id_estudiates = id_estudiates;
        this.Id_profesores = id_profesores;
        this.Id_Admin = id_Admin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public long getId_estudiates() {
        return Id_estudiates;
    }

    public void setId_estudiates(long id_estudiates) {
        Id_estudiates = id_estudiates;
    }

    public long getId_profesores() {
        return Id_profesores;
    }

    public void setId_profesores(long id_profesores) {
        Id_profesores = id_profesores;
    }

    public long getId_Admin() {
        return Id_Admin;
    }

    public void setId_Admin(long id_Admin) {
        Id_Admin = id_Admin;
    }
}
