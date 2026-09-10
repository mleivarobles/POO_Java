public class Rectangulo extends  Figura{

    double ancho;
    double largo;

    public Rectangulo(String color, double ancho, double largo) {
        super(color); //?? que hace super?
        this.ancho = ancho;
        this.largo = largo;
    }
    @Override
    public double calcularArea() {
        return ancho * largo;
    }
    @Override
    public String toString() {
        return super.toString() + " | Rectangulo: " + ancho +"x" + largo; // 6x4
    }
}
