package arrays.teste;

import arrays.modelo.Produto;

import java.util.Locale;
import java.util.Scanner;

public class ProdutoTeste {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o número de produtos que deseja cadastrar");
        int n = sc.nextInt();

        Produto[] produtos = new Produto[n];
        double soma = 0.0;

        for(int i=0; i<produtos.length; i++){
            System.out.println("Digite o nome do produto " + (i+1));
            String nome = sc.next();
            sc.nextLine();
            System.out.println("Digite o valor do produto " + (i+1));
            double valor = sc.nextDouble();
            produtos[i] = new Produto(nome, valor);
            soma += produtos[i].getValor();
        }

        double media = soma / produtos.length;
        System.out.printf("Média dos valores dos produtos = %.2f%n", media);

        System.out.println("Nome e valor dos produtos cadastrados:");
        for(int i=0; i<produtos.length; i++){

            System.out.println(produtos[i].getNome() + "=> " + produtos[i].getValor());
        }
        sc.close();
    }
}
