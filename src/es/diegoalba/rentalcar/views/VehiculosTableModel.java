
package es.diegoalba.rentalcar.views;

import es.diegoalba.rentalcar.model.Vehiculo;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;
/**
 * Clase que permite crear objetos que blablabla
 * @author b09-05m
 */
public class VehiculosTableModel extends AbstractTableModel{
        
    /**
     * Constante: nº de columnas
     */
    private static final int NUM_COLS=5;
    
    /**
     * TableModel: Nombres de columnas
     */
    private String columnNames[];
    /**
     * TableModel: Tipos de cada columna
     */
    private Class types[];
    /**
     * TableModel: Datos a mostrar
     */
    private Object data[][];
    
    /**
     * Cosntructor 1: Datos de la lista pasada.
     */
    public VehiculosTableModel(LinkedList<Vehiculo> lista){
        //Creo array con los titulos de cada columna
        columnNames = new String[NUM_COLS];
        columnNames[0] = "Numero";
        columnNames[1] = "Matricula";
        columnNames[2] = "Marca";
        columnNames[3] = "Modelo";
        columnNames[4] = "Disponible";
        
        //Creo array con los tipos de cada columna
        types = new Class[NUM_COLS];
        types[0] = Integer.class;
        types[1] = String.class;
        types[2] = String.class;
        types[3] = String.class;
        types[4] = Boolean.class; 
        
        //Creo array con los datos de la lista(celdas)
        int num = lista.size();
        data = new Object[num][NUM_COLS];
        int numVehiculo = 0;
        
        
        for(int i = 0;i<num;i++){
            Vehiculo c = lista.get(i);
            
            data[numVehiculo][0] = numVehiculo + 1;
            data[numVehiculo][1] = c.getMatricula();
            data[numVehiculo][2] = c.getMarca();
            data[numVehiculo][3] = c.getModelo();
            data[numVehiculo][4] = c.isDisponible();
            numVehiculo++;
        }
    }
    
    /**
     * Cosntructor 2:Datos fijos
     */
    public VehiculosTableModel(){
        //Creo array con los titulos de cada columna
        columnNames = new String[NUM_COLS];
//        columnNames[0] = "Numero";
        columnNames[0] = "Matricula";
        columnNames[1] = "Marca";
        columnNames[2] = "Modelo";
        columnNames[3] = "Disponible";
        
        //Creo array con los tipos de cada columna
        types = new Class[NUM_COLS];
//        types[0] = Integer.class;
        types[0] = String.class;
        types[1] = String.class;
        types[2] = String.class;
        types[3] = Boolean.class; 
        
//        //Creo array con los datos (celdas)
//        data = new Object[2][NUM_COLS];
//        //Relleno datos:
//        int numCliente=0;
//        data[numCliente][0] = "10";
//        data[numCliente][1] = "Gema Garcia";
//        data[numCliente][2] = 67.67;
//        data[numCliente][3] = true;
//        data[numCliente][4] = "Sin incidencias";
//        
//        numCliente++;
//        data[numCliente][0] = "10";
//        data[numCliente][1] = "Pepe Porras";
//        data[numCliente][2] = 55.67;
//        data[numCliente][3] = false;
//        data[numCliente][4] = "Baja e Mayo";
    }
    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data [rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int col){  //Este no es obligatorio ponerlo
        return columnNames[col];
    }
    
    /**
     * JTable usa este metodo para saber el tipo y presentarlo de forma adecauda.
     * @param columnIndex
     * @return 
     */
    @Override
    public Class getColumnClass(int columnIndex){  //Este no es obligatorio ponerlo
        return types[columnIndex];
    }
}

