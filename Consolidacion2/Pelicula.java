/*
 * MODULO 5 - Implementa dos interfaces: Proyectable y Vendible
 * MODULO 6 - ASOCIACION con Director (ambos existen independientemente)
 * MODULO 4 - Encapsulamiento: atributos privados, validaciones en setters
 */
public class Pelicula implements Proyectable, Vendible {

    private String titulo;
    private int duracionMinutos;
    private String genero;
    private String clasificacion; // "TE", "TE+7", "14+", "18+"
    private double precioBase;
    private Director director; // ASOCIACION: Pelicula conoce a su Director, ambos existen por separado

    public Pelicula(String titulo, int duracionMinutos, String genero,
                    String clasificacion, double precioBase, Director director) {
        setTitulo(titulo);
        setDuracionMinutos(duracionMinutos);
        setGenero(genero);
        setClasificacion(clasificacion);
        setPrecioBase(precioBase);
        setDirector(director);
    }

    // --- Interfaz Proyectable ---

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    @Override
    public String getClasificacion() {
        return clasificacion;
    }

    @Override
    public boolean esAptaParaMenores() {
        return "TE".equals(clasificacion) || "TE+7".equals(clasificacion);
    }

    // --- Interfaz Vendible ---

    @Override
    public double getPrecioBase() {
        return precioBase;
    }

    // --- Setters con validacion ---

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("El titulo no puede estar vacio");
        }
        this.titulo = titulo;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        if (duracionMinutos <= 0) {
            throw new IllegalArgumentException("La duracion debe ser mayor a 0");
        }
        this.duracionMinutos = duracionMinutos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if (genero == null || genero.isBlank()) {
            throw new IllegalArgumentException("El genero no puede estar vacio");
        }
        this.genero = genero;
    }

    public void setClasificacion(String clasificacion) {
        if (clasificacion == null || clasificacion.isBlank()) {
            throw new IllegalArgumentException("La clasificacion no puede estar vacia");
        }
        this.clasificacion = clasificacion;
    }

    public void setPrecioBase(double precioBase) {
        if (precioBase < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precioBase = precioBase;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        if (director == null) {
            throw new IllegalArgumentException("La pelicula debe tener un director");
        }
        this.director = director;
    }

    @Override
    public String toString() {
        return titulo + " (" + genero + ", " + duracionMinutos + " min, " + clasificacion
                + ") - Director: " + director;
    }
}
