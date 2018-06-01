/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.logic;

import co.edu.konrad.MarketPlaceKonrad.entities.RolEntity;
import co.edu.konrad.MarketPlaceKonrad.persistence.RolPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Leonardo Ruiz
 */
@Stateless
public class RolLogic {
    
   /**
    * Inyeccion del persistence de rol
    */ 
    @Inject
    RolPersistence rol;
    
    /**
     * Obtiene la lista de todos los roles que contiene
     * @return  lista con roles de usuario contenidos
     */
    public List<RolEntity> obtenerRoles(){
        List<RolEntity> roles = rol.findAll();
        return roles;
    }
    
    /**
     * Obtener un rol a partir del id
     * @param id
     * @return rol encontrado
     */
    public RolEntity obtenerRol(Long id){
        RolEntity rolencontrado = rol.find(id);
        if(rolencontrado == null){
            throw new IllegalArgumentException(" el Rol solicitado no existe.");
        }
        return rolencontrado;
    }
    
    /**
     * Crea un nuevo Rol 
     * @param rolEntity
     * @return rolEntity
     */
    public RolEntity crearRol(RolEntity rolEntity){
        rol.create(rolEntity);
        return rolEntity;
    }
    
    /**
     * Actualiza un rol 
     * @param rolEntity
     * @param id
     * @return rol actualizado
     */
    public RolEntity actualizarRol(Long id, RolEntity rolEntity){
        RolEntity rolActualizar = rol.update(rolEntity);
        return rolActualizar;
    }
    
    /**
     * Elimina un Rol
     * @param id 
     */
    public void eliminarRol(Long id){
        rol.delete(id);
    }
}
