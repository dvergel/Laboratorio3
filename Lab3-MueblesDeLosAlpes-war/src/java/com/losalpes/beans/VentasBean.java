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
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

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
    
    private LineChartModel chartModel;
    
    public List<RegistroVenta> getVentas(){
        if (ventas == null) {
            ventas = servicioRegistroVenta.getRegistroVentas();
            initChartModel();
        }
        return ventas;
    }

    public void setVentas(List<RegistroVenta> ventas) {
        this.ventas = ventas;
    }

    public LineChartModel getChartModel() {
        return chartModel;
    }

    public void setChartModel(LineChartModel chartModel) {
        this.chartModel = chartModel;
    }

    private void initChartModel() {
        chartModel = new LineChartModel();
        
        LineChartSeries serie = new LineChartSeries();
        chartModel.setTitle("Factura vs Cantidad");
        chartModel.setLegendPosition("e");
        
        serie.setLabel("Label");
        
        for (int i = 0 ; i < ventas.size() ; i++) {
            serie.set(i, ventas.get(i).getCantidad());
        }
        
        chartModel.addSeries(serie);
        
    }
    
    
    
}