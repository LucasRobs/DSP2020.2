package questao3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Logger;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import org.json.simple.JSONObject;

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
}

public class App {
  public static void main(String[] args) throws FileNotFoundException
    {
      Scanner scan = new Scanner(System.in);
      String nomeArquivoCsv = scan.nextLine();
      InputStream csvOrigem = new FileInputStream(nomeArquivoCsv);
      Scanner linha = new Scanner(csvOrigem);

      XStream xStream = new XStream(new DomDriver());
      xStream.alias("Cliente", Cliente.class);
      linha.nextLine();
      StringBuilder xml = new StringBuilder();
      StringBuilder json = new StringBuilder();

      JSONObject objetoJson = new JSONObject(); 

      while(linha.hasNext()){
        String[] dados = linha.nextLine().split(",");
        Cliente cliente = new Cliente(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6]);
        
        objetoJson.put("nome", dados[0]);
        objetoJson.put("cpf", dados[1]);
        objetoJson.put("email", dados[2]);
        objetoJson.put("fone", dados[3]);
        objetoJson.put("cidade", dados[4]);
        objetoJson.put("uf", dados[5]);
        objetoJson.put("cep", dados[6]);
        
        json.append(objetoJson.toJSONString()+"\n");
        xml.append(xStream.toXML(cliente));
        //json.append(xStream.)
      }
      gerarArquivoXml(xml.toString());
      gerarArquivoJson(json.toString());
      scan.close();
      linha.close();
    }

    public static void gerarArquivoXml(String xml){
      PrintWriter print = null;
      try{
        File file = new File("src/test/java/questao3/xml.xml");
        print = new PrintWriter(file);
        print.write(xml);
        print.flush();
        print.close();
      }catch (FileNotFoundException ex){
        System.out.println("deu ruim");
      }
    }

    public static void gerarArquivoJson(String json){
      FileWriter fileWriter = null;
      try{
        fileWriter =new FileWriter("src/test/java/questao3/json.json");
        fileWriter.write(json);
        fileWriter.close();
      }catch(IOException ex){
        System.out.println("deu ruim");
      }
    }
}