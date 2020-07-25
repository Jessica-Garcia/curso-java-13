package interfaces.exercicio1.entities;

public class Invoice {
    private Double basicPayment;
    private Double tax;

    public Invoice(Double basicPayment, Double tax) {
        this.basicPayment = basicPayment;
        this.tax = tax;
    }

    public Double getBasicPayment() {
        return basicPayment;
    }

    public void setBasicPayment(Double basicPayment) {
        this.basicPayment = basicPayment;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double totalPayment(){
        return getBasicPayment() + getTax();
    }

    @Override
    public String toString() {
        return "\nINVOICE" +
                "\nBasic payment: " + String.format("%.2f", getBasicPayment()) +
                "\nTax: " + String.format("%.2f", getTax()) +
                "\nTotal Payment: " + String.format("%.2f", totalPayment());
    }
}
