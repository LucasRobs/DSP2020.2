package dao;

import entity.Dependente;
import java.util.List;

public interface InterfaceDependenteDAO {
    void delete(Long index);

    void adiciona(Dependente dependente);

    void adicionarList(List<Dependente> dependetes);

    void update(Dependente dependente);

    List<Dependente> getLista();

    List<Dependente> getPage(int page);
}
