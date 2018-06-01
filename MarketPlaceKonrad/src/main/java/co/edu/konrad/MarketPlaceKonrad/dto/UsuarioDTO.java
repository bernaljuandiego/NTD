/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.dto;

import co.edu.konrad.MarketPlaceKonrad.entities.RolEntity;
import co.edu.konrad.MarketPlaceKonrad.entities.TipoDocumentoEntity;
import co.edu.konrad.MarketPlaceKonrad.entities.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo Ruiz
 */
public class UsuarioDTO {
        
    private Long idUsuario;
    
    
    private String nombreUsuario;
    
    private String apellidoUsuario;
    
    private String fechaNacimiento;
    
    private int TelefonoUsuario;
    
    private String MailUsuario;
    
    private String contraseñaUsuario;
    
    private String avatar;
    
    private TipoDocumentoDTO tipoDocumento;
    
    private RolDTO rol;
    
    
    public UsuarioDTO(){    
    }
    /**
     * Mapeo de entidad a objeto con constructor de objeto UsuarioDTO y con parametro UsuarioEntity
     * @param user 
     */
    
    public UsuarioDTO(UsuarioEntity user){
        this.idUsuario = user.getIdUsuario();
        this.nombreUsuario = user.getNombreUsuario();
        this.apellidoUsuario = user.getApellidoUsuario();
        this.fechaNacimiento = user.getFechaNacimiento();
        this.TelefonoUsuario = user.getTelefonoUsuario();
        this.MailUsuario = user.getMailUsuario();
        this.contraseñaUsuario = user.getContraseñaUsuario();
        this.avatar = user.getAvatar();
        if(user.getTipoDocumento() != null){
            TipoDocumentoEntity tipo = new TipoDocumentoEntity();
            tipo.setIdtipo(user.getTipoDocumento().getIdtipo());
            tipo.setNomTipoId(user.getTipoDocumento().getNomTipoId());
            
            this.tipoDocumento = new TipoDocumentoDTO(tipo);
        }
        if(user.getRol()!= null){
            RolEntity rolUser =  new RolEntity();
            rolUser.setIdRol(user.getRol().getIdRol());
            rolUser.setNombreRol(user.getRol().getNombreRol());
            this.rol =  new RolDTO(rolUser);
        }
    }
    
    /**
     * Mapeo de objeto a entidad desde UsuarioDTO a una entidad de tipo UsuarioEntity
     * @return 
     */
    public UsuarioEntity toEntity(){
        UsuarioEntity user = new UsuarioEntity();
        user.setIdUsuario(this.idUsuario);
        user.setNombreUsuario(this.nombreUsuario);
        user.setApellidoUsuario(this.apellidoUsuario);
        user.setFechaNacimiento(this.fechaNacimiento);
        user.setTelefonoUsuario(this.TelefonoUsuario);
        user.setMailUsuario(this.MailUsuario);
        user.setContraseñaUsuario(this.contraseñaUsuario);
        user.setAvatar(this.avatar);
        
        if(this.tipoDocumento != null){
            TipoDocumentoEntity tipoDoc = new TipoDocumentoEntity();
            tipoDoc.setIdtipo(this.tipoDocumento.getIdtipo());
            tipoDoc.setNomTipoId(this.tipoDocumento.getNomTipoId());
            user.setTipoDocumento(tipoDoc);
        }
        if(this.rol != null){
            RolEntity rolUser =  new RolEntity();
            rolUser.setIdRol(this.rol.getIdRol());
            rolUser.setNombreRol(this.rol.getNombreRol());
            user.setRol(rolUser);
        }
        
        return user;
    }
    
    /**
     * Mapeo masivo de usuarioEntity  a usuarioDTO
     * @param usuarioList
     * @return 
     */
    
    public static List<UsuarioDTO> toUsuarioList(List<UsuarioEntity> usuarioList){
        List<UsuarioDTO> listaUsuarioDTO = new ArrayList<>();
        for (int i = 0; i < usuarioList.size(); i++) {            
            listaUsuarioDTO.add(new UsuarioDTO(usuarioList.get(i)));
        }
        return listaUsuarioDTO;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getTelefonoUsuario() {
        return TelefonoUsuario;
    }

    public void setTelefonoUsuario(int TelefonoUsuario) {
        this.TelefonoUsuario = TelefonoUsuario;
    }

    public String getMailUsuario() {
        return MailUsuario;
    }

    public void setMailUsuario(String MailUsuario) {
        this.MailUsuario = MailUsuario;
    }

    public String getContraseñaUsuario() {
        return contraseñaUsuario;
    }

    public void setContraseñaUsuario(String contraseñaUsuario) {
        this.contraseñaUsuario = contraseñaUsuario;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public TipoDocumentoDTO getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoDTO tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public RolDTO getRol() {
        return rol;
    }

    public void setRol(RolDTO rol) {
        this.rol = rol;
    }
    
    
     
}
