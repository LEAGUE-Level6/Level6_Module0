package _10_white_box_testing.models;

public class BakeryService {

    private int donutsRemaining;

    public void makeDonuts(){
        this.donutsRemaining += 50;
    }

    public void throwAwayLeftovers() {
        this.donutsRemaining = 0;
    }

    public void setDonutsRemaining(int donutsRemaining) {
        this.donutsRemaining = donutsRemaining;
    }

    public int getDonutsRemaining() {
        return this.donutsRemaining;
    }

    public void removeDonuts(int numberOfDonuts) {
        if(numberOfDonuts > donutsRemaining){
            throw new IllegalArgumentException("Insufficient Donuts Remaining");
        }
        donutsRemaining-=numberOfDonuts;
    }
}
