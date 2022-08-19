package pf.siga.model.users;

import pf.siga.model.asesorias.asesoriasDao;
import pf.siga.model.users.usersDao;
import pf.siga.model.users.usersBean;
import pf.siga.utils.conectionSQL;
import java.sql.*;
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
