package datahora.exercicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class URI2764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 1;
        try {
            while (op != 0){
                DateTimeFormatter form1 = DateTimeFormatter.ofPattern("dd/MM/yy");
                DateTimeFormatter form2 = DateTimeFormatter.ofPattern("MM/dd/yy");
                DateTimeFormatter form3 = DateTimeFormatter.ofPattern("yy/MM/dd");
                DateTimeFormatter form4 = DateTimeFormatter.ofPattern("dd-MM-yy");

                System.out.println("Digite uma data no formato DD/MM/AA");
                String data = sc.nextLine();

                LocalDate dataParse = LocalDate.parse(data, form1);

                String dataForm2 = form2.format(dataParse);
                String dataForm3 = form3.format(dataParse);
                String dataForm4 = form4.format(dataParse);

                System.out.println(dataForm2);
                System.out.println(dataForm3);
                System.out.println(dataForm4);

                System.out.println("Digite qualquer número para continuar ou 0 para sair");
                op = sc.nextInt();
                sc.nextLine();
            }
        }
        catch (Exception e){
            System.out.println("Formato de data inválido!");
        }
        sc.close();
    }
}
