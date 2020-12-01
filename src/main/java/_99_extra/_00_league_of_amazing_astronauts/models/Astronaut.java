package _99_extra._00_league_of_amazing_astronauts.models;

public class Astronaut {

    String name;

    int age;

    boolean trained;

    public void train(){
        this.age += 1;
        trained = true;
    }

    public boolean isTrained() {
        return trained;
    }

}
