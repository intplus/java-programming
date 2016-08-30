package lesson11.example;

import java.io.*;

public class DataIO {

    public static void main(String[] args) throws Exception {
        writeToFile("output.dat");
        readFromFile("output.dat");
    }

    public static void readFromFile(String file) throws Exception {
        try
                (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)))
                ) {
            System.out.println(dis.readInt());
            System.out.println(dis.readFloat());
            System.out.println(dis.readChar());
        }
    }

    public static void writeToFile(String file) throws Exception {
        try (
                DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))
                ) {
            dos.writeInt(10);
            dos.writeFloat(25.3f);
            dos.writeChar('a');
        }
    }
}
