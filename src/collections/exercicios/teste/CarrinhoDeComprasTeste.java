package collections.exercicios.teste;

import collections.exercicios.modelo.carrinhoDeCompras.Carrinho;
import collections.exercicios.modelo.carrinhoDeCompras.Item;
import collections.exercicios.modelo.carrinhoDeCompras.Produto;

public class CarrinhoDeComprasTeste {
    public static void main(String[] args) {
        Produto p1 = new Produto("123", "Notebook", 3150.0);
        Produto p2 = new Produto("124", "Celular", 2150.0);
        Produto p3 = new Produto("125", "Tablet", 1150.0);
        Produto p4 = new Produto("126", "Monitor", 950.0);
        Produto p5 = new Produto("127", "Teclado", 250.0);

        Item i1 = new Item(2, p1);
        Item i2 = new Item(3, p2);
        Item i3 = new Item(1, p3);
        Item i4 = new Item(1, p4);
        Item i5 = new Item(3, p5);

        Carrinho c = new Carrinho();

        c.addItem(i1);
        c.addItem(i2);
        c.addItem(i3);
        c.addItem(i4);
        c.addItem(i5);

        c.listaItens();

        c.removeItem(i3);
        c.removeItem(i5);

        c.listaItens();

    }
}
