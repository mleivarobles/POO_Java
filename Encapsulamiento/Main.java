public class Main {

    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Jhon Weed", 100000, "vista", "Santiago");

        //PUBLIC
        System.out.println(cuenta.titular);
        cuenta.titular = "Jack Sparrow";
        System.out.println(cuenta.titular);

        //PRIVATE
        System.out.println(cuenta.getSaldo());
        cuenta.depositar(30000); //abono de $30.000
        System.out.println(cuenta.getSaldo());

        cuenta.depositar(-50000); //abono -50000
        System.out.println(cuenta.getSaldo());

        cuenta.retirar(75000); //retire $75.000
        System.out.println(cuenta.getSaldo());

        cuenta.retirar(75000); //retire $75.000
        System.out.println(cuenta.getSaldo());

        //Protected
        System.out.println(cuenta.tipoCuenta); //dentro del mismo paquete

        //DEFAULT
        System.out.println(cuenta.sucursal);

        System.out.println(cuenta);
    }
}
