import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public void adicionarCliente(Cliente cliente){
        String sql = "INSERT INTO tbcliente (cpf, nome, endereco1, endereco2, bairro, cidade, estado, cep," +
                " idade, primeira_compra, data_nascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConexaoDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){

            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEndereco1());
            stmt.setString(4, cliente.getEndereco2());
            stmt.setString(5, cliente.getBairro());
            stmt.setString(6, cliente.getCidade());
            stmt.setString(7, cliente.getEstado());
            stmt.setString(8, cliente.getCep());
            stmt.setInt(9, cliente.getIdade());
            stmt.setInt(10, cliente.getPrimeiraCompra());
            stmt.setString(11, cliente.getDataNascimento());

            stmt.executeUpdate();
            connection.close();
            stmt.close();
        }catch (SQLException e){
            System.out.println("Erro ao adicionar cliente: " + e.getMessage());
        }
    }

    public List<Cliente> listarClientes(){
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM tbcliente";

        try (Connection connection = ConexaoDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente(
                (rs.getString("cpf")),
                (rs.getString("nome")),
                (rs.getString("endereco1")),
                (rs.getString("endereco2")),
                (rs.getString("bairro")),
                (rs.getString("cidade")),
                (rs.getString("estado")),
                (rs.getString("cep")),
                (rs.getInt("idade")),
                (rs.getInt("primeira_compra")),
                (rs.getString("data_nascimento"))
                );
                clientes.add(cliente);

            }

        }catch (SQLException e){
            System.out.println("Erro ao mostrar estados: " + e.getMessage());
            return null;
        }
        return clientes;
    }

    public boolean atualizaCliente(Cliente cliente){
        String sql = "UPDATE tbcliente SET nome = ? WHERE cpf = ?";

        try {
            Connection connection = ConexaoDB.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.executeUpdate();
            connection.close();
            stmt.close();
            return true;
        }catch (SQLException e){
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        }
        return false;
    }

    public void deletarCliente(String cpf){
        String sql = "DELETE FROM tbcliente WHERE cpf = ?";

        try {
            Connection connection = ConexaoDB.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.executeUpdate();
            connection.close();
            stmt.close();
            System.out.println("\nSucesso ao deletar cliente!");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar cliente: " + e.getMessage());
        }
    }
}
