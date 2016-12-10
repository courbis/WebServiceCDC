/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BD.Conexion;
import Entidad.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO {
    String nombre="";
    String apellido="";
    int id=0;
    
    Conexion conexion=new Conexion();
    
    public void autenticacion(String rut, String pass) throws SQLException{
        String query="select nombre, apellido,id_usuario from usuario where rut='"+rut+"' and pass='"+pass+"';";
        Connection connection=conexion.conectarBD();
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);
        
while(resultSet.next()){
    
    nombre=resultSet.getString(1);
    apellido=resultSet.getString(2);
    id=resultSet.getInt(3);
    
    }
        
        }
 
 public String nombre()   {
     return nombre;
 }
 
 public String apellido(){
     return apellido;
 }
 
 public int id(){
     return id;
 }
}
