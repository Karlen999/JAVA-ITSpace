package chapter10;

public class Ехс2 {
    public static void main(String[] args) {
        int d, a;

        try {
            d = 0;
            a = 42 / d;
            System.out.println("Չի երևա");
        } catch (ArithmeticException e) {
            // բռնել 0-ի բաժանման սխալը
            System.out.println("0-ի վրա բաժանում");
        }
        System.out.println("catch օպերատորից հետո");
    }
}
