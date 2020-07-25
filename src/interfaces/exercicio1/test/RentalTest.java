package interfaces.exercicio1.test;

import interfaces.exercicio1.entities.CarRental;
import interfaces.exercicio1.entities.Vehicle;
import interfaces.exercicio1.services.BrazilTaxService;
import interfaces.exercicio1.services.RentalService;
import interfaces.exercicio1.services.TaxService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class RentalTest {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Enter rental data");

        System.out.print("Car model: ");
        String carModel = sc.nextLine();
        Vehicle car = new Vehicle(carModel);

        System.out.print("Pickup (dd/MM/yyyy hh:mm): ");
        String pickup = sc.nextLine();
        LocalDateTime start = LocalDateTime.parse(pickup, form);

        System.out.print("Return (dd/MM/yyyy hh:mm): ");
        String returnDate = sc.nextLine();
        LocalDateTime finish = LocalDateTime.parse(returnDate, form);

        CarRental carRental = new CarRental(start, finish, car);

        System.out.print("Enter price per hour: ");
        Double pricePerHour = sc.nextDouble();

        System.out.print("Enter price per day: ");
        Double pricePerDay = sc.nextDouble();

        TaxService taxService = new BrazilTaxService();

        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, taxService);
        rentalService.processInvoice(carRental);

        System.out.println(carRental.getInvoice().toString());

        sc.close();
    }
}
