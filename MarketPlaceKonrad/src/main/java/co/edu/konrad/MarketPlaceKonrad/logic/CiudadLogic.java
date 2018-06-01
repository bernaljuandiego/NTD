/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.logic;

import co.edu.konrad.MarketPlaceKonrad.entities.CiudadEntity;
import co.edu.konrad.MarketPlaceKonrad.persistence.CiudadPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Leonardo Ruiz
 */
@Stateless
public class CiudadLogic {
    
    /**
     * inyeccion del persistence de ciudad
     */
    
    @Inject
    CiudadPersistence ciudadpersistence;
    /**
     * Obtener todas las ciudades almacenadas
     * @return 
     */
    public List<CiudadEntity> obtenerCiudades(){
        List<CiudadEntity> ciudades = ciudadpersistence.findAll();
        return ciudades;
    }
    
    /**
     * Obtener una ciudad a partir del id
     * @param id
     * @return ciudad encontrada
     */
    public CiudadEntity obtenerCiudad(Long id){
        CiudadEntity ciudad = ciudadpersistence.find(id);
        if(ciudad == null){
            throw new IllegalArgumentException("La ciudad solicitada no existe.");
        }
        return ciudad;
    }
    
    /**
     * Crear una nueva ciudad
     * @param ciuEntity
     * @return ciuEntity
     */
    public CiudadEntity crearCiudad(CiudadEntity ciuEntity){
        ciudadpersistence.create(ciuEntity);
        return ciuEntity;
    }
    
    /**
     * Actualiza una ciudad 
     * @param ciuEntity
     * @param id
     * @return ciudad actualizada
     */
    public CiudadEntity actualizarCiudad(Long id, CiudadEntity ciuEntity){
        CiudadEntity ciudadActualizar = ciudadpersistence.update(ciuEntity);
        return ciudadActualizar;
    }
    
    /**
     * Elimina una ciudad
     * @param id 
     */
    public void eliminarCiudad(Long id){
        ciudadpersistence.delete(id);
    }
}
