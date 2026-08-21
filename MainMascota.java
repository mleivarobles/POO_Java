public class MainMascota {

    public static void main(String[] args) {
        
        Mascota masc1 = new Mascota(); // creando una objeto en particular (instancia) de la clase Mascotas
        //definiendo atributos
        masc1.nombre = "Doncan";
        masc1.raza = "Quiltro";
        masc1.edad = 15;

        Mascota masc2 = new Mascota();
        masc2.nombre = "Cholita";
        masc1.edad = 5;

        Mascota Vilumilla = new Mascota("Vilu", "Dogo", 34); //

        masc1.mostrarInfo();
        masc2.mostrarInfo();
        Vilumilla.mostrarInfo();
    }
}