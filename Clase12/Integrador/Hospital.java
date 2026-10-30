import java.util.ArrayList;

public class Hospital {

    private String nombre;
    private ArrayList<Doctor> doctores; //agregación hospital tiene doctores
    
    public Hospital(String nombre) {
        this.nombre = nombre;
        this.doctores = new ArrayList<>(); //iniciializar mi listao de doctores, tengo cero doctor
    }

    public void contratarDoctor(Doctor doctor){
        doctores.add(doctor);
        System.out.println("Se ha contratado al doctor: " + doctor.getNombre());
    }

    public void listarDoctores(){
        System.out.println("Equipo medico del hospital " + nombre);
        for (Doctor d : doctores){
            System.out.println(d.getNombre() + "-" + d.getEspecialidad());
        }
    }
}