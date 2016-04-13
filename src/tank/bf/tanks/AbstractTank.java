package tank.bf.tanks;

// new version

import lesson5.search.AStar;
import tank.Direction;
import tank.bf.BattleField;
import tank.bf.Cell;
import tank.bf.Rock;
import tank.bf.Table;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public abstract class AbstractTank implements Tank {

    Table<Cell> cellList = new Table<Cell>(AStar.WIDTH, AStar.HEIGHT);
    Table blockList = new Table(AStar.WIDTH, AStar.HEIGHT);
    LinkedList<Cell> openList = new LinkedList<Cell>();
    LinkedList<Cell> closedList = new LinkedList<Cell>();
    LinkedList<Cell> tmpList = new LinkedList<Cell>();
    public LinkedList<String> rezList = new LinkedList<>();

    protected int x;
    protected int y;


    protected Direction direction;

    private BattleField bf;
    private int speed = 5;
    protected int movePath = 1;

    protected Color tankColor;
    protected Color towerColor;
    protected boolean destroyed;

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public AbstractTank(BattleField bf) {
        this(bf, 128, 512, Direction.UP);

    }
    public AbstractTank(BattleField bf, int x, int y, Direction direction) {
        this.bf = bf;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.destroyed = false;

    }

    public void turn(Direction direction) throws Exception{
        this.direction = direction;
    }

    public void move(){

    }
    public int ran(int i) {
        Random r = new Random();
        return r.nextInt(i);
    }


    public Bullet fire() {
        int bulletX = -100;
        int bulletY = -100;
        if (direction == Direction.UP) {
            bulletX = x + 25;
            bulletY = y - 64;
        } else if (direction == Direction.DOWN) {
            bulletX = x + 25;
            bulletY = y + 64;
        } else if (direction == Direction.LEFT) {
            bulletX = x - 64;
            bulletY = y + 25;
        } else if (direction == Direction.RIGHT) {
            bulletX = x + 64;
            bulletY = y + 25;
        }
        return new Bullet(bulletX, bulletY, direction);
    }

    public void clean() throws Exception {

    }
    public void updateX (int x) {
        this.x += x;
    }
    public void updateY (int y) {
        this.y += y;
    }

    public void draw(Graphics g) {
        if (!destroyed) {
            g.setColor(tankColor);
            g.fillRect(this.getX() + 20, this.getY() + 20, 24, 24);

            g.setColor(towerColor);
            if (getDirection() == Direction.UP) {
                g.fillRect(getX() + 12, getY() + 16, 8, 32);
                g.fillRect(getX() + 44, getY() + 16, 8, 32);
                g.fillRect(getX() + 28, getY() + 4, 8, 34);
            }
            if (getDirection() == Direction.DOWN) {
                g.fillRect(getX() + 12, getY() + 16, 8, 32);
                g.fillRect(getX() + 44, getY() + 16, 8, 32);
                g.fillRect(getX() + 28, getY() + 26, 8, 34);
            }
            if (getDirection() == Direction.LEFT) {
                g.fillRect(getX() + 16, getY() + 12, 32, 8);
                g.fillRect(getX() + 16, getY() + 44, 32, 8);
                g.fillRect(getX() + 4, getY() + 28, 34, 8);
            }
            if (getDirection() == Direction.RIGHT) {
                g.fillRect(getX() + 16, getY() + 12, 32, 8);
                g.fillRect(getX() + 16, getY() + 44, 32, 8);
                g.fillRect(getX() + 26, getY() + 28, 34, 8);
            }
        }
    }
    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    public void destroy() {
        destroyed = true;
    }
    public int getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public int getMovePath() {
        return movePath;
    }

    public void searchWay(Tank t) {



        for (int v = 0; v < 9; ++v) {
            for (int h = 0; h < 9; ++h) {
                if (bf.scanQuadrant2(v, h).equals("R")) {
                    blockList.add(new Cell(h, v, true));
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cellList.add(new Cell(j, i, blockList.get(j, i).blocked));
            }
        }

        // Стартовая и конечная
        cellList.get(t.getX()/64, t.getY()/64).setAsStart();
        cellList.get(4, 8).setAsFinish();
        Cell start = cellList.get(t.getX()/64, t.getY()/64);
        Cell finish = cellList.get(4, 8);

        cellList.printp();

        // Фух, начинаем
        boolean found = false;
        boolean noroute = false;

        //1) Добавляем стартовую клетку в открытый список.
        openList.push(start);

        //2) Повторяем следующее:
        while (!found && !noroute) {
            //a) Ищем в открытом списке клетку с наименьшей стоимостью F. Делаем ее текущей клеткой.
            Cell min = openList.getFirst();
            for (Cell cell : openList) {
                // тут я специально тестировал, при < или <= выбираются разные пути,
                // но суммарная стоимость G у них совершенно одинакова. Забавно, но так и должно быть.
                if (cell.F < min.F) min = cell;
            }

            //b) Помещаем ее в закрытый список. (И удаляем с открытого)
            closedList.push(min);
            openList.remove(min);
//            System.out.println(closedList);

            //c) Для каждой из соседних 4x клеток ...
            tmpList.clear();
            tmpList.add(cellList.get(min.x,     min.y - 1));
            tmpList.add(cellList.get(min.x + 1, min.y));
            tmpList.add(cellList.get(min.x,     min.y + 1));
            tmpList.add(cellList.get(min.x - 1, min.y));

            for (Cell neightbour : tmpList) {
                //Если клетка непроходимая или она находится в закрытом списке, игнорируем ее. В противном случае делаем следующее.
                if (neightbour.blocked || closedList.contains(neightbour)) continue;

                //Если клетка еще не в открытом списке, то добавляем ее туда. Делаем текущую клетку родительской для это клетки. Расчитываем стоимости F, G и H клетки.
                if (!openList.contains(neightbour)) {
                    openList.add(neightbour);
                    neightbour.parent = min;
                    neightbour.H = neightbour.mandist(finish);
                    neightbour.G = start.price(min);
                    neightbour.F = neightbour.H + neightbour.G;
                    continue;
                }

                // Если клетка уже в открытом списке, то проверяем, не дешевле ли будет путь через эту клетку. Для сравнения используем стоимость G.
                if (neightbour.G + neightbour.price(min) < min.G) {
                    // Более низкая стоимость G указывает на то, что путь будет дешевле. Эсли это так, то меняем родителя клетки на текущую клетку и пересчитываем для нее стоимости G и F.
                    neightbour.parent = min; // вот тут я честно хз, надо ли min.parent или нет
                    neightbour.H = neightbour.mandist(finish);
                    neightbour.G = start.price(min);
                    neightbour.F = neightbour.H + neightbour.G;
                }

                // Если вы сортируете открытый список по стоимости F, то вам надо отсортировать свесь список в соответствии с изменениями.
            }

            //d) Останавливаемся если:
            //Добавили целевую клетку в открытый список, в этом случае путь найден.
            //Или открытый список пуст и мы не дошли до целевой клетки. В этом случае путь отсутствует.

            if (openList.contains(finish)) {
                found = true;
            }

            if (openList.isEmpty()) {
                noroute = true;
            }
        }


        //3) Сохраняем путь. Двигаясь назад от целевой точки, проходя от каждой точки к ее родителю до тех пор, пока не дойдем до стартовой точки. Это и будет наш путь.
        if (!noroute) {
            Cell rd = finish.parent;
            while (!rd.equals(start)) {
//                System.out.println(rd.x + "_" + rd.y);
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
        System.out.println(rezList.size());
    }

}
