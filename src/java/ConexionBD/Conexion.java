/*
 * Método para la conexión con la BD
 */
package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import modelos.GeneraAuditoria;

/**
 *
 * @author ElyyzZ BaRruEtA
 */
public class Conexion {

    public static String ERROR = "";
    private String user = Constantes.BD_NAME;
    private String pass = Constantes.BD_PASS;
    private String BaseDeDatos = "jdbc:oracle:thin:@192.168.40.103:1521:SIA";

    Connection conexion;

    /**
     * Metodo que permite la conexión con la base de datos mediante la libreria
     * ojdbc14 para la version 8 de Oracle
     *
     * @param usuario recibe el usuario de la base de datos
     * @param password recibe el password de la base de datos
     */
    public Conexion(String usuario, String password) {
        this.pass = password;
        this.user = usuario;
    }

    public Conexion() {
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        conexion = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            try {
                conexion = DriverManager.getConnection(BaseDeDatos, user, pass);
            } catch (SQLException ex) {
                GeneraAuditoria audit = new GeneraAuditoria();
            audit.crea_archivo("Error base de datos", "Error al intentar establecer conexion con la base de datos", ex.getMessage());
            } finally {
                return conexion;
            }
        } catch (ClassNotFoundException ex) {
            GeneraAuditoria audit = new GeneraAuditoria();
            audit.crea_archivo("Error base de datos", "Error al intentar establecer conexion con la base de datos", ex.getMessage());
            conexion = null;
        } finally {
            return conexion;
        }
    }

    public void CerraConexion() throws SQLException {
        conexion.close();
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Conexion c = new Conexion();
        c.getConnection();

    }

}
