package interfaces.exercicio1.services;

import interfaces.exercicio1.entities.CarRental;
import interfaces.exercicio1.entities.Invoice;

import java.time.temporal.ChronoUnit;

public class RentalService {
    private Double pricePerHour;
    private Double pricePerDay;
    private TaxService taxService;

    public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public TaxService getTaxService() {
        return taxService;
    }

    public void setTaxService(TaxService taxService) {
        this.taxService = taxService;
    }

    public double rentalDuration(CarRental carRental){
        double hours = (double)ChronoUnit.SECONDS.between(carRental.getStart(),
                       carRental.getFinish()) / 60.0 / 60.0;
        return hours;
    }

    public double rentalBasicPayment(CarRental carRental){
        if(rentalDuration(carRental) <= 12.0){
            return Math.ceil(rentalDuration(carRental)) * pricePerHour;
        }
        return Math.ceil(rentalDuration(carRental) / 24) * pricePerDay;
    }

    public double rentalTax(CarRental carRental){
        return taxService.tax(rentalBasicPayment(carRental));
    }

    public void processInvoice(CarRental carRental){
        carRental.setInvoice(new Invoice(rentalBasicPayment(carRental), rentalTax(carRental)));
    }
}
