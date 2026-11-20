/*
 * MODULO 5 - Interfaces
 *
 * Contrato para cualquier contenido que pueda proyectarse en una sala.
 * Hoy solo Pelicula lo implementa, pero manana podria ser un Documental
 * o un EventoEnVivo sin modificar Sala (OCP).
 */
public interface Proyectable {

    String getTitulo();

    int getDuracionMinutos();

    String getClasificacion();

    boolean esAptaParaMenores();
}
