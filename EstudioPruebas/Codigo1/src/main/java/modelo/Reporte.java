package modelo;

/**
 *
 * @author adingrt
 */
public class Reporte {
    private String fechaVenta;
    private String nombreProducto;
    private String nombreCategoria;

    public Reporte() {
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    @Override
    public String toString() {
        return "Reporte{" + "fechaVenta=" + fechaVenta + ", nombreProducto=" + nombreProducto + ", nombreCategoria=" + nombreCategoria + '}';
    }
    
    
    
}
