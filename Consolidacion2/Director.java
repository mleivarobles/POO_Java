/*
 * Director extiende Persona.
 * Representa al director de una pelicula.
 * ASOCIACION: un Director puede existir sin ninguna Pelicula asignada,
 * y una Pelicula referencia a su Director sin ser su "duena".
 */
public class Director extends Persona {

    private String nacionalidad;

    public Director(String nombre, String rut, String nacionalidad) {
        super(nombre, rut);
        setNacionalidad(nacionalidad);
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        if (nacionalidad == null || nacionalidad.isBlank()) {
            throw new IllegalArgumentException("La nacionalidad no puede estar vacia");
        }
        this.nacionalidad = nacionalidad;
    }

    @Override
    public void mostrarRol() {
        System.out.println(getNombre() + " es DIRECTOR de cine (" + nacionalidad + ")");
    }

    @Override
    public String toString() {
        return getNombre() + " (" + nacionalidad + ")";
    }
}
