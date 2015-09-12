/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.entities.RegistroVenta;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author Zamir
 */
@Stateful
public class ServicioRegistroVentaMock implements IServicioRegistroVentaMockLocal,
                        IServicioRegistroVentaMockRemote{
    
    /**
     * Interface con referencia al servicio de persistencia en el sistema
     */
    @EJB
    private IServicioPersistenciaMockLocal persistencia;

    @Override
    public List<RegistroVenta> getRegistroVentas() {
        return persistencia.findAll(RegistroVenta.class);
    }

}
