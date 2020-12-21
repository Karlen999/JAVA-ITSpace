package classwork.chapter6;

public class StackTest {

    public static void main(String[] args) {

        Stack stack = new Stack();

        stack.push(6);
        stack.push(8);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
