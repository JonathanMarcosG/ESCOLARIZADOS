/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ElyyzZ BaRruEtA
 */
public class BaseDatos {
    private String Clave;
    private String Nombre;

    /**
     * @return the Clave
     */
    public String getClave() {
        return Clave;
    }

    /**
     * @param Clave the Clave to set
     */
    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
     public List<BaseDatos> AgregaS(List<BaseDatos> respuestabd) {
        List<BaseDatos> catalogo= new  ArrayList<>();
        BaseDatos B;
        B = new BaseDatos();
        B.setClave("--");
        B.setNombre("-Seleccione-");
        catalogo.add(B);
        for(int  i=0;i<respuestabd.size(); i++){
            catalogo.add( respuestabd.get(i));        
        }        
        return catalogo;
    }
}
