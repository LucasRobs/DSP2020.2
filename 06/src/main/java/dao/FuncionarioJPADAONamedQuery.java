package dao;
import entity.Funcionario;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class FuncionarioJPADAONamedQuery implements InterfaceFuncionarioDAO {
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












Entity
@Table(name = "funcionarios")

public class Funcionario{
    @OneToMany(cascade=CascadeType.ALL, mappedBy="funcionario")
    //  @JoinColumn(name="id_funcionario")
    private List<Dependente> dependente;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cpf", unique=true, length=11)
    @NotNull
    private int cpf;

    @Column(name = "matricula", unique=true)
    @NotNull
    private int matricula;

    @Column(name = "nome", length=100)
    @NotNull
    private String nome;
    @Column(name = "email", length=50)
    private String email;
    @Column(name = "fone", length=20)
    private int fone;