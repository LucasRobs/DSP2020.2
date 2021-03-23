package entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@NamedQuery(name="Funcionario.findByIniciadosPorNome", query="select c from funcionario as c where c.nome like :nome")

@Entity
@NamedQueries({
        @NamedQuery(name="Funcionario.findByName", query="select c from Funcionario c where c.nome = index"),
        @NamedQuery(name="Funcionario.findAll", query="select c from Funcionario c"),
        @NamedQuery(name="Funcionario.delete", query="delete from Funcionario c where  c.id = index"),
})
@Table(name = "funcionario", uniqueConstraints={@UniqueConstraint(columnNames={"id","cpf","matricula"})})
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String cpf;
    @Column(unique=true)
    private String matricula;
    private String nome;
    private String email;
    private String telefone;
    @OneToMany(cascade=CascadeType.ALL, mappedBy="funcionario")
    private List<Dependente> dependentes = new ArrayList<Dependente>();

    public Funcionario() { }

    public Funcionario(Long id, String cpf, String matricula, String nome, String email, String telefone) {
        this.id = id;
        this.cpf = cpf;
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Funcionario(String cpf, String matricula, String nome, String email, String telefone) {
        this.cpf = cpf;
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Funcionario(String cpf, String matricula, String nome, String email, String telefone, Dependente dependentes) {
        this.cpf = cpf;
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dependentes.add(dependentes);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {this.email = email;}

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void addDependente(Dependente dependete){
        this.dependentes.add(dependete);
    }

    public List<Dependente> getDependentes() { return dependentes; }

    public  void setDependenteList(List<Dependente> list){ dependentes = list;}

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", matricuola='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}