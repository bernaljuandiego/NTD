/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.resources;


import co.edu.konrad.MarketPlaceKonrad.dto.ResidenciaDTO;
import co.edu.konrad.MarketPlaceKonrad.entities.ResidenciaEntity;
import co.edu.konrad.MarketPlaceKonrad.logic.ResidenciaLogic;
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
 *Servicio REST para el manejo de residencias
 * @author Leonardo Ruiz
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/residencias")
public class ResidenciaResource {
    
    @EJB
    private ResidenciaLogic residencialogic;
    
    
    
    /**
     * Metodo HTTP - GET para obtener todas las residencias
     * @return Lista de residencias
     */
    @GET
    public List<ResidenciaDTO> getResidenciaList(){
        List<ResidenciaEntity> residencias = residencialogic.obtenerResidencias();
        return ResidenciaDTO.toResidenciaList(residencias);
    }
    
    /**
     * Metodo HTTP-GET obtener una residencia a traves de su id.
     * Hace uso de parametros se usan las anotaciones @Path para 
     * personalizar la ruta de acceso, y @PathParam para indicar
     * cual es el parametro. En el @Path es necesario determinar 
     * una expresion regular que defina el tipo de caracteres que 
     * pueden ingresar en la URI para el parametro configurado.
     * @param id
     * @return residencia
     */
    @GET
    @Path("{id: \\d+}")
    public ResidenciaDTO getResidencia(@PathParam("id") Long id){
        ResidenciaEntity residence= residencialogic.obtenerResidencia(id);
        if(residence == null){
            throw new RuntimeException("la residencia solicitada no existe.");
        }
        return new ResidenciaDTO(residence);
    }
    
    /**
     * Metodo HTTP -POST usado para crear un nuevo objeto Residencia
     * @param residenceDTO
     * @return residenceDTO
     */
    @POST
    public ResidenciaDTO createResidencia(ResidenciaDTO residenceDTO){
        return new ResidenciaDTO(residencialogic.crearResidencia(residenceDTO.toEntity()));
    }
    
    /**
     * Metodo HTTP - PUT permite actualizar un objeto Residencia.
     * OJO: El nombre del parametro pesonalizado en el @Path y el @PathParam
     * deben ser IGUALES.
     * @param id
     * @param residenceDTO
     * @return 
     */
    @PUT
    @Path("{id: \\d+}")
    public ResidenciaDTO updateResidencia(@PathParam("id") Long id, ResidenciaDTO residenceDTO ){
        ResidenciaEntity entity = residencialogic.obtenerResidencia(id);
        if(entity == null){
            throw new RuntimeException("La residencia solicitada no existe.");
        }
        return new ResidenciaDTO(residencialogic.actualizarResidencia(id, residenceDTO.toEntity()));
    }
    
    /**
     * Metodo HTTP-DELETE usado para eliminar un objeto de Residencia
     * @param id 
     */
    @DELETE
    @Path("{residenciaId: \\d+}")
    public void deleteResidencia(@PathParam("residenciaId") Long id){
        ResidenciaEntity entity = residencialogic.obtenerResidencia(id);
        if(entity == null){
            throw new RuntimeException("La residencia solicitada no existe.");
        }
        residencialogic.eliminarResidencia(id);
    }
    
}
