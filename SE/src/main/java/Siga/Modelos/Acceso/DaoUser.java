package Siga.Modelos.Acceso;

//import Siga.Modelos.Asesorias.BeanAseso;
//import Siga.Modelos.Asesorias.DaoAseso;
import Siga.Modelos.Asesorias.BeanAsesorias;
import Siga.Modelos.Asesorias.DaoAsesorias;
import Siga.Utils.MySQLConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoUser {
    Connection conn;
    PreparedStatement pstm;
    CallableStatement cstm;
    ResultSet rs;

    public BeanUser validate(String username, String password) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "SELECT * FROM users WHERE username = ? " +
                    "AND password = ?;"; //AND status = 1
            pstm = conn.prepareStatement(query);
            pstm.setString(1,username);
            pstm.setString(2,password);
            rs = pstm.executeQuery();
            if (rs.next()){
                BeanUser user = new BeanUser();
                user.setId(rs.getInt("id_Users"));
                user.setUsername(rs.getString("username"));
                user.setStatus(rs.getInt("estatus"));
                user.setStatus(rs.getInt("permiso"));
                user.setNombre(rs.getString("nombres"));
                user.setApellidos(rs.getString("apellidos"));
                return user;
            }
            return null;
        } catch (SQLException e) {
            Logger.getLogger(DaoUser.class.getName())
                    .log(Level.SEVERE, "Error validate method" + e);
            return null;
        } finally {
            closeConnections();
        }


    }


    public boolean verifyUser(String username) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "SELECT id_Users FROM users WHERE " +
                    "username = ?";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, username);
            rs = pstm.executeQuery();
            if (rs.next())
                return true;
        } catch (SQLException e) {
            Logger.getLogger(DaoUser.class.getName())
                    .log(Level.SEVERE, "Error verifyUser" + e);
        } finally {
            closeConnections();
        }
        return false;
    }
    public boolean saveUser(BeanUser AddUsar) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "INSERT INTO users" +
                    "(username, password, estatus, nombres, apellidos)" +
                    " VALUES (?,?,?,?,?)";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, AddUsar.getUsername());
            pstm.setString(2, AddUsar.getPassword());
            pstm.setInt(3, AddUsar.getStatus());
            pstm.setString(4, AddUsar.getNombre());
            pstm.setString(5, AddUsar.getApellidos());
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoUser.class.getName())
                    .log(Level.SEVERE, "Error save", e);
            return false;
        } finally {
            closeConnections();
        }
    }

    public boolean saveEstudiante(BeanUser AddEstudiante) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "INSERT INTO Estudiante" +
                    "(id_Matricula, telefono, genero, Fk_Usuario, Fk_Carrera, Fk_Cuatri)" +
                    " VALUES (?,?,?,?,?,?)";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, AddEstudiante.getId_Matricula());
            pstm.setInt(2, AddEstudiante.getTelefono());
            pstm.setInt(3, AddEstudiante.getGenero());
            pstm.setInt(4, AddEstudiante.getFk_Usuario());
            pstm.setInt(5, AddEstudiante.getFk_Carrera());
            pstm.setInt(6, AddEstudiante.getFk_Cuatri());
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoUser.class.getName())
                    .log(Level.SEVERE, "Error save", e);
            return false;
        } finally {
            closeConnections();
        }
    }


    public BeanUser findDocente(Long id) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "SELECT * FROM Docente WHERE id_Users = ?";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                BeanUser docente = new BeanUser();
                docente.setId(rs.getInt("id_Users"));
                docente.setUsername(rs.getString("tema"));
                docente.setPassword(rs.getString("duda"));
                docente.setNombre(rs.getString("tiempo"));
                docente.setApellidos(rs.getString("nombres"));
                return docente;
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoAsesorias.class.getName())
                    .log(Level.SEVERE, "Error findOne", e);
        } finally {
            closeConnections();
        }
        return null;
    }

    public boolean updateDocenye(BeanAsesorias asesoria) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "UPDATE Docente SET tema = ?, duda = ? WHERE idAsesorias = ?";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, asesoria.getTema());
            pstm.setString(2, asesoria.getDuda());
            pstm.setInt(3, asesoria.getIdAsesorias());
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoAsesorias.class.getName())
                    .log(Level.SEVERE, "Error update", e);
            return false;
        } finally {
            closeConnections();
        }
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
