/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.dto;

import co.edu.konrad.MarketPlaceKonrad.entities.MarcaEntity;
import co.edu.konrad.MarketPlaceKonrad.entities.ProductoEntity;
import co.edu.konrad.MarketPlaceKonrad.entities.ProovedorEntity;
import co.edu.konrad.MarketPlaceKonrad.entities.TipoProductoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Mapeo Entidades a DTO'S y DTO'S a entidades para Producto
 *
 * @author Manuel S. Nino
 */
public class ProductoDTO {

    /**
     * Variables tipo DTO del Producto
     *
     */
    private String nomProducto;
    private Long codProducto;
    private double valorUnitario;
    private int garantia;
    private int stockDisponible;
    private TipoProductoDTO tipoProducto;
    private MarcaDTO marca;
    private ProovedorDTO proveedor;

    /**
     * Mapeo ProductoEntity a ProductoDTO
     *
     * @param producto
     */
    
    
    public ProductoDTO(){
        
    }
    
    public ProductoDTO(ProductoEntity producto) {
        this.nomProducto = producto.getNomProducto();
        this.codProducto = producto.getCodProducto();
        this.valorUnitario = producto.getValorUnitario();
        this.garantia = producto.getGarantia();
        this.stockDisponible = producto.getGarantia();
        if (producto.getTipoProducto() != null) {
            TipoProductoEntity tipoProducto = new TipoProductoEntity();
            tipoProducto.setCodTipoProducto(producto.getTipoProducto().getCodTipoProducto());
            tipoProducto.setNomTipoProducto(producto.getTipoProducto().getNomTipoProducto());
            tipoProducto.setDescripcion(producto.getTipoProducto().getDescripcion());
            this.tipoProducto = new TipoProductoDTO(tipoProducto);
        }
        if (producto.getMarca() != null) {
            MarcaEntity marca = new MarcaEntity();
            marca.setCodMarca(producto.getMarca().getCodMarca());
            marca.setNomMarca(producto.getMarca().getNomMarca());
            this.marca = new MarcaDTO(marca);
        }
        if (producto.getProovedor() != null) {
            ProovedorEntity proveedor = new ProovedorEntity();
            proveedor.setNitProovedor(producto.getProovedor().getNitProovedor());
            proveedor.setUsuario(producto.getProovedor().getUsuario());
            proveedor.setContraseña(producto.getProovedor().getContraseña());
            proveedor.setAvatar(producto.getProovedor().getAvatar());
            proveedor.setMailProovedor(producto.getProovedor().getMailProovedor());
            proveedor.setNombreEmpresa(producto.getProovedor().getNombreEmpresa());
            proveedor.setDireccion(producto.getProovedor().getDireccion());
            proveedor.setChatProovedor(producto.getProovedor().getChatProovedor());
            this.proveedor = new ProovedorDTO(producto.getProovedor());
        }
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    /**
     * Mapeo ProductoDTO a ProductoEntity
     *
     * @return ProductoEntity
     */
    public ProductoEntity toEntity() {
        ProductoEntity producto = new ProductoEntity();
        producto.setCodProducto(this.codProducto);
        producto.setValorUnitario(this.valorUnitario);
        producto.setGarantia(this.garantia);
        producto.setStockDisponible(this.stockDisponible);
        if (this.tipoProducto != null) {
            TipoProductoEntity tipoProducto = new TipoProductoEntity();
            tipoProducto.setCodTipoProducto(this.tipoProducto.getCodTipoProducto());
            tipoProducto.setNomTipoProducto(this.tipoProducto.getNomTipoProducto());
            tipoProducto.setDescripcion(this.tipoProducto.getDescripcion());
            producto.setTipoProducto(tipoProducto);
        }
        if (this.marca != null) {
            MarcaEntity marca = new MarcaEntity();
            marca.setCodMarca(this.marca.getCodMarca());
            marca.setNomMarca(this.marca.getNomMarca());
        }
        if (this.proveedor != null) {
            ProovedorEntity proveedor = new ProovedorEntity();
            proveedor.setNitProovedor(this.proveedor.getNitProovedor());
            proveedor.setUsuario(this.proveedor.getUsuario());
            proveedor.setContraseña(this.proveedor.getContraseña());
            proveedor.setAvatar(this.proveedor.getAvatar());
            proveedor.setMailProovedor(this.proveedor.getMailProovedor());
            proveedor.setNombreEmpresa(this.proveedor.getNombreEmpresa());
            proveedor.setDireccion(this.proveedor.getDireccion());
            proveedor.setChatProovedor(this.proveedor.getChatProovedor());
        }

        return producto;
    }

    /**
     * Mapeo para el caso de más de un ProductoEntity a ProductoDTO
     *
     * @param productoList
     * @return listaProductoDTO
     */
    public static List<ProductoDTO> toProductoList(List<ProductoEntity> productoList) {
        List<ProductoDTO> listaProductoDTO = new ArrayList<>();
        for (int i = 0; i < listaProductoDTO.size(); i++) {
            listaProductoDTO.add(new ProductoDTO(productoList.get(i)));
        }
        return listaProductoDTO;
    }
    // Getter and Settter Para poder recibir y enviar los datos de ProductoDTO

    public Long getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Long codProducto) {
        this.codProducto = codProducto;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    public int getStockDisponible() {
        return stockDisponible;
    }

    public void setStockDisponible(int stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

    public TipoProductoDTO getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProductoDTO tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public MarcaDTO getMarca() {
        return marca;
    }

    public void setMarca(MarcaDTO marca) {
        this.marca = marca;
    }

    public ProovedorDTO getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProovedorDTO proveedor) {
        this.proveedor = proveedor;
    }
}
