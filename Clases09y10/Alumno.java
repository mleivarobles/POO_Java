public class Alumno extends Persona {

    private String carrera;

    public Alumno(String nombre, String carrera) {
        super(nombre);
        this.carrera = carrera;
    }

    @Override
    public String getRol() {
        return "Alumno de " + carrera;
    }
}
