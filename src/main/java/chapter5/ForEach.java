package chapter5;

public class ForEach {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 7, 8, 9, 10};
        int sum = 0;
        for (int x : nums) {
            System.out.print(x + " ");
        }
        System.out.println();
        for (int x : nums) {
            sum += x;
            if (x == 5) break;
        }
        System.out.println(sum);
    }
}
