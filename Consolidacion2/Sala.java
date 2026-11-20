import java.util.ArrayList;
import java.util.List;

/*
 * MODULO 6 - COMPOSICION: Sala crea Boletos internamente (no se reciben de fuera)
 * MODULO 6 - DEPENDENCIA: usa CalculadoraPrecio como variable local
 * MODULO 7 - SRP: Sala gestiona asientos y vende boletos para su funcion
 * MODULO 4 - Encapsulamiento: no expone la lista de boletos, solo cantidades
 */
public class Sala {

    private final int numero;
    private final int capacidad;
    private Proyectable funcionActual; // usa interfaz, no Pelicula directa (DIP)
    private final List<Boleto> boletosVendidos; // COMPOSICION: boletos nacen aqui
    private final boolean[] asientosOcupados;

    public Sala(int numero, int capacidad) {
        if (numero <= 0) {
            throw new IllegalArgumentException("El numero de sala debe ser mayor a 0");
        }
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0");
        }
        this.numero = numero;
        this.capacidad = capacidad;
        this.boletosVendidos = new ArrayList<>();
        this.asientosOcupados = new boolean[capacidad];
    }

    // Asignar una funcion (pelicula) a esta sala
    public void asignarFuncion(Proyectable funcion) {
        if (funcion == null) {
            throw new IllegalArgumentException("La funcion no puede ser nula");
        }
        this.funcionActual = funcion;
        // Limpiar asientos para la nueva funcion
        for (int i = 0; i < asientosOcupados.length; i++) {
            asientosOcupados[i] = false;
        }
        boletosVendidos.clear();
        System.out.println("Sala " + numero + " ahora proyecta: " + funcion.getTitulo());
    }

    /*
     * Vender un boleto — aqui se ven COMPOSICION y DEPENDENCIA juntas:
     * - COMPOSICION: el Boleto se crea aqui (new Boleto), no se recibe de fuera
     * - DEPENDENCIA: CalculadoraPrecio es variable local, se usa y se descarta
     */
    public Boleto venderBoleto(int asiento, Vendible item, EstrategiaDescuento estrategia) {
        if (funcionActual == null) {
            throw new IllegalStateException("No hay funcion asignada a la sala " + numero);
        }
        if (asiento < 1 || asiento > capacidad) {
            throw new IllegalArgumentException("Asiento invalido. Rango: 1 a " + capacidad);
        }
        if (asientosOcupados[asiento - 1]) {
            throw new IllegalStateException("El asiento " + asiento + " ya esta ocupado");
        }

        // DEPENDENCIA: se crea, se usa, se descarta — no es atributo
        CalculadoraPrecio calculadora = new CalculadoraPrecio();
        double precioFinal = calculadora.calcular(item.getPrecioBase(), estrategia);

        // COMPOSICION: el Boleto nace aqui, dentro de Sala
        Boleto boleto = new Boleto(
                funcionActual.getTitulo(),
                this.numero,
                asiento,
                precioFinal,
                estrategia.getDescripcion()
        );

        asientosOcupados[asiento - 1] = true;
        boletosVendidos.add(boleto);

        return boleto;
    }

    // --- Getters: no se expone la lista, solo informacion controlada ---

    public int getNumero() {
        return numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getAsientosDisponibles() {
        int disponibles = 0;
        for (boolean ocupado : asientosOcupados) {
            if (!ocupado) {
                disponibles++;
            }
        }
        return disponibles;
    }

    public int getBoletosVendidos() {
        return boletosVendidos.size(); // cantidad, no la lista
    }

    public Proyectable getFuncionActual() {
        return funcionActual;
    }

    @Override
    public String toString() {
        String funcion = (funcionActual != null) ? funcionActual.getTitulo() : "Sin funcion";
        return "Sala " + numero + " (cap: " + capacidad
                + ", disponibles: " + getAsientosDisponibles()
                + ") - " + funcion;
    }
}
