public class Main {
    public static void main(String[] args) {
        
        Reproducible[] lista = new Reproducible[3]; // un objeto lista que va contener distintos objetos que pueden ser reproducidos

        lista[0] = new Cancion("Gracias a la vida", "VP", 312);
        lista[1] = new Podcast("Caso 63", 1, 245);
        lista[2] = new Cancion("Paramar", "LP", 223);

        for (Reproducible pista : lista) {
            pista.reproducir();
        }
    }
}
