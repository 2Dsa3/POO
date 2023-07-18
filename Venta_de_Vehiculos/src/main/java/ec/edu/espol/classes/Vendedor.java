package ec.edu.espol.classes;

import java.util.Properties;
import java.util.Scanner;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Vendedor extends Usuario{
    private Vehiculo vehiculo;


    public Vendedor(String nombres, String apellidos, String organizacion, String correo, String clave,Vehiculo vehiculo) {
        super(nombres,apellidos,organizacion,correo,clave);
        this.vehiculo = vehiculo;
    }
    
    public Vendedor(String nombres, String apellidos, String organizacion, String correo, String clave){
        super(nombres,apellidos,organizacion,correo,clave);
    }
    
    @Override
    public void enviarCorreo(String destinatario, String asunto, String cuerpo) {
        System.out.println("Confirme su clave:");
        Scanner sc= new Scanner(System.in);
        String claveconf= sc.nextLine();
        
        boolean b=Utilitaria.verificarClaveVendedor(this.getCorreo(), claveconf);
        while (!b){
            System.out.println("Clave incorrecta");
            System.out.println("Ingrese nuevamente:");
            claveconf= sc.nextLine();
        }
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put("mail.smtp.user", this.getCorreo());
        props.put("mail.smtp.clave", claveconf);    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google
        
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        
        try {
        message.setFrom(new InternetAddress(this.getCorreo()));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrían añadir varios de la misma manera
        message.setSubject(asunto);
        message.setText(cuerpo);
        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", this.getCorreo(), this.getClave());
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        }
        catch (MessagingException me) {
            me.printStackTrace();   //Si se produce un error
        }
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "Correo:" + this.getCorreo() + "| Apellidos: "+ this.getApellidos() + "| Nombres: "+ this.getNombres()+ "}";
    }

public static Vendedor getVendedor(String correo)
{
    for (Vendedor v: Utilitaria.vendedorRegistrados)
    {
        if(correo.equals(v.getCorreo()))
            return v;
    }
    return null;
}

}
