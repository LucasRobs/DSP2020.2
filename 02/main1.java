import java.util.*;
import java.io.*;

public class main1{
  public static void main (String[] args)throws IOException, FileNotFoundException{
    Scanner scanner = new Scanner(System.in);
    System.out.println("(exemplo: Nome-Arquivo-Origem Nome-Arquivo-Destino])");
    System.out.println("Nome dos arquivos: ");
    String linha = scanner.nextLine();
    ArrayList<String> textos = new ArrayList<String>();
    InputStream origem;
    PrintStream destino;
    Scanner linhaOrigin;
    String[] arquivos = linha.split(" ");
    while(true){
      try{
        origem = new FileInputStream(arquivos[0] + ".txt");
        destino = new PrintStream(arquivos[1] + ".txt");
        System.out.println("Sucesso: "+arquivos[0] +".txt => "+ arquivos[1] +".txt");
        linhaOrigin = new Scanner(origem);
        break;
      }catch(FileNotFoundException e){
        System.out.println("Erro: Esse nome de arquivo de origem ["+ arquivos[0] +"] não existe! escreva um nome de arquivo valido! ");
        linha = scanner.nextLine();
        arquivos = linha.split(" ");
      }
    }
    long tempoInicial = System.currentTimeMillis();
    while(linhaOrigin.hasNext()){
      destino.println(linhaOrigin.nextLine());
    }
    System.out.println("o metodo executou em " + (System.currentTimeMillis() - tempoInicial) + " milissegundo");
    destino.close();
  }
}