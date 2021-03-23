package dao;

import entity.Funcionario;

import java.util.List;

public interface Questão5 {
    List<String> getAllDependentesByChar(String letra);
    List<Funcionario> getListaFuncionarios();
}
