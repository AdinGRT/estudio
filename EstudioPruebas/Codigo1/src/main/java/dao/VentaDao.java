package dao;

import java.sql.*;
import java.util.*;
import modelo.Reporte;

/**
 *
 * @author adingrt
 */
public class VentaDao {

    private static final String SQL_SELECT = "SELECT venta.fecha, producto.nombre, categoria.nombre FROM venta "
            + "JOIN producto ON(venta.cod_producto = producto.cod_producto) "
            + "JOIN categoria ON(producto.cod_categoria = categoria.cod_categoria)";
    private Connection conn = null;
    //private Statement stmt = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    //private int registros = 0;
    private Reporte reporte = null;
    
    public List<Reporte> listar() {
        List<Reporte> categorias = new ArrayList<>();
        try {
            conn = Conexion.conectar();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
                reporte = new Reporte();
                reporte.setFechaVenta(rs.getString(1));
                reporte.setNombreProducto(rs.getString(2));
                reporte.setNombreCategoria(rs.getString(3));
                System.out.println("\n\n\n\n" + reporte + "\n\n\n\n");
                categorias.add(reporte);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                Conexion.desconectar(rs);
                Conexion.desconectar(ps);
                Conexion.desconectar(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        }
        return categorias;
    }
}
