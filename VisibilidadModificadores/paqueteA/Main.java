package paqueteA;

import paqueteB.Perro;
import paqueteB.Cuidador;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("Dentro de la clase Animal");
        Animal animal = new Animal();
        animal.estoyDentro();

        System.out.println("\nMismo paquete(A) no subclase");
        Veterinario vet = new Veterinario();
        vet.examinar(animal);

        System.out.println("\nOtro paquete(B) pero subclase");
        Perro perro = new Perro();
        perro.ladrar();

        System.out.println("\nOtro paquete(B) no subclase");
        Cuidador cuidador = new Cuidador();
        cuidador.cuidar(animal);
    }
}
