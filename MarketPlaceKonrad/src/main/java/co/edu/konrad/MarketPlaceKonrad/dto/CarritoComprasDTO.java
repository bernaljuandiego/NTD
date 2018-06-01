/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.dto;

import co.edu.konrad.MarketPlaceKonrad.entities.CarritoComprasEntity;
import co.edu.konrad.MarketPlaceKonrad.entities.ProductoEntity;
import co.edu.konrad.MarketPlaceKonrad.entities.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO para el mapeo objeto relacional de una entidad estudiante
 *
 * @author Juan Diego Bernal
 */
public class CarritoComprasDTO {

    /**
     * producto del carrito
     */
    private ProductoDTO producto;

    /**
     * usuario del carrito
     */
    private UsuarioDTO usuario;

    /**
     * Constructor por defecto
     */
    public CarritoComprasDTO() {
    }

    /**
     * Constructor
     *
     * @param carrito
     */
    public CarritoComprasDTO(CarritoComprasEntity carrito) {
        if (carrito.getProducto() != null) {
            ProductoEntity producto = new ProductoEntity();
            producto.setCodProducto(carrito.getProducto().getCodProducto());
            producto.setNomProducto(carrito.getProducto().getNomProducto());
            producto.setValorUnitario(carrito.getProducto().getValorUnitario());
            producto.setGarantia(carrito.getProducto().getGarantia());
            producto.setStockDisponible(carrito.getProducto().getStockDisponible());
            producto.setTipoProducto(carrito.getProducto().getTipoProducto());
            producto.setMarca(carrito.getProducto().getMarca());
            producto.setProovedor(carrito.getProducto().getProovedor());
            this.producto = new ProductoDTO(producto);
        }
        if (carrito.getUsuario() != null) {
            UsuarioEntity user = new UsuarioEntity();
            user.setIdUsuario(carrito.getUsuario().getIdUsuario());
            user.setNombreUsuario(carrito.getUsuario().getNombreUsuario());
            user.setApellidoUsuario(carrito.getUsuario().getApellidoUsuario());
            user.setFechaNacimiento(carrito.getUsuario().getFechaNacimiento());
            user.setTelefonoUsuario(carrito.getUsuario().getTelefonoUsuario());
            user.setMailUsuario(carrito.getUsuario().getMailUsuario());
            user.setContraseñaUsuario(carrito.getUsuario().getContraseñaUsuario());
            user.setAvatar(carrito.getUsuario().getAvatar());
            user.setRol(carrito.getUsuario().getRol());
            user.setTipoDocumento(carrito.getUsuario().getTipoDocumento());
            this.usuario =  new UsuarioDTO(user);
        }
    }

    public CarritoComprasEntity toEntity() {
        CarritoComprasEntity carrito = new CarritoComprasEntity();
        if(this.usuario !=  null){
            UsuarioEntity user =  new UsuarioEntity();
            user.setIdUsuario(this.usuario.getIdUsuario());
            user.setNombreUsuario(this.usuario.getNombreUsuario());
            user.setApellidoUsuario(this.usuario.getApellidoUsuario());
            user.setFechaNacimiento(this.usuario.getFechaNacimiento());
            user.setTelefonoUsuario(this.usuario.getTelefonoUsuario());
            user.setMailUsuario(this.usuario.getMailUsuario());
            user.setAvatar(this.usuario.getAvatar());
            user.setContraseñaUsuario(this.usuario.getContraseñaUsuario());
            user.setRol(this.usuario.getRol().toEntity());
            user.setTipoDocumento(this.usuario.getTipoDocumento().toEntity());
            carrito.setUsuario(user);
        }
        if (carrito.getProducto() != null) {
            ProductoEntity producto = new ProductoEntity();
            producto.setCodProducto(this.producto.getCodProducto());
            producto.setNomProducto(this.producto.getNomProducto());
            producto.setValorUnitario(this.producto.getValorUnitario());
            producto.setGarantia(this.producto.getGarantia());
            producto.setStockDisponible(this.producto.getStockDisponible());
            producto.setTipoProducto(this.producto.getTipoProducto().toEntity());
            producto.setMarca(this.producto.getMarca().toEntity());
            producto.setProovedor(this.producto.getProveedor().toEntity());
            carrito.setProducto(producto);
        }
        return carrito;
    }
    /*
    pasar lista de dtos a entities
    */

    public static List<CarritoComprasDTO> toCarritoComprasList(List<CarritoComprasEntity> carritoComprasList) {
        List<CarritoComprasDTO> listaCarritos = new ArrayList<>();
        for (CarritoComprasEntity carrito : carritoComprasList) {
            listaCarritos.add(new CarritoComprasDTO(carrito));
        }
        return listaCarritos;
    }

    /*
    getters y setters
    */
    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }  
}