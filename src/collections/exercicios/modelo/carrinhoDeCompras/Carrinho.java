package collections.exercicios.modelo.carrinhoDeCompras;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Item> itens = new ArrayList<>();

    public List<Item> getItens() {
        return itens;
    }

    public void addItem(Item item){
        itens.add(item);
    }
    public void removeItem(Item item){
        itens.remove(item);
    }
    public void listaItens(){
        for(Item i : itens){
            System.out.println(i);
        }
        System.out.println("\nTotal a pagar : " + String.format("%.2f", total()) + "\n");
    }

    public double total(){
        double total = 0.0;
        for(Item i : itens){
            total += i.subTotalItem();
        }
        return total;
    }
}
