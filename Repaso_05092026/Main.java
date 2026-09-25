public class Main {

    public static void main(String[] args) {
        
        Hospital h1 = new Hospital("Calvo Mackena", "Santiago", 45);
        int edad;

        Bus b1 = new Bus("Volvo", "V1678", "amarillo", 3, 4500, 28);
        Bus b2 = new Bus("Scania", "T232", "azul-marino", 4, 10000, 45);
        
        System.out.println(h1);
        System.out.println(b1);
        System.out.println(b2);
    }
    
}
