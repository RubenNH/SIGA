package Siga.Modelos.Acceso;

public class BeanUser {
    private int id;
    private String username;
    private String password;
    private int status;
    private String nombres;
    private String apellidos;
    private String id_Matricula;
    private int telefono;
    private int genero;
    private int Fk_Usuario;
    private int Fk_Carrera;
    private int Fk_Cuatri;
    public BeanUser() {
    }

    public BeanUser(int id, String username, String password, int status, String nombres, String apellidos, String id_Matricula, int telefono, int genero, int fk_Usuario, int fk_Carrera, int fk_Cuatri) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.id_Matricula = id_Matricula;
        this.telefono = telefono;
        this.genero = genero;
        Fk_Usuario = fk_Usuario;
        Fk_Carrera = fk_Carrera;
        Fk_Cuatri = fk_Cuatri;
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

    public String getNombres() {return nombres;}

    public void setNombres(String nombres) {this.nombres = nombres;}

    public String getId_Matricula() {return id_Matricula;}

    public void setId_Matricula(String id_Matricula) {this.id_Matricula = id_Matricula;}

    public int getTelefono() {return telefono;}

    public void setTelefono(int telefono) {this.telefono = telefono;}

    public int getGenero() {return genero;}

    public void setGenero(int genero) {this.genero = genero;}

    public int getFk_Usuario() {return Fk_Usuario;}

    public void setFk_Usuario(int fk_Usuario) {Fk_Usuario = fk_Usuario;}

    public int getFk_Carrera() {return Fk_Carrera;}

    public void setFk_Carrera(int fk_Carrera) {Fk_Carrera = fk_Carrera;}

    public int getFk_Cuatri() {return Fk_Cuatri;}

    public void setFk_Cuatri(int fk_Cuatri) {Fk_Cuatri = fk_Cuatri;}
}