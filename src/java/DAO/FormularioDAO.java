
package DAO;

import BD.Conexion;
import Entidad.Formulario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class FormularioDAO {
    
    public LinkedList<Formulario> obtenerTipoFormulario() throws SQLException{
        LinkedList<Formulario> listaFormulario=new LinkedList<Formulario>();
    String query="select *from cdc_contratista.dbo.tipo_formulario;";
        Connection connection=Conexion.conectarBD();
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);  
        while(resultSet.next()){
            Formulario formulario=new Formulario();
            formulario.setNombre(resultSet.getString("detalle"));
            formulario.setId(resultSet.getInt("id_tipo_formulario"));
            listaFormulario.add(formulario);    
            
        }
        return listaFormulario;    
}
    
}
