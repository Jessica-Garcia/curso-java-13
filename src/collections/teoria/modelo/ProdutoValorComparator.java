package collections.teoria.modelo;

import java.util.Comparator;

public class ProdutoValorComparator implements Comparator<Produto> {
    @Override
    public int compare(Produto p1, Produto p2) {
        return p1.getValor().compareTo(p2.getValor());
    }
}
