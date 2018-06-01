/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.logic;

import co.edu.konrad.MarketPlaceKonrad.entities.TipoDocumentoEntity;
import co.edu.konrad.MarketPlaceKonrad.persistence.TipoDocumentoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Leonardo Ruiz
 */
@Stateless
public class TipoDocumentoLogic {
    /**
     * Inyeccion del persistence de tipo de documento
     */
    @Inject
    TipoDocumentoPersistence tipodocumentoentity;
    
    /**
     * Obtiene todos los tipos de documento que hay 
     * @return  lista con todos los t. Documento
     */
    public List<TipoDocumentoEntity> obtenerTiposDocumento(){
        List<TipoDocumentoEntity> tiposDoc = tipodocumentoentity.findAll();
        return tiposDoc;
    }
    
    /**
     * Obtener un tipo de documento a partir del id
     * @param id
     * @return tipo de documento encontrado
     */
    public TipoDocumentoEntity obtenerTipoDocumento(Long id){
        TipoDocumentoEntity tipoDoc = tipodocumentoentity.find(id);
        if(tipoDoc == null){
            throw new IllegalArgumentException(" el Tipo de documento solicitado no existe.");
        }
        return tipoDoc;
    }
    
    /**
     * Crear un nuevo tipo de documento
     * @param tdEntity
     * @return tdEntity
     */
    public TipoDocumentoEntity crearTipoDocumento(TipoDocumentoEntity tdEntity){
        tipodocumentoentity.create(tdEntity);
        return tdEntity;
    }
    
    /**
     * Actualiza un tipo de documento - 
     * @param tdEntity
     * @param id
     * @return tipo de documento actualizado
     */
    public TipoDocumentoEntity actualizarTipoDocumento(Long id, TipoDocumentoEntity tdEntity){
        TipoDocumentoEntity tipo = tipodocumentoentity.update(tdEntity);
        return tipo;
    }
    
    /**
     * Elimina un tipo de documento
     * @param id 
     */
    public void eliminarTipoDocumento(Long id){
        tipodocumentoentity.delete(id);
    }
    
}
