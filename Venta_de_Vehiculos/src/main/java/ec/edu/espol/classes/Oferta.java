public class Oferta{
    private Vendedor vendedor;
    private Comprador comprador;
    private Vehiculo vehiculo;
    private double monto; 


    public Oferta(Vendedor vendedor, Comprador comprador, Vehiculo vehiculo, double monto) {
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.vehiculo = vehiculo;
        this.monto = monto;
    }


    public Vendedor getVendedor() {
        return this.vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Comprador getComprador() {
        return this.comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public double getMonto() {
        return this.monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    



    
}