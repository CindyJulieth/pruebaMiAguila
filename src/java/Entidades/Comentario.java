/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "comentario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c")
    , @NamedQuery(name = "Comentario.findByIdComentario", query = "SELECT c FROM Comentario c WHERE c.idComentario = :idComentario")
    , @NamedQuery(name = "Comentario.findByNombreAutorComen", query = "SELECT c FROM Comentario c WHERE c.nombreAutorComen = :nombreAutorComen")
    , @NamedQuery(name = "Comentario.findByFotoAutorComen", query = "SELECT c FROM Comentario c WHERE c.fotoAutorComen = :fotoAutorComen")
    , @NamedQuery(name = "Comentario.findByFechaPublicacionComen", query = "SELECT c FROM Comentario c WHERE c.fechaPublicacionComen = :fechaPublicacionComen")
    , @NamedQuery(name = "Comentario.findByCantidadMeGusta", query = "SELECT c FROM Comentario c WHERE c.cantidadMeGusta = :cantidadMeGusta")
    , @NamedQuery(name = "Comentario.findByCantidadNoMeGusta", query = "SELECT c FROM Comentario c WHERE c.cantidadNoMeGusta = :cantidadNoMeGusta")})
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idComentario")
    private Integer idComentario;
    @Size(max = 45)
    @Column(name = "nombreAutorComen")
    private String nombreAutorComen;
    @Size(max = 100)
    @Column(name = "fotoAutorComen")
    private String fotoAutorComen;
    @Column(name = "fechaPublicacionComen")
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacionComen;
    @Column(name = "cantidadMeGusta")
    private Integer cantidadMeGusta;
    @Column(name = "cantidadNoMeGusta")
    private Integer cantidadNoMeGusta;
    @JoinColumn(name = "idArticulo", referencedColumnName = "idArticulo")
    @ManyToOne
    private Articulo idArticulo;

    public Comentario() {
    }

    public Comentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public String getNombreAutorComen() {
        return nombreAutorComen;
    }

    public void setNombreAutorComen(String nombreAutorComen) {
        this.nombreAutorComen = nombreAutorComen;
    }

    public String getFotoAutorComen() {
        return fotoAutorComen;
    }

    public void setFotoAutorComen(String fotoAutorComen) {
        this.fotoAutorComen = fotoAutorComen;
    }

    public Date getFechaPublicacionComen() {
        return fechaPublicacionComen;
    }

    public void setFechaPublicacionComen(Date fechaPublicacionComen) {
        this.fechaPublicacionComen = fechaPublicacionComen;
    }

    public Integer getCantidadMeGusta() {
        return cantidadMeGusta;
    }

    public void setCantidadMeGusta(Integer cantidadMeGusta) {
        this.cantidadMeGusta = cantidadMeGusta;
    }

    public Integer getCantidadNoMeGusta() {
        return cantidadNoMeGusta;
    }

    public void setCantidadNoMeGusta(Integer cantidadNoMeGusta) {
        this.cantidadNoMeGusta = cantidadNoMeGusta;
    }

    public Articulo getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Articulo idArticulo) {
        this.idArticulo = idArticulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComentario != null ? idComentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.idComentario == null && other.idComentario != null) || (this.idComentario != null && !this.idComentario.equals(other.idComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Comentario[ idComentario=" + idComentario + " ]";
    }
    
}
