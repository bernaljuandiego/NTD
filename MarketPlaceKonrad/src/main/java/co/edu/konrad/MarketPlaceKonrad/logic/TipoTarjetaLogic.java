/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.logic;

import co.edu.konrad.MarketPlaceKonrad.entities.TipoTarjetaEntity;
import co.edu.konrad.MarketPlaceKonrad.persistence.TipoTarjetaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author juandiego
 */
@Stateless
public class TipoTarjetaLogic {
    /**
     * Declaracion de la injeccion en la clase tipoTarjetaPersistence
     */
    @Inject
    TipoTarjetaPersistence tipoTarjetaPersistence;

    /**
     * @return marcas Metodo que genera la peticion de una Lista con Objetos de
     * una Entity
     */
    public List<TipoTarjetaEntity> obtenerTipoTarjeta() {
        List<TipoTarjetaEntity> tiposTarjeta = tipoTarjetaPersistence.findAll();
        return tiposTarjeta;
    }

    /**
     * Metodo que genera la peticion de un Objeto tipo Entity identificando por
     * su id
     *
     * @param id
     */
    public TipoTarjetaEntity obtenerTipoTarjeta(Long id) {
        TipoTarjetaEntity tipoTarjeta = tipoTarjetaPersistence.find(id);
        if (tipoTarjeta == null) {
            throw new IllegalArgumentException("el tipo de tarjeta no existe.");
        }
        return tipoTarjeta;
    }

    /**
     * Metodo que genera la peticion para crear un Objeto tipo Entity
     */
    public TipoTarjetaEntity crearTipoTarjeta(TipoTarjetaEntity tipoTarjetaNueva) {
        TipoTarjetaEntity tipoTarjetaNuevo = tipoTarjetaPersistence.create(tipoTarjetaNueva);
        return tipoTarjetaNuevo;
    }

    /**
     * Metodo que genera la peticion de actualizar una Objeto tipo Entity con
     * otros datos
     */
    public TipoTarjetaEntity actualizarTipoTarjeta(Long id, TipoTarjetaEntity tipoTarjetaActualizar) {
        TipoTarjetaEntity tipoTarjetaActualizado = tipoTarjetaPersistence.update(tipoTarjetaActualizar);
        return tipoTarjetaActualizado;
    }

    /**
     * Metodo que genera la peticion de borrar un Objeto tipo Entity
     *
     */
    public void eliminarTipoTarjeta(Long id) {
        tipoTarjetaPersistence.delete(id);
    }
}
