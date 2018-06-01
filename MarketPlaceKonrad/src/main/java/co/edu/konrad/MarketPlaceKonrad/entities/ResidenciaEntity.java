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
 * tabla residencia
 */
@Entity(name = "Residencia")
public class ResidenciaEntity implements Serializable {

    private final static long serialVersionUID = 1L;
   /**
    * Codigo de la residencia - llave primaria
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cod_Residencia", nullable = false)
    private Long codResidencia;
    /**
     * Nombre de la residencia 
     */
    @Column(name = "nom_residencia", nullable = false)
    private String nombreResidencia;
    
    /**
     * Direccion donde esta ubicada la residencia 
     */
    @Column(name = "direccion", nullable = false, unique = true)
    private String DireccionResidencia;

    /**
     * Relacion muchos a uno con la tabla usuario
     */
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    /*
    Relacion muchos a uno con la tabla ciudad
     */
    @ManyToOne
    @JoinColumn(name = "cod_ciudad")
    private CiudadEntity ciudad;
    
    // Getters y Setters de la tabla Residencia

    public Long getCodResidencia() {
        return codResidencia;
    }

    public void setCodResidencia(Long codResidencia) {
        this.codResidencia = codResidencia;
    }

    

    public String getNombreResidencia() {
        return nombreResidencia;
    }

    public void setNombreResidencia(String nombreResidencia) {
        this.nombreResidencia = nombreResidencia;
    }

    public String getDireccionResidencia() {
        return DireccionResidencia;
    }

    public void setDireccionResidencia(String DireccionResidencia) {
        this.DireccionResidencia = DireccionResidencia;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public CiudadEntity getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadEntity ciudad) {
        this.ciudad = ciudad;
    }

}
