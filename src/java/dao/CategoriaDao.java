/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Categoria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Categoria;
/**
 *
 * @author user
 */
public class CategoriaDao {
    public static boolean registrar(Categoria cat){
    try {
        String SQL="INSERT INTO categorias(nombre) values(?);";
        Connection con=Conexion.conectar();
        PreparedStatement st=con.prepareStatement(SQL);
        st.setString(1, cat.getNombre());
        if(st.executeUpdate()>0){
            return true;
        }else{
            return false;
        }
        } catch (SQLException ex){
            return false;
        }
    }
    
    
    public static ArrayList<Categoria> listar(){
    try {
        String SQL="SELECT * FROM categorias;";
        Connection con=Conexion.conectar();
        PreparedStatement st=con.prepareStatement(SQL);
        //st.setString(1, cat.getNombre());
        ResultSet resultado=st.executeQuery();
        //ArrayList<Categoria> lista=null;
        ArrayList<Categoria> lista=new ArrayList<>();
        Categoria cat;
        while(resultado.next()){
            cat=new Categoria();
            cat.setCodigo(resultado.getInt("codigo"));
            cat.setNombre(resultado.getString("nombre"));
            lista.add(cat);
        }
        return lista;
        } catch (SQLException ex){
            return null;
        }
        
    }
    
    
    public static String getCategoria(int cod){
        try {
        String SQL="SELECT nombre FROM categorias WHERE codigo=?";
        Connection con=Conexion.conectar();
        PreparedStatement st=con.prepareStatement(SQL);
        //st.setString(1, cat.getNombre());
        st.setInt(1, cod);
        ResultSet resultado=st.executeQuery();
       
        if(resultado.next()){
            return resultado.getString("nombre");
        }
        return "--";
        } catch (SQLException ex){
            return "-";
        }
       
  
}  
    
    
    
    
    
}
