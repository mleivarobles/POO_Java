package paqueteB;

import paqueteA.Animal;

public class Cuidador {
    
    public void cuidar(Animal a){

        //System.out.println(a.secreto); //error
        //System.out.println(a.apodo); //error
        //System.out.println(a.edad); //error
        System.out.println(a.nombre); //solo el atributo publico está disponible
    }
}
