package chapter14.iterator;

import java.util.ArrayList;

public class FuncIteratorMain {
    public static void main(String[] args) {
        ArrayList<Order> orders = new ArrayList<Order>() {
            {
                add(new Order(12, 22.1));
                add(new Order(5, 15.1));
                add(new Order(31, 240.));
                add(new Order(4, 61.5));
                add(new Order(21, 30.));
            }
        };
        System.out.println(orders);
        float bigAmount = 30;
        int percent = 5;
        orders.removeIf(o -> o.getAmount() >= bigAmount);
        orders.forEach(o -> o.setAmount(o.getAmount() * (100 - percent)/100));
        System.out.println(orders);
    }
}
