package _07_intro_to_mocking.models;

public class GasTank {

    double fuelLevelGallons = 12;

    public boolean fill(int octaneGrade){
        return true;
    }

    public double getFuelLevel() {
        return this.fuelLevelGallons;
    }

}
