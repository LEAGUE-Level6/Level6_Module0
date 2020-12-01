package _10_white_box_testing;

import _07_intro_to_mocking.models.Car;
import _08_mocking.models.DeliveryDriver;
import _09_intro_to_white_box_testing.models.Order;

import java.util.List;

public class DeliveryService {

    boolean acceptingOrders = true;

    List<DeliveryDriver> availableDeliveryDrivers;

    List<Car> availableCars;

    List<Order> orders;

    List<Order> canceledOrders;

    public DeliveryService(List<DeliveryDriver> availableDeliveryDrivers, List<Car> availableCars) {
        this.availableDeliveryDrivers = availableDeliveryDrivers;
        this.availableCars = availableCars;
    }

    public boolean scheduleDelivery(Order order) {
        if (acceptingOrders) {
            orders.add(order);
            return true;
        }
        return false;
    }

    public boolean deliver() throws Exception {
        //give the orders to the driver
        if (availableDeliveryDrivers.size() <= 0 || availableCars.size() <= 0) {
            throw new Exception("Sorry we currently do not have the resources available to complete more deliveries");
        }

        //for each order
        for (Order order : orders) {

            //have the driver deliver
            DeliveryDriver deliveryDriver = availableDeliveryDrivers.get(0);

            //if the delivery was completed
            boolean deliveryCompleted = deliveryDriver.completeDelivery(order);

            //remove from orders
            if (deliveryCompleted) {
                orders.remove(order);
                return true;
            }
            //else
            else {
                //contact the customer
                boolean customerContacted = deliveryDriver.contactCustomer(order.getCustomerPhoneNumber());
                //if they answer
                if (customerContacted) {
                    //deliver to customer
                    orders.remove(order);
                    return true;
                }
                //else
                else {
                    //cancel order
                    orders.remove(order);
                    canceledOrders.add(order);
                    return false;
                }
            }
        }
        throw new Exception("There are currently no orders to deliver");
    }

}
