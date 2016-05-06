package lesson5.AStar;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        boolean [][] map = new boolean[9][9];
        for (int i = 0; i < 9; ++i){
            Arrays.fill(map[i], true);
        }
        Pathfinder.generate(0,0,512,512,map);
    }
}
