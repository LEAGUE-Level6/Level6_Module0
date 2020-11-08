package _06_intro_to_mocking.models;

/*
This class would communicate with an API to make actual charges to the customers' cards.  The Stripe API is
one was to accomplish this in the real world, but for simplicity's sake the code below is truncated.
 */
public class PaymentService {

    public boolean charge(Order order){
        //this method contains code that would connect with an API to charge the customers card.
        boolean paymentSuccessful = true;
        return paymentSuccessful;
    }

    public double getTotalSales(){
        //this method contains code that would connect with an API to retrieve the total sales for the shop
        double totalSales = 1_000_000;
        return totalSales;
    }

}
