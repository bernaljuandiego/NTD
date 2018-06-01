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
 * tabla pais
 */
@Entity(name ="Pais")
public class PaisEntity implements Serializable{
    
    private final static long serialVersionUID = 1L;
    /**
     * Codigo del pais - llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cod_pais", nullable = false)
    private Long codPais;
    /**
     * Nombre del pais
     */
    
    @Column(name="nom_pais" , nullable = false)
    private String nombrePais;
 //Getters y Setters de la tabla pais
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
}
