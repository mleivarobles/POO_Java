public class NotificacionEmail implements Notificable {

    private String correo;
    private boolean activo;

    public NotificacionEmail(String correo) {
        this.correo = correo;
        this.activo = true;
    }

    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Enviando email a " + correo +": " + mensaje);
    }

    @Override
    public boolean estaDisponible() {
        return activo;
    }
}
