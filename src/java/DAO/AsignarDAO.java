
package DAO;

import BD.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AsignarDAO {
    
        public static void Asignar(int idObra, int idSector, int idSubSector, int idInspector, int idFormulario) throws SQLException{
        String query="insert into tarea_asignada(id_tarea_asignada,id_usuario,id_sector_obra,id_subsector,id_obra,fecha,id_tipo_formulario)values"
                + "((SELECT MAX(id_tarea_asignada)+1 from tarea_asignada),"+idInspector+","+idSector+","+idSubSector+","+idObra+",GETDATE(),"+idFormulario+");";
        Connection connection=Conexion.conectarBD();
        Statement statement= connection.createStatement();
        statement.executeUpdate(query);
           
    }
    
}
