package chapter14.comparator;

import java.util.ArrayList;
import java.util.Comparator;

public class FuncComparatorMain {
    public static void main(String[] args) {

        ArrayList<PersonTwo> list = new ArrayList<>();
        list.add(new PersonTwo(2,"Poxos"));
        list.add(new PersonTwo(1,"Petros"));
        list.add(new PersonTwo(8,"Poxos"));
        list.add(new PersonTwo(18,"Petros"));
        list.add(new PersonTwo(5,"Poxos"));
        list.add(new PersonTwo(10,"Petros"));

        System.out.println(list);
        /*
            from lambda

        list.sort((o1, o2) -> o1.getPersonId() - o2.getPersonId());

         */
        list.sort(Comparator.comparing(PersonTwo::getName).thenComparing(PersonTwo::getPersonId));
        System.out.println(list);
    }
}
