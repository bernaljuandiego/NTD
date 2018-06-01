/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.resources;

import co.edu.konrad.MarketPlaceKonrad.dto.UsuarioDTO;
import co.edu.konrad.MarketPlaceKonrad.entities.UsuarioEntity;
import co.edu.konrad.MarketPlaceKonrad.logic.UsuarioLogic;
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
 *servicio REST para el manejo de Usuarios
 * @author Leonardo Ruiz
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/Usuarios")
public class UsuarioResource {
    
    
    
    @EJB
    private UsuarioLogic usuariologic;
    
    
      /**
     * Metodo HTTP - GET para obtener todos los usuarios
     * @return Lista de usuarios
     */
    @GET
    public List<UsuarioDTO> getUsuarioList(){
        List<UsuarioEntity> usuarios = usuariologic.obtenerUsuarios();
        return UsuarioDTO.toUsuarioList(usuarios);
    }
    
    /**
     * Metodo HTTP-GET obtener un usuario a traves de su id.
     * Hace uso de parametros se usan las anotaciones @Path para 
     * personalizar la ruta de acceso, y @PathParam para indicar
     * cual es el parametro. En el @Path es necesario determinar 
     * una expresion regular que defina el tipo de caracteres que 
     * pueden ingresar en la URI para el parametro configurado.
     * @param id
     * @return usuario
     */
    @GET
    @Path("{id: \\d+}")
    public UsuarioDTO getUsuario(@PathParam("id") Long id){
        UsuarioEntity user = usuariologic.obtenerUsuario(id);
        if(user == null){
            throw new RuntimeException("El usuario solicitado no existe.");
        }
        return new UsuarioDTO(user);
    }
    
    /**
     * Metodo HTTP -POST usado para crear un nuevo objeto Usuario
     * @param usuarioDTO
     * @return usuarioDTO
     */
    @POST
    public UsuarioDTO createEstudiante(UsuarioDTO usuarioDTO){
        return new UsuarioDTO(usuariologic.crearUsuario(usuarioDTO.toEntity()));
    }
    
    /**
     * Metodo HTTP - PUT permite actualizar un objeto usuario.
     * OJO: El nombre del parametro pesonalizado en el @Path y el @PathParam
     * deben ser IGUALES.
     * @param id
     * @param usuarioDTO
     * @return 
     */
    @PUT
    @Path("{id: \\d+}")
    public UsuarioDTO updateUsuario(@PathParam("id") Long id, UsuarioDTO usuarioDTO ){
        UsuarioEntity entity = usuariologic.obtenerUsuario(id);
        if(entity == null){
            throw new RuntimeException("El usuario solicitado no existe.");
        }
        return new UsuarioDTO(usuariologic.actualizarUsuario(id, usuarioDTO.toEntity()));
    }
    
    /**
     * Metodo HTTP-DELETE usado para eliminar un objeto de Usuario
     * @param id 
     */
    @DELETE
    @Path("{usuarioId: \\d+}")
    public void deleteUsuario(@PathParam("usuarioId") Long id){
        UsuarioEntity entity = usuariologic.obtenerUsuario(id);
        if(entity == null){
            throw new RuntimeException("El estudiante solicitado no existe.");
        }
        usuariologic.eliminarUsuario(id);
    }
}
