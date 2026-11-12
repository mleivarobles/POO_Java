public class Main {
    public static void main(String[] args) {
        Reproducible[] lista = new Reproducible[4];

        lista[0] = new Cancion("Gracias a la Vida", "Violeta Parra", 312);
        lista[1] = new Podcast("Caso 63", 1, 1800);
        lista[2] = new Cancion("El Baile de los que Sobran", "Los Prisioneros", 245);
        lista[3] = new Video("Tutorial Java POO", "Programación UMC", 900);

        for (Reproducible pista : lista) {
            pista.reproducir();
        }
    }
}
