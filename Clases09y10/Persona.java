public abstract class Persona {
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre; //que podria validar acá?? que no venga vacio
    }

    public abstract String getRol(); //las clases hijas deben implementarlo

    @Override
    public String toString() {
        return nombre + " es " + getRol();
    }
}
