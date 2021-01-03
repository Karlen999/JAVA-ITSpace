package chapter14.comparator;

import java.util.ArrayList;
import java.util.List;

public class ComparatorMain {
    public static void main(String[] args) {
        List<PersonTwo> list = new ArrayList<>();
       // ArrayList<PersonTwo> list = new ArrayList<>();
        list.add(new PersonTwo(2,"Poxos"));
        list.add(new PersonTwo(8,"Petros"));
        list.add(new PersonTwo(5,"Martiros"));
        list.add(new PersonTwo(11,"Valod"));
        System.out.println(list);
        //Collections.sort(list, new PersonNameComparator());
        //  list.sort(new PersonNameComparator());
        list.sort(new PersonTwo.NameComparator());  // From Inner Class
        System.out.println(list);
    }
}
