/*
 * Cliente extiende Persona.
 * Agrega atributos propios del dominio: email y tipo de cliente
 * (estudiante, tercera edad, general) que se usa para descuentos.
 */
public class Cliente extends Persona {

    private String email;
    private String tipoCliente; // "estudiante", "tercera_edad", "general"

    public Cliente(String nombre, String rut, String email, String tipoCliente) {
        super(nombre, rut);
        setEmail(email);
        setTipoCliente(tipoCliente);
    }

    // --- Getters y setters con validacion ---

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email invalido");
        }
        this.email = email;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        if (tipoCliente == null || tipoCliente.isBlank()) {
            throw new IllegalArgumentException("El tipo de cliente no puede estar vacio");
        }
        this.tipoCliente = tipoCliente;
    }

    @Override
    public void mostrarRol() {
        System.out.println(getNombre() + " es CLIENTE del cine (" + tipoCliente + ")");
    }
}
