/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.logic;

import co.edu.konrad.MarketPlaceKonrad.entities.MarcaEntity;
import co.edu.konrad.MarketPlaceKonrad.persistence.MarcaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *  Inyeccion, uso de metodos, constructor and other de la <<Persistence>> de Marca.
 *  Controlador de petiticiones 
 * @author Manuel S. Nino
 */
@Stateless
public class MarcaLogic {

    
    /**
     * Declaracion de la injeccion en la clase MarcaPersistence
     */
    
    @Inject
    MarcaPersistence marcaPersistence;
    /**
     * @return marcas
     * Metodo que genera la peticion de una Lista con Objetos de una Entity
     */
    public List<MarcaEntity> obtenerMarcas (){
    List<MarcaEntity> marcas = marcaPersistence.findAll();
    return marcas;        
    }
    
    
    /**
     *Metodo que genera la peticion de un Objeto tipo Entity identificando por su id
     * @param id
     */
    public MarcaEntity obtenerMarca(Long id){
    MarcaEntity marca = marcaPersistence.find(id);
    if (marca == null){
    throw new IllegalArgumentException("La marca solicitada no existe");
    }
    return marca;
    }
    
    /**
     * Metodo que genera la peticion para crear un Objeto tipo Entity
     */
    public MarcaEntity crearMarcar(MarcaEntity marca){
     marcaPersistence.create(marca);
     return marca;
    }
    
    /**
     * Metodo que genera la peticion de actualizar una Objeto tipo Entity con otros datos
     */
    public MarcaEntity actualizarMarca(Long id,MarcaEntity marcaActualizar){
    MarcaEntity marcaActualizada = marcaPersistence.update(marcaActualizar);
    return marcaActualizada;
    }
    
    /**
     * Metodo que genera la peticion de borrar un Objeto tipo Entity 
     * 
     */
    public void eliminarMarca(Long id){
    marcaPersistence.delete(id);
    }
}
