/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.resources;

import co.edu.konrad.MarketPlaceKonrad.dto.CiudadDTO;
import co.edu.konrad.MarketPlaceKonrad.entities.CiudadEntity;
import co.edu.konrad.MarketPlaceKonrad.logic.CiudadLogic;
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
 *Servicio REST para el manejo de ciudades
 * @author Leonardo Ruiz
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/ciudades")
public class CiudadResource {
    
    @EJB
   private CiudadLogic ciudadlogic;
    
    
     /**
     * Metodo HTTP - GET para obtener todas las ciudades
     * @return Lista de ciudades
     */
    @GET
    public List<CiudadDTO> getCiudadList(){
        List<CiudadEntity> ciudades = ciudadlogic.obtenerCiudades();
        return CiudadDTO.toCiudadList(ciudades);
    }
    
    /**
     * Metodo HTTP-GET obtener una ciudad a traves de su id.
     * Hace uso de parametros se usan las anotaciones @Path para 
     * personalizar la ruta de acceso, y @PathParam para indicar
     * cual es el parametro. En el @Path es necesario determinar 
     * una expresion regular que defina el tipo de caracteres que 
     * pueden ingresar en la URI para el parametro configurado.
     * @param id
     * @return ciudad
     */
    @GET
    @Path("{id: \\d+}")
    public CiudadDTO getCiudad(@PathParam("id") Long id){
        CiudadEntity city = ciudadlogic.obtenerCiudad(id);
        if(city == null){
            throw new RuntimeException("la ciudad solicitada no existe.");
        }
        return new CiudadDTO(city);
    }
    
    /**
     * Metodo HTTP -POST usado para crear un nuevo objeto Ciudad
     * @param cityDTO
     * @return cityDTO
     */
    @POST
    public CiudadDTO createCiudad(CiudadDTO cityDTO){
        return new CiudadDTO(ciudadlogic.crearCiudad(cityDTO.toEntity()));
    }
    
    /**
     * Metodo HTTP - PUT permite actualizar un objeto Ciudad.
     * OJO: El nombre del parametro pesonalizado en el @Path y el @PathParam
     * deben ser IGUALES.
     * @param id
     * @param cityDTO
     * @return 
     */
    @PUT
    @Path("{id: \\d+}")
    public CiudadDTO updateCiudad(@PathParam("id") Long id, CiudadDTO cityDTO ){
        CiudadEntity entity = ciudadlogic.obtenerCiudad(id);
        if(entity == null){
            throw new RuntimeException("La ciudad solicitada no existe.");
        }
        return new CiudadDTO(ciudadlogic.actualizarCiudad(id, cityDTO.toEntity()));
    }
    
    /**
     * Metodo HTTP-DELETE usado para eliminar un objeto de Ciudad
     * @param id 
     */
    @DELETE
    @Path("{ciudadId: \\d+}")
    public void deleteCiudad(@PathParam("ciudadId") Long id){
        CiudadEntity entity = ciudadlogic.obtenerCiudad(id);
        if(entity == null){
            throw new RuntimeException("La ciudad solicitada no existe.");
        }
        ciudadlogic.eliminarCiudad(id);
    }
    
}
