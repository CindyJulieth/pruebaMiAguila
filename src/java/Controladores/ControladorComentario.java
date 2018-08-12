/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Comentario;
import Facade.ComentarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author USUARIO
 */
@Named(value = "controladorComentario")
@SessionScoped
public class ControladorComentario implements Serializable {

    @EJB
    ComentarioFacade comentarioFacade;
    private Comentario comentario = new Comentario();
    
    public ControladorComentario() {
    }
    
     public String crearComentario(){
    comentarioFacade.create(comentario); 
    comentario= new Comentario();
    return "blog.xtml";
    
    }
    
    
    public String editarComentario(){
    comentarioFacade.edit(comentario);
    comentario= new Comentario();
    return "blog.xtml";
    
    }
    
    public String eliminarComentario(Comentario Com){
    comentarioFacade.remove(Com);
    return "blog.xtml";
    }
    
    
    public List<Comentario> listarComentario(){
        return comentarioFacade.findAll();
    
    }
    
}
