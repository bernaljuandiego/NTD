/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.dto;

import co.edu.konrad.MarketPlaceKonrad.entities.TipoTarjetaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Diego Bernal
 */
public class TipoTarjetaDTO {

    /**
     * codigo del tipo de la tarjeta
     */
    private Long codTipoTarjeta;

    /**
     * nombre del tipo de la tarjeta
     */
    private String nomTipoTarjeta;

    /**
     * constructor por defecto
     */
    public TipoTarjetaDTO() {
    }
    
     /**
     * Converson de entity a objeto como parametro pasando una entity
     *
     * @param tipoTarjeta 
     */
    public TipoTarjetaDTO(TipoTarjetaEntity tipoTarjeta) {
        this.codTipoTarjeta = tipoTarjeta.getCodTipoTarjeta();
        this.nomTipoTarjeta = tipoTarjeta.getNomTipoTarjeta();
    }

    /**
     * Converson de objeto a entidad
     *
     * @return
     */
    public TipoTarjetaEntity toEntity() {
        TipoTarjetaEntity tipoTarjeta = new TipoTarjetaEntity();
        tipoTarjeta.setCodTipoTarjeta(this.codTipoTarjeta);
        tipoTarjeta.setNomTipoTarjeta(this.nomTipoTarjeta);
        return tipoTarjeta;
    }

    /**
     * Conversion masiva entre TipoTarjetaEntity a TipoTarjetaDTO
     * @param tiposTarjeta
     * @return 
     */
    public static List<TipoTarjetaDTO> toTipoTarjetaList(List<TipoTarjetaEntity> tiposTarjetas) {
        List<TipoTarjetaDTO> listaTipoTarjetaDTO = new ArrayList<>();
        for (TipoTarjetaEntity tiposTarjeta : tiposTarjetas) {
            listaTipoTarjetaDTO.add(new TipoTarjetaDTO(tiposTarjeta));
        }
        return listaTipoTarjetaDTO;
    }
    
    /*
    getters y setters
    */

    public Long getCodTipoTarjeta() {
        return codTipoTarjeta;
    }

    public void setCodTipoTarjeta(Long codTipoTarjeta) {
        this.codTipoTarjeta = codTipoTarjeta;
    }

    public String getNomTipoTarjeta() {
        return nomTipoTarjeta;
    }

    public void setNomTipoTarjeta(String nomTipoTarjeta) {
        this.nomTipoTarjeta = nomTipoTarjeta;
    }
    
   
}
