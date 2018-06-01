/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.dto;

import co.edu.konrad.MarketPlaceKonrad.entities.RolEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo Ruiz
 */
public class RolDTO {

    private Long idRol;

    private String nombreRol;

    public RolDTO() {
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    /**
     * Converson de entity a objeto como parametro pasando una entity
     *
     * @param rol
     */
    public RolDTO(RolEntity rol) {
        this.idRol = rol.getIdRol();
        this.nombreRol = rol.getNombreRol();
    }

    /**
     * Converson de objeto a entidad
     *
     * @return
     */
    public RolEntity toEntity() {
        RolEntity Rol = new RolEntity();
        Rol.setIdRol(this.idRol);
        Rol.setNombreRol(this.nombreRol);

        return Rol;
    }

    /**
     * Conversion masiva entre RolEntity a RolDTO
     * @param Roles
     * @return 
     */
    public static List<RolDTO> toRolList(List<RolEntity> Roles) {
        List<RolDTO> listaRolDTO = new ArrayList<>();
        for (int i = 0; i < Roles.size(); i++) {
            listaRolDTO.add(new RolDTO(Roles.get(i)));
        }
        return listaRolDTO;
    }
}
