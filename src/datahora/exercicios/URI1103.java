package datahora.exercicios;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class URI1103 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int op = 1;
        do {
            int horaInicial = hora();

            int minInicial = minuto();

            LocalTime horarioInicial = LocalTime.of(horaInicial, minInicial);

            int horaFinal = validaHoraFinal(horaInicial);

            int minFinal = minuto();

            LocalTime horarioFinal = LocalTime.of(horaFinal, minFinal);

            Duration duration = Duration.between(horarioInicial,horarioFinal);

            if (duration.isNegative()){
                duration = duration.plusDays(1);
            }

            long minEntreHorarios = duration.toMinutes();

            System.out.println("Número de minutos entre os horários digitados: " + minEntreHorarios);

            System.out.println("\nDigite qualquer número para inserir outra hora e minuto ou 0 para sair");
            op = sc.nextInt();
        }
        while(op != 0);

        sc.close();
    }
    public static boolean validaHora(int hora){
        if(hora < 0 || hora > 23) return true;
        return false;
    }
    public static boolean validaMinuto(int minuto){
        if(minuto < 0 || minuto > 59) return true;
        return false;
    }
    public static int validaHoraFinal(int horaInicial){
        int horaFinal = hora();
        while (horaFinal != 0 && horaFinal < horaInicial){
            System.out.println("Hora inválida, a hora final precisa ser maior ou igual a hora inicial");
            horaFinal = hora();
        }
        return horaFinal;
    }

    public static int hora(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite uma hora : ");
        int hora = sc.nextInt();

        while (validaHora(hora)){
            System.out.println("Hora inválida, digite um número entre 0 e 23");
            hora = sc.nextInt();
        }
        return hora;
    }
    public static int minuto(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite os minutos");
        int min = sc.nextInt();

        while (validaMinuto(min)){
            System.out.println("Minuto inválido, digite um número entre 0 e 59");
            min = sc.nextInt();
        }
        return min;
    }
}
