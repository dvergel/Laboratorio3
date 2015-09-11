/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.entities.Mueble;
import com.losalpes.excepciones.OperacionInvalidaException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Dev
 */
@Stateless
public class ServicioCatalogoMock implements IServicioCatalogoMockLocal,IServicioCatalogoMockRemote{
    
    @EJB
    private IServicioPersistenciaMockLocal persistence;

    @Override
    public void agregarMueble(Mueble mueble) {
        try {
            if(persistence.findById(Mueble.class, mueble.getReferencia())!=null){
                persistence.create(mueble);
            }else{
                persistence.update(mueble);
            }
            
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(ServicioCatalogoMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarMueble(long id) {
        Mueble mueble=new Mueble();
        mueble.setReferencia(id);
        try {
            persistence.delete(mueble);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(ServicioCatalogoMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Mueble> darMuebles() {
        return persistence.findAll(Mueble.class);
    }

    @Override
    public void removerEjemplarMueble(long id) {
        Mueble mueble = (Mueble)persistence.findById(Mueble.class, id);
        if(mueble!=null){
            mueble.setCantidad(mueble.getCantidad()-1);
            agregarMueble(mueble);
        }
    }
}
