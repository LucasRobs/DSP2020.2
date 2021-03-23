import java.util.*;

public class Main{
    public static void main(String[] args) {
        interfaceFuncionarioDAO funcionarioDAO = new FuncionarioJPADAO();
        Scanner scanner = new Scanner(System.in);
        label:
        while(true){
            String comando = scanner.nextLine();
            String[] parte = comando.split(" ");
            System.out.println("$asd"+ comando);
            if(parte[0].equals("add")){
                funcionarioDAO.adiciona(new Funcionario(parte[1], parte[2], parte[3], parte[4], parte[5]));
            }
            else if(parte[0].equals("addList")){
                funcionarioDAO.adicionarList(creatList());
            }
            else if(parte[0].equals("delete")){
                funcionarioDAO.delete(Integer.parseInt(parte[1]));
            }else if(parte[0].equals("show")){
                List<Funcionario> funcionarios = funcionarioDAO.getLista();
                for (Funcionario funcionario : funcionarios) {
                    System.out.println(funcionario);
                }
            }else if(parte[0].equals("showpage")){
                List<Funcionario> funcionariosPorPagina = funcionarioDAO.getListaPaginada(Integer.parseInt(parte[1]));
                for (Funcionario funcionario : funcionariosPorPagina) {
                    System.out.println(funcionario);
                }
            }else if(parte[0].equals("update")){
                funcionarioDAO.update(new Funcionario(Integer.parseInt(parte[1]), parte[2], parte[3], parte[4], parte[5], parte[6]));
            }else{
                break;
            }
        }
        scanner.close();
    }

    public static List<Funcionario> creatList(){
        List<Funcionario> listFuncionarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String info;
        label:
        while(true){
            String comando = scanner.nextLine();
            String[] parte = comando.split(" ");
            System.out.println("$"+ comando);
            if(parte[0].equals("add")){
                listFuncionarios.add(new Funcionario(parte[1], parte[2], parte[3], parte[4], parte[5]));
            }
            else if(parte[0].equals("addList")){
                return  listFuncionarios;
            }
            else if(parte[0].equals("delete")){
                listFuncionarios.remove(Integer.parseInt(parte[1]));
            }else if(parte[0].equals("show")) {
                for (Funcionario funcionario : listFuncionarios) {
                    System.out.println(funcionario);
                }
            }else{
                break;
            }
        }
        return null;
    }
}