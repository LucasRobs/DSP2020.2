import java.util.List;

public interface interfaceFuncionarioDAO {
    void delete(int index);

    void adiciona(Funcionario funcionario);

    void adicionarList(List<Funcionario> funcionarios);

    void update(Funcionario funcionario);

    List<Funcionario> getLista();

    List<Funcionario> getPage(int page);
}
