public class Gato extends MascotaClase {

    boolean esInterior; //true o false

    public Gato(String nombre, int edad, boolean esInterior) {
        super(nombre, edad);
        this.esInterior = esInterior;
    }

    void ronronear(){
        System.out.println(nombre + " dice: Miuaaaaaa!!!");
    }

    @Override
    public String toString() {
        //return "Gato [esInterior=" + esInterior + "]";
        if(esInterior == true){
            return super.toString() + " | y es de interior";
        }else{
            return super.toString() + " | y es calle";
        }
    }
}
