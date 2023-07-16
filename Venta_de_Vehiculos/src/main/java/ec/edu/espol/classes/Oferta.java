package ec.edu.espol.classes;

//import java.util.ArrayList;
//import java.io.PrintWriter;
//import java.io.FileOutputStream;
//import java.io.File;
//import java.util.Scanner;

public class Oferta{
    private String correocomprador;
    private Vehiculo vehiculo;
    private double monto; 


    public Oferta( String correocomprador, Vehiculo vehiculo, double monto) {
        this.correocomprador = correocomprador;
        this.vehiculo = vehiculo;
        this.monto = monto;
    }

    public String getCorreocomprador() {
        return correocomprador;
    }

    public void setCorreocomprador(String correocomprador) {
        this.correocomprador = correocomprador;
    }
    
    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public double getMonto() {
        return this.monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
  
}