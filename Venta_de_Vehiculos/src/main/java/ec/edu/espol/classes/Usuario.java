package ec.edu.espol.classes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public abstract class Usuario {

    protected String nombres;
    protected String apellidos;
    protected String organizacion;
    protected String correo;
    protected String clave;


    public Usuario(String nombres, String apellidos, String organizacion, String correo, String clave) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.organizacion = organizacion;
        this.correo = correo;
        this.clave = clave;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getOrganizacion() {
        return this.organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    

    public static String generarHash(String contrasena) {
    try {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(contrasena.getBytes());
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
        return null;
    }
}

    public static String[] nextUsuario(Scanner sc, String s){
    String[] atributos = new String[5];

    System.out.println("Ingresa nombres del usuario:");
    String nombres = sc.nextLine();
    atributos[0] = nombres;

    System.out.println("Ingresa apellidos del usuario:");
    String apellidos = sc.nextLine();
    atributos[1] = apellidos;

    System.out.println("Ingresa organización del usuario: ");
    String organizacion = sc.nextLine();
    atributos[2] = organizacion;

    System.out.println("Ingresa correo del usuario: ");
    String correo;
    if (s.equals("V"))
    {
    do
    {
    correo = sc.nextLine();
    } while(Utilitaria.vendedorRegistrados.contains(correo));
    }
    else
    {
    {
    correo = sc.nextLine();
    } while(Utilitaria.compradorRegistrados.contains(correo));
    }
    atributos[3] = correo;

    System.out.println("Ingresa clave del comprador");
    String clave = sc.nextLine();
    atributos[4] = clave; 

    return atributos;
    }
    
    public void enviarCorreo(String destinatario, String asunto, String cuerpo){
        System.out.println("enviarcorreo");
    }
    
}
