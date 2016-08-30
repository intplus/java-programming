package lesson11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class GetSearchTest {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.dssl.ru/");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(url.openConnection().getInputStream(), "UTF-8"));
        while (true) {
            String line = reader.readLine();
            if (line == null)
                break;
            System.out.println(line);
        }
    }
}
