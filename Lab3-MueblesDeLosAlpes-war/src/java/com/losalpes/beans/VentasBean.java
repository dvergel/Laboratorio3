/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.entities.RegistroVenta;
import com.losalpes.servicios.IServicioRegistroVentaMockLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 * Bean para la gestión de la vista del registro de ventas
 * @author Zamir
 */
public class VentasBean implements Serializable {
    
    /**
     * Intefaz con la capa de negocio
     */
    @EJB
    private IServicioRegistroVentaMockLocal servicioRegistroVenta;
    
    private List<RegistroVenta> ventas;
    
    public List<RegistroVenta> getVentas(){
        if (ventas == null) {
            ventas = servicioRegistroVenta.getRegistroVentas();
        }
        return ventas;
    }

    public void setVentas(List<RegistroVenta> ventas) {
        this.ventas = ventas;
    }
    
}