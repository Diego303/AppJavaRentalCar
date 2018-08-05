
package es.diegoalba.JUnitTest;

import es.diegoalba.rentalcar.model.Cliente;
import es.diegoalba.rentalcar.model.GestorVehiculos;
import es.diegoalba.rentalcar.model.Vehiculo;
import es.diegoalba.rentalcar.persistence.EscritorObjetos;
import es.diegoalba.rentalcar.persistence.LectorObjetos;
import org.junit.runner.JUnitCore;
import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;

/**
 * Clase que permite realizar las pruebas de JUnit
 * @author Diego Alba Ruiz
 */
public class TestJUnit {
    GestorVehiculos gestor1 = new GestorVehiculos("clientes.dam","vehiculos.dam");
    GestorVehiculos gestor2 = new GestorVehiculos("clientes.dam","vehiculos.dam");
    
    EscritorObjetos escritorV = new EscritorObjetos("vehiculos.dam");
    EscritorObjetos escritorC = new EscritorObjetos("clientes.dam");
    LectorObjetos lectorV = new LectorObjetos("vehiculos.dam");
    LectorObjetos lectorC = new LectorObjetos("clientes.dam");
    
    Vehiculo v1 = new Vehiculo("11","22","33");
    Vehiculo v2 = new Vehiculo("1ssssssssssssss1","22","33");
    
    Cliente c1 = new Cliente("aa","bb","cc");
    
    @Test
    public void testConstructorGestor(){
        Assert.assertNotEquals(gestor1,gestor2);
        Assert.assertNotNull(gestor1);
        Assert.assertNotNull(gestor1);
        
        //TRAZA
        System.out.println("Se ha realizado el testConstructorGestor");
    }
    
    @Test
    public void testCargarVehiculos(){
        escritorV.write(v1);
        escritorV.añadir(v2);
        
        gestor1.cargarVehiculos();
        Assert.assertEquals(2,gestor1.getNumVehiculos());
        
        
        //TRAZA
        System.out.println("Se ha realizado el testCargarVehiculos");
    }
    
    @Test
    public void testGuardarVehiculos(){
        //TRAZA
        System.out.println("Se ha realizado el testGuardarVehiculos");
    }
    
    @Test
    public void testObtenerCliente(){
        escritorC.write(c1);
        Assert.assertEquals(c1,gestor2.obtenerCliente("11"));
        Assert.assertNotNull(gestor2.obtenerCliente("11"));
        
        //TRAZA
        System.out.println("Se ha realizado el testObtenerCliente");
    }
    
    @Test
    public void testObtenerVehiculo(){
        gestor1.cargarVehiculos();
        
        Assert.assertEquals(v1,gestor1.obtenerVehiculo(v1));
        Assert.assertNotNull(gestor1.obtenerVehiculo(1));
        
        //TRAZA
        System.out.println("Se ha realizado el testObtenerVehiculo");
    }
    
    @Test
    public void testGetNumVehiculo(){
        gestor1.cargarVehiculos();
        Assert.assertEquals(2,gestor1.getNumVehiculos());
        Assert.assertNotNull(gestor2.getNumVehiculos());
        
        //TRAZA
        System.out.println("Se ha realizado el testGetNumVehiculo");
    }
    
    @Test
    public void testEliminarVehiculo(){
        gestor1.cargarVehiculos();
        gestor1.eliminarVehiculo(1);
        Assert.assertEquals(1,gestor1.getNumVehiculos());
        //TRAZA
        System.out.println("Se ha realizado el testEliminarVehiculo");
    }
    
    @Test
    public void testAgregarVehiculo(){
        gestor1.cargarVehiculos();
        gestor1.agregarVehiculo(v2);
        Assert.assertEquals(3,gestor1.getNumVehiculos());
        //TRAZA
        System.out.println("Se ha realizado el testAgregarVehiculo");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JUnitCore.runClasses(TestJUnit.class);
    }
    
}
