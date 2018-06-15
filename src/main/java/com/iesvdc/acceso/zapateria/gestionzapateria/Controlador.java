/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.zapateria.gestionzapateria;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author AndresAFB
 */

@CrossOrigin
@RestController
@RequestMapping("/rest")
public class Controlador {
    
    // RepositorioClientes repositorioCliente;
    
    @Autowired
    RepositorioClientes repoClient;
    
    @Autowired
    RepositorioCodPos repoCodPos;
    
    @Autowired
    RepositorioDireccion repoDirec;
    
    @Autowired
    RepositorioProducto repoProd;

   // Get All Clientes
    @GetMapping("/cliente")
    public List<Cliente> getAllAlumnos() {
        return repoClient.findAll();
    }
    
    
    // Get All Clientes
    @GetMapping("/codpos")
    public List<CodPos> getAllCodPos() {
        return repoCodPos.findAll();
    }
    
    
    // Get All Clientes
    @GetMapping("/direcciones")
    public List<ClienteDireccion> getAllDirecciones() {
        return repoDirec.findAll();
    }
    
    @GetMapping("/producto")
    public List<Producto> getAllProductos() {
        return repoProd.findAll();
    }        
    // Get All Notes
    @GetMapping("/cliente/{id}")
    public Cliente getCliente(@PathVariable(value = "id") Long id) {
        return repoClient.findById(id).get();
    }
  

    
}
