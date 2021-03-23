package dao;

import entity.Funcionario;
import java.util.List;

public interface InterfaceFuncionarioDAO {
    void delete(Long index);

    void adiciona(Funcionario funcionario);

    void adicionarList(List<Funcionario> funcionarios);

    void update(Funcionario funcionario);

    List<Funcionario> getLista();

    List<Funcionario> getPage(int page);

    long getIdFuncionario(Funcionario funcionario);
}
