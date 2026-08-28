public class Perro extends MascotaClase {

    String raza;

    public Perro(String nombre, int edad, String raza) {
        super(nombre, edad);    // atributos heredados de mascota
        this.raza = raza;       // atributo propio de Clase Perro
    }

    void ladrar(){
        System.out.println(nombre + " dice: Guau guau");
    }

    @Override
    public String toString() {
        // return "Perro [nombre=" + nombre + ", raza=" + raza + ", edad=" + edad + "]";
        return super.toString() + " | " + raza;
    }
}
