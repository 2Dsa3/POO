package ec.edu.espol.classes;


public class Auto extends Vehiculo{
    private String vidrio;
    private String transmision;

    public Auto(String placa, String marca, String modelo, int año, double recorrido, String color, String tipoCombustible, double precio, String vidrio, String transmision)
    {
        super(placa, modelo, marca, año, recorrido, color, tipoCombustible, precio);
        this.vidrio = vidrio;
        this.transmision = transmision;

    }

}