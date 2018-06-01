/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.dto;

import co.edu.konrad.MarketPlaceKonrad.entities.CategoriaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manuel S. Nino
 */
public class CategoriaDTO {

    /**
     * Variables tipo DTO de la categoria
     *
     */
    private Long codCategoria;

    private String NomCategoria;

    private String descripcionCategoria;

    /**
     * Mapeo categoriaEntity a categoriaDTO
     *
     * @param categoria
     */
    
    public CategoriaDTO(){
        
    }
    public CategoriaDTO(CategoriaEntity categoria) {
        this.codCategoria = categoria.getCodCategoria();
        this.NomCategoria = categoria.getNomCategoria();
        this.descripcionCategoria = categoria.getDescripcionCategoria();
    }
        /**
     * Mapeo de DTO a Entity
     * @return categoria
     */
    public CategoriaEntity toEntity() {
        CategoriaEntity categoria = new CategoriaEntity();
        categoria.setCodCategoria(this.codCategoria);
        categoria.setNomCategoria(this.NomCategoria);
        categoria.setDescripcionCategoria(this.descripcionCategoria);
        return categoria;
    }
    
 /**
     * Mapeo para el caso de más de un CategoriaEntity a CategoriaDTO
     *
     * @param listCategoria
     * @return listCategoriaDTO
     */
    public static List<CategoriaDTO> toCategoriaList(List<CategoriaEntity> listCategoria) {
        List<CategoriaDTO> listCategoriaDTO = new ArrayList<>();
        for (int i = 0; i < listCategoria.size(); i++) {
            listCategoriaDTO.add(new CategoriaDTO(listCategoria.get(i)));
        }
        return listCategoriaDTO;
    }
    
    public Long getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(Long codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getNomCategoria() {
        return NomCategoria;
    }

    public void setNomCategoria(String NomCategoria) {
        this.NomCategoria = NomCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

}
