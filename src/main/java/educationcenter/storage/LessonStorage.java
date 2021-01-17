package educationcenter.storage;

import educationcenter.exception.DuplicateLessonException;
import educationcenter.model.Lesson;

public class LessonStorage {
    private Lesson[] lessons = new Lesson[10];
    private int size = 0;

    public void add(Lesson lesson) throws DuplicateLessonException {
        if (getByName(lesson.getLessonName())!=null){
            throw new DuplicateLessonException("Lesson with " + lesson.getLessonName() + " already exists!");
        }
        if (size == lessons.length) {
            extend();
        }
        lessons[size++] = lesson;
    }

    private void extend() {
        Lesson[] newLesson = new Lesson[lessons.length + 10];
        System.arraycopy(lessons,0,newLesson,0,lessons.length);
        lessons = newLesson;
    }

    public Lesson getByName(String name){
        for (int i = 0; i < size; i++) {
            if (lessons[i].getLessonName().equals(name)){
                return lessons[i];
            }
        }
        return null;
    }

    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.println(lessons[i]);
        }
    }
    public void printNames(){
        for (int i = 0; i < size; i++) {
            System.out.println(lessons[i].getLessonName());
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void searchLessonByName(String name){
        for (int i = 0; i < size; i++) {
            if (lessons[i].getLessonName().contains(name)){
                System.out.println(lessons[i]);
            }
        }

    }
}
