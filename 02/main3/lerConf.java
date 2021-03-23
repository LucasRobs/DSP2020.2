
import java.io.*;
import java.util.*;
public class lerConf{
  public static void main(String[] args)throws IOException{
    Properties prop = new Properties();
    int linhainicial = 0, linhafinal = 0;
    try{
      prop.load(new FileInputStream ( "config.properties"));
      // get the property value and print it out
      linhainicial = Integer.parseInt(prop.getProperty("linha_inicial"));
      linhafinal = Integer.parseInt(prop.getProperty("linha_final"));

      System.out.println("linhas: "+linhainicial +" "+ linhafinal);
    }
    catch(IOException ex ) {   
      ex.printStackTrace ();
    }
    Scanner scanner = new Scanner(System.in);
    System.out.println("Nome do arquivo: ");
    String arquivo = scanner.nextLine();
    System.out.println("$" + arquivo);
    Scanner linha;
    InputStream is;
    while(true){
      try{
        is = new FileInputStream(arquivo);
        linha = new Scanner(is);
        break;
      }catch(FileNotFoundException e){
        System.out.println("Esse nome de arquivo não existe! escreva um nome de arquivo valido: ");
        arquivo = scanner.nextLine();
        System.out.println("$" + arquivo);
      }
    }
    for(int i = 0;i < linhafinal; i++){
      if(i < linhainicial - 1)
        linha.nextLine();
      else
        System.out.println(linha.nextLine());
    }
  }
}
