package _07_intro_to_mocking.models;

import java.awt.*;

public class Car {

    String model;

    boolean insured;

    boolean registered;

    Color color;

    Engine engine;

    GasTank gasTank;

    public Car(Engine engine,
               GasTank gasTank) {
        this.model = "Camaro";
        this.insured = true;
        this.registered = true;
        this.color = Color.red;
        this.engine = engine;
        this.gasTank = gasTank;
    }

    public Car(String model,
               boolean insured,
               boolean registered,
               Color color,
               Engine engine,
               GasTank gasTank) {
        this.model = model;
        this.insured = insured;
        this.registered = registered;
        this.color = color;
        this.engine = engine;
    }

    public boolean start(){
        return engine.start();
    }

    public boolean fillTank(int octaneGrade){
        return gasTank.fill(octaneGrade);
    }

    public double getFuelLevel(){
        return gasTank.getFuelLevel();
    }

}
