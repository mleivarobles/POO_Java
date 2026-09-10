public abstract class Figura {

    String color;
    int lados;

    //constructor
    public Figura(String color) {
        this.color = color;
    }

    public Figura(String color, int lados) {
        this.color = color;
        this.lados = lados;
    }

    //metodo concreto
    @Override
    public String toString() {
        return "Figura de color:" + color;
    }

    //metodo abastracto
    public abstract double calcularArea();    
}
