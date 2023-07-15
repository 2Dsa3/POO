package ec.edu.espol.classes;

import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilitaria{
    public static ArrayList<Comprador> compradorRegistrados  = new ArrayList<>() ;
    public static ArrayList<Vendedor> vendedorRegistrados  = new ArrayList<>(); 
    public static ArrayList<Vehiculo> vehiculosRegistrados = new ArrayList<>();
    public static ArrayList<Oferta> ofertasExistentes = new ArrayList<>();

    

    public static void LoadData() {
        String[] files= {"RegistrosVendedores.txt","RegistrosCompradores.txt","RegistroVehiculos.txt","RegistroOfertas.txt"};
        
   
        for (String f: files){
            try{ 
                File F=new File(f);
                Scanner reader= new Scanner(F);

                while(reader.hasNextLine()){
                    String line= reader.nextLine();
                    String[] tokens= line.split(";");
                    switch (f){
                        case "RegistrosVendedores.txt":
                            vendedorRegistrados.add(new Vendedor(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4]));
                            break;
                        case "RegistrosCompradores.txt":
                            compradorRegistrados.add(new Comprador(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4]));
                        case "RegistroVehiculos.txt":
                            Vendedor dueño= new Vendedor(null,null,null,tokens[13],null);
                            int año= Integer.parseInt(tokens[5]);
                            double recorrido= Double.parseDouble(tokens[6]);
                            double precio= Double.parseDouble(tokens[9]);
                            switch(tokens[0]){
                                case "auto" -> {
                                    Vehiculo a= new Auto( tokens[1], tokens[2], tokens[3], tokens[4],año, recorrido,tokens[7], tokens[8], precio,tokens[10],tokens[11],dueño);
                                    vehiculosRegistrados.add(a);
                            }
                                            
                                case "camioneta" -> {  
                                    Vehiculo c= new Camioneta(tokens[1], tokens[2], tokens[3], tokens[4],año, recorrido,tokens[7], tokens[8], precio,tokens[10],tokens[11],tokens[12],dueño);
                                    vehiculosRegistrados.add(c);
                            }
                                case "motocicleta" -> {
                                    Vehiculo m= new Vehiculo(tokens[1], tokens[2], tokens[3], tokens[4],año, recorrido,tokens[7], tokens[8], precio,dueño);
                                    vehiculosRegistrados.add(m);
                            }
                                    
                            }

                    }
                   
                }
                reader.close();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }

            }
        }
    

    public static boolean existenciaDeCorreoVendedor(String correo) 
    {
        for (Vendedor vendedor : Utilitaria.vendedorRegistrados) {
            if (vendedor.getCorreo().equals(correo)) {
                return true;
            }
        }
        return false;
    }
    public static boolean existenciaDeCorreoComprador(String correo) 
    {
        for (Comprador comprador : Utilitaria.compradorRegistrados) {
            if (comprador.getCorreo().equals(correo)) {
                return true;
            }
        }
        return false;
    }
    public static boolean existenciaDePlacaVehiculo(String placa){
        for (Vehiculo vehiculo:vehiculosRegistrados){
            String placa_ = vehiculo.getPlaca();
            if (placa.equals(placa_)) 
                return true;
                        
        }
    return false;    
    }
    public static boolean verificarClaveVendedor(String correo, String clave) 
    {
    for (Vendedor vendedor : vendedorRegistrados) {
        if (vendedor.getCorreo().equals(correo)) {
            return vendedor.getClave().equals(clave);
        }
    }
    return false;
    }
    public static boolean verificarClaveComprador(String correo, String clave) 
    {
    for (Comprador comprador : compradorRegistrados) {
        if (comprador.getCorreo().equals(correo)) {
            return comprador.getClave().equals(clave);
        }
    }
    return false;
    }
    
    
    public static void menuOpciones(){
        System.out.println(" Menú de Opciones:\n" +
            "1. Vendedor\n" +
            "2. Comprador\n" +
            "3. Salir\n ");
        
        System.out.println("Escoja un número (1-2-3) de acuerdo a las opciones presentadas");
        Scanner sc=  new Scanner(System.in);
        String opcion_v1= sc.next();
        while(!(opcion_v1.equals("1") || opcion_v1.equals("2") || opcion_v1.equals("3")) ){
            
            System.out.println("Número inválido, intente de nuevo");
            opcion_v1= sc.next();
        } 
        
        switch(opcion_v1){
            case "1":
                Utilitaria.opcionesVendedor();
                break;
            case "2":
                Utilitaria.opcionesComprador();
                break;
            case "3":
                System.out.println("Fin del programa");
                break;
        }
                               
            
    }

    public static void opcionesVendedor(){
        System.out.println("Opciones del vendedor: ");
        System.out.println("1. Registrar un nuevo vendedor");
        System.out.println("2. Registrar un nuevo vehículo");
        System.out.println("3. Aceptar oferta");
        System.out.println("4. Regresar");
        System.out.println("Escoja un número (1-2-3-4) de acuerdo a las opciones presentadas");
        Scanner sc=  new Scanner(System.in);
        String opcion_v2a= sc.next();
        while(!(opcion_v2a.equals("1") || opcion_v2a.equals("2") || opcion_v2a.equals("3") || opcion_v2a.equals("4")) ){ 
        System.out.println("Número inválido, intente de nuevo");
        opcion_v2a= sc.next();
        }
        switch(opcion_v2a)
        {
            case "1":
                registrarVendedor();
                break;
            case "2":
                registrarVehiculo();
                break;
            case "3":
                //aceptarOferta(sc);    
                break;
            case "4":
                Utilitaria.menuOpciones();
                break;
        }
    }
    
    public static void opcionesComprador(){
        System.out.println("Opciones del comprador: ");
        System.out.println("1. Registrar un nuevo comprador");
        System.out.println("2. Ofertar por un vehículo");
        System.out.println("3. Regresar");
        System.out.println("Escoja un número (1-2-3) de acuerdo a las opciones presentadas");
        Scanner sc=  new Scanner(System.in);
        String opcion_v2b= sc.next();
        while(! (opcion_v2b.equals("1") || opcion_v2b.equals("2") || opcion_v2b.equals("3"))){ 
        System.out.println("Número inválido, intente de nuevo");
        opcion_v2b= sc.next();
        }
        switch(opcion_v2b)
        {
            case "1":
                registrarComprador();
                break;
            case "2":

                //ofertarPorVehiculo();
                break;
            case "3":
                Utilitaria.menuOpciones();    
                break;
        }   
    }
   

    public static void registrarVendedor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Registrar un nuevo vendedor");

        System.out.println("Nombres: ");
        String nombre = sc.next();
        System.out.println("Apellidos: ");
        String apellido = sc.next();
        System.out.println("Organización: ");
        String organizacion = sc.next();
        System.out.println("Correo Electrónico: ");
        String correo = sc.next();

        while(existenciaDeCorreoVendedor(correo)){
            System.out.println("El correo ya está registrado.");
            String s_n=" ";
            do {
                System.out.println("Desea regresar al menu de opciones del vendedor? (S/N)");
                s_n= sc.next();
                s_n=s_n.toUpperCase();
            } while(!(s_n.equals("S") || s_n.equals("N")));     

            switch(s_n){
                case "S" -> Utilitaria.menuOpciones();
                case "N" -> registrarVendedor();       
            }
        }
        System.out.println("Clave: ");
        String clave = sc.next();
        System.out.println("Confirmar clave: ");
        String clave_ = sc.next();
        while(!(clave.equals(clave_))){
            System.out.println("ERROR AL INGRESAR LA CLAVE");
            System.out.println("Clave:");
            clave = sc.next();
            System.out.println("Confirmar clave:");
            clave_ = sc.next();
        }
        String hash = Usuario.generarHash(clave);

        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File("RegistrosVendedores.txt"), true)))
            {
            pw.println(nombre+";"+apellido+";"+organizacion+";"+correo+";"+hash);
            }
        catch(Exception e)
            {
            System.out.println(e.getMessage());
            }
        Vendedor v= new Vendedor(nombre,apellido,organizacion,correo,hash);//No sé si agregar a la lista el hash o la clave escrita (cual es legal?)

        vendedorRegistrados.add(v);
    }
 
    public static void registrarComprador(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Registrar un nuevo comprador");

        System.out.println("Nombres: ");
        String nombre = sc.next();
        System.out.println("Apellidos: ");
        String apellido = sc.next();
        System.out.println("Organización: ");
        String organizacion = sc.next();
        System.out.println("Correo Electrónico: ");
        String correo = sc.next();

        while(existenciaDeCorreoComprador(correo)){
            System.out.println("El correo ya está registrado.");
            String s_n=" ";
            do {
                System.out.println("Desea regresar al menu de opciones del comprador? (S/N)");
                s_n= sc.next();
                s_n=s_n.toUpperCase();
            } while(!(s_n.equals("S") || s_n.equals("N")));     

            switch(s_n){
                case "S" -> Utilitaria.menuOpciones();
                case "N" -> registrarComprador();       
            }
        }
        System.out.println("Clave: ");
        String clave = sc.next();
        System.out.println("Confirmar clave: ");
        String clave_ = sc.next();
        while(!(clave.equals(clave_))){
            System.out.println("ERROR AL INGRESAR LA CLAVE");
            System.out.println("Clave:");
            clave = sc.next();
            System.out.println("Confirmar clave:");
            clave_ = sc.next();
        }
        String hash = Usuario.generarHash(clave);

        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File("RegistrosCompradores.txt"), true)))
            {
            pw.println(nombre+";"+apellido+";"+organizacion+";"+correo+";"+hash);
            }
        catch(Exception e)
            {
            System.out.println(e.getMessage());
            }
        Comprador c= new Comprador(nombre,apellido,organizacion,correo,hash);//No sé si agregar a la lista el hash o la clave escrita (cual es legal?)

        compradorRegistrados.add(c);
    }
 
    public static void registrarVehiculo(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Registrar un nuevo vehículo");
        System.out.print("Ingrese correo electrónico:");
        String correo = sc.next();
        System.out.println("\n");
        System.out.print("ingrese su clave");
        String clave = sc.next();
        System.out.println("\n");
        while (! verificarClaveVendedor(correo, clave)){
            System.out.println("CREDENCIALES INCORRECTAS");
            System.out.print("Ingrese correo electrónico:");
            correo = sc.next();
            System.out.println("\n");
            System.out.print("ingrese su clave");
            clave = sc.next();
            System.out.println("\n");
        }
        
        System.out.println("Ingrese el tipo de vehículo (auto-camioneta-motocicleta)");
        String tipo= sc.next();
        tipo= tipo.toLowerCase();
        while (!(tipo.equals("auto") || tipo.equals("camioneta")||tipo.equals("motocicleta"))){
            System.out.println("Tipo de vehículo no válido!");
            System.out.println("Vuelva a ingresar (auto-camioneta-motocicleta) ");
            tipo= sc.next();
            tipo= tipo.toLowerCase();
        }
        System.out.println("Placa:");
        String placa = sc.next();
        while(existenciaDePlacaVehiculo(placa)){
            System.out.println("Ya ha registrado este vehiculo");
            System.out.println("Ingrese uno nuevo");
            placa=sc.next();
        }
        System.out.println("Marca");
        String marca= sc.next();
        System.out.println("Modelo");
        String modelo= sc.next();
        System.out.println("Tipo de motor");
        String tipomotor= sc.next();
        System.out.println("Año");
        int año= sc.nextInt();
        System.out.println("Recorrido");
        double recorrido= sc.nextDouble();
        System.out.println("Color");
        String color = sc.next();
        System.out.println("Tipo combustible");
        String tipocombustible= sc.next();
        
        String traccion= "N/A";
        String transmision= "N/A";
        String vidrios= "N/A";
        if (tipo.equals("auto") || tipo.equals("camioneta") ){
            System.out.println("Vidrios");
            vidrios= sc.next();
            System.out.println("Transmisión");
            transmision= sc.next();
            
        }
        if (tipo.equals("camioneta")){
            System.out.println("Tracción");
            traccion = sc.next();
            
        }
        System.out.println("Precio");
        double precio= sc.nextDouble();
     
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File("RegistroVehiculos.txt"),true))){
            pw.println(tipo+";"+placa+";"+marca+";"+modelo+";"+tipomotor+";"+año+";"+recorrido+";"+color+";"+tipocombustible+";"+precio+";"+vidrios+";"+transmision+";"+traccion+";"+correo);    
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Vendedor dueño= new Vendedor(null,null,null,correo,null);
        Vehiculo vh= new Vehiculo( placa, marca, modelo, tipomotor, año, recorrido, color, tipocombustible, precio,dueño);
        vehiculosRegistrados.add(vh);
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
    public void aceptarOferta()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Correo: ");
        String correo = sc.nextLine();
        
        if(existenciaDeCorreoVendedor(correo))
        {
            System.out.println("Contraseña: ");
            String clave = sc.nextLine();
            String hash = Usuario.generarHash(clave);
            
            if(verificarClaveVendedor(correo, hash)
            {
                System.out.println("Placa del vehículo: ");
                String pl = sc.nextLine();
                
                for (Oferta of: ofertasExistentes)
                {
                    if(of.placa.equals(pl))
                        ofertasVehiculos.add(of);
                }
                
                if(ofertasVehiculos.isEmpty())
                {
                    System.out.println("No hay vehículos ofertados con la placa ingresada.");
                    return;
                }
                
                int index = 0;
                boolean validar = true;
                int num = 1;
                
                System.out.println("\nSe han realizado "+ofertasVehiculos.size()+" oferta(s)");
                
                while(validar)
                {
                    Oferta of = ofertasVehiculos.get(0);
                    
                    System.out.println("Oferta "+num);
                    System.out.println("\nCorreo: "+correo);
                    System.out.println("Precio ofertado: "+of.precioOfertado);
                    
                    System.out.println("1.- Siguiente Oferta");
                    System.out.println("2.- Anterior Oferta");
                    System.out.println("3.- Aceptar Oferta");
                    int opcion = sc.nextInt();
                    
                    switch(opcion)
                    {
                        case 1:
                        {
                            if(index<ofertasVehiculos.size()-1)
                            {
                                index++;
                                num++;
                            }else
                                System.out.println("Este es el último vehículo.");
                        }
                        case 2:
                        {
                            if(index>0)
                            {
                                index--;
                                num--;
                            }else
                                System.out.println("Este es el primero vehículo");
                        }
                        case 3:
                        {
                            //eliminar las lineas
                            validar = false;
                            System.out.println("\nSe ha aceptado la oferta. ¡Felicidades!");
                        }
                        default:
                            System.out.println("Opción inválida");
                    }     
                }
            }else
                System.out.println("Contraseña incorrecta :S "); 
        }else
            System.out.println("Correo no registrado :0");
            
    }

}