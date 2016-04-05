
package ConexionBD;

import beans.BaseDatos;
import beans.ClaveCCT;
import beans.FechaRenovar;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.driver.OracleTypes;

/**
 *
 * @author ElyyzZ BaRruEtA
 */
public class Procedimientos {

    BaseDatos bd;
    CallableStatement cs = null;
    ResultSet rs;
    Conexion con = new Conexion();
    String result = "";
    int msgCodeError = -1;
    String msgDescError = "";
    
//Método que regresa en un arreglo de objetos(ArrayList) el contenido de los catálogos de la B.D.
//Parámetros de Entrada:opc--Corresponde a la opción del catálogo que se desea consultar
                      //pk---Corresponde a la llave foránea para realizar la condición en la consulta.
//Parámetros de Salida: Estados--Regresa un ArrayList con el contenido de la consulta.
    public List<BaseDatos> getCatalogos(int opc, int pk) throws SQLException, ClassNotFoundException {
        List<BaseDatos> Estados;
        Estados = new ArrayList<>();
        try {
            cs = con.getConnection().prepareCall("{call FICHAS.CATALOGOS_ASPIRANTES_PQ.GET_CATALOGO_SP(?,?,?,?,?)}");
            cs.setInt("paOpcionCatalogo", opc);
            cs.setInt("paFiltroFk", pk);
            cs.registerOutParameter("paCurRetorno", OracleTypes.CURSOR);
            cs.registerOutParameter("paCodError", OracleTypes.NUMBER);
            cs.registerOutParameter("paDescError", OracleTypes.VARCHAR);
            cs.execute();
            result = cs.getString("paCodError");
            rs = (ResultSet) cs.getObject("paCurRetorno");
            if(opc==11||opc==17||opc==15){
            while (rs.next()) {
                bd = new BaseDatos();
                bd.setNombre(rs.getObject(1).toString());
                Estados.add(bd);
            }
            }else{
            while (rs.next()) {
                bd = new BaseDatos();
                bd.setClave(rs.getObject(1).toString());
                bd.setNombre(rs.getObject(2).toString());
                Estados.add(bd);
            }
            }
            cs.close();
        } catch (SQLException e) {
        } finally {
            con.CerraConexion();
        }
        return Estados;
    }

//Método que regresa en un arreglo de objetos(ArrayList) el contenido de los catálogos de la B.D.
//Parámetros de Entrada:
                      //pk---Corresponde a la llave foránea para realizar la condición en la consulta.
//Parámetros de Salida: Clave--Regresa un ArrayList con el contenido de la consulta.
 
    public List<ClaveCCT> getClaveCCT(int pk) throws SQLException, ClassNotFoundException {
        ClaveCCT cla;
        List<ClaveCCT> Clave;
        Clave = new ArrayList<>();
        try {
            cs = con.getConnection().prepareCall("{call FICHAS.CATALOGOS_ASPIRANTES_PQ.GET_CATALOGO_SP(?,?,?,?,?)}");
            cs.setInt("paOpcionCatalogo", 7);//pasar  atributos  para  where o insertar 
            cs.setInt("paFiltroFk", pk);
            cs.registerOutParameter("paCurRetorno", OracleTypes.CURSOR);//tomas  parametro de salida de  la  base de datos           
            cs.registerOutParameter("paCodError", OracleTypes.NUMBER);
            cs.registerOutParameter("paDescError", OracleTypes.VARCHAR);
            cs.execute();
            result = cs.getString("paCodError");//#error
            rs = (ResultSet) cs.getObject("paCurRetorno");
            //CONVERTIR EL  CURSOR  A  UN ARRAY LIST
            while (rs.next()) {
                cla = new ClaveCCT();
                cla.setClave(rs.getObject(1).toString());
                cla.setCentroEducativo(rs.getObject(2).toString());
                cla.setTurno(rs.getObject(3).toString());
                cla.setDomicilio(rs.getObject(4).toString());
                Clave.add(cla);
            }
            cs.close();

        } catch (SQLException e) {
            con.getConnection().close();
        } finally {
            con.CerraConexion();
        }
        return Clave;
    }
//FICHAS.PQ_CHECK_ASPIRANTE_1 recibe   curp ****LLamando  funciones*** 
    //retorna  
    // numbern 

    public int GetValidaCurp(String curp, String correo) {
        int retorna = 0;
        try {
            List<BaseDatos> Estados;
            Estados = new ArrayList<>();
            cs = con.getConnection().prepareCall("{?=call FICHAS.PQ_CHECK_ASPIRANTE_1.CHECK_EXIST_REG_ASP_FN(?,?)}");
            cs.setString(2, curp);
            cs.setString(3, correo);
            cs.registerOutParameter(1, OracleTypes.NUMBER);
            cs.execute();
            retorna = cs.getInt(1);
            cs.close();
            con.CerraConexion();

        } catch (SQLException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.CerraConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retorna;
    }

    /** 
     * CHECK_CORREO_CLIGA_SP  recibe  liga y  correo  encriptados
     * @param correo: correo ingresado por aspirante
     * @param liga: correo de aspirante encriptado
     * @return int
     * 0 No tenemos registro de ese correo y aun se tienen fichas disponibles
     * 1 Ya existe registro con ese correo
     * 2 Ocurrio un error al generar la liga
     * 3 No tenemos registro de ese correo y NO se tienen fichas disponibles
     * 6 Ocurrio un error al revisar las fichas
     * @throws java.sql.SQLException
     */
    public String GetValidaCorreo(String correo, String liga) throws SQLException {
        String existe = "23";
        String existeDes = "No error description";
        try {
            List<BaseDatos> Estados;
            Estados = new ArrayList<>();
            cs = con.getConnection().prepareCall("{call FICHAS.PQ_CHECK_ASPIRANTE_1.CHECK_CORREO_CLIGA_SP(?,?,?,?,?)}");
            cs.setString("paCorreo", correo);
            cs.setString("paToken", liga);
            cs.registerOutParameter("paRespuesta", OracleTypes.NUMBER);
            cs.registerOutParameter("paCodigoError", OracleTypes.NUMBER);
            cs.registerOutParameter("paMjeDescError", OracleTypes.VARCHAR);
            cs.execute();
            int tmp = cs.getInt("paRespuesta");
            existe = String.valueOf(tmp);
            existeDes = cs.getString("paMjeDescError");
            cs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.CerraConexion();
        }
        return existe + "&" + existeDes;
    }
    
    
    
///respuesta 
    //

    public int[] InsertaPersonales(String curp, String nombre, String Apaterno, String Amaterno, String FecNac,
            String Pais, String Estado, String Municipio, String Localidad, char sexo, String EdoCivil, String sangre, String capacidad,
            char Curso, String correo) {
        int IdAspiranteRes[] = new int[2];
        try {
            cs = con.getConnection().prepareCall("{call FICHAS.PQ_INSERT_ASPIRANTE_1.SET_REGISTRO_PERSONALDATA_SP(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString("paCurp", curp);
            cs.setString("paNombre", nombre);
            cs.setString("paApellidoPat", Apaterno);
            cs.setString("paApellidoMat", Amaterno);
            cs.setString("paFechaDeNacimiento", FecNac);
            cs.setString("paPaisNacimiento", Pais);
            if (!"null".equals(Estado)) {
                cs.setInt("paEstadoNacimiento", Integer.parseInt(Estado));
                cs.setInt("paMunicipioNac", Integer.parseInt(Municipio));
                cs.setInt("paLocalidadNac", Integer.parseInt(Localidad));
            } else {
                cs.setString("paEstadoNacimiento", "");
                cs.setString("paMunicipioNac", "");
                cs.setString("paLocalidadNac", "");
            }
            cs.setString("paSexo", String.valueOf(sexo));
            cs.setString("paEdoCivil", EdoCivil);
            cs.setString("paTipoSangre", sangre);
            cs.setString("paCapDiferente", capacidad);
            cs.setString("paCursoProp", String.valueOf(Curso));
            cs.setString("paCorreo", correo);
            cs.registerOutParameter("paIdAspirante", OracleTypes.NUMBER);
            cs.registerOutParameter("paCodigoError", OracleTypes.NUMBER);
            cs.registerOutParameter("paMjeDescError", OracleTypes.VARCHAR);
            cs.execute();
            IdAspiranteRes[0] = cs.getInt("paIdAspirante");
            IdAspiranteRes[1] = cs.getInt("paCodigoError");
            
            cs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.CerraConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return IdAspiranteRes;
    }

    public int InsertaDireccion(int IdAsp, int Estado, int Municipio, int Localidad, String calle, String NumInt, int NumExt,
            String colonia, int CodPost, String TelFijo, String TelCel) {
        int Exitoso = 0;

        try {
            cs = con.getConnection().prepareCall("{call FICHAS.PQ_INSERT_ASPIRANTE_1.SET_REGISTRO_DOMICILIO_ASP_SP(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt("paIdAspirante", IdAsp);
            cs.setInt("paEstadoViveActual", Estado);
            cs.setInt("paMunicipioVive", Municipio);
            cs.setInt("paLocalidadVive", Localidad);
            cs.setString("paCalle", calle);
            if (!"null".equals(NumInt.trim())) {
                if (!"".equals(NumInt.trim())) {
                    cs.setInt("paNoInterior", Integer.parseInt(NumInt.trim()));
                } else {
                    cs.setString("paNoInterior", "");
                }
            } else {
                cs.setString("paNoInterior", "");
            }
            cs.setInt("paNoExterior", NumExt);
            cs.setString("paColoniaPob", colonia);
            cs.setInt("paCodPost", CodPost);
            cs.setString("paTelFijo", TelFijo);
            cs.setString("paTelCel", TelCel);
            cs.registerOutParameter("paCodigoError", OracleTypes.NUMBER);
            cs.registerOutParameter("paMjeDescError", OracleTypes.NUMBER);
            cs.execute();

            Exitoso = cs.getInt("paCodigoError");
            
        } catch (SQLException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.CerraConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Exitoso;
    }

    public int InsertaCarrera(int IdAsp, int Carrera, int opcion) {
        int Exitoso = 0;
        try {
            try {
                cs = con.getConnection().prepareCall("{call FICHAS.PQ_INSERT_ASPIRANTE_1.SET_REGISTRO_CARRERA_ASP_SP(?,?,?,?,?)}");
                cs.setInt("paIdAspirante", IdAsp);
                cs.setInt("paCarrera", Carrera);
                cs.setInt("paOpcion", opcion);
                cs.registerOutParameter("paCodigoError", OracleTypes.NUMBER);
                cs.registerOutParameter("paMjeDescError", OracleTypes.VARCHAR);
                cs.execute();
                Exitoso = cs.getInt("paCodigoError");
                
                cs.close();

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.CerraConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Exitoso;
    }

    public int InsertaEscProcedencia(int IdAsp, String Escuela, String clave, String TipoEsc,
            int mesinicio, int mesfin, int anioinicio, int aniofin, int promedio) {
        int Exitoso = 0;
        try {
            cs = con.getConnection().prepareCall("{call FICHAS.PQ_INSERT_ASPIRANTE_1.SET_REGISTRO_ESCPROC_ASP_SP (?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt("paIdAspirante", IdAsp);
            cs.setString("paEscuela", Escuela);
            cs.setString("paClaveEscuela", clave);
            cs.setString("paTipoEscuela", TipoEsc);
            cs.setInt("paMesIniEsc", mesinicio);
            cs.setInt("paMesFinEsc", mesfin);
            cs.setInt("paAñoIniEsc", anioinicio);
            cs.setInt("paAñoFinEsc", aniofin);
            cs.setInt("paPromedio", promedio);
            cs.registerOutParameter("paCodigoError", OracleTypes.NUMBER);
            cs.registerOutParameter("paMjeDescError", OracleTypes.VARCHAR);
            cs.execute();
            Exitoso = cs.getInt("paCodigoError");
            
            cs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.CerraConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Exitoso = 0;
    }

    public int InsertaSocioeconomicos(int IdAsp, String NomPadre, String VivePadre, int OcupaPadre, int EstudiosPadre,
            String NomMadre, String ViveMadre, int OcupaMadre, int EstudiosMadre, String ViveCon, String DependeEcon, String IngresosTot,
            String tipoCasa, String CuartosCasa, int NumPerDepEco, int PerViveCasa, String ProgOportunidades, String ZonaProcedencia,
            String TipoBeca) {
        int Exitoso = 0;
        try {
            cs = con.getConnection().prepareCall("{call FICHAS.PQ_INSERT_ASPIRANTE_2.SET_REGISTRO_SOCIECONOMICO_SP(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt("paIdAspirante", IdAsp);
            cs.setString("paNombrePadre", NomPadre);
            cs.setString("paVivePadre", VivePadre);
            cs.setInt("paOcupacionPadre", OcupaPadre);
            cs.setInt("paEstudiosPadre", EstudiosPadre);
            cs.setString("paNombreMadre", NomMadre);
            cs.setString("paViveMadre", ViveMadre);
            cs.setInt("paOcupacionMadre", OcupaMadre);
            cs.setInt("paEstudiosMadre", EstudiosMadre);
            cs.setString("paViveCon", ViveCon);
            cs.setString("paDependEcon", DependeEcon);
            cs.setString("paIngresosTot", IngresosTot);
            cs.setString("paTipoDeCasa", tipoCasa);
            cs.setString("paCuartosCasa", CuartosCasa);
            cs.setInt("paNumPerDepEcon", NumPerDepEco);
            cs.setInt("paPersonasVCasa", PerViveCasa);
            cs.setString("paPrgOportunid", ProgOportunidades);
            cs.setString("paZonaProced", ZonaProcedencia);
            cs.setString("paTipoBeca", TipoBeca);
            cs.registerOutParameter("paCodigoError", OracleTypes.NUMBER);
            cs.registerOutParameter("paMjeDescError", OracleTypes.VARCHAR);
            cs.execute();
            Exitoso = cs.getInt("paCodigoError");
            
            cs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.CerraConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Exitoso;
    }
//************************CAMBIO

    public int InsertaContactoEmergencia(int IdAsp, String NomContacto, int Estado,
            int CiuMunicipio, String colonia, String Calle, String NumInt, int NumExt,
            String telFijo, String TelCel, String CentroTrabajo, String TelCentroTrab) {
        int Exitoso = 0;
        try {
            cs = con.getConnection().prepareCall("{call FICHAS.PQ_INSERT_ASPIRANTE_2.SET_REGISTRO_CONTACTO_ASP_SP(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt("paIdAspirante", IdAsp);
            cs.setString("paNombreContacto", NomContacto);
            cs.setInt("paEstado", Estado);
            cs.setInt("paMunicipioFk", CiuMunicipio);
            cs.setString("paColonia", colonia);
            cs.setString("paCalle", Calle);
            if (!"null".equals(NumInt.trim())) {
                cs.setInt("paNo_Interior", Integer.parseInt(NumInt.trim()));
            } else {
                cs.setString("paNo_Interior", "");
            }
            cs.setInt("paNo_Exterior", NumExt);
            cs.setString("paTel_Fijo", telFijo);
            cs.setString("paTel_Cel", TelCel);
            cs.setString("paCentroTrabajo", CentroTrabajo);
            cs.setString("paTel_Centro_Trab", TelCentroTrab);
            cs.registerOutParameter("paCodigoError", OracleTypes.NUMBER);
            cs.registerOutParameter("paMjeDescError", OracleTypes.VARCHAR);
            cs.execute();
            Exitoso = cs.getInt("paCodigoError");
            
            cs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.CerraConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Exitoso;
    }

    public int Borrando(int IdAspirante) {
        int Exitoso = 0;
        try {
            cs = con.getConnection().prepareCall("{call FICHAS.PQ_BORRADO_ASPIRANTE_1.BORRADO_REGISTRO_ASP_SP(?,?,?)}");
            cs.setInt("paIdAspirante", IdAspirante);
            cs.registerOutParameter("paCodigoError", OracleTypes.NUMBER);
            cs.registerOutParameter("paMjeDescError", OracleTypes.VARCHAR);
            cs.execute();
            Exitoso = cs.getInt("paCodigoError");
            
            cs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.CerraConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Procedimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Exitoso;
    }
}
