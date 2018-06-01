/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.resources;


import co.edu.konrad.MarketPlaceKonrad.dto.CategoriaDTO;
import co.edu.konrad.MarketPlaceKonrad.entities.CategoriaEntity;
import co.edu.konrad.MarketPlaceKonrad.logic.CategoriaLogic;
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
@Path("/categoria")
public class CategoriaResource {

    @EJB
    CategoriaLogic categoriaLogic;
    
    
    @GET
    public List<CategoriaDTO> getCategorias (){
    List<CategoriaEntity> productos = categoriaLogic.obtenerCategorias();
        return CategoriaDTO.toCategoriaList(productos);
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
    public CategoriaDTO getCategoria (@PathParam("id") Long id){
    CategoriaEntity categoria = categoriaLogic.obtenerCategoria(id);
    if(categoria ==  null){
    throw new RuntimeException("La categoria a buscar no existe.");
    }
    return new CategoriaDTO(categoria);
    }
    
    /**
     * Metodo HTTP -POST usado para crear un nuevo objeto Producto
     *
     * @param categoriaCrear
     * @param CategoriaDTO
     * @return CategoriaDTO
     */
    @POST
    public CategoriaDTO createCategoria(CategoriaDTO categoriaCrear){
    return new CategoriaDTO(categoriaLogic.crearCategoria(categoriaCrear.toEntity()));
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
    public CategoriaDTO updateCategoria(@PathParam("id")Long id, CategoriaDTO categoriaActualizar){
    CategoriaEntity categoriaActualizada = categoriaLogic.obtenerCategoria(id);
    if(categoriaActualizada == null){
    throw new RuntimeException("La categoria no existe.");
    }
    return new CategoriaDTO(categoriaLogic.actualizarCategoria(id,categoriaActualizada));
    }
        /**
     * Metodo HTTP-DELETE usado para eliminar un objeto de Categoria
     *
     * @param id
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCategorias(@PathParam("id") Long id) {
        CategoriaEntity categoria = categoriaLogic.obtenerCategoria(id);
        if (categoria == null) {
            throw new RuntimeException("La categoria a borrar no existe.");
        }
        categoriaLogic.eliminarCategoria(id);
    }

}