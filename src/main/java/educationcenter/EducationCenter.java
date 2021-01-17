package educationcenter;

import educationcenter.exception.DuplicateLessonException;
import educationcenter.model.Lesson;
import educationcenter.model.Student;
import educationcenter.storage.LessonStorage;
import educationcenter.storage.StudentStorage;

import java.util.Scanner;

public class EducationCenter implements Commands {

    private static Scanner scanner = new Scanner(System.in);
    private static LessonStorage lessonStorage = new LessonStorage();
    private static StudentStorage studentStorage = new StudentStorage();

    public static void main(String[] args) {


        boolean isRun = true;
        while (isRun) {
            printCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please input number!");
                command = -1;
            }
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case ADD_LESSON:
                    addLesson();
                    break;
                case PRINT_STUDENT:
                    studentStorage.print();
                    break;
                case PRINT_LESSON:
                    lessonStorage.print();
                    break;
                case SEARCH_STUDENT_BY_NAME:
                    searchStudentByName();
                    break;
                case SEARCH_LESSON_BY_NAME:
                    searchLessonByName();
                    break;
                case SEARCH_STUDENT_BY_LESSON_NAME:
                    searchStudentsByLessonName();
                    break;
                case CHANGE_STUDENT_LESSON:
                    changeStudentLesson();
                    break;
                case CHANGE_STUDENT_PHONE:
                    changeStudentPhone();
                    break;
                default:
                    System.out.println("Wrong command !!!");
            }
        }
    }

    private static void printCommands() {
        System.out.println("Please input " + EXIT + " for exit");
        System.out.println("Please input " + ADD_STUDENT + " for add student");
        System.out.println("Please input " + ADD_LESSON + " for add lesson");
        System.out.println("Please input " + PRINT_STUDENT + " for print student");
        System.out.println("Please input " + PRINT_LESSON + " for print lesson");
        System.out.println("Please input " + SEARCH_STUDENT_BY_NAME + " for search student by name");
        System.out.println("Please input " + SEARCH_LESSON_BY_NAME + " for search lesson by name");
        System.out.println("Please input " + SEARCH_STUDENT_BY_LESSON_NAME + " for search students by lesson name");
        System.out.println("Please input " + CHANGE_STUDENT_LESSON + " for change student lesson");
        System.out.println("Please input " + CHANGE_STUDENT_PHONE + " for change student phone");
    }

    private static void addStudent() {
        if (lessonStorage.isEmpty()) {
            System.out.println("Please add lesson first");
            addLesson();
        } else {
            System.out.println("Please select lesson [name] from list");
            lessonStorage.printNames();
            String lessonName = scanner.nextLine();
            Lesson lesson = lessonStorage.getByName(lessonName);
            if (lesson == null) {
                System.out.println("Please select lesson from list");
                addStudent();
            } else {
                System.out.println("Please input  name, surname, phone, email");
                String studentDataStr = scanner.nextLine();
                String[] studentData = studentDataStr.split(",");
                Student student = new Student(studentData[0], studentData[1], studentData[2],
                        studentData[3], lesson);
                studentStorage.add(student);
                System.out.println("Student was added!");
            }

        }
    }

    private static void addLesson() {
        System.out.println("Please input  name, duration, price, lecturerName");
        try {
            String lessonDaraStr = scanner.nextLine();
            String[] lessonData = lessonDaraStr.split(",");
            if (lessonData.length == 4) {
                String name = lessonData[0];
                int duration = Integer.parseInt(lessonData[1]);
                int price = Integer.parseInt(lessonData[2]);
                String lecturerName = lessonData[3];
                Lesson lesson = new Lesson(name, duration, price, lecturerName);
                lessonStorage.add(lesson);
                System.out.println("Lesson was added!");

            } else {
              System.out.println("Please input valid data!!!");
              addLesson();
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Incorrect value! Please try again");
            addLesson();
        } catch (DuplicateLessonException e){
            System.out.println(e.getMessage());
        }
    }

    private static void searchStudentByName() {
        String studentName = scanner.nextLine();
        studentStorage.searchStudentByName(studentName);
    }

    private static void searchLessonByName() {
        String lessonName = scanner.nextLine();
        lessonStorage.searchLessonByName(lessonName);
    }

    private static void searchStudentsByLessonName() {
        String lessonName = scanner.nextLine();
        Lesson name = lessonStorage.getByName(lessonName);
        if (name == null) {
            System.out.println("Incorrect lesson name");
            searchStudentsByLessonName();
        } else {
            studentStorage.searchStudentsByLessonName(name);
        }
    }

    private static void changeStudentLesson() {
        System.out.println("Input Student email");
        String studentName = scanner.nextLine();
        Student name = studentStorage.getByEmail(studentName);
        if (name == null) {
            System.out.println("Incorrect name");
            changeStudentLesson();
        } else {
            System.out.println("Input lesson for change");
            String lessonName = scanner.nextLine();
            Lesson lesson = lessonStorage.getByName(lessonName);
            name.setLesson(lesson);
        }
    }

    private static void changeStudentPhone() {
        System.out.println("Input Student email");
        String studentName = scanner.nextLine();
        Student name = studentStorage.getByEmail(studentName);
        if (name == null) {
            System.out.println("Incorrect name");
            changeStudentPhone();
        } else {
            System.out.println("Input new phone number");
            String phoneNumber = scanner.nextLine();
            name.setPhone(phoneNumber);
        }
    }
}
