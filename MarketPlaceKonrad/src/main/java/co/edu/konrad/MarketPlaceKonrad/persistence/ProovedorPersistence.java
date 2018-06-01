/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.persistence;

import co.edu.konrad.MarketPlaceKonrad.entities.ProovedorEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Leonardo Ruiz
 * Manejador de la tabla proovedor
 */
@Stateless
public class ProovedorPersistence {
    @PersistenceContext(unitName = "MarketPlacePU")
    protected EntityManager em;
    
        /**
     * Obtener todos los elementos de la tabla Proovedor
     * @return todos los elementos de la tabla Proovedor
     *  
     * 
     */
     public List <ProovedorEntity> findAll(){
        Query todos = em.createQuery("select ec from Proovedor ec");
        return todos.getResultList();
    }
     
     
     /**
     * Obtener un elemento a partir de su id
     * @param id
     * @return elemento encontrado
     */
    public ProovedorEntity find(Long id){
        ProovedorEntity proovedor = em.find(ProovedorEntity.class, id);
        return proovedor;
    }
    
     /**
     * Crear un objeto de la entidad Proovedor
     * @param ProovedorNuevo 
     * @return Objeto creado
     */
    public ProovedorEntity create(ProovedorEntity ProovedorNuevo){
        em.persist(ProovedorNuevo);
        return ProovedorNuevo;
    }
    
     /**
     * Actualizar un objeto de la entidad Proovedor
     * @param ProovedorUpdate 
     * @return objeto actualizado
     */
    public ProovedorEntity update(ProovedorEntity ProovedorUpdate){
        return em.merge(ProovedorUpdate);
    }
    
    /**
     * Eliminar un objeto determinado de la entidad Proovedor
     * @param id 
     */
    public void delete(Long id){
        ProovedorEntity ProovedorBorrar = em.find(ProovedorEntity.class, id);
        em.remove(ProovedorBorrar);
    }
}
