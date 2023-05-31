/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tarea1.classes;

/**
 *
 * @author abisu
 */
public class Vehiculo {
    
    private String placa;
             int año;
             double kilometraje;
    private String cedula_cliente;
    
    public Vehiculo(String placa, int año, double kilometraje, String cedula_cliente){
        this.placa= placa;
        this.año= año;
        this.kilometraje= kilometraje;
        this.cedula_cliente= cedula_cliente;  
    }
    public getPlaca(){
        return placa;
    }
}
