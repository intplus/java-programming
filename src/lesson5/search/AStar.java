package lesson5.search;

import java.util.LinkedList;

public class AStar {
    public static int WIDTH = 9;
    public static int HEIGHT = 9;

    /**
     * Пример хуевой реализации алгоритма поиска пути А*
     * @param args нихуя
     */
    public static void main(String[] args) {
        // Создадим все нужные списки
        Table<Cell> cellList = new Table<Cell>(AStar.WIDTH, AStar.HEIGHT);
        Table blockList = new Table(AStar.WIDTH, AStar.HEIGHT);
        LinkedList<Cell> openList = new LinkedList<Cell>();
        LinkedList<Cell> closedList = new LinkedList<Cell>();
        LinkedList<Cell> tmpList = new LinkedList<Cell>();
        LinkedList<String> rezList = new LinkedList<>();

        // Создадим преграду
        blockList.add(new Cell(2, 0, true));
        blockList.add(new Cell(2, 1, true));
        blockList.add(new Cell(2, 2, false));
        blockList.add(new Cell(2, 3, true));
        blockList.add(new Cell(2, 4, true));
        blockList.add(new Cell(2, 5, true));

        blockList.add(new Cell(4, 3, true));
        blockList.add(new Cell(4, 4, true));
        blockList.add(new Cell(4, 5, true));
        blockList.add(new Cell(4, 6, true));
        blockList.add(new Cell(4, 7, true));
        blockList.add(new Cell(4, 2, true));
        blockList.add(new Cell(1, 5, true));
        blockList.add(new Cell(0, 5, true));

        // Заполним карту как-то клетками, учитывая преграду
        for (int i = 0; i < AStar.WIDTH; i++) {
            for (int j = 0; j < AStar.HEIGHT; j++) {
                cellList.add(new Cell(j, i, blockList.get(j, i).blocked));
            }
        }

        // Стартовая и конечная
        cellList.get(0, 4).setAsStart();
        cellList.get(8, 5).setAsFinish();
        Cell start = cellList.get(0, 4);
        Cell finish = cellList.get(8, 5);

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
            //System.out.println(openList);

            //c) Для каждой из соседних 8-ми клеток ...
            tmpList.clear();
//            tmpList.add(cellList.get(min.x - 1, min.y - 1));
            tmpList.add(cellList.get(min.x,     min.y - 1));
//            tmpList.add(cellList.get(min.x + 1, min.y - 1));
            tmpList.add(cellList.get(min.x + 1, min.y));
//            tmpList.add(cellList.get(min.x + 1, min.y + 1));
            tmpList.add(cellList.get(min.x,     min.y + 1));
//            tmpList.add(cellList.get(min.x - 1, min.y + 1));
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
        int i =0;
        while (openList.size() != 0) {
//            System.out.println(openList.getLast());
//            System.out.println(i++);
            System.out.println(closedList.get(i));
            openList.removeLast();
        }
//        System.out.println(openList);
//        System.out.println(closedList.get());

        //3) Сохраняем путь. Двигаясь назад от целевой точки, проходя от каждой точки к ее родителю до тех пор, пока не дойдем до стартовой точки. Это и будет наш путь.
        if (!noroute) {
            tmpList.clear();
            Cell rd = finish.parent;
            while (!rd.equals(start)) {
                rezList.add(rd.x + "_" + rd.y);
                System.out.println(rd.x + " : " + rd.y);
                rd.road = true;
                rd = rd.parent;
                if (rd == null) break;

            }
            cellList.printp();

        } else {
            System.out.println("NO ROUTE");
        }
        i = 0;
        System.out.println("list = " + rezList.size());
        while (rezList.size() != 0) {
            System.out.println(rezList.getLast());
            rezList.removeLast();
            i++;
        }

    }
}