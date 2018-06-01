/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.resources;


import co.edu.konrad.MarketPlaceKonrad.dto.RolDTO;
import co.edu.konrad.MarketPlaceKonrad.entities.RolEntity;
import co.edu.konrad.MarketPlaceKonrad.logic.RolLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *Servicio REST para el manejo de roles
 * @author Leonardo Ruiz
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/Roles")
public class RolResource {
    
    
    @EJB
    private RolLogic rollogic;
    
    
    
    /**
     * Metodo HTTP - GET para obtener todos los roles
     * @return Lista de roles
     */
    @GET
    public List<RolDTO> getRolList(){
        List<RolEntity> Roles = rollogic.obtenerRoles();
        return RolDTO.toRolList(Roles);
    }
    
    /**
     * Metodo HTTP-GET obtener un Rol  a traves de su id.
     * Hace uso de parametros se usan las anotaciones @Path para 
     * personalizar la ruta de acceso, y @PathParam para indicar
     * cual es el parametro. En el @Path es necesario determinar 
     * una expresion regular que defina el tipo de caracteres que 
     * pueden ingresar en la URI para el parametro configurado.
     * @param id
     * @return rol
     */
    @GET
    @Path("{id: \\d+}")
    public RolDTO getRol(@PathParam("id") Long id){
        RolEntity rol = rollogic.obtenerRol(id);
        if(rol == null){
            throw new RuntimeException("El rol solicitado no existe.");
        }
        return new RolDTO(rol);
    }
    
    /**
     * Metodo HTTP -POST usado para crear un nuevo objeto Rol
     * @param rolDTO
     * @return rolDTO
     */
    @POST
    public RolDTO createRol(RolDTO rolDTO){
        return new RolDTO(rollogic.crearRol(rolDTO.toEntity()));
    }
    
    /**
     * Metodo HTTP - PUT permite actualizar un objeto Rol.
     * OJO: El nombre del parametro pesonalizado en el @Path y el @PathParam
     * deben ser IGUALES.
     * @param id
     * @param rolDTO
     * @return 
     */
    @PUT
    @Path("{id: \\d+}")
    public RolDTO updateRol(@PathParam("id") Long id, RolDTO rolDTO ){
        RolEntity entity = rollogic.obtenerRol(id);
        if(entity == null){
            throw new RuntimeException("El rol solicitado no existe.");
        }
        return new RolDTO(rollogic.actualizarRol(id, rolDTO.toEntity()));
    }
    
    /**
     * Metodo HTTP-DELETE usado para eliminar un objeto de Rol
     * @param id 
     */
    @DELETE
    @Path("{rolId: \\d+}")
    public void deleteTipoDocumento(@PathParam("rolId") Long id){
        RolEntity entity = rollogic.obtenerRol(id);
        if(entity == null){
            throw new RuntimeException("El rol solicitado no existe.");
        }
        rollogic.eliminarRol(id);
    }
    
}
