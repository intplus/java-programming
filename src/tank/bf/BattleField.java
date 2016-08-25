package tank.bf;

import java.awt.*;
import java.util.Random;

public class BattleField implements Drawable {

    public static final String BRICK = "B";
    public static final String EAGLE = "E";
    public static final String ROCK = "R";
    public static final String WATER = "W";

    private int bfWidth = 576;
    private int bfHeight = 576;

    private String[][] battleFieldTemplate = {
            {" ", " ", "R", "W", " ", "W", "B", "B", " "},
            {" ", "R", " ", "W", "W", "W", " ", " ", "B"},
            {" ", " ", "R", "W", "R", "W", "B", "B", "B"},
            {"R", "B", "W", "W", "R", " ", "B", "B", "B"},
            {"B", "B", "B", "B", "B", "W", "B", "B", "B"},
            {" ", " ", " ", "R", "B", "R", "W", " ", " "},
            {"W", "W", "W", "R", "B", "B", " ", " ", "B"},
            {"R", " ", "R", "R", "B", "R", " ", "B", " "},
            {" ", " ", "R", "B", "E", "R", " ", " ", " "}
    };
//            {" ", " ", "R", " ", "B", " ", " ", " ", " "},
//            {" ", "R", "R", " ", "R", " ", " ", " ", " "},
//            {" ", "R", "R", " ", "R", "R", "R", " ", "R"},
//            {"W", "B", "B", " ", "R", "W", "W", "W", "W"},
//            {"W", "R", "R", " ", "R", "W", "W", "W", "W"},
//            {"W", "R", " ", " ", "R", "R", "R", "R", " "},
//            {"R", "R", " ", "R", "R", "R", " ", " ", " "},
//            {" ", " ", " ", "R", "R", "R", " ", " ", " "},
//            {" ", " ", " ", "R", "E", "B", " ", " ", " "}
//    };
//            {" ", " ", " ", " ", " ", " ", " ", " ", " "},
//            {" ", " ", " ", " ", " ", " ", " ", " ", " "},
//            {" ", " ", " ", " ", " ", " ", " ", " ", " "},
//            {" ", " ", " ", " ", " ", " ", " ", " ", " "},
//            {" ", " ", " ", " ", " ", " ", " ", " ", " "},
//            {" ", " ", " ", " ", " ", " ", " ", " ", " "},
//            {" ", " ", " ", " ", " ", " ", " ", " ", " "},
//            {" ", " ", " ", " ", " ", " ", " ", " ", " "},
//            {" ", " ", " ", " ", " ", " ", " ", " ", " "},
//    };

    private BFObject[][] battleField = new BFObject[9][10];

    public BattleField() {
//        randomBattleField();
        drawBattleField();
    }

    public BattleField(String[][] battleField) {
        this.battleFieldTemplate = battleField;
        drawBattleField();
    }

    private String getQuadrantXY(int v, int h) {
        return (v - 1) * 64 + "_" + (h - 1) * 64;
    }

    private void randomBattleField() {
        System.out.println();
        System.out.println();

        Random ran = new Random();
        for (int i = 0; i < 9; ++i) {
            for (int k = 0; k < 9; ++k) {
                int r = ran.nextInt(4);
                switch (r) {
                    case 0:
                        battleFieldTemplate[i][k] = "B";
                        break;
                    case 1:
                        battleFieldTemplate[i][k] = "R";
                        break;
                    case 2:
                        battleFieldTemplate[i][k] = "W";
                        break;
                    case 3:
                        battleFieldTemplate[i][k] = " ";
                        break;

                }
                System.out.print(battleFieldTemplate[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------------------");
        battleFieldTemplate[8][4] = "E";
        battleFieldTemplate[0][0] = " ";
        battleFieldTemplate[7][8] = " ";
    }

    private void drawBattleField() {
//        randomBattleField();
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
        battleField[0][9] = new Brick(0, 9);

    }

    @Deprecated
    public String[][] getBattleFieldTemplate() {
        return battleFieldTemplate;
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

//    @Override
//    public String toString() {
//        if (this.equals("Rock")) return "R";
//        return "P";
//
//    }

    public String getAggressorLocation() {
        String str = "0_512";
        Random r = new Random();
        int ran = r.nextInt(3);
        switch (ran) {
            case 0:
                str = "0_0";
                break;

            case 1:
                str = "0_320";
                break;
        }
        return str;
    }

    public int getBfWidth() {
        return bfWidth;
    }

    public int getBfHeight() {
        return bfHeight;
    }

}

