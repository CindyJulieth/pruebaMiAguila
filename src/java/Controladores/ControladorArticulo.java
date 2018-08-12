/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Articulo;
import Facade.ArticuloFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author USUARIO
 */
@Named(value = "controladorArticulo")
@SessionScoped
public class ControladorArticulo implements Serializable {

    
    @EJB
    ArticuloFacade articuloFacade;
    private Articulo articulo = new Articulo();

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    
    
    
    
    public ControladorArticulo() {
    }
    
    
    public String crearArticulo(){
    articuloFacade.create(articulo);
    articulo= new Articulo();
    return "blog.xtml";
    
    }
    
    
    public String editarArticulo(){
    articuloFacade.edit(articulo);
    articulo= new Articulo();
    return "blog.xtml";
    
    }
    
    public String eliminarArticulo(Articulo Art){
    articuloFacade.remove(Art);
    return "blog.xtml";
    }
    
    
    public List<Articulo> listarArticulos(){
        return articuloFacade.findAll();
    
    }

    
}