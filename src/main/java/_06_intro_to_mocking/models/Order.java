package _06_intro_to_mocking.models;

public class Order {

    final String customerName;

    final int numberOfDonuts;

    final long dollarAmount;

    final String creditCardNumber;

    final boolean delivery;

    public Order(String customerName,
                 int numberOfDonuts,
                 long dollarAmount,
                 String creditCardNumber,
                 boolean delivery) {
        this.customerName = customerName;
        this.numberOfDonuts = numberOfDonuts;
        this.dollarAmount = dollarAmount;
        this.creditCardNumber = creditCardNumber;
        this.delivery = delivery;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getNumberOfDonuts() {
        return numberOfDonuts;
    }

    public long getDollarAmount() {
        return dollarAmount;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public boolean isDelivery() {
        return delivery;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", numberOfDonuts=" + numberOfDonuts +
                ", dollarAmount=" + dollarAmount +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", delivery=" + delivery +
                '}';
    }

}
