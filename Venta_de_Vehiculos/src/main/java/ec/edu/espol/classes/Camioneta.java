        package ec.edu.espol.classes;


public class Camioneta extends Vehiculo{
    private String vidrio;
    private String transmision;
    private String traccion;

    public Camioneta(String placa, String marca, String modelo, int año, double recorrido, String color, String tipoCombustible, double precio, String vidrio, String transmision, String traccion)
    {
        super(placa, modelo, marca, año, recorrido, color, tipoCombustible, precio);
        this.vidrio = vidrio;
        this.transmision = transmision;
        this.traccion = traccion;

    }

}