import java.time.LocalDateTime;

/*
 * MODULO 6 - COMPOSICION con Sala
 * MODULO 4 - Encapsulamiento: constructor package-private
 *
 * Un Boleto solo existe como parte de una Sala (la sala lo crea al vender).
 * El constructor es package-private: nadie fuera del paquete puede hacer
 * new Boleto(...), asegurando que solo Sala los crea.
 *
 * Atributos final: una vez emitido, el boleto no cambia.
 */
public class Boleto {

    private static int correlativo = 0;

    private final int numero;
    private final String nombrePelicula;
    private final int numeroSala;
    private final int asiento;
    private final double precioFinal;
    private final String descuentoAplicado;
    private final LocalDateTime fechaEmision;

    // Constructor package-private: solo Sala (mismo paquete) puede crear boletos
    Boleto(String nombrePelicula, int numeroSala, int asiento,
           double precioFinal, String descuentoAplicado) {
        correlativo++;
        this.numero = correlativo;
        this.nombrePelicula = nombrePelicula;
        this.numeroSala = numeroSala;
        this.asiento = asiento;
        this.precioFinal = precioFinal;
        this.descuentoAplicado = descuentoAplicado;
        this.fechaEmision = LocalDateTime.now();
    }

    // Solo getters — un boleto emitido es inmutable
    public int getNumero() {
        return numero;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public int getAsiento() {
        return asiento;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public String getDescuentoAplicado() {
        return descuentoAplicado;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    @Override
    public String toString() {
        return "=== BOLETO #" + numero + " ===\n"
                + "Pelicula: " + nombrePelicula + "\n"
                + "Sala: " + numeroSala + " | Asiento: " + asiento + "\n"
                + "Precio: $" + precioFinal + " (" + descuentoAplicado + ")\n"
                + "Emitido: " + fechaEmision.toLocalDate();
    }
}
