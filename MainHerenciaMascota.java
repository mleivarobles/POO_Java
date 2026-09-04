public class MainHerenciaMascota {
    public static void main(String[] args) {
        Perro p1 = new Perro("Vilu", 4, "Quiltra");
        Perro p2 = new Perro("Doncan", 13, " Pastor Alemán");
        Gato g1 = new Gato("Asrael", 8, false);
        Gato g2 = new Gato("Micifus", 3, true);

        //Se imprime la información de cada instancia
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(g1);

        //Se llama a cada metodo de las instancias (objetos)
        p1.comer();
        p1.ladrar();
        p2.ladrar();
        g1.comer();
        g1.ronronear();
        g2.ronronear();
    }
}
