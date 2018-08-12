/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author USUARIO
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "MiAguilaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    
    public Usuario iniciarSesion(String nombre, String contraseña){
        Usuario usuario =  null;
        String consulta;
        try{
            consulta ="SELECT u FROM Usuario u WHERE u.nombre = :usuario AND u.contraseña = :contraseña";            
            Query q = em.createQuery(consulta);
            q.setParameter("usuario", nombre);
            q.setParameter("contraseña", contraseña);
            
            List<Usuario> lista = q.getResultList();
            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }
        } catch(Exception e){
            throw e;
        }
        return usuario;
    }
   
}
