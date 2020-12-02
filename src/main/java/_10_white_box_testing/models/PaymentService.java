package _10_white_box_testing.models;

import _09_intro_to_white_box_testing.models.Order;

/*
This class would communicate with an API to make actual charges to the customers' cards.  The Stripe API is
one was to accomplish this in the real world, but for simplicity's sake the code below is truncated.
 */
public class PaymentService {

    public boolean charge(Order order){
        //this method contains code that would connect with an API to charge the customers card.
        return true;
    }

    public double getTotalSales(){
        //this method contains code that would connect with an API to retrieve the total sales for the shop
        return 1_000_000;
    }

}
