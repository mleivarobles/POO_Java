package paqueteB;

import paqueteA.Animal;

public class Cuidador {

    public void cuidar(Animal a){
        //System.out.println(a.secreto); no tengo acceso
        //System.out.println(a.apodo); no tengo acceso
        //System.out.println(a.edad); no tengo acceso
        System.out.println(a.nombre);
    }
}
