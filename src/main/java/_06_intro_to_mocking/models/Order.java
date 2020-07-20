package _06_intro_to_mocking.models;

public class Order {

    String customerName;

    int numberOfDonuts;

    public Order(String customerName, int numberOfDonuts) {
        this.customerName = customerName;
        this.numberOfDonuts = numberOfDonuts;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getNumberOfDonuts() {
        return numberOfDonuts;
    }

    public void setNumberOfDonuts(int numberOfDonuts) {
        this.numberOfDonuts = numberOfDonuts;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", numberOfDonuts=" + numberOfDonuts +
                '}';
    }

}
