/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.dto;

import co.edu.konrad.MarketPlaceKonrad.entities.TipoProductoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Mapeo Entidades a DTO'S y DTO'S a entidades para TipoProducto
 *
 * @author Manuel S. Nino
 */
public class TipoProductoDTO {
    // Variables tipo DTO para TipoProducto

    private Long codTipoProducto;

    private String nomTipoProducto;

    private String descripcion;

    
    
    
    public TipoProductoDTO(){
        
    }
    /**
     * Mapeo TipoProductoEntity a TipoProductoDTO
     *
     * @param tipoProducto
     */
    
    
    public TipoProductoDTO(TipoProductoEntity tipoProducto) {
        this.codTipoProducto = tipoProducto.getCodTipoProducto();
        this.nomTipoProducto = tipoProducto.getNomTipoProducto();
        this.descripcion = tipoProducto.getDescripcion();
    }

    /**
     * Mapeo TipoProductoDTO a TipoProductoEntitu
     *
     * @return TipoProductoEntity
     */
    public TipoProductoEntity toEntity() {
        TipoProductoEntity tipoProducto = new TipoProductoEntity();
        tipoProducto.setCodTipoProducto(this.codTipoProducto);
        tipoProducto.setNomTipoProducto(this.nomTipoProducto);
        tipoProducto.setDescripcion(this.descripcion);
        return tipoProducto;
    }

    /**
     * Mapeo para el caso de más de un TipoProductoEntity a TipoProductoDTO
     *
     * @param tipoProductoList
     * @return listaTipoProductoDTo
     */
    public static List<TipoProductoDTO> toTipoProductoList(List<TipoProductoEntity> tipoProductoList) {
        List<TipoProductoDTO> listaTipoProductoDTo = new ArrayList<>();
        for (int i = 0; i < tipoProductoList.size(); i++) {
            listaTipoProductoDTo.add(new TipoProductoDTO(tipoProductoList.get(i)));
        }
        return listaTipoProductoDTo;
    }

    // Getter and Settter Para poder recibir y enviar los datos de TipoProductoDTO
    public Long getCodTipoProducto() {
        return codTipoProducto;
    }

    public void setCodTipoProducto(Long codTipoProducto) {
        this.codTipoProducto = codTipoProducto;
    }

    public String getNomTipoProducto() {
        return nomTipoProducto;
    }

    public void setNomTipoProducto(String nomTipoProducto) {
        this.nomTipoProducto = nomTipoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
