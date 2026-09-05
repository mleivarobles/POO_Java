public class Hospital {

    String nombre;
    String ciudad;
    int cantidadCamas;

    public Hospital(String nombre, String ciudad, int cantidadPiezas) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.cantidadCamas = cantidadPiezas;
    }

    @Override
    public String toString() {
        return "Hospital [nombre=" + nombre + ", ciudad=" + ciudad + ", cantidadPiezas=" + cantidadCamas + "]";
    }
}