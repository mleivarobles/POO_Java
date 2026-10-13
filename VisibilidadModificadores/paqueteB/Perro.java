package paqueteB;

import paqueteA.Animal;

public class Perro extends Animal {

    public void ladrar(){
        //System.out.println(secreto); no puedo acceder
        //System.out.println(apodo); no puedo acceder
        System.out.println(edad);
        System.out.println(nombre);
    }
}
