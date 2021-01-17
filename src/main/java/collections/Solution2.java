package collections;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("арбуз", "ягода");
        map.put("банан", "трава");
        map.put("вишня", "ягода");
        map.put("груша", "фрукт");

        for (Map.Entry<String, String> pair :
                map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }
}
