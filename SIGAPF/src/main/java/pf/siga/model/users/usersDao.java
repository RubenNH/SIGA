package pf.siga.model.users;

import pf.siga.model.asesorias.asesoriasDao;
import pf.siga.model.users.usersDao;
import pf.siga.model.users.usersBean;
import pf.siga.utils.conectionSQL;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class usersDao {

    Connection conn;
    PreparedStatement pstm;
    CallableStatement cstm;
    ResultSet rs;

    public usersBean validate(String username, String password) {
        try {
            conn = new conectionSQL().getConnection();
            String query = "SELECT * FROM users WHERE username = ? " +
                    "AND password = ?;"; //AND status = 1
            pstm = conn.prepareStatement(query);
            pstm.setString(1,username);
            pstm.setString(2,password);
            rs = pstm.executeQuery();
            if (rs.next()){
                usersBean user = new usersBean();
                user.setId(rs.getInt("id_Users"));
                user.setUsername(rs.getString("username"));
                user.setStatus(rs.getInt("estatus"));
                user.setPermiso(rs.getInt("permiso"));
                query = "INSERT INTO logincount" +
                        "(FkUser) VALUES (?)";
                pstm = conn.prepareStatement(query);
                pstm.setString(1, username);
                pstm.executeUpdate();
                return user;
            }
            return null;
        } catch (SQLException e) {
            Logger.getLogger(usersDao.class.getName())
                    .log(Level.SEVERE, "Error validate method" + e);
            return null;
        } finally {
            closeConnections();
        }
    }

    public usersBean locateU(String username) {
        usersBean user = null;
        try {
            conn = new conectionSQL().getConnection();
            String query = "SELECT * FROM Users where username = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, username);
            rs = pstm.executeQuery();
            if (rs.next()){
                user = new usersBean();
                user.setId(rs.getInt("id_Users"));}
        } catch (SQLException e) {
            Logger.getLogger(asesoriasDao.class.getName())
                    .log(Level.SEVERE, "Error findAll", e);
        } finally {
            closeConnections();
        }
        return user;
    }

    public usersBean locateE() {
        usersBean user = null;
        try {
            conn = new conectionSQL().getConnection();
            String query = "SELECT * FROM locateUser ;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            if (rs.next()){
            user = new usersBean();
            user.setUsername(rs.getString("FkUser"));}
        } catch (SQLException e) {
            Logger.getLogger(asesoriasDao.class.getName())
                    .log(Level.SEVERE, "Error findAll", e);
        } finally {
            closeConnections();
        }
        return user;
    }

    public usersBean locateD() {
        usersBean user = null;
        try {
            conn = new conectionSQL().getConnection();
            String query = "SELECT * FROM borrarHistD ;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            if (rs.next()){
                user = new usersBean();
                user.setUsername(rs.getString("FkUser"));
                user.setId(rs.getInt("idProfesores"));}
        } catch (SQLException e) {
            Logger.getLogger(asesoriasDao.class.getName())
                    .log(Level.SEVERE, "Error findAll", e);
        } finally {
            closeConnections();
        }
        return user;
    }


    public usersBean controlA() {
        usersBean user = null;
        try {
            conn = new conectionSQL().getConnection();
            String query = "SELECT * FROM conteo;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            if (rs.next()){
                user = new usersBean();
                user.setLogT(rs.getInt("count(*)"));
                query = "SELECT * FROM conteoH;";
                pstm = conn.prepareStatement(query);
                rs = pstm.executeQuery();
                if (rs.next()){
                    user.setLogH(rs.getInt("count(*)"));
                    query = "SELECT * FROM conteoM;";
                    pstm = conn.prepareStatement(query);
                    rs = pstm.executeQuery();
                    if (rs.next()){
                        user.setLogM(rs.getInt("count(*)"));
                        query = "SELECT * FROM conteoO;";
                        pstm = conn.prepareStatement(query);
                        rs = pstm.executeQuery();
                        if (rs.next()){
                            user.setLogO(rs.getInt("count(*)"));
                            query = "SELECT * FROM asesConteo;";
                            pstm = conn.prepareStatement(query);
                            rs = pstm.executeQuery();
                            if (rs.next()){
                                user.setImpT(rs.getInt("count(*)"));
                                query = "SELECT * FROM asesConteoH;";
                                pstm = conn.prepareStatement(query);
                                rs = pstm.executeQuery();
                                if (rs.next()){
                                    user.setImpH(rs.getInt("count(*)"));
                                    query = "SELECT * FROM asesConteoM;";
                                    pstm = conn.prepareStatement(query);
                                    rs = pstm.executeQuery();
                                    if (rs.next()){
                                        user.setImpM(rs.getInt("count(*)"));
                                        query = "SELECT * FROM asesConteoO;";
                                        pstm = conn.prepareStatement(query);
                                        rs = pstm.executeQuery();
                                        if (rs.next()){
                                            user.setImpO(rs.getInt("count(*)"));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(asesoriasDao.class.getName())
                    .log(Level.SEVERE, "Error findAll", e);
        } finally {
            closeConnections();
        }
        return user;
    }

    public boolean verifyUser(String username) {
        try {
            conn = new conectionSQL().getConnection();
            String query = "SELECT id_Users FROM users WHERE " +
                    "username = ?";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, username);
            rs = pstm.executeQuery();
            if (rs.next())
                return true;
        } catch (SQLException e) {
            Logger.getLogger(usersDao.class.getName())
                    .log(Level.SEVERE, "Error verifyUser" + e);
        } finally {
            closeConnections();
        }
        return false;
    }

    public boolean saveUser(usersBean AddD) {
        usersBean save = null;
        try {
            conn = new conectionSQL().getConnection();
            String query = "INSERT INTO users" +
                    "(username, password, estatus)" +
                    " VALUES (?,?,?)";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, AddD.getUsername());
            pstm.setString(2, AddD.getPassword());
            pstm.setInt(3, AddD.getStatus());
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(usersBean.class.getName())
                    .log(Level.SEVERE, "Error save", e);
            return false;
        } finally {
            closeConnections();
        }
    }

    public boolean saveDoc(usersBean AddD) {
        usersBean save = null;
        try {
            conn = new conectionSQL().getConnection();
            String query = "INSERT INTO Profesores" +
                    "(docente, apeDocente, Fk_User)" +
                    " VALUES (?,?,?)";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, AddD.getNombres());
            pstm.setString(2, AddD.getApellidos());
            pstm.setInt(3, AddD.getId());
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(usersBean.class.getName())
                    .log(Level.SEVERE, "Error save", e);
            return false;
        } finally {
            closeConnections();
        }
    }

    public boolean saveEst(usersBean AddD) {
        usersBean save = null;
        try {
            conn = new conectionSQL().getConnection();
            String query = "INSERT INTO Estudiante" +
                    "(alumno, apeAlumno, Fk_Usuario, id_Matricula, telefono, genero, Fk_Carrera, Fk_Cuatri)" +
                    " VALUES (?,?,?,?,?,?,?,?)";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, AddD.getNombres());
            pstm.setString(2, AddD.getApellidos());
            pstm.setInt(3, AddD.getId());
            pstm.setString(4, AddD.getId_Matricula());
            pstm.setLong(5, AddD.getTelefono());
            pstm.setInt(6, AddD.getGenero());
            pstm.setInt(7, AddD.getFk_Carrera());
            pstm.setInt(8, AddD.getFk_Cuatri());
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(usersBean.class.getName())
                    .log(Level.SEVERE, "Error save", e);
            return false;
        } finally {
            closeConnections();
        }
    }

    public usersBean getEst(String username) {
        usersBean user = null;
        try {
            conn = new conectionSQL().getConnection();
            String query = "SELECT * FROM UserEstudiante where username = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, username);
            rs = pstm.executeQuery();
            if (rs.next()){
                user = new usersBean();
                user.setId(rs.getInt("id_Users"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setId_Matricula(rs.getString("id_Matricula"));
                user.setTelefono(rs.getLong("telefono"));
                user.setGenero(rs.getInt("genero"));
                user.setNombres(rs.getString("alumno"));
                user.setApellidos(rs.getString("apeAlumno"));
                user.setCarrara(rs.getString("carreras"));
                user.setCuatrimestre(rs.getString("cuatrimestre"));
                user.setFk_Cuatri(rs.getInt("Fk_Cuatri"));
                user.setFk_Carrera(rs.getInt("Fk_Carrera"));}
        } catch (SQLException e) {
            Logger.getLogger(asesoriasDao.class.getName())
                    .log(Level.SEVERE, "Error findAll", e);
        } finally {
            closeConnections();
        }
        return user;
    }

    public usersBean getDoc(String username) {
        usersBean user = null;
        try {
            conn = new conectionSQL().getConnection();
            String query = "SELECT * FROM UserDocente where username = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, username);
            rs = pstm.executeQuery();
            if (rs.next()){
                user = new usersBean();
                user.setId(rs.getInt("id_Users"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setId_Matricula(rs.getString("idProfesores"));
                user.setNombres(rs.getString("docente"));
                user.setApellidos(rs.getString("apeDocente"));}
        } catch (SQLException e) {
            Logger.getLogger(asesoriasDao.class.getName())
                    .log(Level.SEVERE, "Error findAll", e);
        } finally {
            closeConnections();
        }
        return user;
    }

    public void closeConnections() {
        try {
            if (conn != null) {
                conn.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (cstm != null) {
                cstm.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
        }
    }
}
