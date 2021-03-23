import java.util.*;
import java.io.*;

class Pessoa{
  private int id;
  private String nome;
  private String email;
  private String fone;
  
  public Pessoa(int id, String nome, String email, String fone){
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.fone = fone;
  }

  public String tostring(){
    return id +" "+ nome +" "+ email +" "+ fone;
  }
}

public class main1{
  public static void main (String[] args)throws IOException{
    ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
    Scanner scan = new Scanner(System.in);
    while(true){
      String line = scan.nextLine();
			String ui[] = line.split(" ");
			String cmd = ui[0];

      if(cmd.equals("add")){
        pessoas.add(new Pessoa(pessoas.size(), ui[1], ui[2], ui[3]));
      }else if(cmd.equals("load")){
        InputStream is = new FileInputStream(ui[1]);
        Scanner linha = new Scanner(is);
        int i = pessoas.size();
        while(linha.hasNext()){
          String dado[] = linha.nextLine().split(" ");
          pessoas.add(new Pessoa(i, dado[1], dado[2], dado[3]));
          i++;
        }
      }else if(cmd.equals("save")){
        PrintStream destino = new PrintStream(ui[1]);
        for(Pessoa pessoa : pessoas){
          destino.println(pessoa.tostring());
        }
      }else if(cmd.equals("show")){
        for(Pessoa pessoa : pessoas){
          System.out.println(pessoa.tostring());
        }
      }
    }
  }
}