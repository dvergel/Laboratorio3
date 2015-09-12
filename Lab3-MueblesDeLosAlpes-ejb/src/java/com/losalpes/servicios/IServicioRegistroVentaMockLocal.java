/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.entities.RegistroVenta;
import java.util.List;

/**
 * Contrato funcional de los servicios para el registro de ventas
 * @author Zamir
 */
public interface IServicioRegistroVentaMockLocal {

    /**
     * Retorna el registro total de ventas
     * @return registro total de ventas
     */
    List<RegistroVenta> getRegistroVentas();
    
}
