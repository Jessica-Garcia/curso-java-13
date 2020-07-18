package collections.exercicios.modelo.lanHouse;

public class Computador {
    private Integer numero;
    private String modelo;
    private Status status;
    private Integer capacidadeMemoria;

    public Computador(Integer numero, String modelo, Status status, Integer capacidadeMemoria) {
        this.numero = numero;
        this.modelo = modelo;
        this.status = status;
        this.capacidadeMemoria = capacidadeMemoria;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getCapacidadeMemoria() {
        return capacidadeMemoria;
    }

    public void setCapacidadeMemoria(Integer capacidadeMemoria) {
        this.capacidadeMemoria = capacidadeMemoria;
    }

    @Override
    public String toString() {
        return "Computador{" +
                "numero = " + numero +
                ", modelo = '" + modelo + '\'' +
                ", status = " + status +
                ", capacidadeMemoria = " + capacidadeMemoria +
                '}';
    }
}
