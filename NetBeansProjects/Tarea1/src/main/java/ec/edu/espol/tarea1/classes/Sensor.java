/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tarea1.classes;

/**
 *
 * @author abisu
 */
public class Sensor {
    
             String parte;
             int temperatura;
             int minutos;
    private String placa_vehiculo;
    
    public Sensor(String parte, int temperatura, int minutos, String placa_vehiculo){
        this.parte= parte;
        this.temperatura= temperatura;
        this.minutos= minutos;
        this.placa_vehiculo= placa_vehiculo;
        
    }
    
}
