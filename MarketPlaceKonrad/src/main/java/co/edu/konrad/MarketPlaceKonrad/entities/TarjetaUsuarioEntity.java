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
 * @author Juan Diego Bernal
 */
@Entity(name = "Tarjeta_usuario")
public class TarjetaUsuarioEntity implements Serializable {

    private final static long serialVersionUID = 1L;
    
    /**
     * Codigo de la tarjeta
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cod_tarjeta", nullable = false)
    private Long codTarjeta;

    /**
     * nombre del banco para tarjetas debito 
     */
    @Column(name = "nom_banco")
    private String nomBanco;
    
    /**
     * numero de la cuenta para tarjetas debito 
     */
    @Column(name = "num_cuenta")
    private String numCuenta;
    
    /**
     * numero de la franquicia para tarjetas cedito
     */
    @Column(name = "num_franquicia")
    private String numFranquicia;
    
    /**
     * numero de la tarjeta para tarjetas cedito
     */
    @Column(name = "num_tarjeta")
    private String numTarjeta;
    
    /**
     * fecha de vencimiento para tarjetas cedito
     */
    @Column(name = "fec_vencimiento")
    private String fecVencimiento;
    
    /**
     * clave para tarjetas cedito
     */
    @Column(name = "cod_clave")
    private String codClave;
    
    /**
     * Atributo que controla la relación con la Tabla Usuario.
     */
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;
    
    /**
     * Atributo que controla la relación con la Tabla Tipo_tarjeta.
     */
    @ManyToOne
    @JoinColumn(name = "cod_tipo_tarjeta")
    private TipoTarjetaEntity tipoTarjeta;
    
    //Getters y Setters de la tabla Rol

    public Long getCodTarjeta() {
        return codTarjeta;
    }

    public void setCodTarjeta(Long codTarjeta) {
        this.codTarjeta = codTarjeta;
    }

    public String getNomBanco() {
        return nomBanco;
    }

    public void setNomBanco(String nomBanco) {
        this.nomBanco = nomBanco;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getNumFranquicia() {
        return numFranquicia;
    }

    public void setNumFranquicia(String numFranquicia) {
        this.numFranquicia = numFranquicia;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getFecVencimiento() {
        return fecVencimiento;
    }

    public void setFecVencimiento(String fecVencimiento) {
        this.fecVencimiento = fecVencimiento;
    }

    public String getCodClave() {
        return codClave;
    }

    public void setCodClave(String codClave) {
        this.codClave = codClave;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public TipoTarjetaEntity getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(TipoTarjetaEntity tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }
}