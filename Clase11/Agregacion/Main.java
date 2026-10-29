public class Main {
    
    public static void main(String[] args) {
        
    Alumno maria = new Alumno("Maria Lopez", "232323");
    Alumno carlos = new Alumno("Carlos Muñoz","2323");

    Seccion poo = new Seccion("POO-001", 15);
    poo.matricular(carlos);
    poo.matricular(maria);

    Seccion bd = new Seccion("BBDD-001", 20);
    bd.matricular(carlos);

    bd.listarAlumnos();
    poo.listarAlumnos();

    poo = null; //se cierra la sección.

    System.out.println(maria.getNombre() + " sigue siendo alumna");
    System.out.println(carlos.getNombre() + " sigue en BBDD-001");

    }
}
