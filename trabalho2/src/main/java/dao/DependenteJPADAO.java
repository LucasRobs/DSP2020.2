package dao;
import entity.Dependente;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class DependenteJPADAO implements InterfaceDependenteDAO {
    @Override
    public void delete(Long index) {
        EntityManager em = JPAUtil.getEntityManager();
        em.createNamedQuery("Depedente.delete", Dependente.class).setParameter("index", index);
        JPAUtil.closeEntityManager();
    }

    @Override
    public void adiciona(Dependente dependente) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            JPAUtil.beginTransaction();
            em.merge(dependente);
            JPAUtil.commit();
        } catch (Exception e) {
            JPAUtil.rollback();
            e.printStackTrace();
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    @Override
    public void adicionarList(List<Dependente> dependentes) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            JPAUtil.beginTransaction();
            for(Dependente funcionario : dependentes)
                em.merge(funcionario);
            JPAUtil.commit();
        } catch (Exception e) {
            JPAUtil.rollback();
            e.printStackTrace();
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    @Override
    public void update(Dependente dependente) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            JPAUtil.beginTransaction();
            em.merge(dependente);
            JPAUtil.commit();
        } catch (Exception e) {
            JPAUtil.rollback();
            e.printStackTrace();
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    @Override
    public List<Dependente> getLista() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Dependente> l = em.createNamedQuery("Dependente.findAll", Dependente.class).getResultList();
        JPAUtil.closeEntityManager();
        return l;
    }

    @Override
    public List<Dependente> getPage(int pagina) {
        EntityManager em = JPAUtil.getEntityManager();
        int offset = (pagina - 1) * 3;
        List<Dependente> l = em.createNamedQuery("Dependente.findAll").setFirstResult(offset).setMaxResults(3).getResultList();
        JPAUtil.closeEntityManager();
        return l;
    }
}

