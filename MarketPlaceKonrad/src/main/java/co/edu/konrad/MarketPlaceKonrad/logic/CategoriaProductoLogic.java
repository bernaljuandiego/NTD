/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.logic;

import co.edu.konrad.MarketPlaceKonrad.entities.CategoriaProductoEntity;
import co.edu.konrad.MarketPlaceKonrad.persistence.CategoriaProductoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Inyeccion, uso de metodos, constructor and other de la <<Persistence>> de
 * CategoriaProducto. Controlador de petiticiones
 *
 * @author Manuel S. Nino
 */
@Stateless
public class CategoriaProductoLogic {

    /**
     * Declaracion de la injeccion en la clase CategoriaMPersistence
     */
    @Inject
    CategoriaProductoPersistence categoriaProductoPersistence;

    /**
     * @return marcas Metodo que genera la peticion de una Lista con Objetos de
     * una Entity
     */
    public List<CategoriaProductoEntity> obtenerCategoriaProductos() {
        List<CategoriaProductoEntity> categoriaProductos = categoriaProductoPersistence.findAll();
        return categoriaProductos;
    }

    /**
     * Metodo que genera la peticion de un Objeto tipo Entity identificando por
     * su id
     *
     * @param id
     */
    public CategoriaProductoEntity obtenerCategoriaProducto(Long id) {
        CategoriaProductoEntity categoriaProducto = categoriaProductoPersistence.find(id);
        if (categoriaProducto == null) {
            throw new IllegalArgumentException("La categoria producto no esta registrada.");
        }
        return categoriaProducto;
    }

    /**
     * Metodo que genera la peticion para crear un Objeto tipo Entity
     */
    public CategoriaProductoEntity crearCategoriaProducto(CategoriaProductoEntity categoriaProductoNueva) {
        CategoriaProductoEntity categoriaProductoNuev = categoriaProductoPersistence.create(categoriaProductoNueva);
        return categoriaProductoNuev;
    }

    /**
     * Metodo que genera la peticion de actualizar una Objeto tipo Entity con
     * otros datos
     */
    public CategoriaProductoEntity actualizarCategoriaProducto(Long id, CategoriaProductoEntity categoriaProductoActualizar) {
        CategoriaProductoEntity categoriaProductoActualizado = categoriaProductoPersistence.update(categoriaProductoActualizar);
        return categoriaProductoActualizado;
    }

    /**
     * Metodo que genera la peticion de borrar un Objeto tipo Entity
     *
     */
    public void eliminarCategoriaProducto(Long id) {
        categoriaProductoPersistence.delete(id);
    }
}
