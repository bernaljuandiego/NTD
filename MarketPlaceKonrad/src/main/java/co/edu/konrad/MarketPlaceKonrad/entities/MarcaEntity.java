/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
/**
 *
 * @author Manuel S. Nino
 */
@Entity
public class MarcaEntity implements Serializable {
    /**
     * Controlador de versiones
     * 
     */
private final static long serialVersionUID = 1L;
/**
 * Codigo de la marca - llave primaria
 * 
 */
@Id
@GeneratedValue (strategy = GenerationType.AUTO)
@Column (name = "cod_marca")
private Long codMarca;

/**
 * 
 * Nombre marca 
 */
@Column (name = "nom_marca")
private String nomMarca;
        

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
