package lesson11;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class FileCopy {

    public static void main(String[] args) throws IOException {
        String nameFile = "data.txt";
        File file = new File(nameFile);
        FileReader reader = new DefaultFileReader();
        System.out.println(reader.read(nameFile));

        copyFile(file);



    }
    public static void copyFile(File f) throws IOException {

        StringBuilder builder = new StringBuilder();
        InputStream in = Files.newInputStream(f.toPath());
        int i = 0;
        try (BufferedInputStream bis = new BufferedInputStream(in, 256)){

            while ((i = bis.read()) != -1){
                builder.append((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File copy = new File(f.getParent() + f.getName());

        OutputStream writer = Files.newOutputStream(copy.toPath(), StandardOpenOption.CREATE);

        try (BufferedOutputStream bos = new BufferedOutputStream(writer, 256)) {
            bos.write(builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
