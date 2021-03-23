import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO implements interfaceFuncionarioDAO {
    private Connection conn;
    public FuncionarioDAO(){
        this.conn = ConnectionFactory.getConnection();
    }

    @Override
    public void delete(int index){
        String sql = "delete from funcionarios " +
                "where id = (?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1,index);

            stmt.execute();
            stmt.close();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void adiciona(Funcionario funcionario) {
        String sql = "insert into funcionarios " +
                "(cpf,matricula,nome,email,telefone)" +
                " values (?,?,?,?,?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = conn.prepareStatement(sql);

            // seta os valores
            stmt.setString(1,funcionario.getCpf());
            stmt.setString(2,funcionario.getMatricula());
            stmt.setString(3,funcionario.getNome());
            stmt.setString(4,funcionario.getEmail());
            stmt.setString(5,funcionario.getTelefone());

            // executa
            stmt.execute();
            stmt.close();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void adicionarList(List<Funcionario> funcionarios){
        String sql = "insert into funcionarios " +
                "(cpf,matricula,nome,email,telefone)" +
                " values (?,?,?,?,?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = conn.prepareStatement(sql);
            for(Funcionario funcionario : funcionarios) {

                // seta os valores
                stmt.setString(1, funcionario.getCpf());
                stmt.setString(2, funcionario.getMatricula());
                stmt.setString(3, funcionario.getNome());
                stmt.setString(4, funcionario.getEmail());
                stmt.setString(5, funcionario.getTelefone());

                // executa
                stmt.execute();
            }
            stmt.close();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Funcionario funcionario) {
        String sql = "update funcionarios " +
                "set cpf = (?)," +
                "matricula = (?)," +
                "nome = (?)," +
                "email = (?)," +
                "telefone = (?)" +
                " where id = (?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = conn.prepareStatement(sql);

            // seta os valores
            stmt.setString(1,funcionario.getCpf());
            stmt.setString(2,funcionario.getMatricula());
            stmt.setString(3,funcionario.getNome());
            stmt.setString(4,funcionario.getEmail());
            stmt.setString(5,funcionario.getTelefone());
            stmt.setInt(6,funcionario.getId());

            // executa
            stmt.execute();
            stmt.close();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Funcionario> getLista() {
        try {
            List<Funcionario> funcionarios = new ArrayList<Funcionario>();
            PreparedStatement stmt = this.conn.prepareStatement("select * from funcionarios");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setMatricula(rs.getString("matricula"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setTelefone(rs.getString("telefone"));

                // adicionando o objeto à lista
                funcionarios.add(funcionario);
            }
            rs.close();
            stmt.close();
            return funcionarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Funcionario> getPage(int page) {
        try {
            int tamanhoPagina = 3;
            List<Funcionario> funcionarios = new ArrayList<Funcionario>();
            PreparedStatement stmt = this.conn.prepareStatement("select * from funcionarios limit ? offset ?");
            stmt.setInt(1,tamanhoPagina);
            stmt.setInt(2,tamanhoPagina * page -  tamanhoPagina);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setMatricula(rs.getString("matricula"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setTelefone(rs.getString("telefone"));

                // adicionando o objeto à lista
                funcionarios.add(funcionario);
            }
            rs.close();
            stmt.close();
            return funcionarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
