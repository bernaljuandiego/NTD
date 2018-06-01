/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.persistence;

import co.edu.konrad.MarketPlaceKonrad.entities.TipoDocumentoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Leonardo Ruiz
 * Manejador de la tabla TipoId
 */
@Stateless
public class TipoDocumentoPersistence {
    
    @PersistenceContext(unitName = "MarketPlacePU")
    protected EntityManager em;
    
    /**
     * Obtener todos los elementos de la tabla TipoId
     * @return todos los elementos de la tabla ciudad
     *  
     * 
     */
     public List <TipoDocumentoEntity> findAll(){
        Query todos = em.createQuery("select ec from tipo_documento ec");
        return todos.getResultList();
    }
     
     
     /**
     * Obtener un elemento a partir de su id
     * @param id
     * @return elemento encontrado
     */
    public TipoDocumentoEntity find(Long id){
        TipoDocumentoEntity tipoid = em.find(TipoDocumentoEntity.class, id);
        return tipoid;
    }
    
     /**
     * Crear un objeto de la entidad TipoId
     * @param TipoIdNuevo  
     * @return Objeto creado
     */
    public TipoDocumentoEntity create(TipoDocumentoEntity TipoIdNuevo){
        em.persist(TipoIdNuevo);
        return TipoIdNuevo;
    }
    
     /**
     * Actualizar un objeto de la entidad TipoId
     * @param TipoUpdate  
     * @return objeto actualizado
     */
    public TipoDocumentoEntity update(TipoDocumentoEntity TipoUpdate){
        return em.merge(TipoUpdate);
    }
    
    /**
     * Eliminar un objeto determinado de la entidad TipoId
     * @param id 
     */
    public void delete(Long id){
        TipoDocumentoEntity TipoidBorrar = em.find(TipoDocumentoEntity.class, id);
        em.remove(TipoidBorrar);
    }
}
