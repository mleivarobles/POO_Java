import java.util.ArrayList;

public class HistorialMedico {
    
    private String rutPaciente;
    private ArrayList<RegistroConsulta> registros; //composicion

    public HistorialMedico(String rutPaciente) {
        this.rutPaciente = rutPaciente;
        this.registros = new ArrayList<>(); //listado de registro de consulta
    }

    public void agregarConsulta(String fecha, String dianostico){
        RegistroConsulta consulta = new RegistroConsulta(fecha, dianostico);
        registros.add(consulta);
    }

    public void mostrar(){
        System.out.println("Historial de consultas: " + registros.size());
        for (RegistroConsulta r : registros) {
            r.mostrar();
        }
    }

    public RegistroConsulta getUltimaConsulta(){
        return registros.get(registros.size() - 1); // 3 (0, 1, 2)
    }
}
