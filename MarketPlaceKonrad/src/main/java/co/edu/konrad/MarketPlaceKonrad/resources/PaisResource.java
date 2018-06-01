/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.resources;


import co.edu.konrad.MarketPlaceKonrad.dto.PaisDTO;
import co.edu.konrad.MarketPlaceKonrad.entities.PaisEntity;
import co.edu.konrad.MarketPlaceKonrad.logic.PaisLogic;
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
 * Servicio REST para el manejo de paises
 * @author Leonardo Ruiz
 * 
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/Paises")
public class PaisResource {
    
    @EJB
    private PaisLogic paislogic;
    
    
    /**
     * Metodo HTTP - GET para obtener todos los paises
     * @return Lista de paises
     */
    @GET
    public List<PaisDTO> getPaisList(){
        List<PaisEntity> Paises = paislogic.obtenerPaises();
        return PaisDTO.ToPaisList(Paises);
    }
    
    /**
     * Metodo HTTP-GET obtener un Pais a traves de su id.
     * Hace uso de parametros se usan las anotaciones @Path para 
     * personalizar la ruta de acceso, y @PathParam para indicar
     * cual es el parametro. En el @Path es necesario determinar 
     * una expresion regular que defina el tipo de caracteres que 
     * pueden ingresar en la URI para el parametro configurado.
     * @param id
     * @return pais
     */
    @GET
    @Path("{id: \\d+}")
    public PaisDTO getPais(@PathParam("id") Long id){
        PaisEntity pais = paislogic.obtenerPais(id);
        if(pais == null){
            throw new RuntimeException("El pais solicitado no existe.");
        }
        return new PaisDTO(pais);
    }
    
    /**
     * Metodo HTTP -POST usado para crear un nuevo objeto Pais
     * @param paisDTO
     * @return paisDTO
     */
    @POST
    public PaisDTO createPais(PaisDTO paisDTO){
        return new PaisDTO(paislogic.crearPais(paisDTO.toEntity()));
    }
    
    /**
     * Metodo HTTP - PUT permite actualizar un objeto Pais.
     * OJO: El nombre del parametro pesonalizado en el @Path y el @PathParam
     * deben ser IGUALES.
     * @param id
     * @param paisDTO
     * @return 
     */
    @PUT
    @Path("{id: \\d+}")
    public PaisDTO updatePais(@PathParam("id") Long id, PaisDTO paisDTO ){
        PaisEntity entity = paislogic.obtenerPais(id);
        if(entity == null){
            throw new RuntimeException("El pais solicitado no existe.");
        }
        return new PaisDTO(paislogic.actualizarPais(id, paisDTO.toEntity()));
    }
    
    /**
     * Metodo HTTP-DELETE usado para eliminar un objeto de Pais
     * @param id 
     */
    @DELETE
    @Path("{paisId: \\d+}")
    public void deleteTipoDocumento(@PathParam("paisId") Long id){
        PaisEntity entity = paislogic.obtenerPais(id);
        if(entity == null){
            throw new RuntimeException("El pais solicitado no existe.");
        }
        paislogic.eliminarPais(id);
    }
    
}
