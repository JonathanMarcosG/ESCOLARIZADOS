/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexionBD.Constantes;
import itt.web.conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import mx.edu.ittoluca.logutils.Logger;
import oracle.jdbc.driver.OracleTypes;

/**
 *
 * @author Jony
 */
public class ValidacionesDAO {

    /**
     * 
     * @param username: 
     * @param password:
     * @param curp: curp ingresado por aspirante 
     * @param correo: correo ingresado por aspirante
     * @return int
     *  0  : El aspirante no se ha registrado.
     *  >0 : El aspirante ya realizo su registro.
     *  -1 : Ocurrio un error al obtener año y periodo consulte
            a su administrador.
     */
    public static int GetValidaCurp(String username, String password,String curp, String correo) {
        int retorna = 0;
        Logger logger = new Logger();
        Connection conn = Conexion.getConnection(username, password, Constantes.NOMBRE_APP, Constantes.NOMBRE_MODULO);

        if (conn != null) {
            //Se genera el bloque try-catch-finally
            try {
                //Objeto callableStatement para llamar el procedimiento.
                CallableStatement call = conn.prepareCall("{?=call FICHAS.PQ_CHECK_ASPIRANTE_1.CHECK_EXIST_REG_ASP_FN(?,?)}");
                //Registro de parámetros de entrada
                call.setString(2, curp);
                call.setString(3, correo);
                call.registerOutParameter(1, OracleTypes.NUMBER);
                //Ejecución del SP
                call.execute();
                retorna = call.getInt(1);
                call.close();
            } catch (SQLException ex) {
                //Loggeo del error.
                logger.registrarErrorSQL(ex, Constantes.NOMBRE_APP, Constantes.NOMBRE_MODULO, username);
                //Gestión de la respuesta para el usuario.
                //Se obtiene la traducción del error con: logger.getMensajeError();

            } finally {
                //El bloque finally es importante pues aquí se garantiza que no se dejen conexiones abiertas.
                Conexion.cerrarConexion(conn);
            }
        } else {
            //Sólo se gestiona la respuesta que se dará al usuario, la librería ya loguea los errores al crear la conexión.
            //El error traducido está en Conexion.getConnectionErrorMessage();
        }
        return retorna;
    }
    
    /**
     * CHECK_CORREO_CLIGA_SP  recibe  liga y  correo  encriptados
     * @param username
     * @param password
     * @param correo: correo ingresado por aspirante
     * @param liga: correo de aspirante encriptado
     * @return int
     * 0 No tenemos registro de ese correo y aun se tienen fichas disponibles
     * 1 Ya existe registro con ese correo
     * 2 Ocurrio un error al generar la liga
     * 3 No tenemos registro de ese correo y NO se tienen fichas disponibles
     * 6 Ocurrio un error al revisar las fichas
     */
    public static String GetValidaCorreo(String username, String password,String correo, String liga){
        String existe = "23";
        String existeDesc = "No error description";
        Logger logger = new Logger();
        Connection conn = Conexion.getConnection(username, password, Constantes.NOMBRE_APP, Constantes.NOMBRE_MODULO);
        if (conn != null) {
            //Se genera el bloque try-catch-finally
            try {
                //Objeto callableStatement para llamar el procedimiento.
                CallableStatement call = conn.prepareCall("{call FICHAS.PQ_CHECK_ASPIRANTE_1.CHECK_CORREO_CLIGA_SP(?,?,?,?,?)}");
                //Registro de parámetros de entrada
                call.setString("paCorreo", correo);
                call.setString("paToken", liga);   
                //Registro de parámetros de salida.
                call.registerOutParameter("paRespuesta", OracleTypes.NUMBER);
                call.registerOutParameter("paCodigoError", OracleTypes.NUMBER);
                call.registerOutParameter("paMjeDescError", OracleTypes.VARCHAR);
                //Ejecución del SP
                call.execute();
                int tmp = call.getInt("paRespuesta");
                existe = String.valueOf(tmp);
                existeDesc = call.getString("paMjeDescError");
                call.close();
            } catch (SQLException ex) {
                //Loggeo del error.
                logger.registrarErrorSQL(ex, Constantes.NOMBRE_APP, Constantes.NOMBRE_MODULO, username);
                //Gestión de la respuesta para el usuario.
                //Se obtiene la traducción del error con: logger.getMensajeError();

            } finally {
                //El bloque finally es importante pues aquí se garantiza que no se dejen conexiones abiertas.
                Conexion.cerrarConexion(conn);
            }
        } else {
            //Sólo se gestiona la respuesta que se dará al usuario, la librería ya loguea los errores al crear la conexión.
            //El error traducido está en Conexion.getConnectionErrorMessage();
        }
        return existe + "&" + existeDesc;
    }
}
