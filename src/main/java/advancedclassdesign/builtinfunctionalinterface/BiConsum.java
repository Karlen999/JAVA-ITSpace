package advancedclassdesign.builtinfunctionalinterface;


//implementing BiConsumer Functional Interface

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsum {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> b1 = map::put;
        BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);
        b1.accept("Poxos", 25);
        b2.accept("Petros", 20);
        System.out.println(map);
    }
}
