/*
 * MODULO 4 - Encapsulamiento y visibilidad
 * MODULO 5 - Abstraccion
 *
 * Persona es abstracta: en el dominio del cine no existe una "persona generica",
 * siempre es un Cliente o un Director. abstract impide instanciarla directamente
 * y obliga a cada subclase a implementar mostrarRol().
 */
public abstract class Persona {

    // Atributos privados (encapsulamiento)
    private String nombre;
    private final String rut; // final: el rut no cambia despues de asignarse

    // Constructor parametrizado: rut es final, debe asignarse aqui
    public Persona(String nombre, String rut) {
        setNombre(nombre);
        if (rut == null || rut.isBlank()) {
            throw new IllegalArgumentException("El rut no puede estar vacio");
        }
        this.rut = rut;
    }

    // --- Getters y setters ---

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        this.nombre = nombre;
    }

    public String getRut() {
        return rut; // sin setter: es final
    }

    // Metodo abstracto: cada subclase define como muestra su rol
    public abstract void mostrarRol();

    @Override
    public String toString() {
        return nombre + " (RUT: " + rut + ")";
    }
}
