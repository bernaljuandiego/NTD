/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.resources;

import co.edu.konrad.MarketPlaceKonrad.dto.TipoTarjetaDTO;
import co.edu.konrad.MarketPlaceKonrad.entities.TipoTarjetaEntity;
import co.edu.konrad.MarketPlaceKonrad.logic.TipoTarjetaLogic;
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
 * Servicios REST para TipoTarjeta
 *
 * @author ManuelS
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/tipoTarjeta")
public class TipoTarjetaResource {

    @EJB
    private TipoTarjetaLogic tipoTarjetaLogic;

    @GET
    public List<TipoTarjetaDTO> getTipoTarjetaList() {
        List<TipoTarjetaEntity> tipoTarjetas = tipoTarjetaLogic.obtenerTipoTarjeta();
        return TipoTarjetaDTO.toTipoTarjetaList(tipoTarjetas);
    }

    @GET
    @Path("{id: \\d+}")
    public TipoTarjetaDTO getTipoTarjeta(@PathParam("id") Long id) {
        TipoTarjetaEntity tipoTarjeta = tipoTarjetaLogic.obtenerTipoTarjeta(id);
        if (tipoTarjeta == null) {
            throw new RuntimeException("El tipo de tarjeta solicitado no existe!");
        }
        return new TipoTarjetaDTO(tipoTarjeta);
    }

    @POST
    public TipoTarjetaDTO createTipoTarjeta(TipoTarjetaDTO tipoTarjetaDTO) {
        return new TipoTarjetaDTO(tipoTarjetaLogic.crearTipoTarjeta(tipoTarjetaDTO.toEntity()));
    }

    @PUT
    @Path("{id: \\d+}")
    public TipoTarjetaDTO updateTipoTarjeta(@PathParam("id") Long id , TipoTarjetaDTO tipotarjetadto){
    TipoTarjetaEntity tipoTarjeta = tipoTarjetaLogic.obtenerTipoTarjeta(id);
    if (tipoTarjeta == null){
    throw new RuntimeException("El tipo de tarjeta  a actualizarno existe!");
    }
    return new TipoTarjetaDTO(tipoTarjetaLogic.actualizarTipoTarjeta(id, tipotarjetadto.toEntity()));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteTipoTarjeta(@PathParam("id") Long id) {
        TipoTarjetaEntity tipoTarjeta = tipoTarjetaLogic.obtenerTipoTarjeta(id);
        if (tipoTarjeta == null) {
            throw new RuntimeException("El tipo de tarjeta a eliminar no existe!");
        }
        tipoTarjetaLogic.eliminarTipoTarjeta(id);
    }

}
