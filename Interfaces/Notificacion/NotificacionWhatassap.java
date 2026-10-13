public class NotificacionWhatassap implements Notificable, Registrable{

    private String telefono;
    private boolean activo;

    public NotificacionWhatassap(String telefono) {
        this.telefono = telefono;
        this.activo = true;
    }

    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Enviar Whatsapp al telefono: " + telefono + ": " + mensaje); 
    }

    @Override
    public boolean estaDisponible() {
        return activo;
    }
    @Override
    public void registrarEvento(String evento) {
        System.out.println("Log[Whataspp]:" + telefono + ": " + evento);      
    }    
}