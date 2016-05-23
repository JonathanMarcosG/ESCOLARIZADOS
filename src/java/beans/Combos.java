package beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ElyyzZ BaRruEtA
 */

public class Combos {
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
    
     public List<Combos> AgregaS(List<Combos> respuestabd) {
        List<Combos> catalogo= new  ArrayList<>();
        Combos B= new Combos();
        B.setClave("--");
        B.setNombre("--Seleccione--");
        catalogo.add(B);
        for(int  i=0;i<respuestabd.size(); i++){
            catalogo.add( respuestabd.get(i));        
        }        
        return catalogo;
    }
}
