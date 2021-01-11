package classwork.ioExample.ioExample;

import java.io.*;

public class FileReadAndWrite {

    private static final String FILE_PATH = "G:\\JAVA ITSpace\\src\\classwork\\ioExample\\ioExample\\file\\example.txt";

    public static void main(String[] args) throws IOException {
        //    write();
        read();
    }

    public static void write() throws IOException {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(FILE_PATH))) {
            bf.append("Hello from Java \r \n");
            bf.append("Hello !!!!!!!!!");
        }
    }

    public static void read() {
        try (BufferedReader inputStream = new BufferedReader(new FileReader(FILE_PATH))) {
            int c;
            while ((c = inputStream.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
