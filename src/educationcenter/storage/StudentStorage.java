package educationcenter.storage;

import educationcenter.model.Lesson;
import educationcenter.model.Student;

public class StudentStorage {
    private Student[] students = new Student[10];
    private int size = 0;

    public void add(Student student){
        if (size == students.length){
            extend();
        }
        students[size++] = student;
    }

    private void extend() {
        Student[] newStudent = new Student[students.length + 10];
        System.arraycopy(students,0,newStudent,0,students.length);
        students = newStudent;
    }

    public Student getByName(String name){
        for (int i = 0; i < size; i++) {
            if (students[i].getName().equals(name)) {
                return students[i];
            }
        }
        return null;
    }

    public Student getByEmail(String email){
        for (int i = 0; i < size; i++) {
            if (students[i].getEmail().equals(email)) {
                return students[i];
            }
        }
        return null;
    }

    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.println(students[i]);
        }
    }

    public void searchStudentByName(String name) {
        for (int i = 0; i < size; i++) {
            if (students[i].getName().contains(name)){
                System.out.println(students[i]);
            }
        }
    }

    public void searchStudentsByLessonName(Lesson name){
        for (int i = 0; i < size; i++) {
            if (students[i].getLesson().equals(name)){
                System.out.println(students[i]);
            }else {
                System.out.println("Student is not found");
            }
        }
    }
}
