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
//    public void aceptarOferta()
//    {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Correo: ");
//        String correo = sc.nextLine();
//        
//        if(verificarCorreo(correo))
//        {
//            System.out.println("Contraseña: ");
//            String clave = sc.nextLine();
//            String hash = Usuario.generarHash(clave);
//            
//            if(verificarClave(correo, clave)
//            {
//                
//
//            }
//            
//        }
//    }

}
