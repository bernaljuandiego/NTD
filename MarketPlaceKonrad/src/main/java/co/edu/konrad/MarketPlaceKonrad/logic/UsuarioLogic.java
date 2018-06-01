/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.logic;

import co.edu.konrad.MarketPlaceKonrad.entities.UsuarioEntity;
import co.edu.konrad.MarketPlaceKonrad.persistence.UsuarioPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Leonardo Ruiz
 */
@Stateless
public class UsuarioLogic {

/**
 * Inyeccion del persistence de usuario
 */

@Inject    
private UsuarioPersistence usuarioPersistence; 

/**
 * Obtener todos los usuarios
 * @return  todos los usuarios
 */
public List<UsuarioEntity> obtenerUsuarios(){
        List<UsuarioEntity> Usuarios = usuarioPersistence.findAll();
        return Usuarios;
    }
    
    /**
     * Obtener un usuario a partir del id
     * @param id
     * @return usuario encontrado
     */
    public UsuarioEntity obtenerUsuario(Long id){
        UsuarioEntity usuario = usuarioPersistence.find(id);
        if(usuario== null){
            throw new IllegalArgumentException("El usuario solicitado no existe.");
        }
        return usuario;
    }
    
    /**
     * Crear un nuevo usuario
     * @param userEntity
     * @return userEntity
     */
    public UsuarioEntity crearUsuario(UsuarioEntity userEntity){
        usuarioPersistence.create(userEntity);
        return userEntity;
    }
    
    /**
     * Actualiza un usario
     * @param userEntity
     * @param id
     * @return  usuario actualizado
     */
    public UsuarioEntity actualizarUsuario(Long id, UsuarioEntity userEntity){
        UsuarioEntity usuario = usuarioPersistence.update(userEntity);
        return usuario;
    }
    
    /**
     * Elimina un Usuario
     * @param id 
     */
    public void eliminarUsuario(Long id){
        usuarioPersistence.delete(id);
    }
    
}
