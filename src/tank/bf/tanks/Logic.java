package tank.bf.tanks;

import lesson5.search.AStar;
import tank.ActionField;
import tank.Direction;
import tank.bf.BattleField;
import tank.bf.Cell;
import tank.bf.Rock;
import tank.bf.Table;

import java.util.LinkedList;

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

    public void attackDefender() throws Exception {
        T34 defender = (T34) af.getDefender();
        Tiger aggressor = (Tiger) af.getAggressor();
        int xd = defender.getX()/64;
        int yd = defender.getY()/64;
        int xa = aggressor.getX()/64;
        int ya = aggressor.getY()/64;

        if (xa != xd) {
            aggressor.turn(xa > xd ? Direction.LEFT : Direction.RIGHT);
        }
        if (ya != yd) {
            aggressor.turn(ya > yd ? Direction.UP : Direction.DOWN);
        }
        aggressor.move();

    }

    public void searchWay(Tank t) {
        BattleField bf = new BattleField();

        for (int v = 0; v < 9; ++v) {
            for (int h = 0; h < 9; ++h) {
                if (bf.scanQuadrant(v, h) instanceof Rock) {
                    blockList.add(new Cell(h, v, true));
                }
                System.out.print(bf.scanQuadrant(v, h) + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cellList.add(new Cell(j, i, blockList.get(j, i).blocked));
            }
        }

        cellList.get(t.getX()/64, t.getY()/64).setAsStart();
        cellList.get(4, 8).setAsFinish();
        Cell start = cellList.get(t.getX()/64, t.getY()/64);
        Cell finish = cellList.get(4, 8);

        cellList.printp();

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
            System.out.println(rd);
            cellList.printp();
        } else {
            System.out.println("NO ROUTE");
        }
        System.out.println(rezList.size() + "this");
    }

}
