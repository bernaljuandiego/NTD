/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.resources;

import co.edu.konrad.MarketPlaceKonrad.dto.TarjetaUsuarioDTO;
import co.edu.konrad.MarketPlaceKonrad.entities.TarjetaUsuarioEntity;
import co.edu.konrad.MarketPlaceKonrad.logic.TarjetaUsuarioLogic;
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
 *
 * @author juandiego
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/TarjetasUsuario")
public class TarjetaUsuarioResource {
    @EJB
    private TarjetaUsuarioLogic tarjetaUsuarioLogic;
    
    
      /**
     * Metodo HTTP - GET para obtener todas las tarjetas
     * @return Lista de tarjetas
     */
    @GET
    public List<TarjetaUsuarioDTO> getTarjetasList(){
        List<TarjetaUsuarioEntity> tarjetas = tarjetaUsuarioLogic.obtenerTarjetaUsuario();
        return TarjetaUsuarioDTO.toTarjetaUsuarioList(tarjetas);
    }
    
    /**
     * Metodo HTTP-GET obtener una tarjeta a traves de su id.
     * Hace uso de parametros se usan las anotaciones @Path para 
     * personalizar la ruta de acceso, y @PathParam para indicar
     * cual es el parametro. En el @Path es necesario determinar 
     * una expresion regular que defina el tipo de caracteres que 
     * pueden ingresar en la URI para el parametro configurado.
     * @param id
     * @return tarjeta
     */
    @GET
    @Path("{id: \\d+}")
    public TarjetaUsuarioDTO getTarjetaUsuario(@PathParam("id") Long id){
        TarjetaUsuarioEntity tarjeta = tarjetaUsuarioLogic.obtenerTarjetaUsuario(id);
        if(tarjeta == null){
            throw new RuntimeException("la tarjeta no existe.");
        }
        return new TarjetaUsuarioDTO(tarjeta);
    }
    
    /**
     * Metodo HTTP -POST usado para crear un nuevo objeto tarjeta
     * @param tarjetaComprasDTO
     * @param tarjetaDTO  
     * @return tarjeta
     */
    @POST
    public TarjetaUsuarioDTO createTarjeta(TarjetaUsuarioDTO tarjetaDTO){
        return new TarjetaUsuarioDTO(tarjetaUsuarioLogic.crearTarjetaUsuario(tarjetaDTO.toEntity()));
    }
    
    /**
     * Metodo HTTP - PUT permite actualizar un objeto tarjeta .
     * OJO: El nombre del parametro pesonalizado en el @Path y el @PathParam
     * deben ser IGUALES.
     * @param id
     * @param tarjetaDTO 
     * @return 
     */
    @PUT
    @Path("{id: \\d+}")
    public TarjetaUsuarioDTO updateTarjetaUsuario(@PathParam("id") Long id, TarjetaUsuarioDTO tarjetaDTO ){
        TarjetaUsuarioEntity entity = tarjetaUsuarioLogic.obtenerTarjetaUsuario(id);
        if(entity == null){
            throw new RuntimeException("la tarjeta no existe.");
        }
        return new TarjetaUsuarioDTO(tarjetaUsuarioLogic.actualizarTarjetaUsuario(id, tarjetaDTO.toEntity()));
    }
    
    /**
     * Metodo HTTP-DELETE usado para eliminar un objeto de tarjeta
     * @param id 
     */
    @DELETE
    @Path("{tarjetaId: \\d+}")
    public void deleteTarjetaUsuario(@PathParam("tarjetaId") Long id){
        TarjetaUsuarioEntity entity = tarjetaUsuarioLogic.obtenerTarjetaUsuario(id);
        if(entity == null){
            throw new RuntimeException("la tarjeta no existe.");
        }
        tarjetaUsuarioLogic.eliminarTarjeta(id);
    }
}
