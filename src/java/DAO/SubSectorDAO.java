
package DAO;

import BD.Conexion;
import Entidad.SubSector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class SubSectorDAO {
    
    public LinkedList<SubSector> obtenerSubSector(int idSector) throws SQLException{
        LinkedList<SubSector> listaSubSector=new LinkedList<SubSector>();
    String query="select id_subsector, tipo_subsector.detalle+''+subsector.detalle as subsector "
            + "from obra,sector,tipo_sector,subsector,tipo_subsector,sector_obra "
            + "where 3 and "
            + "sector.id_tipo_sector=tipo_sector.id_tipo_sector and subsector.id_obra_sector=sector_obra.id_sector_obra and "
            + "tipo_subsector.id_tipo_subsector=subsector.id_tipo_subsector and sector.id_sector="+idSector+";";
        Connection connection=Conexion.conectarBD();
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);  
        while(resultSet.next()){
            SubSector subSector=new SubSector();
            subSector.setNombre(resultSet.getString("subsector"));
            subSector.setId(resultSet.getInt("id_subsector"));
            listaSubSector.add(subSector);
            
        }
        return listaSubSector;    
}
    
}
