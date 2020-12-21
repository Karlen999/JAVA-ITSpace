package educationcenter.model;

public class Lesson {
    private String lessonName;
    private int duration;
    private int price;
    private String lecturerName;

    public Lesson(String lessonName, int duration, int price, String lecturerName) {
        this.lessonName = lessonName;
        this.duration = duration;
        this.price = price;
        this.lecturerName = lecturerName;
    }

    public Lesson() {
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + lessonName + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                ", lecturerName='" + lecturerName + '\'' +
                '}';
    }
}
