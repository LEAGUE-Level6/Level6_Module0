package _07_intro_to_mocking.models;

public class Engine {

    double displacementInLiters;

    int numberOfCylinders;

    int horsePower;

    int partNumber;

    int camshaftLobeSeparationAngleDegrees;

    public Engine(double displacementInLiters,
                  int numberOfCylinders,
                  int horsePower,
                  int partNumber,
                  int camshaftLobeSeparationAngle) {
        this.displacementInLiters = displacementInLiters;
        this.numberOfCylinders = numberOfCylinders;
        this.horsePower = horsePower;
        this.partNumber = partNumber;
        this.camshaftLobeSeparationAngleDegrees = camshaftLobeSeparationAngle;
    }

    public boolean start(){
        return true;
    }
}
