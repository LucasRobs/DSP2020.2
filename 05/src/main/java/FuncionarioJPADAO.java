import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioJPADAO implements interfaceFuncionarioDAO {
    private Connection conn;
    public FuncionarioJPADAO(){
        this.conn = ConnectionFactory.getConnection();
    }

    @Override
    public void delete(int index){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(index);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void adiciona(Funcionario funcionario) {

        EntityManager em = JPAUtil.getEntityManager();

        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(funcionario);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void adicionarList(List<Funcionario> funcionarios){

        EntityManager em = JPAUtil.getEntityManager();

        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            for(Funcionario funcionario : funcionarios) {
                em.persist(funcionario);
                tx.commit();
            }

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Funcionario funcionario) {

        EntityManager em = JPAUtil.getEntityManager();

        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.refresh(funcionario);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Funcionario> getLista() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Funcionario> f = em.createQuery("select c from Funcionario as c", Funcionario.class).getResultList();
        JPAUtil.closeEntityManager();
        return f;
    }

    @Override
    public List<Funcionario> getListaPaginada(int page) {
        int tamanhoPagina = 3;
        EntityManager em = JPAUtil.getEntityManager();
        List l = em.createQuery("select c from Cliente c")
                .setFirstResult(page+tamanhoPagina).setMaxResults(tamanhoPagina)
                .getResultList();
        JPAUtil.closeEntityManager();
        return l;
    }
}
