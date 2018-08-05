
package es.diegoalba.rentalcar.persistence;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Clase que permite crear objetos EscritorObjetos.
 * @author Diego Alba Ruiz
 * @param <O>
 */
public class EscritorObjetos<O> {

    //Atributos
    private String filename;

    //Metodos
    /**
     * Constructor de EscritorObjetos.
     * @param filename Fichero que usara la clase.
     */
    public EscritorObjetos(String filename){
        this.filename = filename;
    }
    
    /**
     * Metodo que escribe el objeto pasado por parametro.(Borrando primero lo que hay en el fichero) 
     * @param obj El objeto que se escribe.
     * @return El numero de objetos que se han escrito.
     */
    public int write (O obj){
        LinkedList<O> lista = new LinkedList();
        lista.add(obj);

        return write(lista);
    }
    
    /**
     * Metodo que escribe una lista pasada por parametro.(Borrando primero lo que hay en el fichero) 
     * @param lista La lista de objetos pasados por parametros.
     * @return El numero de objetos que se han escrito.
     */
    public int write(LinkedList<O> lista) {
        int contadorObj = 0;
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));

            for (O obj : lista) {
                oos.writeObject(obj);
                contadorObj++;

                System.out.printf("Escribir: %s %n", new Object[]{obj});
            }

            return contadorObj;
        } catch (IOException e) {
            System.out.printf("Escribir: ERROR de E/S. Informacion: %s %n", new Object[]{e});
            contadorObj = -1;
            return contadorObj;
        } 
    }
    
    /**
     * Metodo que escribe(agrega) un objeto.(Sin borrar lo anterior, lo añade a continuacion)
     * CUIDADO ---> Usar el MyObjectOutputStream para lo de la cabecera
     * @param objeto  El objeto que se va a añadir.
     * @return El numero de objetos que se han añadido.
     */
    public int añadir(O objeto) {
        ArrayList<O> lista = new ArrayList();
        lista.add(objeto);
        return añadir(lista);
    }
    
    /**
     * Metodo que escribe(agrega) una lista de objetos.(Sin borrar lo anterior, lo añade a continuacion)
     * CUIDADO ---> Usar el MyObjectOutputStream para lo de la cabecera
     * @param lista La lista de objetos que se quiere añadir.
     * @return El numero de objetos que se han añadido.
     */
    public int añadir(ArrayList<O> lista) {
        int contadorObj = 0;
        try (MyObjectOutputStream myoos = new MyObjectOutputStream(new FileOutputStream(filename,true))){

            for (O objeto : lista) {
                myoos.writeObject(objeto);
                contadorObj++;

                System.out.printf("Agregar: %s %n", new Object[]{objeto});
            }

            return contadorObj;
        } catch (IOException e) {
            System.out.printf("Agregar: ERROR de E/S. Informacion: %s %n", new Object[]{e});
            contadorObj = -1;
            return contadorObj;
        }
    }
}


