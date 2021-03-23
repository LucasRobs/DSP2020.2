
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        label:
        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String[] ui = line.split(" ");
            switch (ui[0]) {
                case "end":
                    break label;
                case "add":
                    funcionarioDAO.adiciona(new Funcionario(ui[1], ui[2], ui[3], ui[4], ui[5]));
                    break;
                case "all":
                    List<Funcionario> funcionarios = funcionarioDAO.getLista();
                    for (Funcionario funcionario : funcionarios) {
                        System.out.println(funcionario);
                    }
                    break;
                case "del":
                    funcionarioDAO.delete(Integer.parseInt(ui[1]));
                    break;
                case "up":
                    funcionarioDAO.update(new Funcionario(Integer.parseInt(ui[1]), ui[2], ui[3], ui[4], ui[5], ui[6]));
                    break;
                case "addList":
                    funcionarioDAO.adicionarList(creatList());
                    break;
                case "getPage":
                    List<Funcionario> funcionariosPorPage = funcionarioDAO.getPage(Integer.parseInt(ui[1]));
                    for (Funcionario funcionario : funcionariosPorPage) {
                        System.out.println(funcionario);
                    }
                    break;
                default:
                    System.out.println("Comando " + ui[0] + " não encontrado!");
                    break;
            }
        }
        scanner.close();
    }

    public static List<Funcionario> creatList(){
        List<Funcionario> listFuncionarios = new ArrayList<Funcionario>();
        Scanner scanner = new Scanner(System.in);
        String info = "";
        label:
        while (true) {
            System.out.println("$List");
            info = scanner.nextLine();

            String[] dado = info.split(" ");
            switch (dado[0]) {
                case "cancel":
                    break label;
                case "add":
                    listFuncionarios.add(new Funcionario(dado[1], dado[2], dado[3], dado[4], dado[5]));
                    break;
                case "listDados":
                    for (Funcionario funcionario : listFuncionarios) {
                        System.out.println(funcionario);
                    }
                    break;
                case "commit":
                    return listFuncionarios;
                default:
                    System.out.println("Comando " + dado[0] + " não encontrado!");
            }
        }
        return listFuncionarios;
    }
}