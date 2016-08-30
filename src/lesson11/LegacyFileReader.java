package lesson11;

import java.io.IOException;
import java.io.FileInputStream;

public class LegacyFileReader implements FileReader {

    public String read (String fileName) {
        StringBuilder builder = new StringBuilder();
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(fileName);

            int i;
            while ((i = fis.read()) != -1) {
                builder.append((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {

                }
            }
        }
        return builder.toString();
    }
}
