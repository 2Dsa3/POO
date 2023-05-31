/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tarea1.classes;

/**
 *
 * @author abisu
 */
public class Alarma {
    private String placa_vehiculo;
    private String hora_inicio;
    private String hora_fin;
    private String dia;
    
    public Alarma(String placa_vehiculo,String hora_inicio,String hora_fin, String dia){
        this.placa_vehiculo= placa_vehiculo;
        this.hora_inicio= hora_inicio;
        this.hora_fin= hora_fin;
        this.dia= dia;
    }
    public Alarma(){
        this.dia="sábado";
    }
    
    
}
