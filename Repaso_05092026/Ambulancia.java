public class Ambulancia extends Vehiculo{

    int numeroCamillas;
    boolean tieneBotiquin; //true o false
    boolean tieneSirena;

    public Ambulancia(String marca, String modelo, String color, int cantidadPuertas, int kilometraje,
            int numeroCamillas, boolean tieneBotiquin, boolean tieneSirena) {
        super(marca, modelo, color, cantidadPuertas, kilometraje); //constructor clase padre
        
        this.numeroCamillas = numeroCamillas;
        this.tieneBotiquin = tieneBotiquin;
        this.tieneSirena = tieneSirena;
    }

    @Override
    public String toString() {
        return "Ambulancia [marca=" + marca + ", numeroCamillas=" + numeroCamillas + ", modelo=" + modelo + ", color="
                + color + ", tieneBotiquin=" + tieneBotiquin + ", cantidadPuertas=" + cantidadPuertas + ", tieneSirena="
                + tieneSirena + "]";
    }
}
