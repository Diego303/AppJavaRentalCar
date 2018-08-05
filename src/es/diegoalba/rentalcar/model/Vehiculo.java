
package es.diegoalba.rentalcar.model;

import java.util.Objects;

/**
 * Clase que permite crear objetos Vehiculo.
 * @author Diego Alba Ruiz
 */
public class Vehiculo implements java.io.Serializable {

    //Atributos
    private String matricula;
    private String marca;
    private String modelo;
    private boolean disponible;
    private static String color = "Amarillo";
    private byte[] foto;
    private Cliente cliente;

    //Metodos
    /**
     * Constructor de Vehiculo.
     * @param matricula del vehiculo creado.
     * @param marca del vehiculo creado.
     * @param modelo del vehiculo creado.
     */
    public Vehiculo(String matricula, String marca, String modelo){
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.disponible = true;
    }

    //Getters

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public static String getColor() {
        return color;
    }

    public byte[] getFoto() {
        return foto;
    }

    //Setters

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public static void setColor(String color) {
        Vehiculo.color = color;
    }

    //Metodos
    /**
     * Metodo que usa el objeto Vehiculo para ser alquilado.
     * @param cliente el cliente al que se le asigna el vehiculo.
     */
    public void usar(Cliente cliente){
        if ((disponible) && (cliente != null)) {
            disponible = false;
            this.cliente = cliente;

            //TRAZA
            System.out.println("Se ha alquilado vehiculo");
        } else {
            //TRAZA
            System.out.println("NO se ha alquilado vehiculo");
        }
    }
    
    /**
     * Metodo que usa el objeto Vehiculo para ser decuelto y pasar a estar disponible(True)
     */
    public void devolver(){
        if (!disponible) {
            disponible = true;
            cliente = null;

            //TRAZA
            System.out.println("Este coche ya esta disponible");
        }

    }

    //Este es un getter.
    public boolean isDisponible() {
        return disponible;
    }

    //Metodos equals y toString Sobreescritos.
    @Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", disponible=" + disponible + ", cliente=" + cliente + '}';
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
        final Vehiculo other = (Vehiculo) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }


    // OTRA FORMA DE HACER EQUALS
//        public boolean equals(Vehiculo x){
//            return this.matricula.equals(x.matricula);
//        }


}
