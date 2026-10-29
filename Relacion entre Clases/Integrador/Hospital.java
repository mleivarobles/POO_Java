import java.util.ArrayList;

public class Hospital {
    
    private String nombre;
    private ArrayList<Doctor> doctores; //agregacion: tiene doctores

    public Hospital(String nombre) {
        this.nombre = nombre;
        this.doctores = new ArrayList<>();
    }

    public void contratarDoctor(Doctor doctor){
        doctores.add(doctor);
        System.out.println("Doctor: " + doctor.getNombre());
    }

    public void mostrarEquipo(){

        System.out.println("Equipo medio: " + nombre);
        for (Doctor d: doctores) {
            System.out.println(d.getNombre() + "-" + d.getEspecialidad());
        }

    }
}
