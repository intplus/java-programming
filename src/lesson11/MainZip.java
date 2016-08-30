package lesson11;

import java.io.File;
import java.io.IOException;

/**
 * Created by alpo123 on 11.07.16.
 */
public class MainZip {
    public static void main(String[] args) throws IOException {
        ZipUnzip zu = new ZipUnzip();
        File dir = new File("/Users/alpo123/Documents/job_environment/java-programming/test/");
        zu.pack(dir, "test.zip");
        zu.unpack("/Users/alpo123/Documents/job_environment/java-programming/test.zip", "/Users/alpo123/Documents/job_environment/java-programming/");
    }
}
