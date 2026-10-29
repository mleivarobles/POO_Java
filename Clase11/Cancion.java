public class Cancion implements Reproducible {

    private String titulo;
    private String artista;
    private int segundos;

    public Cancion(String titulo, String artista, int segundos) {
        this.titulo = titulo;
        this.artista = artista;
        this.segundos = segundos;
    }

    @Override
    public int duracion() {
        return segundos;
    }

    @Override
    public void pausar() {
        System.out.println("Cancion pausada:" + titulo);
        
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo cancion: " + titulo + " autoe: " + artista);
    }
}
