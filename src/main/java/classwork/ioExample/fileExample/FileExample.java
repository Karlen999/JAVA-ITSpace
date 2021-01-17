package classwork.ioExample.fileExample;


import java.io.File;
import java.io.IOException;

public class FileExample {

    public static void main(String[] args) throws IOException {

        File file = new File("G:\\JAVA ITSpace\\src\\classwork\\folder\\");
//        System.out.println(file.exists());
//        System.out.println(file.isDirectory());
//       if (!file.exists()){
//            boolean newFile = file.createNewFile();
//            System.out.println(newFile);
//        }
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println("Name " + f.getName());
            System.out.println("length " + f.length());
            System.out.println("isFile " + f.isFile());
        }
    }
}
