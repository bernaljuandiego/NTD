/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.logic;

import co.edu.konrad.MarketPlaceKonrad.entities.ProductoEntity;
import co.edu.konrad.MarketPlaceKonrad.persistence.ProductoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Inyeccion, uso de metodos, constructor and other de la <<Persistence>> de
 * Producto. Controlador de petiticiones
 *
 * @author Manuel S. Nino
 */
@Stateless
public class ProductoLogic {

    /**
     * Declaracion de la injeccion en la clase ProductoPersistence
     */
    @Inject
    ProductoPersistence productoPersistence;

    /**
     * @return marcas Metodo que genera la peticion de una Lista con Objetos de
     * una Entity
     */
    public List<ProductoEntity> obtenerProductos() {
        List<ProductoEntity> productos = productoPersistence.findAll();
        return productos;
    }

    /**
     * Metodo que genera la peticion de un Objeto tipo Entity identificando por
     * su id
     *
     * @param id
     */
    public ProductoEntity obtenerProducto(Long id) {
        ProductoEntity producto = productoPersistence.find(id);
        if (producto == null) {
            throw new IllegalArgumentException("El producto no se encuentra regisrado.");
        }
        return producto;
    }

    /**
     * Metodo que genera la peticion para crear un Objeto tipo Entity
     */
    public ProductoEntity crearProducto(ProductoEntity nuevoProducto) {
        productoPersistence.create(nuevoProducto);
        return nuevoProducto;
    }

    /**
     * Metodo que genera la peticion de actualizar una Objeto tipo Entity con
     * otros datos
     */
    public ProductoEntity actualizarProducto(ProductoEntity productoAtualizar) {
        ProductoEntity productoActualizado = productoPersistence.update(productoAtualizar);
        return productoActualizado;
    }

    /**
     * Metodo que genera la peticion de borrar un Objeto tipo Entity con su id
     *
     */
    public void eliminarProducto(Long id) {
        productoPersistence.delete(id);
    }
}
