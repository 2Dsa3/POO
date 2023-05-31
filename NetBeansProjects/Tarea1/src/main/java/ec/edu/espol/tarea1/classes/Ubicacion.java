/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tarea1.classes;

/**
 *
 * @author abisu
 */
public class Ubicacion {
            int minuto;
            double latitud;
            double longitud;
    private String placa_vehiculo;
    
    public Ubicacion(int minuto, double latitud, double longitud){
        this.minuto= minuto;
        this.latitud= latitud;
        this.longitud= longitud;
        this.placa_vehiculo= placa_vehiculo;
    }
    public Ubicacion(int minuto){
        this(minuto,0,0);
    }
    
    public  int getMinuto(){
        return minuto;
        
    }
}
