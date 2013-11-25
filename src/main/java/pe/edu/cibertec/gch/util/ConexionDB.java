package pe.edu.cibertec.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Utilitario para conectarse a una base de datos por JDBC
 */
public class ConexionDB {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection crearConexion() {
        try {
            String url = "jdbc:mysql://localhost:3306/gch";
            String usr = "root";
            String pwd = "mysql";
            Connection conexion = 
                    DriverManager.getConnection(url, usr, pwd);
            return conexion;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void cerrarConexion(Connection conexion){
        try {
            if(conexion != null) { conexion.close(); }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
