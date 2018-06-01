/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.resources;

import co.edu.konrad.MarketPlaceKonrad.dto.ProductoDTO;
import co.edu.konrad.MarketPlaceKonrad.entities.ProductoEntity;
import co.edu.konrad.MarketPlaceKonrad.logic.ProductoLogic;
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
 * Se define el tipo de medio por el cual pasan los datos y direccion Path
 *
 * @author Manuel S. Nino
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/producto")
public class ProductoResource {
    
    @EJB
    ProductoLogic productoLogic;
    
     @GET
    public List<ProductoDTO> getProductos (){
    List<ProductoEntity> productos = productoLogic.obtenerProductos();
        return ProductoDTO.toProductoList(productos);
    }
    
        /**
     * Metodo HTTP-GET obtener un proovedor a traves de su id. Hace uso de
     * parametros se usan las anotaciones @Path para personalizar la ruta de
     * acceso, y @PathParam para indicar cual es el parametro. En el @Path es
     * necesario determinar una expresion regular que defina el tipo de
     * caracteres que pueden ingresar en la URI para el parametro configurado.
     *
     * @param id
     * @return 
     */
    @GET
    @Path("{id: \\d+}")
    public ProductoDTO getProducto (@PathParam("id") Long id){
    ProductoEntity producto = productoLogic.obtenerProducto(id);
    if(producto ==  null){
    throw new RuntimeException("El producto a buscar no existe.");
    }
    return new ProductoDTO(producto);
    }
    
    /**
     * Metodo HTTP -POST usado para crear un nuevo objeto Producto
     *
     * @param productoCrear
     * @param productoDTO
     * @return productoDTO
     */
    @POST
    public ProductoDTO createProducto(ProductoDTO productoCrear){
    return new ProductoDTO(productoLogic.crearProducto(productoCrear.toEntity()));
    }
     /**
     * Metodo HTTP - PUT permite actualizar un objeto Proovedor. OJO: El nombre
     * del parametro pesonalizado en el @Path y el @PathParam deben ser IGUALES.
     *
     * @param id
     * @param 
     * @return
     */
    @PUT
    @Path("{id: \\d+}")
    public ProductoDTO updateProducto(@PathParam("id")Long id, ProductoDTO productoActualizar){
    ProductoEntity productoActualizado = productoLogic.obtenerProducto(id);
    if(productoActualizado == null){
    throw new RuntimeException("El producto no existe.");
    }
    return new ProductoDTO(productoLogic.actualizarProducto(productoActualizado));
    }
        /**
     * Metodo HTTP-DELETE usado para eliminar un objeto de Proovedor
     *
     * @param id
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteProducto(@PathParam("id") Long id) {
        ProductoEntity producto = productoLogic.obtenerProducto(id);
        if (producto == null) {
            throw new RuntimeException("El producto a borrar no existe.");
        }
        productoLogic.eliminarProducto(id);
    }
}
