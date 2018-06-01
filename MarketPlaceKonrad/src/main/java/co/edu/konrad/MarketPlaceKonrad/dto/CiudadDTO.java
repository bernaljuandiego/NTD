/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.dto;

import co.edu.konrad.MarketPlaceKonrad.entities.CiudadEntity;
import co.edu.konrad.MarketPlaceKonrad.entities.PaisEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo Ruiz
 */
public class CiudadDTO {
    
    
    private Long codCiudad;
    
    private String nomCiudad;
    
    private PaisDTO pais;
    
    
    public CiudadDTO(){
}
    /**
     * Conversion por medio de constructor de entity a DTO
     * @param ciuen 
     */
    public CiudadDTO(CiudadEntity ciuen){
        this.codCiudad =  ciuen.getCodCiudad();
        this.nomCiudad =  ciuen.getNomCiudad();
        if(ciuen.getPais() !=  null){
            PaisEntity pais =  new PaisEntity();
            pais.setCodPais(ciuen.getPais().getCodPais());
            pais.setNombrePais(ciuen.getPais().getNombrePais());
            
            this.pais =  new PaisDTO(pais);
            
        }    
        
    }
    
    /**
     * Conversion de DTO a entity
     * @return 
     */
    
    public CiudadEntity toEntity(){
        CiudadEntity ciu = new CiudadEntity();
        
        ciu.setCodCiudad(this.codCiudad);
        ciu.setNomCiudad(this.nomCiudad);
        
        if(this.pais !=  null){
            PaisEntity paisen =  new PaisEntity();
            
            pais.setCodPais(this.pais.getCodPais());
            pais.setNombrePais(this.pais.getNombrePais());
            
            ciu.setPais(paisen);
        }
        
        return ciu;
    }
    
    /**
     * Mapeo masivo de CiudadEntity a CiudadDTO
     * @param ciudadesEn
     * @return 
     */
    public static  List<CiudadDTO> toCiudadList(List<CiudadEntity> ciudadesEn){
        List<CiudadDTO> ciudades =  new ArrayList<>();
        
        for(int i = 0; i < ciudadesEn.size(); i++){
            ciudades.add(new CiudadDTO(ciudadesEn.get(i)));
        }
        
        return ciudades;
        
    }

    public Long getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(Long codCiudad) {
        this.codCiudad = codCiudad;
    }

    public String getNomCiudad() {
        return nomCiudad;
    }

    public void setNomCiudad(String nomCiudad) {
        this.nomCiudad = nomCiudad;
    }

    public PaisDTO getPais() {
        return pais;
    }

    public void setPais(PaisDTO pais) {
        this.pais = pais;
    }
    
    
}
