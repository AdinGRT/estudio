package dao;

import java.sql.*;
import java.util.*;

import modelo.*;

public class TestConexion {

	public static void main(String[] args) {
		CategoriaDao categoriaDao = new CategoriaDao();
		//Categoria categoria = new Categoria();
		
		List<Categoria> categorias = categoriaDao.listar();
		
		/*for(int i = 0; i < categorias.size(); i++) {
			System.out.println(categorias.get(i));
		}*/
		
		categorias.forEach(categoria -> {
			System.out.println(categoria);
		});
		
		/*Connection conn = null;
		try {
			conn = Conexion.conectar();
			System.out.println("Se conecto");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		} finally {
			try {
				Conexion.desconectar(conn);
				System.out.println("Se desconecto");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(System.out);
			}
		}*/
	}

}
