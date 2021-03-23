import java.util.*;
import java.io.*;

public class main1{
  public static void main (String[] args)throws IOException{
    Scanner scanner = new Scanner(System.in);
    System.out.println("Nome do arquivo: ");
    String arquivo = scanner.nextLine();
    System.out.println("$" + arquivo);
    List<String> textos = new ArrayList<String>();
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

    System.out.println("Numero da primeira linha: ");
    String numero =scanner.nextLine();
    int primeiroNumero;
    try{
      primeiroNumero = Integer.parseInt(numero);
    }catch(NumberFormatException e){
      System.out.println("numero invalido!!! a primeira linha foi definida com [0]!");
      primeiroNumero = 0;
    }
    System.out.println("Numero da segunda linha: ");
    int segundoNumero;
    try{
      segundoNumero = Integer.parseInt(scanner.nextLine());
      for(int x = 0; x <= primeiroNumero; x++){
        if(x == primeiroNumero)
          for(int i = primeiroNumero; i <= segundoNumero;i++){
            textos.add(linha.nextLine());
          }
        linha.nextLine();
      }
    }catch(NumberFormatException e){
      while(linha.hasNext()){
        textos.add(linha.nextLine());
      }
      System.out.println("numero invalido!!! a segunda linha foi definica ultima linha ["+ textos.size() +"]!");
      segundoNumero = textos.size();
    }
    System.out.println("$" + arquivo + ".txt inicio["+ primeiroNumero + "] fim[" + segundoNumero+"]");

    if(primeiroNumero < segundoNumero){
      for(String x : textos){
        System.out.println(x);
      }
    }else{
      System.out.println("erro: o primeiro numero é maior que o segundo!");
    }
  }
}