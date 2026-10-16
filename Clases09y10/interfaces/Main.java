public class Main {
    public static void main(String[] args) {
        
        NotificacionEmail notEmail = new NotificacionEmail("alumno@umc.cl");
        NotificacionSMS notSMS = new NotificacionSMS("+562392823232");
        NotificacionSMS notSMS2 = new NotificacionSMS("+56945352523");

        Notificable[] canales = { notEmail, notSMS}; //array de canales de comunicación

        for (Notificable canal : canales) {
            if(canal.estaDisponible()){
                canal.enviarNotificacion("Nota publicada en Moodle!!!");
            }
        }
        notSMS2.enviarNotificacion("\nRecordatorio de clases");
        notSMS2.registrarEvento("Notificaciones enviada el 15/10/2026 21:34");
    }
}