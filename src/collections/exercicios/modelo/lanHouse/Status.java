package collections.exercicios.modelo.lanHouse;

public enum Status {
    DISPONIVEL(0),
    ALUGADO(1),
    DEFEITO(2);

    private final int valor;

    Status(int valor) {
        this.valor = valor;
    }
    public int getValor(){
        return valor;
    }
}
