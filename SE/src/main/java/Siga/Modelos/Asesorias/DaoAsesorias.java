package Siga.Modelos.Asesorias;

import Siga.Utils.MySQLConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoAsesorias {
    Connection conn;
    PreparedStatement pstm;
    CallableStatement cstm;
    ResultSet rs;

    public List<BeanAsesorias> findAll() {
        List<BeanAsesorias> Asesorias = new LinkedList<>();
        BeanAsesorias Asesoria = null;
        try {
            conn = new MySQLConnection().getConnection();
            String query = "SELECT * FROM ConsAseE;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Asesoria = new BeanAsesorias();
                Asesoria.setIdAsesorias(rs.getInt("idAsesorias"));
                Asesoria.setTema(rs.getString("tema"));
                Asesoria.setDuda(rs.getString("duda"));
                Asesoria.setTiempo(rs.getInt("tiempo"));
                Asesoria.setFkProfesores(rs.getString("nombres"));
                Asesoria.setEstados(rs.getInt("Estados"));
                Asesoria.setFkMaterias(rs.getString("nombre"));
                Asesoria.setFkMatricula(rs.getString("FkMatricula"));
                Asesorias.add(Asesoria);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoAsesorias.class.getName())
                    .log(Level.SEVERE, "Error findAll", e);
        } finally {
            closeConnections();
        }
        return Asesorias;
    }

    public BeanAsesorias findOne(Long id) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "SELECT * FROM ConsAseE WHERE idAsesorias = ?";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                BeanAsesorias asesoria = new BeanAsesorias();
                asesoria.setIdAsesorias(rs.getInt("idAsesorias"));
                asesoria.setTema(rs.getString("tema"));
                asesoria.setDuda(rs.getString("duda"));
                asesoria.setTiempo(rs.getInt("tiempo"));
                asesoria.setFkProfesores(rs.getString("nombres"));
                asesoria.setEstados(rs.getInt("Estados"));
                asesoria.setFkMaterias(rs.getString("nombre"));
                asesoria.setFkMatricula(rs.getString("FkMatricula"));
                return asesoria;
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoAsesorias.class.getName())
                    .log(Level.SEVERE, "Error findOne", e);
        } finally {
            closeConnections();
        }
        return null;
    }

    public List<BeanAsesorias> findMynes(Long id) {
        List<BeanAsesorias> Asesorias = new LinkedList<>();
        BeanAsesorias Asesoria = null;
        try {
            conn = new MySQLConnection().getConnection();
            String query = "SELECT * FROM ConsAseP where id_Users = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Asesoria = new BeanAsesorias();
                Asesoria.setIdAsesorias(rs.getInt("idAsesorias"));
                Asesoria.setTema(rs.getString("tema"));
                Asesoria.setDuda(rs.getString("duda"));
                Asesoria.setTiempo(rs.getInt("tiempo"));
                Asesoria.setFkProfesores(rs.getString("nombres"));
                Asesoria.setEstados(rs.getInt("Estados"));
                Asesoria.setFkMaterias(rs.getString("nombre"));
                Asesoria.setFkMatricula(rs.getString("FkMatricula"));
                Asesorias.add(Asesoria);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoAsesorias.class.getName())
                    .log(Level.SEVERE, "Error find", e);
        } finally {
            closeConnections();
        }
        return Asesorias;
    }

    public boolean update(BeanAsesorias asesoria) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "UPDATE Asesorias SET tema = ?, duda = ? WHERE idAsesorias = ?";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, asesoria.getTema());
            pstm.setString(2, asesoria.getDuda());
            pstm.setInt(3, (int) asesoria.getIdAsesorias());
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