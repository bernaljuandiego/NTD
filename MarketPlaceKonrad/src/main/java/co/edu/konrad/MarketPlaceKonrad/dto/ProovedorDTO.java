/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.dto;

import co.edu.konrad.MarketPlaceKonrad.entities.ProovedorEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo Ruiz
 */
public class ProovedorDTO {
    
    private Long nitProovedor;
    
    private String usuario;
    
    private String Contraseña;
    
    private String Avatar;
    
    private String mailProovedor;
    
    private String NombreEmpresa;
    
    private String Direccion;
    
    private String chatProovedor;
    
    
    public ProovedorDTO(){
        
    }
    /**
     * Mapeo de  entity a DTO
     * @param prove 
     */
    public ProovedorDTO(ProovedorEntity prove){
        this.nitProovedor = prove.getNitProovedor();
        this.usuario = prove.getUsuario();
        this.Contraseña =  prove.getContraseña();
        this.Avatar =  prove.getAvatar();
        this.mailProovedor =  prove.getMailProovedor();
        this.NombreEmpresa =  prove.getNombreEmpresa();
        this.Direccion =  prove.getDireccion();
        this.chatProovedor =  prove.getChatProovedor();
        
    }
    
    /**
     * Mapeo de DTO a Entity
     * @return 
     */
    public ProovedorEntity toEntity(){
        ProovedorEntity prove =  new ProovedorEntity();
        prove.setNitProovedor(this.nitProovedor);
        prove.setUsuario(this.usuario);
        prove.setContraseña(this.Contraseña);
        prove.setAvatar(this.Avatar);
        prove.setMailProovedor(this.mailProovedor);
        prove.setNombreEmpresa(this.NombreEmpresa);
        prove.setDireccion(this.Direccion);
        prove.setChatProovedor(this.chatProovedor);
        
        return prove;
    }
    /**
     * Mapeo masivo de ProovedorEntity a ProveedorDTO
     * @param proves
     * @return 
     */
    public static List<ProovedorDTO> toProovedorList (List<ProovedorEntity> proves){
        List<ProovedorDTO> proovedores = new ArrayList<>();
        for(int i = 0; i < proves.size(); i++){
            proovedores.add(new ProovedorDTO(proves.get(i)));
        }
        return proovedores;
    }

    public Long getNitProovedor() {
        return nitProovedor;
    }

    public void setNitProovedor(Long nitProovedor) {
        this.nitProovedor = nitProovedor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String Avatar) {
        this.Avatar = Avatar;
    }

    public String getMailProovedor() {
        return mailProovedor;
    }

    public void setMailProovedor(String mailProovedor) {
        this.mailProovedor = mailProovedor;
    }

    public String getNombreEmpresa() {
        return NombreEmpresa;
    }

    public void setNombreEmpresa(String NombreEmpresa) {
        this.NombreEmpresa = NombreEmpresa;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getChatProovedor() {
        return chatProovedor;
    }

    public void setChatProovedor(String chatProovedor) {
        this.chatProovedor = chatProovedor;
    }
    
    
}
