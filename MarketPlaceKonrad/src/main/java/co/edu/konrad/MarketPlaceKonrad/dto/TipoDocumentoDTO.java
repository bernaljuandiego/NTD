/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.dto;

import co.edu.konrad.MarketPlaceKonrad.entities.TipoDocumentoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo Ruiz
 */
public class TipoDocumentoDTO {
    
    private Long idtipo;
    
    
    private String nomTipoId;
    
    
    
    
    public TipoDocumentoDTO(){
    }
    /**
     * Creacion de el objeto DTO desde una entity como parametro
     * @param tipo 
     */
    public TipoDocumentoDTO(TipoDocumentoEntity tipo){
        this.idtipo = tipo.getIdtipo();
        this.nomTipoId = tipo.getNomTipoId();
    }

    public Long getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Long idtipo) {
        this.idtipo = idtipo;
    }

    public String getNomTipoId() {
        return nomTipoId;
    }

    public void setNomTipoId(String nomTipoId) {
        this.nomTipoId = nomTipoId;
    }
    /**
     * Creacion de tipodocumentoentity a partir del objeto DTO
     * @return 
     */
    public TipoDocumentoEntity toEntity(){
        TipoDocumentoEntity tipoDoc = new TipoDocumentoEntity();
        tipoDoc.setIdtipo(this.idtipo);
        tipoDoc.setNomTipoId(this.nomTipoId);
         return tipoDoc; 
    }
    /**
     * Conversion masiva de tipodocumentoentity a tipodocumentoDTO
     * @param tiposEntity
     * @return 
     */
    public  static List<TipoDocumentoDTO> toTipoDocumentoList(List<TipoDocumentoEntity> tiposEntity){
        List<TipoDocumentoDTO> listaTipoDocumentoDTO =new ArrayList<>();
        for(int i = 0; i < tiposEntity.size(); i++){
            listaTipoDocumentoDTO.add(new TipoDocumentoDTO(tiposEntity.get(i)));
        }
        return listaTipoDocumentoDTO;
    }
    
    }
