public class MainPersona {

    public static void main(String[] args) {
    
        Alumno alumno = new Alumno("Pedro Soto", "Ing. Informatica");
        Profesor profesor = new Profesor("Fabian Rojas", "POO");

        Persona[] personas = {alumno, profesor};

        for(Persona p: personas){
            System.out.println(p);
        }
    }
}
