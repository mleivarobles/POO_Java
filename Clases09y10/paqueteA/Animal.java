package paqueteA;

public class Animal {

    private String secreto = "Solo lo veo yo";
    String apodo = "Visible del mismo paquete"; //default
    protected int edad = 5;
    public String nombre = "todos me ven"; //publico

    public void probarDesdeAdentro(){
        System.out.println(secreto); 
        System.out.println(apodo);
        System.out.println(edad);
        System.out.println(nombre);
    }

    public void setSecreto(String secreto) {
        this.secreto = secreto;
    }
}