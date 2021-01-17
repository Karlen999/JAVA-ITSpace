package chapter6;

public class Human {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void print(){
        System.out.println(name);
    }

    public static void main(String[] args) {
        Human human1 = new Human();
        human1.setName("Volodya");
        human1.print();
    }
}
