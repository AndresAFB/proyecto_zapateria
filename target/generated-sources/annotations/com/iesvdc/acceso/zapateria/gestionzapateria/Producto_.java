package com.iesvdc.acceso.zapateria.gestionzapateria;

import com.iesvdc.acceso.zapateria.gestionzapateria.ProductoCategoria;
import com.iesvdc.acceso.zapateria.gestionzapateria.ProductoIdioma;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-14T14:16:05")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile ListAttribute<Producto, ProductoIdioma> productoIdiomaList;
    public static volatile SingularAttribute<Producto, ProductoCategoria> categoria;
    public static volatile SingularAttribute<Producto, Integer> idProducto;
    public static volatile SingularAttribute<Producto, String> rutaImagen;

}