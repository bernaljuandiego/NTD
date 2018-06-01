/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.persistence;

import co.edu.konrad.MarketPlaceKonrad.entities.ResidenciaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Leonaro Ruiz
 * Manejador de la tabla Residencia
 */
@Stateless
public class ResidenciaPersistence {
     @PersistenceContext(unitName = "MarketPlacePU")
    protected EntityManager em;
    
    /**
     * Obtener todos los elementos de la tabla Residencia
     * @return todos los elementos de la tabla Residencia
     *  
     * 
     */
     public List <ResidenciaEntity> findAll(){
        Query todos = em.createQuery("select ec from Residencia ec");
        return todos.getResultList();
    }
     
     
     /**
     * Obtener un elemento a partir de su id
     * @param id
     * @return elemento encontrado
     */
    public ResidenciaEntity find(Long id){
        ResidenciaEntity residencia = em.find(ResidenciaEntity.class, id);
        return residencia;
    }
    
     /**
     * Crear un objeto de la entidad Residencia
     * @param ResidenciaNueva
     * @return Objeto creado
     */
    public ResidenciaEntity create(ResidenciaEntity ResidenciaNueva){
        em.persist(ResidenciaNueva);
        return ResidenciaNueva;
    }
    
     /**
     * Actualizar un objeto de la entidad Residencia
     * @param ResidenciaActualizar  
     * @return objeto actualizado
     */
    public ResidenciaEntity update(ResidenciaEntity ResidenciaActualizar){
        return em.merge(ResidenciaActualizar);
    }
    
    /**
     * Eliminar un objeto determinado de la entidad Residencia
     * @param id 
     */
    public void delete(Long id){
        ResidenciaEntity ResidenciaBorrar = em.find(ResidenciaEntity.class, id);
        em.remove(ResidenciaBorrar);
    }
}
