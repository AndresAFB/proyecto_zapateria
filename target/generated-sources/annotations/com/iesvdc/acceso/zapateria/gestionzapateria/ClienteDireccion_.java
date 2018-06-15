package com.iesvdc.acceso.zapateria.gestionzapateria;

import com.iesvdc.acceso.zapateria.gestionzapateria.Cliente;
import com.iesvdc.acceso.zapateria.gestionzapateria.CodPos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-14T14:16:05")
@StaticMetamodel(ClienteDireccion.class)
public class ClienteDireccion_ { 

    public static volatile SingularAttribute<ClienteDireccion, Long> idDireccion;
    public static volatile SingularAttribute<ClienteDireccion, String> nombreVia;
    public static volatile SingularAttribute<ClienteDireccion, CodPos> cpDireccionCliente;
    public static volatile SingularAttribute<ClienteDireccion, Cliente> idCliente;
    public static volatile SingularAttribute<ClienteDireccion, String> nombre;

}