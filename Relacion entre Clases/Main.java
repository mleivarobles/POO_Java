public class Main {
    public static void main(String[] args) {
        
        Profesor juan = new Profesor("Juan Gana", "BDD");
        Profesor ana = new Profesor("Ana Torres", "POO");

        Alumno sofia = new Alumno("Sofia Pérez");

        sofia.inscribirRamo(juan);
        sofia.inscribirRamo(ana);
        sofia.mostrarProfesores();

        sofia = null; //se retira de la carrera

        System.out.println("Profe: " + ana.getAsignatura() + " sigue haciendo clases");

    }
    
}
