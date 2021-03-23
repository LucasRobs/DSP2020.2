package dao;

import entity.Dependente;
import entity.Funcionario;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class SQLNativasDAO implements Questão5 {
    public List<String> getAllDependentesByChar(String letraa){

        ArrayList<String> nomes = new ArrayList<>();
        EntityManager em = JPAUtil.getEntityManager();
        List<Dependente> dependentes = em.createNativeQuery("select * from Dependente c where c.nome like :letra",Dependente.class)
                .setParameter("letra", letraa+"%")
                .getResultList();

        for(Dependente dependente: dependentes){
            nomes.add(dependente.getFuncionario().getNome()+" -> "+dependente.getNome());
        }
        return  nomes;
    };
    public List<Funcionario> getListaFuncionarios(){
        EntityManager em = JPAUtil.getEntityManager();
        List<Funcionario> funcionario = em.createNativeQuery("select * from funcionario",Funcionario.class).getResultList();
        return  funcionario;
    };
}
