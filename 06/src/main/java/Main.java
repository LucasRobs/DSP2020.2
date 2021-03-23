import dao.*;
import entity.Funcionario;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        InterfaceFuncionarioDAO funcionarioDAO = new FuncionarioJPADAONamedQuery();
        label:
        while (true) {
            String comando = ler.nextLine();
            String[] parte = comando.split(" ");
            System.out.println("$" + comando);
            if (parte[0].equals("add")) {
                funcionarioDAO.adiciona(new Funcionario(parte[1], parte[2], parte[3], parte[4], parte[5]));
            } else if (parte[0].equals("addList")) {
                funcionarioDAO.adicionarList(creatList());
            } else if (parte[0].equals("delete")) {
                funcionarioDAO.delete(Long.parseLong(parte[1]));
            } else if (parte[0].equals("show")) {
                List<Funcionario> funcionarios = funcionarioDAO.getLista();
                for (Funcionario funcionario : funcionarios) {
                    System.out.println(funcionario);
                }
            } else if (parte[0].equals("showpage")) {
                List<Funcionario> funcionariosPorPagina = funcionarioDAO.getPage(Integer.parseInt(parte[1]));
                for (Funcionario funcionario : funcionariosPorPagina) {
                    System.out.println(funcionario);
                }
            } else if (parte[0].equals("update")) {
                funcionarioDAO.update(new Funcionario(Long.parseLong(parte[1]), parte[2], parte[3], parte[4], parte[5], parte[6]));
            } else {
                break;
            }
        }
    }

    public static List<Funcionario> creatList(){
        List<Funcionario> listFuncionarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String info;
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