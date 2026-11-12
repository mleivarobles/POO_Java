public class Video implements Reproducible {
    private String titulo;
    private String canal;
    private int segundos;

    public Video(String titulo, String canal, int segundos) {
        this.titulo = titulo;
        this.canal = canal;
        this.segundos = segundos;
    }

    public void reproducir() {
        System.out.println("Video: " + titulo + " [" + canal + "]");
    }

    public void pausar() {
        System.out.println("Video pausado");
    }

    public int duracion() {
        return segundos;
    }
}