package SIGA.Model.Auth;

import SIGA.Utils.MySQLConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoAuth {
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
                user.setUsername(rs.getString("username"));
                //user.setStatus(rs.getInt("status"));
                return user;
            }
            return null;
        } catch (SQLException e) {
            Logger.getLogger(DaoAuth.class.getName())
                    .log(Level.SEVERE, "Error validate method" + e);
            return null;
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
