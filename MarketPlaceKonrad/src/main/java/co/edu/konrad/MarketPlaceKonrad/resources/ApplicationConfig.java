/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.MarketPlaceKonrad.resources;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Clase que registra el inventario de todos los recursos
 * @author Leonardo Ruiz
 */
@ApplicationPath("/api")
public class ApplicationConfig extends Application {
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(co.edu.konrad.MarketPlaceKonrad.resources.CarritoComprasResource.class);
        resources.add(co.edu.konrad.MarketPlaceKonrad.resources.CategoriaProductoResource.class);
        resources.add(co.edu.konrad.MarketPlaceKonrad.resources.CategoriaResource.class);
        resources.add(co.edu.konrad.MarketPlaceKonrad.resources.CiudadResource.class);
        resources.add(co.edu.konrad.MarketPlaceKonrad.resources.CompraResource.class);
        resources.add(co.edu.konrad.MarketPlaceKonrad.resources.MarcaResource.class);
        resources.add(co.edu.konrad.MarketPlaceKonrad.resources.PaisResource.class);
        resources.add(co.edu.konrad.MarketPlaceKonrad.resources.ProductoResource.class);
        resources.add(co.edu.konrad.MarketPlaceKonrad.resources.ProovedorResource.class);
        resources.add(co.edu.konrad.MarketPlaceKonrad.resources.ResidenciaResource.class);
        resources.add(co.edu.konrad.MarketPlaceKonrad.resources.RolResource.class);
        resources.add(co.edu.konrad.MarketPlaceKonrad.resources.TarjetaUsuarioResource.class);
        resources.add(co.edu.konrad.MarketPlaceKonrad.resources.TipoDocumentoResource.class);
        resources.add(co.edu.konrad.MarketPlaceKonrad.resources.TipoProductoResource.class);
        resources.add(co.edu.konrad.MarketPlaceKonrad.resources.TipoTarjetaResource.class);
        resources.add(co.edu.konrad.MarketPlaceKonrad.resources.UsuarioResource.class);
    }
    
}
