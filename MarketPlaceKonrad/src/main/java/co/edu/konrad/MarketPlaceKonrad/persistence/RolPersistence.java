/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.persistence;

import co.edu.konrad.MarketPlaceKonrad.entities.RolEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Leonardo Ruiz
 * Manejador de la tabla Rol
 */
@Stateless
public class RolPersistence {
     @PersistenceContext(unitName = "MarketPlacePU")
    protected EntityManager em;
    
    /**
     * Obtener todos los elementos de la tabla Rol
     * @return todos los elementos de la tabla Rol
     *  
     * 
     */
     public List <RolEntity> findAll(){
        Query todos = em.createQuery("select ec from rol ec");
        return todos.getResultList();
    }
     
     
     /**
     * Obtener un elemento a partir de su id
     * @param id
     * @return elemento encontrado
     */
    public RolEntity find(Long id){
        RolEntity rol = em.find(RolEntity.class, id);
        return rol;
    }
    
     /**
     * Crear un objeto de la entidad Rol
     * @param RolNuevo
     * @return Objeto creado
     */
    public RolEntity create(RolEntity RolNuevo){
        em.persist(RolNuevo);
        return RolNuevo;
    }
    
     /**
     * Actualizar un objeto de la entidad Rol
     * @param RolActualizar  
     * @return objeto actualizado
     */
    public RolEntity update(RolEntity RolActualizar){
        return em.merge(RolActualizar);
    }
    
    /**
     * Eliminar un objeto determinado de la entidad Rol
     * @param id 
     */
    public void delete(Long id){
        RolEntity RolBorrar = em.find(RolEntity.class, id);
        em.remove(RolBorrar);
    }
}
