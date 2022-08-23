package pf.siga.utils;

import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

public class conectionSQL {
    public Connection getConnection() {


        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","usuario-docker-bd","contraseña-docker-bd");
        } catch (SQLException e) {
            System.out.println(this.getClass().getCanonicalName() +
                    "->" + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        Connection conn = new conectionSQL().getConnection();
        if (conn != null) {
            try {
                System.out.println("Conexión realizada");
                conn.close();
            } catch (SQLException e) {

            }
        } else {
            System.out.println("Conexión fallida");
        }
    }
}