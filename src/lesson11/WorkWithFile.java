package lesson11;

import java.io.File;
import java.io.IOException;

public class WorkWithFile {
    public static void main(String[] args) throws IOException {
        File dir = new File("/Users/alpo123/Documents/job_environment/java-programming/test");

        dir.mkdirs();

        File file = new File("/Users/alpo123/Documents/job_environment/java-programming/test/test.txt");

        if(!file.exists()) {
            file.createNewFile();
        }

        System.out.println(file.getAbsolutePath());

        System.out.println(System.getProperty("user.dir"));



    }
}
