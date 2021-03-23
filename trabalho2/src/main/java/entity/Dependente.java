package entity;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name="Dependente.findLetra", query="select c from Dependente c where c.nome like :letra")
})
@Table(name = "dependente", uniqueConstraints={@UniqueConstraint(columnNames={"id","cpf"})})
public class Dependente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String cpf;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    public Dependente() { }

    public Dependente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public Long getId() {return id;}

    public void setId(Long id) { this.id = id;}

    public String getCpf() { return cpf;}

    public void setCpf(String cpf) { this.cpf = cpf;}

    public String getNome() { return nome;}

    public void setNome(String nome) { this.nome = nome;}

    public  void setFuncionario(Funcionario funcionario){ this.funcionario = funcionario;}

    public Funcionario getFuncionario() { return funcionario; }
}
