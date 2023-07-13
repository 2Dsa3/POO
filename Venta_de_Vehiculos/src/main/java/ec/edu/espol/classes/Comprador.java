package ec.edu.espol.classes;
import java.util.Scanner;
import java.util.ArrayList;

public class Comprador extends Usuario {

    public Comprador(String nombres, String apellidos, String organizacion, String correo, String clave) {
        super(nombres,apellidos,organizacion,correo,clave);
    }

    public static Comprador nextComprador(Scanner sc){
    String[] atributos = Usuario.nextUsuario(sc, "C");
    String nombres = atributos[0];
    String apellidos = atributos[1];
    String organizacion = atributos[2];
    String correo = atributos[3];
    String clave = atributos[4];

    return new Comprador(nombres,apellidos,organizacion,correo,clave);

    }
}
