/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;

/**
 * Clase que modela la entidad Categoria
 *
 * @author Manuel S. Nino
 */
@Entity(name = "Categoria")
public class CategoriaEntity implements Serializable {

    /**
     * Controlador de versiones del Programa
     */
    private final static Long serialVersionUID = 1L;

    /**
     * Uso de @Column para asignar el nombre de la columna que depende del
     * codCategoria Uso de @Id Señala a codCategoria como una llave princial Uso
     * de @GeneratedValue genera una estrategia de incrementacion a la llave
     * princial en este caso GenerationType.AUTO Codigo categoria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cod_categoria")
    private Long codCategoria;

    /**
     * Nombre de la nueva columna Nombre de la variable y tipo de objeto que
     * guardara el dato segun el nombre de la columna y el del mismo.
     */
    @Column(name = "nom_categoria")
    private String NomCategoria;

    @Column(name = "descripcion")
    private String descripcionCategoria;

    
    /** Get y set para poder hacer cambios en los datos declarados
     * 
     * @return 
     */ 
    public Long getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(Long codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getNomCategoria() {
        return NomCategoria;
    }

    public void setNomCategoria(String NomCategoria) {
        this.NomCategoria = NomCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }
}
