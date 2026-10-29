public class Seccion {

    private String codigo;
    private  Alumno[] alumnos;
    private  int cantidad; //cantidad de alumnos de la sección

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
        System.out.println("Seccion: " + codigo);
        for (int i = 0; i < cantidad; i++) {
            System.out.println(alumnos[i].getNombre());
        }
    } 
}