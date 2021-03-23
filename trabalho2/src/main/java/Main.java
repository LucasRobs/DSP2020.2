import dao.*;
import entity.Dependente;
import entity.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InterfaceFuncionarioDAO funcionarioDao = new FuncionarioJPADAO();
        {
            Funcionario funcionario1 = new Funcionario("1", "1", "lucas", "1", "1");
            Funcionario funcionario2 = new Funcionario("2", "2", "joao", "2", "2");
            Funcionario funcionario3 = new Funcionario("3", "3", "regis", "3", "3");
            Funcionario funcionario4 = new Funcionario("4", "4", "pedro", "4", "4");
            Funcionario funcionario5 = new Funcionario("5", "5", "marcelo", "5", "5");
            Funcionario funcionario6 = new Funcionario("6", "6", "robson", "6", "6");
            {
                List<Dependente> dependentes = new ArrayList<>();

                Dependente dependente1 = new Dependente("1", "aperoba");
                dependente1.setFuncionario(funcionario1);
                dependentes.add(dependente1);

                Dependente dependente2 = new Dependente("2", "bmatias");
                dependente2.setFuncionario(funcionario1);
                dependentes.add(dependente2);

                funcionario1.setDependenteList(dependentes);
                funcionarioDao.adiciona(funcionario1);
            }//funcionario 1
            {
                List<Dependente> dependenteList1 = new ArrayList<>();

                Dependente dependente3 = new Dependente("3", "apostgres");
                dependente3.setFuncionario(funcionario2);
                dependenteList1.add(dependente3);

                Dependente dependente4 = new Dependente("4", "ccopia");
                dependente4.setFuncionario(funcionario2);
                dependenteList1.add(dependente4);


                funcionario2.setDependenteList(dependenteList1);
                funcionarioDao.adiciona(funcionario2);
            }//funcionario 2
            {
                List<Dependente> dependenteList2 = new ArrayList<>();
                Dependente dependente5 = new Dependente("5", "cxerox");
                dependente5.setFuncionario(funcionario3);
                dependenteList2.add(dependente5);

                Dependente dependente6 = new Dependente("6", "bimpreção");
                dependente6.setFuncionario(funcionario3);
                dependenteList2.add(dependente6);

                funcionario3.setDependenteList(dependenteList2);
                funcionarioDao.adiciona(funcionario3);
            }//funcionario 3
            {
                funcionarioDao.adiciona(funcionario4);
                funcionarioDao.adiciona(funcionario5);
                funcionarioDao.adiciona(funcionario6);
            }//funcionarios 4 5 6
        }//Cria e adiciona funcionarios

        {
            System.out.println("JPA");

            Questão5 JPQL = new JPQLDAO();
            for (String x : JPQL.getAllDependentesByChar("a")) {
                System.out.println(x);
            }
            System.out.println("Letra a");
            for (Funcionario x : JPQL.getListaFuncionarios()) {
                System.out.println(x);
            }
        }//JPQL

        {
            System.out.println("NamedQuery");

            Questão5 NamedQuery = new NamedQueryDAO();
            for (String x : NamedQuery.getAllDependentesByChar("b")) {
                System.out.println(x);
            }
            System.out.println("Letra b");
            for (Funcionario x : NamedQuery.getListaFuncionarios()) {
                System.out.println(x);
            }
        }//NamedQuery

        {
            System.out.println("Criteria");

            Questão5 criteria = new CriteriaDAO();
            for (String x : criteria.getAllDependentesByChar("c")) {
                System.out.println(x);
            }
            System.out.println("Letra c");
            for (Funcionario x : criteria.getListaFuncionarios()) {
                System.out.println(x);
            }
        }//Criteria

        {
            System.out.println("SQLNativo");

            Questão5 SQLNativas = new SQLNativasDAO();
            for (String x : SQLNativas.getAllDependentesByChar("a")) {
                System.out.println(x);
            }
            System.out.println("Letra a");
            for (Funcionario x : SQLNativas.getListaFuncionarios()) {
                System.out.println(x);
            }
        }//SQL Nativas
        {
            System.out.println("GRAM FINALE!!!");
            questão6 q6 = new questão6();
            q6.gramFinale(new Funcionario("9", "9", "9", "9", "9"));
        }//GRAMFINALE :tada:
    }
}
