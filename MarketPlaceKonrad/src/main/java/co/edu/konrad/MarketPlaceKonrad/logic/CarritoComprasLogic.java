/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.logic;

import co.edu.konrad.MarketPlaceKonrad.entities.CarritoComprasEntity;
import co.edu.konrad.MarketPlaceKonrad.persistence.CarritoComprasPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author juandiego
 */
@Stateless
public class CarritoComprasLogic {
    /**
     * Declaracion de la injeccion en la clase carritoComprasPersistence
     */
    @Inject
    CarritoComprasPersistence carritoComprasPersistence;

    /**
     * @return marcas Metodo que genera la peticion de una Lista con Objetos de
     * una Entity
     */
    public List<CarritoComprasEntity> obtenerCarritoCompras() {
        List<CarritoComprasEntity> listCarritoCompras = carritoComprasPersistence.findAll();
        return listCarritoCompras;
    }

    /**
     * Metodo que genera la peticion de un Objeto tipo Entity identificando por
     * su id
     *
     * @param id
     */
    public CarritoComprasEntity obtenerCarritoCompras(Long id) {
        CarritoComprasEntity carritoCompras = carritoComprasPersistence.find(id);
        if (carritoCompras == null) {
            throw new IllegalArgumentException("el carrito esta vacio!");
        }
        return carritoCompras;
    }

    /**
     * Metodo que genera la peticion para crear un Objeto tipo Entity
     */
    public CarritoComprasEntity crearCarritoCompras(CarritoComprasEntity carritoCompras) {
        CarritoComprasEntity carritoComprasEntity = carritoComprasPersistence.create(carritoCompras);
        return carritoComprasEntity;
    }

    /**
     * Metodo que genera la peticion de actualizar una Objeto tipo Entity con
     * otros datos
     */
    public CarritoComprasEntity actualizarCarritoCompras(Long id, CarritoComprasEntity carritoComprasEntity) {
        CarritoComprasEntity carritoCompras = carritoComprasPersistence.update(carritoComprasEntity);
        return carritoCompras;
    }

    /**
     * Metodo que genera la peticion de borrar un Objeto tipo Entity
     *
     */
    public void eliminarCarritoCompras(Long id) {
        carritoComprasPersistence.delete(id);
    }
}
