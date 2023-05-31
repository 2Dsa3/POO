/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author eduardo
 */
public class Polinomio {
    private int grado;
    private int[] coeficientes;
    
    public Polinomio(int grado)
    {
        this.grado = grado;
        this.coeficientes = new int[grado+1];
    }
    public Polinomio(int[] coeficientes)
    {
        this.coeficientes = coeficientes;
        this.grado = coeficientes.length - 1;
    }

    public int getGrado() {
        return grado;
    }

    public int[] getCoeficientes() {
        return coeficientes;
    }

    public void setCoeficientes(int[] coeficientes) {
        this.coeficientes = coeficientes;
    }
    
    public Polinomio sumar(Polinomio p)
    {
        int mayor = Math.max(this.grado,p.grado);
        Polinomio res = new Polinomio(mayor);
        for(int i=0; i<=this.grado;i++)
            res.coeficientes[i] += this.coeficientes[i];
        for(int i=0; i<=p.grado;i++)
            res.coeficientes[i] += p.coeficientes[i];
        return res;
    }
    
    
    public static Polinomio getPolinomio()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el grado del Polinomio ");
        int grado = sc.nextInt();
        
        int[] coeficientes = new int[grado];
        for (int i=0; i<grado; i++)
            {
                System.out.println("El orden va, a1 X^0 + a2 X^1 ...");
                System.out.println("a"+(i+1)+":");
                int coeficiente =sc.nextInt();
                coeficientes[i]= coeficiente;
                
            }
        
    Polinomio retorno= new Polinomio(coeficientes);
    return retorno;
              
    }
    public static String toString(Polinomio p) 
    {
        String pol= "";
        String var= "x^";
        for (int i=0;i<p.grado+1;i++)
            {
                if (i!= p.grado )
                    pol+=p.coeficientes[i]+var+i+"+";
                else
                    pol+=p.coeficientes[i]+var+i;
                
            }
        return pol;
    }
}
