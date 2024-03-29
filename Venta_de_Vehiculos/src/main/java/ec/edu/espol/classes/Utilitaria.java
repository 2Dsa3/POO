package ec.edu.espol.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Session;
import javax.mail.Transport;


public class Utilitaria{
    public static ArrayList<Comprador> compradorRegistrados  = new ArrayList<>();
    public static ArrayList<Vendedor> vendedorRegistrados  = new ArrayList<>(); 
    public static ArrayList<Vehiculo> vehiculosRegistrados = new ArrayList<>();
    public static ArrayList<Oferta> ofertasRegistradas = new ArrayList<>();

    

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
                            break;
                        case "RegistroVehiculos.txt":
                            Vendedor dueño= new Vendedor(null,null,null,tokens[13],null);
                            int año= Integer.parseInt(tokens[5]);
                            double recorrido= Double.parseDouble(tokens[6]);
                            double precio= Double.parseDouble(tokens[9]);
                            switch(tokens[0]){
                                case "auto" -> {
                                    Vehiculo a= new Auto( tokens[1], tokens[2], tokens[3], tokens[4],año, recorrido,tokens[7], tokens[8], precio,tokens[10],tokens[11],dueño);
                                    vehiculosRegistrados.add(a);
                                    break;
                                }
                                            
                                case "camioneta" -> {  
                                    Vehiculo c= new Camioneta(tokens[1], tokens[2], tokens[3], tokens[4],año, recorrido,tokens[7], tokens[8], precio,tokens[10],tokens[11],tokens[12],dueño);
                                    vehiculosRegistrados.add(c);
                                    break;
                                }
                                case "motocicleta" -> {
                                    Vehiculo m= new Vehiculo(tokens[1], tokens[2], tokens[3], tokens[4],año, recorrido,tokens[7], tokens[8], precio,dueño);
                                    vehiculosRegistrados.add(m);
                                    break;
                                }
                            }
                            break;
                        case "RegistroOfertas.txt":
                            Vehiculo vh= new Vehiculo(tokens[0],tokens[1],tokens[2],null,0,0.0,null,null,0.0);
                            double monto=Double.parseDouble(tokens[4]);
                            Oferta of= new Oferta(tokens[3],vh,monto);
                            ofertasRegistradas.add(of);
                            break;
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
            return vendedor.getClave().equals(Usuario.generarHash(clave));
        }
    }
    return false;
    }
    public static boolean verificarClaveComprador(String correo, String clave) 
    {
    for (Comprador comprador : compradorRegistrados) {
        if (comprador.getCorreo().equals(correo)) {
            return comprador.getClave().equals(Usuario.generarHash(clave));
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
        String opcion_v1= sc.nextLine();
        while(!(opcion_v1.equals("1") || opcion_v1.equals("2") || opcion_v1.equals("3")) ){
            
            System.out.println("Número inválido, intente de nuevo");
            opcion_v1= sc.nextLine();
        } 
        
        switch(opcion_v1){
            case "1":
                opcionesVendedor();
                break;
            case "2":
                opcionesComprador();
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
        String opcion_v2a= sc.nextLine();
        while(!(opcion_v2a.equals("1") || opcion_v2a.equals("2") || opcion_v2a.equals("3") || opcion_v2a.equals("4")) ){ 
        System.out.println("Número inválido, intente de nuevo");
        opcion_v2a= sc.nextLine();
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
                aceptarOferta();
                break;
            case "4":
                menuOpciones();
                break;
        }
    }
    
    public static void opcionesComprador(){
        System.out.println("Opciones del comprador: ");
        System.out.println("1. Registrar un nuevo comprador");
        System.out.println("2. Ofertar por un vehículo");
        System.out.println("3. Eliminar Oferta");
        System.out.println("4. Regresar");
        System.out.println("Escoja un número (1-2-3-4) de acuerdo a las opciones presentadas");
        Scanner sc=  new Scanner(System.in);
        String opcion_v2b= sc.nextLine();
        while(! (opcion_v2b.equals("1") || opcion_v2b.equals("2") || opcion_v2b.equals("3") || opcion_v2b.equals("4"))){ 
        System.out.println("Número inválido, intente de nuevo");
        opcion_v2b= sc.nextLine();
        }
        switch(opcion_v2b)
        {
            case "1":
                registrarComprador();
                break;
            case "2":
                OfertarporVehiculo();
                break;
            case "4":
                menuOpciones();    
                break;
            case "3":
                eliminarOfertaComprador();
                break;
        }    
    }
   

    public static void registrarVendedor(){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Registrar un nuevo vendedor");

        System.out.println("Nombres: ");
        String nombre = sc.nextLine();
        System.out.println("Apellidos: ");
        String apellido = sc.nextLine();
        System.out.println("Organización: ");
        String organizacion = sc.nextLine();
        System.out.println("Correo Electrónico: ");
        String correo = sc.nextLine();

        while(existenciaDeCorreoVendedor(correo)){
            System.out.println("El correo ya está registrado.");
            String s_n=" ";
            do {
                System.out.println("Desea regresar al menu de opciones principal? (S/N)");
                s_n= sc.nextLine();
                s_n=s_n.toUpperCase();
            } while(!(s_n.equals("S") || s_n.equals("N")));     

            switch(s_n){
                case "S" -> menuOpciones();
                case "N" -> opcionesVendedor();       
            }
        }
        System.out.println("Clave: ");
        String clave = sc.nextLine();
        System.out.println("Confirmar clave: ");
        String clave_ = sc.nextLine();
        while(!(clave.equals(clave_))){
            System.out.println("ERROR AL INGRESAR LA CLAVE\n");
            System.out.println("Clave:");
            clave = sc.nextLine();
            System.out.println("Confirmar clave:");
            clave_ = sc.nextLine();
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
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Registrar un nuevo comprador");

        System.out.println("Nombres: ");
        String nombre = sc.nextLine();
        System.out.println("Apellidos: ");
        String apellido = sc.nextLine();
        System.out.println("Organización: ");
        String organizacion = sc.nextLine();
        System.out.println("Correo Electrónico: ");
        String correo = sc.nextLine();

        while(existenciaDeCorreoComprador(correo)){
            System.out.println("El correo ya está registrado.");
            String s_n="";
            do {
                System.out.println("Desea regresar al menu de opciones principal? (S/N)");
                s_n= sc.nextLine();
                s_n=s_n.toUpperCase();
            } while(!(s_n.equals("S") || s_n.equals("N")));     

            switch(s_n){
                case "S" -> menuOpciones();
                case "N" -> opcionesComprador();       
            }
        }
        System.out.println("Clave: ");
        String clave = sc.nextLine();
        System.out.println("Confirmar clave: ");
        String clave_ = sc.nextLine();
        while(!(clave.equals(clave_))){
            System.out.println("ERROR AL INGRESAR LA CLAVE");
            System.out.println("Clave:");
            clave = sc.nextLine();
            System.out.println("Confirmar clave:");
            clave_ = sc.nextLine();
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
        
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Registrar un nuevo vehículo");
        System.out.print("Ingrese correo electrónico: ");
        String correo = sc.nextLine();
        System.out.println("\n");
        System.out.print("Ingrese su clave: ");
        String clave = sc.nextLine();
        System.out.println("\n");
        if (existenciaDeCorreoVendedor(correo)){
            while (! verificarClaveVendedor(correo, clave)){
                System.out.println("CREDENCIALES INCORRECTAS");
                System.out.print("Ingrese correo electrónico: ");
                correo = sc.nextLine();
                System.out.println("\n");
                System.out.print("Ingrese su clave: ");
                clave = sc.nextLine();
                System.out.println("\n");
            }

            System.out.println("Ingrese el tipo de vehículo (auto-camioneta-motocicleta)");
            String tipo= sc.nextLine();
            tipo= tipo.toLowerCase();
            while (!(tipo.equals("auto") || tipo.equals("camioneta")||tipo.equals("motocicleta"))){
                System.out.println("Tipo de vehículo no válido!");
                System.out.println("Vuelva a ingresar (auto-camioneta-motocicleta) ");
                tipo= sc.nextLine();
                tipo= tipo.toLowerCase();
            }
            System.out.println("Placa:");
            String placa = sc.nextLine();
            while(existenciaDePlacaVehiculo(placa)){
                System.out.println("Ya ha registrado este vehiculo");
                System.out.println("Ingrese uno nuevo");
                placa=sc.nextLine();
            }
            System.out.println("Marca");
            String marca= sc.nextLine();
            System.out.println("Modelo");
            String modelo= sc.nextLine();
            System.out.println("Tipo de motor");
            String tipomotor= sc.nextLine();
            System.out.println("Año");
            int año= sc.nextInt();
            System.out.println("Recorrido");
            double recorrido= sc.nextDouble();
            sc.nextLine();
            System.out.println("Color");
            String color = sc.nextLine();
            System.out.println("Tipo combustible");
            String tipocombustible= sc.nextLine();
            String traccion= "N/A";
            String transmision= "N/A";
            String vidrios= "N/A";
            if (tipo.equals("auto") || tipo.equals("camioneta") ){
                System.out.println("Vidrios");
                vidrios= sc.nextLine();
                System.out.println("Transmisión");
                transmision= sc.nextLine();

            }
            if (tipo.equals("camioneta")){
                System.out.println("Tracción");
                traccion = sc.nextLine();

            }
            System.out.println("Precio");
            double precio= sc.nextDouble();

            try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File("RegistroVehiculos.txt"),true))){
                pw.println(tipo+";"+placa+";"+marca+";"+modelo+";"+tipomotor+";"+año+";"+recorrido+";"+color+";"+tipocombustible+";"+precio+";"+vidrios+";"+transmision+";"+traccion+";"+correo);    
            } 
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Vendedor dueño = Vendedor.getVendedor(correo);
            Vehiculo vh= new Vehiculo( placa, marca, modelo, tipomotor, año, recorrido, color, tipocombustible, precio,dueño);
            Vendedor.getVendedor(correo).setVehiculo(vh);
            vehiculosRegistrados.add(vh);
            System.out.println("Fin del programa");
        }
        else {System.out.println("Correo no registrado");
            Utilitaria.opcionesVendedor();}
    }
    
    public static void eliminarVehiculo(String archivo, String eliminado)
    {
        File arch = new File(archivo);
        File borrador = new File("borrador.txt");
        
        try (BufferedReader br = new BufferedReader(new FileReader(arch));
             BufferedWriter bw = new BufferedWriter(new FileWriter(borrador))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.contains(eliminado)) {
                    bw.write(linea);
                    bw.newLine();
                    
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(BufferedReader br2 = new BufferedReader(new FileReader(borrador));
             BufferedWriter bw2 = new BufferedWriter(new FileWriter(arch,false))){
            
            String linea2;
            while ((linea2=br2.readLine())!=null){
                bw2.write(linea2);
                bw2.newLine();
            }
            
            
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        borrador.delete();
        
    }
    


    public static ArrayList<Vehiculo> filtrarVehículoTipo(ArrayList<Vehiculo> vehiculofiltrador){
        Scanner sc=new Scanner(System.in);
        String tipoauto; 
        String s_n= null;
        do {
            System.out.println("Filtrar por tipo? (S-N)");
            s_n= sc.nextLine().toLowerCase().trim();
        } while (!(s_n.equals("s")||s_n.equals("n")));
        
        ArrayList<Vehiculo> vehiculosXtipo = new ArrayList<>() ;
        if (s_n.equals("n")) {
            return vehiculofiltrador;
        }
            System.out.println("Ingrese tipoauto: ");
            tipoauto = sc.nextLine();
            
        for (Vehiculo v: vehiculofiltrador)
        {
            //System.out.println(String.valueOf(v.getClass()));
            if (String.valueOf(v.getClass()).equals("java.classes"+ tipoauto))
            {
                vehiculosXtipo.add(v);
            }
        }
        if (s_n.equals("s")) {
            return vehiculosXtipo;
        }

        return vehiculosXtipo;

    } 
    

    public static ArrayList<Vehiculo> filtrarVehículoAño(ArrayList<Vehiculo> vehiculofiltrador)
    {
        Scanner sc=new Scanner(System.in);
        String s_n= null;
        do {
            System.out.println("Filtrar por año? (S-N)");
            s_n= sc.nextLine().toLowerCase().trim();
        } while (!(s_n.equals("s")||s_n.equals("n")));
        ArrayList<Vehiculo> vehiculosXaño = new ArrayList<>();
        
        if (s_n.equals("n"))
            return vehiculofiltrador;
        
        System.out.println("Ingrese año de inicio: ");
        int añoInicio = sc.nextInt();
        
        System.out.println("Ingrese año de fin: ");
        int añoFinal = sc.nextInt();
        
        for (Vehiculo v: vehiculofiltrador)
        {
            if (v.año >= añoInicio)
            {
                if(v.año <= añoFinal)
                    vehiculosXaño.add(v);
            }
        }
        
        return vehiculosXaño;
    }


    public static ArrayList<Vehiculo> filtrarVehículoRecorrido(ArrayList<Vehiculo> vehiculofiltrador){
        Scanner sc=new Scanner(System.in);
        String s_n= null;
        do {
            System.out.println("Filtrar por recorrido? (S-N)");
            s_n= sc.nextLine().toLowerCase().trim();
        } while (!(s_n.equals("s")||s_n.equals("n")));
        
        ArrayList<Vehiculo> vehiculosXrecorrido= new ArrayList<>() ;
        if (s_n.equals("n"))
            return vehiculofiltrador;
            
        System.out.println("Ingrese recorrido mínimo: ");
        double min = sc.nextDouble();
        
        System.out.println("Ingrese recorrido máximo: ");
        double max = sc.nextDouble();
        
        for (Vehiculo v: vehiculofiltrador)
        {
            if (v.recorrido >= min)
            {
                if(v.recorrido <= max)
                    vehiculosXrecorrido.add(v);
            }
        }
        return vehiculosXrecorrido;

    } 
  
    public static ArrayList<Vehiculo> filtrarVehículoPrecio(ArrayList<Vehiculo> vehiculofiltrador){
        Scanner sc=new Scanner(System.in);
        String s_n= null;
        do {
            System.out.println("Filtrar por precio? (S-N)");
            s_n= sc.nextLine().toLowerCase().trim();
        } while (!(s_n.equals("s")||s_n.equals("n")));
        ArrayList<Vehiculo> vehiculosXprecio= new ArrayList<>();
        
        if (s_n.equals("n"))
            return vehiculofiltrador;
        
        System.out.println("Ingrese precio mínimo: ");
        double min = sc.nextDouble();
        
        System.out.println("Ingrese precio máximo: ");
        double max = sc.nextDouble();
        
        for (Vehiculo v: vehiculofiltrador){
            if (v.getPrecio()>= min)
            {
                if(v.getPrecio() <= max)
                    vehiculosXprecio.add(v);
            }
        }
        
        return vehiculosXprecio;
    } 
    
    public static void OfertarporVehiculo(){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        String s_n=null;
        System.out.println("Ofertar por un vehículo");
        do {
            System.out.println("Filtrar? (S-N)");
            s_n= sc.nextLine().toLowerCase().trim();
        } while (!(s_n.equals("s")||s_n.equals("n")));

        switch (s_n){
            case "s":
                ArrayList<Vehiculo> vehiculosfiltrados= vehiculosRegistrados;
                ArrayList<Vehiculo> vehiculosfiltradosXTIPO = filtrarVehículoTipo(vehiculosfiltrados);
                ArrayList<Vehiculo> vehiculosfiltradosXAÑO= filtrarVehículoAño(vehiculosfiltradosXTIPO);
                ArrayList<Vehiculo> vehiculosfiltradosXKM= filtrarVehículoRecorrido(vehiculosfiltradosXAÑO);
                ArrayList<Vehiculo> vehiculosfiltradosPRECIO = filtrarVehículoPrecio(vehiculosfiltradosXKM);
//               
                mostrarVehiculo(0,vehiculosfiltradosPRECIO);
                    
                break;
            case "n":
                mostrarVehiculo(0,vehiculosRegistrados);
                break;
        }
        
    }
    
    public static void mostrarVehiculo(int index, ArrayList<Vehiculo> vehiculosfiltrados)//en el principal comienza en 0
    {
       
        System.out.println(vehiculosfiltrados.get(index).toString());
        Scanner sc= new Scanner(System.in).useLocale(Locale.US);
        if (index==0 && vehiculosfiltrados.size()>1 ){
            System.out.println("1. Siguiente Vehiculo");
            System.out.println("2. Realizar Oferta");
            String opcion_v3b= sc.nextLine();
            while(!(opcion_v3b.equals("1") || opcion_v3b.equals("2") ) ){ 
            System.out.println("Número inválido, intente de nuevo");
            opcion_v3b= sc.nextLine();
            }
            switch(opcion_v3b){
                
                case "1" ->{index=index+1; mostrarVehiculo(index,vehiculosfiltrados);}
                case "2" -> Utilitaria.generarOferta(vehiculosfiltrados.get(index));
            }
        }
        else if(index==0 && vehiculosfiltrados.size()==1){
            System.out.println("Por el momento solo existe este vehiculo en el mercado");
            String s_n=null;
            do {
                System.out.println("Realizar oferta? (S-N)");;
                s_n= sc.nextLine().toLowerCase().trim();
            } while (!(s_n.equals("s")||s_n.equals("n")));
            switch(s_n){
                
                case "n" -> Utilitaria.menuOpciones();
                case "s" -> Utilitaria.generarOferta(vehiculosfiltrados.get(index));
            }
        }
        else if(index==vehiculosfiltrados.size()-1){
            System.out.println("1. Anterior Vehiculo");
            System.out.println("2. Realizar Oferta");
            String opcion_v3b= sc.nextLine();
            while(!(opcion_v3b.equals("1") || opcion_v3b.equals("2") ) ){ 
            System.out.println("Número inválido, intente de nuevo");
            opcion_v3b= sc.nextLine();
            }
            switch(opcion_v3b){
                
                case "1" ->{index=index-1; mostrarVehiculo(index,vehiculosfiltrados);}
                case "2" -> Utilitaria.generarOferta(vehiculosfiltrados.get(index));
            }
        }
        else{
            System.out.println("1. Anterior Vehiculo");
            System.out.println("2. Siguiente Vehiculo");
            System.out.println("3. Realizar Oferta");
            String opcion_v3b= sc.nextLine();
            while(!(opcion_v3b.equals("1") || opcion_v3b.equals("2")|| opcion_v3b.equals("3")  ) ){ 
            System.out.println("Número inválido, intente de nuevo");
            opcion_v3b= sc.nextLine();
            }
            switch(opcion_v3b){
                case "1" -> {index=index-1;mostrarVehiculo(index,vehiculosfiltrados);}
                case "2" -> {index=index+1;mostrarVehiculo(index,vehiculosfiltrados);}
                case "3" -> Utilitaria.generarOferta(vehiculosfiltrados.get(index));
                    
            }
        } 
            
            
        }
       
    
    public static void generarOferta(Vehiculo vh){
        System.out.println("Incie sesión...");
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Ingrese correo electrónico: ");
        String correo = sc.nextLine();
        if(existenciaDeCorreoComprador(correo))
        {
            System.out.println("\n");
            System.out.print("Ingrese su clave: ");
            String clave = sc.nextLine();
            System.out.println("\n");
            while (! verificarClaveComprador(correo, clave)){
                System.out.println("CREDENCIALES INCORRECTAS");
                System.out.print("Ingrese correo electrónico: ");
                correo = sc.nextLine();
                System.out.println("\n");
                System.out.print("Ingrese su clave: ");
                clave = sc.nextLine();
                System.out.println("\n");
            }
            {
                System.out.println("Precio a ofertar:");
                double precio_comp= Math.abs(sc.nextDouble());
                
                try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File("RegistroOfertas.txt"),true))){
                    pw.println(vh.getPlaca()+";"+vh.getMarca()+";"+vh.getModelo()+";"+correo+";"+precio_comp);    
                } 
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                Oferta of= new Oferta(correo,vh,precio_comp);
                ofertasRegistradas.add(of);
                System.out.println("Fin del programa");
            }
        } else  {System.out.println("Correo no registrado");
                Utilitaria.opcionesComprador();}
        

    }        
        
    
    public static void aceptarOferta()
    {
        System.out.println("Inicie sesión...");
        Scanner sc = new Scanner(System.in);
        System.out.println("Correo: ");
        String correo = sc.nextLine();
        ArrayList<Oferta> ofertasplaca= new ArrayList<>();
        String clave= null;
        
        if(existenciaDeCorreoVendedor(correo))
        {
            System.out.println("Contraseña: ");
            clave = sc.nextLine();
            
            if(verificarClaveVendedor(correo, clave))
            {
                System.out.println("Placa del vehículo: ");
                String pl = sc.nextLine();
                
                
                if(ofertasRegistradas.isEmpty())
                {
                    System.out.println("No tienes ninguna oferta por el momento");
                    Utilitaria.opcionesVendedor();
                    
                }
                else {
                    for (Oferta ofs: ofertasRegistradas)
                    {
                        Vehiculo vh= ofs.getVehiculo();
                        if(vh.getPlaca().equals(pl))
                            ofertasplaca.add(ofs);
                    }
                    
                }
                int index = 0;
                System.out.println("\nSe han realizado "+ofertasplaca.size()+" oferta(s)");
                
                if (!ofertasplaca.isEmpty()){
                    
                
                if (!mostrarOferta(index, ofertasplaca).equals(".")){
                    Vendedor remitente= new Vendedor(null, null, null, correo, clave);
                    String asunto= "Se ha aceptado su oferta!";
                    System.out.println("\nMensaje a enviar?\n");
                    String cuerpo= sc.nextLine();
                    remitente.enviarCorreo(mostrarOferta(index, ofertasplaca), asunto, cuerpo);}}
            }else
                {System.out.println("Contraseña incorrecta :");
                 opcionesVendedor();
                }
        }else
            {System.out.println("Correo no registrado");
            opcionesVendedor();}
            
    }
    public static String mostrarOferta(int index,ArrayList<Oferta> ofertasfiltradas ){
        System.out.println(ofertasfiltradas.get(index).toString());
        Scanner sc= new Scanner(System.in).useLocale(Locale.US);
        if (index==0 && ofertasfiltradas.size()>1 ){
            System.out.println("1. Siguiente Oferta");
            System.out.println("2. Aceptar Oferta");
            String opcion_v3b= sc.nextLine();
            while(!(opcion_v3b.equals("1") || opcion_v3b.equals("2") ) ){ 
            System.out.println("Número inválido, intente de nuevo");
            opcion_v3b= sc.nextLine();
            }
            switch(opcion_v3b){
                
                case "1" ->{index=index+1; mostrarOferta(index,ofertasfiltradas);}
                case "2" ->{String corcom=ofertasfiltradas.get(index).getCorreocomprador();
                            eliminarVehiculo("RegistroOfertas.txt",ofertasfiltradas.get(index).getVehiculo().getPlaca());
                            eliminarVehiculo("RegistroVehiculos.txt",ofertasfiltradas.get(index).getVehiculo().getPlaca());
                            System.out.println("\nSe ha aceptado la oferta. ¡Felicidades!");
                            return corcom;
                            }
            }
        }
        else if(index==0 && ofertasfiltradas.size()==1){
            System.out.println("Por el momento solo existe esta oferta");
            String s_n=null;
            do {
                System.out.println("Aceptar oferta? (S-N)");;
                s_n= sc.nextLine().toLowerCase().trim();
            } while (!(s_n.equals("s")||s_n.equals("n")));
            switch(s_n){
                
                case "n" -> Utilitaria.menuOpciones();
                case "s" ->{String corcom=ofertasfiltradas.get(index).getCorreocomprador();
                            eliminarVehiculo("RegistroOfertas.txt",ofertasfiltradas.get(index).getVehiculo().getPlaca());
                            eliminarVehiculo("RegistroVehiculos.txt",ofertasfiltradas.get(index).getVehiculo().getPlaca());
                            System.out.println("\nSe ha aceptado la oferta. ¡Felicidades!");
                            return corcom;}
            }
        }
        else if(index==ofertasfiltradas.size()-1){
            System.out.println("1. Anterior Oferta");
            System.out.println("2. Aceptar Oferta");
            String opcion_v3b= sc.nextLine();
            while(!(opcion_v3b.equals("1") || opcion_v3b.equals("2") ) ){ 
            System.out.println("Número inválido, intente de nuevo");
            opcion_v3b= sc.nextLine();
            }
            switch(opcion_v3b){
                
                case "1" ->{index=index-1; mostrarOferta(index,ofertasfiltradas);}
                case "2" ->{String corcom=ofertasfiltradas.get(index).getCorreocomprador();
                            eliminarVehiculo("RegistroOfertas.txt",ofertasfiltradas.get(index).getVehiculo().getPlaca());
                            eliminarVehiculo("RegistroVehiculos.txt",ofertasfiltradas.get(index).getVehiculo().getPlaca());
                            System.out.println("\nSe ha aceptado la oferta. ¡Felicidades!");
                            return corcom;}
            }
        }
        else{
            System.out.println("1. Anterior Oferta");
            System.out.println("2. Siguiente Oferta");
            System.out.println("3. Aceptar Oferta");
            String opcion_v3b= sc.nextLine();
            while(!(opcion_v3b.equals("1") || opcion_v3b.equals("2")|| opcion_v3b.equals("3")  ) ){ 
            System.out.println("Número inválido, intente de nuevo");
            opcion_v3b= sc.nextLine();
            }
            switch(opcion_v3b){
                case "1" -> {index=index-1;mostrarOferta(index,ofertasfiltradas);}
                case "2" -> {index=index+1;mostrarOferta(index,ofertasfiltradas);}
                case "3" -> {String corcom=ofertasfiltradas.get(index).getCorreocomprador();
                            eliminarVehiculo("RegistroOfertas.txt",ofertasfiltradas.get(index).getVehiculo().getPlaca());
                            eliminarVehiculo("RegistroVehiculos.txt",ofertasfiltradas.get(index).getVehiculo().getPlaca());
                            System.out.println("\nSe ha aceptado la oferta. ¡Felicidades!");
                            return corcom ;}
                    
            }
        } 
        return ".";   
    }
    
    
    public static void eliminarOfertaComprador(){
        System.out.println("Inicie sesión...");
        Scanner sc = new Scanner(System.in);
        System.out.println("Correo: ");
        String correo = sc.nextLine();
        ArrayList<Oferta> ofertascomp= new ArrayList<>();
        String clave= null;
        
        if(existenciaDeCorreoComprador(correo))
        {
            System.out.println("Contraseña: ");
            clave = sc.nextLine();
            
            if(verificarClaveComprador(correo, clave))
            {
                if(ofertasRegistradas.isEmpty())
                {
                    System.out.println("No has realizado ninguna oferta por el momento");
                    Utilitaria.opcionesVendedor();
                    
                }
                else {
                    for (Oferta ofs: ofertasRegistradas)
                    {
                        String correocomp= ofs.getCorreocomprador();
                        if(correocomp.equals(correo))
                            ofertascomp.add(ofs);
                    }
                    
                }
                int index = 0;
                System.out.println("\nHas realizado "+ofertascomp.size()+" oferta(s)");
                
                if (!ofertascomp.isEmpty()){
                    mostrarOfertaComprador(index, ofertascomp);
                } 
                
            }else
                {System.out.println("Contraseña incorrecta :");
                 opcionesComprador();
                }
        }else
            {System.out.println("Correo no registrado");
            opcionesComprador();}
            
    }
    
    public static void mostrarOfertaComprador(int index,ArrayList<Oferta> ofertasfiltradas ){
        System.out.println(ofertasfiltradas.get(index).toString());
        Scanner sc= new Scanner(System.in).useLocale(Locale.US);
        if (index==0 && ofertasfiltradas.size()>1 ){
            System.out.println("1. Siguiente Oferta");
            System.out.println("2. Eliminar Oferta");
            String opcion_v3b= sc.nextLine();
            while(!(opcion_v3b.equals("1") || opcion_v3b.equals("2") ) ){ 
            System.out.println("Número inválido, intente de nuevo");
            opcion_v3b= sc.nextLine();
            }
            switch(opcion_v3b){
                
                case "1" ->{index=index+1; mostrarOfertaComprador(index,ofertasfiltradas);}
                case "2" ->{ eliminarCorreocompYplaca("RegistroOfertas.txt",ofertasfiltradas.get(index).getCorreocomprador(),ofertasfiltradas.get(index).getVehiculo().getPlaca());
                            System.out.println("\nSe ha eliminado la oferta.");
                            }
            }
        }
        else if(index==0 && ofertasfiltradas.size()==1){
            System.out.println("Por el momento solo has realizado esta oferta");
            String s_n=null;
            do {
                System.out.println("Eliminar oferta? (S-N)");;
                s_n= sc.nextLine().toLowerCase().trim();
            } while (!(s_n.equals("s")||s_n.equals("n")));
            switch(s_n){
                
                case "n" -> Utilitaria.menuOpciones();
                case "s" ->{ eliminarCorreocompYplaca("RegistroOfertas.txt",ofertasfiltradas.get(index).getCorreocomprador(),ofertasfiltradas.get(index).getVehiculo().getPlaca());
                            System.out.println("\nSe ha eliminado la oferta.");
                            }
            }
        }
        else if(index==ofertasfiltradas.size()-1){
            System.out.println("1. Anterior Oferta");
            System.out.println("2. Eliminar Oferta");
            String opcion_v3b= sc.nextLine();
            while(!(opcion_v3b.equals("1") || opcion_v3b.equals("2") ) ){ 
            System.out.println("Número inválido, intente de nuevo");
            opcion_v3b= sc.nextLine();
            }
            switch(opcion_v3b){
                
                case "1" ->{index=index-1; mostrarOfertaComprador(index,ofertasfiltradas);}
                case "2" ->{eliminarCorreocompYplaca("RegistroOfertas.txt",ofertasfiltradas.get(index).getCorreocomprador(),ofertasfiltradas.get(index).getVehiculo().getPlaca());
                            System.out.println("\nSe ha eliminado la oferta");
                            }
            }
        }
        else{
            System.out.println("1. Anterior Oferta");
            System.out.println("2. Siguiente Oferta");
            System.out.println("3. Eliminar Oferta");
            String opcion_v3b= sc.nextLine();
            while(!(opcion_v3b.equals("1") || opcion_v3b.equals("2")|| opcion_v3b.equals("3")  ) ){ 
            System.out.println("Número inválido, intente de nuevo");
            opcion_v3b= sc.nextLine();
            }
            switch(opcion_v3b){
                case "1" -> {index=index-1;mostrarOfertaComprador(index,ofertasfiltradas);}
                case "2" -> {index=index+1;mostrarOfertaComprador(index,ofertasfiltradas);}
                case "3" -> {eliminarCorreocompYplaca("RegistroOfertas.txt",ofertasfiltradas.get(index).getCorreocomprador(),ofertasfiltradas.get(index).getVehiculo().getPlaca());
                            System.out.println("\nSe ha eliminado la oferta.");
                            }
                    
            }
        }} 

    public static void eliminarCorreocompYplaca(String archivo, String correocomp, String plcaof)
    {
        File arch = new File(archivo);
        File borrador = new File("borrador.txt");
        
        try (BufferedReader br = new BufferedReader(new FileReader(arch));
             BufferedWriter bw = new BufferedWriter(new FileWriter(borrador))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                if (!(linea.contains(correocomp)&&linea.contains(plcaof))) {
                    bw.write(linea);
                    bw.newLine();
                    
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(BufferedReader br2 = new BufferedReader(new FileReader(borrador));
             BufferedWriter bw2 = new BufferedWriter(new FileWriter(arch,false))){
            
            String linea2;
            while ((linea2=br2.readLine())!=null){
                bw2.write(linea2);
                bw2.newLine();
            }
            
            
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        borrador.delete();
        
    }
}
