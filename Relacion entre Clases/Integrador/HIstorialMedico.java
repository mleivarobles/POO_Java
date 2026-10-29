import java.util.ArrayList;

public class HIstorialMedico {

    private String pacienteRut;
    private ArrayList<RegistroConsulta> registros; // Composicion
    
    public HIstorialMedico(String pacienteRut) {
        this.pacienteRut = pacienteRut;
        this.registros = new ArrayList<>();
    }
    
    //Composicion: el historial CREA el registro internamente
    public void agregarConsulta(String fecha, String diagnostico, String tratamiento, String nombreDoctor){
        RegistroConsulta registro = new RegistroConsulta(fecha, diagnostico, tratamiento, nombreDoctor);
        registros.add(registro);
    }

    public void mostrar(){
        System.out.println("Historial de Consultas: " + registros.size());
        for (RegistroConsulta r : registros) {
            r.mostrar();
        }
    }

     public RegistroConsulta getUltimaConsulta() {
        return registros.get(registros.size() - 1); //devuelvo la ultima consulta
    }
}
