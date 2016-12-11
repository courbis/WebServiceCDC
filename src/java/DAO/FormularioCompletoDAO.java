/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BD.Conexion;
import Entidad.Formulario;
import Entidad.FormularioCompleto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Courbis-Diaz
 */
public class FormularioCompletoDAO {
    
     public LinkedList<FormularioCompleto> obtenerFormularioCompleto1() throws SQLException{
        LinkedList<FormularioCompleto> listaFormularioCompleto=new LinkedList<FormularioCompleto>();
    String query="select formulario_completo.id_tarea_asignada, obra.nombre_obra as obra, usuario.nombre+''+usuario.apellido as inspector, formulario_completo.fecha\n" +
"from obra, usuario, formulario_completo, tarea_asignada\n" +
"where formulario_completo.id_tarea_asignada=tarea_asignada.id_tarea_asignada and\n" +
"tarea_asignada.id_obra=obra.id_obra and tarea_asignada.id_usuario=usuario.id_usuario\n" +
"group by formulario_completo.fecha, obra.nombre_obra, usuario.nombre, usuario.apellido, formulario_completo.id_tarea_asignada;";
        Connection connection=Conexion.conectarBD();
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);  
        while(resultSet.next()){
            FormularioCompleto formularioCompleto=new FormularioCompleto();
            formularioCompleto.setIdTareaAsignada(resultSet.getInt("id_tarea_asignada"));
            formularioCompleto.setObra(resultSet.getString("obra"));
            formularioCompleto.setFecha(resultSet.getString("fecha"));
            formularioCompleto.setInspector(resultSet.getString("inspector"));
            listaFormularioCompleto.add(formularioCompleto);    
            
        }
        return listaFormularioCompleto;    
}
        
}
