package collections.teoria.modelo;

import java.util.Objects;

public class Produto {
    private String numeroDeSerie;
    private String nome;
    private Double valor;

    public Produto(String numeroDeSerie, String nome, Double valor) {
        this.numeroDeSerie = numeroDeSerie;
        this.nome = nome;
        this.valor = valor;
    }

    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public void setNumeroDeSerie(String numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return Objects.equals(numeroDeSerie, produto.numeroDeSerie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroDeSerie);
    }

    @Override
    public String toString() {
        return "Produto = " + this.nome + ", "
                + "Numero de Série = " + this.numeroDeSerie + ", "
                + "Preço = " + this.valor;
    }
}
