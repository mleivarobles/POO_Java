
public class MascotaClase {

    String nombre;
    int edad;

    //Constructor
    public MascotaClase(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    void comer(){
        System.out.println(nombre + " está comiendo!!!");
    }

    @Override
    public String toString() {
        return nombre + " | " + edad + " años";
    }  
}