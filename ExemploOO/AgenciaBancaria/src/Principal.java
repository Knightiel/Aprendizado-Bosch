public class Principal {
    public static void main(String[] args) {
        Banco b = new Banco(); //porque queremos apenas um objeto banco
        int opcao;
        int agencia = 0;
        int numero = 0;
        Conta conta;
        do{
            opcao = EntradaSaida.escolherOpcaoMenu();
            switch (opcao) {
                case 1:
                    Conta c = new Conta(); //sempre precisamos criar um novo objeto conta
                    c.agencia = EntradaSaida.solicitarDadoConta("a agência");
                    c.numero = EntradaSaida.solicitarDadoConta("o número");
                    Pessoa p = new Pessoa();
                    p.cpf = EntradaSaida.solicitarCpf();
                    p.dataNascimento = EntradaSaida.solicitarDadoTitular("a data de nascimento");
                    p.nome = EntradaSaida.solicitarDadoTitular("o nome completo");
                    c.titular = p;

                    // System.out.println(c.agencia);
                    // System.out.println(c.numero);
                    // System.out.println(c.titular.cpf);
                    // System.out.println(c.titular.nome);
                    // System.out.println(c.titular.dataNascimento);
                    // System.out.println(c.saldo);

                    b.adicionarConta(c); //adicionando o objeto conta na lista  de contas

                break;
                case 2:
                    if(!b.listaDeContas.isEmpty()){
                        EntradaSaida.mostrarContas(b.listarContas());  
                    }else{
                        EntradaSaida.mostrarAlerta("Nenhuma conta foi cadastrada até o momento. ");   
                    }
                break;

                case 3:
                    agencia=EntradaSaida.solicitarDadoConta("a agência");
                    numero = EntradaSaida.solicitarDadoConta("o número");
                    conta = b.encontrarConta(agencia, numero);
                    if(conta != null){
                        conta.depositar(EntradaSaida.solicitarValorOperacao("depósito"));
                    }else{
                        EntradaSaida.mostrarAlerta("A agência e número digitados não foram encontrados!");
                    }  
                break;

                case 4:
                    agencia=EntradaSaida.solicitarDadoConta("a agência");
                    numero = EntradaSaida.solicitarDadoConta("o número");
                    conta = b.encontrarConta(agencia, numero);
                    if(conta != null){
                        conta.sacar(EntradaSaida.solicitarValorOperacao("saque"));
                    }else{
                        EntradaSaida.mostrarAlerta("A agência e número digitados não foram encontrados!");
                    }
                break;
            }
        }while(opcao != 5);
    }
}
