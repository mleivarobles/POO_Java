public class RegistroConsulta {
    
    private String fecha;
    private String diagnostico;
    private String tratamiento;
    private String nombreDoctor;

    public RegistroConsulta(String fecha, String diagnostico, String tratamiento, String nombreDoctor) {
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.nombreDoctor = nombreDoctor;
    }

    public void mostrar(){
        System.out.println("fecha: " + fecha + "doctor: " +nombreDoctor);
        System.out.println("Diagnóstico:  " + diagnostico);
        System.out.println("Tratamiento:  " + tratamiento);
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }
}
