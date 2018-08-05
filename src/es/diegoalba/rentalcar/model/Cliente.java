
package es.diegoalba.rentalcar.model;

import java.io.Serializable;
import java.util.Objects;
/**
 * Clase que permite crear objetos Cliente.
 * @author Diego Alba Ruiz
 */
public class Cliente implements Serializable{
    //Atributos
    private String dni;
    private String nombre;
    private String apellido;
    private String fechaAlta;
    
    //Metodos
    
    /**
     * Constructor de Cliente
     * @param dni del cliente creado
     * @param nombre del cliente creado
     * @param apellido del cliente creado
     */
    public Cliente(String dni, String nombre, String apellido){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }
  
    //Getters y Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    
    //Metodos Equals y toString sobreescritos
    @Override
    public String toString() {
        return "Cliente{" + "dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaAlta=" + fechaAlta + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.fechaAlta, other.fechaAlta)) {
            return false;
        }
        return true;
    }
    
    
}
