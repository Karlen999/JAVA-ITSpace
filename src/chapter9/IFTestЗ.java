package chapter9;

public class IFTestЗ {
    public static void main(String[] args) {
        IntStack mystack;
        //создать переменную ссылки на интерфейс
        DynStack ds = new DynStack(5);
        FixedStack fx = new FixedStack(8);

        mystack = ds; // загрузить динамический стек
        // разместить числа в стеке
        for (int i = 0; i < 12; i++) {
            mystack.push(i);
        }

        mystack = fx;
        for (int i = 0; i < 8; i++) {
            mystack.push(i);
        }

        mystack = ds;
        System.out.println("Знaчeния в динамическом стеке:");
        for (int i = 0; i < 12; i++)
            System.out.println(mystack.pop());
        mystack = fx;
        System.out.println("Знaчeния в фиксированном стеке:");
        for (int i = 0; i < 8; i++)
            System.out.println(mystack.pop());
    }
}
