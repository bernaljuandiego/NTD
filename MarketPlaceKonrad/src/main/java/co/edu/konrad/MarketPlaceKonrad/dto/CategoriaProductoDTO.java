/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.dto;

import co.edu.konrad.MarketPlaceKonrad.entities.CategoriaEntity;
import co.edu.konrad.MarketPlaceKonrad.entities.CategoriaProductoEntity;
import co.edu.konrad.MarketPlaceKonrad.entities.MarcaEntity;
import co.edu.konrad.MarketPlaceKonrad.entities.ProductoEntity;
import co.edu.konrad.MarketPlaceKonrad.entities.ProovedorEntity;
import co.edu.konrad.MarketPlaceKonrad.entities.TipoProductoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manuel S. Nino
 */
public class CategoriaProductoDTO {

    /**
     * Variables tipo DTO de CategoriaProductoDto
     *
     */
    private Long codCategoriaProducto;

    private CategoriaDTO categoria;

    private ProductoDTO producto;

    /**
     * Mapeo CategoriaProductoEntity a CategoriaProductoDTO
     *
     * @param categoriaProducto
     */
    
    
    public CategoriaProductoDTO(){
        
    }
    public CategoriaProductoDTO(CategoriaProductoEntity categoriaProducto) {
        this.codCategoriaProducto = categoriaProducto.getCodCategoriaProducto();
        if (categoriaProducto.getCodCategoria() != null) {
            CategoriaEntity categoria = new CategoriaEntity();
            categoria.setCodCategoria(categoriaProducto.getCodCategoria().getCodCategoria());
            categoria.setNomCategoria(categoriaProducto.getCodCategoria().getNomCategoria());
            categoria.setDescripcionCategoria(categoriaProducto.getCodCategoria().getDescripcionCategoria());
            this.categoria = new CategoriaDTO(categoria);
        }
        if (categoriaProducto.getProducto() != null) {
            ProductoEntity producto = new ProductoEntity();
            producto.setCodProducto(categoriaProducto.getProducto().getCodProducto());
            producto.setGarantia(categoriaProducto.getProducto().getGarantia());
            producto.setMarca(categoriaProducto.getProducto().getMarca());
            producto.setNomProducto(categoriaProducto.getProducto().getNomProducto());
            producto.setProovedor(categoriaProducto.getProducto().getProovedor());
            producto.setStockDisponible(categoriaProducto.getProducto().getStockDisponible());
            producto.setTipoProducto(categoriaProducto.getProducto().getTipoProducto());
            producto.setValorUnitario(categoriaProducto.getProducto().getValorUnitario());
            this.producto = new ProductoDTO(producto);
        }
    }

    /**
     * Mapeo CategoriaProductoDTO a CategoriaProductoEntity
     *
     * @return CategoriaProductoEntity
     */
    public CategoriaProductoEntity toEntity() {
        CategoriaProductoEntity categoriaProducto = new CategoriaProductoEntity();
        categoriaProducto.setCodCategoriaProducto(this.codCategoriaProducto);
        if (this.categoria != null) {
            CategoriaEntity categoria = new CategoriaEntity();
            categoria.setCodCategoria(this.categoria.getCodCategoria());
            categoria.setNomCategoria(this.categoria.getNomCategoria());
            categoria.setDescripcionCategoria(this.categoria.getDescripcionCategoria());
            categoriaProducto.setCodCategoria(categoria);
        }
        if (this.producto != null) {
            ProductoEntity producto = new ProductoEntity();
            producto.setCodProducto(this.producto.getCodProducto());
            producto.setGarantia(this.producto.getGarantia());
            categoriaProducto.setProducto(producto);
            if (categoriaProducto.getProducto().getMarca() != null) {
                MarcaEntity marca = new MarcaEntity();
                marca.setCodMarca(this.producto.getMarca().getCodMarca());
                marca.setNomMarca(this.producto.getMarca().getNomMarca());
                categoriaProducto.getProducto().setMarca(marca);// REVISAR
            }
            producto.setNomProducto(this.producto.getNomProducto());
            if (categoriaProducto.getProducto().getProovedor() != null) {
                ProovedorEntity proveedor = new ProovedorEntity();
                proveedor.setAvatar(this.producto.getProveedor().getAvatar());
                proveedor.setChatProovedor(this.producto.getProveedor().getChatProovedor());
                proveedor.setContraseña(this.producto.getProveedor().getContraseña());
                proveedor.setDireccion(this.producto.getProveedor().getDireccion());
                proveedor.setMailProovedor(this.producto.getProveedor().getMailProovedor());
                proveedor.setNitProovedor(this.producto.getProveedor().getNitProovedor());
                proveedor.setNombreEmpresa(this.producto.getProveedor().getNombreEmpresa());
                proveedor.setUsuario(this.producto.getProveedor().getUsuario());
                categoriaProducto.getProducto().setProovedor(proveedor);
            }
            producto.setStockDisponible(this.producto.getStockDisponible());
            if (categoriaProducto.getProducto().getTipoProducto() != null) {
                TipoProductoEntity tipoProducto = new TipoProductoEntity();
                tipoProducto.setCodTipoProducto(this.producto.getTipoProducto().getCodTipoProducto());
                tipoProducto.setNomTipoProducto(this.producto.getTipoProducto().getNomTipoProducto());
                tipoProducto.setDescripcion(this.producto.getTipoProducto().getDescripcion());
                categoriaProducto.getProducto().setTipoProducto(tipoProducto);
            }
            producto.setValorUnitario(this.producto.getValorUnitario());
        }
        return categoriaProducto;
    }

    /**
     * Mapeo para el caso de más de un CategoriaProductoEntity a
     * CategoriaProductoDTO
     *
     * @param categoriaProductoList
     * @return listaCategoriaProductoDTO
     */
    public static List<CategoriaProductoDTO> listCategoriaProductoDTO(List<CategoriaProductoEntity> listCategoriaProducto) {
        List<CategoriaProductoDTO> listCategoriaProductoDTO = new ArrayList<>();
        for (int i = 0; i < listCategoriaProducto.size(); i++) {
            listCategoriaProductoDTO.add(new CategoriaProductoDTO(listCategoriaProducto.get(i)));
        }

        return listCategoriaProductoDTO;
    }
}
