package modelo;

/**
 *
 * @author adingrt
 */
public class Venta {
    private int codigoVenta;
    private String fechaVenta;
    private String codigoProducto;

    public Venta() {
        
    }

    public Venta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public Venta(String fechaVenta, String codigoProducto) {
        this.fechaVenta = fechaVenta;
        this.codigoProducto = codigoProducto;
    }
    
    public Venta(int codigoVenta, String fechaVenta, String codigoProducto) {
        this.codigoVenta = codigoVenta;
        this.fechaVenta = fechaVenta;
        this.codigoProducto = codigoProducto;
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    @Override
    public String toString() {
        return "Venta{" + "codigoVenta=" + codigoVenta + ", fechaVenta=" + fechaVenta + ", codigoProducto=" + codigoProducto + '}';
    }   
    
}
