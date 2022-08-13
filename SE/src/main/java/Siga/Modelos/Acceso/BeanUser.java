package Siga.Modelos.Acceso;

public class BeanUser {
    private int id;
    private String username;
    private String password;
    private int status;
    private String nombres;
    private String apellidos;
    public BeanUser() {
    }

    public BeanUser(int id, String username, String password, int status, String nombres, String apellidos) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return nombres;
    }

    public void setNombre(String nombre) {
        this.nombres = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}