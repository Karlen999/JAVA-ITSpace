package chapter14;

import java.util.*;

public class MapMain {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("Gloria", 4);
        map.put("Jeans", 5);
        map.put("Zakarian", 4);
        System.out.println(map);
        map.put("Jeans", 4);
        System.out.println(map);

        Set<String> set = map.keySet();
        System.out.println(set);

        Collection<Integer> collection = map.values();
        Set<Integer> sets = new HashSet<>(collection);
        System.out.println(collection);
        System.out.println(sets);

        Set<Map.Entry<String, Integer>> values = map.entrySet();
        System.out.println(values);

    }
}
