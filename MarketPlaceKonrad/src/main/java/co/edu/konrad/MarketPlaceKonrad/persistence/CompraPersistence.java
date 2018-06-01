/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.persistence;

import co.edu.konrad.MarketPlaceKonrad.entities.CompraEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author juandiego
 */
@Stateless
public class CompraPersistence {

    @PersistenceContext(unitName = "MarketPlacePU")
    protected EntityManager em;

    /**
     * Obtener todos los elementos de la tabla Compra
     *
     * @return todos los elementos
     */
    public List<CompraEntity> findAll() {
        Query todos = em.createQuery("select ce from Compra ce");
        return todos.getResultList();
    }

    /**
     * Obtener el objeto por su id
     *
     * @param Id
     * @return Elemento correspondiente al id
     */
    public CompraEntity find(Long id) {
        CompraEntity compraEntity = em.find(CompraEntity.class, id);
        return compraEntity;
    }

    /**
     * Crear un nuevo elemento
     *
     * @param Elemento a crear
     * @return Elemento creado
     */
    public CompraEntity create(CompraEntity compraEntity) {
        em.persist(compraEntity);
        return compraEntity;
    }

    /**
     * Actualizar un elemento
     *
     * @param Elemento a actualizar
     * @return Elemento actualizado
     */
    public CompraEntity update(CompraEntity compraActualizar) {
        return em.merge(compraActualizar);
    }

    /**
     * Eliminar un elemento
     *
     * @param id del elemento
     */
    public void delete(Long id) {
        CompraEntity compraEliminar = em.find(CompraEntity.class, id);
        em.remove(compraEliminar);
    }
}
