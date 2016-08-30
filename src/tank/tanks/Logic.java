package tank.tanks;

import lesson5.search.AStar;
import tank.ActionField;
import tank.Direction;
import tank.bf.BattleField;
import tank.bf.Cell;
import tank.bf.Rock;
import tank.bf.Table;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Created by alpo123 on 20.04.16.
 */
public class Logic {
    private BattleField bf;
    private ActionField af;
    private Tank tank;
    private T34 defender;
    private Tiger aggressor;

    Table<Cell> cellList = new Table<Cell>(AStar.WIDTH, AStar.HEIGHT);
    Table blockList = new Table(AStar.WIDTH, AStar.HEIGHT);
    LinkedList<Cell> openList = new LinkedList<Cell>();
    LinkedList<Cell> closedList = new LinkedList<Cell>();
    LinkedList<Cell> tmpList = new LinkedList<Cell>();
    private LinkedList<String> rezList = new LinkedList<>();

    public Logic() {

    }
    public Logic(BattleField bf, Tank tank) {
//        this.af = af;
        this.bf = bf;
        this.tank = tank;
    }

    public LinkedList<String> getRezList() {
        return rezList;
    }


    public void moveToQuadrant(Tank t) throws Exception {

        try {
            while (true) {
                String str = rezList.getLast();
                int x = Integer.parseInt(str.split("_")[0]);
                int y = Integer.parseInt(str.split("_")[1]);
                int xt = t.getX() / 64;
                int yt = t.getY() / 64;
//                System.out.println("tank = " + xt + " : " + yt);
//                System.out.println("move to " + x + " : " + y);

                if (x != xt) {
                    t.turn(x > xt ? Direction.RIGHT :
                            Direction.LEFT);
//                    System.out.print(t.getDirection());
                    return;
                }
                if (y != yt) {
                    t.turn(y > yt ? Direction.DOWN :
                            Direction.UP);
//                    System.out.print(t.getDirection());
                    return;
                }
                if (rezList.size() != 0) {
                    rezList.removeLast();
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("WIN");
            t.turn((Direction) actionsDirection[ran(4)]);
        }

    }
    public Object[] actionsDirection = new Object[] {
            Direction.UP,
            Direction.DOWN,
            Direction.RIGHT,
            Direction.LEFT
    };
    public int ran(int i) {
        Random r = new Random();
        return r.nextInt(i);
    }


    public void searchWay(Tank t, int targetX, int targetY) {
//        BattleField bf = new BattleField();
        rezList.clear();
        openList.clear();
        closedList.clear();
        tmpList.clear();

        for (int v = 0; v < 9; ++v) {
            for (int h = 0; h < 9; ++h) {
                if (bf.scanQuadrant(v, h) instanceof Rock) {
                    blockList.add(new Cell(h, v, true));
                }
//                System.out.print(bf.scanQuadrant(v, h) + " ");
            }
//            System.out.println();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cellList.add(new Cell(j, i, blockList.get(j, i).blocked));
            }
        }

        cellList.get(t.getX()/64, t.getY()/64).setAsStart();
        cellList.get(targetX, targetY).setAsFinish();
        Cell start = cellList.get(t.getX()/64, t.getY()/64);
        Cell finish = cellList.get(targetX, targetY);

//        cellList.printp();

        boolean found = false;
        boolean noroute = false;

        openList.push(start);

        while (!found && !noroute) {

            Cell min = openList.getFirst();
            for (Cell cell : openList) {
                if (cell.F < min.F) min = cell;
            }

            closedList.push(min);
            openList.remove(min);

            tmpList.clear();
            tmpList.add(cellList.get(min.x,     min.y - 1));
            tmpList.add(cellList.get(min.x + 1, min.y));
            tmpList.add(cellList.get(min.x,     min.y + 1));
            tmpList.add(cellList.get(min.x - 1, min.y));

            for (Cell neightbour : tmpList) {

                if (neightbour.blocked || closedList.contains(neightbour)) continue;

                if (!openList.contains(neightbour)) {
                    openList.add(neightbour);
                    neightbour.parent = min;
                    neightbour.H = neightbour.mandist(finish);
                    neightbour.G = start.price(min);
                    neightbour.F = neightbour.H + neightbour.G;
                    continue;
                }

                if (neightbour.G + neightbour.price(min) < min.G) {

                    neightbour.parent = min;
                    neightbour.H = neightbour.mandist(finish);
                    neightbour.G = start.price(min);
                    neightbour.F = neightbour.H + neightbour.G;
                }

            }

            if (openList.contains(finish)) {
                found = true;
            }

            if (openList.isEmpty()) {
                noroute = true;
            }
        }

        if (!noroute) {
            Cell rd = finish.parent;
            while (!rd.equals(start)) {
                rezList.add(rd.x + "_" + rd.y);

                rd.road = true;
                rd = rd.parent;
                if (rd == null) break;
            }
            rezList.addFirst(targetX + "_" + targetY);
//            System.out.println(rd);
//            cellList.printp();
        } else {
            System.out.println("NO ROUTE");
        }
//        System.out.println(rezList.size() + "this");
    }

}
