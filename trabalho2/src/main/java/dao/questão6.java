package dao;

import entity.Funcionario;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class questão6 {

    public void gramFinale(Funcionario funcionario) {

        EntityManager em = JPAUtil.getEntityManager();

        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            String aux = funcionario.getCpf();
            em.persist(funcionario);//1
            funcionario.setCpf("ajshdjahsjdhasjd");
            em.persist(funcionario);//2
            funcionario.setCpf(aux);
            em.persist(funcionario);//3

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            System.out.println("RollBack!");
        } finally {
            em.close();
        }
    }

}
