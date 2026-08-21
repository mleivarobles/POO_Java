public class Mascota {

    String nombre;
    String raza;
    int edad; //float, double

    // ctrl + . (al mismo tiempo)
    
    void comer(){
        System.out.println(nombre + " está comiendo");
    }
    
    public Mascota() {
    }

    public Mascota(String nombre) {
        this.nombre = nombre;
    }

    //Constructores
    public Mascota(String nombre, String raza, int edad) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
    }

    void mostrarInfo(){
        System.out.println(nombre + " es de raza " + raza + " y tiene " + edad + " años de edad");
    }
}