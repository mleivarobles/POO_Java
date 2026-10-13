package paqueteA;

public class Veterinario {
    
    public void examinar(Animal a){
        //System.out.println(a.secreto); //no puedo acceder.
        System.out.println(a.apodo);
        System.out.println(a.edad);
        System.out.println(a.nombre);
    }
}
