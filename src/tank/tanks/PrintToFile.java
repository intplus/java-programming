package tank.tanks;

import java.io.*;

public class PrintToFile {

    private static boolean isNewGame = true;
    private static int count = 0;

    public static void printToFile(String fileName, String str) throws IOException {
        //Определяем файл
        File file = new File(fileName);

        try {
            //проверяем, что если файл не существует то создаем его
            if(!file.exists()){
                file.createNewFile();
            }

            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                //Записываем текст у файл
                out.print(str);
            } finally {
                //После чего мы должны закрыть файл
                //Иначе файл не запишется
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(String nameFile, String newText) throws IOException {

        if (isNewGame || count < 2) {
            printToFile(nameFile, "");
            isNewGame = false;
            count++;
        }

        File file = new File(nameFile);
        if(!file.exists()){
            file.createNewFile();
        }
        exists(nameFile);
        StringBuilder sb = new StringBuilder();
        String oldFile = read(file, nameFile);
        sb.append(oldFile);
        sb.append(newText);
        printToFile(nameFile, sb.toString());
    }

    private static void exists(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
    }

    public static String read(File file, String fileName) throws FileNotFoundException{
        //Этот спец. объект для построения строки
        StringBuilder sb = new StringBuilder();

        exists(fileName);

        try {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        //Возвращаем полученный текст с файла
        return sb.toString();
    }
    public static void delete(String nameFile) throws FileNotFoundException{
        exists(nameFile);
        new File(nameFile).delete();
    }
}
