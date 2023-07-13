package ec.edu.espol.classes;

import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.File;

//import java.util.Scanner;

public class Utilitaria{
    public static ArrayList<Comprador> compradorRegistrados  = new ArrayList<>() ;
    public static ArrayList<Vendedor> vendedorRegistrados  = new ArrayList<>(); 
    public static ArrayList<Vehiculo> vehiculosRegistrados = new ArrayList<>();
    public static ArrayList<Oferta> ofertasExistentes = new ArrayList<>();




    public static void registrarVendedor(Vendedor v){
        String nomfile="RegistroVendedores";
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true))){
            pw.println(v.getCorreo()+"|"+v.getNombres()+"|"+v.getApellidos()+"|");
        }
       

    }


    /* public ArrayList<Vehiculo> filtrarVehículoTipo(String tipoauto){
        ArrayList<Vehiculo> vehiculosXtipo= new ArrayList<>() ;
        for (Vehiculo v: vehiculosRegistrados){
            if (v instanceof tipoauto){
                vehiculosXtipo.add(v);
            }
        }

        return vehiculosXtipo;

    } 
 
    public ArrayList<Vehiculo> filtrarVehículoAño(int añoinicio, int añoFinal){
        
        ArrayList<Vehiculo> vehiculosXaño= new ArrayList<>();
        for (Vehiculo v: vehiculosXtipo){
            if (v instanceof tipoauto){
                vehiculosXtipo.add(v);
            }
        }

        return ;

    }  */



}