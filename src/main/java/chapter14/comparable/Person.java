package chapter14.comparable;

public class Person implements Comparable<Person>{
    private int personId;
    private String name = "";
    public Person(){    }

    public Person(int id) {
        super();
        this.personId = id;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(int id, String name) {
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

    @Override
    public int compareTo(Person o) {
        int result = -(personId - o.personId);
        int value = 0;
        if (result > 0){
            value = 1;
        }else if (result < 0) {
            value = -1;
        }
        return value;

        /*
        sorting by name

         return name.compareTo(o.name);
         */
    }
}
