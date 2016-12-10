
package DAO;

import BD.Conexion;
import Entidad.Obra;
import Entidad.PreguntaFormulario;
import Entidad.Tarea;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class TareaDAO {
    
            Conexion conexion=new Conexion();
    
    public  LinkedList<Tarea> obtenerTarea(int idUsuario) throws SQLException{
        LinkedList<Tarea> listaTarea=new LinkedList<Tarea>();
                String query="select id_tarea_asignada, obra.nombre_obra as obra, tipo_sector.detalle+' '+sector.detalle as sector,\n" +
"tipo_subsector.detalle+' '+subsector.detalle as subsector, tipo_formulario.detalle as formulario\n" +
"from tarea_asignada,obra,sector,subsector,tipo_formulario, sector_obra,tipo_sector,tipo_subsector \n" +
"where id_usuario="+idUsuario+" and obra.id_obra=tarea_asignada.id_obra and sector_obra.id_sector=sector.id_sector and\n" +
"sector_obra.id_obra=obra.id_obra and sector.id_tipo_sector=tipo_sector.id_tipo_sector and \n" +
"subsector.id_obra_sector=sector_obra.id_sector_obra and tipo_subsector.id_tipo_subsector=subsector.id_tipo_subsector\n" +
"and tipo_formulario.id_tipo_formulario=tarea_asignada.id_tipo_formulario;";
       Connection connection=Conexion.conectarBD();
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);
        try{
            while (resultSet.next()) {
            Tarea tarea=new Tarea();
          tarea.setId(resultSet.getInt("id_tarea_asignada"));
          tarea.setObra(resultSet.getString("obra"));
          tarea.setSector(resultSet.getString("sector"));
          tarea.setSubSector(resultSet.getString("subsector"));
          tarea.setFormulario(resultSet.getString("formulario"));
          listaTarea.add(tarea);
        }
        }catch(Exception e){
            }    
        
     return listaTarea;
    }
    
    public void insertarTareaLista(int idTareaAsignada, String respuesta) throws SQLException{
              
        int i=1;
        LinkedList<PreguntaFormulario> listaRespuesta=new LinkedList<PreguntaFormulario>();
        String delimitador=",";
    StringTokenizer stringTokenizer=new StringTokenizer(respuesta, delimitador);
    while(stringTokenizer.hasMoreTokens()){
        
        String query="insert into formulario_completo(id_tarea_asignada,id_pregunta,respuesta,fecha)\n" +
                        "values("+idTareaAsignada+","+i+++",'"+stringTokenizer.nextToken()+"',GETDATE());";
        Connection connection=Conexion.conectarBD();
        Statement statement= connection.createStatement();
        statement.executeUpdate(query);

    }  
    }    
    
    
     public LinkedList<PreguntaFormulario> separarRespuesta(int idTareaAsignada,String respuesta){
         int i=1;
        LinkedList<PreguntaFormulario> listaRespuesta=new LinkedList<PreguntaFormulario>();
        String delimitador=",";
    StringTokenizer stringTokenizer=new StringTokenizer(respuesta, delimitador);
    while(stringTokenizer.hasMoreTokens()){
        PreguntaFormulario pf=new PreguntaFormulario();
        pf.setRespuesta(stringTokenizer.nextToken());
        pf.setIdPregunta(i++);
        pf.setIdTareaAsignada(idTareaAsignada);
        listaRespuesta.add(pf);
    }
    return listaRespuesta;
     }
}
