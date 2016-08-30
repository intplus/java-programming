package lesson11;


import java.io.File;

public class LauncherFile {
    public static void main(String[] args) {

        File file = new File("test.txt");

        System.out.println(System.getProperty("user.dir"));
        System.out.println(File.separator);
        System.out.println(File.pathSeparator);
        System.out.println("---------");

        for (File f : File.listRoots()) {
            System.out.println(f.getAbsolutePath());
        }

        System.out.println(getRelativeFileDir());
        System.out.println(getFilePath());


    }

    public static String getFilePath() {
        String path = "src/com/kademika/day11/io/files";
        path = path.replace("/", File.separator);

        File thisFile = new File(path, LauncherFile.class.getSimpleName() + ".java");

        return thisFile.getAbsolutePath();
    }

    public static String getRelativeFileDir() {
        String path = "src/com/kademika/day11/io/files";
        return path.replace("/", File.separator);
    }


}
