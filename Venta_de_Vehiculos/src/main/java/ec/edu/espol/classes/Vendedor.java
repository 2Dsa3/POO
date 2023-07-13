package ec.edu.espol.classes;

import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.IOException;
import java.util.ArrayList;


public class Vendedor extends Usuario{
    private Vehiculo vehiculo;
    private String placaVehiculo;
    private ArrayList<Vendedor> vendedores = new ArrayList<>();


    public Vendedor(String nombres, String apellidos, String organizacion, String correo, String clave,Vehiculo vehiculo, String placaVehiculo) {
        super(nombres,apellidos,organizacion,correo,clave);
        this.vehiculo = vehiculo;
        this.placaVehiculo = placaVehiculo;
    }

    public Vendedor(String nombres, String apellidos, String organizacion, String correo, String clave) {
        super(nombres,apellidos,organizacion,correo,clave);
    }
    
    public static void menuVendedor(Scanner sc)
    {
        boolean regresar = false;

        while(!regresar)
        {
            System.out.println("Opciones del vendedor: ");
            System.out.println("1. Registrar un nuevo vendedor");
            System.out.println("2. Registrar un nuevo vehículo");
            System.out.println("3. Aceptar oferta");
            System.out.println("4. Regresar");
            System.out.println("Ingrese una opción: ");
            int opcion = sc.nextInt();

            switch(opcion)
            {
                case 1;
                    registroVendedor(sc);
                case 2;
                    registrarNuevoVehiculo(sc);
                case 3;
                    aceptarOferta(sc);    
                case 4;
                    regresar = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
       
    }

    public static String calcularHash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
}

    public static Vendedor nextVendedor(Scanner sc){
        
    String[] atributos = Usuario.nextUsuario(sc,"V");
    String nombres = atributos[0];
    String apellidos = atributos[1];
    String organizacion = atributos[2];
    String correo = atributos[3];
    String clave = atributos[4];

    return new Vendedor(nombres,apellidos,organizacion,correo,clave);
    }


    public static boolean verificarCorreoExistente(String correo) 
    {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getCorreo().equals(correo)) {
                return true;
            }
        }
            return false;
    }


    public void registroVendedor(Scanner sc)
    {
        System.out.println("Registrar un nuevo vendedor");
        System.out.print("Nombres: ");
        String nombres = sc.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = sc.nextLine();
        System.out.print("Organización: ");
        String organizacion = sc.nextLine();
        System.out.print("Correo Electrónico: ");
        String correo = sc.nextLine();
        System.out.print("Clave: ");
        String clave = sc.nextLine();

        if(verificarCorreoExistente(correo))
            System.out.println("El correo ya está regustrado.");
            return;

        String claveHash = calcularHash(clave);
        Vendedor vendedor = new Vendedor(nombres, apellidos, organizacion, correo, clave);
        vendedores.add(vendedor);
    }


    

    public void registrarVehiculo(Scanner sc){ //Vendedor registre vehículo y lo asocie con él.


    }

