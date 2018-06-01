/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.persistence;
import co.edu.konrad.MarketPlaceKonrad.entities.MarcaEntity;
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
public class MarcaPersistence {
    @PersistenceContext (unitName = "MarketPlacePU")
    protected EntityManager em;
    
       /**
     * Obtener todos los elementos de la tabla Marca
     * @return todos los elementos de la tabla Marca
     *  
     * 
     */
     public List <MarcaEntity> findAll(){
        Query todos = em.createQuery("select me from MarcaEntity me");
        return todos.getResultList();
    }
     
     
     /**
     * Obtener un elemento a partir de su id
     * @param id
     * @return elemento encontrado
     */
    public MarcaEntity find(Long id){
        MarcaEntity marca = em.find(MarcaEntity.class, id);
        return marca;
    }
    
     /**
     * Crear un objeto de la entidad Marca
     * @param marcaNueva 
     * @return Objeto creado
     */
    public MarcaEntity create(MarcaEntity marcaNueva){
        em.persist(marcaNueva);
        return marcaNueva;
    }
    
     /**
     * Actualizar un objeto de la entidad Marca
     * @param marcaUpdate 
     * @return objeto actualizado
     */
    public MarcaEntity update(MarcaEntity marcaUpdate){
        return em.merge(marcaUpdate);
    }
    
    /**
     * Eliminar un objeto determinado de la entidad Marca
     * @param id 
     */
    public void delete(Long id){
        MarcaEntity marcaBorrar = em.find(MarcaEntity.class, id);
        em.remove(marcaBorrar);
    }
}
