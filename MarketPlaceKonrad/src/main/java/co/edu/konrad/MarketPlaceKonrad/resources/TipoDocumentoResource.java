/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.resources;



import co.edu.konrad.MarketPlaceKonrad.dto.TipoDocumentoDTO;
import co.edu.konrad.MarketPlaceKonrad.entities.TipoDocumentoEntity;
import co.edu.konrad.MarketPlaceKonrad.logic.TipoDocumentoLogic;
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
 *Servicio RESST para el manejo de tipo de documentos
 * @author Leonardo Ruiz 
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/TiposDocumento")
public class TipoDocumentoResource {
    
    
    @EJB
    private TipoDocumentoLogic tipodocumentologic;
    
    
    
     /**
     * Metodo HTTP - GET para obtener todos los tipos de documento
     * @return Lista de tipos de documento
     */
    @GET
    public List<TipoDocumentoDTO> getTipoDocumentoList(){
        List<TipoDocumentoEntity> tiposDoc = tipodocumentologic.obtenerTiposDocumento();
        return TipoDocumentoDTO.toTipoDocumentoList(tiposDoc);
    }
    
    /**
     * Metodo HTTP-GET obtener un tipo de Documento a traves de su id.
     * Hace uso de parametros se usan las anotaciones @Path para 
     * personalizar la ruta de acceso, y @PathParam para indicar
     * cual es el parametro. En el @Path es necesario determinar 
     * una expresion regular que defina el tipo de caracteres que 
     * pueden ingresar en la URI para el parametro configurado.
     * @param id
     * @return tipo De documento
     */
    @GET
    @Path("{id: \\d+}")
    public TipoDocumentoDTO getTipoDocumento(@PathParam("id") Long id){
        TipoDocumentoEntity tipo = tipodocumentologic.obtenerTipoDocumento(id);
        if(tipo == null){
            throw new RuntimeException("El tipo de documento solicitado no existe.");
        }
        return new TipoDocumentoDTO(tipo);
    }
    
    /**
     * Metodo HTTP -POST usado para crear un nuevo objeto tipoDocumento
     * @param tipoDocDTO
     * @return tipoDocDTO
     */
    @POST
    public TipoDocumentoDTO createTipoDocumento(TipoDocumentoDTO tipoDocDTO){
        return new TipoDocumentoDTO(tipodocumentologic.crearTipoDocumento(tipoDocDTO.toEntity()));
    }
    
    /**
     * Metodo HTTP - PUT permite actualizar un objeto tipoDocumento.
     * OJO: El nombre del parametro pesonalizado en el @Path y el @PathParam
     * deben ser IGUALES.
     * @param id
     * @param tipoDocDTO
     * @return 
     */
    @PUT
    @Path("{id: \\d+}")
    public TipoDocumentoDTO updateTipoDocumento(@PathParam("id") Long id, TipoDocumentoDTO tipoDocDTO ){
        TipoDocumentoEntity entity = tipodocumentologic.obtenerTipoDocumento(id);
        if(entity == null){
            throw new RuntimeException("El tipo de documento solicitado no existe.");
        }
        return new TipoDocumentoDTO(tipodocumentologic.actualizarTipoDocumento(id, tipoDocDTO.toEntity()));
    }
    
    /**
     * Metodo HTTP-DELETE usado para eliminar un objeto de TipoDocumento
     * @param id 
     */
    @DELETE
    @Path("{tipoDocumentoId: \\d+}")
    public void deleteTipoDocumento(@PathParam("tipoDocumentoId") Long id){
        TipoDocumentoEntity entity = tipodocumentologic.obtenerTipoDocumento(id);
        if(entity == null){
            throw new RuntimeException("El tipo de documento solicitado no existe.");
        }
        tipodocumentologic.eliminarTipoDocumento(id);
    }
}
