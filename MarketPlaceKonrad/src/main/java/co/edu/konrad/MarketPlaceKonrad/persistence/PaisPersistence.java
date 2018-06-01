/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.persistence;

import co.edu.konrad.MarketPlaceKonrad.entities.PaisEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Leonardo Ruiz
 * Manejador de la tabla Pais
 */
@Stateless
public class PaisPersistence {
    
    
    @PersistenceContext(unitName = "MarketPlacePU")
    protected EntityManager em;
    
    
    /**
     * Obtener todos los elementos de la tabla Pais
     * @return todos los elementos de la tabla ciudad
     *  
     * 
     */
     public List <PaisEntity> findAll(){
        Query todos = em.createQuery("select ec from Pais ec");
        return todos.getResultList();
    }
     
     
     /**
     * Obtener un elemento a partir de su id
     * @param id
     * @return elemento encontrado
     */
    public PaisEntity find(Long id){
        PaisEntity pais = em.find(PaisEntity.class, id);
        return pais;
    }
    
     /**
     * Crear un objeto de la entidad Pais
     * @param paisNuevo  
     * @return Objeto creado
     */
    public PaisEntity create(PaisEntity paisNuevo){
        em.persist(paisNuevo);
        return paisNuevo;
    }
    
     /**
     * Actualizar un objeto de la entidad Pais
     * @param PaisUpdate  
     * @return objeto actualizado
     */
    public PaisEntity update(PaisEntity PaisUpdate){
        return em.merge(PaisUpdate);
    }
    
    /**
     * Eliminar un objeto determinado de la entidad Pais
     * @param id 
     */
    public void delete(Long id){
        PaisEntity PaisBorrar = em.find(PaisEntity.class, id);
        em.remove(PaisBorrar);
    }
}
