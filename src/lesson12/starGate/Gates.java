package lesson12.starGate;


import java.awt.*;

public class Gates {
    private int topX;
    private int topY;
    private int bottomX;
    private int bottomY;
    private Color c;
    private boolean isOpen;
    private int openTopY = 20;
    private int openBottomY = 190;
    private int topWidht;
    private int bottomWidth;
    private int doorHeight;
    private int closeTopY = 50;
    private int closeBottomY = 150;

    public Gates() {
        this.isOpen = false;
        this.topX = 200;
        this.topY = 50;
        this.topWidht = 22;
        this.bottomX = 200;
        this.bottomY = 150;
        this.doorHeight = 100;
        this.bottomWidth = 20;
    }

    public int getTopX() {
        return topX;
    }

    public void setTopX(int topX) {
        this.topX = topX;
    }

    public int getTopY() {
        return topY;
    }

    public void setTopY(int topY) {
        this.topY = topY;
    }

    public Color getC() {
        return Color.RED;
    }

//    public void setC(Color c) {
//        this.c = c;
//    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public int getOpenTopY() {
        return openTopY;
    }

    public int getOpenBottomY() {
        return openBottomY;
    }

    public int getBottomX() {
        return bottomX;
    }

    public void setBottomX(int bottomX) {
        this.bottomX = bottomX;
    }

    public int getBottomY() {
        return bottomY;
    }

    public void setBottomY(int bottomY) {
        this.bottomY = bottomY;
    }

    public int getTopWidht() {
        return topWidht;
    }

    public int getBottomWidth() {
        return bottomWidth;
    }

    public int getDoorHeight() {
        return doorHeight;
    }

    public int getCloseTopY() {
        return closeTopY;
    }

    public int getCloseBottomY() {
        return closeBottomY;
    }
}
