package _99_extra._00_league_of_amazing_astronauts.models;

public class Rocketship {

    private double gallonsOfFuel;

    private boolean rocketsIgnited;

    private String destination;

    private int milesToDestination;

    private Astronaut astronaut;

    public Rocketship() {
    }

    void refuel(){
        this.gallonsOfFuel = 143_000;
    }

    public void launch(){
        this.rocketsIgnited = true;
        while(milesToDestination > 0){
            milesToDestination -= 500;
            gallonsOfFuel -= 1;
        }
    }

    public void setDestination(String destination, int milesToDesination) {
        this.destination = destination;
        this.milesToDestination = milesToDesination;
    }

    public void loadOccupant(Astronaut astronaut) {
        if(astronaut.isTrained()){
            this.astronaut = astronaut;
        }
        else{
            throw new IllegalArgumentException("This astronaut is not trained");
        }

    }

    public boolean isLoaded(){
        return this.astronaut == null;
    }

    public Astronaut getAstronaut() {
        return astronaut;
    }

}
