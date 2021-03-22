package dao;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Producto;

/**
 *
 * @author adingrt
 */
public class ProductoDao {

    private static final String SQL_SELECT_CAT = "SELECT cod_producto, nombre FROM producto WHERE cod_categoria = ?";
    private static final String SQL_INSERT = "INSERT INTO producto VALUES(sec_producto.NEXTVAL, ? , ?)";
    private Connection conn = null;
    //private Statement stmt = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private int registros = 0;
    Producto producto = null;

    public List<Producto> listaPorCategoria(int codigoCategoria) {
        List<Producto> productos = new ArrayList<>();
        try {
            conn = Conexion.conectar();
            ps = conn.prepareStatement(SQL_SELECT_CAT);
            ps.setInt(1, codigoCategoria);
            rs = ps.executeQuery();
            while (rs.next()) {
                producto = new Producto();
                producto.setCodigoProducto(rs.getInt(1));
                producto.setNombreProducto(rs.getString(2));
                productos.add(producto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.desconectar(rs);
                Conexion.desconectar(ps);
                Conexion.desconectar(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return productos;
    }
    
    public int insertar(Producto producto) {
        try {
            conn = Conexion.conectar();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, producto.getNombreProducto());
            ps.setInt(2, producto.getCodigoCategoria());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.desconectar(ps);
                Conexion.desconectar(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

}
