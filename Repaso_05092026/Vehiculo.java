public class Vehiculo {

    String marca;
    String modelo;
    String color;
    int cantidadPuertas;
    int kilometraje;

    public Vehiculo(String marca, String modelo, String color, int cantidadPuertas, int kilometraje) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.cantidadPuertas = cantidadPuertas;
        this.kilometraje = kilometraje;
    }

    @Override
    public String toString() {
        return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", cantidadPuertas="
                + cantidadPuertas + ", kilometraje=" + kilometraje + "]";
    }
}
