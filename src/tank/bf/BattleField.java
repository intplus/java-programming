package tank.bf;

import java.awt.*;

public class BattleField implements Drawable {

    public static final String BRICK = "B";
    public static final String EAGLE = "E";
    public static final String ROCK = "R";
    public static final String WATER = "W";

    private int bfWidth = 576;
    private int bfHeight = 576;

    private String[][] battleFieldTemplate = {
            {"B", "B", "B", " ", "B", " ", "B", "B", "B"},
            {"B", " ", " ", " ", " ", " ", " ", " ", "B"},
            {" ", " ", " ", "R", "R", " ", "B", "B", "B"},
            {"B", "B", "B", "B", "R", " ", "B", "B", "B"},
            {"B", "B", "B", "B", "R", "B", "B", "B", "B"},
            {" ", " ", " ", "R", "R", "R", " ", " ", " "},
            {" ", " ", " ", "R", "B", "B", " ", " ", " "},
            {"B", "B", "B", "R", "R", "R", " ", "B", "B"},
            {" ", " ", " ", "R", "E", " ", " ", " ", " "}
    };
//            {" ", " ", "R", " ", " ", " ", " ", " ", " "},
//            {" ", "R", "R", " ", "R", " ", " ", " ", " "},
//            {" ", "R", "R", " ", "R", "R", "R", " ", "R"},
//            {" ", " ", "B", " ", "R", " ", " ", " ", " "},
//            {" ", "R", "R", " ", "R", " ", " ", " ", " "},
//            {" ", "R", " ", "R", "R", "R", "R", "R", " "},
//            {"R", "R", "R", "R", "R", "R", " ", " ", " "},
//            {" ", " ", " ", "R", "R", "R", " ", " ", " "},
//            {" ", " ", " ", "R", "E", "B", " ", " ", " "}
//    };

    private BFObject[][] battleField = new BFObject[9][9];

    public BattleField() {
        drawBattleField();
    }

    public BattleField(String[][] battleField) {
        this.battleFieldTemplate = battleField;
        drawBattleField();
    }

    private String getQuadrantXY(int v, int h) {
        return (v - 1) * 64 + "_" + (h - 1) * 64;
    }

    private void drawBattleField() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String coordinates = getQuadrantXY(i + 1, j + 1);
                int separator = coordinates.indexOf("_");
                int y = Integer.parseInt(coordinates
                        .substring(0, separator));
                int x = Integer.parseInt(coordinates
                        .substring(separator + 1));

                String obj = battleFieldTemplate[i][j];
                BFObject bfObject;
                if (obj.equals(BRICK)) {
                    bfObject = new Brick(x, y);
                } else if (obj.equals(ROCK)) {
                    bfObject = new Rock(x, y);
                } else if (obj.equals(EAGLE)) {
                    bfObject = new Eagle(x, y);
                } else if (obj.equals(WATER)) {
                    bfObject = new Water(x, y);
                } else {
                    bfObject = new Blank(x, y);
                }
                battleField[i][j] = bfObject;
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        for (int j = 0; j < battleField.length; j++) {
            for (int k = 0; k < battleField.length; k++) {
                battleField[j][k].draw(g);
            }
        }
    }

    public void destroyObject(int v, int h) throws Exception{
        battleField[v][h].destroy();

    }

    public BFObject scanQuadrant(int v, int h) {
        return battleField[v][h];
    }
    public String scanQuadrant2(int v, int h) {
        return battleFieldTemplate[v][h];
    }

    @Override
    public String toString() {
        if (this.equals("Rock")) return "R";
        return "P";

    }

    public String getAggressorLocation() {
        return "128_0";
    }

    public int getBfWidth() {
        return bfWidth;
    }

    public int getBfHeight() {
        return bfHeight;
    }

}

