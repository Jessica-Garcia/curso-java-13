package collections.teoria.teste;

import collections.teoria.modelo.Celular;

import java.util.ArrayList;
import java.util.List;

public class ListCelularTeste {
    public static void main(String[] args) {
        Celular celular1 = new Celular("Motorola G7 play", "12345");
        Celular celular2 = new Celular("Motorola G8", "12346");
        Celular celular3 = new Celular("Iphone 11", "12347");

        List<Celular> celularList = new ArrayList<>();

        celularList.add(celular1);
        celularList.add(celular2);
        celularList.add(celular3);

        for(Celular c : celularList){
            System.out.println(c.getNome());
        }

        Celular celular4 = new Celular("Motorola", "12349");

        System.out.println("Celulares iguais? " + celular1.equals(celular4));
        System.out.println("Está na lista? " + celularList.contains(celular4));

    }
}
