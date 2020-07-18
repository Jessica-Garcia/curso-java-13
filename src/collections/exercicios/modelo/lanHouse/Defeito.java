package collections.exercicios.modelo.lanHouse;

public class Defeito {
    private String descricaoDefeito;

    public Defeito(String descricaoDefeito) {
        this.descricaoDefeito = descricaoDefeito;
    }

    public String getDescricaoDefeito() {
        return descricaoDefeito;
    }

    public void setDescricaoDefeito(String descricaoDefeito) {
        this.descricaoDefeito = descricaoDefeito;
    }

    @Override
    public String toString() {
        return "Defeito{" +
                "descricaoDefeito='" + descricaoDefeito + '\'' +
                '}';
    }
}
