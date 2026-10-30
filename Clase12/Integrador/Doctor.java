public class Doctor {

    private String rut;
    private String nombre;
    private String especialidad;

    public Doctor(String rut, String nombre, String especialidad) {
        this.rut = rut;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
