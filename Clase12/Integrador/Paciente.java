public class Paciente {

    private String rut;
    private String nombre;
    private Doctor docTratante; //asociación
    private HistorialMedico historial; //Composició
    // n
    public Paciente(String rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
        this.historial = new HistorialMedico(rut);
    }

    public void asignarDoctor(Doctor doctor){
        this.docTratante = doctor;
    }

    public void registrarConsulta(String fecha, String diagnostico){
        historial.agregarConsulta(fecha, diagnostico);
    }

    public void solicitarReceta(){
        RegistroConsulta ultima = historial.getUltimaConsulta();
        Recetario.generarReceta(nombre, docTratante.getNombre(), ultima.getDiagnostico());
    }

    public void mostrar(){
        System.out.println("Paciente:" + nombre);
        System.out.println("Doctor: " + docTratante.getNombre());
        historial.mostrar();
    }
}
