package scooterGarage.garageForce;

public class GarageForce {
    private int [] scooters;
    private int C;
    private int P;

    public GarageForce(){}

    public GarageForce(int[] scooters, int c, int p) {
        this.scooters = scooters;
        C = c;
        P = p;
    }

    public int[] getScooters() {
        return scooters;
    }

    public void setScooters(int[] scooters) {
        this.scooters = scooters;
    }

    public int getC() {
        return C;
    }

    public void setC(int c) {
        C = c;
    }

    public int getP() {
        return P;
    }

    public void setP(int p) {
        P = p;
    }
}
