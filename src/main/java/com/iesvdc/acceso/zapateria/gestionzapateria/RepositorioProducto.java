/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.zapateria.gestionzapateria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AndresAFB
 */

@Repository
public interface RepositorioProducto extends JpaRepository<Producto, Long> {
    
}

