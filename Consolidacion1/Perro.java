public class Perro {
    
    int id;
    String nombre;
    int edad;
    String raza;

    public Perro() {
    }

    public Perro(String nombre) {
        this.nombre = nombre;
    }

    public Perro(String nombre, int edad, String raza) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
    }

    public static void main(String[] args) {
        Perro p1 = new Perro(); //creo el p1, es un objeto
        Perro p2 = new Perro("Cachupin");
        Perro p3 = new Perro("Cachupin", 5, "Quiltro");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        p1.nombre = "Cholo";
        p1.edad = 3;
        System.out.println(p1);
    }
}
