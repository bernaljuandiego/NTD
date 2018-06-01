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
 */
@Entity(name ="rol")
public class RolEntity implements Serializable{
    
    
    private final static long serialVersionUID = 1L;
   /**
    * Codigo del rol - llave primaria
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cod_rol", nullable = false)
    private Long idRol;
    
    /**
     * Nombre del rol de usuario
     */
    
    @Column(name ="nom_rol")
    private String nombreRol;
  //Getters y Setters de la tabla Rol
    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    

    

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
