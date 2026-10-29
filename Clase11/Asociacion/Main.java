public class Main {
    public static void main(String[] args) {
        Profesor juan = new Profesor("Juan Garcia", "BBDD");
        Profesor ana = new Profesor("Ana Torres", "POO");
        Profesor luis = new Profesor("Luis Gana", "Proyectos");

        Alumno sofia = new Alumno("Sofia Perez");

        sofia.inscribirRamo(ana);
        sofia.inscribirRamo(juan);
        sofia.inscribirRamo(luis);
        sofia.mostrarProfesores();
    }
}