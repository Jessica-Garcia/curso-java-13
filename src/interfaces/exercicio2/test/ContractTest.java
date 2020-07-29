package interfaces.exercicio2.test;

import interfaces.exercicio2.entities.Contract;
import interfaces.exercicio2.entities.Installment;
import interfaces.exercicio2.services.ContractService;
import interfaces.exercicio2.services.OnlinePaymentService;
import interfaces.exercicio2.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class ContractTest {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter contract data");
        System.out.print("Number: ");
        int number = sc.nextInt();

        System.out.print("Date (dd/MM/yyyy): ");
        sc.nextLine();
        String dateStr = sc.nextLine();
        LocalDate date = LocalDate.parse(dateStr, formatter);

        System.out.print("Contract value: ");
        double value = sc.nextDouble();

        Contract contract = new Contract(number, date, value);

        System.out.print("Enter number of installments: ");
        int numberOfMonths = sc.nextInt();

        OnlinePaymentService onlinePaymentService = new PaypalService();
        ContractService contractService = new ContractService(onlinePaymentService);
        contractService.processContract(contract, numberOfMonths);

        System.out.println("\nInstallments: ");
        for (Installment installment : contract.getInstallments()){
            System.out.println(installment);
        }
        sc.close();
    }
}
