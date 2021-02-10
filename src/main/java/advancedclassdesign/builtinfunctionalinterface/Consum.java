package advancedclassdesign.builtinfunctionalinterface;


//implementing Consumer Functional Interface

import java.util.function.Consumer;

public class Consum {
    public static void main(String[] args) {

    Consumer<String> c1 = System.out::println;
    Consumer<String> c2 = x -> System.out.println(x);

    c1.accept("Poxos");
    c2.accept("Petros");

    }
}
