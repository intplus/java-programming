package lesson7.generic;

/**
 * Created by alpo123 on 06.05.16.
 */
public class JamesBondCar extends Car {

    private int currentSubmergeDepth;
    private boolean isGunOnBoard = true;
    private String manufacturer = "James Bond";

    public JamesBondCar() {

    }

    public JamesBondCar(int cd) {
        this.setCountDoor(cd);
    }

    public void submarge() {
        currentSubmergeDepth = 50;
        // Some code
    }
    public void surface() {
        // Some code
    }

    public int getCurrentSubmergeDepth() {
        return currentSubmergeDepth;
    }

    public void setCurrentSubmergeDepth(int currentSubmergeDepth) {
        this.currentSubmergeDepth = currentSubmergeDepth;
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

    @Override
    public String toString() {
        return manufacturer;
    }
}
