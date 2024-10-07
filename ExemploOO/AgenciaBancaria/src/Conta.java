public class Conta {
    
    public int agencia;
    public int numero;
    public Pessoa titular;
    public double saldo;

    public double depositar(double valor){
        return this.saldo += valor;
    }

    public void sacar(double valor) {
        this.saldo -= valor;
    }
    
}
