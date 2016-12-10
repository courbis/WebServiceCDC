/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import DAO.*;
import Entidad.Usuario;
import com.google.gson.Gson;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Courbis-Diaz
 */
@Path("generic")
public class GenericResource {


    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }
    
    @GET
    @Path("/Autenticacion")
    public String Autenticacion(@QueryParam("rut")String rut,@QueryParam("clave")String clave) throws SQLException{
                    UsuarioDAO udao=new UsuarioDAO();
            Usuario usuario=new Usuario();
        udao.autenticacion(rut, clave);
        usuario.setNombre(udao.nombre());
        usuario.setApellido(udao.apellido());
        Gson gson=new Gson();
        return gson.toJson(usuario);
    }
    
    @GET
    @Path("/obtenerObra")
    public String obtenerObra() throws SQLException{
        ObraDAO odao=new ObraDAO();
        Gson gson=new Gson();
        return gson.toJson(odao.asignar());
    }
    
        @GET
    @Path("/obtenerInspector")
    public String obtenerInspector() throws SQLException{
        InspectorDAO idao=new InspectorDAO();   
        Gson gson=new Gson();
        return gson.toJson(idao.obtenerInspector());
    }
    
    @GET
    @Path("/obtenerFormulario")
    public String obtenerFormulario() throws SQLException{
        FormularioDAO fdao=new FormularioDAO();
        Gson gson=new Gson();
        return gson.toJson(fdao.obtenerTipoFormulario());
    }
    
    @GET
    @Path("/obtenerSector")
    public String obtenerSector(@QueryParam("idObra")int idObra) throws SQLException{
        SectorDAO sdao=new SectorDAO();      
        Gson gson=new Gson();
        return gson.toJson(sdao.obtenerSector(idObra));
    }
    
    @GET
    @Path("/obtenerSubSector")
    public String obtenerSubSector(@QueryParam("idSector")int idSector) throws SQLException{
        SubSectorDAO ssdao=new SubSectorDAO();
        Gson gson=new Gson();
        return gson.toJson(ssdao.obtenerSubSector(idSector));
    }
    
    @GET
    @Path("/asignar")
    public String asignar(@QueryParam("idObra") int idObra, @QueryParam("idSector")int idSector,@QueryParam("idSubSector") int idSubSector,@QueryParam("idInspector") int idInspector,@QueryParam("idFormulario") int idFormulario) throws SQLException{
        AsignarDAO adao=new AsignarDAO();
        adao.Asignar(idObra, idSector, idSubSector, idInspector, idFormulario);
        return"Exito!";
    }
    
    
    
    
    

    /**
     * Retrieves representation of an instance of servicio.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
