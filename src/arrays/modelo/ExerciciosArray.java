package arrays.modelo;

import java.util.Scanner;

public class ExerciciosArray {

    public int quantidadeNegativos(int[] numeros){
        int quant = 0;
        for(int i = 0; i< numeros.length; i++){
            if(numeros[i] < 0){
                quant += 1;
            }
        }
        return quant;
    }

    public int quantasVezesAparece(int[] numeros, int x){
        int quant = 0;
        for(int i = 0; i< numeros.length; i++){
            if(numeros[i] == x){
                quant += 1;
            }
        }
        return quant;
    }

    public boolean[] retornaTrueOuFalse(int[] a){

        boolean [] b = new boolean[a.length];

        for(int i = 0; i< a.length; i++){
            if(a[i] <= 0){
                b[i] = false;
            }
            else {
                b[i] = true;
            }
        }
        return b;
    }

    public int maiorValor(int[] numeros){
        int maior = numeros[0];
        int posicao = 0;

        for(int i = 1; i< numeros.length; i++){
            if(numeros[i] > maior){
                maior = numeros[i];
                posicao = i;
            }
        }
        return posicao;
    }

    public int[] lidosDoTeclado(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a quantidade de números que serão lidos: ");
        int n = sc.nextInt();

        int[] array = new int[n];
        for (int i = 0; i< n; i++){
            System.out.print("Digite o numero  " + (i+1) + ": ");
            array[i] = sc.nextInt();
        }
        return array;
    }


}
