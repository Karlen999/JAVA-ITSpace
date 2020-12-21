package classwork;

import java.util.Scanner;

public class StudentTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DynamicArrayForStudent dataStorage = new DynamicArrayForStudent();

        boolean isRun = true;
        while (isRun) {
            System.out.println("Please input 0 for exit");
            System.out.println("Please input 1 for add student");
            System.out.println("Please input 2 for print student");
            System.out.println("Please input 3 for search by name");
            String command = scanner.nextLine();

            switch (command) {
                case "0":
                    isRun = false;
                    break;
                case "1":
                    System.out.println("Please input name,surname,age");
                    String name = scanner.nextLine();
                    String surName = scanner.nextLine();
                    int age = Integer.parseInt(scanner.nextLine());
                    Student student = new Student(name, surName, age);
                    dataStorage.add(student);
                    break;
                case "2":
                    dataStorage.print();
                    break;
                case "3":
                    System.out.println("Please input name");
                    String studentName = scanner.nextLine();
                    dataStorage.searchByName(studentName);
                    break;
                default:
                    System.out.println("Wrong command");
            }
        }

    }
}
