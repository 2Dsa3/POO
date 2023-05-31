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
public class GPS {
    
    private int id;
            int hora_inicio;
            int hora_final;
            String marca;
            String modelo;
    private String placa_vehiculo;
    private ArrayList<Ubicacion> ubicaciones;
    
    public GPS(int id, int hora_inicio, int hora_final, String marca, String modelo, String placa_vehiculo, ArrayList<Ubicacion> ubicaciones){
        this.id= id;
        this.hora_inicio= hora_inicio;
        this.hora_final= hora_final;
        this.marca= marca;
        this.modelo= modelo;
        this.placa_vehiculo= placa_vehiculo;
        this.ubicaciones= ubicaciones;
    } 
    
    public GPS(int hora_final, String placa_vehiculo, ArrayList<Ubicacion> ubicaciones ){
        this(0,0,hora_final, "","", placa_vehiculo, ubicaciones);
    }
    public getUbicaciones(){
        return ubicaciones;
    }
}
