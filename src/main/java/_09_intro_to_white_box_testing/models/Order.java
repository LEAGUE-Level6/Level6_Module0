package _09_intro_to_white_box_testing.models;

public class Order {

    final String customerName;

    final String customerPhoneNumber;

    final int numberOfDonuts;

    final long dollarAmount;

    final String creditCardNumber;

    final boolean delivery;

    public Order(String customerName,
                 String customerPhoneNumber, int numberOfDonuts,
                 long dollarAmount,
                 String creditCardNumber,
                 boolean delivery) {
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
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

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                ", numberOfDonuts=" + numberOfDonuts +
                ", dollarAmount=" + dollarAmount +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", delivery=" + delivery +
                '}';
    }

}
