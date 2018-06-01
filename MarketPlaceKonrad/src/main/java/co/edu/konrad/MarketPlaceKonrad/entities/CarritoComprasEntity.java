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
@Entity(name = "Carrito_compras")
public class CarritoComprasEntity implements Serializable {

    private final static long serialVersionUID = 1L;
    
    /**
     * Atributo que controla la relación con la Tabla Usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    
    private UsuarioEntity usuario;
    
    /**
     * Atributo que controla la relación con la Tabla Producto.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ManyToOne
    @JoinColumn(name = "cod_producto")
   
    private ProductoEntity producto;

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }
    
    
}