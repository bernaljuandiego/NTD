/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.logic;

import co.edu.konrad.MarketPlaceKonrad.entities.CompraEntity;
import co.edu.konrad.MarketPlaceKonrad.persistence.CompraPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author juandiego
 */
@Stateless
public class CompraLogic {
    /**
     * Declaracion de la injeccion en la clase comprasPersistence
     */
    @Inject
    CompraPersistence compraPersistence;

    /**
     * @return marcas Metodo que genera la peticion de una Lista con Objetos de
     * una Entity
     */
    public List<CompraEntity> obtenerCompras() {
        List<CompraEntity> listCompras = compraPersistence.findAll();
        return listCompras;
    }

    /**
     * Metodo que genera la peticion de un Objeto tipo Entity identificando por
     * su id
     *
     * @param id
     */
    public CompraEntity obtenerCompra(Long id) {
        CompraEntity compra = compraPersistence.find(id);
        if (compra == null) {
            throw new IllegalArgumentException("la compra no existe!");
        }
        return compra;
    }

    /**
     * Metodo que genera la peticion para crear un Objeto tipo Entity
     */
    public CompraEntity crearCompra(CompraEntity compra) {
        CompraEntity compraEntity = compraPersistence.create(compra);
        return compraEntity;
    }

    /**
     * Metodo que genera la peticion de actualizar una Objeto tipo Entity con
     * otros datos
     */
    public CompraEntity actualizarCompra(Long id, CompraEntity compraEntity) {
        CompraEntity compras = compraPersistence.update(compraEntity);
        return compras;
    }

    /**
     * Metodo que genera la peticion de borrar un Objeto tipo Entity
     *
     */
    public void eliminarCompra(Long id) {
        compraPersistence.delete(id);
    }
}
