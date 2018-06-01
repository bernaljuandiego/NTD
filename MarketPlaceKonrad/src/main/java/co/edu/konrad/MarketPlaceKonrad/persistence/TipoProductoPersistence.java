/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.persistence;

import co.edu.konrad.MarketPlaceKonrad.entities.TipoProductoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Manuel S. Nino
 */
@Stateless
public class TipoProductoPersistence {

    @PersistenceContext(unitName = "MarketPlacePU")
    protected EntityManager em;

    /**
     * Obtener todos los elementos de la tabla TipoProducto
     *
     * @return Lista de los elementos
     */
    public List<TipoProductoEntity> findAll() {
        Query todos = em.createQuery("select tp  from Tipo_producto tp");
        return todos.getResultList();
    }

    /**
     * Encontrar un elemento por su id
     *
     * @param id
     * @return objeto encontrado
     */
    public TipoProductoEntity find(Long id) {
        TipoProductoEntity tipoProductoEntityEncontrado = em.find(TipoProductoEntity.class, id);
        return tipoProductoEntityEncontrado;
    }

    /**
     * Eliminar un objeto por su id
     *
     * @param id
     */
    public void delete(Long id) {
        TipoProductoEntity tipoProductoEntityEliminado = em.find(TipoProductoEntity.class, id);
        em.remove(tipoProductoEntityEliminado);
    }

    /**
     * Agregar un objeto
     *
     * @param Objeto a agregar
     * @return Objeto agregado
     */
    public TipoProductoEntity create(TipoProductoEntity tipoProductoEntityNuevo) {
        em.persist(tipoProductoEntityNuevo);
        return tipoProductoEntityNuevo;
    }

    /**
     * Actualizar un objeto
     *
     * @param Objeto a actualizado
     * @return objeto actualizado
     */

    public TipoProductoEntity update(TipoProductoEntity tipoProductoEntityActualizado) {
        return em.merge(tipoProductoEntityActualizado);
    }
}
