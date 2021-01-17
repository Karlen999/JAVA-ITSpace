package collections;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        set.add("Арбуз");
        set.add("Банан");
        set.add("Вишня");
        set.add("Груша");

        for (String string : set) {
            System.out.println(string);
        }
    }
}
