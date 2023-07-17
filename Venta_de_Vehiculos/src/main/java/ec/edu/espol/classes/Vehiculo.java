package ec.edu.espol.classes;
import java.util.Scanner;

public class Vehiculo {
    protected String placa;
    protected String marca;
    protected String modelo;
    protected String tipomotor;
    protected int año;
    protected double recorrido;
    protected String color;
    protected String tipoCombustible;
    protected double precio;
    protected Vendedor dueño;


    public Vehiculo(String placa, String marca, String modelo, String tipomotor, int año, double recorrido, String color, String tipoCombustible, double precio) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipomotor = tipomotor;
        this.año = año;
        this.recorrido = recorrido;
        this.color = color;
        this.tipoCombustible = tipoCombustible;
        this.precio = precio;
    }
    
    public Vehiculo(String placa, String marca, String modelo, String tipomotor, int año, double recorrido, String color, String tipoCombustible, double precio, Vendedor dueño){
        this( placa, marca,modelo,tipomotor,año,recorrido,color,tipoCombustible,precio);
        this.dueño=dueño;
    }


    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipomotor() {
        return tipomotor;
    }

    public void setTipomotor(String tipomotor) {
        this.tipomotor = tipomotor;
    }
    public int getAño() {
        return this.año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getRecorrido() {
        return this.recorrido;
    }

    public void setRecorrido(double recorrido) {
        this.recorrido = recorrido;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoCombustible() {
        return this.tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


public static Vehiculo nextVehiculo(Scanner sc) //Los vehículos son motocicletas. Las clases hija son autos y camionetas.
{
String placa;
do{
System.out.println("Ingrese placa de la motocicleta:");
placa = sc.nextLine();
} while(Utilitaria.existenciaDePlacaVehiculo(placa));

System.out.println("Ingrese marca de la motocicleta: ");
String marca = sc.nextLine();

System.out.println("Ingrese modelo de la motocicleta: ");
String modelo = sc.nextLine();

System.out.println("Ingrese tipo de motor de la motocicleta: ");
String tipoMotor = sc.nextLine();

System.out.println("Ingrese año de la motocicleta:");
int año = sc.nextInt();

System.out.println("Ingrese recorrido de la motocicleta:");
double recorrido = sc.nextDouble();

System.out.println("Ingrese color de la motocicleta: ");
String color = sc.nextLine();

System.out.println("Ingrese tipo de combustible de la motocicleta: ");
String tipoCombustible = sc.nextLine();

System.out.println("Ingrese precio de la motocicleta:");
double precio = sc.nextDouble();

System.out.println("Motocicleta de placa" + placa + "exitosamente ingresado.");
    return new Vehiculo(placa,marca,tipoMotor,modelo,año,recorrido,color,tipoCombustible,precio);
}

    @Override
    public String toString() {
        return "Vehiculo / " + "Placa:" + placa + " | Marca:" + marca + " | Año:" + año + " | Precio:" + precio + " | Dueño:" + dueño + "| Tipo: Motocicleta";
    }

    
}
