package collections.teoria.teste;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListTeste1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();


        //Adicionando elementos na lista:

        //Nome da lista.add(o que quer adicionar);

        list.add("Maria");
        list.add("Bob");
        list.add("Alex");
        list.add("Anna");

        //Para imprimir cada elemento da lista:

        for (String x : list) {
            System.out.println(x);
        }

        //Inserindo um elemento na posição alguma posição da lista, por exemplo posição 2:

        list.add(2, "Marco");

        //Para ver o tamanho da lista:

        System.out.println(list.size());


        //Para remover um elemento da lista:

        list.remove("Anna");

       // Para remover um elemento de determinada posição da lista, por exemplo posição 1:

        list.remove(1);

        //Para remover da lista elementos que atendam a um predicado,
        // por exemplo remover todos os elementos que começam com a letra M:

        list.removeIf(x -> x.charAt(0) == 'M');

        //Para imprimir a posição de um elemento da lista:

        System.out.println(list.indexOf("Bob"));

        //Se eu procurar um elemento que não existe na lista o indexOf retorna -1.

        //Para deixar na lista somente o elemento que  começa com a letra A, por exemplo:
       // Deve-se declara uma nova lista

        //List<Tipo da lista> nome da lista = comando para filtrar a lista

        List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());

        for (String x : result) {
            System.out.println(x);
        }


        //Para encontrar o primeiro elemento da lista que atenda a um certo predicado,
        // para encontrar o primeiro elemento que começa com a letra A por exemplo:

        String name = list.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null);

        System.out.println(name);

    }
}
