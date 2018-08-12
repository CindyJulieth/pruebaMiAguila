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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author USUARIO
 */
@Named(value = "controladorSesion")
@SessionScoped
public class ControladorSesion implements Serializable {

    /**
     * Creates a new instance of ControladorSesion
     */
    public ControladorSesion() {
    }
    
    @EJB
    private UsuarioFacade usuarioFacade;
    private Usuario usuario;
    private String nombre;
    private String contraseña;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
   
    
    
    /*Inicio de Sesión*/
    public String iniciarSesion() {
        try {
            usuario = usuarioFacade.iniciarSesion(nombre, contraseña);
            System.out.println(usuario.getNombre());
            if (usuario != null) {
                //renderizarPermisos(usuarios.getFkRoles().getPermisosList());
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
                System.out.println(usuario);
                return "blog?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Usuario o contraseña errado, vuelva a intertarlo."));
                return "";
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Usuario o contraseña errado, vuelva a intertarlo."));
            return "";
        }
    }
    
    /*Validación de sesión*/

    public Usuario traerSesion() {
        return (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    }
    
    /*Cierre de sesión*/

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        usuario = null;
        this.contraseña = "";
        return "";
    }
    
    public void verificarSesion() {
        try {
            Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            
            if (us == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("../Error404.xhtml");
            }
        } catch (Exception e) {
            // log para guardar registro de un error
            
        }
    }
    
    
    
}

    
    

