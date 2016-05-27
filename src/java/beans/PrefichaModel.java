package beans;

/**
 *
 * @author Chris
 */
public class PrefichaModel {

    private String periodobd;
    private String mensaje;
    private String fechapdf;
    private String prefichabd;
    private String nombrebd;
    private String apellidosbd;
    private String curpbd;
    private String carrerabd;
    private String modalidadbd;
    private String importe_bd;
    private String ref_bancaria;
    private String fecha_limite_pago;
    private int existe;

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

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
