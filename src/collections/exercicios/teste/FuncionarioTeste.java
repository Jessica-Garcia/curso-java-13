package collections.exercicios.teste;

import collections.exercicios.modelo.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FuncionarioTeste {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Funcionario> funcionarios = new ArrayList<>();

        System.out.print("Digite quantos funcionários deseja registrar ");
        int n = sc.nextInt();

        for(int i=1; i<=n; i++){
            System.out.println("\nFuncionário # " + i);

            System.out.print("\nDigite o ID do funcionário: ");
            Integer id = sc.nextInt();

            while(existeId(funcionarios,id)){
                System.out.print("\nID já existe! Digite novamente: ");
                id = sc.nextInt();
            }

            System.out.print("Digite o nome do funcionário: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Digite o salário do funcionário: ");
            Double salario = sc.nextDouble();
            Funcionario funcionario = new Funcionario(id, nome, salario);
            funcionarios.add(funcionario);
        }

        System.out.print("\nDigite o id do funcionário que deseja aumentar o salário: ");
        Integer id = sc.nextInt();
        System.out.print("Digite a porcentagem de aumento do salário: ");
        double porcentagem = sc.nextDouble();

        Funcionario idFunc = funcionarios.stream().filter(x -> x.getId().
                             equals(id)).findFirst().orElse(null);

        if(idFunc != null){
            idFunc.aumentaSalario(10.0);
        }
        else{
            System.out.println("ID não encontrado!");
        }

        System.out.println("\n Lista de funcionários: \n");

        for(Funcionario f : funcionarios){
            System.out.println(f);
        }

        sc.close();
    }

    public static boolean existeId(List<Funcionario> l, int id){
        Funcionario func = l.stream().filter(x -> x.getId().
                equals(id)).findFirst().orElse(null);
        return func != null;
    }
}
