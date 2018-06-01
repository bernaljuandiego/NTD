/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.dto;

import co.edu.konrad.MarketPlaceKonrad.entities.CiudadEntity;
import co.edu.konrad.MarketPlaceKonrad.entities.ResidenciaEntity;
import co.edu.konrad.MarketPlaceKonrad.entities.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo Ruiz
 */
public class ResidenciaDTO {
    
    
    private Long codResidencia;
    
    private String nombreResidencia;
    
    private String DireccionResidencia;
    
    private UsuarioDTO usuario;
    
    private CiudadDTO ciudad;
    
    
    public ResidenciaDTO(){
        
    }
    /**
     * Conversion desde entity a DTO
     * @param resi 
     */
    public ResidenciaDTO(ResidenciaEntity resi){
        this.codResidencia =  resi.getCodResidencia();
        this.nombreResidencia =  resi.getNombreResidencia();
        this.DireccionResidencia =  resi.getDireccionResidencia();
        if(resi.getUsuario() != null){
            UsuarioEntity user = new UsuarioEntity();
            user.setIdUsuario(resi.getUsuario().getIdUsuario());
            user.setNombreUsuario(resi.getUsuario().getNombreUsuario());
            user.setApellidoUsuario(resi.getUsuario().getApellidoUsuario());
            user.setFechaNacimiento(resi.getUsuario().getFechaNacimiento());
            user.setTelefonoUsuario(resi.getUsuario().getTelefonoUsuario());
            user.setMailUsuario(resi.getUsuario().getMailUsuario());
            user.setContraseñaUsuario(resi.getUsuario().getContraseñaUsuario());
            user.setAvatar(resi.getUsuario().getAvatar());
            user.setRol(resi.getUsuario().getRol());
            user.setTipoDocumento(resi.getUsuario().getTipoDocumento());
            
            
            this.usuario =  new UsuarioDTO(user);
        }
        
        if(resi.getCiudad() !=  null){
            CiudadEntity ciudad = new CiudadEntity();
            ciudad.setCodCiudad(resi.getCiudad().getCodCiudad());
            ciudad.setNomCiudad(resi.getCiudad().getNomCiudad());
            ciudad.setPais(resi.getCiudad().getPais());
            this.ciudad =  new CiudadDTO(ciudad);
            
        }
        
    }
    /**
     * Conversion desde DTO a entity
     * @return 
     */
    
    public ResidenciaEntity toEntity(){
        ResidenciaEntity residence =  new ResidenciaEntity();
        residence.setCodResidencia(this.codResidencia);
        residence.setNombreResidencia(this.nombreResidencia);
        residence.setDireccionResidencia(this.DireccionResidencia);
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
            residence.setUsuario(user);
        }
        if(this.ciudad !=  null){
            CiudadEntity city =  new CiudadEntity();
            city.setCodCiudad(this.ciudad.getCodCiudad());
            city.setNomCiudad(this.ciudad.getNomCiudad());
            city.setPais(this.ciudad.getPais().toEntity());
            residence.setCiudad(city);
        }
        
        return residence;
        
    }
    
    /**
     * Mapeo masivo de ResidenciaEntity  a ResidenciaDTO
     * @param residences
     * @return residencias
     */
    
    public static List<ResidenciaDTO> toResidenciaList (List<ResidenciaEntity> residences){
        List<ResidenciaDTO> residencias = new ArrayList<>();
        for(int i = 0; i < residences.size(); i++){
            residencias.add(new ResidenciaDTO(residences.get(i)));
        }
        
        return residencias;
    }

    public Long getCodResidencia() {
        return codResidencia;
    }

    public void setCodResidencia(Long codResidencia) {
        this.codResidencia = codResidencia;
    }

    public String getNombreResidencia() {
        return nombreResidencia;
    }

    public void setNombreResidencia(String nombreResidencia) {
        this.nombreResidencia = nombreResidencia;
    }

    public String getDireccionResidencia() {
        return DireccionResidencia;
    }

    public void setDireccionResidencia(String DireccionResidencia) {
        this.DireccionResidencia = DireccionResidencia;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public CiudadDTO getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadDTO ciudad) {
        this.ciudad = ciudad;
    }
    
    
}
