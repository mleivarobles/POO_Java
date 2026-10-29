public class Alumno {

    private String nombre;
    private Profesor[] profesores; //alumo puede tener varios profesores
    private  int cantidad;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.profesores = new Profesor[6]; //alumno puede tener como maximo 6 profesores.
        this.cantidad = 0;
    }

    public void inscribirRamo(Profesor p){
        if(cantidad < profesores.length){
            profesores[cantidad] = p;
            cantidad++;
        }
    }

    public void mostrarProfesores(){
        System.out.println("Listado de profesores de " + nombre);
        for (int i = 0; i < cantidad; i++) {
            System.out.println(profesores[i].getNombre() + " - " + profesores[i].getAsignatura());
        }
    }
}
