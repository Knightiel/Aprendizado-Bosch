import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO {
    public boolean adicionarEstado(Estado estado){
        String sql = "INSERT INTO tbestado (sigla, descricao) VALUES (?, ?)";

        try (Connection connection = ConexaoDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){

            stmt.setString(1, estado.getSigla());
            stmt.setString(2, estado.getDescricao());

            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch (SQLException e){
            System.out.println("Erro ao adicionar estado: " + e.getMessage());
            return false;
        }
    }

    public List<Estado> listarEstados(){
        List<Estado> estados = new ArrayList<>();
        String sql = "SELECT * FROM tbestado";

        try (Connection connection = ConexaoDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Estado estado = new Estado();
                estado.setSigla(rs.getString("sigla"));
                estado.setDescricao(rs.getString("descricao"));
                estados.add(estado);
            }

        }catch (SQLException e){
            System.out.println("Erro ao mostrar estados: " + e.getMessage());
            return null;
        }
        return estados;
    }

    public boolean atualizaEstado(Estado estado){
        String sql = "UPDATE tbestado SET descricao = ? WHERE sigla = ?";

        try {
            Connection connection = ConexaoDB.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, estado.getDescricao());
            stmt.setString(2, estado.getSigla());
            stmt.executeUpdate();
            connection.close();
            stmt.close();
            return true;
        }catch (SQLException e){
            System.out.println("Erro ao atualizar estado: " + e.getMessage());
        }
        return false;
    }

    public void deletarEstado(String sigla){
        String sql = "DELETE FROM tbestado WHERE sigla = ?";

        try {
            Connection connection = ConexaoDB.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, sigla);
            stmt.executeUpdate();
            connection.close();
            stmt.close();
            System.out.println("Sucesso ao deletar estado!");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar estado: " + e.getMessage());
        }
    }
}
