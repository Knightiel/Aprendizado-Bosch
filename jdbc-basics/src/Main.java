import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Olá Mundo!");

        EstadoDAO dao = new EstadoDAO();
        ClienteDAO clientedao = new ClienteDAO();

        //Adicionar estado
        Estado novoEstado = new Estado();
        novoEstado.setSigla("SP");
        novoEstado.setDescricao("São Paulo");
        dao.adicionarEstado(novoEstado);

        //Listar estados
        for(Estado estado: dao.listarEstados()){
            System.out.println(estado.getSigla()+ " - " + estado.getDescricao());
        }

        //Atualizar estado
        novoEstado.setDescricao("São Paulo - Atualizado");
        dao.atualizaEstado(novoEstado);

        //Deletar estado
        dao.deletarEstado(novoEstado.getSigla());

        //Adiciona cliente
        Cliente clienteNovo = new Cliente("00000000003", "Chaves Aguero", "Rua mimir", "201", "Vila Nova",
                "Recife", "PR", "84628123", 23, 1, "2000-09-29");
        clientedao.adicionarCliente(clienteNovo);

        //Listar clientes
        int i=0;
        for(Cliente cliente: clientedao.listarClientes()){
            i++;
            System.out.println("\n\nCliente " + i + ":");
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Endereço 1: " + cliente.getEndereco1());
            System.out.println("Endereço 2: " + cliente.getEndereco2());
            System.out.println("Bairro: " + cliente.getBairro());
            System.out.println("Cidade: " + cliente.getCidade());
            System.out.println("Estado: " + cliente.getEstado());
            System.out.println("CEP: " + cliente.getCep());
            System.out.println("Idade: " + cliente.getIdade());
            System.out.println("Primeira Compra: " + cliente.getPrimeiraCompra());
            System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
        }

        //Atualizar cliente
        clienteNovo.setNome("Ceasar Bros");
        clientedao.atualizaCliente(clienteNovo);

        //Deletar cliente
        clientedao.deletarCliente(clienteNovo.getCpf());

//        try(Connection connection = ConexaoDB.getConnection()) {
//            System.out.println("Conectou");;
//        }catch (SQLException e){
//            System.out.println("Erro ao conectar: " + e.getMessage());
//        }
    }
}