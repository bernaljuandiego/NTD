/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.persistence;

import co.edu.konrad.MarketPlaceKonrad.entities.CarritoComprasEntity;
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
public class CarritoComprasPersistence {
    
   @PersistenceContext (unitName = "MarketPlacePU")
   protected EntityManager em;
   
   /**
    * Obtener todos los elementos de la tabla CarritoCompras
    * @return todos los elementos
    */
   
   public List <CarritoComprasEntity> findAll (){
   Query todos = em.createQuery("select e from Carrito_compras e");
   return todos.getResultList();
   }
   
   /**
    * Obtener el objeto por su id
    * @param Id
    * @return Elemento correspondiente al id
    */
    public CarritoComprasEntity find (Long id){
    CarritoComprasEntity carritoComprasEntity = em.find(CarritoComprasEntity.class, id);
    return carritoComprasEntity;
    }
    
    /**
     * Crear un nuevo elemento
     * @param Elemento a crear
     * @return Elemento creado
     */
    public CarritoComprasEntity create (CarritoComprasEntity carritoComprasEntity){
    em.persist(carritoComprasEntity);
    return carritoComprasEntity;
    }
    
    /**
     * Actualizar un elemento
     * @param Elemento a actualizar
     * @return Elemento actualizado
     */
    
    public CarritoComprasEntity update(CarritoComprasEntity carritoComprasActualizado){
    return em.merge(carritoComprasActualizado);
     }
    
    /**
     * Eliminar un elemento
     * @param id del elemento 
     */
    public void delete (Long id){
    CarritoComprasEntity carritoComprasEliminar = em.find(CarritoComprasEntity.class, id);
    em.remove(carritoComprasEliminar);
    }
}
