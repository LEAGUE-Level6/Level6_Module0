package _99_extra._00_league_of_amazing_astronauts;

import _99_extra._00_league_of_amazing_astronauts.models.Astronaut;
import _99_extra._00_league_of_amazing_astronauts.models.Rocketship;

public class LeagueOfAmazingAstronauts {

    Rocketship rocketship = new Rocketship();

    public LeagueOfAmazingAstronauts() {
    }

    public void prepareAstronaut(Astronaut astronaut){
        astronaut.train();
        rocketship.loadOccupant(astronaut);
    }

    public void launchRocket(String destination){
        if(rocketship.isLoaded()) {
            int milesToDesination = 0;
            if (destination.equals("Mars")) {
                milesToDesination = 68_000_000;
            } else {
                throw new IllegalArgumentException("Destination is unavailable");
            }
            rocketship.setDestination(destination, milesToDesination);
            rocketship.launch();
        }
        else{
            throw new IllegalStateException("Rocketship is not loaded");
        }
    }

    public void setRocketship(Rocketship rocketship) {
        this.rocketship = rocketship;
    }
}
