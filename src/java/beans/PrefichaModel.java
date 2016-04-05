package beans;

/**
 *
 * @author Chris
 */
public class PrefichaModel {

    String periodobd;
    String fechapdf;
    String prefichabd;
    String nombrebd;
    String apellidosbd;
    String curpbd;
    String carrerabd;
    String modalidadbd;
    String importe_bd;
    String ref_bancaria;
    private String fecha_limite_pago;
    int existe;

    public int getExiste() {
        return existe;
    }

    public void setExiste(int existe) {
        this.existe = existe;
    }

    public String getPeriodobd() {
        return periodobd;
    }

    public void setPeriodobd(String periodobd) {
        this.periodobd = periodobd;
    }

    public String getFechapdf() {
        return fechapdf;
    }

    public void setFechapdf(String fechapdf) {
        this.fechapdf = fechapdf;
    }

    public String getPrefichabd() {
        return prefichabd;
    }

    public void setPrefichabd(String prefichabd) {
        this.prefichabd = prefichabd;
    }

    public String getNombrebd() {
        return nombrebd;
    }

    public void setNombrebd(String nombrebd) {
        this.nombrebd = nombrebd;
    }

    public String getApellidosbd() {
        return apellidosbd;
    }

    public void setApellidosbd(String apellidosbd) {
        this.apellidosbd = apellidosbd;
    }

    public String getCurpbd() {
        return curpbd;
    }

    public void setCurpbd(String curpbd) {
        this.curpbd = curpbd;
    }

    public String getCarrerabd() {
        return carrerabd;
    }

    public void setCarrerabd(String carrerabd) {
        this.carrerabd = carrerabd;
    }

    public String getModalidadbd() {
        return modalidadbd;
    }

    public void setModalidadbd(String modalidadbd) {
        this.modalidadbd = modalidadbd;
    }

    public String getRef_bancaria() {
        return ref_bancaria;
    }

    public void setRef_bancaria(String ref_bancaria) {
        this.ref_bancaria = ref_bancaria;
    }

    public String getImporte_bd() {
        return importe_bd;
    }

    public void setImporte_bd(String importe_bd) {
        this.importe_bd = importe_bd;
    }

    public String getFecha_limite_pago() {
        return fecha_limite_pago;
    }
    
    public void setFecha_limite_pago(String fecha_limite_pago) {
        this.fecha_limite_pago = fecha_limite_pago;
    }

}
