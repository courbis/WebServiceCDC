
package DAO;

import BD.Conexion;
import Entidad.Formulario;
import Entidad.FormularioCompleto;
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
    
     public LinkedList<FormularioCompleto> obtenerFormularioCompleto(int idObra) throws SQLException{
        LinkedList<FormularioCompleto> listaFormularioCompleto=new LinkedList<FormularioCompleto>();
    String query="select formulario_completo.fecha, usuario.nombre+' '+usuario.apellido as inspector, obra.nombre_obra as obra, tipo_sector.detalle+' '+sector.detalle as sector, tipo_subsector.detalle+' '+subsector.detalle as subsector, pregunta.pregunta as pregunta, formulario_completo.respuesta \n" +
"from pregunta,formulario_completo, obra, tarea_asignada, sector, tipo_sector, sector_obra, tipo_subsector, subsector, usuario\n" +
"where pregunta.id_pregunta=formulario_completo.id_pregunta and\n" +
"tarea_asignada.id_tarea_asignada=formulario_completo.id_tarea_asignada and tarea_asignada.id_obra=obra.id_obra and\n" +
"tarea_asignada.id_sector_obra=sector_obra.id_sector and sector_obra.id_sector=sector.id_sector and tarea_asignada.id_subsector=subsector.id_subsector\n" +
"and subsector.id_tipo_subsector=tipo_subsector.id_tipo_subsector and tarea_asignada.id_usuario=usuario.id_usuario and obra.id_obra="+idObra+";";
        Connection connection=Conexion.conectarBD();
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);  
        while(resultSet.next()){
            FormularioCompleto fc=new FormularioCompleto();
            fc.setFecha(resultSet.getString("fecha"));
            fc.setInspector(resultSet.getString("inspector"));
            fc.setObra(resultSet.getString("obra"));
            fc.setSector(resultSet.getString("sector"));
            fc.setSubSector(resultSet.getString("subsector"));
            fc.setPregunta(resultSet.getString("pregunta"));
            fc.setRespuesta(resultSet.getString("respuesta"));
            
            listaFormularioCompleto.add(fc);
        }
        return listaFormularioCompleto;    
}
    
}
