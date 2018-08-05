/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.diegoalba.JUnitTest;

import es.diegoalba.rentalcar.model.Cliente;
import es.diegoalba.rentalcar.model.GestorVehiculos;
import es.diegoalba.rentalcar.model.Vehiculo;
import es.diegoalba.rentalcar.persistence.EscritorObjetos;
import es.diegoalba.rentalcar.persistence.LectorObjetos;

/**
 *
 * @author Diego Alba Ruiz
 */
public class MisPruebasApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Vehiculo v1 = new Vehiculo("58ABCJ","SEAT","IBIZA");
        Vehiculo v2 = new Vehiculo("534ADF","CHEVROLET","EPICA");
        Vehiculo v3 = new Vehiculo("5347DF","CHEVROLET","YELLOW");
        Vehiculo v4 = new Vehiculo("AB56BG","TOYOTA","HYLUX");
        
        
        EscritorObjetos fr = new EscritorObjetos("vehiculos.dam");
        GestorVehiculos g1 = new GestorVehiculos("vehiculos.dam","vehiculos.dam");
        
        fr.write(v1);
        fr.añadir(v2);
        
        
//        fl.read();
        g1.cargarVehiculos();
        
        g1.eliminarVehiculo(1);
        g1.agregarVehiculo(v3);
        g1.agregarVehiculo(v4);
        
        g1.guardarVehiculos();
        
        System.out.println("----------");
        System.out.println(g1.getNumVehiculos());
//        System.out.println(fl.getObject("1"));
        System.out.println("----------");
    }
    
}
