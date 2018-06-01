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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Leonardo Ruiz 
 * tabla cliente
 */
@Entity(name = "Usuario")
public class UsuarioEntity implements Serializable {

    private final static long serialVersionUID = 1L;
     /**
      * Identificacion del Usuario - llave primaria 
      */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;
     /**
      * Nombre del usuario
      */
    @Column(name = "nom_usuario" , nullable =false)
    private String nombreUsuario;
    /**
     * Apellidos del usuario
     */
    @Column(name ="ape_usuario")
    private String apellidoUsuario;
    /**
     * Fecha de nacimiento del usuario
     */
    @Column(name = "fec_nacimiento")
    private String fechaNacimiento;
    /**
     * Numero de telefono del usuario
     */
    @Column(name = "Tel")
    private int TelefonoUsuario;
    /**
     * Direcion de correo electronico del usuario
     */
    @Column(name = "Correo")
    private String MailUsuario;
    //contraseña del cliente , debe ser unica 
    @Column(name = "contraseña",  nullable = false)
    private String contraseñaUsuario;
    /**
     * Nombre de avatar del usuario
     */
    @Column(nullable = false)
    private String avatar;
    /**
     * Relacion muchos a uno con la tabla de tipo de identificacion - tipo_id
     */
    @ManyToOne
    @JoinColumn(name = "cod_tipo_documento")
    private TipoDocumentoEntity tipoDocumento;
    /**
     * Relacion muchos a uno con la tabla de rol de usuario - Rol
     */
    
    @ManyToOne
    @JoinColumn(name ="cod_rol")
    private RolEntity rol;

 

    
    
    
    
    
    
    
   //Getters y Setters de la los atributos de la tabla Usuario
    
   
    

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
    
       public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
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
     public RolEntity getRol() {
        return rol;
    }

    public void setRol(RolEntity rol) {
        this.rol = rol;
    }

    public TipoDocumentoEntity getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoEntity tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
  


    
  

  

    
   

    

}
