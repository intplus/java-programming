package tank.tanks;

import tank.ActionField;
import tank.bf.BattleField;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RepeatTanks{

    private static int act;
    private static ArrayList list;

//    public static void main(String[] args) {
//
//        readFile();
//        for(int i = 0; i < list.size(); ++i) {
//            System.out.println(list.get(i));
//        }
//
//    }


    public void repeatGame() throws Exception{
        int choice = 1;

        ActionField af = new ActionField(choice);
        BattleField bf = new BattleField();
        T34 t34 = new T34(af, bf);
        BT7 bt7 = new BT7(bf);


    }
    public static ArrayList readFile(String nameFile){
        String line = null;
        list = new ArrayList();
        try(BufferedReader br = new BufferedReader(new FileReader(nameFile))) {
            while((line = br.readLine()) != null){
                list.add(line);

            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        return list;
    }

}
