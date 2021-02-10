package advancedclassdesign.designprinciples;

public class Animal {
    private String species;
    private int age;

    public Animal(String species) {
        this.species = species;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        if (species == null || species.trim().length() == 0) {
            throw new IllegalArgumentException("Species is required");
        }
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0){
            throw new IllegalArgumentException("Age cannot be a negative number");
        }
            this.age = age;
    }

    public static void main(String[] args) {
        Animal animal = new Animal("Dog");
        animal.setAge(20);
        System.out.println(animal.age);
        System.out.println(animal.species);
    }
}
