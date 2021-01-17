package classwork.ioExample.fileExample.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationDemo {

    private static final String FILE_PATH = "G:\\JAVA ITSpace\\src\\classwork\\ioExample\\fileExample\\serialization\\file\\example.txt";


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // for writing student object to file

       Student student = new Student("Poxos","Poxosyan", 30,"Poxos@mail.ru");
//
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
//
//        objectOutputStream.writeObject(student);
//        objectOutputStream.close();


//        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_PATH));
//        Object object = objectInputStream.readObject();
//        Student student = (Student) object;
//        System.out.println(student);
//        System.out.println(student.getEmail());

//        Student student1 = new Student("Valod","Valodyan",15,"valod@gmail.com");
//        List<Student> students = new ArrayList<>();
//        students.add(student);
//        students.add(student1);
//
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
//        objectOutputStream.writeObject(students);
//        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_PATH));
        Object deserialization = objectInputStream.readObject();
        List<Student> st = (List<Student>) deserialization;
        objectInputStream.close();
        for (Student student2 : st) {
            System.out.println(student2);
        }

    }


}
