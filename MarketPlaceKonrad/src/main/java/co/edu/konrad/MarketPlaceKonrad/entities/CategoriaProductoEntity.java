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
import javax.persistence.JoinColumn;

/**
 *
 * @author Manuel S. Nino
 */
@Entity(name = "Categoria_producto")
public class CategoriaProductoEntity implements Serializable {

    /**
     * Controlador de versiones
     *
     */
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cod_categoriaProducto")
    private Long codCategoriaProducto;
    /**
     *
     * Relacion con categoria
     */
    @ManyToOne
    @JoinColumn(name = "cod_categoria")
    private CategoriaEntity codCategoria;
    /**
     * Relacion con producto
     */
    @ManyToOne
    @JoinColumn(name = "cod_producto")
    private ProductoEntity producto;

    public Long getCodCategoriaProducto() {
        return codCategoriaProducto;
    }

    public void setCodCategoriaProducto(Long codCategoriaProducto) {
        this.codCategoriaProducto = codCategoriaProducto;
    }

    public CategoriaEntity getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(CategoriaEntity codCategoria) {
        this.codCategoria = codCategoria;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }
}
