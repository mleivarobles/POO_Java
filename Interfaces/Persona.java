public abstract class Persona {

    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    //metodo abstracto
    public abstract String getRol();

    @Override
    public String toString() {
        return nombre + " es " + getRol();
    }
}
