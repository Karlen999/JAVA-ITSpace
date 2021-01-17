package chapter14.comparator;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<PersonTwo> {

    @Override
    public int compare(PersonTwo o1, PersonTwo o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
