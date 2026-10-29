public class Main {

    public static void main(String[] args) {
        Alumno maria = new Alumno("María López", "20.123.456-7");
        Alumno carlos = new Alumno("Carlos Muñoz", "20.789.012-3");


        Seccion poo = new Seccion("POO-001", 30);
        poo.matricular(maria);
        poo.matricular(carlos);

        Seccion bd = new Seccion("BD-001", 20);
        bd.matricular(carlos);

        bd.listarAlumnos();
        poo.listarAlumnos();

        poo = null; //se cierra la sección

        System.out.println(maria.getNombre() + " sigue siendo alumnma");
        System.out.println(carlos.getNombre() + " sigue en BD-001");
    }
    
}
