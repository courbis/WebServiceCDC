
package DAO;

import BD.Conexion;
import Entidad.Obra;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;


public class ObraDAO {
    
        Conexion conexion=new Conexion();
    
    public  LinkedList<Obra> asignar() throws SQLException{
        LinkedList<Obra> listaAsignar=new LinkedList<Obra>();
                String query="select id_obra, nombre_obra, direccion_obra from obra;";
       Connection connection=Conexion.conectarBD();
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);
        try{
            while (resultSet.next()) {
            Obra obra=new Obra();
            obra.setNombre(resultSet.getString("nombre_obra"));
            obra.setDireccion(resultSet.getString("direccion_obra"));
            obra.setId(Integer.parseInt(resultSet.getString("id_obra")));
            listaAsignar.add(obra);
        }
        }catch(Exception e){
            }    
        
     return listaAsignar;
    }
    
}
