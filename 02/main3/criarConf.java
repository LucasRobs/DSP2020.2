
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
public class criarConf{
  public static void main(String[] args) {
    Properties prop = new Properties();
    try{
      prop.setProperty("linha_inicial", "1");
      prop.setProperty("linha_final", "6");
      prop.store(new FileOutputStream("config.properties"), null);
    }
    catch(IOException ex) {   
      ex.printStackTrace ();
    }
  }
}
