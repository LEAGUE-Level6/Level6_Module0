package _05_intro_to_mocking;

/*
You are now the proud owner of a donut shop.  This program helps you keep track of your business,
and you want to make sure that everything works correctly so that you don't lose money or customers.

 */

import _05_intro_to_mocking.models.DonutShop;

public class MyDonutShop {

    DonutShop donutShop = new DonutShop();

    public static void main(String[] args) {
        MyDonutShop myDonutShop = new MyDonutShop();
        myDonutShop.openForTheDay();
    }

    public void openForTheDay(){
        this.donutShop.makeDonuts();
        this.donutShop.setOpenForBusiness(true);
    }

    public void takeOrder(String customerName, int numberOfDonuts){


    }

}
