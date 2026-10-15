
import paqueteA.Animal;
import paqueteA.Veterinario;
import paqueteB.Cuidador;
//import paqueteB.*;
import paqueteB.Perro;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        System.err.println(animal);
        
        animal.nombre = "Quiltro"; // Main quien va a cambiar el dato a la clase Animal
        animal.setSecreto("Cambio mi secreto"); //Animal quien provee un metodo para acceder a un atributo

        //Probando acceso desde dentro de la clase
        System.out.println("\n1.- Estoy en la misma clase animal");
        animal.probarDesdeAdentro();

        System.out.println("\n2.- Mismo paquete no subclase");
        Veterinario vet = new Veterinario();
        vet.examinar(animal);

        System.out.println("\n3.- Otro paquete pero sublclase");
        Perro perro = new Perro();
        perro.ladrar();

        System.out.println("\n4.- Otro paquete no subclase");
        Cuidador cuidador = new Cuidador();
        cuidador.cuidar(animal);
    }
}
