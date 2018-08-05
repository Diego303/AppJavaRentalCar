
package es.diegoalba.util;

/**
 * Clase que permite crear objetos que blablabla
 * @author Diego Alba Ruiz
 * @param <E>
 */
public class MyLinkedList<E>{
    
 // Clase ANIDADA Nodo --------------------
    public class Nodo {
        // INFO util
        private final E obj;// PROVISIONAL por claridad
        // Referencia al siguiente Nodo
        private Nodo sig;     // PROVISIONAL por claridad    
        // Constructor
        public Nodo(E obj){
            this.obj = obj;
            this.sig= null;
        }
    } // FIN Clase Nodo -----------------------

    private Nodo primero;
    
    public MyLinkedList(){
        this.primero = null;
    }
    
    /**
     * Añade un elemento al final de la lista
     * @param nuevoalu el alumno a añadir
     */
    public void add(E nuevoalu){

        Nodo nodo = new Nodo(nuevoalu);
        
        if (primero!=null){
            // Ref. auxiliar para hacer el recorrido
            Nodo aux;
            aux = primero;
            while (aux.sig != null){
                aux = aux.sig;
            }
            // Ya tengo el último apuntado por sig
            // Enlazo el elemento
            aux.sig = nodo; 
        }
        else {
            // Está vacía
            primero = nodo;
        }
    }
    
    /**
     * Añade un elemento en una posicion dada
     * @param element
     * @param index
     */
    public void add(E element,int index) 
                throws IndexOutOfBoundsException,NullPointerException{

        if(index < 0 || index < size()){
            throw new IndexOutOfBoundsException();
        }
        
        if(element == null){
            throw new NullPointerException();
        }
        
        // Ref. auxiliar para hacer el recorrido
        Nodo nodo = new Nodo(element);
        
        if(isEmpty()){
            primero=nodo;
            return;
        }
        
        if(index==0){
            nodo.sig = primero.sig;
            primero = nodo;
            return;
        }
        
        Nodo aux = primero;
        int pos=0;
        while (aux.sig != null && pos<index){
            aux = aux.sig;
            pos++;
        }
        
        //Ahora aux apunta al nodo anterior al nuevo
        nodo.sig = aux.sig;
        aux.sig = nodo;
        
    }
    
    /**
     * Devuelve el número de elementos de la lista.
     * 
     * @return número de elementos de la lista.
     */
    public int size(){
        int cuenta = 0;
        Nodo aux = primero;
        while (aux != null){
            cuenta++;
            aux = aux.sig;
        }
        return cuenta;
    }
    
    /**
     * Escribe los elementos que tiene la lista para
     * depuración/desarrollo.
     */
    public void print(){
       
        if (primero==null){
            // Está vacía
            System.out.printf("* NO Tiene elementos %n");
            return;
        }
        
        Nodo aux = primero;
        while (aux!=null){
            // Escribir info
            System.out.println(aux.obj);
            // Ir al siguiente
            aux = aux.sig;
        }
    }
    
    /**
     * Metodo para saber si la lista esta vacia
     * @return devuelve true si esta vacia, y false si hay elementos.
     */
    public boolean isEmpty(){
        if(primero==null){
            return true;
        }
        return false;
    }
    
    /**
     * Metodo para obtener un nodo pasando por parametro su posicion
     * @param index es la posicion del nodo que queremos obtener
     * @return el nodo de la posicion index
     * @throws IndexOutOfBoundsException 
     */
    public E get(int index)
            throws IndexOutOfBoundsException{
        
        //Excepcion
        if(index>=size() || index<0){
            throw new IndexOutOfBoundsException();
        }
        
        //Obtengo el nodo segun la posicion(index)
        int pos=0;
        Nodo aux = primero;
        
        while(pos < index){
            aux = aux.sig;
            pos++;
        }
        return aux.obj;
        
    }
    
    /**
     * Metodo que devuelve el index de la primera ocurrencia del elemento 
     * @param element elemento pasado por parametro.
     * @return 
     */
    public int indexOf(E element){
        int pos=0;
        boolean encontrado = false;
        Nodo aux;
        aux=primero;
        
        while (aux!= null && !encontrado){
            if (element.equals(aux.obj)){
                encontrado = true;
            }
            else{
                aux=aux.sig;
                pos++;
            }
        }    
    
        if(encontrado){
            return pos;
        }
        
        return pos;
    }
    
    /**
     * Metodo que borra un nodo de la lista con posicion pasada por parametro 
     * y te lo devuelve.
     * @param index es la posicion del nodo que se quiere borrar.
     * @return el nodo que se ha borrado.
     * @throws IndexOutOfBoundsException Excepcion que se ejecuta si
     *                                   el parametro esta fuera de la lista.
     */
    public E remove(int index)
                throws IndexOutOfBoundsException{
        
        //Comprobar index y lanzar excepcion.
        if(index>=size() || index<0){
            throw new IndexOutOfBoundsException();
        }
        
        //Si es el primer nodo.
        if(index==0){
            E obj = primero.obj;
            primero = primero.sig;
            return obj;
        } 
        
        //Esto en caso de no ser el primero.
        int pos=1;
        Nodo aux = primero.sig;
        Nodo ant = primero;
        
        //Recorrido para llegar al que se quiere borrar
        while(pos < index){
            ant = aux;
            aux = aux.sig;
            pos++;
        }
        
        //Se vuelve a enlazar la lista saltandose el que se quiere borrar.
        ant.sig = aux.sig;
        
        //Se devuelve el elemento saltado o borrado de la lista.
        return aux.obj;
        
        
    }

    //</editor-fold> 

    //</editor-fold>

}
