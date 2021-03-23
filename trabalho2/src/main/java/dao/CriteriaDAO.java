package dao;

import entity.Dependente;
import entity.Funcionario;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CriteriaDAO implements Questão5{
    public List<String> getAllDependentesByChar(String letra){
        List<String> lista = new ArrayList<>();
        List<Dependente> dependenteList = null;
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            JPAUtil.beginTransaction();
            CriteriaBuilder cb=entityManager.getCriteriaBuilder();
            AbstractQuery<Dependente> cq1=cb.createQuery(Dependente.class);
            Root<Dependente> dependant=cq1.from(Dependente.class);
            cq1.where(cb.like(dependant.get("nome"), letra+"%"));
            CriteriaQuery<Dependente> select1 = ((CriteriaQuery<Dependente>) cq1).select(dependant);
            TypedQuery<Dependente> tq1 = entityManager.createQuery(select1);
            dependenteList = tq1.getResultList();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        for (Dependente dependente : dependenteList) {
            lista.add(dependente.getFuncionario().getNome()+" -> "+ dependente.getNome());
        }
        return lista;
    }

    @Override
    public List<Funcionario> getListaFuncionarios() {
        EntityManager em = JPAUtil.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Funcionario> cq = cb.createQuery(Funcionario.class);
        cq.from(Funcionario.class);
        List<Funcionario> l = em.createQuery(cq).getResultList();
        return l;
    }
}