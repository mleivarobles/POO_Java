import java.util.ArrayList;
import java.util.List;

/*
 * MODULO 6 - COMPOSICION con Sala (las salas nacen con el cine)
 * MODULO 6 - AGREGACION con Pelicula (las peliculas vienen de fuera)
 * MODULO 7 - SRP: Cine solo coordina salas y catalogo
 * MODULO 7 - DIP: trabaja con Proyectable, no con Pelicula directamente
 * MODULO 4 - Encapsulamiento: listas privadas, solo expone cantidades
 */
public class Cine {

    private final String nombre;
    private final List<Sala> salas;               // COMPOSICION: se crean aqui
    private final List<Proyectable> catalogo;      // AGREGACION: vienen de fuera

    public Cine(String nombre, int cantidadSalas, int capacidadPorSala) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del cine no puede estar vacio");
        }
        this.nombre = nombre;
        this.salas = new ArrayList<>();
        this.catalogo = new ArrayList<>();

        // COMPOSICION: las salas se crean dentro del constructor del Cine
        for (int i = 1; i <= cantidadSalas; i++) {
            salas.add(new Sala(i, capacidadPorSala));
        }
        System.out.println("Cine \"" + nombre + "\" creado con " + cantidadSalas
                + " salas de " + capacidadPorSala + " asientos cada una.");
    }

    // AGREGACION: las peliculas se agregan desde fuera — existen independientemente
    public void agregarAlCatalogo(Proyectable contenido) {
        if (contenido == null) {
            throw new IllegalArgumentException("El contenido no puede ser nulo");
        }
        catalogo.add(contenido);
        System.out.println("Agregada al catalogo: " + contenido.getTitulo());
    }

    // Asignar una pelicula del catalogo a una sala
    public void programarFuncion(int numeroSala, Proyectable contenido) {
        Sala sala = buscarSala(numeroSala);
        if (!catalogo.contains(contenido)) {
            throw new IllegalArgumentException(contenido.getTitulo() + " no esta en el catalogo");
        }
        sala.asignarFuncion(contenido);
    }

    // Vender boleto en una sala especifica
    public Boleto venderBoleto(int numeroSala, int asiento,
                               Vendible item, EstrategiaDescuento estrategia) {
        Sala sala = buscarSala(numeroSala);
        return sala.venderBoleto(asiento, item, estrategia);
    }

    // --- Metodos de consulta (no exponen listas) ---

    public String getNombre() {
        return nombre;
    }

    public int getCantidadSalas() {
        return salas.size();
    }

    public int getCantidadPeliculas() {
        return catalogo.size();
    }

    public void mostrarCartelera() {
        System.out.println("\n=== CARTELERA " + nombre.toUpperCase() + " ===");
        for (Sala sala : salas) {
            System.out.println("  " + sala);
        }
    }

    // Buscar sala por numero (uso interno)
    private Sala buscarSala(int numero) {
        for (Sala sala : salas) {
            if (sala.getNumero() == numero) {
                return sala;
            }
        }
        throw new IllegalArgumentException("No existe la sala " + numero);
    }
}
