/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.persistence;
import co.edu.konrad.MarketPlaceKonrad.entities.CategoriaEntity;
import co.edu.konrad.MarketPlaceKonrad.entities.CategoriaProductoEntity;
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
public class CategoriaProductoPersistence {
    @PersistenceContext (unitName = "MarketPlacePU")
    protected EntityManager em;
    /**
     * Obtener todos los elementos de la tabla CategoriaProducto
     */
        public List <CategoriaProductoEntity> findAll (){
        Query todos = em.createQuery("select cpe from Categoria_producto cpe");
        return todos.getResultList();    
    }
    /**
     * Obtener un elemento por su id
     * @param id
     * @return Elemento correspondiente al id
     */

    public CategoriaProductoEntity find (Long id){
        CategoriaProductoEntity encontrado = em.find(CategoriaProductoEntity.class, id);
        return encontrado;
    }
    
    /**
     * Crear nueva CategoriaProducto
     * @param Objeto de tipo CategoriaProductoEntity
     * @return objeto creado
     */
    
    public CategoriaProductoEntity create (CategoriaProductoEntity categoriaProductoNuevo){
    em.persist(categoriaProductoNuevo);
    return categoriaProductoNuevo;
    }
    
    /**
     * Eliminar un objeto de tipo categoriaProductoEntity
     * @param id del objeto
     */
    public void delete (Long id){
    CategoriaProductoEntity categoriaProductoEntityEliminada = em.find(CategoriaProductoEntity.class, id);
    em.remove(categoriaProductoEntityEliminada);
    }
    
    /**
     * Actualizar un objeto
     * @param Objeto actualizado
     * @return Objeto actualizado
     */
    
    public CategoriaProductoEntity update(CategoriaProductoEntity categoriaProductoEntityActualizada){
    return em.merge(categoriaProductoEntityActualizada);
    }
}
