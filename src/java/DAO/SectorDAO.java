
package DAO;

import BD.Conexion;
import Entidad.Sector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class SectorDAO {
    
    public LinkedList<Sector> obtenerSector(int idObra) throws SQLException{
        LinkedList<Sector> listaSector=new LinkedList<Sector>();
    String query="select sector.id_sector, tipo_sector.detalle+''+sector.detalle as sector from sector, tipo_sector, sector_obra where sector.id_sector=sector_obra.id_sector and sector.id_tipo_sector=tipo_sector.id_tipo_sector and id_obra="+idObra+";";
        Connection connection=Conexion.conectarBD();
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);  
        while(resultSet.next()){
            Sector sector=new Sector();
            sector.setNombre(resultSet.getString("sector"));
            sector.setId(resultSet.getString("id_sector"));
            listaSector.add(sector);    
            
        }
        return listaSector;    
}
    
}
