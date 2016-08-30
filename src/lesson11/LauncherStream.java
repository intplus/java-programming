package lesson11;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class LauncherStream {
    public static void main(String[] args) throws IOException {
        File file = new File("data.txt");

        if(!file.exists()) {
            file.createNewFile();
        }

        try {
            printStreamData(Files.newInputStream(file.toPath(), StandardOpenOption.READ));
        } catch (IOException e){
            e.printStackTrace();
        }

    }
    private static void printStreamData(InputStream in) throws IOException{
        int data = in.read();
        char ch;

        while (data != -1) {
            ch = (char) data;
            System.out.print(ch);
            data = in.read();
        }
        in.close();

    }
}

