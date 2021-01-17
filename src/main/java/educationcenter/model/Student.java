package educationcenter.model;

import educationcenter.model.Lesson;

public class Student {
    private String name;
    private String surname;
    private String phone;
    private String email;
    private Lesson lesson;

    public Student(String name, String surname, String phone, String email, Lesson lesson) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.lesson = lesson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", lesson=" + lesson +
                '}';
    }
}
