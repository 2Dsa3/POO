        package ec.edu.espol.classes;

import java.util.Scanner;


public class Camioneta extends Vehiculo{
    private String vidrio;
    private String transmision;
    private String traccion;

    public Camioneta(String placa, String marca, String modelo, int año, double recorrido, String color, String tipoCombustible, double precio, String vidrio, String transmision, String traccion)
    {
        super(placa, modelo, marca, año, recorrido, color, tipoCombustible, precio);
        this.vidrio = vidrio;
        this.transmision = transmision;
        this.traccion = traccion;

    }
    
public static Camioneta nextCamioneta(Scanner sc)
{
    String placa;
do{
System.out.println("Ingrese placa de la camioneta:");
placa = sc.nextLine();
} while(Vehiculo.verificarPlacaExistente(placa));

System.out.println("Ingrese marca de la camioneta: ");
String marca = sc.nextLine();

System.out.println("Ingrese modelo de la camioneta: ");
String modelo = sc.nextLine();

System.out.println("Ingrese año de la camioneta:");
int año = sc.nextInt();

System.out.println("Ingrese recorrido de la camioneta:");
double recorrido = sc.nextDouble();

System.out.println("Ingrese color de la camioneta: ");
String color = sc.nextLine();

System.out.println("Ingrese tipo de combustible de la camioneta: ");
String tipoCombustible = sc.nextLine();

System.out.println("Ingrese precio de la camioneta:");
double precio = sc.nextDouble();

System.out.println("Ingrese tipo de vidrio de la camioneta:");
String vidrio = sc.nextLine();

System.out.println("Ingrese transmisión de la camioneta:");
String transmision = sc.nextLine();

System.out.println("Ingrese tracción de la camioneta:");
String traccion = sc.nextLine();

System.out.println("Camioneta de placa" + placa + "exitosamente ingresado.");
    return new Camioneta(placa,marca,modelo,año,recorrido,color,tipoCombustible,precio,vidrio,transmision,traccion);
}
    
}