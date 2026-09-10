public class Main {

    public static void main(String[] args) {

        Circulo c1 = new Circulo("Rojo", 5);
        Rectangulo r1 = new Rectangulo("Azul", 4, 6);

        Figura[] figuras = {c1, r1}; // figuras[0]=c1, figuras[1]=r1

        for (Figura f : figuras) {
            System.out.println(f + " | Area: " + f.calcularArea()); //f.toString();
        }
    }     
}
