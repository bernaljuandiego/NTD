/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.persistence;

import co.edu.konrad.MarketPlaceKonrad.entities.UsuarioEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Leonardo Ruiz
 * Manejador de la tabla usuario
 */
@Stateless
public class UsuarioPersistence {
    @PersistenceContext(unitName = "MarketPlacePU")
    protected EntityManager em;
    
    /**
     * Obtener todos los elementos de la tabla Usuario
     * @return todos los elementos de la tabla Usuario
     *  
     * 
     */
     public List <UsuarioEntity> findAll(){
        Query todos = em.createQuery("select ec from Usuario ec");
        return todos.getResultList();
    }
     
     
     /**
     * Obtener un elemento a partir de su id
     * @param id
     * @return elemento encontrado
     */
    public UsuarioEntity find(Long id){
        UsuarioEntity user = em.find(UsuarioEntity.class, id);
        return user;
    }
    
     /**
     * Crear un objeto de la entidad Usuario
     * @param UsuarioNuevo
     * @return Objeto creado
     */
    public UsuarioEntity create(UsuarioEntity UsuarioNuevo){
        em.persist(UsuarioNuevo);
        return UsuarioNuevo;
    }
    
     /**
     * Actualizar un objeto de la entidad Usuario
     * @param UsuarioActualizar 
     * @return objeto actualizado
     */
    public UsuarioEntity update(UsuarioEntity UsuarioActualizar){
        return em.merge(UsuarioActualizar);
    }
    
    /**
     * Eliminar un objeto determinado de la entidad Usuario
     * @param id 
     */
    public void delete(Long id){
        UsuarioEntity UserBorrar = em.find(UsuarioEntity.class, id);
        em.remove(UserBorrar);
    }
    
}
