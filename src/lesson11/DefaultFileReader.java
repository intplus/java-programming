package lesson11;

import java.io.IOException;
import java.io.FileInputStream;

public class DefaultFileReader implements FileReader{

    public String read(String fileName) {
        StringBuilder builder = new StringBuilder();

        try (FileInputStream fis = new FileInputStream(fileName)) {

            int i;
            while ((i = fis.read()) != -1) {
                builder.append((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
