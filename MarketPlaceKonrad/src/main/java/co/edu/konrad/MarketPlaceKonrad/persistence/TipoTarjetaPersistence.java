package co.edu.konrad.MarketPlaceKonrad.persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import co.edu.konrad.MarketPlaceKonrad.entities.TipoTarjetaEntity;

/**
 * Manejador de la entidad Tipo Tarjeta
 * @author Leonardo Ruiz
 */
@Stateless
public class TipoTarjetaPersistence {
    
    @PersistenceContext(unitName = "MarketPlacePU")
    protected EntityManager em;
    
    /**
     * Obtener la lista con los datos de la tabla Tipo Tarjeta
     * @return Lista de datos de la tabla Tipo Tarjeta
     */
    public List<TipoTarjetaEntity> findAll(){
        Query todos = em.createQuery("select e from Tipo_tarjeta e");
        return todos.getResultList();
    }
    
    /**
     * Encontrar una tupla especifica de la tabla Tipo Tarjeta
     * @param id que se desea buscar
     * @return Tipo TarjetaEntity
     */
    public TipoTarjetaEntity find(Long id){
        TipoTarjetaEntity tipoTarjeta = em.find(TipoTarjetaEntity.class, id);
        return tipoTarjeta;
    }
    
    /**
     * Creacion de un nuevo Tipo Tarjeta
     * @param tipoTarjeta
     * @return nuevo Tipo Tarjeta creado
     */
    public TipoTarjetaEntity create(TipoTarjetaEntity tipoTarjeta){
        em.persist(tipoTarjeta);
        return tipoTarjeta;
    }
    
    /**
     * Actualizacion de una tupla de la tabla Tipo Tarjeta
     * @param tipoTarjeta
     * @return Tipo Tarjeta actualizado
     */
    public TipoTarjetaEntity update (TipoTarjetaEntity tipoTarjeta){
        return em.merge(tipoTarjeta);
    }
    
    /**
     * Elimina una tupla Tipo Tarjeta de la tabla
     * @param id 
     */
    public void delete (Long id){
        TipoTarjetaEntity tipoTarjetaDelete = em.find(TipoTarjetaEntity.class, id);
        em.remove(tipoTarjetaDelete);
    }
}

