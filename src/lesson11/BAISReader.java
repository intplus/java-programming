package lesson11;

import java.io.ByteArrayInputStream;

public class BAISReader {
    public static void main(String[] args) {

        byte[] bytes = {63, 64, 65, 66, 67, -27, -128, 0};

        ByteArrayInputStream in = new ByteArrayInputStream(bytes);

        int i;
        while ((i = in.read()) != -1) {
            System.out.print(i);
            System.out.print(" ");
        }
      }
}
