package dao;

import java.sql.*;
import java.util.*;
import modelo.*;

public class CategoriaDao {

    private static final String SQL_SELECT = "SELECT * FROM categoria";
    private static final String SQL_SELECT_CAT_MAS_VENTAS = "SELECT DISTINCT categoria.cod_categoria, categoria.nombre "
            + "FROM venta "
            + "JOIN producto ON (venta.cod_producto = producto.cod_producto) "
            + "JOIN categoria ON (producto.cod_categoria = categoria.cod_categoria) "
            + "WHERE TO_CHAR(venta.fecha, 'YYYY') = '2019'";

    private Connection conn = null;
    //private Statement stmt = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    //private int registros = 0;
    Categoria categoria = null;

    public List<Categoria> listar() {
        List<Categoria> categorias = new ArrayList<>();
        try {
            conn = Conexion.conectar();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
                categoria = new Categoria();
                categoria.setCodigoCategoria(rs.getInt("cod_categoria"));
                categoria.setNombreCategoria(rs.getString("nombre"));
                categorias.add(categoria);
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
    
    public List<Categoria> listar_mas_vendidas() {
        List<Categoria> categorias = new ArrayList<>();
        try {
            conn = Conexion.conectar();
            ps = conn.prepareStatement(SQL_SELECT_CAT_MAS_VENTAS);
            rs = ps.executeQuery();
            while (rs.next()) {
                categoria = new Categoria();
                categoria.setCodigoCategoria(rs.getInt(1));
                categoria.setNombreCategoria(rs.getString(2));
                categorias.add(categoria);
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
