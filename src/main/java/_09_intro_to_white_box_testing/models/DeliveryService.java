package _09_intro_to_white_box_testing.models;

import _07_intro_to_mocking.models.Car;
import _08_mocking.models.DeliveryDriver;

import java.util.ArrayList;
import java.util.List;

public class DeliveryService {

    private boolean acceptingOrders = true;

    private List<DeliveryDriver> availableDeliveryDrivers;

    private List<Order> orders;

    public DeliveryService(List<DeliveryDriver> availableDeliveryDrivers) {
        this.availableDeliveryDrivers = availableDeliveryDrivers;
        orders = new ArrayList<>();
    }

    public void refuelAllCars(int octaneGrade) {
        for (DeliveryDriver deliveryDriver : availableDeliveryDrivers) {
            deliveryDriver.refuel(octaneGrade);
        }
    }

    public void scheduleDelivery(Order order) throws Exception {
        if (acceptingOrders) {
            orders.add(order);
        }
        else{
            throw new Exception("Sorry we are not currently accepting orders");
        }
    }

    public void deliver() throws Exception {
        //give the orders to the driver
        if (availableDeliveryDrivers.size() <= 0) {
            throw new Exception("Sorry we currently do not have the resources available to complete more deliveries");
        }
        else if(orders.size()==0){
            throw new Exception("There are currently no orders to deliver");
        }

        //for each order
        for (Order order : orders) {

            //have the driver deliver
            DeliveryDriver deliveryDriver = availableDeliveryDrivers.get(0);

            //if the delivery was completed
            boolean deliveryCompleted = deliveryDriver.completeDelivery(order);

            if (!deliveryCompleted) {
                //contact the customer
                deliveryDriver.contactCustomer(order.getCustomerPhoneNumber());
            }

            //remove from orders
            order.setCompleted(true);
        }

    }

    public void setAvailableDeliveryDrivers(List<DeliveryDriver> availableDeliveryDrivers) {
        this.availableDeliveryDrivers = availableDeliveryDrivers;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setAcceptingOrders(boolean acceptingOrders) {
        this.acceptingOrders = acceptingOrders;
    }

}
