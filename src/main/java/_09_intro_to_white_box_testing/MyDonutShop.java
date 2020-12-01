package _09_intro_to_white_box_testing;

/*

You are now the proud owner of a donut shop.  This program helps you keep track of your business,
and you want to make sure that everything works correctly so that you don't lose money or customers.

Familiarize yourself with the classes in this package, then go to
src/test/java/_06_intro_to_mocking/MyDonutShopTest.java
for more information about unit testing this class.

 */

import _10_white_box_testing.DeliveryService;
import _09_intro_to_white_box_testing.models.Order;
import _09_intro_to_white_box_testing.models.PaymentService;

import java.util.ArrayList;
import java.util.List;

public class MyDonutShop {

    private boolean openForBusiness;

    private int donutsRemaining;

    private List<Order> orders = new ArrayList<>();

    PaymentService paymentService;

    DeliveryService deliveryService;

    public MyDonutShop(PaymentService paymentService, DeliveryService deliveryService) {
        this.paymentService = paymentService;
        this.deliveryService = deliveryService;
    }

    //    public static void main(String[] args) {
//        MyDonutShop myDonutShop = new MyDonutShop();
//        myDonutShop.openForTheDay();
//        myDonutShop.takeOrder(new Order("Patrick", 100));
//    }

    public void openForTheDay() {
        makeDonuts();
        openForBusiness = true;
    }

    public void closeForTheDay(){
        throwAwayLeftovers();
        openForBusiness = false;
    }

    public void takeOrder(Order order) {
        if (openForBusiness) {
            int donutsInOrder = order.getNumberOfDonuts();
            if (donutsInOrder <= donutsRemaining) {
                addOrder(order);
            } else {
                throw new IllegalArgumentException("Insufficient donuts remaining");
            }
        }
        else{
            throw new IllegalStateException("Sorry we're currently closed");
        }
    }

    public void addOrder(Order order){
        if(paymentService.charge(order)){
            orders.add(order);
            if(order.isDelivery()){
                deliveryService.scheduleDelivery(order);
            }
        }
    }

    public void makeDonuts(){
        this.donutsRemaining += 50;
    }

    public void throwAwayLeftovers() {
        this.donutsRemaining = 0;
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void setDeliveryService(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

}
