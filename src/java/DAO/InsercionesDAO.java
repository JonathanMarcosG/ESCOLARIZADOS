/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import modelos.Constantes;
import beans.ContactoEmeAsp;
import beans.DomicilioAspirante;
import beans.EscProcedenciaAsp;
import beans.PersonalesAspirante;
import beans.SocioeconomicosAsp;
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
public class InsercionesDAO {

    public static String InsertaDatosGeneral(String username, String password, SocioeconomicosAsp AspSocioecono,
            ContactoEmeAsp contacto, PersonalesAspirante aspirante,
            DomicilioAspirante AspDomicilio, EscProcedenciaAsp AspEscuela) {
        int resultado = 0;
        String error = "";
        Logger logger = new Logger();
        Connection conn = Conexion.getConnection(username, password, Constantes.NOMBRE_APP, Constantes.NOMBRE_MODULO);
        if (conn != null) {
            //Se genera el bloque try-catch-finally
            try ( //Objeto callableStatement para llamar el procedimiento.
                    CallableStatement call = conn.prepareCall(" {call FICHAS.PQ_INSERT_ASPIRANTE_3.SET_INSERCION_GENERAL_ASP_SP(?,?,?,?,?,?,?,?,?,?,"
                            + "?,?,?,?,?,?,?,?,?,?,?,"
                            + "?,?,?,?,?,?,?,?,?,?,"
                            + "?,?,?,?,?,?,?,?,?,?,"
                            + "?,?,?,?,?,?,?,?,?,?,"
                            + "?,?,?,?,?,?,?,?,?,?,"
                            + "?,?,?,?,?,?,?)}")) {
                //personales
                call.setString("paCurp", aspirante.getCurp());
                call.setString("paNombre", aspirante.getNombre());
                call.setString("paApellidoPat", aspirante.getAppat());
                call.setString("paApellidoMat", aspirante.getApmat());
                call.setString("paFechaDeNacimiento", aspirante.getFechaNac());
                call.setString("paPaisNacimiento", aspirante.getPaisNac());
                if (!"null".equals(aspirante.getEdoNac())) {
                    call.setInt("paEstadoNacimiento", Integer.parseInt(aspirante.getEdoNac().trim()));
                    call.setInt("paMunicipioNac", Integer.parseInt(aspirante.getMpioNac().trim()));
                    call.setInt("paLocalidadNac", Integer.parseInt(aspirante.getLocNac().trim()));
                } else {
                    call.setString("paEstadoNacimiento", "");
                    call.setString("paMunicipioNac", "");
                    call.setString("paLocalidadNac", "");
                }
                call.setString("paSexo", String.valueOf(aspirante.getSexo()));
                call.setString("paEdoCivil", aspirante.getEdoCivil());
                call.setString("paTipoSangre", aspirante.getTipoSangre());
                call.setString("paCapDiferente", aspirante.getCapacidadDif());
                call.setString("paCursoProp", String.valueOf(aspirante.getCurso().charAt(0)));
                call.setString("paCorreo", aspirante.getCorreo());

                //domicilio
                call.setInt("paEstadoViveActual", Integer.parseInt(AspDomicilio.getEstadoVive().trim()));
                call.setInt("paMunicipioVive", Integer.parseInt(AspDomicilio.getMunicipioVive().trim()));
                call.setInt("paLocalidadVive", Integer.parseInt(AspDomicilio.getLocalidadVive().trim()));
                call.setString("paCalleAsp", AspDomicilio.getCalleVive());
                if (!"".equals(AspDomicilio.getNumInt().trim()) && !"null".equals(AspDomicilio.getNumInt().trim())) {
                    call.setInt("paNoInterior", Integer.parseInt(AspDomicilio.getNumInt().trim()));
                } else {
                    call.setString("paNoInterior", "");
                }
                call.setInt("paNoExterior", Integer.parseInt(AspDomicilio.getNumExt().trim()));
                call.setString("paColoniaPob", AspDomicilio.getColoniaVive());
                call.setInt("paCodPost", Integer.parseInt(AspDomicilio.getCodPostal().trim()));
                call.setString("paTelFijo", AspDomicilio.getTelFijo());
                call.setString("paTelCel", AspDomicilio.getTelCelular());

                // Carrera
                call.setInt("paCarreraOp1", aspirante.getCarrOp1());
                call.setInt("paCarreraOp2", aspirante.getCarrOp2());
                call.setInt("paCarreraOp3", aspirante.getCarrOp3());
                //Escuela de procedencia
                call.setString("paEscuela", AspEscuela.getEscuela());
                call.setString("paClaveEscuela", AspEscuela.getClaveEsc());
                call.setString("paTipoEscuela", AspEscuela.getTipoEsc());
                call.setInt("paMesIniEsc", Integer.parseInt(AspEscuela.getMesInicio().trim()));
                call.setInt("paMesFinEsc", Integer.parseInt(AspEscuela.getMesFin().trim()));
                call.setInt("paAñoIniEsc", Integer.parseInt(AspEscuela.getAnioInicio().trim()));
                call.setInt("paAñoFinEsc", Integer.parseInt(AspEscuela.getAnioFin().trim()));
                call.setInt("paPromedio", Integer.parseInt(AspEscuela.getPromedio().trim()));
                //socioeconomicos
                call.setString("paNombrePadre", AspSocioecono.getNomPadre());
                call.setString("paVivePadre", AspSocioecono.getVivePadre());
                call.setInt("paOcupacionPadre", Integer.parseInt(AspSocioecono.getOcuPadre().trim()));
                call.setInt("paEstudiosPadre", Integer.parseInt(AspSocioecono.getNivEstPadre().trim()));
                call.setString("paNombreMadre", AspSocioecono.getNomMadre());
                call.setString("paViveMadre", AspSocioecono.getViveMadre());
                call.setInt("paOcupacionMadre", Integer.parseInt(AspSocioecono.getOcuMadre().trim()));
                call.setInt("paEstudiosMadre", Integer.parseInt(AspSocioecono.getNivEstMadre().trim()));
                call.setString("paViveCon", AspSocioecono.getViveCon());
                call.setString("paDependEcon", AspSocioecono.getDepenEcon());
                call.setString("paIngresosTot", AspSocioecono.getIngreTot());
                call.setString("paTipoDeCasa", AspSocioecono.getTipoCasa());
                call.setString("paCuartosCasa", AspSocioecono.getCuartosCasa());
                call.setInt("paNumPerDepEcon", Integer.parseInt(AspSocioecono.getNumPerEcono().trim()));
                call.setInt("paPersonasVCasa", Integer.parseInt(AspSocioecono.getPerViveCasa().trim()));
                call.setString("paPrgOportunid", AspSocioecono.getOportunidades());
                call.setString("paZonaProced", AspSocioecono.getZonaProced());
                call.setString("paTipoBeca", AspSocioecono.getTipoBeca());
                //contacto
                call.setString("paNombreContacto", contacto.getNomContacto());
                call.setInt("paEstado", contacto.getEstado());
                call.setInt("paMunicipioFk", contacto.getMunicipio());
                call.setString("paColonia", contacto.getColonia());
                call.setString("paCalle", contacto.getCalle());
                if (!"null".equals(contacto.getNumInt().trim())) {
                    call.setInt("paNo_Interior", Integer.parseInt(contacto.getNumInt().trim()));
                } else {
                    call.setString("paNo_Interior", "");
                }
                call.setInt("paNo_Exterior", contacto.getNumExt());
                call.setInt("paCodigoPostal", Integer.parseInt(contacto.getCodPostal().trim()));
                call.setString("paTel_Fijo", contacto.getTelFijo());
                call.setString("paTel_Cel", contacto.getTelCelular());
                call.setString("paCentroTrabajo", contacto.getCentroTrab());
                call.setString("paTel_Centro_Trab", contacto.getTelTrab());
                call.setString("paTel_Centro_Trab", contacto.getTelTrab());

                call.registerOutParameter("paCodigoError", OracleTypes.NUMBER);
                call.registerOutParameter("paMjeDescError", OracleTypes.VARCHAR);
                call.execute();
                resultado = call.getInt("paCodigoError");
                error = call.getString("paMjeDescError");
                call.close();
            } catch (SQLException ex) {
                //Loggeo del error.
                logger.registrarErrorSQL(ex, Constantes.NOMBRE_APP, Constantes.NOMBRE_MODULO, username);
                resultado=2;
                error=logger.getMensajeError();
                //Gestión de la respuesta para el usuario.
                //Se obtiene la traducción del error con: logger.getMensajeError();

            } finally {
                //El bloque finally es importante pues aquí se garantiza que no se dejen conexiones abiertas.
                Conexion.cerrarConexion(conn);
            }
        } else {
            //Sólo se gestiona la respuesta que se dará al usuario, la librería ya loguea los errores al crear la conexión.
            //El error traducido está en Conexion.getConnectionErrorMessage();
            resultado=2;
            error=Conexion.getConnectionErrorMessage();
        }
        return resultado + "&" + error;
    }
}
