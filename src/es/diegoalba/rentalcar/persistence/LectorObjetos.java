
package es.diegoalba.rentalcar.persistence;

import es.diegoalba.rentalcar.model.Cliente;
import es.diegoalba.rentalcar.model.Vehiculo;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;


/**
 * Clase que permite crear objetos LectorObjetos.
 * @author Diego Alba Ruiz
 */
public class LectorObjetos<O> {

    //Atributos
    private String filename;
    private Vehiculo ve = null;
    
    //Metodos
    /**
     * Constructor de LectorObjetos.
     * @param filename Fichero que usara la clase.
     */
    public LectorObjetos(String filename){
        this.filename = filename;
    }

    /**
     * Metodo que lee los objetos de un fichero.
     * @return Lista(LinkedList) con los objetos que estaban escritos.
     */
    public final LinkedList<O> read() {
        final LinkedList<O> coleccionObjs = new LinkedList<>();
        int contadorObj = 0;
        
        try (final ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.filename))) {
            while (true) {
                O objetoLeido = (O)ois.readObject();
                System.out.printf("Lee: %s %n", objetoLeido);
                coleccionObjs.add(objetoLeido);
                ++contadorObj;
            }
        }
        catch (FileNotFoundException e3) {
            System.out.println("NO se pudo abrir el fichero");
        }
        catch (ClassNotFoundException e) {
            System.out.println("ERROR en readObject: " + e);
        }
        catch (EOFException e4) {
//            System.out.printf("ERROR EOF Leidos %d objetos %n", contadorObj);
              System.out.println("-----------------");
        }
        catch (IOException e2) {
            System.out.println("ERROR E/S:" + e2);
        } finally{
            return coleccionObjs;
        }
    }
    
    /**
     * Metodo que lee los objetos de un fichero dado por parametro.
     * @param nombreFichero El fichero que se lee.
     * @return la lista con los objetos leidos.
     */
    public static LinkedList<Vehiculo> read(String nombreFichero) {
        LinkedList<Vehiculo> coleccionObjs = new LinkedList<>();
        int contadorObj = 0;
        
        try (final ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreFichero))) {
            while (true) {
                Vehiculo objetoLeido = (Vehiculo)ois.readObject();
                System.out.printf("Lee: %s %n", objetoLeido);
                coleccionObjs.add(objetoLeido);
                ++contadorObj;
            }
        }
        catch (FileNotFoundException e3) {
            System.out.println("NO se pudo abrir el fichero");
        }
        catch (ClassNotFoundException e) {
            System.out.println("ERROR en readObject: " + e);
        }
        catch (EOFException e4) {
//            System.out.printf("ERROR EOF Leidos %d objetos %n", contadorObj);
              System.out.println("-----------------");
        }
        catch (IOException e2) {
            System.out.println("ERROR E/S:" + e2);
        } finally{
            return coleccionObjs;
        }
    }
    
    

    /**
     * Metodo que obtiene un cliente en concreto pasandole su dni por parametro.
     * @param dni El dni del cliente que se quiere obtener.
     * @return El cliente buscado.
     */
    public Cliente getObjectCliente(String dni) {
        Cliente objetoLeido = null;
        
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));

            boolean encontrado = false;
            while (!encontrado) {
                objetoLeido = (Cliente) ois.readObject();
                if (objetoLeido.getDni().equalsIgnoreCase(dni)) {
                    encontrado = true;
                    System.out.printf("Encontrado %s %n", new Object[]{objetoLeido});
                }
            }

            return objetoLeido;
    } catch (FileNotFoundException e) {
        System.out.println("NO se pudo abrir el fichero. Detalles:" + e);
        return objetoLeido;
    } catch (ClassNotFoundException e) {
        System.out.println("ERROR en readObject: " + e);
        return objetoLeido;
    } catch (EOFException e) {
        System.out.printf("EOF. No encontrado %s", new Object[]{dni});
        System.out.println("ERROR" + e);
        return objetoLeido;
    } catch (IOException e) {
        System.out.println("ERROR E/S:" + e);
        return objetoLeido;
    } 
}

}
