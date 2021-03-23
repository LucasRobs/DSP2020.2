package dao;
import entity.Funcionario;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class FuncionarioJPADAO implements InterfaceFuncionarioDAO {
    @Override
    public void delete(Long index) {
        EntityManager em = JPAUtil.getEntityManager();
        em.createNamedQuery("Funcionario.delete", Funcionario.class).setParameter("index", index);
        JPAUtil.closeEntityManager();
    }

    @Override
    public void adiciona(Funcionario funcionario) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            JPAUtil.beginTransaction();
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
    public void adicionarList(List<Funcionario> funcionarios) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            JPAUtil.beginTransaction();
            for(Funcionario funcionario : funcionarios)
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
    public long getIdFuncionario(Funcionario funcionario){
        EntityManager em = JPAUtil.getEntityManager();
        Funcionario l = em.createNamedQuery("Funcionario.findByName", Funcionario.class).setParameter("index", funcionario.getNome()).getSingleResult();
        JPAUtil.closeEntityManager();
        return l.getId();
    }

    @Override
    public void update(Funcionario funcionario) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            JPAUtil.beginTransaction();
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
    public List<Funcionario> getLista() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Funcionario> l = em.createNamedQuery("Funcionario.findAll", Funcionario.class).getResultList();
        JPAUtil.closeEntityManager();
        return l;
    }

    @Override
    public List<Funcionario> getPage(int pagina) {
        EntityManager em = JPAUtil.getEntityManager();
        int offset = (pagina - 1) * 3;
        List<Funcionario> l = em.createNamedQuery("Funcionario.findAll").setFirstResult(offset).setMaxResults(3).getResultList();
        JPAUtil.closeEntityManager();
        return l;
    }
}

