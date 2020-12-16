package _10_white_box_testing;

/*

You are now the proud owner of a donut shop.  This program helps you keep track of your business,
and you want to make sure that everything works correctly so that you don't lose money or customers.

Familiarize yourself with the classes in this package, then complete the tests in
src/test/java/_10_white_box_testing/MyDonutShopTest.java


 */

import _09_intro_to_white_box_testing.models.DeliveryService;
import _09_intro_to_white_box_testing.models.Order;
import _10_white_box_testing.models.BakeryService;
import _10_white_box_testing.models.PaymentService;

import java.util.ArrayList;
import java.util.List;

public class MyDonutShop {

    private boolean openForBusiness;

    private List<Order> orders = new ArrayList<>();

    private PaymentService paymentService;

    private DeliveryService deliveryService;

    private BakeryService bakeryService;

    public MyDonutShop(PaymentService paymentService,
                       DeliveryService deliveryService,
                       BakeryService bakeryService) {
        this.paymentService = paymentService;
        this.deliveryService = deliveryService;
        this.bakeryService = bakeryService;
    }

    public void openForTheDay() {
        bakeryService.makeDonuts();
        openForBusiness = true;
    }

    public void closeForTheDay(){
        bakeryService.throwAwayLeftovers();
        openForBusiness = false;
    }

    public void takeOrder(Order order) throws Exception {
        if (openForBusiness) {
            int donutsInOrder = order.getNumberOfDonuts();
            if (donutsInOrder <= bakeryService.getDonutsRemaining()) {
                addOrder(order);
            } else {
                throw new IllegalArgumentException("Insufficient donuts remaining");
            }
        }
        else{
            throw new IllegalStateException("Sorry we're currently closed");
        }
    }

    public void addOrder(Order order) throws Exception {
        if(paymentService.charge(order)){
            orders.add(order);
            bakeryService.removeDonuts(order.getNumberOfDonuts());
            if(order.isDelivery()){
                deliveryService.scheduleDelivery(order);
            }
        }
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void setDeliveryService(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

}