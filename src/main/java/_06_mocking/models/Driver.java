package _06_mocking.models;

import _06_mocking.models.Order;

import java.util.List;
import java.util.Random;

public class Driver {

    String name;

    boolean licensed;

    boolean onTheClock;

    boolean currentlyDelivering;

    List<Order> orders;

    public Driver(String name, boolean licensed, boolean onTheClock, boolean currentlyDelivering) {
        this.name = name;
        this.licensed = licensed;
        this.onTheClock = onTheClock;
        this.currentlyDelivering = currentlyDelivering;
    }

    public boolean completeDelivery(Order order) {
        //Here is some code that completes the delivery
        return new Random().nextBoolean();
    }

    public boolean contactCustomer(Order order) {
        //Here is some code that contacts the customer
        return new Random().nextBoolean();
    }

}
