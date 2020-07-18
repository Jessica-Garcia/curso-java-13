package arrays.teste;

import java.util.Locale;
import java.util.Scanner;

public class ArrayTeste {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        //Fazer um programa para ler um número inteiro N e a altura de N
        //pessoas. Armazene as N alturas em um vetor. Em seguida, mostrar a
        //altura média dessas pessoas.

        System.out.println("Digite quantas alturas serão calculadas?");
        int n = sc.nextInt();
        double[] vect = new double[n];

        double soma = 0.0;

        for(int i=0; i<n; i++){
            System.out.println("Digite a altura " + (i+1));
            vect[i] = sc.nextDouble();
            soma += vect[i];
        }

        double media = soma / n;

        System.out.printf("Média das alturas digitadas = %.2f%n", media);

        sc.close();
    }
}
