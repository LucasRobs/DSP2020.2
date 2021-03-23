package dao;

import entity.Dependente;
import entity.Funcionario;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JPQLDAO implements Questão5{
    private Connection conn;
    public JPQLDAO(){
        this.conn = ConnectionFactory.getConnection();
    }

    public List<String> getAllDependentesByChar(String letra){
        try {
            List<String> nomes = new ArrayList<>();
            PreparedStatement stmt = this.conn.prepareStatement("select * from dependente where nome like (?)");
            stmt.setString(1, letra+"%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PreparedStatement stmt2 = this.conn.prepareStatement("select * from funcionario where id = (?)");
                stmt2.setInt(1, rs.getInt("funcionario_id"));
                ResultSet rs2 = stmt2.executeQuery();
                rs2.next();
                nomes.add(rs2.getString("nome")+" -> "+rs.getString("nome"));
            }
            rs.close();
            stmt.close();
            return nomes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };


    public List<Funcionario> getListaFuncionarios(){
        try {
            List<Funcionario> funcionarios = new ArrayList<Funcionario>();
            PreparedStatement stmt = this.conn.prepareStatement("select * from funcionario");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getLong("id"));
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
    };
}
