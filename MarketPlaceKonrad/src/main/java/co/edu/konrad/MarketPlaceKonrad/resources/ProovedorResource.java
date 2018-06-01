/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.resources;

import co.edu.konrad.MarketPlaceKonrad.dto.ProovedorDTO;

import co.edu.konrad.MarketPlaceKonrad.entities.ProovedorEntity;

import co.edu.konrad.MarketPlaceKonrad.logic.ProovedorLogic;
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
 *Servicio REST para el manejo de proovedores
 * @author Leonardo Ruiz
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/proovedores")
public class ProovedorResource {
    
    
    @EJB
    private ProovedorLogic proovedorlogic;
    
    
    /**
     * Metodo HTTP - GET para obtener todos los proovedores
     * @return Lista de proovedores
     */
    @GET
    public List<ProovedorDTO> getProovedorList(){
        List<ProovedorEntity> proovedores = proovedorlogic.obtenerProovedores();
        return ProovedorDTO.toProovedorList(proovedores);
    }
    
    /**
     * Metodo HTTP-GET obtener un proovedor a traves de su id.
     * Hace uso de parametros se usan las anotaciones @Path para 
     * personalizar la ruta de acceso, y @PathParam para indicar
     * cual es el parametro. En el @Path es necesario determinar 
     * una expresion regular que defina el tipo de caracteres que 
     * pueden ingresar en la URI para el parametro configurado.
     * @param id
     * @return proovedor
     */
    @GET
    @Path("{id: \\d+}")
    public ProovedorDTO getProovedor(@PathParam("id") Long id){
        ProovedorEntity proovedor= proovedorlogic.obtenerProovedor(id);
        if(proovedor == null){
            throw new RuntimeException("el proovedor solicitado no existe.");
        }
        return new ProovedorDTO(proovedor);
    }
    
    /**
     * Metodo HTTP -POST usado para crear un nuevo objeto Proovedor
     * @param proovedorDTO
     * @return proovedorDTO
     */
    @POST
    public ProovedorDTO createProovedor(ProovedorDTO proovedorDTO){
        return new ProovedorDTO(proovedorlogic.crearProovedor(proovedorDTO.toEntity()));
    }
    
    /**
     * Metodo HTTP - PUT permite actualizar un objeto Proovedor.
     * OJO: El nombre del parametro pesonalizado en el @Path y el @PathParam
     * deben ser IGUALES.
     * @param id
     * @param proovedorDTO
     * @return 
     */
    @PUT
    @Path("{id: \\d+}")
    public ProovedorDTO updateProovedor(@PathParam("id") Long id, ProovedorDTO proovedorDTO ){
        ProovedorEntity entity = proovedorlogic.obtenerProovedor(id);
        if(entity == null){
            throw new RuntimeException("El proovedor solicitado no existe.");
        }
        return new ProovedorDTO(proovedorlogic.actualizarProovedor(id, proovedorDTO.toEntity()));
    }
    
    /**
     * Metodo HTTP-DELETE usado para eliminar un objeto de Proovedor
     * @param id 
     */
    @DELETE
    @Path("{proovedorId: \\d+}")
    public void deleteResidencia(@PathParam("proovedorId") Long id){
        ProovedorEntity entity = proovedorlogic.obtenerProovedor(id);
        if(entity == null){
            throw new RuntimeException("El proovedor solicitado no existe.");
        }
        proovedorlogic.eliminarProovedor(id);
    }
    
}
