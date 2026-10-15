public class MainPersona {

    public static void main(String[] args) {
        
        Alumno alumno1 = new Alumno("Pedro Soto", "Ing. Informática");
        Profesor profe1 = new Profesor("Fabian Rojas", "POO");
        Profesor profe2 = new Profesor("Luis Fuentes", "Democracia");

        Persona[] personas = {alumno1, profe1, profe2}; //array de Personas 

        for (Persona p : personas) {
            System.out.println(p); //cada elemento del arras de Personas     
        }
    }
}
