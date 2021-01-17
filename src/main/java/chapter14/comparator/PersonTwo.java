package chapter14.comparator;

import java.util.Comparator;

public class PersonTwo {
    private int personId;
    private String name = "";
    public PersonTwo(){    }

    public PersonTwo(int id) {
        super();
        this.personId = id;
    }

    public PersonTwo(String name) {
        this.name = name;
    }

    public static class NameComparator implements Comparator<PersonTwo>{
        @Override
        public int compare(PersonTwo o1, PersonTwo o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    public PersonTwo(int id, String name) {
        this.personId = id;
        this.name = name;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person {");
        sb.append("PersonId = ").append(personId);
        sb.append(", name ='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
