package modelos;

import ConexionBD.Conexion;
import ConexionBD.Constantes;
import ConexionBD.VerificaVigencia;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Chris
 */
public class VerificaCupo {

    /**
     *
     * @return Cadena compuesta por la cuenta de prefichas disponibles y el
     * mensaje del procedimiento
     */
    public String getCupo() {
        String ret = "";
        try {
            String resultado_error;
            String descrip_error;
            Integer cuenta_fichas;
            CallableStatement cst;
            Conexion con = new Conexion(Constantes.BD_NAME, Constantes.BD_PASS);
            cst = con.getConnection().prepareCall("{call FICHAS.PQ_CHECK_ASPIRANTE_1.CHECK_CANTIDAD_PREFICHAS_SP(?,?,?)}");
            cst.registerOutParameter("paCuentaFichas", OracleTypes.NUMBER);
            cst.registerOutParameter("paCodigoError", OracleTypes.VARCHAR);
            cst.registerOutParameter("paMjeDescError", OracleTypes.VARCHAR);
            cst.execute();

            resultado_error = cst.getString("paCodigoError");
            descrip_error = cst.getString("paMjeDescError");
            cuenta_fichas = cst.getInt("paCuentaFichas");

            if ("0".equals(resultado_error)) {
                ret = String.valueOf(cuenta_fichas) + "&" + "Ficha(s) disponobles";
                cst.close();
                con.CerraConexion();
            } else {
                GeneraAuditoria aud = new GeneraAuditoria();
                aud.crea_archivo(resultado_error, descrip_error, "Sucedio un error al trattar de obtener la cuenta de fichas disponibles");
                cst.close();
                con.CerraConexion();
                return "-100" + "&" + descrip_error;
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(VerificaVigencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Mandar llamar procedimiento que retorna la cuenta de prefichas
        return ret;
    }
}
