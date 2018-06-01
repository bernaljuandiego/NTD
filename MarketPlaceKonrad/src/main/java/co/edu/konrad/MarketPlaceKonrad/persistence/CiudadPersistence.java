/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.persistence;

import co.edu.konrad.MarketPlaceKonrad.entities.CiudadEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Leonardo Ruiz
 * Manejador de la tabla Ciudad
 */
@Stateless
public class CiudadPersistence {
    @PersistenceContext(unitName = "MarketPlacePU")
    protected EntityManager em;
    
        /**
     * Obtener todos los elementos de la tabla Ciudad
     * @return todos los elementos de la tabla ciudad
     *  
     * 
     */
     public List <CiudadEntity> findAll(){
        Query todos = em.createQuery("select ec from Ciudad ec");
        return todos.getResultList();
    }
     
     
     /**
     * Obtener un elemento a partir de su id
     * @param id
     * @return elemento encontrado
     */
    public CiudadEntity find(Long id){
        CiudadEntity Ciudad = em.find(CiudadEntity.class, id);
        return Ciudad;
    }
    
     /**
     * Crear un objeto de la entidad Ciudad
     * @param Ciudadueva 
     * @return Objeto creado
     */
    public CiudadEntity create(CiudadEntity Ciudadueva){
        em.persist(Ciudadueva);
        return Ciudadueva;
    }
    
     /**
     * Actualizar un objeto de la entidad Ciudad
     * @param CiudadUpdate 
     * @return objeto actualizado
     */
    public CiudadEntity update(CiudadEntity CiudadUpdate){
        return em.merge(CiudadUpdate);
    }
    
    /**
     * Eliminar un objeto determinado de la entidad Ciudad
     * @param id 
     */
    public void delete(Long id){
        CiudadEntity CiudadBorrar = em.find(CiudadEntity.class, id);
        em.remove(CiudadBorrar);
    }
    
    
}
