/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.persistence;

import co.edu.konrad.MarketPlaceKonrad.entities.TarjetaUsuarioEntity;
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
public class TarjetaUsuarioPersistence {
     
   @PersistenceContext (unitName = "MarketPlacePU")
   protected EntityManager em;
   
   /**
    * Obtener todos los elementos de la tabla Tarjeta Usuario
    * @return todos los elementos
    */
   
   public List <TarjetaUsuarioEntity> findAll (){
   Query todos = em.createQuery("select ce from Tarjeta_usuario ce");
   return todos.getResultList();
   }
   
   /**
    * Obtener el objeto por su id
    * @param Id
    * @return Elemento correspondiente al id
    */
    public TarjetaUsuarioEntity find (Long id){
    TarjetaUsuarioEntity tarjetaUsuarioEntity = em.find(TarjetaUsuarioEntity.class, id);
    return tarjetaUsuarioEntity;
    }
    
    /**
     * Crear un nuevo elemento
     * @param Elemento a crear
     * @return Elemento creado
     */
    public TarjetaUsuarioEntity create (TarjetaUsuarioEntity tarjetaUsuarioEntity){
    em.persist(tarjetaUsuarioEntity);
    return tarjetaUsuarioEntity;
    }
    
    /**
     * Actualizar un elemento
     * @param Elemento a actualizar
     * @return Elemento actualizado
     */
    
    public TarjetaUsuarioEntity update(TarjetaUsuarioEntity tarjetaUsuarioActualizado){
    return em.merge(tarjetaUsuarioActualizado);
     }
    
    /**
     * Eliminar un elemento
     * @param id del elemento 
     */
    public void delete (Long id){
    TarjetaUsuarioEntity tarjetaUsuarioEliminar = em.find(TarjetaUsuarioEntity.class, id);
    em.remove(tarjetaUsuarioEliminar);
    }
}
