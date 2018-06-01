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
 * @author Juan Diego Bernal
 */

@Entity(name = "Tipo_tarjeta")
public class TipoTarjetaEntity implements Serializable {

    private final static long serialVersionUID = 1L;
    
    /**
     * Codigo del tipo de tarjeta
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cod_tipo_tarjeta", nullable = false)
    private Long codTipoTarjeta;

    /**
     * nombre del tipo de tarjeta
     */
    @Column(name = "nom_tipo_tarjeta")
    private String nomTipoTarjeta;

    //Getters y Setters de la tabla Tipo Tarjeta

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
