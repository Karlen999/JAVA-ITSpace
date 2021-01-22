package chapter7;

public class UseStatic {
    static int a = 3;
    static int b;

    static void meth(int x) {
        System.out.println(x);
        System.out.println(a);
        System.out.println(b);
    }

    static {
        System.out.println("Статический блок инициализирован");
        b = a * 4;
    }

    public static void main(String[] args) {
        System.out.println("main method");
        meth(42);
    }
}
