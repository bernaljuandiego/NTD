/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.logic;

import co.edu.konrad.MarketPlaceKonrad.entities.PaisEntity;
import co.edu.konrad.MarketPlaceKonrad.persistence.PaisPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Leonardo Ruiz
 */
@Stateless
public class PaisLogic {
    
    /**
     * inyeccion del persistence de pais
     */
    @Inject
    PaisPersistence paispersistence;
    
    
    
    /**
     * Obtener todos los paises registrados
     * @return 
     */
    
    public List<PaisEntity> obtenerPaises(){
        List<PaisEntity> Paises = paispersistence.findAll();
        return Paises;
    }
    
    /**
     * Obtener un Pais a partir del id
     * @param id
     * @return pais encontrado
     */
    public PaisEntity obtenerPais(Long id){
        PaisEntity pais = paispersistence.find(id);
        if(pais == null){
            throw new IllegalArgumentException("El pais solicitado no existe.");
        }
        return pais;
    }
    
    /**
     * Crear un nuevo Pais
     * @param paisEntity
     * @return paisEntity
     */
    public PaisEntity crearPais(PaisEntity paisEntity){
        paispersistence.create(paisEntity);
        return paisEntity;
    }
    
    /**
     * Actualiza un Pais 
     * @param paisEntity
     * @param id
     * @return Pais actualizado
     */
    public PaisEntity actualizarPais(Long id, PaisEntity paisEntity){
        PaisEntity pais = paispersistence.update(paisEntity);
        return pais;
    }
    
    /**
     * Elimina un Pais
     * @param id 
     */
    public void eliminarPais(Long id){
        paispersistence.delete(id);
    }
}
