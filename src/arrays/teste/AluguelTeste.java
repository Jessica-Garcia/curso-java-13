package arrays.teste;

import arrays.modelo.Aluguel;

import java.util.Locale;
import java.util.Scanner;

public class AluguelTeste {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Aluguel[] al = new Aluguel[10];

        System.out.println("Quantos quartos serão alugados?");
        int n = sc.nextInt();

        for(int i = 1; i<=n; i++){
            System.out.println("\nAluguel #" + i +":");
            sc.nextLine();
            System.out.print("Digite o nome do locatário: ");
            String nome = sc.nextLine();
            System.out.print("Digite o email do locatário: ");
            String email = sc.nextLine();
            System.out.print("Digite o numero do quarto alugado: ");
            int quarto = sc.nextInt();
            al[quarto] = new Aluguel(nome, email, quarto);

        }

        System.out.println("\nQuartos ocupados:");

//        for(int i = 0; i< al.length; i++){
//            if(al[i] != null){
//                System.out.println(al[i].getQuarto() + ": " + al[i].getNome() + ", " + al[i].getEmail());
//            }
//
//        }

        for(Aluguel a : al){
            if(a != null){
                System.out.println(a.getQuarto() + ": " + a.getNome() + ", " + a.getEmail());
            }
        }

        sc.close();
    }
}
