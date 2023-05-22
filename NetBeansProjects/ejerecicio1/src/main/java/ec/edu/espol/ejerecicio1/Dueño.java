/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.ejerecicio1;

/**
 *
 * @author abisu
 */
import java.util.ArrayList;

public class Dueño {
    int id;
    String nombres;
    String apellidos;
    String direccion;
    String telefono;
    String email;  
    ArrayList<Mascota> mascotas;
    
    public Dueño(String nombres, String apellidos)
    {
        this.nombres= nombres;
        this.apellidos= apellidos;
        this.mascotas= new ArrayList<>();
    } 
    
    public Dueño(String nombres, String apellidos, String telefono)
    {
        this.nombres= nombres;
        this.apellidos= apellidos;
        this.mascotas= new ArrayList<>();
        this.telefono= telefono;   
    } 
    public Dueño(String nombres, String apellidos, String telefono, String direccion)
    {
        this.nombres= nombres;
        this.apellidos= apellidos;
        this.mascotas= new ArrayList<>();
        this.telefono= telefono;   
    } 
    
}
