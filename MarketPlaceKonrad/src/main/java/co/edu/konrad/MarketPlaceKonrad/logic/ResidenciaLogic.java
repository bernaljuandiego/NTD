/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.logic;

import co.edu.konrad.MarketPlaceKonrad.entities.ResidenciaEntity;
import co.edu.konrad.MarketPlaceKonrad.persistence.ResidenciaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Leonardo Ruiz
 * 
 */
@Stateless
public class ResidenciaLogic {
    /**
     * Inyeccion del persistence de Residencia
     */
    @Inject
    ResidenciaPersistence residenciapersistence;
    
    /**
     * Obtener todas las residencias almacenadas
     * @return  Residencias
     */
    public List<ResidenciaEntity> obtenerResidencias(){
        List<ResidenciaEntity> Residencias= residenciapersistence.findAll();
        return Residencias;
    }
    
    /**
     * Obtener una Residencia a partir del id
     * @param id
     * @return Residencia encontrada
     */
    public ResidenciaEntity obtenerResidencia(Long id){
        ResidenciaEntity residencia = residenciapersistence.find(id);
        if(residencia == null){
            throw new IllegalArgumentException("La residencia  solicitada no existe.");
        }
        return residencia;
    }
    
    /**
     * Crear una nueva Residencia
     * @param resEntity
     * @return resEntity
     */
    public ResidenciaEntity crearResidencia(ResidenciaEntity resEntity){
        residenciapersistence.create(resEntity);
        return resEntity;
    }
    
    /**
     * Actualiza una residencia 
     * @param resEntity
     * @param id
     * @return residencia actualizada
     */
    public ResidenciaEntity actualizarResidencia(Long id, ResidenciaEntity resEntity){
        ResidenciaEntity resActualizada = residenciapersistence.update(resEntity);
        return resActualizada;
    }
    
    /**
     * Elimina una residencia
     * @param id 
     */
    public void eliminarResidencia(Long id){
        residenciapersistence.delete(id);
    }
    
}
