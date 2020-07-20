package _06_intro_to_mocking;

/*

You are now the proud owner of a donut shop.  This program helps you keep track of your business,
and you want to make sure that everything works correctly so that you don't lose money or customers.

 */

import _06_intro_to_mocking.models.DonutShop;
import _06_intro_to_mocking.models.Order;

public class MyDonutShop {

    DonutShop donutShop = new DonutShop();

//    public static void main(String[] args) {
//        MyDonutShop myDonutShop = new MyDonutShop();
//        myDonutShop.openForTheDay();
//        myDonutShop.takeOrder(new Order("Patrick", 100));
//    }

    public void openForTheDay() {
        this.donutShop.makeDonuts();
        this.donutShop.setOpenForBusiness(true);
    }

    public void closeForTheDay(){
        this.donutShop.throwAwayLeftovers();
        this.donutShop.setOpenForBusiness(false);
    }

    public void takeOrder(Order order) {
        if (donutShop.isOpenForBusiness()) {
            int donutsInOrder = order.getNumberOfDonuts();
            int donutsRemaining = donutShop.getDonutsRemaining();
            if (donutsInOrder <= donutsRemaining) {
                donutShop.addOrder(order);
            } else {
                throw new IllegalArgumentException("Insufficient donuts remaining");
            }
        }
        else{
            throw new IllegalStateException("Sorry we're currently closed");
        }
    }

    public void setDonutShop(DonutShop donutShop) {
        this.donutShop = donutShop;
    }

}
