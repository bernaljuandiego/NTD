/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Leonardo Ruiz
 * Tabla Proovedor
 */
@Entity(name="Proovedor")
public class ProovedorEntity implements Serializable {
    
     private final static long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="nit_proovedor" , nullable = false )
    /**
     * nit del proovedor - llave primaria
     */
    private Long nitProovedor;
    /**
     * El nombre del empleado que registra la empresa
     */
    @Column
    private String usuario;
    
    
    /**
     * Contraseña del proovedor
     */
    @Column(nullable = false)
    private String Contraseña;
    /**
     * Avatar del proovedor
     */
    
    @Column(nullable = false , unique = true)
    private String Avatar;
    
    /**
     * Direccion de correo electronico del proovedor
     */
    @Column(name = "correo",nullable = false , unique = true)
    private String mailProovedor;
    /**
     * Nombre de la empresa - proovedor
     */
    @Column(name ="nom_empresa" , nullable = false , unique = true)
    private String NombreEmpresa;
    /**
     * Ubicacion o almacen del proovedor
     */
    @Column(nullable = false)
    private String Direccion;
    
    /**
     * Metodo de contacto del proovedor
     */
    @Column(name ="chat" , nullable = false)
    private String chatProovedor;

    
    //Getters y Setters de la tabla proovedor
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
