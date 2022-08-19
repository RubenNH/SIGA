package pf.siga.model.asesorias;

import pf.siga.model.users.usersBean;
import pf.siga.model.users.usersDao;
import pf.siga.utils.conectionSQL;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class asesoriasDao {
    Connection conn;
    PreparedStatement pstm;
    CallableStatement cstm;
    ResultSet rs;

    public List<Asesorias> findAll() {
        List<Asesorias> Asesorias = new LinkedList<>();
        Asesorias Asesoria = null;
        try {
            conn = new conectionSQL().getConnection();
            String query = "SELECT * FROM asesoriastotales;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Asesoria = new Asesorias();
                Asesoria.setIdAsesorias(rs.getInt("idAsesorias"));
                Asesoria.setTema(rs.getString("tema"));
                Asesoria.setDuda(rs.getString("duda"));
                Asesoria.setTiempo(rs.getInt("tiempo"));
                Asesoria.setProfesor(rs.getString("docente"));
                Asesoria.setFkEstados(rs.getInt("idEstados"));
                Asesoria.setEstados(rs.getString("estado"));
                Asesoria.setMaterias(rs.getString("nombre"));
                Asesoria.setAlumno(rs.getString("alumno"));
                Asesoria.setFkMatricula(rs.getString("FkMatricula"));
                Asesorias.add(Asesoria);
            }
        } catch (SQLException e) {
            Logger.getLogger(asesoriasDao.class.getName())
                    .log(Level.SEVERE, "Error findAll", e);
        } finally {
            closeConnections();
        }
        return Asesorias;
    }

    public List<Asesorias> findAllE(String username) {
        List<Asesorias> Asesorias = new LinkedList<>();
        Asesorias Asesoria = null;
        try {
            conn = new conectionSQL().getConnection();
            String query = "SELECT * FROM asesoriastotales where idEstados = 1 and username = ?;";
            pstm = conn.prepareStatement(query);
            System.out.print(username);
            pstm.setString(1, username);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Asesoria = new Asesorias();
                Asesoria.setIdAsesorias(rs.getInt("idAsesorias"));
                Asesoria.setTema(rs.getString("tema"));
                Asesoria.setDuda(rs.getString("duda"));
                Asesoria.setTiempo(rs.getInt("tiempo"));
                Asesoria.setProfesor(rs.getString("docente"));
                Asesoria.setFkEstados(rs.getInt("idEstados"));
                Asesoria.setEstados(rs.getString("estado"));
                Asesoria.setMaterias(rs.getString("nombre"));
                Asesoria.setAlumno(rs.getString("alumno"));
                Asesoria.setFkMatricula(rs.getString("FkMatricula"));
                Asesorias.add(Asesoria);
            }
        } catch (SQLException e) {
            Logger.getLogger(asesoriasDao.class.getName())
                    .log(Level.SEVERE, "Error findAll", e);
        } finally {
            closeConnections();
        }
        return Asesorias;
    }

    public List<Asesorias> findAllD(String username) {
        List<Asesorias> Asesorias = new LinkedList<>();
        Asesorias Asesoria = null;
        try {
            conn = new conectionSQL().getConnection();
            String query = "SELECT * FROM asesoriastotalesP where idEstados = 1 and visibilidadP = 1"+
            " and username = ?;";
            pstm = conn.prepareStatement(query);
            System.out.print(username);
            pstm.setString(1, username);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Asesoria = new Asesorias();
                Asesoria.setIdAsesorias(rs.getInt("idAsesorias"));
                Asesoria.setTema(rs.getString("tema"));
                Asesoria.setDuda(rs.getString("duda"));
                Asesoria.setTiempo(rs.getInt("tiempo"));
                Asesoria.setProfesor(rs.getString("docente"));
                Asesoria.setFkEstados(rs.getInt("idEstados"));
                Asesoria.setEstados(rs.getString("estado"));
                Asesoria.setMaterias(rs.getString("nombre"));
                Asesoria.setAlumno(rs.getString("alumno"));
                Asesoria.setFkMatricula(rs.getString("FkMatricula"));
                Asesorias.add(Asesoria);
            }
        } catch (SQLException e) {
            Logger.getLogger(asesoriasDao.class.getName())
                    .log(Level.SEVERE, "Error findAll", e);
        } finally {
            closeConnections();
        }
        return Asesorias;
    }

    public Asesorias pase(int estado, int time, int id) {
        try {
            conn = new conectionSQL().getConnection();
            String query = "update Asesorias set FkEstados = ?, tiempo = ?" +
                    " where idAsesorias = ?;"; //AND status = 1
            pstm = conn.prepareStatement(query);
            pstm.setInt(1,estado);
            pstm.setInt(2,time);
            pstm.setInt(3,id);
            rs = pstm.executeQuery();
            return null;
        } catch (SQLException e) {
            Logger.getLogger(usersDao.class.getName())
                    .log(Level.SEVERE, "Error validate method" + e);
            return null;
        } finally {
            closeConnections();
        }
    }

    public Asesorias recha(int id) {
        try {
            conn = new conectionSQL().getConnection();
            String query = "update Asesorias set visibilidadP = 2" +
                    " where idAsesorias = ?;"; //AND status = 1
            pstm = conn.prepareStatement(query);
            pstm.setInt(1,id);
            rs = pstm.executeQuery();
            return null;
        } catch (SQLException e) {
            Logger.getLogger(usersDao.class.getName())
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