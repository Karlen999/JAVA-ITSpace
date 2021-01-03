package chapter14;

import java.util.Set;
import java.util.TreeSet;

public class ComparableMain {
    public static void main(String[] args) {
        Set<Person> set = new TreeSet<>();
        set.add(new Person(7,"Poxos"));
        set.add(new Person(11,"Petros"));
        set.add(new Person(2,"Martiros"));
        set.add(new Person(5,"Valod"));
        System.out.println(set);
    }
}
