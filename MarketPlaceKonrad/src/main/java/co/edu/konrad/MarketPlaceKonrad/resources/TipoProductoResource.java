/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.resources;

import co.edu.konrad.MarketPlaceKonrad.logic.TipoProductoLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import co.edu.konrad.MarketPlaceKonrad.dto.TipoProductoDTO;
import co.edu.konrad.MarketPlaceKonrad.dto.UsuarioDTO;
import co.edu.konrad.MarketPlaceKonrad.entities.TipoProductoEntity;
import co.edu.konrad.MarketPlaceKonrad.entities.UsuarioEntity;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
/**
 * Servicios REST para tipoProducto
 * @author ManuelS
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/tipoProducto")
public class TipoProductoResource {
    
@EJB
private TipoProductoLogic tipoProductoLogic;
      /**
     * Metodo HTTP - GET para obtener todos los tipoProductos
     * @return Lista de tipoProductos
     */
@GET
public List<TipoProductoDTO> getTipoProductoList (){
List<TipoProductoEntity> tipoProductos = tipoProductoLogic.obtenerTipoProductos();
return TipoProductoDTO.toTipoProductoList(tipoProductos);
}
/**
 * Obtiene un tipoProducto por su id
 * @param id
 * @return tipoProducto
 */
@GET
@Path("{id: \\d+}")
public TipoProductoDTO getTipoProducto (@PathParam("id") Long id){
TipoProductoEntity tipoProducto = tipoProductoLogic.obtenerTipoProducto(id);
if(tipoProducto == null){
 throw new RuntimeException("El tipo producto no existe!");
}
return new TipoProductoDTO(tipoProducto);
}
    /**
     * Metodo HTTP -POST usado para crear un nuevo objeto tipoProducto
     * @param TipoProductoDTO
     * @return TipoProductoDTO
     */
@POST
public TipoProductoDTO createTipoProducto (TipoProductoDTO tipoProductoDTO){
return new TipoProductoDTO(tipoProductoLogic.crearTipoProducto(tipoProductoDTO.toEntity()));
}
   /**
     * Metodo HTTP - PUT permite actualizar un objeto TipoProducto.
     * @param id
     * @param tipoProductoDTO
     * @return 
     */

    @PUT
    @Path("{id: \\d+}")
    public TipoProductoDTO updateTipoProducto(@PathParam("id") Long id, TipoProductoDTO tipoProductoDTO){
        TipoProductoEntity tipoProducto = tipoProductoLogic.obtenerTipoProducto(id);
        if(tipoProducto == null){
            throw new RuntimeException("El tipo producto solicitado no existe!");
        }
        return new TipoProductoDTO(tipoProductoLogic.actualizaTipoProducto(id, tipoProductoDTO.toEntity()));
    }
    /**
     * Metodo HTTP-DELETE usado para eliminar un objeto de tipoProducto
     * @param id 
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteTipoProducto(@PathParam("id") Long id){
        TipoProductoEntity tipoProducto = tipoProductoLogic.obtenerTipoProducto(id);
        if(tipoProducto == null){
            throw new RuntimeException("El tipo producto solicitado no existe!");
        }
        tipoProductoLogic.eliminarTipoProducto(id);
    }    
}
