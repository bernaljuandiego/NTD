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
@Entity(name = "Compra")
public class CompraEntity implements Serializable {

    private final static long serialVersionUID = 1L;
    
    /**
     * Codigo de la compra
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cod_compra", nullable = false)
    private Long codCompra;

    /**
     * valoracion de la compra
     */
    @Column(name = "valoracion")
    private String valoracion;
    
    /**
     * Atributo que controla la relación con la Tabla Tarjeta_usuario.
     */
    @ManyToOne
    @JoinColumn(name = "cod_tarjeta")
    private  TarjetaUsuarioEntity tarjeta;
    
    /**
     * Atributo que controla la relación con la Tabla Usuario.
     */
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;
    
    /**
     * Atributo que controla la relación con la Tabla Residencia.
     */
    @ManyToOne
    @JoinColumn(name = "cod_residencia")
    private ResidenciaEntity residencia;
    
    /**
     * Atributo que controla la relación con la Tabla Producto.
     */
    @ManyToOne
    @JoinColumn(name = "cod_producto")
    private ProductoEntity producto;

    //Getters y Setters de la tabla Rol

    public Long getCodCompra() {
        return codCompra;
    }

    public void setCodCompra(Long codCompra) {
        this.codCompra = codCompra;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public TarjetaUsuarioEntity getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaUsuarioEntity tarjeta) {
        this.tarjeta = tarjeta;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public ResidenciaEntity getResidencia() {
        return residencia;
    }

    public void setResidencia(ResidenciaEntity residencia) {
        this.residencia = residencia;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }
}