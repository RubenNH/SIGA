package pf.siga.model.users;

public class usersBean {
    private int Id;
    private String Username;
    private String Password;
    private int Status;
    private int LogT;
    private int LogM;
    private int LogH;
    private int LogO;
    private int ImpT;
    private int ImpM;
    private int ImpH;
    private int ImpO;
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

    public usersBean(int id, String username, String password, int status, int logT, int logM, int logH, int logO, int impT, int impM, int impH, int impO, int permiso, String nombres, String apellidos, String id_Matricula, int telefono, int genero, int fk_Usuario, int fk_Carrera, int fk_Cuatri) {
        Id = id;
        Username = username;
        Password = password;
        Status = status;
        LogT = logT;
        LogM = logM;
        LogH = logH;
        LogO = logO;
        ImpT = impT;
        ImpM = impM;
        ImpH = impH;
        ImpO = impO;
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

    public int getLogM() {
        return LogM;
    }

    public void setLogM(int logM) {
        LogM = logM;
    }

    public int getLogH() {
        return LogH;
    }

    public void setLogH(int logH) {
        LogH = logH;
    }

    public int getLogO() {
        return LogO;
    }

    public void setLogO(int logO) {
        LogO = logO;
    }

    public int getImpM() {
        return ImpM;
    }

    public void setImpM(int impM) {
        ImpM = impM;
    }

    public int getImpH() {
        return ImpH;
    }

    public void setImpH(int impH) {
        ImpH = impH;
    }

    public int getImpO() {
        return ImpO;
    }

    public void setImpO(int impO) {
        ImpO = impO;
    }

    public int getLogT() {
        return LogT;
    }

    public void setLogT(int logT) {
        LogT = logT;
    }

    public int getImpT() {
        return ImpT;
    }

    public void setImpT(int impT) {
        ImpT = impT;
    }
}
