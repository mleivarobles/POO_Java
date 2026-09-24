
public class CuentaBancaria {

    public String titular; //cualquiera pieder ese dato y modificar
    private double saldo; //solo los objetos de la propia clase puede acceder
    protected String tipoCuenta; //las clases, las hiijas y dentro del mismo paquete
    String sucursal; // todas las clases del paquete acceden

    public CuentaBancaria(String titular, double saldo, String tipoCuenta, String sucursal) {
        this.titular = titular;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
        this.sucursal = sucursal;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto){
        if(monto < 0){
            System.out.println("No se puede abonar montos negativos: " + monto);
            return;
        }
        this.saldo += monto; //this.saldo = this.saldo + monto
        System.out.println("Se ha depositado: " + monto);
    }

    public void retirar(double monto){     
        if(monto > 0 && monto <= this.saldo){
            this.saldo -= monto;
            System.out.println("Se ha retirado " + monto);
        }else if(monto > this.saldo){
            System.out.println("No tienes fondos para el retiro " + monto);
        }
    }

    @Override
    public String toString() {
        return "CuentaBancaria [titular=" + titular + ", saldo=" + saldo + ", tipoCuenta=" + tipoCuenta + ", sucursal="
                + sucursal + "]";
    }
}