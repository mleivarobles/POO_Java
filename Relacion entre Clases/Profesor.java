public class Profesor {
    
    private String nombre;
    private String asignatura;

    public Profesor(String nombre, String asignatura) {
        this.nombre = nombre;
        this.asignatura = asignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAsignatura() {
        return asignatura;
    }
}
