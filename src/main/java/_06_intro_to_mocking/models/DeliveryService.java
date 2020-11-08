package _06_intro_to_mocking.models;

/*
This class would communicate with an API to facilitate the delivery of our donuts.  For simplicity's sake
the code below is truncated.
 */
public class DeliveryService {

    public boolean scheduleDelivery(Order order){
        //this method contains code that would contact the delivery service to dispatch a delivery driver to our shop
        boolean deliveryScheduled = true;
        return deliveryScheduled;
    }

}
