package _09_intro_to_white_box_testing.models;

public class Order {

    private final String customerName;

    private final String customerPhoneNumber;

    private final int numberOfDonuts;

    private final double dollarAmount;

    private final String creditCardNumber;

    private final boolean delivery;

    private boolean completed = false;

    public Order(String customerName,
                 String customerPhoneNumber, int numberOfDonuts,
                 double dollarAmount,
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

    public double getDollarAmount() {
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

    public void setCompleted(boolean completed) {
        this.completed = completed;
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
