/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.resources;

import co.edu.konrad.MarketPlaceKonrad.entities.MarcaEntity;
import co.edu.konrad.MarketPlaceKonrad.logic.MarcaLogic;
import co.edu.konrad.MarketPlaceKonrad.dto.MarcaDTO;
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
@Path("/marcas")
public class MarcaResource {

    @EJB
    private MarcaLogic marcaLogic; /**
             *
             * @return
             */

    @GET
    public List<MarcaDTO> getMarcaList() {
        List<MarcaEntity> marcas = marcaLogic.obtenerMarcas();
        return MarcaDTO.toMarcaList(marcas);
    }

    /**
     * Metodo HTTP-GET obtener un proovedor a traves de su id. Hace uso de
     * parametros se usan las anotaciones @Path para personalizar la ruta de
     * acceso, y @PathParam para indicar cual es el parametro. En el @Path es
     * necesario determinar una expresion regular que defina el tipo de
     * caracteres que pueden ingresar en la URI para el parametro configurado.
     *
     * @param id
     * @return Marca
     */
    @GET
    @Path("{id: \\d+}")
    public MarcaDTO getMarca(@PathParam("id") Long id) {
        MarcaEntity marca = marcaLogic.obtenerMarca(id);
        if (marca == null) {
            throw new RuntimeException("La marca no existe.");
        }
        return new MarcaDTO(marca);
    }

    /**
     * Metodo HTTP -POST usado para crear un nuevo objeto Proovedor
     *
     * @param proovedorDTO
     * @return proovedorDTO
     */
    @POST
    public MarcaDTO createMarca(MarcaDTO marca) {
        return new MarcaDTO(marcaLogic.crearMarcar(marca.toEntity()));
    }

    /**
     * Metodo HTTP - PUT permite actualizar un objeto Proovedor. OJO: El nombre
     * del parametro pesonalizado en el @Path y el @PathParam deben ser IGUALES.
     *
     * @param id
     * @param proovedorDTO
     * @return
     */
    @PUT
    @Path("{id: \\d+}")
    public MarcaDTO actualizarMarca(@PathParam("id") Long id, MarcaDTO marcaActualizar) {
        MarcaEntity marcaActualizada = marcaLogic.obtenerMarca(id);
        if (marcaActualizada == null) {
            throw new RuntimeException("La marca solicitada no existe.");
        }
        return new MarcaDTO(marcaLogic.actualizarMarca(id, marcaActualizada));
    }

    /**
     * Metodo HTTP-DELETE usado para eliminar un objeto de Proovedor
     *
     * @param id
     */
    @DELETE
    @Path("{id: \\d+}")
    public void borrarMarca(@PathParam("id") Long id) {
        MarcaEntity marca = marcaLogic.obtenerMarca(id);
        if (marca == null) {
            throw new RuntimeException("La marca a borrar no existe.");
        }
        marcaLogic.eliminarMarca(id);
    }
}


