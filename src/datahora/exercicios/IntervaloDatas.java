package datahora.exercicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IntervaloDatas {
    public static void main(String[] args) {

        //exercício URI 1619

        DateTimeFormatter d = DateTimeFormatter.ISO_DATE;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o número de vezes que serão digitadas duas datas ");
        int n = numeroValido();
        //sc.nextLine();

        for(int i = 0; i < n; i++){
            System.out.println("Digite duas datas no formato AAAA-MM-DD");
            String data1 = data();

            String data2 = data();

            String data1Format = formataData(data1);
            String data2Format = formataData(data2);

            LocalDate d1 = LocalDate.parse(data1Format, d);
            LocalDate d2 = LocalDate.parse(data2Format, d);

            Long dias = ChronoUnit.DAYS.between(d1,d2);
            System.out.println("\nNumero de dias entre as datas: " + Math.abs(dias) + "\n");
        }
        sc.close();
    }
    public static int ano(String data){
        String ano = data.substring(0, 4);
        return Integer.parseInt(ano);
    }
    public static int mes(String data){
        String mes = data.substring(5, 7);
        return Integer.parseInt(mes);
    }

    public static int dia (String data){
        String dia = data.substring(8, 10);
        return Integer.parseInt(dia);
    }

    public static boolean anoValido(String data){
        int ano = ano(data);
        if(ano < 1970 || ano > 2020) return false;
        return true;
    }

    public static boolean mesValido(String data){
        int mes = mes(data);
        if (mes < 1 || mes > 12) return false;
        return true;
    }

    public static boolean diaValido(String data){
        int dia = dia(data);
        if (dia < 1 || dia > 31) return false;
        return true;
    }
    public static boolean anoBissexto(String data){
        if((ano(data) % 400 == 0) || (ano(data) % 4 == 0 && ano(data) % 100 != 0)) return true;
        return false;
    }
    public static boolean diaDoEMes(String data){
        int mes = mes(data);
        int dia = dia(data);
        List<Integer> mes31 = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
        List<Integer> mes30 = Arrays.asList(4, 6, 9, 11);

        if(mes31.contains(mes)){
            return dia > 0 && dia <= 31;
        }
        else if (mes30.contains(mes)){
            return dia > 0 && dia <= 30;
        }
        else if (mes == 2 && !anoBissexto(data)){
            return dia > 0 && dia <= 28;
        }
        else if(mes == 2 && anoBissexto(data)){
            return dia > 0 && dia <= 29;
        }
        return false;
    }

    public static String formataData(String data){
        int ano = ano(data);
        int mes = mes(data);
        int dia = dia(data);
        return String.format("%4d-%02d-%02d",ano,mes,dia);
    }

    public static int numeroValido(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n < 0 || n >= 100){
            System.out.println("Opção inválida! Digite um número maior que 0 e menor ou igual a 100");
            n = sc.nextInt();
        }
        return n;
    }

    public static boolean dataValida(String data){
        if(anoValido(data) && mesValido(data) && diaValido(data) && diaDoEMes(data)) return true;
        return false;
    }

    public static String data(){
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();

        while(!dataValida(data)){
            System.out.println("Data inválida! Digite novamente");
            data = sc.nextLine();
        }
        return data;
    }
}
