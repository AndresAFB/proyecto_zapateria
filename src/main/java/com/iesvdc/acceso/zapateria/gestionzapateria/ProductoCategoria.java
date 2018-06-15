/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.zapateria.gestionzapateria;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AndresAFB
 */
@Entity
@Table(name = "producto_categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoCategoria.findAll", query = "SELECT p FROM ProductoCategoria p")
    , @NamedQuery(name = "ProductoCategoria.findByIdCategoria", query = "SELECT p FROM ProductoCategoria p WHERE p.idCategoria = :idCategoria")
    , @NamedQuery(name = "ProductoCategoria.findByNombre", query = "SELECT p FROM ProductoCategoria p WHERE p.nombre = :nombre")})
public class ProductoCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria", nullable = false)
    private Integer idCategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(nullable = false, length = 35)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    @JsonBackReference
    private List<Producto> productoList;

    public ProductoCategoria() {
    }

    public ProductoCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public ProductoCategoria(Integer idCategoria, String nombre) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoCategoria)) {
            return false;
        }
        ProductoCategoria other = (ProductoCategoria) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iesvdc.acceso.zapateria.gestionzapateria.ProductoCategoria[ idCategoria=" + idCategoria + " ]";
    }
    
}
