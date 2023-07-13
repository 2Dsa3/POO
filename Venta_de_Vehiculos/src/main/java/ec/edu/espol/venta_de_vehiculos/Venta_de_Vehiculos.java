/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.venta_de_vehiculos;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author abisu
 */
public class Venta_de_Vehiculos {

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        int opcion;

        do
        {
            System.out.println("Menu de Opciones: ");
            System.out.println("1. Vendedor");
            System.out.println("2. Comprador");
            System.out.println("3. Salir");
            System.out.println("Ingrese su opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion)
            {
                case 1:
                    menuVendedor();
                    break;
                case 2:
                    menuComprador();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no válida, seleccione una de las 3 opciones.");
                    break;
            }
        } while(opcion !=3);

    }

    
}
