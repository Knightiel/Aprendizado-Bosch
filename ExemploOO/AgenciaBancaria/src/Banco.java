import java.util.ArrayList;

public class Banco {
    
    public ArrayList<Conta> listaDeContas = new ArrayList<Conta>();

    public void adicionarConta(Conta c){
        this.listaDeContas.add(c);
    }

    public String listarContas(){
        String contas = "Os dados das contas são\n";

        for(Conta c : this.listaDeContas){
            contas += "\nAgência: " + c.agencia+ "\nConta: " + c.numero +"\nSaldo: " + c.saldo + "\nNome do titular: " + c.titular.nome + 
                "\nCPF do titular: " + c.titular.cpf + "\nData de nascimento do titular: " + c.titular.dataNascimento + "\n";
        }

        return contas;
    }

    public Conta encontrarConta(int agencia, int numero) {
        for(Conta c : this.listaDeContas){
            if(c.agencia == agencia && c.numero == numero){
                return c;
            }
        }
        return null;
    }
}
