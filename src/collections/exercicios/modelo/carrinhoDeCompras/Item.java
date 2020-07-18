package collections.exercicios.modelo.carrinhoDeCompras;

public class Item {
    private Integer quantidade;
    private Produto produto;

    public Item(Integer quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double subTotalItem(){
        return this.quantidade * this.produto.getValor();
    }

    @Override
    public String toString() {
        return  "Produto = " + this.produto.getNome() +
                ", Quantidade= " + this.quantidade +
                ", Subtotal = " + String.format("%.2f", this.subTotalItem());

    }
}
