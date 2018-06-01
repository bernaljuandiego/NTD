/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.logic;


import co.edu.konrad.MarketPlaceKonrad.entities.CategoriaEntity;
import co.edu.konrad.MarketPlaceKonrad.persistence.CategoriaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *  Inyeccion, uso de metodos, constructor and other de la <<Persistence>> de Categoria.
 *  Controlador de petiticiones 
 * @author Manuel S. Nino
 */
@Stateless
public class CategoriaLogic {

    
    /**
     * Declaracion de la injeccion en la clase CategoriaMPersistence
     */
    
    @Inject
        CategoriaPersistence categoriaPersistence;
    /**
     * @return marcas
     * Metodo que genera la peticion de una Lista con Objetos de una Entity
     */
    public List<CategoriaEntity> obtenerCategorias (){
    List<CategoriaEntity> categorias = categoriaPersistence.findAll();
    return categorias;        
    }
    
    
    /**
     *Metodo que genera la peticion de un Objeto tipo Entity identificando por su id
     * @param id
     */
   public CategoriaEntity obtenerCategoria(Long id){
   CategoriaEntity categoria = categoriaPersistence.find(id);
   if(categoria == null){
   throw new IllegalArgumentException("La categoria no se encuentra registrada");
   }
   return categoria;
   }
    
    /**
     * Metodo que genera la peticion para crear un Objeto tipo Entity
     */
    public CategoriaEntity crearCategoria(CategoriaEntity categoriaNueva){
        categoriaPersistence.create(categoriaNueva);
        return categoriaNueva;
    }
    /**
     * Metodo que genera la peticion de actualizar una Objeto tipo Entity con otros datos
     */
    public CategoriaEntity actualizarCategoria(Long id,CategoriaEntity categoriaActualizar){
    CategoriaEntity categoriaActualizada = categoriaPersistence.update(categoriaActualizar);
    return categoriaActualizada;
    }
    
    /**
     * Metodo que genera la peticion de borrar un Objeto tipo Entity 
     * 
     */
    public void eliminarCategoria(Long id){
    categoriaPersistence.delete(id);
    }
}
