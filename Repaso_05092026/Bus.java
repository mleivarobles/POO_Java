public class Bus extends Vehiculo{

    int cantidadAsientos;

    public Bus(String marca, String modelo, String color, int cantidadPuertas, int kilometraje, int cantidadAsientos) {
        super(marca, modelo, color, cantidadPuertas, kilometraje);
        this.cantidadAsientos = cantidadAsientos;
    }

    @Override
    public String toString() {
        return "Bus [cantidadAsientos=" + cantidadAsientos + "]";
    }
}
