public class Paciente {

    private String rut;
    private String nombre;
    private int edad;
    private Doctor doctorTratante;  //Asociacion: conoce su doctor
    private  HIstorialMedico historial; //Composicion: crea su historial
    
    public Paciente(String rut, String nombre, int edad) {
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
        this.historial = new HIstorialMedico(rut); // lo crea internamente
    }

    //asociacion: se le asigna un doctor no lo crea
    public void asignarDoctor(Doctor doctor){
        this.doctorTratante = doctor;
    }

        // COMPOSICIÓN: delega al historial que CREE el registro
    public void registrarConsulta(String fecha, String diagnostico, 
                                  String tratamiento) {
        historial.agregarConsulta(fecha, diagnostico, tratamiento,
                                  doctorTratante.getNombre());
    }

        // DEPENDENCIA: usa Recetario solo en este momento
    public void solicitarReceta() {
        RegistroConsulta ultima = historial.getUltimaConsulta();
        Recetario.generarReceta(
            nombre,
            doctorTratante.getNombre(),
            ultima.getDiagnostico(),
            ultima.getTratamiento()
        );
    }

    public void mostrarInfo(){
        System.out.println("Paciente: " + nombre);
        System.out.println("Doctor: " + doctorTratante.getNombre());
        historial.mostrar();
    }
}
