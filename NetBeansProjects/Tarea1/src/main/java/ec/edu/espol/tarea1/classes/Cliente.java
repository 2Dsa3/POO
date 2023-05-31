/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tarea1.classes;

import java.util.ArrayList;

/**
 *
 * @author abisu
 */
public class Cliente {
    
    private String nombre;
    private String cedula;
    private String direccion;
    
    ArrayList<Vehiculo> vehiculos;
    
    public Cliente(String nombre,String cedula,String direccion,ArrayList<Vehiculo> vehiculos){
        this.nombre= nombre;
        this.cedula= cedula;
        this.direccion= direccion;
        this.vehiculos= vehiculos;
    }
    
    public Cliente(){
        this.vehiculos= new ArrayList<Vehiculo>();
    }
            
}    
    
}
