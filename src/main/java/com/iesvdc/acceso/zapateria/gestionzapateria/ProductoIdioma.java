/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.zapateria.gestionzapateria;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AndresAFB
 */
@Entity
@Table(name = "producto_idioma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoIdioma.findAll", query = "SELECT p FROM ProductoIdioma p")
    , @NamedQuery(name = "ProductoIdioma.findByCodIdioma", query = "SELECT p FROM ProductoIdioma p WHERE p.codIdioma = :codIdioma")
    , @NamedQuery(name = "ProductoIdioma.findByIdCodIdioma", query = "SELECT p FROM ProductoIdioma p WHERE p.idCodIdioma = :idCodIdioma")
    , @NamedQuery(name = "ProductoIdioma.findByNombre", query = "SELECT p FROM ProductoIdioma p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "ProductoIdioma.findByDescripcion", query = "SELECT p FROM ProductoIdioma p WHERE p.descripcion = :descripcion")})
public class ProductoIdioma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cod_idioma", nullable = false, length = 3)
    private String codIdioma;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cod_idioma", nullable = false)
    private Integer idCodIdioma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(nullable = false, length = 35)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String descripcion;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", nullable = false)
    @ManyToOne(optional = false)
    @JsonManagedReference
    private Producto idProducto;

    public ProductoIdioma() {
    }

    public ProductoIdioma(Integer idCodIdioma) {
        this.idCodIdioma = idCodIdioma;
    }

    public ProductoIdioma(Integer idCodIdioma, String codIdioma, String nombre, String descripcion) {
        this.idCodIdioma = idCodIdioma;
        this.codIdioma = codIdioma;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getCodIdioma() {
        return codIdioma;
    }

    public void setCodIdioma(String codIdioma) {
        this.codIdioma = codIdioma;
    }

    public Integer getIdCodIdioma() {
        return idCodIdioma;
    }

    public void setIdCodIdioma(Integer idCodIdioma) {
        this.idCodIdioma = idCodIdioma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCodIdioma != null ? idCodIdioma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoIdioma)) {
            return false;
        }
        ProductoIdioma other = (ProductoIdioma) object;
        if ((this.idCodIdioma == null && other.idCodIdioma != null) || (this.idCodIdioma != null && !this.idCodIdioma.equals(other.idCodIdioma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iesvdc.acceso.zapateria.gestionzapateria.ProductoIdioma[ idCodIdioma=" + idCodIdioma + " ]";
    }
    
}
