public class Profesor extends Persona {

    private String asignatura;

    public Profesor(String nombre, String asignatura) {
        super(nombre);
        this.asignatura = asignatura;
    }

    @Override
    public String getRol() {
        return "Profesor de " + asignatura;
    }
}
