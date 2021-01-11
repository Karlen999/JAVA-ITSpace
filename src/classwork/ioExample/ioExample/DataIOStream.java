package classwork.ioExample.ioExample;

import java.io.*;

public class DataIOStream {

    private static final String FILE_PATH = "G:\\JAVA ITSpace\\src\\classwork\\ioExample\\ioExample\\file\\example.txt";

    public static void main(String[] args) throws IOException {

    // write();
       read();

    }


    public static void write() throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(FILE_PATH))) {
            dataOutputStream.write(33);
            dataOutputStream.write(55);
            dataOutputStream.writeBoolean(false);
            dataOutputStream.writeUTF("բարև");
        }
    }

    public static void read() throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(FILE_PATH))) {
            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readUTF());
        }
    }
}

