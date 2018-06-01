/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.persistence;
import co.edu.konrad.MarketPlaceKonrad.entities.CategoriaEntity;
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
public class CategoriaPersistence {
   @PersistenceContext (unitName = "MarketPlacePU")
   protected EntityManager em;
   
   /**
    * Obtener todos los elementos de la tabla Categoria
    * @return todos los elementos
    */
   
   public List <CategoriaEntity> findAll (){
   Query todos = em.createQuery("select ce FROM Categoria ce");
   return todos.getResultList();
   }
   
   /**
    * Obtener el objeto por su id
    * @param Id
    * @return Elemento correspondiente al id
    */
    public CategoriaEntity find (Long id){
    CategoriaEntity categoria = em.find(CategoriaEntity.class, id);
    return categoria;
    }
    
    /**
     * Crear un nuevo elemento
     * @param Elemento a crear
     * @return Elemento creado
     */
    public CategoriaEntity create (CategoriaEntity categoriaNueva){
    em.persist(categoriaNueva);
    return categoriaNueva;
    }
    
    /**
     * Actualizar un elemento
     * @param Elemento a actualizar
     * @return Elemento actualizado
     */
    
    public CategoriaEntity update(CategoriaEntity categoriaActualizada){
    return em.merge(categoriaActualizada);
     }
    
    /**
     * Eliminar un elemento
     * @param id del elemento 
     */
    public void delete (Long id){
    CategoriaEntity categoriaBorrar = em.find(CategoriaEntity.class, id);
    em.remove(categoriaBorrar);
    }
}
