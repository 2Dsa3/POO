/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.venta_de_vehiculos;
import ec.edu.espol.classes.Utilitaria;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author abisu
 */
public class Venta_de_Vehiculos {

    public static void main(String[] args) 
    {
        Utilitaria.LoadData();
        Utilitaria.menuOpciones(); 
        System.out.println(Utilitaria.vendedorRegistrados);
        Utilitaria.vendedorRegistrados.get(0).setClave("xnrstsnbtecopiyf");
        System.out.println(Utilitaria.vendedorRegistrados.get(0).getClave());
        Utilitaria.vendedorRegistrados.get(0).enviarCorreo("davsum78@hotmail.com", "prueba javamail ", "Buenas noches");
        Utilitaria.vendedorRegistrados.get(0).enviarCorreo("dsailorgamer@gmail.com", "prueba javamail ", "Buenas noches");

    }

    
}
