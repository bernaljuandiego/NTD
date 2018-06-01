/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Leonardo Ruiz
 * tabla tipo_id
 */
@Entity(name = "tipo_documento")
public class TipoDocumentoEntity implements Serializable{
    
    private final static long serialVersionUID = 1L;
    /**
     * Codigo del tipo de documento - llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cod_tipo_documento", nullable = false)
    private Long idtipo;
    /**
     * Nombre del tipo de documento
     */
    @Column(name ="nom_documento" ,nullable = false , unique= true)
    private String nomTipoId;
   //Getters y Setters de la tabla Tipo_documento
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
    
}
