
package es.diegoalba.rentalcar.model;

import es.diegoalba.rentalcar.persistence.EscritorObjetos;
import es.diegoalba.rentalcar.persistence.LectorObjetos;
import java.util.LinkedList;

/**
 * Clase que permite crear objetos GestorVehiculos.
 * @author Diego Alba Ruiz
 */
public class GestorVehiculos {
    
        //Atributos
        private String ficheroClientes;
        private String ficheroVehiculos;
        private int numeVehiculos;
        private LinkedList<Vehiculo> listaVehiculos;
  
        //Metodos
        /**
         * Constructor de GestorVehiculos
         */
        public GestorVehiculos(){
            this("","");
        }
        
        /**
         * Constructor de GestorVehiculos Con los parametros de los ficheros de
         * Clientes y de Vehiculos.
         * @param ficheroClientes
         * @param ficheroVehiculos 
         */
        public GestorVehiculos(String ficheroClientes, String ficheroVehiculos) {
            listaVehiculos = null;
            this.ficheroClientes = ficheroClientes;
            this.ficheroVehiculos = ficheroVehiculos;
            numeVehiculos = 0;
        }
        
        /**
         * Metodo que permite cargar los objetos Vehiculos
         * de un fichero "exterior".
         */
        public void cargarVehiculos() {
            LectorObjetos<Vehiculo> lectorObjVehiculos = new LectorObjetos(ficheroVehiculos);

            listaVehiculos = lectorObjVehiculos.read("vehiculos.dam");
            numeVehiculos = listaVehiculos.size();
        }
        
        
        /**
         * Metodo que permite escribir los objetos Vehiculos
         * en un fichero "exterior".
         */
        public void guardarVehiculos() {
            EscritorObjetos<Vehiculo> escritorObjVehiculos = new EscritorObjetos(ficheroVehiculos);

            escritorObjVehiculos.write(listaVehiculos);
        }
        
        /**
         * Metodo que permite escribir los objetos Vehiculos de un alista especifica.
         * en un fichero "exterior".
         * @param lista La lista leida por parametro.
         */
        public void guardarVehiculos(LinkedList lista) {
            EscritorObjetos<Vehiculo> escritorObjVehiculos = new EscritorObjetos(ficheroVehiculos);

            escritorObjVehiculos.write(lista);
        }
        
        /**
         * Metodo que permite obtener la lista de Objetos Vehiculos.
         * @return la lista de Objetos.
         */
        public LinkedList<Vehiculo> getListaVehiculos() {
            return listaVehiculos;
        }
        
        /**
         * Metodo que permite obtener un objeto cliente pasando su dni por parametro
         * y usando el metodo getObjectCliente de la clase Lector.
         * @param dni El dni del cliente que se quiere obtener.
         * @return El objeto Cliente que se buscaba.
         */
        public Cliente obtenerCliente(String dni) {
            LectorObjetos<Cliente> lectorObjClientes = new LectorObjetos(ficheroClientes);

            return lectorObjClientes.getObjectCliente(dni);
        }
        
        /**
         * Metodo que permite obtener un objeto Vehiculo 
         * @param ve Vehiculo pasado Por parametro que se quiere buscar.
         * @return  Vehiculo buscado.
         */
        public Vehiculo obtenerVehiculo(Vehiculo ve) {
            Vehiculo vehiculo = null;
            int posicion = listaVehiculos.indexOf(ve);
            if (posicion >= 0) {
              vehiculo = (Vehiculo)listaVehiculos.get(posicion);
            }
            return vehiculo;
        }
        
        /**
         * Metodo que obtiene el numero de vehiculos que hay.
         * @return el numero de vehiculos.
         */
        public int getNumVehiculos(){
            return numeVehiculos;
        }
        
        /**
         * Metodo que permite obtener un objeto Vehiculo pasando por parametro 
         * su indice.
         * @param index indice o lugar pasado por parametro
         * @return el vehiculo buscado.
         */
        public Vehiculo obtenerVehiculo(int index) {
             return (Vehiculo)listaVehiculos.get(index);
        }
        
        /**
         * Metodo que permite eliminar un vehiculo de la
         * lista de vehiculos pasando por parametro su indice.
         * @param index El indice del vehiculo que se quiere eliminar.
         */
        public void eliminarVehiculo(int index) {
            listaVehiculos.remove(index);
            numeVehiculos = numeVehiculos - 1;
        }
        
        /**
         * Metodo que permite agregar o añadir un vehiculo a la
         * lista de vehiculos pasando por parametro el Vehiculo.
         * @param nuevoVehiculo El vehiculo que se quiere añadir.
         */
        public void agregarVehiculo(Vehiculo nuevoVehiculo){
            listaVehiculos.add(nuevoVehiculo);
            numeVehiculos = numeVehiculos + 1;
        }
}
