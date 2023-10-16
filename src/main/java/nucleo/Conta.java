
package nucleo;


public class Conta {
    private int numero;
    private Cliente cliente;
    private double saldo;
    private double limite;

    public Conta(int numero, Cliente cliente, double limite) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0.0; // Inicialmente, a conta inicia com saldo zero.
        this.limite = limite;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo - valor >= -limite) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido.");
            return false;
        }
    }

    public boolean transferir(Conta destino, double valor) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            System.out.println("Transferência de R$ " + valor + " realizada com sucesso para a Conta " + destino.getNumero() + ".");
            return true;
        } else {
            System.out.println("Transferência não realizada.");
            return false;
        }
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }
}
