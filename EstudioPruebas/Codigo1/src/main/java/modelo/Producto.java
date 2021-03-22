package modelo;

/**
 *
 * @author adingrt
 */
public class Producto {
    private int codigoProducto;
    private String nombreProducto;
    private int codigoCategoria;

    public Producto() {
    }

    public Producto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
        
    public Producto(String nombreProducto, int codigoCategoria) {
        this.nombreProducto = nombreProducto;
        this.codigoCategoria = codigoCategoria;
    }
    
    public Producto(int codigoProducto, String nombreProducto, int codigoCategoria) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.codigoCategoria = codigoCategoria;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigoProducto=" + codigoProducto + ", nombreProducto=" + nombreProducto + ", codigoCategoria=" + codigoCategoria + '}';
    }
    
    
    
}
