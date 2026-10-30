public class RegistroConsulta {

    private String fecha;
    private String diagnostico;

    public RegistroConsulta(String fecha, String diagnostico) {
        this.fecha = fecha;
        this.diagnostico = diagnostico;
    }

    

    public void mostrar(){
        System.out.println("Fecha:" + fecha);
        System.out.println("Diagnostico: " + diagnostico);
    }

    public String getDiagnostico() {
        return diagnostico;
    }
}
