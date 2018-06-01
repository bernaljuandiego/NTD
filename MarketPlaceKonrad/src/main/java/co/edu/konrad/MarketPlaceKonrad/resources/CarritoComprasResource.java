/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.resources;

import co.edu.konrad.MarketPlaceKonrad.dto.CarritoComprasDTO;
import co.edu.konrad.MarketPlaceKonrad.entities.CarritoComprasEntity;
import co.edu.konrad.MarketPlaceKonrad.logic.CarritoComprasLogic;
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
@Path("/CarritoCompras")
public class CarritoComprasResource {
    @EJB
    private CarritoComprasLogic carritoComprasLogic;
    
    
      /**
     * Metodo HTTP - GET para obtener todos los carritos
     * @return Lista de carritos
     */
    @GET
    public List<CarritoComprasDTO> getCarritosList(){
        List<CarritoComprasEntity> carritos = carritoComprasLogic.obtenerCarritoCompras();
        return CarritoComprasDTO.toCarritoComprasList(carritos);
    }
    
    /**
     * Metodo HTTP-GET obtener un carrito a traves de su id.
     * Hace uso de parametros se usan las anotaciones @Path para 
     * personalizar la ruta de acceso, y @PathParam para indicar
     * cual es el parametro. En el @Path es necesario determinar 
     * una expresion regular que defina el tipo de caracteres que 
     * pueden ingresar en la URI para el parametro configurado.
     * @param id
     * @return carrito
     */
    @GET
    @Path("{id: \\d+}")
    public CarritoComprasDTO getCarrito(@PathParam("id") Long id){
        CarritoComprasEntity carrito = carritoComprasLogic.obtenerCarritoCompras(id);
        if(carrito == null){
            throw new RuntimeException("El carrito de compras esta vacio.");
        }
        return new CarritoComprasDTO(carrito);
    }
    
    /**
     * Metodo HTTP -POST usado para crear un nuevo objeto Carrito
     * @param carritoComprasDTO 
     * @return carrito
     */
    @POST
    public CarritoComprasDTO createCarrito(CarritoComprasDTO carritoComprasDTO){
        return new CarritoComprasDTO(carritoComprasLogic.crearCarritoCompras(carritoComprasDTO.toEntity()));
    }
    
    /**
     * Metodo HTTP - PUT permite actualizar un objeto carrito de compras.
     * OJO: El nombre del parametro pesonalizado en el @Path y el @PathParam
     * deben ser IGUALES.
     * @param id
     * @param usuarioDTO
     * @return 
     */
    @PUT
    @Path("{id: \\d+}")
    public CarritoComprasDTO updateCarritoCompras(@PathParam("id") Long id, CarritoComprasDTO carritoComprasDTO ){
        CarritoComprasEntity entity = carritoComprasLogic.obtenerCarritoCompras(id);
        if(entity == null){
            throw new RuntimeException("El carrito de compras esta vacio.");
        }
        return new CarritoComprasDTO(carritoComprasLogic.actualizarCarritoCompras(id, carritoComprasDTO.toEntity()));
    }
    
    /**
     * Metodo HTTP-DELETE usado para eliminar un objeto de carrito
     * @param id 
     */
    @DELETE
    @Path("{carritoId: \\d+}")
    public void deleteCarrito(@PathParam("carritoId") Long id){
        CarritoComprasEntity entity = carritoComprasLogic.obtenerCarritoCompras(id);
        if(entity == null){
            throw new RuntimeException("El carrito de compras esta vacio.");
        }
        carritoComprasLogic.eliminarCarritoCompras(id);
    }
}
