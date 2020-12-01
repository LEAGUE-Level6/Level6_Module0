package _08_mocking.models;

import _07_intro_to_mocking.models.Car;
import _09_intro_to_white_box_testing.models.Order;

import java.util.List;
import java.util.Random;

public class DeliveryDriver {

    String name;

    Car car;

    CellPhone cellPhone;

    boolean licensed;

    boolean onTheClock;

    boolean currentlyOnDelivery;

    List<Order> orders;

    public DeliveryDriver(String name, Car car, CellPhone cellPhone) {
        this.name = name;
        this.car = car;
        this.cellPhone = cellPhone;
        this.licensed = true;
        this.onTheClock = true;
        this.currentlyOnDelivery = false;
    }

    public DeliveryDriver(String name,
                          Car car,
                          CellPhone cellPhone,
                          boolean licensed,
                          boolean onTheClock,
                          boolean currentlyOnDelivery) {
        this.name = name;
        this.car = car;
        this.cellPhone = cellPhone;
        this.licensed = licensed;
        this.onTheClock = onTheClock;
        this.currentlyOnDelivery = currentlyOnDelivery;
    }

    public boolean completeDelivery(Order order) {
        //Here is some code that completes the delivery
        return new Random().nextBoolean();
    }

    public boolean contactCustomer(String phoneNumber) {
        return cellPhone.call(phoneNumber);
    }

    public boolean refuel(int octaneGrade){
        return car.fillTank(octaneGrade);
    }

    public boolean wasteTime(){
        return cellPhone.browseCatMemes();
    }

}
