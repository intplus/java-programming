package lesson7.generic;

/**
 * Created by alpo123 on 06.05.16.
 */
public class BatmanCar extends Car {

    private int abilityFly;
    private boolean isGunOnBoard = true;
    private String manufacturer = "BatMan";

    public BatmanCar() {

    }

    public void fly() {
        abilityFly = 50;
        // Some code
    }
    public void surface() {
        // Some code
    }

    public boolean isGunOnBoard() {
        return isGunOnBoard;
    }

    public void setGunOnBoard(boolean gunOnBoard) {
        isGunOnBoard = gunOnBoard;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getAbilityFly() {
        return abilityFly;
    }

    public void setAbilityFly(int abilityFly) {
        this.abilityFly = abilityFly;
    }

    @Override
    public String toString() {
        return manufacturer;
    }
}
