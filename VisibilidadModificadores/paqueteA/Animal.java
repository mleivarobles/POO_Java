package paqueteA;

public class Animal {

    private String secreto = "solo lo veo yo"; //private
    String apodo = "se ve desde el mismo paquete"; //default
    protected int edad = 5;
    public String nombre = "todos me ven";

    public void estoyDentro(){
        System.out.println(secreto);
        System.out.println(apodo);
        System.out.println(edad);
        System.out.println(nombre);
    }
}
