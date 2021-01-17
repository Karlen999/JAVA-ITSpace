package chapter6;

public class Jarvis {

    public void sayHi (String ... names) {

        for (String name : names) {
            System.out.println("Добрый вечер, " + name + ", как ваши дела?");

        }
    }

    public static void main(String[] args) {
        Jarvis jarvis = new Jarvis();
        jarvis.sayHi("Tony", "Capitan America");
    }
}
