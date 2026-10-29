public class Podcast implements Reproducible{

    private String nombre;
    private  int episodio;
    private  int segundos;
    
    public Podcast(String nombre, int episodio, int segundos) {
        this.nombre = nombre;
        this.episodio = episodio;
        this.segundos = segundos;
    }

    @Override
    public int duracion() {
        return segundos;
    }

    @Override
    public void pausar() {
        System.out.println("Podcast pausado en episodio: " + episodio);
        
    }

    @Override
    public void reproducir() {
        System.out.println("Podcast: " + nombre + " EP: " + episodio);
    }
}
