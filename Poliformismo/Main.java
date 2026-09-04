public class Main {
    
    public static void main(String[] args) {
        
        EmpleadoFijo ef1 = new EmpleadoFijo("Juan", "132-2", 150, 850000);
        EmpleadoFijo ef2 = new EmpleadoFijo("Daniel", "888-4", 50, 350000);
        EmpleadoComision ec1 = new EmpleadoComision("Sofia", "187-2", 50, 500000, 500000, 1.3);
        EmpleadoFreelance efr1 = new EmpleadoFreelance("Ana", "287-2", 40, 18000);

        Empleado[] sueldos = {ef1, ec1, efr1, ef2, ec1}; //array de 3 objetos

        double total = 0;

        /*
        for (Empleado e : sueldos) {
            System.out.println(e); //toString()
            total = total + e.calcularSueldo(); //
            //total += e.calcularSueldo();
        }
        */

        for (int i = 0; i < sueldos.length; i++) {
            System.out.println(sueldos[i]);
            total += sueldos[i].calcularSueldo();
        }

        System.out.println("Total sueldo: " + total);
    }
}
