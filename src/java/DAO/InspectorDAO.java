
package DAO;

import BD.Conexion;
import Entidad.Inspector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class InspectorDAO {
    
    public LinkedList<Inspector> obtenerInspector() throws SQLException{
        LinkedList<Inspector> listaInspector=new LinkedList<Inspector>();
    String query="select id_usuario, nombre, apellido, rut from usuario where tipo_usuario=2";
        Connection connection=Conexion.conectarBD();
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);  
        while(resultSet.next()){
            Inspector inspector=new Inspector();
            inspector.setNombre(resultSet.getString("nombre"));
            inspector.setApellido(resultSet.getString("apellido"));
            inspector.setRut(resultSet.getString("rut"));
            inspector.setId(resultSet.getInt("id_usuario"));
            listaInspector.add(inspector);    
            
        }
        return listaInspector;    
}
}
