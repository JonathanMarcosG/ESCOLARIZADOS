/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import modelos.Constantes;
import beans.PrefichaModel;
import itt.web.conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.GeneraAuditoria;
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
     * @return int 0 : El aspirante no se ha registrado. >0 : El aspirante ya
     * realizo su registro. -1 : Ocurrio un error al obtener año y periodo
     * consulte a su administrador.
     */
    public static int GetValidaCurp(String username, String password, String curp, String correo) {
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
     * CHECK_CORREO_CLIGA_SP recibe liga y correo encriptados
     *
     * @param username
     * @param password
     * @param correo: correo ingresado por aspirante
     * @param liga: correo de aspirante encriptado
     * @return int 0 No tenemos registro de ese correo y aun se tienen fichas
     * disponibles 1 Ya existe registro con ese correo 2 Ocurrio un error al
     * generar la liga 3 No tenemos registro de ese correo y NO se tienen fichas
     * disponibles 6 Ocurrio un error al revisar las fichas
     */
    public static String GetValidaCorreo(String username, String password, String correo, String liga) {
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

    public static PrefichaModel recuperaPreficha(String username, String password, String curp) {
        PrefichaModel prefichaTmp = new PrefichaModel();
        Logger logger = new Logger();
        Connection conn = Conexion.getConnection(username, password, Constantes.NOMBRE_APP, Constantes.NOMBRE_MODULO);
        if (conn != null) {
            //Se genera el bloque try-catch-finally
            try {
                String resultado_error;
                String nombrebd;

                CallableStatement call = conn.prepareCall("{call FICHAS.PQ_GET_ASPIRANTE_2.GET_RECUPERAR_PREFICHA_ASP_SP(?,?,?,?)}");
                call.setString("paCurpAspirante", curp);
                call.registerOutParameter("paCurRetorno", OracleTypes.CURSOR);
                call.registerOutParameter("paCodigoError", OracleTypes.NUMBER);
                call.registerOutParameter("paMjeDescError", OracleTypes.VARCHAR);
                call.execute();
                resultado_error = call.getString("paCodigoError");

                if ("0".equals(resultado_error)) {
                    ResultSet rset = (ResultSet) call.getObject("paCurRetorno");
                    while (rset.next()) {
                        nombrebd = rset.getString("NOMBRE");
                        if ("".equals(nombrebd) || nombrebd == null) {
                            prefichaTmp.setExiste(0);
                        } else {

                            String appat = rset.getObject("APELLIDO_PAT").toString();
                            String apmat = rset.getObject("APELLIDO_MAT").toString();
                            String date_exp_ref = rset.getString("FECHA_EXPIRA_REF");

                            prefichaTmp.setNombrebd(rset.getObject("NOMBRE").toString());
                            prefichaTmp.setApellidosbd(appat + " " + apmat);
                            prefichaTmp.setCarrerabd(rset.getObject("NOMBRE_CARRERA").toString());
                            prefichaTmp.setPrefichabd(rset.getObject("PREFICHA").toString());
                            prefichaTmp.setPeriodobd(rset.getObject("PERIODO_CONSURSA").toString());
                            prefichaTmp.setModalidadbd(rset.getObject("MODALIDAD").toString());
                            prefichaTmp.setRef_bancaria(rset.getObject(11).toString());
                            prefichaTmp.setImporte_bd(rset.getObject("IMPORTE").toString());
                            //prefichaTmp.set(rset.getObject("FECHA_EMISION").toString());
                            prefichaTmp.setFechapdf(rset.getObject("FECHA_ACTUAL").toString());

                            //Revisamos si el aspirate tiene fecha de expriacion de referecia:
                            // Si la fecha no viene valida, ponemos 'No asignada'
                            // Si la fecha es valida, simplemente la asignamos.
                            prefichaTmp.setFecha_limite_pago((date_exp_ref == null || "".equals(date_exp_ref)) ? "No asignada" : date_exp_ref);
//                        fechalim = rset.getObject("FECHA_LIMITE_PAGO").toString();

                            prefichaTmp.setCurpbd(curp);
                            prefichaTmp.setExiste(1);
                        }
                    }
                    call.close();
                } else {
                    GeneraAuditoria ob = new GeneraAuditoria();
                    ob.crea_archivo(resultado_error, "No se logró crear la preficha", "Error al generar la Preficha.");

                }
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
        return prefichaTmp;
    }
}
