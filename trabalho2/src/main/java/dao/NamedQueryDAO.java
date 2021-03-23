package dao;

import entity.Dependente;
import entity.Funcionario;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NamedQueryDAO implements  Questão5{
    @Override
    public List<String> getAllDependentesByChar(String letra) {
        ArrayList<String> nomes = new ArrayList<>();
        EntityManager em = JPAUtil.getEntityManager();
        List<Dependente> dependentes = em.createNamedQuery("Dependente.findLetra", Dependente.class)
                .setParameter("letra",letra+"%")
                .getResultList();
        for(Dependente dependente: dependentes){
            nomes.add(dependente.getFuncionario().getNome()+" -> "+ dependente.getNome());
        }
        JPAUtil.closeEntityManager();

        return nomes;
    }

    @Override
    public List<Funcionario> getListaFuncionarios() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Funcionario> funcionarios = em.createNamedQuery("Funcionario.findAll", Funcionario.class)
                .getResultList();
        JPAUtil.closeEntityManager();
        return funcionarios;
    }
}
