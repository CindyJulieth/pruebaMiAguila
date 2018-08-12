/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Usuario;
import Facade.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author USUARIO
 */
@Named(value = "controladorUsuario")
@SessionScoped
public class ControladorUsuario implements Serializable {

    
    @EJB
    UsuarioFacade usuarioFacade;
    private Usuario usuario = new Usuario();
    
    public ControladorUsuario() {
    
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    public String registrarUsuario(){
    usuarioFacade.create(usuario);
    usuario = new Usuario();
    return "index.xhtml";
    }
   
        
  }
    

