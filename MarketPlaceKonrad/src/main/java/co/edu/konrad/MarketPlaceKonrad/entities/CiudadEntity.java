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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Leonardo Ruiz
 * tabla ciudad
 */
@Entity(name ="Ciudad")
public class CiudadEntity implements Serializable{
    
    private final static long serialVersionUID = 1L;
    /**
     * Codigo de la ciudad  - llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cod_ciudad" , nullable = false )
    private Long codCiudad;
    
    /**
     * Nombre de la ciudad
     */
    @Column(name = "nom_ciudad" , nullable = false)
    private String nomCiudad;
    /**
     * Relacion muchos a uno con la tabla pais
     */
    @ManyToOne
    @JoinColumn(name = "cod_pais")
    private PaisEntity pais;
//Getters y Setters de la tabla Ciudad
    public PaisEntity getPais() {
        return pais;
    }

    public void setPais(PaisEntity pais) {
        this.pais = pais;
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
    
    
}
