/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.dto;

import co.edu.konrad.MarketPlaceKonrad.entities.TarjetaUsuarioEntity;
import co.edu.konrad.MarketPlaceKonrad.entities.TipoTarjetaEntity;
import co.edu.konrad.MarketPlaceKonrad.entities.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juandiego
 */
public class TarjetaUsuarioDTO {
    /**
     * codigo de la tarjeta
     */
    private Long codTarjeta;
    /**
     * nombre del banco
     */
    private String nomBanco;
    /**
     * numero de la cuenta
     */
    private String numCuenta;
    /**
     * numero de la franquicia
     */
    private String numFranquicia;
    /**
     * numero de la tarjeta
     */
    private String numTarjeta;
    /**
     * fecha de vencimiento de la trajeta
     */
    private String fecVencimiento;
    /**
     * clave
     */
    private String codClave;
    /**
     * dueño de la tarjeta
     */
    private UsuarioDTO usuario;
    /**
     * tipo de la tarjeta
     */
    private TipoTarjetaDTO tipoTarjeta;

     /**
     * Constructor por defecto
     */
    public TarjetaUsuarioDTO() {
    }

    /**
     * Constructor
     *
     * @param tajeta
     */
    public TarjetaUsuarioDTO(TarjetaUsuarioEntity tajeta) {
        this.codTarjeta = tajeta.getCodTarjeta();
        this.nomBanco = tajeta.getNomBanco();
        this.numCuenta = tajeta.getNumCuenta();
        this.numFranquicia = tajeta.getNumFranquicia();
        this.numTarjeta = tajeta.getNumTarjeta();
        this.fecVencimiento = tajeta.getFecVencimiento();
        this.codClave = tajeta.getCodClave();
        if (tajeta.getUsuario() != null) {
            UsuarioEntity user = new UsuarioEntity();
            user.setIdUsuario(tajeta.getUsuario().getIdUsuario());
            user.setNombreUsuario(tajeta.getUsuario().getNombreUsuario());
            user.setApellidoUsuario(tajeta.getUsuario().getApellidoUsuario());
            user.setFechaNacimiento(tajeta.getUsuario().getFechaNacimiento());
            user.setTelefonoUsuario(tajeta.getUsuario().getTelefonoUsuario());
            user.setMailUsuario(tajeta.getUsuario().getMailUsuario());
            user.setContraseñaUsuario(tajeta.getUsuario().getContraseñaUsuario());
            user.setAvatar(tajeta.getUsuario().getAvatar());
            user.setRol(tajeta.getUsuario().getRol());
            user.setTipoDocumento(tajeta.getUsuario().getTipoDocumento());
            this.usuario =  new UsuarioDTO(user);
        }
        if (tajeta.getTipoTarjeta()!= null) {
            TipoTarjetaEntity tipoTarjeta = new TipoTarjetaEntity();
            tipoTarjeta.setCodTipoTarjeta(tajeta.getTipoTarjeta().getCodTipoTarjeta());
            tipoTarjeta.setNomTipoTarjeta(tajeta.getTipoTarjeta().getNomTipoTarjeta());
            this.tipoTarjeta = new TipoTarjetaDTO(tipoTarjeta);
        }
    }

    public TarjetaUsuarioEntity toEntity() {
        TarjetaUsuarioEntity tarjeta = new TarjetaUsuarioEntity();
        tarjeta.setCodTarjeta(this.codTarjeta);
        tarjeta.setNomBanco(this.nomBanco);
        tarjeta.setNumCuenta(this.numCuenta);
        tarjeta.setNumFranquicia(this.numFranquicia);
        tarjeta.setNumTarjeta(this.numTarjeta);
        tarjeta.setFecVencimiento(this.fecVencimiento);
        tarjeta.setCodClave(this.codClave);
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
            tarjeta.setUsuario(user);
        }
        if (tarjeta.getTipoTarjeta()!= null) {
            TipoTarjetaEntity tipoTarjeta = new TipoTarjetaEntity();
            tipoTarjeta.setCodTipoTarjeta(this.tipoTarjeta.getCodTipoTarjeta());
            tipoTarjeta.setNomTipoTarjeta(this.tipoTarjeta.getNomTipoTarjeta());
            tarjeta.setTipoTarjeta(tipoTarjeta);
        }
        return tarjeta;
    }
    /*
    pasar lista de dtos a entities
    */

    public static List<TarjetaUsuarioDTO> toTarjetaUsuarioList(List<TarjetaUsuarioEntity> tajetaUsuarioList) {
        List<TarjetaUsuarioDTO> listatarjetasUsuario = new ArrayList<>();
        for (TarjetaUsuarioEntity tarjeta : tajetaUsuarioList) {
            listatarjetasUsuario.add(new TarjetaUsuarioDTO(tarjeta));
        }
        return listatarjetasUsuario;
    }

    /*
    getters y setters
    */

    public Long getCodTarjeta() {
        return codTarjeta;
    }

    public void setCodTarjeta(Long codTarjeta) {
        this.codTarjeta = codTarjeta;
    }

    public String getNomBanco() {
        return nomBanco;
    }

    public void setNomBanco(String nomBanco) {
        this.nomBanco = nomBanco;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getNumFranquicia() {
        return numFranquicia;
    }

    public void setNumFranquicia(String numFranquicia) {
        this.numFranquicia = numFranquicia;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getFecVencimiento() {
        return fecVencimiento;
    }

    public void setFecVencimiento(String fecVencimiento) {
        this.fecVencimiento = fecVencimiento;
    }

    public String getCodClave() {
        return codClave;
    }

    public void setCodClave(String codClave) {
        this.codClave = codClave;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public TipoTarjetaDTO getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(TipoTarjetaDTO tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    } 
}