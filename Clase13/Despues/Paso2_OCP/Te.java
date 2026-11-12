package Paso2_OCP;

// OCP: otro tipo nuevo, sin tocar Cafe ni Bebida
public class Te extends Bebida {
    private boolean conMiel;

    public Te(boolean conMiel) {
        super("Té", 900);
        this.conMiel = conMiel;
    }

    @Override
    public double calcularPrecio() {
        return conMiel ? getPrecioBase() + 200 : getPrecioBase();
    }
}