import java.util.*;
import java.io.*;

class Cliente{
  private String nome;
  private String cpf;
  private String email;
  private String fone;
  private String cidade;
  private String uf;
  private String cep;
  

  public Cliente(String nome, String cpf, String email, String fone, String cidade, String uf, String cep) {
    this.nome = nome;
    this.cpf = cpf;
    this.email = email;
    this.fone = fone;
    this.cidade = cidade;
    this.uf = uf;
    this.cep = cep;
  }

  public String getNome() {
    return this.nome;
  }

  public String getCpf() {
    return this.cpf;
  }

  public String getEmail() {
    return this.email;
  }

  public String getFone() {
    return this.fone;
  }

  public String getCidade() {
    return this.cidade;
  }

  public String getUf() {
    return this.uf;
  }

  public String getCep() {
    return this.cep;
  }

  @Override
  public String toString() {
    return
      getNome()+","+
      getCpf()+","+
      getEmail()+","+
      getFone()+","+
      getCidade()+","+
      getUf()+","+
      getCep()+"";
  }
}


public class main1{
  public static void main (String[] args)throws IOException{
    Cliente cliente;
    Scanner scan = new Scanner(System.in);
    while(true){
      String line = scan.nextLine();
			String ui[] = line.split(" ");

      cliente = new Cliente(ui[0], ui[1], ui[2], ui[3], ui[4], ui[5], ui[6]);
      FileWriter destino = new FileWriter("arquivo.csv", true);
      destino.append(cliente.toString()+"\n");
      destino.close();
      
    }
  }
}