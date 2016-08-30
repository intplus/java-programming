package lesson11;

/**
 * Created by alpo123 on 02.07.16.
 */
public class LauncherByte {
    public static void main(String[] args) {

        printBytes(0, 127);

        printBytes(128, 255);

        printBytes(-256, 0);

    }
    private static void printBytes(int start, int finish) {
        System.out.println();

        byte b;
        int num;
        for (num = start; num <= finish; num++) {
            b = (byte) num;

            System.out.print(b);
            System.out.print(" ");
        }

        System.out.println();
        System.out.println();

    }

}
