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
@Entity(name = "Tipo_producto")
public class TipoProductoEntity implements Serializable{
    /**
     * Controlador de versiones
     * 
     */
    private final static long serialVersionUID = 1L;
    
     /**
     * Codigo del tipo producto  - llave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cod_tipo_producto" , nullable = false )
    private Long codTipoProducto;
    
     /**
     * nombre del tipo producto 
     */    
    @Column (name = "nom_tipo_producto", nullable = false)
    private String nomTipoProducto;
    
     /**
     * descripcion del tipo producto 
     */    
    @Column (name = "descripcion", nullable = false)
    private String descripcion;    
    
        public Long getCodTipoProducto() {
        return codTipoProducto;
    }

    public void setCodTipoProducto(Long codTipo) {
        this.codTipoProducto = codTipo;
    }

    public String getNomTipoProducto() {
        return nomTipoProducto;
    }

    public void setNomTipoProducto(String nomTipoProducto) {
        this.nomTipoProducto = nomTipoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
