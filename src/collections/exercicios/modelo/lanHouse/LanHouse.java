package collections.exercicios.modelo.lanHouse;

import java.util.ArrayList;
import java.util.List;

public class LanHouse {
    List<Computador> computadores = new ArrayList<>();
    List<Defeito> defeitos = new ArrayList<>();

    public void listaPorMemoria(){
        System.out.println("\nLista de computadores com capacidade de memória a partir de 8GB:\n");
        for(Computador c : computadores){
            if(c.getCapacidadeMemoria() >= 8){
                System.out.println(c);
            }
        }
    }

    public void addComputador(Computador computador){
        computadores.add(computador);
    }
    public void removeComputador(Computador computador){
        computadores.remove(computador);
    }

    public void aluga(Computador computador){
        if(computador.getStatus() == Status.DISPONIVEL){
            computador.setStatus(Status.ALUGADO);
            System.out.println("O computador " + computador.getNumero() + " foi alugado!");
        }
        else{
            System.out.println("O computador " + computador.getNumero() + " está indisponível");
        }
    }

    public void disponibiliza(Computador computador){
        if(computador.getStatus() != Status.DISPONIVEL){
            computador.setStatus(Status.DISPONIVEL);
            System.out.println("\nO computador" + computador.getNumero() + " está disponível:\n");
        }
    }

    public void apresentaDefeito(Computador computador, Defeito defeito){
        if(computador.getStatus() != Status.DEFEITO){
            computador.setStatus(Status.DEFEITO);
            defeitos.add(defeito);

            System.out.println("O computador " + computador.getNumero() +" apresenta o seguinte defeito: "
                    + defeito.getDescricaoDefeito());
        }
    }
    public void listaTodosComputadores(){
        System.out.println("\nOs computadores da lan house são:\n");
        for(Computador c : computadores){
            System.out.println(c);

        }
    }

    public void listaComputadoresDefeito(){
        System.out.println("\nOs seguintes computadores estão com defeito:\n");
        for(Computador c : computadores){
           if(c.getStatus() == Status.DEFEITO) System.out.println(c);

        }
    }

    public void listaComputadoresIndisponiveis(){
        System.out.println("\nOs seguintes computadores estão indisponíveis:\n");
        for(Computador c : computadores){
            if(c.getStatus() == Status.DEFEITO || c.getStatus() == Status.ALUGADO)
                System.out.println(c);

        }
    }

    public void listaComputadoresDisponiveis(){
        System.out.println("\nOs seguintes computadores estão disponíveis:\n");
        for(Computador c : computadores){
            if(c.getStatus() == Status.DISPONIVEL)
                System.out.println(c);

        }
    }
}
