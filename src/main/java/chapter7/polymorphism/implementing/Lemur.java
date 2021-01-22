package chapter7.polymorphism.implementing;

public class Lemur extends Primate implements HasTail{
    int age = 18;
    @Override
    public boolean isTailStriped() {
        return false;
    }

    public static void main(String[] args) {
        Lemur lemur = new Lemur();
        System.out.println(lemur.age);

        Primate primate = lemur;
        System.out.println(primate.hasHair());

        HasTail hasTail = lemur;
        System.out.println(hasTail.isTailStriped());
    }

}
