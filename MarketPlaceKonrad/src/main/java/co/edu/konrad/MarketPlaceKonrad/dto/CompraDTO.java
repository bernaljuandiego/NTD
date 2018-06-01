/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.dto;

import co.edu.konrad.MarketPlaceKonrad.entities.CompraEntity;
import co.edu.konrad.MarketPlaceKonrad.entities.ProductoEntity;
import co.edu.konrad.MarketPlaceKonrad.entities.ResidenciaEntity;
import co.edu.konrad.MarketPlaceKonrad.entities.TarjetaUsuarioEntity;
import co.edu.konrad.MarketPlaceKonrad.entities.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO para el mapeo objeto relacional de una entidad estudiante
 *
 * @author Juan Diego Bernal
 */
public class CompraDTO {
    /**
     * codigo de la compra
     */
    private Long codCompra;
    /**
     * valoracion de la compra
     */
    private String valoracion;
    /**
     * tarjeta de la compra
     */
    private TarjetaUsuarioDTO tarjeta;
    /**
     * residencia de entrega de la compra
     */
    private ResidenciaDTO residencia;
    /**
     * producto de la compra
     */
    private ProductoDTO producto;
    /**
     * usuario de la compra
     */
    private UsuarioDTO usuario;

    /**
     * Constructor por defecto
     */
    public CompraDTO() {
    }

    /**
     * Constructor
     *
     * @param compra
     */
    public CompraDTO(CompraEntity compra) {
        this.codCompra = compra.getCodCompra();
        this.valoracion = compra.getValoracion();
        if (compra.getProducto() != null) {
            ProductoEntity productoEntity = new ProductoEntity();
            productoEntity.setCodProducto(compra.getProducto().getCodProducto());
            productoEntity.setNomProducto(compra.getProducto().getNomProducto());
            productoEntity.setValorUnitario(compra.getProducto().getValorUnitario());
            productoEntity.setGarantia(compra.getProducto().getGarantia());
            productoEntity.setStockDisponible(compra.getProducto().getStockDisponible());
            productoEntity.setTipoProducto(compra.getProducto().getTipoProducto());
            productoEntity.setMarca(compra.getProducto().getMarca());
            productoEntity.setProovedor(compra.getProducto().getProovedor());
            this.producto = new ProductoDTO(productoEntity);
        }
        if (compra.getUsuario() != null) {
            UsuarioEntity user = new UsuarioEntity();
            user.setIdUsuario(compra.getUsuario().getIdUsuario());
            user.setNombreUsuario(compra.getUsuario().getNombreUsuario());
            user.setApellidoUsuario(compra.getUsuario().getApellidoUsuario());
            user.setFechaNacimiento(compra.getUsuario().getFechaNacimiento());
            user.setTelefonoUsuario(compra.getUsuario().getTelefonoUsuario());
            user.setMailUsuario(compra.getUsuario().getMailUsuario());
            user.setContraseñaUsuario(compra.getUsuario().getContraseñaUsuario());
            user.setAvatar(compra.getUsuario().getAvatar());
            user.setRol(compra.getUsuario().getRol());
            user.setTipoDocumento(compra.getUsuario().getTipoDocumento());
            this.usuario =  new UsuarioDTO(user);
        }
        if (compra.getResidencia() != null) {
            ResidenciaEntity residenciaEntity = new ResidenciaEntity();
            residenciaEntity.setCodResidencia(compra.getResidencia().getCodResidencia());
            residenciaEntity.setNombreResidencia(compra.getResidencia().getNombreResidencia());
            residenciaEntity.setDireccionResidencia(compra.getResidencia().getDireccionResidencia());
            residenciaEntity.setUsuario(compra.getResidencia().getUsuario());
            residenciaEntity.setCiudad(compra.getResidencia().getCiudad());
            this.residencia =  new ResidenciaDTO(residenciaEntity);
        }
        if (compra.getTarjeta()!= null) {
            TarjetaUsuarioEntity tarjetaUsuarioEntity = new TarjetaUsuarioEntity();
            tarjetaUsuarioEntity.setCodTarjeta(compra.getTarjeta().getCodTarjeta());
            tarjetaUsuarioEntity.setNomBanco(compra.getTarjeta().getNomBanco());
            tarjetaUsuarioEntity.setNumCuenta(compra.getTarjeta().getNumCuenta());
            tarjetaUsuarioEntity.setNumFranquicia(compra.getTarjeta().getNumFranquicia());
            tarjetaUsuarioEntity.setNumTarjeta(compra.getTarjeta().getNumTarjeta());
            tarjetaUsuarioEntity.setFecVencimiento(compra.getTarjeta().getFecVencimiento());
            tarjetaUsuarioEntity.setCodClave(compra.getTarjeta().getCodClave());
            this.tarjeta =  new TarjetaUsuarioDTO(tarjetaUsuarioEntity);
        }
    }

    public CompraEntity toEntity() {
        CompraEntity compra = new CompraEntity();
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
            compra.setUsuario(user);
        }
        if (compra.getProducto() != null) {
            ProductoEntity productoEntity = new ProductoEntity();
            productoEntity.setCodProducto(this.producto.getCodProducto());
            productoEntity.setNomProducto(this.producto.getNomProducto());
            productoEntity.setValorUnitario(this.producto.getValorUnitario());
            productoEntity.setGarantia(this.producto.getGarantia());
            productoEntity.setStockDisponible(this.producto.getStockDisponible());
            productoEntity.setTipoProducto(this.producto.getTipoProducto().toEntity());
            productoEntity.setMarca(this.producto.getMarca().toEntity());
            productoEntity.setProovedor(this.producto.getProveedor().toEntity());
            compra.setProducto(productoEntity);
        }
        if (compra.getResidencia() != null) {
            ResidenciaEntity residenciaEntity = new ResidenciaEntity();
            residenciaEntity.setCodResidencia(this.residencia.getCodResidencia());
            residenciaEntity.setNombreResidencia(this.residencia.getNombreResidencia());
            residenciaEntity.setDireccionResidencia(this.residencia.getDireccionResidencia());
            residenciaEntity.setUsuario(this.residencia.getUsuario().toEntity());
            residenciaEntity.setCiudad(this.residencia.getCiudad().toEntity());
            compra.setResidencia(residenciaEntity);
        }
        if (compra.getTarjeta()!= null) {
            TarjetaUsuarioEntity tarjetaUsuarioEntity = new TarjetaUsuarioEntity();
            tarjetaUsuarioEntity.setCodTarjeta(this.tarjeta.getCodTarjeta());
            tarjetaUsuarioEntity.setNomBanco(this.tarjeta.getNomBanco());
            tarjetaUsuarioEntity.setNumCuenta(this.tarjeta.getNumCuenta());
            tarjetaUsuarioEntity.setNumFranquicia(this.tarjeta.getNumFranquicia());
            tarjetaUsuarioEntity.setNumTarjeta(this.tarjeta.getNumTarjeta());
            tarjetaUsuarioEntity.setFecVencimiento(this.tarjeta.getFecVencimiento());
            tarjetaUsuarioEntity.setCodClave(this.tarjeta.getCodClave());
            compra.setTarjeta(tarjetaUsuarioEntity);
        }
        return compra;
    }

    public static List<CompraDTO> toCompraList(List<CompraEntity> compraList) {
        List<CompraDTO> listaCompras = new ArrayList<>();
        for (CompraEntity compra : compraList) {
            listaCompras.add(new CompraDTO(compra));
        }
        return listaCompras;
    }

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

    public TarjetaUsuarioDTO getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaUsuarioDTO tarjeta) {
        this.tarjeta = tarjeta;
    }

    public ResidenciaDTO getResidencia() {
        return residencia;
    }

    public void setResidencia(ResidenciaDTO residencia) {
        this.residencia = residencia;
    }

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