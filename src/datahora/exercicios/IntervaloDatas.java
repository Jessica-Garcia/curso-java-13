package datahora.exercicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class IntervaloDatas {
    public static void main(String[] args) {

        //exercício URI 1619

        DateTimeFormatter d = DateTimeFormatter.ISO_DATE;
        Scanner sc = new Scanner(System.in);


        System.out.println("Digite o número de vezes que serão digitadas duas datas ");

        int n = sc.nextInt();

        while(n <= 0 || n > 1000){
            System.out.println("\nOpção inválida! Digite um número maior que 0 e menor ou igual a 1000 ");
            n = sc.nextInt();
        }
        sc.nextLine();

        for(int i = 0; i < n; i++){
            System.out.println("Digite duas datas no formato AAAA-MM-DD");
            String data1 = sc.nextLine();

            while(validaAno(data1)){
                System.out.println("Data inválida! Digite uma data entre 1970 e 2014");
                data1 = sc.nextLine();
                validaAno(data1);
            }

            String data2 = sc.nextLine();
            while(validaAno(data2)){
                System.out.println("Data inválida! Digite uma data entre 1970 e 2014");
                data2 = sc.nextLine();
                validaAno(data2);
            }
            String data1Format = formataData(data1);
            String data2Format = formataData(data2);

            LocalDate d1 = LocalDate.parse(data1Format, d);
            LocalDate d2 = LocalDate.parse(data2Format, d);

            Long dias = ChronoUnit.DAYS.between(d1,d2);
            System.out.println("\nNumero de dias entre as datas: " + Math.abs(dias) + "\n");
        }
        sc.close();
    }
    public static boolean validaAno(String data){
        String ano = data.substring(0, 4);
        int ano1 = Integer.parseInt(ano);
        if(ano1 < 1970 || ano1 > 2014) return true;
        return false;
    }

    public static String formataData(String data){
        String ano = data.substring(0, 4);
        String mes = data.substring(5, 7);
        String dia = data.substring(8, 10);
        Integer anoInt = Integer.parseInt(ano);
        Integer mesInt = Integer.parseInt(mes);
        Integer diaInt = Integer.parseInt(dia);
        return String.format("%4d-%02d-%02d",anoInt,mesInt,diaInt);
    }

}
