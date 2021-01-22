package chapter7.lambda;

public class FindMatchingAnimalsPredicate {

    private static void print(Animal animal, Predicate<Animal> trait){
        if (trait.test(animal)){
            System.out.println(animal);
        }
    }

    public static void main(String[] args) {
        print(new Animal("fish",false,true), a -> a.canHop());
        print(new Animal("kangaroo",true,false), a -> a.canSwim());
    }

}
