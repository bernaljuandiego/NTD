/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.dto;

import co.edu.konrad.MarketPlaceKonrad.entities.PaisEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo Ruiz
 */
public class PaisDTO {
    
    
    private Long codPais;
    
    
    private String nombrePais;

    public Long getCodPais() {
        return codPais;
    }

    public void setCodPais(Long codPais) {
        this.codPais = codPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
    
    
    
    
    public PaisDTO(){
      }
    
    /**
     * Conversion de PaisEntity a PaisDTO por medio del constructor de paisDTO y pasando como parametro
     * una entidad de  PaisEntity
     * @param paisen 
     */
    public PaisDTO(PaisEntity paisen){
        this.codPais = paisen.getCodPais();
        this.nombrePais = paisen.getNombrePais();
        
        
    }
    /**
     * Conversion de Objeto DTO a entity
     * @return 
     */
    
    
    public PaisEntity toEntity(){
        PaisEntity pais =  new PaisEntity();
        pais.setCodPais(this.codPais);
        pais.setNombrePais(this.nombrePais);
        return pais;
    }
    /**
     * Mapeo masivo de PaisEntity a PaisDTO
     * @param paisesEn
     * @return 
     */
    
    public static List<PaisDTO> ToPaisList(List<PaisEntity> paisesEn){
        List<PaisDTO> paises =  new  ArrayList<>();
        
        for(int i = 0; i < paisesEn.size(); i++){
            paises.add(new PaisDTO(paisesEn.get(i)));
        }
        return paises;
    }
}
