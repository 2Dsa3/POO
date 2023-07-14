package ec.edu.espol.classes;

import java.util.Scanner;


public class Auto extends Vehiculo{
    private String vidrio;
    private String transmision;

    public Auto(String placa, String marca, String modelo, int año, double recorrido, String color, String tipoCombustible, double precio, String vidrio, String transmision)
    {
        super(placa, modelo, marca, año, recorrido, color, tipoCombustible, precio);
        this.vidrio = vidrio;
        this.transmision = transmision;

    }

public static Auto nextAuto(Scanner sc)
{
    String placa;
do{
System.out.println("Ingrese placa del auto:");
placa = sc.nextLine();
} while(Vehiculo.verificarPlacaExistente(placa));

System.out.println("Ingrese marca del auto: ");
String marca = sc.nextLine();

System.out.println("Ingrese modelo del auto: ");
String modelo = sc.nextLine();

System.out.println("Ingrese año del auto:");
int año = sc.nextInt();

System.out.println("Ingrese recorrido del auto:");
double recorrido = sc.nextDouble();

System.out.println("Ingrese color del auto: ");
String color = sc.nextLine();

System.out.println("Ingrese tipo de combustible del auto: ");
String tipoCombustible = sc.nextLine();

System.out.println("Ingrese precio del auto:");
double precio = sc.nextDouble();

System.out.println("Ingrese tipo de vidrio del auto:");
String vidrio = sc.nextLine();

System.out.println("Ingrese transmision del auto:");
String transmision = sc.nextLine();

System.out.println("Auto de placa" + placa + "exitosamente ingresado.");
    return new Auto(placa,marca,modelo,año,recorrido,color,tipoCombustible,precio,vidrio,transmision);
}
}