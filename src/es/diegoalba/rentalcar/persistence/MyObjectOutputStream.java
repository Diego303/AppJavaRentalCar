
package es.diegoalba.rentalcar.persistence;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


/**
 * Clase que permite crear objetos MyObjectOutputStream para controlar 
 * la clase Escritor. (Lo de las cabeceras al escribir).
 * @author Diego Alba Ruiz
 */
public class MyObjectOutputStream extends ObjectOutputStream{

    //Metodos
    /**
     * Constructor de MyObjectOutputStream.
     * @throws IOException ERROR
     * @throws SecurityException ERROR 
     */
    public MyObjectOutputStream() 
            throws IOException, SecurityException {
    }
    
    /**
     * Constructor de MyObjectOutputStream.
     * @param out 
     * @throws IOException ERROR
     * @throws SecurityException ERROR 
     */
    public MyObjectOutputStream(OutputStream out) 
            throws IOException {
        super(out);
    }
    
    /**
     * Metodo que escribe cabeceras sobreescrito 
     * para que no escriba las cabeceras.
     * @throws IOException ERROR
     */
    @Override
    protected void writeStreamHeader() 
            throws IOException{
        // No hacer nada.
    }
}
