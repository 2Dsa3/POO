package ec.edu.espol.classes;


public class Vendedor extends Usuario{
    private Vehiculo vehiculo;


    public Vendedor(String nombres, String apellidos, String organizacion, String correo, String clave,Vehiculo vehiculo) {
        super(nombres,apellidos,organizacion,correo,clave);
        this.vehiculo = vehiculo;
    }
    
    public Vendedor(String nombres, String apellidos, String organizacion, String correo, String clave){
        super(nombres,apellidos,organizacion,correo,clave);
    }

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
