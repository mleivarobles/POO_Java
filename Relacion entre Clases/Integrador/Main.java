// ============================================
// Main.java
// ============================================
public class Main {
    public static void main(String[] args) {

        // --- Doctores existen por sí solos ---
        Doctor doc1 = new Doctor("11111111-1", "María González", "Medicina General");
        Doctor doc2 = new Doctor("22222222-2", "Roberto Silva", "Traumatología");
        Doctor doc3 = new Doctor("33333333-3", "Carmen Rojas", "Pediatría");

        // --- AGREGACIÓN: hospital recibe doctores (no los crea) ---
        Hospital hospital = new Hospital("Hospital UMC");
        hospital.contratarDoctor(doc1);
        hospital.contratarDoctor(doc2);
        hospital.contratarDoctor(doc3);

        System.out.println();
        hospital.mostrarEquipo();

        System.out.println();

        // --- Pacientes ---
        Paciente pac1 = new Paciente("44444444-4", "Juan Pérez", 35);
        Paciente pac2 = new Paciente("55555555-5", "Laura Muñoz", 28);

        // --- ASOCIACIÓN: paciente conoce a su doctor ---
        pac1.asignarDoctor(doc1);
        pac2.asignarDoctor(doc2);

        // --- COMPOSICIÓN: el historial crea registros internamente ---
        pac1.registrarConsulta("2026-10-20", "Gripe estacional", "Paracetamol cada 8 hrs");
        pac1.registrarConsulta("2026-10-28", "Control post-gripe", "Alta médica");

        pac2.registrarConsulta("2026-10-25", "Esguince tobillo", "Reposo 2 semanas + hielo");

        System.out.println();
        pac1.mostrarInfo();

        System.out.println();
        pac2.mostrarInfo();

        // --- DEPENDENCIA: usa Recetario solo en este instante ---
        System.out.println();
        pac2.solicitarReceta();
    }
}