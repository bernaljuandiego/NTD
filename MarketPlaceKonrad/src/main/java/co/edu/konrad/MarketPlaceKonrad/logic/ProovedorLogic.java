/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.logic;

import co.edu.konrad.MarketPlaceKonrad.entities.ProovedorEntity;
import co.edu.konrad.MarketPlaceKonrad.persistence.ProovedorPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Leonardo Ruiz 
 */
@Stateless
public class ProovedorLogic {
    /**
     * Inyecion del persistence de proovedor
     */
    @Inject
    ProovedorPersistence proovedorpersistence;
    
    
    public List<ProovedorEntity> obtenerProovedores(){
        List<ProovedorEntity> proovedores = proovedorpersistence.findAll();
        return proovedores;
    }
    
    /**
     * Obtener un proovedor a partir del id
     * @param id
     * @return proovedor encontrado
     */
    public ProovedorEntity obtenerProovedor(Long id){
        ProovedorEntity proovedor = proovedorpersistence.find(id);
        if(proovedor == null){
            throw new IllegalArgumentException("el Proovedor solicitado no existe.");
        }
        return proovedor;
    }
    
    /**
     * Crear un nuevo proovedor
     * @param proovEntity
     * @return proovEntity
     */
    public ProovedorEntity crearProovedor(ProovedorEntity proovEntity){
        proovedorpersistence.create(proovEntity);
        return proovEntity;
    }
    
    /**
     * Actualiza un proovedor 
     * @param proovEntity
     * @param id
     * @return proovedor actualizado
     */
    public ProovedorEntity actualizarProovedor(Long id, ProovedorEntity proovEntity){
        ProovedorEntity proovedorActualizar = proovedorpersistence.update(proovEntity);
        return proovedorActualizar;
    }
    
    /**
     * Elimina un proovedor
     * @param id 
     */
    public void eliminarProovedor(Long id){
        proovedorpersistence.delete(id);
    }
    
}
