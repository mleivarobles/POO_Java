public class NotificacionSMS implements Notificable, Registrable {

    private String telefono;
    private boolean activo;
    
    public NotificacionSMS(String telefono) {
        this.telefono = telefono;
        this.activo = true;
    }

    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Enviando SMS a " + telefono + ": " + mensaje);
        
    }

    @Override
    public boolean estaDisponible() {
        return activo;
    }

    @Override
    public void registrarEvento(String evento) {
        System.out.println("LOG SMS "+ telefono + " | " + evento); 
        //registrar fecha, ahora, usuario, acción.  
    }
}
