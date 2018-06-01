/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.resources;

import co.edu.konrad.MarketPlaceKonrad.dto.CompraDTO;
import co.edu.konrad.MarketPlaceKonrad.entities.CompraEntity;
import co.edu.konrad.MarketPlaceKonrad.logic.CompraLogic;
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
@Path("/Compra")
public class CompraResource {
    @EJB
    private CompraLogic compraLogic;
    
    
      /**
     * Metodo HTTP - GET para obtener todas las compras
     * @return Lista de compras
     */
    @GET
    public List<CompraDTO> getComprasList(){
        List<CompraEntity> compras = compraLogic.obtenerCompras();
        return CompraDTO.toCompraList(compras);
    }
    
    /**
     * Metodo HTTP-GET obtener un compra a traves de su id.
     * Hace uso de parametros se usan las anotaciones @Path para 
     * personalizar la ruta de acceso, y @PathParam para indicar
     * cual es el parametro. En el @Path es necesario determinar 
     * una expresion regular que defina el tipo de caracteres que 
     * pueden ingresar en la URI para el parametro configurado.
     * @param id
     * @return compra
     */
    @GET
    @Path("{id: \\d+}")
    public CompraDTO getCompra(@PathParam("id") Long id){
        CompraEntity compra = compraLogic.obtenerCompra(id);
        if(compra == null){
            throw new RuntimeException("El compra no existe.");
        }
        return new CompraDTO(compra);
    }
    
    /**
     * Metodo HTTP -POST usado para crear un nuevo objeto compra
     * @param compraComprasDTO
     * @param ComprasDTO 
     * @return compra
     */
    @POST
    public CompraDTO createCompra(CompraDTO compraDTO){
        return new CompraDTO(compraLogic.crearCompra(compraDTO.toEntity()));
    }
    
    /**
     * Metodo HTTP - PUT permite actualizar un objeto compra de compras.
     * OJO: El nombre del parametro pesonalizado en el @Path y el @PathParam
     * deben ser IGUALES.
     * @param id
     * @param compraDTO 
     * @return 
     */
    @PUT
    @Path("{id: \\d+}")
    public CompraDTO updateCompras(@PathParam("id") Long id, CompraDTO compraDTO ){
        CompraEntity entity = compraLogic.obtenerCompra(id);
        if(entity == null){
            throw new RuntimeException("la compra no existe.");
        }
        return new CompraDTO(compraLogic.actualizarCompra(id, compraDTO.toEntity()));
    }
    
    /**
     * Metodo HTTP-DELETE usado para eliminar un objeto de compra
     * @param id 
     */
    @DELETE
    @Path("{compraId: \\d+}")
    public void deleteCompra(@PathParam("compraId") Long id){
        CompraEntity entity = compraLogic.obtenerCompra(id);
        if(entity == null){
            throw new RuntimeException("la compra no existe.");
        }
        compraLogic.eliminarCompra(id);
    }
}
