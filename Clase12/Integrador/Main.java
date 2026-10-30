public class Main {
    public static void main(String[] args) {

        Hospital hospitalUMC = new Hospital("Hospital Miguel de Cervantes");
        
        Doctor doc1 = new Doctor("44534534-2", "Sofia Perez", "Pediatra");
        Doctor doc2 = new Doctor("23232323-1", "Marco Aurelio", "Geriatra");
        Doctor doc3 = new Doctor("77787878-2", "Pedro Solis", "General");

        //Agregacion: Hospital recibe doctores no los crea
        hospitalUMC.contratarDoctor(doc1);
        hospitalUMC.contratarDoctor(doc2);
        hospitalUMC.contratarDoctor(doc3);

        hospitalUMC.listarDoctores();

        Paciente pac1 = new Paciente("43434343", "Juan Perez");
        Paciente pac2 = new Paciente("23232", "Luis Morales");

        pac1.asignarDoctor(doc1); //asociación pac1 -> doc1
        pac2.asignarDoctor(doc2);
        pac2.asignarDoctor(doc3);

        pac1.registrarConsulta("2026-10-20", "Fiebre");
        pac2.registrarConsulta("2026-09-24", "Esguince");

        System.out.println();
        pac1.mostrar();
        
        System.out.println();
        pac2.mostrar();
    }
    
}
