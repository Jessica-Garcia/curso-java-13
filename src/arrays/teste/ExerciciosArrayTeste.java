package arrays.teste;

import arrays.modelo.ExerciciosArray;

import java.util.Locale;
import java.util.Scanner;

public class ExerciciosArrayTeste {
    public static void main(String[] args) {

        ExerciciosArray e = new ExerciciosArray();
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("digite a quantidade de números que serão armazenados: ");
        int n = sc.nextInt();
        int[] numeros = new int[n];

        for(int i = 0; i< n; i++){
            System.out.println("Digite o número " + (i+1) + ":");
            numeros[i] = sc.nextInt();
        }

        int q = e.quantidadeNegativos(numeros);
        int q2 = e.quantasVezesAparece(numeros, 5);

        boolean[] b = e.retornaTrueOuFalse(numeros);

        System.out.println("Quantidade de numeros negativos digitados = " + q);
        System.out.println("Quantidade de vezes que o número 5 foi digitado = " + q2);

        for(int i = 0; i< b.length; i++){
            System.out.println("Numero " + numeros[i] + " é maior que zero: " + b[i]);
        }

        int posicaoMaior = e.maiorValor(numeros);

        System.out.println("Posição do maior valor = " + posicaoMaior);

        int[] a = e.lidosDoTeclado();
        for(int i = 0; i< a.length; i++){
            System.out.println(a[i]);
        }




        sc.close();
    }

}
