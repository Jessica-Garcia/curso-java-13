package collections.teoria.teste;

import collections.teoria.modelo.Produto;
import collections.teoria.modelo.ProdutoNomeComparator;
import collections.teoria.modelo.ProdutoValorComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListaProdutoOrdenadoTeste {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();

        Produto p1 = new Produto("123", "Notebook", 3150.0);
        Produto p2 = new Produto("124", "Celular", 2150.0);
        Produto p3 = new Produto("125", "Tablet", 1150.0);
        Produto p4 = new Produto("126", "Monitor", 950.0);

        produtos.add(p1);
        produtos.add(p2);
        produtos.add(p3);
        produtos.add(p4);

        // Para ordenar a lista por nome usando a interface Comparator
        Collections.sort(produtos, new ProdutoNomeComparator());

        System.out.println("\n***Lista Ordenada por nome***\n");
        for(Produto p : produtos){
            System.out.println(p);
        }


        // Para ordenar Arrays

        Produto[] prod = new Produto[4];
        prod[0] = p1;
        prod[1] = p2;
        prod[2] = p3;
        prod[3] = p4;

        System.out.println("\n***Array Ordenado por nome***\n");
        Arrays.sort(prod, new ProdutoNomeComparator());

        for(Produto pr : prod){
            System.out.println(pr);
        }

        System.out.println("\n***Lista Ordenada por preço***\n");
        Collections.sort(produtos, new ProdutoValorComparator());
        for(Produto p : produtos){
            System.out.println(p);
        }

        System.out.println("\n***Array Ordenado por preço***\n");
        Arrays.sort(prod, new ProdutoValorComparator());
        for(Produto pr : prod){
            System.out.println(pr);
        }

        System.out.println("\n***Array de Strings Ordenado***\n");
        String[] array = new String[4];
        array[0] = "Maria";
        array[1] = "Adrielly";
        array[2] = "Vagner";
        array[3] = "João";

        Arrays.sort(array);

        for(String n : array){
            System.out.println(n);
        }
    }
}
