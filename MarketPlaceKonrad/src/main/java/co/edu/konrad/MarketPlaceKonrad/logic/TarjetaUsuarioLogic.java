/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.logic;

import co.edu.konrad.MarketPlaceKonrad.entities.TarjetaUsuarioEntity;
import co.edu.konrad.MarketPlaceKonrad.persistence.TarjetaUsuarioPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author juandiego
 */
@Stateless
public class TarjetaUsuarioLogic {
   /**
     * Declaracion de la injeccion en la clase tarjetaUsuariosPersistence
     */
    @Inject
    TarjetaUsuarioPersistence tarjetaUsuarioPersistence;

    /**
     * @return marcas Metodo que genera la peticion de una Lista con Objetos de
     * una Entity
     */
    public List<TarjetaUsuarioEntity> obtenerTarjetaUsuario() {
        List<TarjetaUsuarioEntity> listTarjetasUsuario = tarjetaUsuarioPersistence.findAll();
        return listTarjetasUsuario;
    }

    /**
     * Metodo que genera la peticion de un Objeto tipo Entity identificando por
     * su id
     *
     * @param id
     */
    public TarjetaUsuarioEntity obtenerTarjetaUsuario(Long id) {
        TarjetaUsuarioEntity tarjetaUsuario = tarjetaUsuarioPersistence.find(id);
        if (tarjetaUsuario == null) {
            throw new IllegalArgumentException("la tarjeta del usuario no existe!");
        }
        return tarjetaUsuario;
    }

    /**
     * Metodo que genera la peticion para crear un Objeto tipo Entity
     */
    public TarjetaUsuarioEntity crearTarjetaUsuario(TarjetaUsuarioEntity tarjetaUsuario) {
        TarjetaUsuarioEntity tarjetaUsuarioEntity = tarjetaUsuarioPersistence.create(tarjetaUsuario);
        return tarjetaUsuarioEntity;
    }

    /**
     * Metodo que genera la peticion de actualizar una Objeto tipo Entity con
     * otros datos
     */
    public TarjetaUsuarioEntity actualizarTarjetaUsuario(Long id, TarjetaUsuarioEntity tarjetaUsuarioEntity) {
        TarjetaUsuarioEntity tarjetaUsuarios = tarjetaUsuarioPersistence.update(tarjetaUsuarioEntity);
        return tarjetaUsuarios;
    }

    /**
     * Metodo que genera la peticion de borrar un Objeto tipo Entity
     *
     */
    public void eliminarTarjeta(Long id) {
        tarjetaUsuarioPersistence.delete(id);
    }
}
