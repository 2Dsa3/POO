package ec.edu.espol.classes;


public class Vendedor extends Usuario{
    private Vehiculo vehiculo;
    private String placaVehiculo;


    public Vendedor(String nombres, String apellidos, String organizacion, String correo, String clave,Vehiculo vehiculo, String placaVehiculo) {
        super(nombres,apellidos,organizacion,correo,clave);
        this.vehiculo = vehiculo;
        this.placaVehiculo = placaVehiculo;
    }

}
