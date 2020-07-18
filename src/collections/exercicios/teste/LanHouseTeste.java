package collections.exercicios.teste;

import collections.exercicios.modelo.lanHouse.Computador;
import collections.exercicios.modelo.lanHouse.Defeito;
import collections.exercicios.modelo.lanHouse.LanHouse;
import collections.exercicios.modelo.lanHouse.Status;

public class LanHouseTeste {
    public static void main(String[] args) {
        Computador c1 = new Computador(1, "Dell", Status.DISPONIVEL, 8);
        Computador c2 = new Computador(2, "Samsung", Status.ALUGADO, 4);
        Computador c3 = new Computador(3, "Azus", Status.DEFEITO, 16);
        Computador c4 = new Computador(4, "Lenovo", Status.DISPONIVEL, 8);
        Computador c5 = new Computador(5, "Positivo", Status.ALUGADO, 4);
        Computador c6 = new Computador(6, "Sony", Status.DEFEITO, 4);

        Defeito defeito1 = new Defeito("Não liga");
        Defeito defeito2 = new Defeito("Placa mãe queimada");
        Defeito defeito3 = new Defeito("Desconehcido");
        Defeito defeito4 = new Defeito("Hd queimado");

        LanHouse l = new LanHouse();
        l.addComputador(c1);
        l.addComputador(c2);
        l.addComputador(c3);
        l.addComputador(c4);
        l.addComputador(c5);
        l.addComputador(c6);

       l.listaTodosComputadores();

        System.out.println("--------------------------------------------");

        l.listaPorMemoria();

        System.out.println("--------------------------------------------");

        l.aluga(c1);

        System.out.println("--------------------------------------------");
        l.listaTodosComputadores();

        System.out.println("--------------------------------------------");
        l.apresentaDefeito(c4,defeito2);

        l.listaTodosComputadores();

        l.aluga(c4);

        l.listaComputadoresDefeito();

        l.listaComputadoresIndisponiveis();

        l.disponibiliza(c1);
        l.disponibiliza(c2);
        l.disponibiliza(c3);

        l.listaComputadoresDefeito();

        l.listaComputadoresIndisponiveis();

        l.listaComputadoresDisponiveis();

    }
}
