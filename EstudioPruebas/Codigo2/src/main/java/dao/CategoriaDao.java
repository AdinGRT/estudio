/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import model.Categoria;

/**
 *
 * @author adingrt
 */
public class CategoriaDao {
    public static boolean registrar(Categoria cat){
        try {
            String SQL="INSERT INTO categorias(nombre) values(?);";
            Connection con = Conexion.conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, cat.getNombre());
            return st.executeUpdate()>0;
        } catch (SQLException ex) {
            return false;
        }
    }
    public static ArrayList<Categoria> listar(){
        try {
            String SQL="SELECT *FROM categorias;";
            Connection con = Conexion.conectar();
            PreparedStatement st=con.prepareStatement(SQL);
            //st.setString(1, cat.getNombre());
            ResultSet resultado=st.executeQuery();
            ArrayList<Categoria> lista=null;
            Categoria cat;
            while(resultado.next()){
                cat = new Categoria();
                cat.setCodigo(resultado.getInt("codigo"));
                cat.setNombre(resultado.getString("nombre"));
                lista.add(cat);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
}

