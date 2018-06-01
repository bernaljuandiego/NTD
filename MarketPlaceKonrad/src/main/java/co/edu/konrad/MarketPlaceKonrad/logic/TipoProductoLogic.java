/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.logic;

import co.edu.konrad.MarketPlaceKonrad.entities.TipoProductoEntity;
import co.edu.konrad.MarketPlaceKonrad.persistence.TipoProductoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ManuelS
 */
@Stateless
public class TipoProductoLogic {
 /**
 * Inyeccion del persistence de TipoProducto
 */   
@Inject
private TipoProductoPersistence tipoProductoPersistence;
/**
 * Obtener todos los tipoProducto
 * @return  todos los tipoProducto
 */
public List<TipoProductoEntity> obtenerTipoProductos(){
    List<TipoProductoEntity> tipoProductos = tipoProductoPersistence.findAll();
    return tipoProductos;
}
/**
 * Obtener un tipoProducto por su id
 * @param id
 * @return tipoProductoEntity 
 */
public TipoProductoEntity obtenerTipoProducto (Long id){
TipoProductoEntity tipoProductoEntity = tipoProductoPersistence.find(id);
return tipoProductoEntity;
}
/**
 *  * Crea un nuevo tipoProducto
 * @param tipoProductoEntity
 * @return tipoProducto nuevo
 */
public TipoProductoEntity crearTipoProducto (TipoProductoEntity tipoProductoEntity){
tipoProductoPersistence.create(tipoProductoEntity);
return tipoProductoEntity;
}
/**
 *  Actualiza un tipo de producto
 * @param id
 * @param tipoProductoEntity
 * @return tipoProducto actualizado 
 */
public TipoProductoEntity actualizaTipoProducto (Long id, TipoProductoEntity tipoProductoEntity){
TipoProductoEntity tipoProductoEntity1 = tipoProductoPersistence.update(tipoProductoEntity);
return tipoProductoEntity;
}
/**
 * Elimina un tipoProducto por id
 * @param id 
 */
public void eliminarTipoProducto (Long id){
tipoProductoPersistence.delete(id);
}
}
