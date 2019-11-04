/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Editorial;

/**
 *
 * @author user
 */
public class EditorialDao {
   
    
    
   
    public static boolean registrar(Editorial e){
    try {
        String SQL="INSERT INTO editoriales(nit,nombre,telefono,direccion,email,sitioweb)" +
"VALUES(?,?,?,?,?,?);";
        Connection con=Conexion.conectar();
        PreparedStatement st=con.prepareStatement(SQL);
        st.setString(1, e.getNit());
        st.setString(2, e.getNombre());
        st.setString(3, e.getTelefono());
        st.setString(4, e.getDireccion());
        st.setString(5, e.getEmail());
        st.setString(6, e.getSitioweb());
        if(st.executeUpdate()>0){
            return true;
        }else{
            return false;
        }
        } catch (SQLException ex){
            return false;
        }
    }
    
    
    public static ArrayList<Editorial> listar(){
    try {
        String SQL="SELECT * FROM editoriales";
        Connection con=Conexion.conectar();
        PreparedStatement st=con.prepareStatement(SQL);
        //st.setString(1, cat.getNombre());
        ResultSet resultado=st.executeQuery();
        
       //ArrayList<Editorial> lista=null;
        ArrayList<Editorial> lista=new ArrayList<>();
        
        Editorial edi;
        while(resultado.next()){
            edi=new Editorial();
            edi.setNit(resultado.getString("nit"));
            edi.setNombre(resultado.getString("nombre"));
            edi.setDireccion(resultado.getString("direccion"));
            edi.setEmail(resultado.getString("email"));
            edi.setSitioweb(resultado.getString("sitioweb"));
            edi.setTelefono(resultado.getString("telefono"));
            lista.add(edi);
        }
        return lista;
        } catch (SQLException ex){
            return null;
        }
       
    }
    
    
     public static String getEditorial(String nit){
  
    try {
        String SQL="SELECT nombre FROM editoriales WHERE nit=?";
        Connection con=Conexion.conectar();
        PreparedStatement st=con.prepareStatement(SQL);
        st.setString(1, nit);
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
