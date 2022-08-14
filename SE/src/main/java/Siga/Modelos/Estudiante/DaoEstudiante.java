package Siga.Modelos.Estudiante;

import Siga.Modelos.Acceso.BeanUser;
import Siga.Modelos.Asesorias.BeanAsesorias;
import Siga.Modelos.Asesorias.DaoAsesorias;
import Siga.Modelos.Estudiante.DaoEstudiante;
import Siga.Utils.MySQLConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DaoEstudiante {
    Connection conn;
    PreparedStatement pstm;
    CallableStatement cstm;
    ResultSet rs;

    public boolean saveEstudiante(BeanEstudiante AddEstudiante) {
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
            Logger.getLogger(DaoEstudiante.class.getName())
                    .log(Level.SEVERE, "Error save", e);
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
