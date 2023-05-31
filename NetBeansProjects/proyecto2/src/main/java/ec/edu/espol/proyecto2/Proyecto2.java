/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.proyecto2;

import static ec.edu.espol.proyecto2.Polinomio.getPolinomio;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author eduardo
 */
public class Proyecto2 {

    public static void main(String[] args) {
    
        System.out.println("1er Polinomio");
        Polinomio p1= Polinomio.getPolinomio();
        Polinomio p2= Polinomio.getPolinomio();
        
        Polinomio suma= p1.sumar(p2);
        String po= Polinomio.toString(p1);
                
        System.out.println(po);
    }
    
                
        
    

    
}
