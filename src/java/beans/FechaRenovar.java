package beans;

/**
 *
 * @author Chris
 */
public class FechaRenovar {

    String fechaIni;
    String fechaFin;
    String descError;
    int codError;

    public String getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(String fechaIni) {
        this.fechaIni = fechaIni;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescError() {
        return descError;
    }

    public void setDescError(String descError) {
        this.descError = descError;
    }

    public int getCodError() {
        return codError;
    }

    public void setCodError(int codError) {
        this.codError = codError;
    }

}
