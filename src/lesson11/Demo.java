package lesson11;

public class Demo {

    public static void main(String[] args) {
        String fileName = "data.txt";

        FileWriter writer = new DefaultFileWriter();
        writer.write("Ilove programming!", fileName);

        FileReader reader = new DefaultFileReader();
        System.out.println(reader.read(fileName));

        writer = new DefaultFileWriter();
        writer.write("Me too", fileName);

        reader = new DefaultFileReader();
        System.out.println(reader.read(fileName));
    }
}
