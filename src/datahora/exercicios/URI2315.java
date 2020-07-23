package datahora.exercicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class URI2315 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int op = 1;
        do {
            int diaInicial = validaDia();

            int mesInicial = validaMes();

            LocalDate dataInicial = validaData(diaInicial, mesInicial);

            int diaFinal = validaDia();

            int mesFinal = validaMesFinal(mesInicial);

            LocalDate dataFinal = validaDataFinal(dataInicial, diaFinal, mesFinal);

            diasEntreDatas(dataInicial, dataFinal);

            System.out.println("Digite qualquer número para continuar ou 0 para sair");
            op = sc.nextInt();
        }
        while (op != 0);

        sc.close();
    }

    public static boolean isDiaDoEMes(int dia, int mes){
        List<Integer> mes31 = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
        List<Integer> mes30 = Arrays.asList(4, 6, 9, 11);

        if(mes31.contains(mes)){
            return dia > 0 && dia <= 31;
        }
        else if (mes30.contains(mes)){
            return dia > 0 && dia <= 30;
        }
        else if (mes == 2){
            return dia > 0 && dia <= 28;
        }
        return false;

    }
    public static int validaDia(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um dia entre 1 e 31");
        int dia = sc.nextInt();
        while(dia < 1 || dia > 31){
            System.out.println("Dia Inválido!");
            System.out.println("Digite um dia entre 1 e 31");
            dia = sc.nextInt();
        }
        return dia;
    }
    public static int validaMes(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um mes entre 1 e 12");
        int mes = sc.nextInt();
        while(mes < 1 || mes > 12){
            System.out.println("Mes Inválido!");
            System.out.println("Digite um mes entre 1 e 12");
            mes = sc.nextInt();
        }
       return mes;
    }
    public static int validaMesFinal(int mesInicial){
        Scanner sc = new Scanner(System.in);
        int mesFinal = validaMes();
        while(mesFinal < mesInicial){
            System.out.println("Mes Inválido!");
            System.out.println("Digite um mes maior ou igual ao mês inicial");
            mesFinal = sc.nextInt();
        }
       return mesFinal;
    }

    public static LocalDate validaData(int dia, int mes){
        Scanner sc = new Scanner(System.in);

        while(!isDiaDoEMes(dia, mes)){
            System.out.println("Data Inválida!");
            System.out.println("Digite um dia entre 1 e 31");
            dia = sc.nextInt();
            System.out.println("Digite um mes entre 1 e 12");
            mes = sc.nextInt();
        }
        return LocalDate.of(2019, mes, dia);
    }

    public static LocalDate validaDataFinal(LocalDate dataInicial, int diaFinal, int mesFinal){
        LocalDate dataFinal = validaData(diaFinal,mesFinal);
        while (dataInicial.isAfter(dataFinal)){
            System.out.println("Digite uma data posterior ou igual à primeira data");
            diaFinal = validaDia();
            mesFinal = validaMes();
            dataFinal = validaData(diaFinal,mesFinal);
        }
        return dataFinal;
    }

    public static void diasEntreDatas(LocalDate dataInicial, LocalDate dataFinal){
        DateTimeFormatter d = DateTimeFormatter.ofPattern("dd/MM");
        String data1 = d.format(dataInicial);
        String data2 = d.format(dataFinal);
        Long diasEntreDatas = ChronoUnit.DAYS.between(dataInicial,dataFinal);
        System.out.println("Numero de dias entre: " + data1 + " e " + data2 + " = "+ diasEntreDatas);
    }
}
