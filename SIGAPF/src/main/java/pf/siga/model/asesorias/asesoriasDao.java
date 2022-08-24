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
            String query = "SELECT * FROM asesoriastotales where visibilidadE = 1;";
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

    public List<Asesorias> findND() {
        List<Asesorias> Asesorias = new LinkedList<>();
        Asesorias Asesoria = null;
        try {
            conn = new conectionSQL().getConnection();
            String query = "SELECT * FROM UserDocente;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Asesoria = new Asesorias();
                Asesoria.setUsername(rs.getString("username"));
                Asesoria.setIdUsers(rs.getInt("id_Users"));
                Asesoria.setProfesor(rs.getString("docente"));
                Asesoria.setAlumno(rs.getString("apeDocente"));
                Asesoria.setPermiso(rs.getInt("permiso"));
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

    public Asesorias find(int id) {
        try {
            conn = new conectionSQL().getConnection();
            String query = "SELECT * FROM asesoriastotales where idAsesorias = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                Asesorias Asesoria = new Asesorias();
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
                return Asesoria;
            }
        } catch (SQLException e) {
            Logger.getLogger(asesoriasDao.class.getName())
                    .log(Level.SEVERE, "Error findAll", e);
        } finally {
            closeConnections();
        }
        return null;
    }

    public Asesorias findD(String username) {
        try {
            conn = new conectionSQL().getConnection();
            String query = "SELECT * FROM asesoriastotalesP where "+
                    "username = ?;";
            pstm = conn.prepareStatement(query);
            System.out.print(username);
            pstm.setString(1, username);
            rs = pstm.executeQuery();
            if (rs.next()) {
                Asesorias Asesoria = new Asesorias();
                Asesoria.setIdUsers(rs.getInt("id_Users"));
                Asesoria.setUsername(rs.getString("username"));
                Asesoria.setPass(rs.getString("password"));
                Asesoria.setProfesor(rs.getString("docente"));
                Asesoria.setAlumno(rs.getString("apeDocente"));
                return Asesoria;
            }
        } catch (SQLException e) {
            Logger.getLogger(asesoriasDao.class.getName())
                    .log(Level.SEVERE, "Error findAll", e);
        } finally {
            closeConnections();
        }
        return null;
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
            String query = "SELECT * FROM asesoriastotalesP where idEstados = 1 and visibilidadP = 1 "+
            " and username = ?;";
            pstm = conn.prepareStatement(query);
            System.out.print(username);
            pstm.setString(1, username);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Asesoria = new Asesorias();
                Asesoria.setIdAsesorias(rs.getInt("idAsesorias"));
                Asesoria.setIdUsers(rs.getInt("id_Users"));
                Asesoria.setUsername(rs.getString("username"));
                Asesoria.setPass(rs.getString("password"));
                Asesoria.setTema(rs.getString("tema"));
                Asesoria.setDuda(rs.getString("duda"));
                Asesoria.setTiempo(rs.getInt("tiempo"));
                Asesoria.setProfesor(rs.getString("docente"));
                Asesoria.setFkProfesores(rs.getInt("FkProfesores"));
                Asesoria.setFkProfesores(rs.getInt("FkProfesores"));
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

    public List<Asesorias> histoD(String username) {
        List<Asesorias> Asesorias = new LinkedList<>();
        Asesorias Asesoria = null;
        try {
            conn = new conectionSQL().getConnection();
            String query = "SELECT * FROM asesoriastotalesP where visibilidadP = 1"+
                    " and username = ? and not(FkEstados = 1);;";
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
                Asesoria.setFkProfesores(rs.getInt("FkProfesores"));
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



    public boolean pase(Asesorias add) {
        try {
            conn = new conectionSQL().getConnection();
            String query = "update Asesorias set FkEstados = ?, tiempo = ?" +
                    " where idAsesorias = ?;"; //AND status = 1
            pstm = conn.prepareStatement(query);
            pstm.setInt(1,add.getFkEstados());
            pstm.setInt(2,add.getTiempo());
            pstm.setInt(3,add.getIdAsesorias());
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(usersDao.class.getName())
                    .log(Level.SEVERE, " Error validate method" + e);
            return false;
        } finally {
            closeConnections();
        }
    }

    public boolean permiso(Asesorias add) {
        try {
            conn = new conectionSQL().getConnection();
            String query = "update Users set permiso = ?" +
                    " where id_Users = ?;"; //AND status = 1
            pstm = conn.prepareStatement(query);
            pstm.setInt(1,add.getPermiso());
            System.out.println(add.getIdUsers());
            pstm.setInt(2,add.getIdUsers());
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(usersDao.class.getName())
                    .log(Level.SEVERE, " Error validate method" + e);
            return false;
        } finally {
            closeConnections();
        }
    }

    public Boolean recha(Asesorias rechazar) {
        try {
            conn = new conectionSQL().getConnection();
            String query = "update Asesorias set FkEstados = 5," +
                    "razonCan = ? where idAsesorias = ?;"; //AND status = 1
            pstm = conn.prepareStatement(query);
            pstm.setString(1,rechazar.getRazon());
            pstm.setInt(2,rechazar.getIdAsesorias());
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(usersDao.class.getName())
                    .log(Level.SEVERE, " Error validate method" + e);
            return null;
        } finally {
            closeConnections();
        }
    }

    public Boolean cancelar(Asesorias rechazar) {
        try {
            conn = new conectionSQL().getConnection();
            String query = "update Asesorias set FkEstados = 4," +
                    "razonCan = ? where idAsesorias = ?;"; //AND status = 1
            pstm = conn.prepareStatement(query);
            pstm.setString(1,rechazar.getRazon());
            pstm.setInt(2,rechazar.getIdAsesorias());
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(usersDao.class.getName())
                    .log(Level.SEVERE, " Error validate method" + e);
            return null;
        } finally {
            closeConnections();
        }
    }

    public Boolean delP(int id) {
        try {
            conn = new conectionSQL().getConnection();
            String query = "update Asesorias set visibilidadP = 2 " +
                    "where  FkProfesores = ? and not(FkEstados = 1);"; //AND status = 1
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, id);
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(usersDao.class.getName())
                    .log(Level.SEVERE, " Error validate method" + e);
            return null;
        } finally {
            closeConnections();
        }
    }

    public Boolean delA() {
        try {
            conn = new conectionSQL().getConnection();
            String query = "update Asesorias set visibilidadE = 2;"; //AND status = 1
            pstm = conn.prepareStatement(query);
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(usersDao.class.getName())
                    .log(Level.SEVERE, " Error validate method" + e);
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