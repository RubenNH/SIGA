package SIGA.Model.Asesorias;

import SIGA.Utils.MySQLConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoAseso {
    Connection conn;
    PreparedStatement pstm;
    CallableStatement cstm;
    ResultSet rs;

    public List<BeanAseso> findAll() {
        List<BeanAseso> Asesorias = new LinkedList<>();
        BeanAseso Asesoria = null;
        try {
            conn = new MySQLConnection().getConnection();
            String query = "SELECT * FROM Asesorias;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Asesoria = new BeanAseso();
                Asesoria.setIdAsesorias(rs.getLong("idAsesorias"));
                Asesoria.setTema(rs.getString("tema"));
                Asesoria.setDuda(rs.getString("duda"));
                Asesoria.setTiempo(rs.getInt("tiempo"));
                Asesoria.setProfesores_idProfesores(rs.getLong("Profesores_idProfesores"));
                Asesoria.setAs_Estados_idAs_Estados(rs.getLong("As_Estados_idAs_Estados"));
                Asesoria.setEstudiante_id_Matricula(rs.getLong("Estudiante_id_Matricula"));
                Asesoria.setEstudiante_Carreras_idCarrera(rs.getLong("Estudiante_Carreras_idCarrera"));
                Asesoria.setEstudiante_Cuatri_idCuatri(rs.getLong("Estudiante_Cuatri_idCuatri"));
                Asesorias.add(Asesoria);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoAseso.class.getName())
                    .log(Level.SEVERE, "Error findAll", e);
        } finally {
            closeConnections();
        }
        return Asesorias;
    }
    public boolean save(BeanAseso asesoria) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "INSERT INTO Asesorias" +
                    "(tema, duda, tiempo, Profesores_idProfesores, As_Estados_idAs_Estados, Estudiante_id_Matricula, Estudiante_Carreras_idCarrera, Estudiante_Cuatri_idCuatri)" +
                    " VALUES (?,?,?,?,?,?,?,?)";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, asesoria.getTema());
            pstm.setString(2, asesoria.getDuda());
            pstm.setInt(3, asesoria.getTiempo());
            pstm.setLong(4, asesoria.getProfesores_idProfesores());
            pstm.setLong(5, asesoria.getAs_Estados_idAs_Estados());
            pstm.setLong(6, asesoria.getEstudiante_id_Matricula());
            pstm.setLong(7, asesoria.getEstudiante_Carreras_idCarrera());
            pstm.setLong(8, asesoria.getEstudiante_Cuatri_idCuatri());

            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoAseso.class.getName())
                    .log(Level.SEVERE, "Error save", e);
            return false;
        } finally {
            closeConnections();
        }
    }

    public BeanAseso findOne(Long id) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "SELECT * FROM Asesorias WHERE id = ?";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                BeanAseso Asesoria = new BeanAseso();
                Asesoria.setIdAsesorias(rs.getLong("idAsesorias"));
                Asesoria.setTema(rs.getString("tema"));
                Asesoria.setDuda(rs.getString("duda"));
                Asesoria.setTiempo(rs.getInt("tiempo"));
                Asesoria.setProfesores_idProfesores(rs.getLong("Profesores_idProfesores"));
                Asesoria.setAs_Estados_idAs_Estados(rs.getLong("As_Estados_idAs_Estados"));
                Asesoria.setEstudiante_id_Matricula(rs.getLong("Estudiante_id_Matricula"));
                Asesoria.setEstudiante_Carreras_idCarrera(rs.getLong("Estudiante_Carreras_idCarrera"));
                Asesoria.setEstudiante_Cuatri_idCuatri(rs.getLong("Estudiante_Cuatri_idCuatri"));
                return Asesoria;
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoAseso.class.getName())
                    .log(Level.SEVERE, "Error findOne", e);
        } finally {
            closeConnections();
        }
        return null;
    }

    public boolean update(BeanAseso asesoria) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "UPDATE Asesorias SET tema = ?, duda = ?, tiempo = ?," +
                    "As_Estados_idAs_Estados = ? WHERE id = ?";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, asesoria.getTema());
            pstm.setString(2, asesoria.getDuda());
            pstm.setInt(3, asesoria.getTiempo());
            pstm.setLong(5, asesoria.getAs_Estados_idAs_Estados());
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoAseso.class.getName())
                    .log(Level.SEVERE, "Error update", e);
            return false;
        } finally {
            closeConnections();
        }
    }

    public boolean delete(Long id) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "DELETE FROM Asesorias WHERE id = ?";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1, id);
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoAseso.class.getName())
                    .log(Level.SEVERE, "Error delete method");
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
