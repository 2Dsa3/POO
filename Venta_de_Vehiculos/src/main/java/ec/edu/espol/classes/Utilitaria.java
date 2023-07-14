package ec.edu.espol.classes;

import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.File;
import java.util.Scanner;

//import java.util.Scanner;

public class Utilitaria{
    public static ArrayList<Comprador> compradorRegistrados  = new ArrayList<>() ;
    public static ArrayList<Vendedor> vendedorRegistrados  = new ArrayList<>(); 
    public static ArrayList<Vehiculo> vehiculosRegistrados = new ArrayList<>();
    public static ArrayList<Oferta> ofertasExistentes = new ArrayList<>();


    public static boolean verificarCorreo(String correo) 
    {
        for (Vendedor vendedor : vendedorRegistrados) {
            if (vendedor.getCorreo().equals(correo)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean verificarClave(String correo, String clave) 
    {
    for (Vendedor vendedor : vendedorRegistrados) {
        if (vendedor.getCorreo().equals(correo)) {
            return vendedor.getClave().equals(clave);
        }
    }
    return false;
    }
    
    public void registroVendedor()
    {
    Scanner sc = new Scanner(System.in);
    System.out.println("Registrar un nuevo vendedor");
    System.out.println("Nombre: ");
    String nombre = sc.nextLine();
    System.out.println("Apellido: ");
    String apellido = sc.nextLine();
    System.out.println("Organización: ");
    String organizacion = sc.nextLine();
    System.out.println("Correo Electrónico: ");
    String correo = sc.nextLine();



    if(verificarCorreo(correo))
        System.out.println("El correo ya está registrado.");
    else
        {
        System.out.println("Contraseña");
        String clave = sc.nextLine();
        String hash = Usuario.generarHash(clave);

        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File("vendedores.txt"), true)))
            {
            pw.println(nombre+"|"+apellido+"|"+organizacion+"|"+correo+"|"+hash);
            }
        catch(Exception e)
            {
            System.out.println(e.getMessage());
            }
        System.out.println(nombre+"|"+apellido+"|"+organizacion+"|"+correo+"|"+hash);
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