/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ElyyzZ BaRruEtA
 */
public class ClaveCCT {
    private String clave;
    private String CentroEducativo;
    private String turno;
    private String Domicilio;

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the CentroEducativo
     */
    public String getCentroEducativo() {
        return CentroEducativo;
    }

    /**
     * @param CentroEducativo the CentroEducativo to set
     */
    public void setCentroEducativo(String CentroEducativo) {
        this.CentroEducativo = CentroEducativo;
    }

    /**
     * @return the turno
     */
    public String getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(String turno) {
        this.turno = turno;
    }

    /**
     * @return the Domicilio
     */
    public String getDomicilio() {
        return Domicilio;
    }

    /**
     * @param Domicilio the Domicilio to set
     */
    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }
    public ArrayList  <ClaveCCT>  ConResultSet(ResultSet rs){
          ArrayList  <ClaveCCT> claves = null;
        try {
            ClaveCCT cla= new  ClaveCCT();
          
            //CONVERTIR EL  CURSOR  A  UN ARRAY LIST
            while (rs.next()) {
             
                cla.setClave(rs.getObject(1).toString());
                cla.setCentroEducativo(rs.getObject(2).toString());
                cla.setTurno(rs.getObject(3).toString());
                cla.setDomicilio(rs.getObject(4).toString());
                claves.add(cla);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ClaveCCT.class.getName()).log(Level.SEVERE, null, ex);
        }
        return claves;
    }
}
