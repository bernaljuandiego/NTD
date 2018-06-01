/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.dto;

import co.edu.konrad.MarketPlaceKonrad.entities.MarcaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Mapeo Entidades a DTO'S y DTO'S a entidades para Marca
 *
 * @author Manuel S. Nino
 */
public class MarcaDTO {

    // Variables tipo DTO de la Marca
    private Long codMarca;

    private String nomMarca;

    
    
    
    public MarcaDTO(){
        
    }
    //Mapeo MarcaEntity a MarcaDTO
    public MarcaDTO(MarcaEntity marca) {
        this.codMarca = marca.getCodMarca();
        this.nomMarca = marca.getNomMarca();
    }

    //MarcaDTO a MarcaEntity
    public MarcaEntity toEntity() {
        MarcaEntity marca = new MarcaEntity();
        marca.setCodMarca(this.codMarca);
        marca.setNomMarca(this.nomMarca);
        return marca;
    }

    /**
     * Mapeo para el caso más de una MarcaEntity a MarcaDTO
     *
     * @param marcaList
     * @return listaMarcaDTO
     */
    public static List<MarcaDTO> toMarcaList(List<MarcaEntity> marcaList) {
        List<MarcaDTO> listaMarcaDTO = new ArrayList<>();
        for (int i = 0; i < marcaList.size(); i++) {
            listaMarcaDTO.add(new MarcaDTO(marcaList.get(i)));
        }

        return listaMarcaDTO;
    }

    // Getter and Settter Para poder recibir y enviar los datos de MarcaDTO
    public Long getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(Long codMarca) {
        this.codMarca = codMarca;
    }

    public String getNomMarca() {
        return nomMarca;
    }

    public void setNomMarca(String nomMarca) {
        this.nomMarca = nomMarca;
    }
}
