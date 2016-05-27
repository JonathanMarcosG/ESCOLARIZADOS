/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import modelos.Constantes;
import beans.FechaRenovar;
import itt.web.conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import mx.edu.ittoluca.logutils.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Jony
 */
public class VerificarDAO {

    public static String period2(String username, String password) throws ParseException {
        String val_per = "0" + "&" + "Convocatoria valida";
        Logger logger = new Logger();
        String resultado_error;
        String descrip_error;

        String fi = "";
        String ff = "";
        String fh = "";

        Connection conn = Conexion.getConnection(username, password, Constantes.NOMBRE_APP, Constantes.NOMBRE_MODULO);
        if (conn != null) {
            //Se genera el bloque try-catch-finally
            try {
                //Objeto callableStatement para llamar el procedimiento.
                CallableStatement call = conn.prepareCall("{call FICHAS.PQ_CHECK_ADMIN_1.CHECK_VIGENCIA_CONVOC_SP(?,?,?,?,?)}");
                //Registro de parámetros de salida.
                call.registerOutParameter("paFechaInicio", oracle.jdbc.OracleTypes.VARCHAR);
                call.registerOutParameter("paFechaFin", oracle.jdbc.OracleTypes.VARCHAR);
                call.registerOutParameter("paFechaActual", oracle.jdbc.OracleTypes.VARCHAR);
                call.registerOutParameter("paCodigoError", oracle.jdbc.OracleTypes.NUMBER);
                call.registerOutParameter("paMjeDescError", oracle.jdbc.OracleTypes.VARCHAR);
                //Ejecución del SP
                call.execute();

                resultado_error = call.getString("paCodigoError");
                descrip_error = call.getString("paMjeDescError");
                System.out.println("Resultado de error: " + resultado_error);
                System.out.println("Descripcion de error: " + descrip_error);
                if ("0".equals(resultado_error)) {
                    fi = call.getString("paFechaInicio");
                    ff = call.getString("paFechaFin");
                    fh = call.getString("paFechaActual");

                    //cambios para pruebas
                    //fi = "10/08/2015";
//                ff = "31/04/2016";
                    //fh = "10/08/2015";
                    if (fi == null || ff == null || ff == null) {
                        val_per = "1 & No hay fechas disponibles para la convocatoria";
                    } else {
                        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
                        Date fechah = formateador.parse(fh);
                        Date fechai = formateador.parse(fi);
                        Date fechaf = formateador.parse(ff);

                        if (fechah.equals(fechai) || fechah.equals(fechaf)) {

                            val_per = "0 & Convocatoria valida";
                        }
                        if (fechah.before(fechaf) && fechah.after(fechai)) {

                            val_per = "0 & Convocatoria valida";
                        }
                        if (fechah.after(fechaf) || fechah.before(fechai)) {
                            val_per = "1 & Aún no se llega a un periodo válido de convocatoria";
                        }
                    }
                    call.close();
                    return val_per;
                } else {
                    //"Error al momento de obtener la convocatoria para el periodo y año actual"
                    String logMessage = resultado_error + "->" + descrip_error;
                    logger.registrarError(Logger.GRAVE, logMessage, Constantes.NOMBRE_APP, Constantes.NOMBRE_MODULO, username);
                    call.close();
                    return resultado_error + "&" + descrip_error;
                }
            } catch (SQLException ex) {
                //Loggeo del error.
                logger.registrarErrorSQL(ex, Constantes.NOMBRE_APP, Constantes.NOMBRE_MODULO, username);
                val_per = "1" + "&" + logger.getMensajeError();
                //Gestión de la respuesta para el usuario.
                //Se obtiene la traducción del error con: logger.getMensajeError();

            } finally {
                //El bloque finally es importante pues aquí se garantiza que no se dejen conexiones abiertas.
                Conexion.cerrarConexion(conn);
            }
        } else {
            //Sólo se gestiona la respuesta que se dará al usuario, la librería ya loguea los errores al crear la conexión.
            //El error traducido está en Conexion.getConnectionErrorMessage();
//            val_per = "1" + "&" + "Error al momento de obtener la convocatoria para el periodo y año actual";
            val_per = "1" + "&" + Conexion.getConnectionErrorMessage();
        }
        return val_per;
    }

    public static ArrayList<FechaRenovar> getPeriodoRenovacion(String username, String password) {
        Logger logger = new Logger();
        String resultado_error;
        String descrip_error;
        ArrayList<FechaRenovar> fechaList = new ArrayList();
        FechaRenovar fecha = new FechaRenovar();
        Connection conn = Conexion.getConnection(username, password, Constantes.NOMBRE_APP, Constantes.NOMBRE_MODULO);

        if (conn != null) {
            //Se genera el bloque try-catch-finally
            try {
                //Objeto callableStatement para llamar el procedimiento.
                CallableStatement call = conn.prepareCall("{call FICHAS.PQ_CHECK_ASPIRANTE_2.CHECK_PERIODO_RENOVAR_SP(?,?,?,?)}");
                //Registro de parámetros de salida.
                call.registerOutParameter("paFechaIniRenov", oracle.jdbc.driver.OracleTypes.VARCHAR);
                call.registerOutParameter("paFechaFinRenov", oracle.jdbc.driver.OracleTypes.VARCHAR);
                call.registerOutParameter("paCodigoError", oracle.jdbc.driver.OracleTypes.NUMBER);
                call.registerOutParameter("paMjeDescError", oracle.jdbc.driver.OracleTypes.VARCHAR);
                //Ejecución del SP
                call.execute();

                resultado_error = call.getString("paCodigoError");
                descrip_error = call.getString("paMjeDescError");

                if ("0".equals(resultado_error)) {
                    fecha.setFechaIni(call.getString("paFechaIniRenov"));
                    fecha.setFechaFin(call.getString("paFechaFinRenov"));
                    fecha.setCodError(call.getInt("paCodigoError"));
                    fecha.setDescError(call.getString("paMjeDescError"));

                } else {
                    //"Error al momento de obtener el periodo de renovación de referencia"
                    String logMessage = resultado_error + "->" + descrip_error;
                    logger.registrarError(Logger.GRAVE, logMessage, Constantes.NOMBRE_APP, Constantes.NOMBRE_MODULO, username);
                    fecha.setFechaIni(call.getString("paFechaIniRenov"));
                    fecha.setFechaFin(call.getString("paFechaFinRenov"));
                    fecha.setCodError(call.getInt("paCodigoError"));
                    fecha.setDescError(call.getString("paMjeDescError"));
                }
                fechaList.add(fecha);

                call.close();
            } catch (SQLException ex) {
                //Loggeo del error.
                logger.registrarErrorSQL(ex, Constantes.NOMBRE_APP, Constantes.NOMBRE_MODULO, username);
                descrip_error = logger.getMensajeError();
                fecha.setCodError(1);
                fecha.setDescError(descrip_error);
                fecha.setFechaFin("");
                fecha.setFechaIni("");
                fechaList.add(fecha);
                //Gestión de la respuesta para el usuario.
                //Se obtiene la traducción del error con: logger.getMensajeError();
            } finally {
                //El bloque finally es importante pues aquí se garantiza que no se dejen conexiones abiertas.
                Conexion.cerrarConexion(conn);
            }
        } else {
            fecha.setCodError(1);
            fecha.setDescError(Conexion.getConnectionErrorMessage());
            fecha.setFechaFin("");
            fecha.setFechaIni("");
            fechaList.add(fecha);
        }
        return fechaList;
    }

    public static String getValidoRenovar(String username, String password, String paCurpAsp) {
        int retorno1 = -1;
        String ret = "";
        int resultado_error = 0;
        String descrip_error;
        int validoRenov = -1;
        Logger logger = new Logger();
        Connection conn = Conexion.getConnection(username, password, Constantes.NOMBRE_APP, Constantes.NOMBRE_MODULO);

        if (conn != null) {
            //Se genera el bloque try-catch-finally
            try {
                //Objeto callableStatement para llamar el procedimiento.
                CallableStatement call = conn.prepareCall("{call FICHAS.PQ_CHECK_ASPIRANTE_2.CHECK_VALIDA_RENOVACION_SP(?,?,?,?)}");
                //Registro de parámetros de salida.
                call.setString("paCurpAspirante", paCurpAsp);
                call.registerOutParameter("paValidoRenovar", oracle.jdbc.driver.OracleTypes.NUMBER);
                call.registerOutParameter("paCodigoError", oracle.jdbc.driver.OracleTypes.NUMBER);
                call.registerOutParameter("paMjeDescError", oracle.jdbc.driver.OracleTypes.VARCHAR);
                //Ejecución del SP
                call.execute();
                resultado_error = call.getInt("paCodigoError");
                descrip_error = call.getString("paMjeDescError");

                if (resultado_error == 0) {
                    validoRenov = call.getInt("paValidoRenovar");
                    switch (resultado_error) {
                        case 0:
                            //No ocurrio error alguno
                            //Verificamos si es valido renovar
                            retorno1 = (validoRenov == 0) ? 0 : 1;
                            ret = retorno1 + "&" + descrip_error;
                            break;
                        case 2:
                            ret = resultado_error + "&" + descrip_error;
                            break;
                        case 3:
                            //No es valido renovar por que ya no hay prefichas disponibles
                            retorno1 = 1;
                            ret = retorno1 + "&" + descrip_error;
                            break;
                        case 101:
                            retorno1 = 101;
                            ret = retorno1 + "&" + descrip_error;
                            break;
                        case 102:
                            retorno1 = 102;
                            ret = retorno1 + "&" + descrip_error;
                            break;
                        case 103:
                            retorno1 = 103;
                            ret = retorno1 + "&" + descrip_error;
                            break;
                        default:
                            retorno1 = 1;
                            ret = retorno1 + "&" + descrip_error;
                            break;

                    }
                } else {
                    //"Error al momento de validar la CURP del aspirante para renovar su referencia bancaria.";
                    String logMessage = resultado_error + "->" + descrip_error;
                    logger.registrarError(Logger.GRAVE, logMessage, Constantes.NOMBRE_APP, Constantes.NOMBRE_MODULO, username);
                    ret = resultado_error + "&" + descrip_error;
                }
                call.close();

            } catch (SQLException ex) {
                //Loggeo del error.
                logger.registrarErrorSQL(ex, Constantes.NOMBRE_APP, Constantes.NOMBRE_MODULO, username);
                ret="2"+"&"+logger.getMensajeError();
                //Gestión de la respuesta para el usuario.
                //Se obtiene la traducción del error con: logger.getMensajeError();

            } finally {
                //El bloque finally es importante pues aquí se garantiza que no se dejen conexiones abiertas.
                Conexion.cerrarConexion(conn);
            }
        } else {
            //Sólo se gestiona la respuesta que se dará al usuario, la librería ya loguea los errores al crear la conexión.
            //El error traducido está en Conexion.getConnectionErrorMessage();
            ret = "1" + "&" + Conexion.getConnectionErrorMessage();
        }
        return ret;
    }

    public static String getCupo(String username, String password) {
        String ret = "";
        Logger logger = new Logger();
        Connection conn = Conexion.getConnection(username, password, Constantes.NOMBRE_APP, Constantes.NOMBRE_MODULO);
        if (conn != null) {
            //Se genera el bloque try-catch-finally
            try {
                int resultado_error;
                String descrip_error;
                Integer cuenta_fichas;
                //Objeto callableStatement para llamar el procedimiento.
                CallableStatement call = conn.prepareCall("{call FICHAS.PQ_CHECK_ASPIRANTE_1.CHECK_CANTIDAD_PREFICHAS_SP(?,?,?)}");
                //Registro de parámetros de salida.
                call.registerOutParameter("paCuentaFichas", OracleTypes.NUMBER);
                call.registerOutParameter("paCodigoError", OracleTypes.VARCHAR);
                call.registerOutParameter("paMjeDescError", OracleTypes.VARCHAR);
                //Ejecución del SP
                call.execute();

                resultado_error = call.getInt("paCodigoError");
                descrip_error = call.getString("paMjeDescError");
                cuenta_fichas = call.getInt("paCuentaFichas");
                if (resultado_error == 0) {
                    ret = String.valueOf(cuenta_fichas) + "&" + "Ficha(s) disponobles";
                    call.close();
                } else {
                    //"Sucedio un error al trattar de obtener la cuenta de fichas disponibles"
                    String logMessage = resultado_error + "->" + descrip_error;
                    logger.registrarError(Logger.GRAVE, logMessage, Constantes.NOMBRE_APP, Constantes.NOMBRE_MODULO, username);
                    call.close();
                    return "-100" + "&" + descrip_error;
                }
            } catch (SQLException ex) {
                //Loggeo del error.
                logger.registrarErrorSQL(ex, Constantes.NOMBRE_APP, Constantes.NOMBRE_MODULO, username);
                ret = "-10" + "&" + logger.getMensajeError();
                //Gestión de la respuesta para el usuario.
                //Se obtiene la traducción del error con: logger.getMensajeError();

            } finally {
                //El bloque finally es importante pues aquí se garantiza que no se dejen conexiones abiertas.
                Conexion.cerrarConexion(conn);
            }
        } else {
            //Sólo se gestiona la respuesta que se dará al usuario, la librería ya loguea los errores al crear la conexión.
            //El error traducido está en Conexion.getConnectionErrorMessage();
            ret = "-10" + "&" + Conexion.getConnectionErrorMessage();
        }
        return ret;
    }
}
