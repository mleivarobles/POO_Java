public class Seccion {

    private String codigo;
    private Alumno[] alumnos; // definiendo una variable 
    private int cantidad; // cantidad de alumnos de la seccion

    public Seccion(String codigo, int capacidad) {
        this.codigo = codigo;
        this.alumnos = new Alumno[capacidad];
        this.cantidad = 0;
    }

    public void matricular(Alumno a){
        if(cantidad < alumnos.length){
            alumnos[cantidad] = a;
            cantidad++;
        }
    }

    public void listarAlumnos(){
        System.out.println("Sección: " + codigo);
        for (int i = 0; i < cantidad; i++) {
            System.out.println(alumnos[i].getNombre());
        }
    }
}
