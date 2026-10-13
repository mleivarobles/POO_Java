public class MainNotificacion {

    public static void main(String[] args) {
        
        NotificacionEmail notAlumno = new NotificacionEmail("alumno@umc.cl");
        NotificacionSMS notSMS = new NotificacionSMS("+568271323232");
        NotificacionWhatassap notWhatassap = new NotificacionWhatassap("+568271323232");

        Notificable[] canales = {notAlumno, notSMS, notWhatassap};

        for (Notificable canal : canales) {
            if(canal.estaDisponible()){
                canal.enviarNotificacion("La nota de la solemne1 está publica en el portal");
            }
        }

        NotificacionSMS sms = new NotificacionSMS("+569231231277");
        sms.enviarNotificacion("Recordatorio de clases en un 1 hora más");
        sms.registrarEvento("Notificacion enviada el 12.10.2026 23:23 horas");
    }
}
