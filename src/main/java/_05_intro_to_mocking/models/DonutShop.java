package _05_intro_to_mocking.models;

import java.util.List;

public class DonutShop {

    private boolean openForBusiness;

    private int donutsRemaining;

    private List<Order> orders;

    public DonutShop() {
    }

    public void makeDonuts(){
        this.donutsRemaining += 50;
    }

    public int getDonutsRemaining() {
        return donutsRemaining;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public boolean isOpenForBusiness() {
        return openForBusiness;
    }

    public void setOpenForBusiness(boolean openForBusiness) {
        this.openForBusiness = openForBusiness;
    }

}
